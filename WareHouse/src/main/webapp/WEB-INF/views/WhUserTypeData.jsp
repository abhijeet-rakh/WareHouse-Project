<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="UserMenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WH USER TYPE DATA</title>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">WareHouse User Type Data</h1>
			</div>

			<a style="text-align: right;" href="excelall">Get all User in
				Excel</a> | <a style="text-align: right;" href="pdfall">Get all User
				in pdf</a>

			<div class="card-body">
				<c:choose>
					<c:when test="${empty data}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped"
							border="1">
							<tr>
								<th>ID</th>
								<th>TYPE</th>
								<th>CODE</th>
								<th>FOR</th>
								<th>EMAIL</th>
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.whId}"></c:out></td>
									<td><c:out value="${d.whType}"></c:out></td>
									<td><c:out value="${d.whCode}"></c:out></td>
									<td><c:out value="${d.whFor}"></c:out></td>
									<td><c:out value="${d.whEmail}"></c:out></td>

									<td><a href="delete?wid=${d.whId}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>
									<td><a href="viewOne?wid=${d.whId}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>
									<td><a href="editOne?wid=${d.whId}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>
									<td><a href="excelOne?wid=${d.whId}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>
									<td><a href="pdfOne?wid=${d.whId}"> <img
											src="../resources/images/pdf.png" height="30" width="30">
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- Close card-body -->

			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>


		</div>
		<!-- close container -->
	</div>
	<!-- close card -->
</body>
</html>