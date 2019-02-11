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
			<td>${item.itemId}</td>
		</tr>

		<tr>
			<td>CODE</td>
			<td>${item.itemCode}</td>
		</tr>

		<tr>
			<td>Length</td>
			<td>${item.itemLength}</td>
		</tr>

		<tr>
			<td>Width</td>
			<td>${item.itemWidth}</td>
		</tr>

		<tr>
			<td>Height</td>
			<td>${item.itemHeight}</td>
		</tr>

		<tr>
			<td>BaseCost</td>
			<td>${item.baseCost}</td>
		</tr>

        <tr>
			<td>BaseCurrency</td>
			<td>${item.baseCurrency}</td>
		</tr>
        
        <tr>
			<td>Description</td>
			<td>${item.itemDesc}</td>
		</tr>
        
          <tr>
			<td>uomid</td>
			<td>${item.uom.uomid}</td>
		</tr>
        
         <tr>
			<td>ordid</td>
			<td>${item.om.oid}</td>
		</tr>
        
        
	</table>

<br><br><br>
<a href="all">Back</a>


</body>
</html>