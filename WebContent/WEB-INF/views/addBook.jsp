<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/css/styles.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<h2>Add Book</h2>
	</div>

	<br />
	<div class="container">
		<form action="${pageContext.request.contextPath}/addBook" method="post">
		Name <br /> <input type="text" class="form-control" class="form-control" name="name" required/><br />
		Author <br /> <input type="text" class="form-control" class="form-control" name="author" required/><br />
		Content <br /> <input type="text" class="form-control" name="content" required/><br />
		Public time <br /> <input type="number" class="form-control" class="form-control" name="public_time" required/><br />
		Total <br /> <input type="number" class="form-control" name="total" required/><br />
		<button class="btn btn-primary" type="submit">Add</button>
	</form>
	</div>
</body>
</html>