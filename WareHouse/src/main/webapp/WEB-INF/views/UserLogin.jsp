<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<!--card header -->
			<div class="card-header bg-info text-white">
				<h2>Welcome to User Login</h2>
			</div>

			<!-- Card body -->
			<div class="card-body">

				<form action='<spring:url value="/signin"/>' method="post">
					<div class="form-group">
						<label for="username" class="control-label col-sm-4">User
							Id :</label> <input type="text" id="username" name="username"
							required="required">
					</div>

					<div class="form-group">
						<label for="password" class="control-label col-sm-4">Password
							:</label> <input type="text" id="password" name="username"
							required="required">
					</div>

					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success" />
					</div>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</form>

			</div>

		</div>
	</div>
</body>
</html>