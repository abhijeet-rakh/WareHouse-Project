<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Order Method</title>
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
				<h1 style="color: red; text-align: center;">Order Method
					Edit Form</h1>
			</div>

			<div class="card-body">
				<form:form action="update" method="post"
					modelAttribute="orderMethod">
					

                  <div class="row">
						<div class="col-4">
							<label for="oid">Order Id :</label>
						</div>
						<div class="col-6">
							<form:input path="oid" readonly="true"/>
							<form:errors path="oid" cssClass="err" />
						</div>
					</div>
					<br>
                  

					

					<div class="row">
						<div class="col-4">
							<label for="ordermode">Order Mode :</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="ordermode" value="SALE" />
							Sale <br>
							<form:radiobutton path="ordermode" value="PURCHASE" />
							Purchase <br>
							<form:errors path="ordermode" cssClass="err" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4">
							<label for="ordercode">Order Code :</label>
						</div>
						<div class="col-6">
							<form:input path="ordercode" />
							<form:errors path="ordercode" cssClass="err" />
						</div>
					</div>



					<br>

					<div class="row">
						<div class="col-4">
							<label for="executetype">Execute Type :</label>
						</div>
						<div class="col-6">
							<form:select path="executetype">
								<form:option value="">--select--</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
							</form:select>
							<form:errors path="executetype" cssClass="err" />
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-4">
							<label for="orderaccept">Order Accept :</label>
						</div>
						<div class="col-6">
							<form:checkbox path="orderaccept" value="MULTI-MODEL" />
							Multi-Model <br>
							<form:checkbox path="orderaccept" value="ACCEPT-RETURN" />
							Accept-Return <br>
							<form:checkbox path="orderaccept" value="SERVICE-EXTEND" />
							Service-Return <br>
							<form:errors path="orderaccept" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="orderdesc">Order Description :</label>
						</div>
						<div class="col-6">
							<form:textarea path="orderdesc" />
							<form:errors path="orderdesc" cssClass="err" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="Update Item" />
						</div>
					</div>
					<br>
				</form:form>
			</div>
			<br>

		</div>

	</div>
</body>
</html>