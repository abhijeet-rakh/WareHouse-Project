<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:red;text-align:center;">All UOMtype Data</h1>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
<tr>
     <th>uid</th>
     <th>uomtype</th>
     <th>uommodel</th>
     <!-- <th>uomdesc</th> -->
     <th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${data}" var="d">
       <tr>
       <td><c:out value="${d.uomid}"></c:out></td>
       <td><c:out value="${d.uomtype}"></c:out></td>
       <td><c:out value="${d.uommodel}"></c:out></td>
       <%-- <td><c:out value="${d.uomdesc}"></c:out></td> --%>
       <td>
       <a href="delete?uid=${d.uomid}">
              <img src="../resources/images/delete.png" height="30" width="30">
       </a>
       </td>
       <td>
       <a href="viewOne?uid=${d.uomid}">
              <img src="../resources/images/view.png" height="30" width="30">        
       </a>
       </td>
       </tr>
</c:forEach>
</table>

${message}

</body>
</html>