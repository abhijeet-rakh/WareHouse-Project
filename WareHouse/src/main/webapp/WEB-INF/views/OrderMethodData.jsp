<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Method Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">Order Method Detail</h1>
			</div>
			<!-- Card header end -->

			<a style="text-align: right;" href="excelall">Get all OrderMethod
				in Excel</a> <a style="text-align: right;" href="pdfExp">Get all
				OrderMethod in pdf</a> <br>

			<div class="card-body">
				<c:choose>
					<c:when test="${empty data}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped">
							<tr>
								<th>Orderid</th>
								<th>OrderMode</th>
								<th>OrdercCode</th>
								<th>ExecuteType</th>
								<!-- <th>Desc</th>
                     <th>OrderAccept</th> -->
								<th colspan="5">OPERATION</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.oid}"></c:out></td>
									<td><c:out value="${d.ordermode}"></c:out></td>
									<td><c:out value="${d.ordercode}"></c:out></td>
									<td><c:out value="${d.executetype}"></c:out></td>
									<%-- <td><c:out value="${d.desc}"></c:out></td>
      <td><c:out value="${d.orderaccept}"></c:out></td> --%>

									<td><a href="delete?oid=${d.oid}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>

									<td><a href="viewOne?oid=${d.oid}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>

									<td><a href="editOne?oid=${d.oid}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>

									<td><a href="excelOne?oid=${d.oid}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

									<td><a href="pdfOne?oid=${d.oid}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>

			<c:if test="${message != null}">
				<div class="card-footer bg-info text-white">${message}</div>
				<!-- card-footer end-->
			</c:if>

		</div>
		<!-- Card class end -->

	</div>
	<!-- Container class end  -->
</body>
</html>