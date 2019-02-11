<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order View</title>
</head>
<body>

<h1 style="color: red; text-align: center;">Purchase Order Detail</h1>

	<table border="1">

		<tr>
			<td>ID</td>
			<td>${po.orderId}</td>
		</tr>

		<tr>
			<td>CODE</td>
			<td>${po.orderCode}</td>
		</tr>

		<tr>
			<td>Shipment Mode</td>
			<td>${po.shipmentMode}</td>
		</tr>

		<tr>
			<td>Vendor</td>
			<td>${po.vendor}</td>
		</tr>

		<tr>
			<td>Reference Number</td>
			<td>${po.refNum}</td>
		</tr>

		<tr>
			<td>Quality Check</td>
			<td>${po.qualityCheck}</td>
		</tr>

        <tr>
			<td>Order Status</td>
			<td>${po.ordStatus}</td>
		</tr>
        
        <tr>
			<td>Purchase Order</td>
			<td>${po.ordStatus}</td>
		</tr>
        
        <tr>
			<td>Order Description</td>
			<td>${po.whusertype.whid}</td>
		</tr>
        
	</table>

<br><br><br>
<a href="all">Back</a>




</body>
</html>