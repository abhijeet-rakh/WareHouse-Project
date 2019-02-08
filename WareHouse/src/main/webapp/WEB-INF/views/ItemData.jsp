<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="UserMenu.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Detail</title>
</head>
<body>

<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">Item Detail</h1>
			</div>
			<!-- Card header end -->

			<a style="text-align: right;" href="excelall">Get all Item in Excel</a> 
			<a style="text-align: right;" href="pdfExp">Get all Item in pdf</a> <br>

			<div class="card-body">
				<c:choose>
					<c:when test="${empty data}">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover table-striped">
							<tr>
								<th>Itemid</th>
								<th>ItemCode</th>
								<th>ItemLength</th>
								<th>ItemWidth</th>
						        <th>ItemHeight</th>
                           <!-- <th>BaseCost</th> 
                                <th>BaseCurrency</th>
                                <th>ItemDesc</th>-->
								<th colspan="5">OPERATION</th>
							</tr>
							<c:forEach items="${data}" var="d">
								<tr>
									<td><c:out value="${d.itemId}"></c:out></td>
									<td><c:out value="${d.itemCode}"></c:out></td>
									<td><c:out value="${d.itemLength}"></c:out></td>
									<td><c:out value="${d.itemWidth}"></c:out></td>
							        <td><c:out value="${d.itemHeight}"></c:out></td>
                                <%--<td><c:out value="${d.baseCost}"></c:out></td>
                                    <td><c:out value="${d.baseCurrency}"></c:out></td>
                                    <td><c:out value="${d.itemDesc}"></c:out></td> --%>

									<td><a href="delete?itemId=${d.itemId}"> <img
											src="../resources/images/delete.png" height="30" width="30">
									</a></td>

									<td><a href="viewOne?itemId=${d.itemId}"> <img
											src="../resources/images/view.png" height="30" width="30">
									</a></td>

									<td><a href="editOne?itemId=${d.itemId}"> <img
											src="../resources/images/edit.png" height="30" width="30">
									</a></td>

									<td><a href="excelOne?itemId=${d.itemId}"> <img
											src="../resources/images/excel.png" height="30" width="30">
									</a></td>

									<td><a href="pdfOne?itemId=${d.itemId}"> <img
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