<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Type Edit Form</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>

	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h1 style="color: red; text-align: center;">Shipment Type Edit
					Form</h1>
			</div>

			<div class="card-body">
				<form:form action="update" method="POST"
					modelAttribute="shipmentType">


					<div class="row">
						<div class="col-4">
							<label for="id">Shipment Id :</label>
						</div>
						<div class="col-6">
							<form:input path="id" />
							<form:errors path="id" cssClass="err" />
						</div>
					</div>

                    <br>

					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">Shipment Mode :</label>
						</div>
						<div class="col-6">
							<form:select path="shipmentMode">
								<form:option value="">--select--</form:option>
								<form:option value="Air">AIR</form:option>
								<form:option value="Truck">TRUCK</form:option>
								<form:option value="Ship">SHIP</form:option>
								<form:option value="Train">TRAIN</form:option>
							</form:select>
							<form:errors path="shipmentMode" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">Shipment Code :</label>
						</div>
						<div class="col-6">
							<form:input path="shipmentCode" />
							<form:errors path="shipmentCode" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="enableShipment">Enable Shipment :</label>
						</div>
						<div class="col-6">
							<form:select path="enableShipment">
								<form:option value="">SELECT</form:option>
								<form:option value="yes">YES</form:option>
								<form:option value="no">NO</form:option>
							</form:select>
							<form:errors path="enableShipment" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">Shipment Grade :</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="shipmentGrade" value="A" />
							A <br>
							<form:radiobutton path="shipmentGrade" value="B" />
							B <br>
							<form:radiobutton path="shipmentGrade" value="C" />
							C <br>
							<form:errors path="shipmentGrade" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">Description :</label>
						</div>
						<div class="col-6">
							<form:textarea path="desc" />
							<form:errors path="desc" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit"
								value="Register Shipment">
						</div>
					</div>
				</form:form>
			</div>
			<br>
			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>
			<br> <a href="all">Get All Data</a>

		</div>

	</div>
</body>
</html>