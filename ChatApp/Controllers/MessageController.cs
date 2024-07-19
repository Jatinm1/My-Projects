using ChatApp.Areas.Identity.Data;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

[Route("api/[controller]")]
[ApiController]
public class MessagesController : ControllerBase
{
    private readonly ApplicationDbContext _context;
    private readonly UserManager<IdentityUser> _userManager;

    public MessagesController(ApplicationDbContext context, UserManager<IdentityUser> userManager)
    {
        _context = context;
        _userManager = userManager;
    }

    // Fetch all messages
    [HttpGet]
    public async Task<IActionResult> GetMessages()
    {
        var currentUser = await _userManager.GetUserAsync(User);
        var messages = await _context.Messages
            .Where(m => m.Receiver == currentUser.UserName || m.Receiver == "All" || m.Sender == currentUser.UserName)
            .ToListAsync();
        return Ok(messages);
    }

    // Fetch frequent users
    [HttpGet("frequentUsers")]
    public async Task<IActionResult> GetFrequentUsers()
    {
        var currentUser = await _userManager.GetUserAsync(User);
        var now = DateTime.UtcNow;
        var fortyEightHoursAgo = now.AddHours(-48);

        var frequentUsers = await _context.Messages
            .Where(m => (m.Sender == currentUser.UserName || m.Receiver == currentUser.UserName) && m.Timestamp >= fortyEightHoursAgo)
            .GroupBy(m => m.Sender == currentUser.UserName ? m.Receiver : m.Sender)
            .OrderByDescending(g => g.Count())
            .Take(4)
            .Select(g => new { UserName = g.Key })
            .ToListAsync();

        return Ok(frequentUsers);
    }
}
