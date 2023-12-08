package com.theandroguide.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // Proxies
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String Reupwd = request.getParameter("re_pass");
		String umob = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		if(uname== null || uname.equals("")) {
			request.setAttribute("status","invalidName");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		if(uemail == null || uemail.equals("")) {
			request.setAttribute("status","invalidEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		if(upwd == null || upwd.equals("")) {
			request.setAttribute("status","invalidUpwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(Reupwd == null || Reupwd.equals("")) {
			request.setAttribute("status","invalidReUpwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		else if(!Reupwd.equals(upwd)) {
			request.setAttribute("status","RepassNotSame");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
			
		}
		
		if(umob == null || umob.equals("")) {
			request.setAttribute("status","invalidUmob");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		else if (umob.length() > 10 ){
			request.setAttribute("status","invalidUmobLength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);	
		}
		else if (umob.length() < 10 ){
			request.setAttribute("status","invalidUmobLength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);	
		}
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false","Username", "password");
			PreparedStatement pst = con.prepareStatement("insert into users(uname,uemail,upwd,umob) values(?,?,?,?)");
			
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upwd);
			pst.setString(4, umob);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount > 0) {
				request.setAttribute("status", "success");
				
			}
			else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		}
		catch(java.sql.SQLIntegrityConstraintViolationException nullex) {
			request.setAttribute("status", "sameUser");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
