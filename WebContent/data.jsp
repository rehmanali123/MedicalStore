
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*,java.sql.*,java.io.*"%>

<%
	String name = "";
	String q = request.getParameter("q");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalstore", "root",
				"root");
		Statement smt = con.createStatement(); //Create Statement to interact
		ResultSet r = smt.executeQuery("select * from employees where( firstname = '" + q + "');");
		while (r.next()) {
			name = r.getString("firstname");
		}
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

Name:<%out.print(name);%>
