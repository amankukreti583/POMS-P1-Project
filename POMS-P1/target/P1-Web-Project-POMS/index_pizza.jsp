<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizza</title>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Registration</title>

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
<link href="Pizza_Register/css/main.css" rel="stylesheet" media="all">
</head>
<body>


	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960">
			<div class="card card-2">
				<div class="card-heading"></div>
				<div class="card-body">
					<h2 class="title">Pizza Registration</h2>

					<c:if test="${not empty succMsg}">
						<p class="text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" />
					</c:if>


					<c:if test="${not empty errorMsg}">
						<p class="text-center text-success">${errorMsg}</p>
						<c:remove var="errorMsg"  />
					</c:if>

					<form action="AddPizzaServlet" method="post">
						<div class="input-group">
							<input class="input--style-2" type="text" placeholder="Pizza Id"
								name="pizzaId" required>
						</div>
						<div class="input-group">
							<input class="input--style-2" type="text"
								placeholder="Pizza Name" name="pizzaname" required>
						</div>

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="Size" required>
											<option disabled="disabled" selected="selected">Size</option>
											<option>Regular</option>
											<option>Medium</option>
											<option>Large</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
						</div>









						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="check" required>
									<option disabled="disabled" selected="selected">Pizza
										Type</option>
									<option>VEG</option>
									<option>NON-VEG</option>
								</select>
								<div class="select-dropdown"></div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2" type="number" placeholder="Price"
										name="res_code" required>
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