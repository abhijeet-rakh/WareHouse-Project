<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 style="color:red;text-align:center">Registration form of Warehouse UserType</h1>

<form:form action="insert" method="POST" modelAttribute="WUT">
<pre>

User Type :<form:radiobutton path="userType" value="VENDOR"/>Vendor
<form:radiobutton path="userType" value="WhUserType"/>WhUserType

User Code :<form:input path="userCode"/>

User For :<form:input path="userFor"/>

User Email :<form:input path="userEmail"/>

User Contact :<form:input path="userContact"/>

User IDType :<form:select path="userIdType">
             <form:option value="">--select--</form:option>
             <form:option value="PAN CARD">PAN CARD</form:option>
             <form:option value="AADHAR">AADHAR</form:option>
             <form:option value="VOTERID">VOTERID</form:option>
             <form:option value="OTHER">OTHER</form:option>
             </form:select>
             
ID Number :<form:input path="idnumber"/>

<input type="submit" value="CREATE WAREHOUSE USER TYPE">
</pre>
</form:form>
<br><br><br>

${message}

<br><br>
<a href="all">View all</a>

</body>
</html>