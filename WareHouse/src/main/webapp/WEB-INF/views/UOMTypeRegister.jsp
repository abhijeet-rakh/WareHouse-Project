<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<h1 style="color: red; text-align: center">Unit of Measurement Registration Form</h1>



<!-- <form action="insert" method="POST">
<pre>
UOM Type : <select name="">
            <option value="">--select--</option>
            <option value="PACKING">PACKING</option>
            <option value="NO PACKING">NO PACKING</option>
            <option value="NA">-NA-</option>
           </select>

UOM MODEL : <input type="text" name="uommodel"/>

DESCRIPTION : <textarea rows="3" cols="20" name="uomdesc"></textarea>

<input type="submit" value="CREATE UOM">
</pre>
</form>
 -->
 
 <form:form action="insert" method="POST" modelAttribute="UM">
 <pre>
 UOM Type :<form:select path="uomtype">
            <form:option value="">--select--</form:option>
            <form:option value="PACKING">PACKING</form:option>
            <form:option value="NO PACKING">NO PACKING</form:option>
            <form:option value="NA">-NA-</form:option>
           </form:select>
 
 UOM MODEL :<form:input path="uommodel"/>

DESCRIPTION : <form:textarea path="uomdesc"/>

<input type="submit" value="CREATE UOM">
</pre>
 </form:form>
 
 
 <br><br>
 ${message}
<br><br>
<a href="all">View UOM</a>

</body>
</html>