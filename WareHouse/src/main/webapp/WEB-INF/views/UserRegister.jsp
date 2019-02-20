<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="UserMenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<h1 style="color: red; text-align: center">User Registration
					Form</h1>
			</div>

			<div class="card-body">
				<form:form action="insert" method="POST" modelAttribute="user">


					<div class="row">
						<div class="col-4">
							<label for="userName">User Name :</label>
						</div>
						<div class="col-6">
							<form:input path="userName" />
							<form:errors path="userName" cssClass="err" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="mail">User Email :</label>
						</div>
						<div class="col-6">
							<form:input path="mail" />
							<form:errors path="mail" cssClass="err" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-4">
							<label for="mobile">User Mobile No. :</label>
						</div>
						<div class="col-6">
							<form:input path="mobile" />
							<form:errors path="mobile" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="password">User Password :</label>
						</div>
						<div class="col-6">
							<form:password path="password" />
							<form:errors path="password" cssClass="err" />
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-4">
							<label for="roles">Roles :</label>
						</div>
						<div class="col-6">
							<form:checkbox path="roles" value="ADMIN" />
							ADMIN
							<form:checkbox path="roles" value="APP USER" />
							APP USER
							<form:errors path="roles" cssClass="err" />
						</div>
					</div>

					<br>


					<div class="row">
						<div class="col-4"></div>
						<div class="col-6">
							<input class="btn btn-primary" type="submit"
								value="Register User">
						</div>
					</div>
				</form:form>

			</div>

			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

			<br> <a href="all"><input type="button" value="ViewAll"></a>

		</div>
	</div>
</body>
</html>