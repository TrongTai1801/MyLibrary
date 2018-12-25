<%@page import="model.Book"%>
<%@page import="common.Constant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
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
		<h2>List Books</h2>
	</div>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<div class="container">
			<a href="${pageContext.request.contextPath}/addBook"
				class="btn btn-info btn-lg"> <span
				class="glyphicon glyphicon-plus"></span> Add Book
			</a>
		</div>
		<br/>
		<div class="container">
			<form class="form-inline"
				action="${pageContext.request.contextPath}/searchBook" method="post">
				<input class="form-control" type="text" name="search"
					placeholder="Search" required>
				<button class="btn btn-primary" type="submit">Search</button>
			</form>
		</div>
		<br />
	</div>

	<div class="container">
		<table class="table table-striped">
			<tr>
				<th>Name</th>
				<th>Author</th>
				<th>Content</th>
				<th>Public time</th>
				<th>Total</th>
				<th></th>
				<th></th>
			</tr>

			<%
				ArrayList<Book> listBook = new ArrayList<>();
				listBook = (ArrayList<Book>) request.getAttribute(Constant.LIST_BOOK);
				for (int i = 0; i < listBook.size(); i++) {
			%>
			<tr>
				<td>
					<%
						out.print(listBook.get(i).getName());
					%>
				</td>
				<td>
					<%
						out.print(listBook.get(i).getAuthor());
					%>
				</td>
				<td>
					<%
						out.print(listBook.get(i).getContent());
					%>
				</td>
				<td>
					<%
						out.print(listBook.get(i).getPublicTime());
					%>
				</td>
				<td>
					<%
						out.print(String.valueOf(listBook.get(i).getTotal()));
					%>
				</td>
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/editBook">
						<input type="hidden" name="bookId" value='<%=String.valueOf(listBook.get(i).getId())%>'>
						<button class="btn btn-primary" type="submit">Edit</button>
					</form>
				</td>
				<td>
					<form method="post"
						action="${pageContext.request.contextPath}/deleteBook">
						<input type="hidden" name="bookId" value='<%=String.valueOf(listBook.get(i).getId())%>'>
						<button class="btn btn-danger" type="submit">Delete</button>
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>