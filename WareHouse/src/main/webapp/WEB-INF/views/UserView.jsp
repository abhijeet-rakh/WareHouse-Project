<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<div class="card">
			<div class="card-header bg-info text-white">
				<h1
					style="text-align: center; font-size: x-large; font-family: serif;">VIEW
					USER DATA</h1>
			</div>


			<table border="1">
				<tr>
					<th>ID</th>
					<td>${user.userid}</td>
				</tr>

				<tr>
					<th>Name</th>
					<td>${user.userName}</td>
				</tr>

				<tr>
					<th>Mail</th>
					<td>${user.mail}</td>
				</tr>

				<tr>
					<th>Mobile</th>
					<td>${user.mobile}</td>
				</tr>

				<tr>
					<th>roles</th>
					<td>${user.roles}</td>
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