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
							<label for="uomtype">UOM Type :</label>
						</div>
						<div class="col-6">
							<form:select path="uomtype">
								<form:option value="">--select--</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="NA">-NA-</form:option>
							</form:select>
							<form:errors path="uomtype" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4">
							<label for="uommodel">UOM MODEL :</label>
						</div>
						<div class="col-6">
							<form:input path="uommodel" />
							<form:errors path="uommodel" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="uomdesc">UOM Description :</label>
						</div>
						<div class="col-6">
							<form:textarea path="uomdesc" />
							<form:errors path="uomdesc" />
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