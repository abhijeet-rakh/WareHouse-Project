<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maharashtra WareHouse</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
	<c:set var="base">${pageContext.request.requestURL}</c:set>
	<c:set var="url"
		value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />


	<nav
		class="navbar navbar-expand-sm bg-success navbar-dark justify-content-center">
		<!-- Brand -->
		<a class="navbar-brand" href="#"><img height="30" width="30"
			src="../resources/images/logo.png" /></a>

		<!-- Links -->
		<ul class="navbar-nav">

			<!--Uom Dropdown start -->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> UOM </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/uom/register">Register </a> <a
						class="dropdown-item" href="${url}/uom/all">View All</a> 
				</div></li>
			<!--Uom Dropdown end -->

			<!-- Order Method start-->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Order Method </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/order/register">Register
					</a> <a class="dropdown-item" href="${url}/order/all">View All</a><a
						class="dropdown-item" href="${url}/order/report"> View Report </a>
				</div></li>
			<!-- Order Method end-->

			<!-- Shipment Type start-->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Shipment Type </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/shipmenttype/register">Register
					</a> <a class="dropdown-item" href="${url}/shipmenttype/all">View All</a><a
						class="dropdown-item" href="${url}/shipmenttype/report"> View Report </a>
				</div></li>
			<!-- Shipment Type end-->


			<!-- WH USER TYPE -->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Warehouse User </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/wtype/register">Register
					</a> <a class="dropdown-item" href="${url}/wtype/all">View All</a>
				</div></li>


			<!-- ITEM  -->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown">Item</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/item/register">Register </a>
					<a class="dropdown-item" href="${url}/item/all">View All</a><a
						class="dropdown-item" href="${url}/item/report"> View Report </a>


				</div></li>
			<!-- Employee -->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown">Employee</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/employee/register">Register
					</a> <a class="dropdown-item" href="${url}/employee/all">View All</a>

				</div></li>

			<!-- Purchase Order -->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown">Purchase Order</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${url}/purchaseorder/register">Register
					</a> <a class="dropdown-item" href="${url}/purchaseorder/all">View All</a><a 
					class="dropdown-item" href="${url}/purchaseorder/report">View Report</a>
				</div></li>

			<!-- Sale Order -->
			<li class="nav-item dropdown bg-secondary"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown">Sale Order</a>
				<div class="dropdown-menu ">
					<a class="dropdown-item " href="${url}/saleorder/register">Register
					</a> <a class="dropdown-item " href="${url}/saleorder/all">View All</a>
					<a class="dropdown-item " href="${url}/saleorder/report">View Report</a>
				</div></li>

			<!-- SWAGGER -->
			<%-- <li class="nav-item"><a class="nav-link"
			href="${url}/swagger-ui.html">Swagger</a></li> --%>

			<li class="nav-item bg-secondary btn-successs"><a class="nav-link text-white"
				href="${url}/logout">logout</a></li>
		</ul>
		
		<form class="form-inline" action="/action_page.php">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-success" type="submit">Search</button>
			</form>
		
	</nav>

</body>
</html>