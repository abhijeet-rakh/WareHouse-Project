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

<table border="1">

<tr>
<th>ID</th>
<th>User Type</th>
<th>User Code</th>
<th>User For</th>
<th>User Email</th>
<th>User Contact</th>
<th colspan="3">OPERATIONS</th> 
</tr>
<c:forEach items="${data}" var="d">

<tr>

       <td><c:out value="${d.whid}"></c:out></td>
       <td><c:out value="${d.userType}"></c:out></td>
       <td><c:out value="${d.userCode}"></c:out></td>
       <td><c:out value="${d.userFor}"></c:out></td>
       <td><c:out value="${d.userEmail}"></c:out></td>
       <td><c:out value="${d.userContact}"></c:out></td>
    <td>
     <a href="delete?wid=${d.whid}">
        <img src="../resources/images/delete.png" height="30" width="30">
     </a>
    </td>
      
    <td>
     <a href="viewOne?wid=${d.whid}">
        <img src="../resources/images/view.png" height="30" width="30">
    </a>
    </td>
    
    <td>
    <a href="editOne?wid=${d.whid}">
        <img src="../resources/images/edit.png" height="30" width="30">
    </a>
    </td>
    
</tr>
</c:forEach>
</table>

<br><br>

${message}
</body>
</html>