#nullable disable

using System;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Logging;

namespace CompleteChatApp.Areas.Identity.Pages.Account
{
    public class LogoutModel : PageModel
    {
        private readonly SignInManager<IdentityUser> _signInManager;
        private readonly ILogger<LogoutModel> _logger;

        public LogoutModel(SignInManager<IdentityUser> signInManager, ILogger<LogoutModel> logger)
        {
            _signInManager = signInManager;
            _logger = logger;
        }

        public async Task<IActionResult> OnPost(string returnUrl = null)
        {
            var userName = User.Identity.Name;

            await _signInManager.SignOutAsync();
            _logger.LogInformation("User logged out.");
            LogActivity(userName, "Logout");

            // Redirect to the login page after logging out
            return RedirectToPage("/Account/Login");
        }

        private void LogActivity(string userName, string activity)
        {
            var logPath = Path.Combine(Directory.GetCurrentDirectory(), "Logs", "UserActivityLog.txt");
            Directory.CreateDirectory(Path.GetDirectoryName(logPath));

            using (var writer = new StreamWriter(logPath, true))
            {
                writer.WriteLine($"{DateTime.Now}: {userName} - {activity}");
            }
        }
    }
}
