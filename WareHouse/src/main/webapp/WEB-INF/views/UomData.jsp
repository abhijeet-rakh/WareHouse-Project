<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.catalina.Session" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>
</head>
<%-- 
<body bgcolor="skyblue">
	<center>
	
			<h2>
				<b><div style="cue-after: none; color: maroon;">WELCOME TO UOM DATA PAGE</b>
			</h2>
			<img  src="../resources/imgs/bg.jpg" width="1400"
				height="350">
 --%>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">


			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO UOM DATA PAGE</h2>
			</div>
			<!-- card header end -->

			<div class="card-body">

				<c:choose>
					<c:when test="${empty list }">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
					
						<table class="table table-bordered table-hover table table-striped table-dark bg-success">
							<tr class="thead-dark">
								<th>ID</th>
								<th>UOMTYPE</th>
								<th>UOMMODEL</th>
								<th>DESCRIPTION</th>
								<th>OPRATIONS</th>

							</tr>
							<c:forEach items="${list}" var="st">
								
								<tr>
									<td><c:out value="${st.uomId} " /></td>
									<td><c:out value="${st.uomType} " /></td>
									<td><c:out value="${st.uomModel}" /></td>
									<td><c:out value="${st.uomDsc}" /></td>
									
									<td><a href="delete?id=${st.uomId}"> <img
											src="../resources/imgs/delete.png" width="35" height="30" /></a>
										<a href="viewone?id=${st.uomId}"> <img
											src="../resources/imgs/view.png" width="35" height="30" /></a> <a
										href="editone?id=${st.uomId}"><img
											src="../resources/imgs/edit.png" width="30" height="30" /></a>  <a
										href="exportExcelOne?id=${st.uomId}"><img
											src="../resources/imgs/excel.jpg" width="30" height="30" /></a>
										<a href="exportPdfOne?id=${st.uomId}"><img
											src="../resources/imgs/pdf.png" height="20" width="20" /> </a></td>
								</tr>

							</c:forEach>

						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- card body class end -->
			<br> <a href="register"><input type="button"
				value="BackRegPage"></a>

			<c:if test="${message != null}">
				<div class="card-footer bg-danger text-white">${message}</div>
			</c:if>


		</div>
		<!-- card class end -->
	</div>
	<!--  container class end -->
	<a href="excelExp">Export Excel</a>
</body>

</html>