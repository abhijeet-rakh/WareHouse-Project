<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order View</title>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">

				<h1
					style="text-align: center; font-size: x-large; font-family: serif;">VIEW
					PURCHASE-ORDER DATA</h1>
			</div>

			<table border="1">

				<tr>
					<th>ID</th>
					<td>${po.orderId}</td>
				</tr>

				<tr>
					<th>CODE</th>
					<td>${po.orderCode}</td>
				</tr>

				<tr>
					<th>Shipment Mode</th>
					<td>${po.shipmentMode}</td>
				</tr>

				<tr>
					<th>Vendor</th>
					<td>${po.vendor}</td>
				</tr>

				<tr>
					<th>Reference Number</th>
					<td>${po.refNum}</td>
				</tr>

				<tr>
					<th>Quality Check</th>
					<td>${po.qualityCheck}</td>
				</tr>

				<tr>
					<th>Order Status</th>
					<td>${po.ordStatus}</td>
				</tr>

				<tr>
					<th>Purchase Order</th>
					<td>${po.ordStatus}</td>
				</tr>

				<tr>
					<th>Order Description</th>
					<td>${po.whusertype.whid}</td>
				</tr>

			</table>

		</div>
		<!-- close container class-->

	</div>
	<!-- close card class -->
	<br>
	<a href="all">Back</a>




</body>
</html>