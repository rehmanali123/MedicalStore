
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>

</head>
<body>


	Enter the name: <input type="text" name="name" id="name" />
	<br/>
	<button id="register">Submit</button>
	<p id="demo"></p>

	<script>
	
	$(document).ready(function(){
		alert("document ready");
		$("#register").click(function(){
			var name = $("#name").val();
			$.ajax({
				type:'post',
				url:'AjaxController',
				data:{name:name},
				dataType:'json',
				success:function(result){
					var obj = JSON.parse(result);
					$("#demo").html(result);
				}
			});
		});
	});
	
	</script>





</body>
</html>