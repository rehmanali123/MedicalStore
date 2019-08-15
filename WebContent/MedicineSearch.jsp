<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.medbay.medicine.Medicine"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Medicine Search</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  -->

<link rel="stylesheet" href="css/medsearch.css" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap/js/bootstrap.min.js" /> 
Include jQuery
<script type="text/javascript" src="js/jquery.js"></script> 



</head>
<body>

		<p>Search for the medicine</p>
		
		<form>

			<div class="row form-group">

				<div class="col-md-2">
					<label style="font-size: 16px; margin-top: 3px;"> Search By
					</label>
				</div>
				<div class="col-md-2">
					<select class="form-control" id="searchBy"
						style="border-radius: 1px;">
						<option>Name</option>
						<option>Formula</option>
						<option>Distributor</option>
						<option>Supplier</option>
						<option>Date</option>
					</select>
				</div>
				<div class="col-md-6">
					<input type="text" placeholder="search" id="keyword"
						class="form-control" style="border-radius: 1px;">
				</div>
				<div class="col-md-1">
					<button class="btn btn-primary" id="submit">Search</button>
				</div>

			</div>

			<table>
				<thead>
					<tr>
						<td>Medicine Name</td>
						<td>Type</td>
						<td>Dose</td>
						<td>Formula</td>
					</tr>
				</thead>
				<tbody id="resultBody">

				</tbody>
			</table>

		</form>
	
	<button id="btn" value="open" >Open Modal</button>

        <div class="overlay">
          <div class="cmodal" id="cmodal">
            <!-- close trigger -->
            <div id="title">
                <span>Login</span>
                <span style="float:right; margin-right: 15px;" class="close">&times;</span>
            </div>

            <!-- modal content -->
            <div class="modal-content" style="text-align:center;">

            <p> Enter New Medicine: ( Administrator previliges required ) </p>


        <hr/>
        <div class="row form-group ">


            <div class="col-md-2">
                <label for="name" class="w-25 mb-2 mr-sm-2">Medicine Name</label>
            </div>
            <div class="col-md-3">
                <input type="text" class="form-control mb-2 mr-sm-2 user" placeholder="paracetamol" id="name" name="name" focus>
            </div>
            <div class="col-md-1" style="width: 65px; padding-left:2px; ">
                <label for="name" class="w-25 mb-2 mr-sm-2" >Dose</label>
            </div>
            <div class="col-md-1" style="width: 100px; padding-left: 2px;">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="dose" name="dose" placeholder="" >
            </div>

            <div class="col-md-1" style="width: 40px; padding-left: 2px;">
                <label for="name" class="w-25 mb-2 mr-sm-2">Type</label>
            </div>
            <div class="col-md-1" style="width: 115px; padding-left:0px; ">
                <select class="form-control" id="type" name="type" style="border-radius:1px; border: 1px solid gray;">
                    <option>Tablet</option>
                    <option>Syrup</option>
                    <option>Capsule</option>
                    <option>Injection</option>
                    <option>Drops</option>
                </select>
            </div>
            <div class="col-md-1">
                <label for="name" class="w-25 mb-2 mr-sm-2">Batch No.</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="batch" name="batch" placeholder="" >
            </div>

        </div>
        <div class="row form-group">

            <div class="col-md-2">
                <label for="name" class="w-25">Formula</label>
            </div>
            <div class="col-md-6">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="formula" name="formula" placeholder="formula" >
            </div>
            <div class="col-md-1">
                <label for="name" class="w-25">Distributor</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="distributor" name="distributor" placeholder="" >
            </div>
        </div>

        <hr/>

        <div class="row form-group">
            <div class="col-md-2">
                <label for="name" class="w-25">Whole Cost Per Box </label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="boxcost" name="costPerBox" placeholder="cost in PKR" >
            </div>
            <div class="col-md-2">
                <label for="name" class="w-25">Whole Sale Price Per Box</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="boxsale" name="salePerBox" placeholder="sale in PKR" >
            </div>
            <div class="col-md-1">
                <label for="name" class="w-25">Number of Boxes</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="noOfBox" name="noOfBoxes"  placeholder="" >
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-2">
                <label for="name" class="w-25">Retail Cost Price </label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="retailcost" name="retailCost" placeholder="cost in PKR" >
            </div>
            <div class="col-md-2">
                <label for="name" class="w-25">Retail Sale Price</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="retailsale" name="retailSale" placeholder="sale in PKR" >
            </div>
            <div class="col-md-1">
                <label for="name" class="w-25">Quantity</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="quantity" name="quantity"  placeholder="" >
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-2">
                <label for="name" class="w-25">Mfg. Date</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="date1" name="mfg" placeholder="MM/DD/YYYY" >
            </div>
            <div class="col-md-2">
                <label for="name" class="w-25">Exp. Date</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="date2" name="exp" placeholder="MM/DD/YYYY" >
            </div>
        </div>

    <hr/>

        <div class="row form-group">
            <div class="col-md-2">
                <label for="name" class="w-25">No. Of Pills Per Box</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="pills" name="pillsPerBox" placeholder="no. of pills" >
            </div>
            <div class="col-md-2">
                <label for="name" class="w-25">Critical Amount</label>
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control mb-2 mr-sm-2 user" id="critical" name="criticalAmount" placeholder="critical amount" >
            </div>
        </div>

        <div class="row form-group">
            <div class="col-md-2">
                <label for="name" class="w-25">Supplier/Guaranteer</label>
            </div>
            <div class="col-md-6">
                <select class="form-control" id="supplier" name="supplier" style="border-radius:1px; border: 1px solid gray;">
                    <option>Sarwar</option>
                    <option>Ahmad</option>
                    <option>Kaleem</option>
                    <option>Haris</option>
                </select>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-2">

            </div>
            <div class="col-md-3">

            </div>
            <div class="col-md-3">
                <button class="btn btn-primary" id="submit">Add Medicine</button>
            </div>
        </div>


    </div>

            <p style="text-align:right; margin-right: 180px;">
                <a href="#">Forgot Password ?</a><input type="button" name="submit" id="submit" value="Login"/>
            </p>

            </div>
          </div>
        </div>

	<script>
	
	
	// Edit Modal 
	
		var $showmodal = $("#btn");
