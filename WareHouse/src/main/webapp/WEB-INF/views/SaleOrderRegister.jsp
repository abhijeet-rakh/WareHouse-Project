<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SALE ORDER REGISTER</title>
<style type="text/css">
.err {
	color: Red;
}
</style>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h1 style="text-align: center;font-size:x-large;font-family: monospace;">SALE ORDER
					REGISTRTION FORM</h1>
			</div>

			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="saleOrder">

					<div class="row">
						<div class="col-4">
							<label for="orderCode">Order Code :</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode" />
							<form:errors path="orderCode" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">Shipment Mode :</label>
						</div>
						<div class="col-6">
							<form:select path="shiptype.id">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${shipmenttype}" />
							</form:select>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="customer">Customer :</label>
						</div>
						<div class="col-6">
							<form:select path="customer">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${whservice}" />
							</form:select>
							<form:errors path="customer" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="refNumber">Reference Number :</label>
						</div>
						<div class="col-6">
							<form:input path="refNumber" />
							<form:errors path="refNumber" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="stockMode">Stock Mode :</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="stockMode" value="GRADE" />
							GRADE <br>
							<form:radiobutton path="stockMode" value="MARGIN" />
							MARGIN <br>
							<form:errors path="stockMode" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="stockSource">Stock Source :</label>
						</div>
						<div class="col-6">
							<form:select path="stockSource">
								<form:option value="">--SELECT--</form:option>
								<form:option value="OPEN">OPEN</form:option>
								<form:option value="AVAIL">AVAIL</form:option>
								<form:option value="REFUND">REFUND</form:option>
							</form:select>
							<form:errors path="stockSource" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="defaultStatus">Default Status :</label>
						</div>
						<div class="col-6">
							<form:input path="defaultStatus" />
							<form:errors path="defaultStatus" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="saleOrdDesc">Sale Order Description:</label>
						</div>
						<div class="col-6">
							<form:textarea path="saleOrdDesc" />
							<form:errors path="saleOrdDesc" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit"
								value="Create Sale Order" />
						</div>
					</div>

				</form:form>
			</div>

			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

              <br>
				
			<a href="all"><input type="button" value="ViewAll"></a>

			
		</div>

	</div>
</body>
</html>