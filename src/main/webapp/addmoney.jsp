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

body {
	background-color: skyblue;
	 font-family:verdana;
}

h3 {
	font-size: 20px;
}

h4 {
	font-size: 25px;
}

b {
	font-size: 25px;
}
</style>
</head>
<body>
	<form action="customer/add" method="post">

		<h1 align="center">Adding Operation</h1>
		<table align="center">

			<tr>
				<th><h2>Enter Amount to Add</h2></th>
			</tr>
			<br>
			<tr>
				<th><input type="number" name="money"></th>
			</tr>

			<tr>
				<th><button class="btn btn-primary" type="submit">Deposit</button></th>
			</tr>
		</table>
	</form>
</body>
</html>