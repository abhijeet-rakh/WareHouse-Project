<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="UserMenu.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Order Method View</title>
</head>

<body>

<div class="container">

<div class="card">

              <div class="card-header bg-info text-white">
              <h1 style="text-align: center;font-size:x-large;font-family: serif;">VIEW ORDER-METHOD DATA</h1>
              </div>

	<table border="1">

		<tr>
			<th>ID</th>
			<td>${orderMethod.oid}</td>
		</tr>

		<tr>
			<th>MODE</th>
			<td>${orderMethod.ordermode}</td>
		</tr>

		<tr>
			<th>CODE</th>
			<td>${orderMethod.ordercode}</td>
		</tr>

		<tr>
			<th>EXECUTETYPE</th>
			<td>${orderMethod.executetype}</td>
		</tr>

		<tr>
			<th>DESCRIPTION</th>
			<td>${orderMethod.orderdesc}</td>
		</tr>

		<tr>
			<th>ORDERACCEPT</th>
			<td>${orderMethod.orderaccept}</td>
		</tr>

	</table>

</div>

</div>
<br>
<a href="all">Back</a>


</body>
</html>