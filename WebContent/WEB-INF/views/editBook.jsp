<%@page import="common.Constant"%>
<%@page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
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
		<h2>Edit Book</h2>
	</div>
	
	
	<%
		Book book = (Book)request.getAttribute(Constant.BOOK);
	%> 
	<br />
	<div class="container">
		<form action="${pageContext.request.contextPath}/editBook" method="post">
			<input type="hidden" name="bookId" value='<%=book.getId()%>'>
			Name <br /> <input type="text" class="form-control" name="name" required value='<%=book.getName()%>' /><br /> 
			Author <br /> <input type="text" class="form-control" name="author" value='<%=book.getName()%>' required /><br /> 
			Content <br /> <input type="text" class="form-control" name="content" value='<%=book.getContent()%>' required /><br /> 
			Public time <br /><input type="number" class="form-control" name="public_time" value='<%=book.getPublicTime()%>' required /><br /> 
			Total <br /> <input type="number" class="form-control" name="total" value='<%=book.getTotal()%>' required /><br />
			<button class="btn btn-primary" type="submit">Edit</button>
		</form>
	</div>
</body>
</html>