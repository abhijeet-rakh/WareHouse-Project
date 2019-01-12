<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="update" method="POST" modelAttribute="user">
<pre>

User Id : <form:input path="userid" readonly="true"/>

User Name :<form:input path="userName" readonly="true"/>

User Email :<form:input path="mail"/>

User Password :<form:input path="password" />

User Mobile No. :<form:input path="mobile"/>

Roles :<form:checkbox path="roles" value="ADMIN"/> ADMIN
       <form:checkbox path="roles" value="APP USER"/> APP USER

<input type="submit" value="Update User">

</pre>
</form:form>

</body>
</html>