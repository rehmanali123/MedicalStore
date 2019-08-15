<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- CDN -->
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->

	<link rel="stylesheet" href="css/login.css" />
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="bootstrap/js/bootstrap.min.js" />
    <!-- Include jQuery -->
    <script type="text/javascript" src="js/jquery.js"></script>
    

</head>

<body style="padding: 0px; margin: 0px;">
	
	<div id="head_container">

        <div id ="left">
            <div id="logo">
                MEDPHARM
            </div>
            <div id="slogan">
                Medicine Helper
            </div>
        </div>

        <div id="right">
            <ul>
            	<li>Home</li>
            	<li>Products</li>
            	<li>About Us</li>
            	<li>Contact</li>
            	
            </ul>
        </div>
        <div class="clear"></div>

    </div>
    

	<div id="signin_form">
		<!-- <button type="button" name="signupbtn" value="Sign Up" id="signupbtn">Sign Up</button> -->

		<div id="sign_in">
			<span id="sign_in_title">Sign In</span> 
			<span><a id="forgot_password">Forgot Password ?</a></span>
		</div>

		<div style="margin:20px;">
			<input type="text" class="form-control" placeholder="Username" id="username" required><br /> 
			
			<input type="password" class="form-control" placeholder="password" id="password" required><br />
			<input type="checkbox" name="admin" id="admin" />
			<span style="color: white;"> Admin</span>
			<input type="button" class="btn btn-default" id="login" value="Login" /><br/>
			<p id="again" style="color: white;"></p>
		</div>

	</div>


<script>


	$(document).ready(function(){
		
		$("#again").hide();
		
		$("#login").click(function(){
			
			var login = new Object();
			login.username =  $("#username").val();
			login.password = $("#password").val();
			login.admin = $("#admin").is(":checked") ? "1" : "0";
			
			
			alert(login.username);
			alert(login.password);
			alert(login.admin);
			
			
			var data = JSON.stringify(login);
			
			$.ajax({
					type: 'POST',
					url: "LoginServlet",
			        dataType: 'text',
			        data: data,
			        contentType: 'application/json',
			        mimeType: 'application/json',
					success:function(result){
						if(result == "true"){
							window.location.replace("main.jsp");
						}else if(result == "false"){
							alert("Message is false");
							
							$("#again").html("Username or password is incorrect").show();
							$("#username").val("");
							$("#password").val("");
						}
		
					}// success 
				
				});// ajax
			});// submit
		 }); // document


</script>



</body>
</html>