<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;text-align:center;">All ShipmentType Data</h1>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
<tr>
     <th>ShipId</th>
     <th>ShipMode</th>
     <th>ShipCode</th>
     <th>EnableShip</th>
     <!-- <th>ShipGrade</th>
     <th>ShipDesc</th>
     <th>UpdateCount</th>
     <th>CreatedOn</th>
     <th>UpdatedOn</th> -->
     <th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${data}" var="d">
       <tr>
       <td><c:out value="${d.id}"></c:out></td>
       <td><c:out value="${d.shipmentMode}"></c:out></td>
       <td><c:out value="${d.shipmentCode}"></c:out></td>
       <td><c:out value="${d.enableShipment}"></c:out></td>
      <%--  <td><c:out value="${d.shipmentGrade}"></c:out></td>
       <td><c:out value="${d.desc}"></c:out></td>
       <td><c:out value="${d.shipcount}"></c:out></td>
       <td><c:out value="${d.createtime}"></c:out></td>
       <td><c:out value="${d.updttime}"></c:out></td> --%>
       <td><a href="delete?sid=${d.id}">
              <img  src="../resources/images/delete.png" height="30" width="30">
           </a>
       </td>
       <td><a href="viewOne?sid=${d.id}">
              <img  src="../resources/images/view.png" height="30" width="30">
           </a>
       </td>
       </tr>
</c:forEach>

</table>

${message}

</body>
</html>