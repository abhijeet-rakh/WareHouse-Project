<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="UserMenu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">

		<div class="card">

              <div class="card-header bg-info text-white">
              <h1 style="text-align: center;font-size:x-large;font-family: serif;">VIEW SHIPMENT-TYPE DATA</h1>
              </div>


	<table border="1">
		<tr>
			<th>ID</th>
			<td>${st.id}</td>
		</tr>

		<tr>
			<th>MODE</th>
			<td>${st.shipmentMode}</td>
		</tr>

		<tr>
			<th>CODE</th>
			<td>${st.shipmentCode}</td>
		</tr>

		<tr>
			<th>ENABLE SHIPMENT</th>
			<td>${st.enableShipment}</td>
		</tr>

		<tr>
			<th>GRADE</th>
			<td>${st.shipmentGrade}</td>
		</tr>

		<tr>
			<th>DESCRIPTION</th>
			<td>${st.desc}</td>
		</tr>

	</table>
	
	</div>
	
	</div>
	
	<br>
	<a href="all">Back</a>
</body>
</html>