<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale Order View</title>
</head>
<body>

	<div class="container">

		<div class="card">

			<table border="1">

				<tr>
					<th>OrderId</th>
					<td>${saleOrder.orderId}</td>
				</tr>

				<tr>
					<th>OrderCode</th>
					<td>${saleOrder.orderCode}</td>
				</tr>

				<tr>
					<th>Shipment Mode</th>
					<td>${saleOrder.shipmentMode}</td>
				</tr>

				<tr>
					<th>Customer</th>
					<td>${saleOrder.customer}</td>
				</tr>

				<tr>
					<th>refNumber</th>
					<td>${saleOrder.refNumber}</td>
				</tr>

				<tr>
					<th>stockMode</th>
					<td>${saleOrder.stockMode}</td>
				</tr>

				<tr>
					<th>Stock Source</th>
					<td>${saleOrder.stockSource}</td>
				</tr>

				<tr>
					<th>Default Status</th>
					<td>${saleOrder.defaultStatus}</td>
				</tr>

				<tr>
					<th>Sale ord Desc</th>
					<td>${saleOrder.saleOrdDesc}</td>
				</tr>
			</table>

		</div>

	</div>

	<br>
	<a href="all">Back</a>



</body>
</html>