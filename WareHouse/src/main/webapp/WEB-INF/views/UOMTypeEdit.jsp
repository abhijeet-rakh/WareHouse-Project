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
	<h1 style="color: red; text-align: center">Edit Unit of Measurement Registration Form</h1>

 <form:form action="update" method="POST" modelAttribute="UOM">
 <pre>
 UOM Id :<form:input path="uomid" readonly="true"/>
 
 UOM Type :<form:select path="uomtype">
            <form:option value="">--select--</form:option>
            <form:option value="PACKING">PACKING</form:option>
            <form:option value="NO PACKING">NO PACKING</form:option>
            <form:option value="NA">-NA-</form:option>
           </form:select>
 
 UOM MODEL :<form:input path="uommodel"/>

 DESCRIPTION : <form:textarea path="uomdesc"/>

<input type="submit" value="Update UOM">
</pre>
 </form:form>

</body>
</html>