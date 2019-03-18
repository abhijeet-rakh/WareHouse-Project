<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="UserMenu.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WareHouse User Type View</title>
</head>
<body>

<div class="container">

		<div class="card">

              <div class="card-header bg-info text-white">
              <h1 style="text-align: center;font-size:x-large;font-family: serif;">VIEW WH-USER-TYPE DATA</h1>
              </div>
              
             
<table border="1">



<tr>
<th>ID</th>
<td>${li.whId}</td>
</tr>

<tr>
<th>TYPE</th>
<td>${li.whType}</td>
</tr>

<tr>
<th>CODE</th>
<td>${li.whCode}</td>
</tr>

<tr>
<th>WH-FOR</th>
<td>${li.whFor}</td>
</tr>

<tr>
<th>WH-EMAIL</th>
<td>${li.whEmail}</td>
</tr>

<tr>
<th>WH_CONTACT</th>
<td>${li.whContact}</td>
</tr>

<tr>
<th>WH-ID-TYPE</th>
<td>${li.whIdType}</td>
</tr>

<tr>
<th>WH-ID-OTHER</th>
<td>${li.whIdOther}</td>
</tr>


<tr>
<th>WH-ID-NUMBER</th>
<td>${li.whIdNumber}</td>
</tr>
</table>

</div>

</div>

<br>
	<a href="all">Back</a>
</body>
</html>