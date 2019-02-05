<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>UOM Type Page</title>
<meta charset="ISO-8859-1">
</head>
<body>

<%@include file="UserMenu.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 align="center">All UOMtype Data</h1>
			</div><!-- Card header end -->

			
			<a style="text-align: right;" href="excelExp">Get All UOMType Excel</a>  
			<a style="text-align: right;" href="pdfExp">Get All UOMType Pdf</a> <br>
			<div class="card-body">
			
				<c:choose>
					<c:when test="${empty data}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped" >

							<tr>
								<th>uid</th>
								<th>uomtype</th>
								<th>uommodel</th>
								<!-- <th>uomdesc</th> -->
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.uomid}"></c:out></td>
									<td><c:out value="${d.uomtype}"></c:out></td>
									<td><c:out value="${d.uommodel}"></c:out></td>
									<%-- <td><c:out value="${d.uomdesc}"></c:out></td> --%>

									<td><a href="delete?uid=${d.uomid}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>

									<td><a href="viewOne?uid=${d.uomid}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>

									<td><a href="editOne?uid=${d.uomid}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>

									<td><a href="excelOne?uid=${d.uomid}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

									<td><a href="pdfOne?uid=${d.uomid}"> <img
											src="../resources/images/pdf.png" height="30" width="30">
									</a></td>

								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>

			</div>
			<!-- Card body end -->

			<c:if test="${message != null}">
				<div class="card-footer bg-info text-white">${message}</div><!-- card-footer end-->
			</c:if>

		</div>
		<!-- Card class end -->

	</div>
	<!-- Container class end  -->
</body>
</html>