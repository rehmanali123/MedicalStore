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

	<div id="stockinfo" style="flaot: right; width: 80%;">
		
	
	<h4>General Stock Information</h4>
		Total Number of medicines: <span id="total">_______________</span><br/>
		Low Stock: <span id="low">_______________</span> medicines<br/>
		Out of Stock: <span id="out">_______________</span> medicines<br/>
		Expired: <span id="expired">_____________</span>
		
	
	</div>
	
	<script>
	
	$(document).ready(function(){
		
		alert("sending");
		$.ajax({
			type:"POST",
			url:"StockServlet",
			dataType:"json",
			success:function(result){
				
				alert("Got the stock information");
				var total = result.total;
				var low = result.low;
				var out = result.out;
				var expired = result.expired;
				
				$("#total").html(total);
				$("#low").html(low);
				$("#out").html(out);
				$("#expired").html(expired);
				
				
				
			},
			error:function(){
				alert("Error getting stock information");
			}
		});
		
		
	});
	
	</script>
	
	
	
</body>
</html>