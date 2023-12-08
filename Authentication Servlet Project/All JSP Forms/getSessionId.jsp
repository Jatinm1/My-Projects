<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.UUID" %>
<%
  // Generate a session ID (for demonstration, generating a random UUID)
  String sessionId = UUID.randomUUID().toString();
  session.setAttribute("sessionId", sessionId);

  // Return the session ID as a response to the client
  out.print(sessionId);
%>
