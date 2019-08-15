<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Adding Medicine</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/newmed.css" />
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

	<div id="container" style=" float: right; width: 80%; ">

		<form style="padding: 30px;">
			<fieldset>

				<legend>Medicine Information</legend>

				<br />
					Name: <input type="text" name="medname" id="name" class="character" required />
			        Formula: <input type="text" name="Formula" id="formula" class="character" required  />
			        Type: <select class="character" id="type" required>
			                <option>Tablet</option>
			                <option>Syrup</option>
			                <option>Capsule</option>
			                <option>Injection</option>
			                <option>Cream</option>
			            	</select>
			        Dose: <input type="text" name="dose" id="dose" class="number" required /><br /><br />
			        Rack No: <input type="number" name="rack" id="rack" class="number" min="0" required /> 
			 		Critical Qty: <input type="number" name="critical" id="critical" class="number" min="0" required /> <br />
        <br />

			</fieldset>
			<br />
			<fieldset>

				<legend>Batch Information</legend>

				<br /> 
				Batch No.: <input type="text" id="batch" class="number" min="0" required />
				Mfg. Date: <input type="text" id="mfg" class="number" placeholder="dd/mm/yyyy" required/> 
				Exp. Date: <input type="text" id="exp" class="number" placeholder="dd/mm/yyyy" required/><br/><br/> 
				No. of packs: <input type="number" id="packs" class="number" min="0" step="any" required /> 
				Pack Strength: <input type="number" id="strength" class="number" min="0" required />
				<br/><br/> 
				Distributor: <input type="text" id="dtr" class="character" required /> 
				Dealer: <input type="text" id="dlr" class="character" required /> 

				<br />

			</fieldset>
			<br />
			<fieldset>

				<legend>Price Information</legend>

				<br /> 
				Cost Price: <input type="number" name="batch" id="cost" class="number" min="0" step="any" required />
				MRP: <input type="number" name="Formula" id="mrp" class="number" min="0" step="any" required /><br /> <br />
				<br/>
				<input type=button value="Submit" name="submit" id="submit" />
				
			</fieldset>

		</form>


	</div>
	<div class="clear"></div>

	<script type="text/javascript" src="js/jquery.js"></script>

	<!-- Include Date Range Picker -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />


	<script>
		$(document).ready(function() {
			var date_input = $('input[name="mfg"]'); //our date input has the name "date"
			date_input.datepicker({
				format : 'dd/mm/yy',
				todayHighlight : true,
				autoclose : true,
			})
		});

		$(document).ready(function() {
			var date_input = $('input[name="exp"]'); //our date input has the name "date"
			date_input.datepicker({
				format : 'dd/mm/yy',
				todayHighlight : true,
				autoclose : true,
			})
		});

		$(document).ready(function() {
			
			$("#submit").click(function() {
				
				alert("submit button clicked");
				
				if($("#name").val() == ""){
					alert("Fill all the fields.");
					return;
				}else if($("#formula").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#type").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#dose").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#rack").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#critical").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#batch").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#dtr").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#qty").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#dlr").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#strength").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#cost").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#mrp").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#mfg").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#exp").val() == "") {
					alert("Fill all the fields.");
					return;
				}else if($("#packs").val() == "") {
					alert("Fill all the fields.");
					return;
				}
				
				
				

				// turn into json object later
				var medicine = new Object();
				medicine.name = $("#name").val();
				medicine.dose = $("#dose").val();
				medicine.type = $("#type").val();
				
				medicine.formula = $("#formula").val();
				medicine.batch = $("#batch").val();
				medicine.rack = $("#rack").val();
				medicine.distributor = $("#dtr").val();
				medicine.packs = $("#packs").val();
				medicine.strength = $("#strength").val();
				medicine.mfg = $("#mfg").val();
				medicine.exp = $("#exp").val();
				medicine.critical= $("#critical").val();
				medicine.dealer = $("#dlr").val();
				medicine.cost = $("#cost").val();
				medicine.mrp = $("#mrp").val();

				var data = JSON.stringify(medicine);
				
				alert("Sending data");
				$.ajax({
					
					type : 'POST',
					url : "NewMedicineServlet",
					dataType : 'text',
					data : data,
					contentType : 'application/json',
					mimeType : 'application/json',
					success : function(result) {

						alert("Got the message: " + result);
						result = false;
						if(result){
							
							$("#name").val("");
							$("#formula").val("");
							$("#type").val("");
							$("#dose").val("");
							$("#rack").val("");
							$("#critical").val("");
							$("#batch").val("");
							$("#mfg").val("");
							$("#exp").val("");
							$("#qty").val("");
							$("#strength").val("");
							$("#dtr").val("");
							$("#dlr").val("");
							$("#cost").val("");
							$("#mrp").val("");
							
						}

					}// success 
				});// ajax
			});// submit
		}); // document
		
		
		
		
	</script>


</body>
</html>
