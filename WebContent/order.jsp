<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Orders</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/order.css" />
<link rel="stylesheet" href="css/modal.css" />
<!-- Include jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/modal.js"></script>

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

	<div id="orderinfo" style="flaot: right; width: 80%;">
		<h3>General Order Information</h3>
		
		<input type="button" id="showmodal" name="showmodal" value="Add Custom Order" />
		
		
		
		
	
	</div>
	
	
	<!-- Start Modal For Sign-up Form -->
	<div class="overlay" id="orderovarlay">
          <div class="modal" id="ordermodal">
            <!-- close trigger -->
            <div id="title">
                <span>Order Information</span>
                <span style="float:right; margin-right: 15px;" class="close">&times;</span>
            </div>

            <!-- modal content -->
            <div class="modal-content" style="text-align:center;">
			
			
			

            </div>
          </div>
    </div>
	<!-- End Modal For Sign-up Form -->
	
	<script>
	
	
	
	
	
	
	</script>
	
	
	
</body>
</html>