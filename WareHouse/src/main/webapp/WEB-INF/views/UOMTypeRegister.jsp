<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="insert" method="POST">
<pre>
UOM Type : <select name="uomtype">
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
${message}
<br>
<a href="all">View UOM</a>

</body>
</html>