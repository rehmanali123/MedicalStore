
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Navigation Module</title>
    <link rel="stylesheet" type="text/css" href="css/navigation.css" />
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

                        <%
                        
                        	Object string = session.getAttribute("user");
                        	Object str = session.getAttribute("status");
                        
                        	String username = (String) string;
                        	String status = (String) str;
                        
                        %>
    <div id="nav_container">
        <div id="logger">

                    <img id="log_img" src="resources/pic.jpeg"/>
                    <div id="log_info">
                        <p id="first"><%= string %></p>
                        
                        <p>
                            <span id="second" style="line-height: normal;"><%= status %> </span>
                        </p>
                    </div>
                    <div class="clear"></div>
        </div>
        <ul>
            <li style="background-color: #494949; border-left: 3px solid #1c1c1c;"><a href="main.jsp"><i class="glyphicon glyphicon-envelope"></i> Dashboard</a></li>
            <li><a href="NewMedicine.jsp"><i class="glyphicon glyphicon-envelope"></i>Medicine</a></li>
            <li><a href="billing.jsp"><i class="glyphicon glyphicon-user"></i>Transaction</a></li>
            <li><a href="stock.jsp"><i class="glyphicon glyphicon-remove"></i>Stock</a></li>
            <li><a href="order.jsp"><i class="glyphicon glyphicon-user"></i>Order</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-cloud"></i>Reports</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-remove"></i>Finance</a></li>
            <li><a href="notification.jsp"><i class="glyphicon glyphicon-envelope"></i>Notifications</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-cloud"></i>Settings</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-remove"></i>Logout</a></li>
        </ul>
    </div>






</body>
</html>
