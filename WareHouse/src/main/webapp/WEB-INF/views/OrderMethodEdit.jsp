<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Order Method</title>
</head>
<body>

<h1 style="color:red;text-align:center;">Order Method Edit Form</h1>

 <form:form action="update" method="POST" modelAttribute="OM">
 <pre>
 
 Order Id :<form:input path="oid" readonly="true"/>
 
 OrderMode :<form:radiobutton path="ordermode" value="SALE"/>Sale
            <form:radiobutton path="ordermode" value="PURCHASE"/>Purchase
 
 Order Code :<form:input path="ordercode" readonly="true"/>
 
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
 
 <input type="submit" value="Update Order Method">
 
 </pre>
 </form:form>

</body>
</html>