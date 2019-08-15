<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New User</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


	<h2>Adding New User</h2>
	<h3>Administrator priviliges required</h3>

		FirstName: <input type="text" name="firstname" id="fname" required /><br />
		LastName: <input type="text" name="lastname" id="lname" required /><br />
		DOB: <input type="text" name="dob" id="dob" /><br />
		Username: <input type="text" name="username" id="username" required /><br />
		Password: <input type="password" name="password" id="password" required /><br />
		Email: <input type="email" name="email" id="email" /><br />
		
		Gender: <input type="radio" id="male" name="gender" value="male" checked />Male
			 	<input type="radio" id="female" name="gender" value="female" />Female<br /> 
			
		<input type="checkbox" name="admin" id="admin" /> Admin<br />
		<button id="submit" name="submit">Submit</button>
		<br />


	<script>
		
		
		 $(document).ready(function(){
			 alert("document ready");
			 $("#submit").click(function(){
				 alert("submit button clicked");
				 
				// turn into json object later
				var user = new Object();
				user.firstname = $("#fname").val();
				user.lastname = $("#lname").val();
				user.dob = $("#dob").val();
				user.username = $("#username").val();
				user.password = $("#password").val();
				user.email = $("#email").val();
				user.gender = $("input[name=gender]:checked").val();
				user.admin = $("#admin").is(":checked") ? "1" : "0";
				
				var data = JSON.stringify(user);
				
				$.ajax({
					url: "../NewUser",
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