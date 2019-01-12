<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<h1 style="color:red;text-align:center">Registration Form of User</h1>

<form:form action="insert" method="POST" modelAttribute="user">
<pre>

User Name :<form:input path="userName"/>

User Email :<form:input path="mail"/>

User Mobile No. :<form:input path="mobile"/>

User Password :<form:input path="password" />

Roles :<form:checkbox path="roles" value="ADMIN"/> ADMIN
       <form:checkbox path="roles" value="APP USER"/> APP USER

<input type="submit" value="Register User">

</pre>
</form:form>
<br>
${message}
<br>
<a href="all">View all</a>
</body>
</html>