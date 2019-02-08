<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Method Registration Form</title>
<style type="text/css">
.err {
	color: Red;
}
</style>
</head>
<body>

	<h1 style="color: red; text-align: center;">Order Method
		Registration Form</h1>

	<form:form action="insert" method="post" modelAttribute="orderMethod">
		<pre>
  
     
 OrderMode :<form:radiobutton path="ordermode" value="SALE" />Sale
            <form:radiobutton path="ordermode" value="PURCHASE" />Purchase
            <form:errors path="ordermode" cssClass="err" />
           
 
  Order Code : <form:input path="ordercode" />
               <form:errors path="ordercode" cssClass="err" /> 
            
 
 Execute Type :<form:select path="executetype">
               <form:option value="">--select--</form:option>
               <form:option value="FIFO">FIFO</form:option>
               <form:option value="LIFO">LIFO</form:option>
               <form:option value="FEFO">FEFO</form:option>
               <form:option value="FCFO">FCFO</form:option>
               </form:select>
              
 <form:errors path="executetype" cssClass="err" />
 
 <form:checkbox path="orderaccept" value="MULTI-MODEL" />Multi-Model
 <form:checkbox path="orderaccept" value="ACCEPT-RETURN" />Accept-Return
 <form:checkbox path="orderaccept" value="SERVICE-EXTEND" />Service-Return
<form:errors path="orderaccept" cssClass="err" />
 
 Description : <form:textarea path="desc" />
               <form:errors path="desc" cssClass="err" />
 
 <input type="submit" value="CreateOrderMethod">
 </pre>
	</form:form>


	<br> ${message}
	<br>
	
	<a href="all">View all Order method</a>
</body>
</html>