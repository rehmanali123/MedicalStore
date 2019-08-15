<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Adding Medicine</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/billing.css" />
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

<div id="transaction_form" style="float: right; width: 80%;">

            <h3 style="text-align: center; margin-bottom: 20px;">Transaction Page</h3>

			Customer Id: <input type="text" name="custId" id="custId" />
			Transaction Id: <span>________________</span>
			
			<br/>
			<br/>

            Name: <input type="text" list="medicine" name="name" id="name" />
            <datalist id="medicine">
            
            </datalist>
            
            Formula: <span id="formula">__________________</span>
            Price: <span id="mrp">______________</span>
        </br>
            Quantity: <input type="text" name="quantity" id="quantity" /><br/>
            Batch: <input type="text" name="batch" id="batch" />
            <input type="button" value="add" id="add" name="add"/>

            <table id="transaction_table" style="width: 100%; ">
    			<thead>
    				<tr>
	    				<th>Id</th>
	    				<th>Name</th>
	    				<th>Formula</th>
	    				<th>Type</th>
	    				<th>Dose</th>
	    				<th>Batch</th>
	    				<th>Qty.</th>
	    				<th>R. Price</th>
	    				<th>Total Price</th>
    				</tr>
    			</thead>
    			<tbody id="body_tbltransaction">
    				
    			</tbody>
    		</table>
    		
    		
    		Total: <span id="total">-----------</span><br/>
    		Discount (Rs/-): <input type="text" name="discount" id="discount" /><br/>
    		G. Total: <span id="grandtotal">---------</span> /-
    		
    		<input type="button" value="Save Records" id="savebtn" name="savebtn"/>
    		
    		
    		
    		

        </div>

<script>



</script>









<script src="js/billing.js"></script>






</body>
</html>
