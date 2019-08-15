<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Orders</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/order.css" />
<!-- Include jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>

<style>
.overlay {
	height: 100%;
	width: 100%;
	background-color: green;
	z-index: 10;
}
</style>


</head>
<body>


	<input type="button" id="showmodal" name="showmodal"
		value="Add Custom Order" />

	<!-- Start Modal For Sign-up Form -->
	<div class="overlay" id="order" style="padding: 20px;">


	<br/>
	<br/>
		
		Name: <input type="text" list="medicine" name="name" id="name" />
        <datalist id="medicine">
            
        </datalist>
        Stock: <span id="stock"></span><br />
        Formula: <span id="formula"></span>
		Quantity: <input type="text" name="quantity" id="quantity" /> 
		<input type="button" name="add" id="add" value="Add Medicine" /><br /> <br />


		<table id="order_table" style="width: 100%;">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Formula</th>
					<th>Type</th>
					<th>Dose</th>
					<th>Quantity</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody id="body_ordertable" style="text-align: center;">
			
			

			</tbody>
		
		</table>

		<br/>
		<input type="button" name="submit" value="Save Order" id="saveOrder" />





	</div>
	<!-- End Modal For Sign-up Form -->

	<script>
	
	$(document).ready(function(){
		
		$("#name").keyup(function(event){
			
			if((event.keyCode < 91) && (event.keyCode > 64)){
				
				var value = new Object();
				value.search = $("#name").val();
				
				var data = JSON.stringify(value);
			
			
			$.ajax({
				type:"post",
				url:"KeyUpOptionServlet",
				contentType:"json",
				data:data,
				dataType:"json",
				success:function(result){
					
					var option = "";
					$("#medicine").html(option);
					for(var i = 0; i < result.length; i++ ){
						option += "<option value='"+result[i].name+"-"+result[i].dose+"' />";
					}
					
					$("#medicine").append(option);
					
				},
				error: function(){
					alert("Error fetching medicine options!");
				}
				
			})
			
			}
		});// end keyup function
		
		
		$("#name").blur(function(){
		    
			var x = $(this).val();
			if(x.trim() === ""){
				return;
			}
			
			var value = x.split("-");
			
			var object = new Object();
			object.name = value[0];
			object.dose = value[1];
			
			var data = JSON.stringify(object);
			
			$.ajax({
				
				type:"post",
				url:"OptionDetailServlet",
				contentType:"json",
				data:data,
				dataType:"json",
				success:function(result){
					
					$("#stock").html(result.stock);
					$("#formula").html(result.formula);
					
				},
				error: function(){
					alert("Error!!! Fetching price and formula");
				}
			
			});
		});// end unfocusing function
		
		
		
		$("#add").click(function(){
			
			var stock = $("#stock").text();
			var formula = $("#formula").text();
			var quantity = $("#quantity").val();
			var value = $("#name").val();
			
			var array = value.split("-");
			var name = array[0];
			var dose = array[1];
			
			var object = new Object();
			
			object.name = name;
			object.dose = dose;
			object.stock = stock;
			object.formula = formula;
			
			var data = JSON.stringify(object);
			
			$.ajax({
				type:"post",
				url:"AddOrderRowServlet",
				contentType:"json",
				data:data,
				dataType:"json",
				success:function(result){

					var total = 0;
					var rows = "<tr>"
							+"<td>"+result.id+"</td>"
							+"<td>"+result.name+"</td>"
							+"<td>"+result.formula+"</td>"
							+"<td>"+result.type+"</td>"
							+"<td>"+result.dose+"</td>"
							+"<td>"+quantity+"</td>"
							+"<td>remove</td>"
							+"</tr>";
					
					$("#body_ordertable").append(rows);
					
	
				},
				error: function(){
					alert("Error!!! Cannot get the row information");
				}
			
			});
		});// end add function
		
		
		
		$("#saveOrder").click(function(){
			
			alert("Save btn clicked");
			
			var order_id;
		
			$.ajax({
				
				type:"POST",
				url:"OrderServlet",
				dataType:"json",
				success:function(result){
					
					order_id = Number(result.orderId);
					
					alert("Order id is: " + order_id);
					
					var array = [];
					
					$("#body_ordertable tr").each(function(){
						
						var self = $(this);
				        var id = self.find('td:eq(0)').text().trim();
				        id= Number(id);
				        var name = self.find('td:eq(1)').text().trim();
				        var formula = self.find('td:eq(2)').text().trim();
				        var type = self.find('td:eq(3)').text().trim();
				        var dose = self.find('td:eq(4)').text().trim();
				        var quantity = self.find('td:eq(5)').text().trim();
				        quantity = Number(quantity);
				        
				        var object = {};
				        
				        object.id = id;
				        object.quantity = quantity;
				        object.order_id = order_id;
						
				        array.push(object);
				        
				        
					});
					
					
					alert("Good Luck");
					
					var data = JSON.stringify(array);
					
					$.ajax({
						
						type:"POST",
						url:"OrderItemServlet",
						dataType:'json',
						data:data,
						contentType:'json',
						mimeType:'application/json',
						success:function(result){
							
							if(result){
								alert("Data has been added into order and item.");
							}
							
						},
						error: function(){
							alert("Error!!! Fetching price and formula");
						}
					
					});
				}
				
			});
			
			
		}); // end saving order
		
		
		
		
		
		
	});
	
	

	
	
	
	
		
	</script>



</body>
</html>