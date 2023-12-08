package com.theandroguide.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Cache-Control", "no-store"); // HTTP 1.1
		response.setHeader("Cache-Control", "must-revalidate"); // HTTP 1.1
		response.setHeader("Expires", "0"); // Proxies
		response.setDateHeader("Expires", -1);
		
		HttpSession session = request.getSession(false);
		System.out.println(session.getId());
		if (session != null) {
		    session.invalidate();
		    response.sendRedirect("login.jsp");
		}
		

	}
}
