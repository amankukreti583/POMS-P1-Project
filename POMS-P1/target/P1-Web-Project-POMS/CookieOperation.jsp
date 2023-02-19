<%@page import="com.revature.Model.Cookie"%>
<%@page import="com.DatabaseConnection.ConnectionFactory"%>
<%@page import="com.revature.Dao.CookieDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<title>Display Cookie</title>
<meta content="" name="description" />
<meta content="" name="keywords" />

<!-- Favicons -->
<link href="assets/img/favicon1.png" rel="icon" />

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet" />

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet" />
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet" />

<!-- Table -->
<link rel="Stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
</head>
<body>
	<!-- ======= Header ======= -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container-fluid">
				<a style="font-size: 25px" class="navbar-brand"
					href="LandingPage.jsp">All Cookie Details</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a style="font-size: 15px"
							class="nav-link active" aria-current="page"
							href="LandingPage.jsp">Home</a></li>


					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main id="main">
		<!-- ======= Breadcrumbs ======= -->
		<!-- <div class="breadcrumbs" data-aos="fade-in">
            <div class="container">
                <h2>Pizza Oven</h2>
            </div>
        </div> -->
		<!-- End Breadcrumbs -->

		<div class="container  px-2"
			style="margin-bottom: 10%; margin-top: 10%;">

			<div class="table-responsive">

				<table id="MyTable" class="table table-striped" cellspacing="0"
					width="100%" style="padding-top: 25px; text-align: center;">

					<thead class="table-dark">
						<tr>
							<th>Cookie id</th>
							<th>Cookie Name</th>
							<th>Cookie Price</th>


							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<%
						ArrayList<Cookie> list = (ArrayList<Cookie>)(request.getAttribute("data"));
						for (Cookie cok : list) {
							CookieDao ad = new CookieDao(ConnectionFactory.getConnection());
							ArrayList<Cookie> itemList = (ArrayList<Cookie>) ad.selectCookieDetails();
						%>
						<tr>
							<td class="cid"><%=cok.getCookieId()%></td>
							<td class="cname"><%=cok.getCookieName()%></td>
							<td class="cprice"><%=cok.getCookiePrice()%></td>


							<td>

								<button class="edit btn btn-primary btn-sm" type="button"
									data-toggle="modal" data-target="#exampleModalCenter">
									Edit</button> <!-- <a href="#" data-toggle="modal" data-target="#exampleModalCenter"><i class="bi bi-pen"
									style="color: black;"></i></a> -->
							</td>
							<td><a
								href="DeleteCookieServlet?cz_id=<%=cok.getCookieId()%>"><i
									class="bi bi-trash" style="color: black;"></i></a></td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</main>
	<!-- End #main -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Edit Order
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="mx-1 mx-md-4" action="EditCookieServlet" method="post">
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="id" name="id" value=""
									class="form-control" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="name" name="name" class="form-control"
									placeholder="Enter Name" />
							</div>
						</div>
						<div class="d-flex flex-row align-items-center mb-4">
							<i class="fas fa-user fa-lg me-3 fa-fw"></i>
							<div class="form-outline flex-fill mb-0">
								<input type="text" id="price" name="price" class="form-control"
									placeholder="Enter Price" />
							</div>
						</div>
				</div>

				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Update</button>
				</form>
			</div>


		</div>
	</div>
	</div>



	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>


	<script type="text/javascript">
		$(function() {
			// ON SELECTING ROW
			$(".edit").click(function() {
				//FINDING ELEMENTS OF ROWS AND STORING THEM IN VARIABLES
				var id = $(this).parents("tr").find(".cid").text();
				var name = $(this).parents("tr").find(".cname").text();
				var category = $(this).parents("tr").find(".ccategory").text();
				var price = $(this).parents("tr").find(".cprice").text();
				var size = $(this).parents("tr").find(".csize").text();
				document.getElementById("name").value = name;
				document.getElementById("id").value = id;
				document.getElementById("category").value = category;
					
				document.getElementById("size").value = size;
				document.getElementById("price").value = price;
			});
		});
	</script>
	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script>
		$(document)
				.ready(
						function() {
							$("#MyTable")
									.DataTable(
											{
												initComplete : function() {
													this
															.api()
															.columns()
															.every(
																	function() {
																		var column = this;
																		var select = $(
																				'<select><option value=""></option></select>')
																				.appendTo(
																						$(
																								column
																										.footer())
																								.empty())
																				.on(
																						"change",
																						function() {
																							var val = $.fn.dataTable.util
																									.escapeRegex($(
																											this)
																											.val());
																							//to select and search from grid
																							column
																									.search(
																											val ? "^"
																													+ val
																													+ "$"
																													: "",
																											true,
																											false)
																									.draw();
																						});

																		column
																				.data()
																				.unique()
																				.sort()
																				.each(
																						function(
																								d,
																								j) {
																							select
																									.append('<option value="' + d + '">'
																											+ d
																											+ "</option>");
																						});
																	});
												},
											});
						});
	</script>
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
</body>
</html>







