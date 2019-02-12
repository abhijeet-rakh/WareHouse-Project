<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order Register</title>
<style type="text/css">
.err {
	color: Red;
}
</style>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header  bg-info text-white">
				<h1 style="color: red; text-align: center;">Purchase
					Registration Form</h1>
			</div>

			<div class="card-body">
				<form:form action="insert" method="post"
					modelAttribute="purchaseOrder">

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
							<form:select path="shipmentMode">
								<form:option value="">--SELECT--</form:option>
								<form:option value="AIR">AIR</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIP">SHIP</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
							</form:select>
							<form:errors path="shipmentMode" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="vendor">Vendor :</label>
						</div>
						<div class="col-6">
							<form:select path="vendor">
								<form:option value="">--SELECT--</form:option>
								<form:option value="A">A</form:option>
								<form:option value="B">B</form:option>
								<form:option value="C">C</form:option>
								<form:option value="D">D</form:option>
							</form:select>
							<form:errors path="vendor" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="refNum">Reference Number :</label>
						</div>
						<div class="col-6">
							<form:input path="refNum" />
							<form:errors path="refNum" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="qualityCheck">Quality Check :</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="qualityCheck" value="Required" />
							Required
							<form:radiobutton path="qualityCheck" value="Not-Required" />
							Not Required
							<form:errors path="qualityCheck" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="ordStatus">Order Status :</label>
						</div>
						<div class="col-6">
							<form:input path="ordStatus" />
							<form:errors path="ordStatus" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="UserCode">User Code :</label>
						</div>
						<div class="col-6">
						    <form:select path="whusertype.whid">
							<form:option value="">--SELECT--</form:option>
							<form:options items="${whusertype}" itemLabel="userCode"
								itemValue="whid" />
							</form:select>
						</div>
					</div>

                   <br>

                    <div class="row">
						<div class="col-4">
							<label for="ShipmentCode">Shipment Code :</label>
						</div>
						<div class="col-6">
						    <form:select path="shiptype.id">
							<form:option value="">--SELECT--</form:option>
							<form:options items="${shipmenttype}" itemLabel="shipmentCode"
								itemValue="id" />
							</form:select>
						</div>
					</div>
                     
					<br>

					<div class="row">
						<div class="col-4">
							<label for="ordDesc">Order Desc :</label>
						</div>
						<div class="col-6">
							<form:textarea path="ordDesc" />
							<form:errors path="ordDesc" cssClass="err" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit"
								value="Register Item" />
						</div>
					</div>

				</form:form>
			</div>

			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

			<br> <a href="all">View all Purchase Order</a> <br> <br>
		</div>

	</div>

</body>
</html>