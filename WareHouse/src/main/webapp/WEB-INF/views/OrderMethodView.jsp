<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Method View</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">OrderMethod Detail</h1>

	<table border="1">

		<tr>
			<td>ID</td>
			<td>${orderMethod.oid}</td>
		</tr>

		<tr>
			<td>MODE</td>
			<td>${orderMethod.ordermode}</td>
		</tr>

		<tr>
			<td>CODE</td>
			<td>${orderMethod.ordercode}</td>
		</tr>

		<tr>
			<td>EXECUTETYPE</td>
			<td>${orderMethod.executetype}</td>
		</tr>

		<tr>
			<td>DESCRIPTION</td>
			<td>${orderMethod.orderdesc}</td>
		</tr>

		<tr>
			<td>ORDERACCEPT</td>
			<td>${orderMethod.orderaccept}</td>
		</tr>

	</table>

<br><br><br>
<a href="all">Back</a>


</body>
</html>