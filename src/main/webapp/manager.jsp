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
body {
	background-color: skyblue;
	 font-family:verdana;
}

input[type=text] ,[type=password]{
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
	<form action="customer/manager" method="Post">

		<h1 align="center">Manager Details</h1>
		<table  align="center">
			<tr><th><h3>Manager UserName</h3></th></tr>
			<tr><th><input type="text" name="name" required autofocus /></th></tr>
			
			<tr><th><h3>Manager Password</h3></th></tr>
			<tr><th><input type="password" name="password" value="password" ></th></tr>
			<tr><th><button  class="btn btn-primary" type="submit">Login</button></th></tr>
		</table>
	</form>
</body>
</html>