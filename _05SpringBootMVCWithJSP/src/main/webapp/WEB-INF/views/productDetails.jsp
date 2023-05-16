<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container border border-2 mt-2 rounded-4">
		${msg}
		<form:form action="register" modelAttribute="product">
			<div class="mb-3">
				<label for="Enter yor ProductName" class="form-label">ProductName</label>
				<form:input type="text" path="productName" class="form-control"
					id="formGroupExampleInput" placeholder="Example input placeholder" />
			</div>
			<div class="mb-3">
				<label for="Enter yor ProductQty" class="form-label">ProductQty</label>
				<form:input type="text" class="form-control" path="productQuantity"
					id="formGroupExampleInput2" placeholder="Another input placeholder" />
			</div>

			<div class="mb-3">
				<label for="Enter yor ProductPrice" class="form-label">ProductPrice</label>
				<form:input type="text" class="form-control" path="productPrice"
					id="formGroupExampleInput2" placeholder="Another input placeholder" />
			</div>
			<Button class="btn btn-outline-primary">submit</Button>
		</form:form>
		<a href="viewrecords">ViewProducts</a>
	</div>
</body>
</html>