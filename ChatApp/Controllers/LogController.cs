using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System.IO;

[Authorize]
public class LogController : Controller
{
    [Authorize(Roles = "Admin")]
    public IActionResult DownloadLog()
    {
        var logPath = Path.Combine(Directory.GetCurrentDirectory(), "Logs", "UserActivityLog.txt");
        if (!System.IO.File.Exists(logPath))
        {
            return NotFound();
        }

        var bytes = System.IO.File.ReadAllBytes(logPath);
        return File(bytes, "text/plain", "UserActivityLog.txt");
    }

    [Authorize(Roles = "Admin,Developer,ProjectManager")]
    public IActionResult DownloadMessageLog()
    {
        var logPath = Path.Combine(Directory.GetCurrentDirectory(), "Logs", "MessageLog.txt");
        if (!System.IO.File.Exists(logPath))
        {
            return NotFound();
        }

        var bytes = System.IO.File.ReadAllBytes(logPath);
        return File(bytes, "text/plain", "MessageLog.txt");
    }
}
