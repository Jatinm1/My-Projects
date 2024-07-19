using System;

namespace CompleteChatApp.Models
{
    public class UserActivity
    {
        public int Id { get; set; }
        public string UserName { get; set; }
        public string ActivityType { get; set; } // "Login" or "Logout"
        public DateTime Timestamp { get; set; }
    }
}
