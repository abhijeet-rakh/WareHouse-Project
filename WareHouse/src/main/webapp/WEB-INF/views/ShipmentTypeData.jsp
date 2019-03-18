<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentType Data</title>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">All Shipment Type Data</h1>
			</div>

			<!-- card-header end -->
			<a style="text-align: right;" href="excelExp">Export all recordin
				Excel</a> | <a style="text-align: right;" href="pdfExp">Export all
				record in Pdf</a>

			<div class="card-body">
				<c:choose>
					<c:when test="${empty data}">
						<h4>No Record Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped"
							border="1">
							<tr>
								<th>ShipId</th>
								<th>ShipMode</th>
								<th>ShipCode</th>
								<th>EnableShip</th>
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.id}"></c:out></td>
									<td><c:out value="${d.shipmentMode}"></c:out></td>
									<td><c:out value="${d.shipmentCode}"></c:out></td>
									<td><c:out value="${d.enableShipment}"></c:out></td>
									
									<td><a href="delete?sid=${d.id}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>
									<td><a href="viewOne?sid=${d.id}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>
									<td><a href="editOne?sid=${d.id}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>

									<td><a href="excelOne?sid=${d.id}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

									<td><a href="pdfOne?sid=${d.id}"> <img
											src="../resources/images/pdf.png" height="30" width="30">
									</a></td>

								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- card body closed -->

			<div>
				<c:if test="${message != null}">
					<div class="card-footer bg-info text-white">${message}</div>
				</c:if>
			</div>


		</div>
		<!-- card div end -->

	</div>
	<!-- container div end -->

</body>
</html>