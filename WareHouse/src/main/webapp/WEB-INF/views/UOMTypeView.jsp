<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="color: red; text-align: center">UOM Type Detail</h1>
	<br>
	<br>
	<table border="1">

      <tr>
      <td>ID</td>
      <td>${um.uomid}</td>
      </tr>
      
      <tr>
      <td>UOMTYPE</td>
      <td>${um.uomtype}</td>
      </tr>
      
      <tr>
      <td>UOMMODEL</td>
      <td>${um.uommodel}</td>
      </tr>
      
      <tr>
      <td>DESCRIPTION</td>
      <td>${um.uomdesc}</td>
      </tr>
      
	</table>

<a href="all">Back</a>
</body>
</html>