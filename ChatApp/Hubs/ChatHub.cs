using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.SignalR;
using System;
using System.Collections.Concurrent;
using System.IO;
using System.Threading.Tasks;
using CompleteChatApp.Models;
using ChatApp.Areas.Identity.Data;

namespace CompleteChatApp.Hubs
{
    public class ChatHub : Hub
    {
        private static readonly ConcurrentDictionary<string, string> _userConnections = new ConcurrentDictionary<string, string>();
        private readonly ApplicationDbContext _dbContext;

        public ChatHub(ApplicationDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        [Authorize]
        public async Task SendMessage(string user, string message)
        {
            var sender = Context.User.Identity.Name;
            var timestamp = DateTime.Now;

            var newMessage = new Message
            {
                Sender = sender,
                Receiver = "All", // Set receiver to "All"
                Content = message,
                Timestamp = timestamp
            };

            _dbContext.Messages.Add(newMessage);
            await _dbContext.SaveChangesAsync();

            // Send message to all clients, including the sender
            await Clients.All.SendAsync("ReceiveMessage", sender, "All", message, timestamp);

            // Send message to the sender's client for updating sent messages
            if (_userConnections.TryGetValue(sender, out var senderConnectionId))
            {
                await Clients.Client(senderConnectionId).SendAsync("SentMessage", sender, "All", message, timestamp);
            }

            // Log the message
            LogMessage(sender, "All", message, timestamp);
        }

        [Authorize]
        public async Task SendToUser(string receiver, string message)
        {
            var sender = Context.User.Identity.Name;
            var timestamp = DateTime.Now;

            var newMessage = new Message
            {
                Sender = sender,
                Receiver = receiver,
                Content = message,
                Timestamp = timestamp
            };

            _dbContext.Messages.Add(newMessage);
            await _dbContext.SaveChangesAsync();

            if (_userConnections.TryGetValue(receiver, out var connectionId))
            {
                await Clients.Client(connectionId).SendAsync("ReceiveMessage", sender, receiver, message, timestamp);
            }

            if (_userConnections.TryGetValue(sender, out var senderConnectionId))
            {
                await Clients.Client(senderConnectionId).SendAsync("SentMessage", sender, receiver, message, timestamp);
            }

            // Log the message
            LogMessage(sender, receiver, message, timestamp);
        }

        public override async Task OnConnectedAsync()
        {
            var user = Context.User.Identity.Name;
            if (user != null)
            {
                _userConnections[user] = Context.ConnectionId;
            }
            await base.OnConnectedAsync();
        }

        public override async Task OnDisconnectedAsync(System.Exception exception)
        {
            var user = Context.User.Identity.Name;
            if (user != null)
            {
                _userConnections.TryRemove(user, out _);
            }
            await base.OnDisconnectedAsync(exception);
        }

        private void LogMessage(string sender, string receiver, string message, DateTime timestamp)
        {
            var logPath = Path.Combine(Directory.GetCurrentDirectory(), "Logs", "MessageLog.txt");
            Directory.CreateDirectory(Path.GetDirectoryName(logPath));

            using (var writer = new StreamWriter(logPath, true))
            {
                writer.WriteLine($"{timestamp}: {sender} to {receiver} - {message}");
            }
        }

        public string GetConnectionId() => Context.ConnectionId;
    }
}
