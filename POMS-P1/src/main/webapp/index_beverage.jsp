<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Beverage Registration</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>

<!-- Icons font CSS-->
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">
</head>
<body>

<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container-fluid">
				<a style="font-size: 25px" class="navbar-brand" href="home.jsp">All Beverage Details</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a style="font-size: 15px;margin-left: 900px;"
							class="nav-link active" aria-current="page"
							href="LandingPage.jsp">Home</a></li>


					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960" style="max-width: 1120px;margin-top:18px; display: flex">
			<div class="card card-2">
			<div><img style="margin: -3px;margin-bottom: -398px;" src="https://images.pexels.com/photos/15485498/pexels-photo-15485498.jpeg?auto=compress&cs=tinysrgb&w=400"></div>
				<!-- <div class="card-heading"></div> -->
				<div class="card-body">
					<h2 class="title">Beverage Registration</h2>
					<c:if test="${not empty succMsg}">
						<p style="font-size: 15px; color: green; text-align: center;
						" class="text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" />
					</c:if>


					<c:if test="${not empty errorMsg}">
						<p style="font-size: 15px; color: red; text-align: center;
						"  class="text-center text-success">${errorMsg}</p>
						<c:remove var="errorMsg" />
					</c:if>
					
					<form action="AddBeverageServlet" method="POST">
						<div class="input-group">
							<input class="input--style-2" type="text"
								placeholder="Beverage Id" name="bid" required>
						</div>
						<div class="input-group">
							<input class="input--style-2" type="text"
								placeholder="Beverage Name" name="bname" required>
						</div>

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="btype" required>
											<option disabled="disabled" selected="selected">Type</option>
											<option>HOT</option>
											<option>COLD</option>

										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
						</div>


						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2" type="number" placeholder="Price"
										name="bprice" required>
								</div>
							</div>
						</div>
						<div class="p-t-30">
							<button class="btn btn--radius btn--green" type="submit">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Jquery JS-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="js/global.js"></script>
</body>
</html>