<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<script>
	function deleteConfirm() {
		return alert("hlo..");
	}
</script>

</head>
<body>
	<a href="loadForm">Add New Product</a>
	<table class="table table-striped" border="2" id="protab">
		<thead>
			<tr>
				<th>ProductId</th>
				<th>Product Name</th>
				<th>product Qty</th>
				<th>product Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${listProducts}" var="p">
				<tr>
					<td>${p.productId}</td>
					<td>${p.productName}</td>
					<td>${p.productPrice}</td>
					<td>${p.productQuantity}</td>

					<td><a href="editstu?id=${p.productId}">Edit</a></td>
					<td><a href="deletestu?id=${p.productId}"
						onclick="deleteConfirm()">Delete</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>