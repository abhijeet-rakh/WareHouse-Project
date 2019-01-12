<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 style="color:red;text-align:center;">Order Method Registration Form</h1>

 <form:form action="insert" method="POST" modelAttribute="OM">
 <pre>
 
 OrderMode :<form:radiobutton path="ordermode" value="SALE"/>Sale
            <form:radiobutton path="ordermode" value="PURCHASE"/>Purchase
 
 Order Code :<form:input path="ordercode"/>
 
 Execute Type :<form:select path="executetype">
               <form:option value="">--select--</form:option>
               <form:option value="FIFO">FIFO</form:option>
               <form:option value="LIFO">LIFO</form:option>
               <form:option value="FEFO">FEFO</form:option>
               <form:option value="FCFO">FCFO</form:option>
               </form:select>
 
 <form:checkbox path="orderaccept" value="MULTI-MODEL"/>Multi-Model
 <form:checkbox path="orderaccept" value="ACCEPT-RETURN"/>Accept-Return
 <form:checkbox path="orderaccept" value="SERVICE-EXTEND"/>Service-Return
 
 Description : <form:textarea path="desc"/>
 
 <input type="submit" value="Create Order Method">
 </pre>
 </form:form>
 
 <br>
 <br>
${message}<br><br>

<a href="all">View all Order method</a>
</body>
</html>