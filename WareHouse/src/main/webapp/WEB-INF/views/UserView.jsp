<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;text-align:center">User Information</h1>

<table border="1">
<tr>
<td>ID</td>
<td>${user.userid}</td>
</tr>

<tr>
<td>Name</td>
<td>${user.userName}</td>
</tr>

<tr>
<td>Mail</td>
<td>${user.mail}</td>
</tr>

<tr>
<td>Mobile</td>
<td>${user.mobile}</td>
</tr>

<tr>
<td>roles</td>
<td>${user.roles}</td>
</tr>

</table>
</body>
</html>