var $overlay = $(".overlay");
var $modal = $(".cmodal");
var $close = $(".close");

var login = new Object();
login.username = "Junaid";
login.password = "784692";

$(document).ready(function(e){

    $overlay.hide();

});

$showmodal.on('click',function(e){
    e.preventDefault();

    var windowheight = $(window).height();
    var windowwidth = $(window).width();
    var modalwidth = windowwidth/1.25;

    $overlay.show();
    $modal.css({
        'width':modalwidth,
        'margin-left':-modalwidth/2
        
    });
    addData(login);
});

$overlay.on('click',function(e){
    if(e.target !== this){
        return;
    }
    $overlay.hide();
});

$close.on('click',function(e){
    $overlay.hide();
});







function addData(data){
    $("#username").val(data.username);
    $("#password").val(data.password);
}



	
	
	// End Edit Modal
	
				$("#submit").click(function() {

					var search = new Object();
					search.name = $("#searchBy").val();
					search.keyword = $("#keyword").val();

					alert(search);

					
					var data = JSON.stringify(search);
					var x;
					$.ajax({
						type : 'post',
						url : 'MedicineSearch',
						contentType : 'application/json',
						data:data,
						dataType : 'json',
						success : function(result) {
							var res = JSON.parse(JSON
									.stringify(result));
							
							alert("Message is success " + result);
							alert(res);
							
							x = "<tr><td>"+ res[0].name +"</td><td>"+ res[0].type +"</td><td>"+ res[0].dose +"</td><td>"+ res[0].formula +"</td></tr>";
							$("#resultBody").html(x);
							
						},
						error : function(result) {
							alert("Error occurred: " + result);
						}

					});

				});
	
	
	
	
	
		
		
		

		
		
		
	</script>



</body>
</html>
