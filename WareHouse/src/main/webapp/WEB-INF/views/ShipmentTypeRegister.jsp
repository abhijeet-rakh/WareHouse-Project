<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Type Registration Form</title>
<style type="text/css">
.err{color:red;}
</style>
</head>
<body>
	<h1 style="color: red; text-align: center;">Shipment Type Registration Form</h1>

<form:form action="insert" method="POST" modelAttribute="shipmentType">
<pre>
Shipment Mode:<form:select path="shipmentMode" >
               <form:option value="">--select--</form:option>
               <form:option value="Air">AIR</form:option>
               <form:option value="Truck">TRUCK</form:option>
               <form:option value="Ship">SHIP</form:option>
               <form:option value="Train">TRAIN</form:option>
               </form:select>
<form:errors path="shipmentMode" cssClass="err"/>

Shipment Code :<form:input path="shipmentCode" />

<form:errors path="shipmentCode" cssClass="err"/>

Enable Shipment :<form:select path="enableShipment">
                   <form:option value="yes">YES</form:option>
                   <form:option value="no">NO</form:option>
                 </form:select>
                 
<form:errors path="enableShipment" cssClass="err"/>

Shipment Grade :<form:radiobutton path="shipmentGrade" value="A"/>A
                <form:radiobutton path="shipmentGrade" value="B"/>B
                <form:radiobutton path="shipmentGrade" value="C"/>C
<form:errors path="shipmentGrade" cssClass="err"/>
                
Description :<form:textarea path="desc" />

<form:errors path="desc" cssClass="err"/>

<input type="submit" value="Register Shipment">

</pre>
</form:form>
<br><br>
       ${msg} 
    <br><br>
       
       <a href="all">Get All Data</a>
</body>
</html>