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
        </style>
</head>
<body>
<h1 align="center">Updated Balance</h1>
	<table border="1" align="center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>BALANCE</th>
				
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${AA.id}</td>
				<td>${AA.name}</td>
				<td>${AA.balance}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>