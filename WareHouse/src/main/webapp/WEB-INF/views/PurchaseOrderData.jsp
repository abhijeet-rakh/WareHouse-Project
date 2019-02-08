<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="UserMenu.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order Data</title>
</head>
<body>

<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">Purchase Order Detail</h1>
			</div>
			<!-- Card header end -->

			<a style="text-align: right;" href="excelall">Get all Purchase Order in Excel</a> 
			<a style="text-align: right;" href="pdfExp">Get all Purchase Order in pdf</a> <br>

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
								<th>Vendor</th>
						        <th>Reference Number</th>
                           <!-- <th>Quality Check</th> 
                                <th>Order Status</th>
                                <th>Order Desc</th>-->
								<th colspan="5">OPERATION</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.orderId}"></c:out></td>
									<td><c:out value="${d.orderCode}"></c:out></td>
									<td><c:out value="${d.shipmentMode}"></c:out></td>
									<td><c:out value="${d.vendor}"></c:out></td>
							        <td><c:out value="${d.refNum}"></c:out></td>
                                <%--<td><c:out value="${d.qualityCheck}"></c:out></td>
                                    <td><c:out value="${d.ordStatus}"></c:out></td>
                                    <td><c:out value="${d.ordDesc}"></c:out></td> --%>

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