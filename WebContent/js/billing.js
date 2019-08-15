

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
	});
	
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
				alert(result.rack);
				
				$("#formula").html(result.formula);
				$("#mrp").html(result.mrp);
			},
			error: function(){
				alert("Error!!! Fetching price and formula");
			}
		
		});
	});
	
	

	$("#add").click(function(){
		
		var mrp = $("#mrp").text();
		var formula = $("#formula").text();
		var quantity = $("#quantity").val();
		var value = $("#name").val();
		var batch = $("#batch").val();
		
		var array = value.split("-");
		var name = array[0];
		var dose = array[1];
		
		var totalPrice = mrp * quantity;
		
		var object = new Object();
		
		object.name = name;
		object.dose = dose;
		object.mrp = mrp;
		object.formula = formula;
		
		
		var data = JSON.stringify(object);
		
		$.ajax({
			type:"post",
			url:"AddMedicineRowServlet",
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
						+"<td>"+54658+"</td>"
						+"<td>"+quantity+"</td>"
						+"<td>"+result.mrp+"</td>"
						+"<td>"+(result.mrp * quantity).toFixed(2)+ "</td>"
						+"</tr>";
				
				$("#body_tbltransaction").append(rows);
				
				var total = 0;
				
				$("#body_tbltransaction tr").each(function(){
			        var currentRow=$(this);
			    
			        var col1_value=currentRow.find("td:eq(8)").text();
			      
			        total += Number(col1_value);
			        	
			
			   });
				
					total = total.toFixed(2);
					$("#total").html(total);
				
			},
			error: function(){
				alert("Error!!! Cannot get the row information");
			}
		
		});
	});
	
	
	$("#discount").keyup(function(){
		
	
		
		var discount = $("#discount").val();
		discount = Number(discount);
		
		var t = $("#total").html();
		
		t = Number(t);
		
		var gtot = t - discount;
		gtot = gtot.toFixed(2);
		
		$("#grandtotal").html(gtot);
		
		
	});
	
	$("#savebtn").click(function(){
		
		alert("Save btn clicked");
		
		var trans_id;
		
		// saving the transaction or billing
		var total = $("#total").html();
		total = Number(total);
		var discount = $("#discount").val();
		var grandtotal = $("#grandtotal").html();
		grandtotal = Number(grandtotal);
		
		var obj = {};
		
		obj.total = total;
		obj.discount = discount;
		obj.grandtotal = grandtotal;
		
		var bill = JSON.stringify(obj);
		
		$.ajax({
			
			type:"POST",
			url:"BillingServlet",
			dataType:"json",
			data:bill,
			contentType:"json",
			success:function(result){
				
				
				trans_id = Number(result.id);
				
				alert(trans_id);
				
				var array = [];
				
				$("#body_tbltransaction tr").each(function(){
					
					var self = $(this);
			        var id = self.find('td:eq(0)').text().trim();
			        id= Number(id);
			        var name = self.find('td:eq(1)').text().trim();
			        var formula = self.find('td:eq(2)').text().trim();
			        var type = self.find('td:eq(3)').text().trim();
			        var dose = self.find('td:eq(4)').text().trim();
			        var batch = self.find('td:eq(5)').text().trim();
			        var quantity = self.find('td:eq(6)').text().trim();
			        quantity = Number(quantity);
			        var mrp = self.find('td:eq(7)').text().trim();
			        mrp = Number(mrp);
			        var total = self.find('td:eq(8)').text().trim();
			        total = Number(total);
			        
			        var object = {};
			        
			        object.id = id;
			        object.name = name;
			        object.formula = formula;
			        object.type = type;
			        object.dose = dose;
			        object.batch = batch;
			        object.mrp = mrp;
			        object.quantity = quantity;
			        object.total = total;
			        object.trans_id = trans_id;
					
			        array.push(object);
			        
			        
				});
				
				
				alert("Good Luck");
				
				var data = JSON.stringify(array);
				
				$.ajax({
					
					type:"POST",
					url:"SaveTransactionServlet",
					dataType:'json',
					data:data,
					contentType:'json',
					mimeType:'application/json',
					success:function(result){
						
						if(result){
							alert("Data has been added into billing and item.");
						}
						
					},
					error: function(){
						alert("Error!!! Fetching price and formula");
					}
				
				});
			}
			
		});
		
		
	});
	
	
	
	
});

