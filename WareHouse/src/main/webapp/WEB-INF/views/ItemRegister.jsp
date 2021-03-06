<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Registration Form</title>
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
				<h1 style="text-align: center;font-size:x-large;font-family: monospace;">Item Registration
					Form</h1>
			</div>

			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="item">



					<div class="row">
						<div class="col-4">
							<label for="itemCode">Item Code :</label>
						</div>
						<div class="col-6">
							<form:input path="itemCode" />
							<form:errors path="itemCode" cssClass="err" />
						</div>
					</div>

					<br>
					<div class="row">
						<div class="col-4">
							<label for="itemLength">Item Length :</label>
						</div>
						<div class="col-6">
							<form:input path="itemLength" />
							<form:errors path="itemLength" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="itemWidth">Item Width :</label>
						</div>
						<div class="col-6">
							<form:input path="itemWidth" />
							<form:errors path="itemWidth" cssClass="err" />
						</div>
					</div>

					<br>
					<div class="row">
						<div class="col-4">
							<label for="itemHeight">Item Height :</label>
						</div>
						<div class="col-6">
							<form:input path="itemHeight" />
							<form:errors path="itemHeight" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="baseCost">Base Cost :</label>
						</div>
						<div class="col-6">
							<form:input path="baseCost" />
							<form:errors path="baseCost" cssClass="err" />
						</div>
					</div>

					<br>
					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">Base Currency :</label>
						</div>
						<div class="col-6">
							<form:select path="baseCurrency">
								<form:option value="">--SELECT--</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
							<form:errors path="baseCurrency" cssClass="err" />
						</div>
					</div>

					<br>
					
					<div class="row">
						<div class="col-4">
							<label for="ItemUom">UOM Model :</label>
						</div>
						<div class="col-6">
							<form:select path="uom.uomId">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${uoms}"/>
							</form:select>
							<form:errors path="uom" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="ordercode">Order Code :</label>
						</div>
						<div class="col-6">
							<form:select path="om.oid">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${ordermethods}" itemLabel="ordercode"
									itemValue="oid" />
							</form:select>
							<form:errors path="om" cssClass="err" />
						</div>
					</div>

					<br>
                     
                     <div class="row">
						<div class="col-4">
							<label for="itemDesc">Item Desc :</label>
						</div>
						<div class="col-6">
							<form:textarea path="itemDesc" />
							<form:errors path="itemDesc" cssClass="err" />
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
            <br>
            
            <a href="all"><input type="button" value="ViewAll"></a>
		</div>

	</div>

</body>
</html>