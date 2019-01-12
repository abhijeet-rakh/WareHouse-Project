<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="excelall">Get all User in Excel</a> |
<a href="pdfExp">Get all User in pdf</a>
<table border="1">
<tr>
<th>ID</th>
<th>UserName</th>
<th>Email</th>
<th>Mobile</th>
<th colspan="5">Operation</th>
</tr>

<c:forEach items="${data}" var="d">
<tr>
<td><c:out value="${d.userid}"></c:out></td>
<td><c:out value="${d.userName}"></c:out></td>
<td><c:out value="${d.mail}"></c:out></td>
<td><c:out value="${d.mobile}"></c:out></td>

<td>
 <a href="delete?uid=${d.userid}">
       <img src="../resources/images/delete.png" height="30" width="30">
 </a>
</td>

<td>
<a href="viewOne?uid=${d.userid}">
       <img src="../resources/images/view.png" height="30" width="30">
</a>      
</td>

<td>
<a href="editOne?uid=${d.userid}">
       <img src="../resources/images/edit.png" height="30" width="30">
</a>
</td>

<td>
<a href="excelOne?uid=${d.userid}">
       <img src="../resources/images/excel.png" height="30" width="30">
</a>
</td>

<td>
<a href="pdfOne?uid=${d.userid}">
       <img src="../resources/images/pdf.png" height="30" width="30">
</a>
</td>

</tr>
</c:forEach>
</table>
<br><br>
${message} 
</body>
</html>