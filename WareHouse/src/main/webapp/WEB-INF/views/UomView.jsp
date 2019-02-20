<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View page</title>
</head>
<body bgcolor="lightgreen">
<center>
<h2><b>WELCOME TO UOM VIEW  PAGE </b></h2>
<table border="1">

<tr>
<td>ID</td><td>${st.uomId}</td>
</tr> 
<tr>
<td>MODE</td><td>${st.uomType}</td>
</tr> 
<tr>
<td>CODE</td><td>${st.uomModel}</td>
</tr> 
<tr>
<td>ENABLE</td><td>${st.uomDsc}</td>
</tr> 


</table><br><br>
<a href="all"><input type="button" value="BackViewAll"></a>
</body>
</html>