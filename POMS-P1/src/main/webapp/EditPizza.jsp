<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit Pizza</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
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

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet" />

<!-- Table -->
<link rel="Stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<!-- <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script> -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>

	<form action="EditPizzaServlet" method="get">

		<div class="container pt-4">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
							<p class="fs-3 text-center">Edit Pizza</p>

							<%--  <%
              int id=Integer.parseInt(request.getParameter("Associate_id"));
              AssociateDaoImp dao = new AssociateDaoImp(ConnectionFactory.getConnection());
			  Associate a=dao.getAssociateById(id);
              %> --%>

							<form action="EditPizzaServlet" method="get">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Pizza
										Id</label> <input type="text" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										name="pid" <%-- value="<%=a.getAssociateId() %>" --%>
                  />
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Pizza
										Name</label> <input type="text" class="form-control"
										id="exampleInputPassword1" name="pname" <%--  value="<%=a.getAssociateName() %>" --%>
                  />
								</div>
								<div class="col-md-6 mb-4">
									<label for="exampleInputPassword1" class="form-label">Pizza
										Category</label> <select class="select"
										style="width: 200%; padding: 13px 10px; border-radius: 5px; color: rgb(23, 18, 18);"
										name="pcategory"<%-- value=<%=a.getAssociateTrack()%>
                    <% System.out.println(a.getAssociateTrack()); %> --%>
                   
                  >

										<option value="veg">Veg</option>
										<option value="Nonveg">Nonveg</option>

									</select>
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Pizza
										Size</label> <input type="text" class="form-control"
										id="exampleInputPassword1" name="psize" <%-- value="<%=a.getAssociateQualification() %>" --%>
                  />
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Pizza
										Price</label> <input type="text" class="form-control"
										id="exampleInputPassword1" name="pprice" <%--  value="<%=a.getAssociateExperience() %>" --%>
                  />
								</div>

								<button type="submit" class="btn btn-primary col-md-12">Update</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
			integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
			integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
			crossorigin="anonymous"></script>

	</form>
</body>
</html>































