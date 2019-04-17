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
input[type=number] {
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
	<form action="customer/transfer" method="post">
		<h1 align="center">Transfer Operation</h1>
		<table align="center">
			<tr><th><h3>Enter Account id of the Receiver</h3></th></tr>
			<tr><th><input type="number" name="id"></th></tr>
			<tr><th><h3>Enter Money to transfer</h3></th></tr>
			<tr><th><input type="number" name="money"></th></tr>
			<tr><th><button class="btn btn-success" type="submit">Transfer</button></th></tr>
		</table>
	</form>
</body>
</html>