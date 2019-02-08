<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item View</title>
</head>
<body>
<h1 style="color: red; text-align: center;">Item Detail</h1>

	<table border="1">

		<tr>
			<td>ID</td>
			<td>${it.itemId}</td>
		</tr>

		<tr>
			<td>CODE</td>
			<td>${it.itemCode}</td>
		</tr>

		<tr>
			<td>Length</td>
			<td>${it.itemLength}</td>
		</tr>

		<tr>
			<td>Width</td>
			<td>${it.itemWidth}</td>
		</tr>

		<tr>
			<td>Height</td>
			<td>${it.itemHeight}</td>
		</tr>

		<tr>
			<td>BaseCost</td>
			<td>${it.baseCost}</td>
		</tr>

        <tr>
			<td>BaseCurrency</td>
			<td>${it.baseCurrency}</td>
		</tr>
        
        <tr>
			<td>Description</td>
			<td>${it.itemDesc}</td>
		</tr>
        
	</table>

<br><br><br>
<a href="all">Back</a>


</body>
</html>