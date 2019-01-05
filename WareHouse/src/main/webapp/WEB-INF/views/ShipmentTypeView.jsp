<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Shipment Type Detail</h1>
	<br>
	<br>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${st.id}</td>
		</tr>

		<tr>
			<td>MODE</td>
			<td>${st.shipmentMode}</td>
		</tr>

		<tr>
			<td>CODE</td>
			<td>${st.shipmentCode}</td>
		</tr>

		<tr>
			<td>ENABLE SHIPMENT</td>
			<td>${st.enableShipment}</td>
		</tr>

		<tr>
			<td>GRADE</td>
			<td>${st.shipmentGrade}</td>
		</tr>

		<tr>
			<td>DESCRIPTION</td>
			<td>${st.desc}</td>
		</tr>

	</table>
	<br><br><br>
	<a href="all">Back</a>
</body>
</html>