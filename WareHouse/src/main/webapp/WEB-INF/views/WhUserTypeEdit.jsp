<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h1 style="color: red; text-align: center">Registration form of
					Warehouse UserType</h1>
			</div>


			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="whuserType">


					<div class="row">
						<div class="col-4">
							<label for="whid">User Id:</label>
						</div>
						<div class="col-6">
							<form:input path="whid" readonly="true" />
							<form:errors path="whid" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="userType">User Type :</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="userType" value="VENDOR" />
							Vendor
							<form:radiobutton path="userType" value="WhUserType" />
							WhUserType
							<form:errors path="userType" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="userCode">User Code :</label>
						</div>
						<div class="col-6">
							<form:input path="userCode" />
							<form:errors path="userCode" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="userFor">User For :</label>
						</div>
						<div class="col-6">
							<form:input path="userFor" />
							<form:errors path="userFor" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="userEmail">User Email :</label>
						</div>
						<div class="col-6">
							<form:input path="userEmail" />
							<form:errors path="userEmail" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="userContact">User Contact :</label>
						</div>
						<div class="col-6">
							<form:input path="userContact" />
							<form:errors path="userContact" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="userContact">User IDType :</label>
						</div>
						<div class="col-6">
							<form:select path="userIdType">
								<form:option value="">--select--</form:option>
								<form:option value="PAN CARD">PAN CARD</form:option>
								<form:option value="AADHAR">AADHAR</form:option>
								<form:option value="VOTERID">VOTERID</form:option>
								<form:option value="OTHER">OTHER</form:option>
							</form:select>
							<form:errors path="userIdType" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="userContact">ID Number :</label>
						</div>
						<div class="col-6">
							<form:input path="idnumber" />
							<form:errors path="idnumber" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit"
								value="EDIT WAREHOUSE USER TYPE">
						</div>
					</div>
				</form:form>
			</div>


		</div>
		<!-- card Ended -->

	</div>
	<!-- container ended -->
</body>
</html>