<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">OrderMethod Detail</h1>

	<table border="1">

		<tr>
			<td>ID</td>
			<td>${om.oid}</td>
		</tr>

		<tr>
			<td>MODE</td>
			<td>${om.ordermode}</td>
		</tr>

		<tr>
			<td>CODE</td>
			<td>${om.ordercode}</td>
		</tr>

		<tr>
			<td>EXECUTETYPE</td>
			<td>${om.executetype}</td>
		</tr>

		<tr>
			<td>DESCRIPTION</td>
			<td>${om.desc}</td>
		</tr>

		<tr>
			<td>ORDERACCEPT</td>
			<td>${om.orderaccept}</td>
		</tr>

	</table>


</body>
</html>