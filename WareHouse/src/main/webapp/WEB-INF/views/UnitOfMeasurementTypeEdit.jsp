<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UOM Edit Form</title>
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
				<h1 style="color: red; text-align: center">Unit of Measurement
					Edit Form</h1>
			</div>

			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="unitmeasure">


					<div class="row">
						<div class="col-4">
							<label for="uomId">UOM Id :</label>
						</div>
						<div class="col-6">
							<form:input path="uomId" readonly="true"/>
							<form:errors path="uomId" />
						</div>
					</div>

                    <br>

					<div class="row">
						<div class="col-4">
							<label for="uomType">UOM Type :</label>
						</div>
						<div class="col-6">
							<form:select path="uomType">
								<form:option value="">--select--</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="NA">-NA-</form:option>
							</form:select>
							<form:errors path="uomType" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4">
							<label for="uomModel">UOM MODEL :</label>
						</div>
						<div class="col-6">
							<form:input path="uomModel" />
							<form:errors path="uomModel" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="uomdesc">UOM Description :</label>
						</div>
						<div class="col-6">
							<form:textarea path="uomDesc" />
							<form:errors path="uomDesc" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="Edit UOM" />
						</div>
					</div>

				</form:form>
			</div>

		</div>

	</div>

</body>
</html>