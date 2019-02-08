<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UOM Registration Form</title>
</head>
<body>

	<h1 style="color: red; text-align: center">Unit of Measurement Registration Form</h1>


 <form:form action="insert" method="post" modelAttribute="uom">
 <pre>
 UOM Type :<form:select path="uomtype">
            <form:option value="">--select--</form:option>
            <form:option value="PACKING">PACKING</form:option>
            <form:option value="NO PACKING">NO PACKING</form:option>
            <form:option value="NA">-NA-</form:option>
           </form:select>
 
 <form:errors path="uomtype"/>
 
 UOM MODEL :<form:input path="uommodel"/>

<form:errors path="uommodel"/>

DESCRIPTION : <form:textarea path="uomdesc"/>

<form:errors path="uomdesc"/>
<input type="submit" value="CREATE UOM">
</pre>
 </form:form>
 
 
 <br><br>
 ${message}
<br><br>
<a href="all">View UOM</a>

</body>
</html>