<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">SaleOrder Detail</h1>

	<table border="1">

		<tr>
			<td>OrderId</td>
			<td>${saleOrder.orderId}</td>
		</tr>

		<tr>
			<td>OrderCode</td>
			<td>${saleOrder.orderCode}</td>
		</tr>

		<tr>
			<td>Shipment Mode</td>
			<td>${saleOrder.shipmentMode}</td>
		</tr>

		<tr>
			<td>Customer</td>
			<td>${saleOrder.customer}</td>
		</tr>

		<tr>
			<td>refNumber</td>
			<td>${saleOrder.refNumber}</td>
		</tr>

		<tr>
			<td>stockMode</td>
			<td>${saleOrder.stockMode}</td>
		</tr>

       <tr>
			<td>Stock Source</td>
			<td>${saleOrder.stockSource}</td>
		</tr>
       
       <tr>
			<td>Default Status</td>
			<td>${saleOrder.defaultStatus}</td>
		</tr>
       
        <tr>
			<td>Sale ord Desc</td>
			<td>${saleOrder.saleOrdDesc}</td>
		</tr>
	</table>

<br><br><br>
<a href="all">Back</a>



</body>
</html>