<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View page</title>
</head>
<body>

<div class="container">

<div class="card">
       
              <div class="card-header bg-info text-white">
              <h1 style="text-align: center;font-size:x-large;font-family: serif;">VIEW UOM DATA</h1>
              </div>
	
		<table border="1">

			<tr>
				<th>ID</th>
				<td>${st.uomId}</td>
			</tr>
			<tr>
				<th>MODE</th>
				<td>${st.uomType}</td>
			</tr>
			<tr>
				<th>CODE</th>
				<td>${st.uomModel}</td>
			</tr>
			<tr>
				<th>ENABLE</th>
				<td>${st.uomDsc}</td>
			</tr>

		</table>
		
		</div>
		<!-- close container class -->
		</div>
		<!-- close card class-->
		<br>
<a href="all">Back</a>

</body>
</html>