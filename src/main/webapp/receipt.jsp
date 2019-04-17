<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1 align="center">List of Transaction Details</h1>
	<table align="center" border="1">
		<thead>
			<tr>
				<th>Transaction Id</th>
				<th>Amount</th>
				<th>Type </th>
		
			</tr>
		</thead>
		<tbody>
			<c:forEach var="print" items="${PRINT}">
				<tr>
					<td>${print.id}</td>
					<td>${print.amount}</td>
					<td>${print.type}</td>
					
					
				</tr>
			</c:forEach>
			</table>
</body>
</html>