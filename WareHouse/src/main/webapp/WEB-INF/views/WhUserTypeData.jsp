<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WareHouse User Type Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">
	
		<div class="card">

			<div class="card-header bg-primary text-white" >
				<h1 style="text-align:center;">WareHouse User Type</h1>
			</div>

			<a style="text-align: right;" href="excelAll">Get All WhUserType
				Data in Excel</a> <a style="text-align: right;" href="pdfExp">Get
				All WhUserType Data in Pdf</a>


			<div class="card-body">
				<c:choose>
					<c:when test="${empty data}">
						<h1>No record Found</h1>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped">
							<tr>
								<th>ID</th>
								<th>User Type</th>
								<th>User Code</th>
								<th>User For</th>
								<th>User Email</th>
								<th>User Contact</th>
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.whid}"></c:out></td>
									<td><c:out value="${d.userType}"></c:out></td>
									<td><c:out value="${d.userCode}"></c:out></td>
									<td><c:out value="${d.userFor}"></c:out></td>
									<td><c:out value="${d.userEmail}"></c:out></td>
									<td><c:out value="${d.userContact}"></c:out></td>

									<td><a href="delete?wid=${d.whid}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>

									<td><a href="viewOne?wid=${d.whid}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>

									<td><a href="editOne?wid=${d.whid}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>

									<td><a href="excelOne?wid=${d.whid}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

									<td><a href="pdfOne?wid=${d.whid}"> <img
											src="../resources/images/pdf.png" height="30" width="30">
									</a></td>

								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>

			<c:if test="${message != null}">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>

		</div>
		<!-- Container div closed -->

	</div>
	<!-- card div closed -->
</body>
</html>