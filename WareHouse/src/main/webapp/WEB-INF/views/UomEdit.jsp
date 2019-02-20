<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UOM REGISTER</title>
</head>
<body bgcolor="skyblue" background="bg.png">
	<center>
		<h1>WELCOME TO UOM Edit PAGE</h1>
		<table border="1">
			<form:form action="update" method="post" modelAttribute="uom">
				<pre>
UomId:<form:input path="uomId"  readonly="true"/>

UomType:<form:select path="uomType">
<form:option value="">-Select-</form:option>
<form:option value="Packingno">Packing-No</form:option>
<form:option value="Packing">Packing</form:option>
<form:option value="NA">-NA-</form:option>
</form:select>

UomModel:<form:input path="UomModel" />

Description:<form:textarea path="uomDsc" />

<input type="submit" value="Update" /><br>
<a href="all"><input type="button" value="ViewAll"></a>
</pre>
</form:form>
</table>
${message}
</body>
</html>