<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 style="color:red;text-align:center">Shipment Type Edit Form</h1>


<form:form action="update" method="POST" modelAttribute="shipmentType">
<pre>

Shipment Id  : <form:input path="id" readonly="true"/>

Shipment Mode:<form:select path="shipmentMode">
               <form:option value="">--select--</form:option>
               <form:option value="Air">AIR</form:option>
               <form:option value="Truck">TRUCK</form:option>
               <form:option value="Ship">SHIP</form:option>
               <form:option value="Train">TRAIN</form:option>
               </form:select>

Shipment Code :<form:input path="shipmentCode" readonly="true"/>


Enable Shipment :<form:select path="enableShipment">
                   <form:option value="yes">YES</form:option>
                   <form:option value="no">NO</form:option>
                 </form:select>
                 
Shipment Grade :<form:radiobutton path="shipmentGrade" value="A"/>A
                <form:radiobutton path="shipmentGrade" value="B"/>B
                <form:radiobutton path="shipmentGrade" value="C"/>C
                
Description :<form:textarea path="desc" />

<input type="submit" value="Update Shipment">
</pre>
</form:form>

</body>
</html>