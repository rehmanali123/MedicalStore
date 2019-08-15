<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Stock</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/stock.css" />
<!-- Include jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>

<script>
	$(function() {
		$("#head").load("header.jsp");
	});
	$(function() {
		$("#nav").load("navigation.jsp");
	});
</script>

</head>
<body>

	<div id="head"></div>
	<div id="nav" style="float: left; width: 20%;"></div>

	<div id="notification" style="flaot: right; width: 80%;">
		</h4>Notifications of medicine</h4>
	</div>
	
	
</body>
</html>