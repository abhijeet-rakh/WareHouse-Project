<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WareHouse User Type</title>
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
				<h1 style="text-align: center;font-size:x-large;font-family: monospace;">WAREHOUSE USER TYPE REGISTER PAGE</h1>
			</div>

			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="whUserType">

                    					<div class="row">
						<div class="col-4">
							<label for="whId">User Code:</label>
						</div>
						<div class="col-6">
							<form:input path="whId" readonly="true"/>
							<form:errors path="whId" cssClass="err"/>
						</div>
					</div>
                    
                     <br>

					<div class="row">
						<div class="col-4">
							<label for="whType">User Type:</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="whType" value="VENDOR" />
							Vendor <br>
							<form:radiobutton path="whType" value="CUSTOMER" />
							Customer <br>
							<form:errors path="whType" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whCode">User Code:</label>
						</div>
						<div class="col-6">
							<form:input path="whCode" />
							<form:errors path="whCode" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whFor">User FOR:</label>
						</div>
						<div class="col-6">
							<form:select path="whFor">
								<form:option value="">--Select--</form:option>
								<form:option value="PURCHASE">Purchase</form:option>
								<form:option value="SALE">Sale</form:option>
							</form:select>
							<form:errors path="whFor" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whEmail">User Email:</label>
						</div>
						<div class="col-6">
							<form:input path="whEmail" />
							<form:errors path="whEmail" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whContact">User Contact:</label>
						</div>
						<div class="col-6">
							<form:input path="whContact" />
							<form:errors path="whContact" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whIdType">User ID Type:</label>
						</div>
						<div class="col-6">
							<form:select path="whIdType">
								<form:option value="">--select--</form:option>
								<form:option value="PANCARD">PAN-CARD</form:option>
								<form:option value="AADAR">AADAR</form:option>
								<form:option value="VOTERID">VOTER-ID</form:option>
								<form:option value="OTHER">OTHER-CARD</form:option>
							</form:select>
							<form:errors path="whIdType" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whIdOther">If Other:</label>
						</div>
						<div class="col-6">
							<form:input path="whIdOther" />
							<form:errors path="whIdOther" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="whIdNumber">Id Number:</label>
						</div>
						<div class="col-6">
							<form:input path="whIdNumber" />
							<form:errors path="whIdNumber" cssClass="err"/>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="Update User" />
						</div>
					</div>
				</form:form>
			</div>
            		
         </div>
		<!-- card end -->
	</div>
	<!-- container end -->



</body>
</html>