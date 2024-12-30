<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<%@ include file="./Base.jsp"%>
<!-- This includes the Bootstrap and CSS files -->
<title>Add Product</title>
<style>
.form-container {
	max-width: 600px;
	margin: 0 auto;
}

.form-group {
	margin-bottom: 15px;
}

.button-container {
	display: flex;
	justify-content: space-between;
}

.button-container button {
	width: 48%;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="form-container">
			<h2 class="text-center mb-4">Add Product</h2>
			<form action="${pageContext.request.contextPath}/submit-product" method="POST">
				<div class="form-group">
					<label for="productName">Product Name:</label> <input type="text"
						id="name" name="name" class="form-control"
						placeholder="Enter product name" required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label>
					<textarea id="description" name="description" class="form-control"
						rows="4" placeholder="Enter product description" required></textarea>
				</div>

				<div class="form-group">
					<label for="price">Price:</label> <input type="number" id="price"
						name="price" class="form-control"
						placeholder="Enter product price" step="0.01" required>
				</div>

				<div class="container text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
					<a href="${pageContext.request.contextPath}/home"
						class="btn btn-secondary">Back</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>