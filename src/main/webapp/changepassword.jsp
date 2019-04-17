<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="main.css">
        <style>
        body
        {
        background-color:skyblue;
         font-family:verdana;
        }
        input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 10px;
  margin: 15px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}
        </style>
</head>
<body>
  <form action="customer/pass" method="post">
	<h1 align="right">PasswordChange Operation</h1>
	<table align="right">
	<tr><th><h3>Enter Previous Password</h3></th></tr>
	<tr><th><input type="text" name="previouspassword"></th></tr>
	<tr><th><h3>Enter New Password</h3></th></tr>
	<tr><th><input type="text" name="password"></th></tr>
	<tr><th><button class="btn btn-success" type="submit">change</button></th></tr>
	</table>
	</form>
</body>
</html>