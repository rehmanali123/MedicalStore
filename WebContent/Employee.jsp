<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>

<script src="js/jquery.js"></script>

</head>
<body>

	<h2>Adding New Employee</h2>
	<h3>Administrator priviliges required</h3>

		FirstName: <input type="text" name="firstname" id="fname" required /><br />
		LastName: <input type="text" name="lastname" id="lname" required /><br />
		
		Username: <input type="text" name="username" id="username" required /><br />
		Email: <input type="email" name="email" id="email" /><br />
		Password: <input type="password" name="password" id="password" required /><br />
		Designation: <input type="text" name="designation" id="designation" required /><br />
		DOB: <input type="text" name="dob" id="dob" /><br />
		CNIC: <input type="text" name="cnic" id="cnic" /><br />
		Gender: <input type="radio" id="male" name="gender" value="male" checked />Male
			 	<input type="radio" id="female" name="gender" value="female" />Female<br /> 
		
		Address: <input type="text" name="address" id="address" /><br />
		Cell-phone: <input type="text" name="cellPhone" id="cellPhone" /><br />
		Landline: <input type="text" name="landLine" id="landLine" /><br />
		
		<button id="submit" name="submit">Submit</button>
		<br />


		<script>
		
		
		 $(document).ready(function(){
			 alert("document ready");
			 $("#submit").click(function(){
				 alert("submit button clicked");
				 
				// turn into json object later
				var employee = new Object();
				employee.firstname = $("#fname").val();
				employee.lastname = $("#lname").val();
				employee.dob = $("#dob").val();
				employee.username = $("#username").val();
				employee.password = $("#password").val();
				employee.email = $("#email").val();
				employee.cnic = $("#cnic").val();
				employee.gender = $("input[name=gender]:checked").val();
				employee.designation = $("#designation").val();
				employee.address = $("#address").val();
				employee.cellPhone = $("#cellPhone").val();
				employee.landLine = $("#landLine").val();
				
				
				var data = JSON.stringify(employee);
				
				$.ajax({
					url: "EmployeeServlet",
			        type: 'POST',
			        dataType: 'json',
			        data: data,
			        contentType: 'application/json',
			        mimeType: 'application/json',
					success:function(result){
						alert("Got the message");
		
					}// success 
					});// ajax
				});// submit
			 }); // document
		
		
		
		
		</script>



</body>
</html>