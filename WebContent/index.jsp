<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.medbay.medicine.Medicine"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Medicine</title>
</head>
<body>

	This button is going to show a table
	<br />
	<a href="Demo"><button onclick="showTable()">Show Data</button></a>

	<% String user = (String) request.getAttribute("answer"); %>

	
	<br /> This is great isn't it.



	<script>
	
		function showTable() {
			document.getElementById("table1").style.display = 'block';
		}
		
	</script>



</body>
</html>