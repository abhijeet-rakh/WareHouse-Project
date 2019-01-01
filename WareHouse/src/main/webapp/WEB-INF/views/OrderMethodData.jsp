<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
<tr>
      <th>Orderid</th>
      <th>OrderMode</th>
      <th>OrdercCode</th>
      <th>ExecuteType</th>
      <th>Desc</th>
      <th>OrderAccept</th>
      <th>OPERATION</th>
</tr>
<c:forEach items="${data}" var="d">
      <tr>
      <td><c:out value="${d.oid}"></c:out></td>
      <td><c:out value="${d.ordermode}"></c:out></td>
      <td><c:out value="${d.ordercode}"></c:out></td>
      <td><c:out value="${d.executetype}"></c:out></td>
      <td><c:out value="${d.desc}"></c:out></td>
      <td><c:out value="${d.orderaccept}"></c:out></td>
      <td><a href="delete?oid=${d.oid}">DELETE</a></td>
     </tr>
</c:forEach>
</table>
<br><br>
${message}
</body>
</html>