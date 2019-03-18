<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="UserMenu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item View</title>
</head>
<body>

<div class="container">

<div class="card">

              <div class="card-header bg-info text-white">
              <h1 style="text-align: center;font-size:x-large;font-family: serif;">VIEW ITEM DATA</h1>
              </div>
	
	<table border="1">

		<tr>
			<th>ID</th>
			<td>${item.itemId}</td>
		</tr>

		<tr>
			<th>CODE</th>
			<td>${item.itemCode}</td>
		</tr>

		<tr>
			<th>Length</th>
			<td>${item.itemLength}</td>
		</tr>

		<tr>
			<th>Width</th>
			<td>${item.itemWidth}</td>
		</tr>

		<tr>
			<th>Height</th>
			<td>${item.itemHeight}</td>
		</tr>

		<tr>
			<th>BaseCost</th>
			<td>${item.baseCost}</td>
		</tr>

        <tr>
			<th>BaseCurrency</th>
			<td>${item.baseCurrency}</td>
		</tr>
        
        <tr>
			<th>Description</th>
			<td>${item.itemDesc}</td>
		</tr>
        
          <tr>
			<th>uomId</th>
			<td>${item.uom.uomId}</td>
		</tr>
        
         <tr>
			<th>ordId</th>
			<td>${item.om.oid}</td>
		</tr>
        
        
	</table>

</div>
<!-- close container -->
</div>
<!-- close card -->

<br>
<a href="all">Back</a>


</body>
</html>