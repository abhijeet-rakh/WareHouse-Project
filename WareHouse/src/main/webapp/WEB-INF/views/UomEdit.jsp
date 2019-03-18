<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="UserMenu.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UOM REGISTER</title>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h1
					style="text-align: center; font-size: x-large; font-family: monospace;">WELCOME
					TO UOM REGISTER PAGE</h1>
			</div>

			<div class="card-body">

				<form:form cssClass="form" action="insert" method="post"
					modelAttribute="uom">

					<div class="row">
						<div class="col-4">
							<label for="uomId">UOM ID</label>
						</div>
						<div class="col-6">
							<form:input path="uomId" readonly="true" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="uomType">UOM TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="uomType">
								<form:option value="">--SELECT--</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="-NA-">-NA-</form:option>
							</form:select>
							<form:errors path="uomType" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="uomModel">UOM MODEL</label>
						</div>
						<div class="col-6">
							<form:input path="uomModel" />
							<form:errors path="uomModel" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="uomDsc">UOM NOTE</label>
						</div>
						<div class="col-6">
							<form:textarea path="uomDsc" />
							<form:errors path="uomDsc" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="Update Uom" />
						</div>
					</div>

					<br>

				</form:form>

			</div>
			<!-- card body close -->

			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

			<br> <a href="all"><input type="button" value="ViewAll"></a>

		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>