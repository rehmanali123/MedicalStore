<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
</head>

    <body>

      <div id="nav"></div>
      This is the content


<script>
      $(function(){
    	  $("#nav").load("sidebar.jsp");  
      });
      
</script>

    </body>
    
</html>
