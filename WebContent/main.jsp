<!DOCTYPE html>
<html lang="en">
<head>
<title>Main Page</title>

<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap/js/bootstrap.min.js" />
<!-- Include jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body style="margin: 0px; padding: 0px;">

	<div id="header"></div>
	<div id="nav"></div>

	<script>
		$(function() {
			$("#header").load("header.jsp");
		});
		$(function() {
			$("#nav").load("navigation.jsp");
		});
	</script>

</body>