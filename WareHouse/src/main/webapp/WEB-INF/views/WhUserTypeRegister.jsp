<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="UserMenu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WareHouse Registration form</title>
</head>
<body>

<h1 style="color:red;text-align:center">Registration form of Warehouse UserType</h1>

<form:form action="insert" method="POST" modelAttribute="whuserType">
<pre>

User Type :<form:radiobutton path="userType" value="VENDOR"/>Vendor
<form:radiobutton path="userType" value="WhUserType"/>WhUserType
<form:errors path="userType"/>

User Code :<form:input path="userCode"/>
<form:errors path="userCode"/>

User For :<form:input path="userFor"/>
<form:errors path="userFor"/>

User Email :<form:input path="userEmail"/>
<form:errors path="userEmail"/>

User Contact :<form:input path="userContact"/>
<form:errors path="userContact"/>

User IDType :<form:select path="userIdType">
             <form:option value="">--select--</form:option>
             <form:option value="PAN CARD">PAN CARD</form:option>
             <form:option value="AADHAR">AADHAR</form:option>
             <form:option value="VOTERID">VOTERID</form:option>
             <form:option value="OTHER">OTHER</form:option>
             </form:select>
<form:errors path="userIdType"/>
             
ID Number :<form:input path="idnumber"/>
<form:errors path="idnumber"/>

<input type="submit" value="CREATE WAREHOUSE USER TYPE">
</pre>
</form:form>
<br>

${message}

<br>
<a href="all">View all</a>

</body>
</html>