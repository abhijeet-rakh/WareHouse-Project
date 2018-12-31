<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Shipment Type
		Registration Form</h1>

	<form action="insert" method="POST">
		<pre>
 Shipment Mode :<select name="shipmentMode">
                <option value="">--select--</option>
                <option value="AIR">Air</option>
                <option value="TRUCK">Truck</option>
                <option value="SHIP">Ship</option>
                <option value="TRAIN">Train</option>
                </select>
                
 Shipment Code :<input type="text" name="shipmentCode" />
 
 Enable Shipment :<select name="enableShipment">
                   <option value="YES">yes</option>
                   <option value="NO">No</option>
                  </select>

Shipment Grade :<input type="radio" name="shipmentGrade" value="A" />A
                <input type="radio" name="shipmentGrade" value="B" />B
                <input type="radio" name="shipmentGrade" value="C" />C
                
Description :<textarea rows="3" cols="20" name="ShipmentDesc" ></textarea>

<input type="submit" value="Register Shipment" />
</pre>
</form>
       ${msg} <br><br>
       
       <a href="all">Get All Data</a>
</body>
</html>