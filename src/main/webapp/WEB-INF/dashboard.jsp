<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body style = "background: gold; background-size: 100% 100% ;">

	<div class="container mt-5">
	
		<div>
		
			<button type="button" class="btn btn-light"><a href="/logout">Logout</a></button>
			
			<p></p>
			
			<br>
			
			<p></p>
			
			<br>
			
			<h1>Welcome, <c:out value = "${userName}"/>!</h1>
			
			<br>
			
			<h3>Lego Sets:</h3>
		</div>
		
			<br>
		
		<div>
			<table class="table table-sm">
				<thead>
					<tr>
						<th>Lego Set Name</th>
						<th></th>
						<th>Model #</th>
						<th># Pieces</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="oneLego" items="${legos }">
						<tr>
							<td><a href="/legos/${oneLego.id}"><c:out value="${oneLego.legoName }" /></a></td>
							<td><c:if test="${oneLego.user.id == userId }">
							<button type="button" class="btn btn-light"><a href="/legos/edit/${oneLego.id}">Edit</a></button></c:if></td>
							<td>${oneLego.modelNumber } </td>
							<td>${oneLego.numberPieces } </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<button type="button" class="btn btn-light"><a href="/legos/new">Add a Lego Set</a></button>
		
	</div>

</body>
</html>