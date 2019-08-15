<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SideBar Nav</title>

<style>
        body{
            padding: 0px;
            margin: 0px;
        }

        #navbar {
            float: left;
            width: 250px;
            height: 100%;
            padding: 0px;
            margin: 0px;
            list-style-type: none;
        }
        #navbar li {
            padding: 10px;
            background-color: gray;
            border: 2px solid black;
        }
        #navbar li a {
            text-decoration: none;
            color: white;
        }
        a:hover {
            cursor: pointer;
        }

    </style>

    </head>
    <body>

    <ul id="navbar">
        <li><a href="NewMedicine.jsp">Add Medicine</a></li>
        <li><a href="searchmed.jsp">Search Medicine</a></li>
        <li><a href="addtrans.jsp">Add Transaction</a></li>
        <li><a href="searchtrans.jsp">Search Transaction</a></li>
        <li><a href="NewMedicine.jsp">Add Medicine</a></li>
        <li><a href="searchmed.jsp">Search Medicine</a></li>
        <li><a href="addtrans.jsp">Add Transaction</a></li>
        <li><a href="searchtrans.jsp">Search Transaction</a></li>
       
    </ul>




    </body>
</html>
