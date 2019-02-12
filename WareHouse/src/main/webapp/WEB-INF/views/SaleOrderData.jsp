<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="UserMenu.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale Order Data</title>
</head>
<body>
	<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">Sale Order Detail</h1>
			</div>
			<!-- Card header end -->

			<a style="text-align: right;" href="excelall">Get all Sale Order
				in Excel</a> <a style="text-align: right;" href="pdfExp">Get all
				Sale Order in pdf</a> <br>

			<div class="card-body">
				<c:choose>
					<c:when test="${empty data}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped">
							<tr>
								<th>Orderid</th>
								<th>OrderCode</th>
								<th>ShipmentMode</th>
								<th>ExecuteType</th>
								<th>Customer</th>
								<th>RefNumber</th>
								<th>StockMode</th>
								<!-- <th>stockSource</th>
                                <th>defaultStatus</th>
                                 <th>saleOrdDesc</th>-->
								<th colspan="5">OPERATION</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.orderId}"></c:out></td>
									<td><c:out value="${d.orderCode}"></c:out></td>
									<td><c:out value="${d.shipmentMode}"></c:out></td>
									<td><c:out value="${d.customer}"></c:out></td>
									<td><c:out value="${d.refNumber}"></c:out></td>
									<td><c:out value="${d.stockMode}"></c:out></td>
									<%-- <td><c:out value="${d.stockSource}"></c:out></td>
      								<td><c:out value="${d.defaultStatus}"></c:out></td>
      								<td><c:out value="${d.saleOrdDesc}"></c:out></td> --%>

									<td><a href="delete?orderId=${d.orderId}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>

									<td><a href="viewOne?orderId=${d.orderId}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>

									<td><a href="editOne?orderId=${d.orderId}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>

									<td><a href="excelOne?orderId=${d.orderId}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

									<td><a href="pdfOne?orderId=${d.orderId}"> <img
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
				<!-- card-footer end-->
			</c:if>

		</div>
		<!-- Card class end -->

	</div>
	<!-- Container class end  -->
</body>
</html>