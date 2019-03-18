<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="UserMenu.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>
</head>

<body>
	<div class="container">

		<div class="card">


			<div class="card-header bg-primary text-white">
				<h1 style="text-align: center;">UOM Data Detail</h1>
			</div>


            <a style="text-align: right;" href="excelall">Get all UOM in Excel</a> 
			<a style="text-align: right;" href="pdfExp">Get all UOM in pdf</a> <br>
            

			<!-- card header end -->
			<div class="card-body">

				<c:choose>
					<c:when test="${empty list }">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
					
						<table class="table table-bordered table-hover table-striped">
							<tr>
								<th>ID</th>
								<th>UOMTYPE</th>
								<th>UOMMODEL</th>
								<th>DESCRIPTION</th>
								<th colspan="5">OPRATIONS</th>

							</tr>
							<c:forEach items="${list}" var="st">
								
								<tr>
									<td><c:out value="${st.uomId} " /></td>
									<td><c:out value="${st.uomType} " /></td>
									<td><c:out value="${st.uomModel}" /></td>
									<td><c:out value="${st.uomDsc}" /></td>
									
									<td><a href="delete?id=${st.uomId}"> <img
											src="../resources/images/delete.png" width="30" height="30" />
									</a></td>
										
									<td><a href="viewone?id=${st.uomId}"> <img
											src="../resources/images/view.png" width="30" height="30" />
								    </a></td>
								     
									<td><a href="editone?id=${st.uomId}"><img
											src="../resources/images/edit.png" width="30" height="30" />
									</a></td>
									  
									<td><a href="exportExcelOne?id=${st.uomId}"><img
											src="../resources/images/excel.png" width="30" height="30" />
									</a></td>
									
									<td><a href="exportPdfOne?id=${st.uomId}"><img
											src="../resources/images/pdf.png" height="30" width="30" /> 
									</a></td>
	
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