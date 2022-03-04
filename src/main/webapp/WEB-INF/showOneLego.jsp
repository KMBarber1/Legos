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
<title>Show One Lego Set</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body style = "background: orange; background-size: 100% 100% ;">

	<div class="container mt-5 text-white">
	
		<div>

			<h1><c:out value="${lego.legoName}"/></h1>

			<h4>(added by <c:out value="${lego.user.userName}"/>)</h4>
			
			<br>
		
			<ul>
				<li>Lego Set Name: ${lego.legoName}</li>
				<li>Model #: ${lego.modelNumber}</li>
				<li># Pieces: ${lego.numberPieces} </li>
				<li>Price: ${lego.price} </li>
				<li>Description: ${lego.description} </li>
			</ul>
		
		</div>
		
		<br>
		
		<p></p>
	
		<h3>Add a rating for this Lego Set!</h3>
		
		<br>

		<div>
			<table class="table table-sm text-white">
				<thead>
					<tr>
						<th>Name</th>
						<th>Rating</th>
						<th>Comment</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rating" items="${ratings}">
						<tr>
							<td><c:out value="${rating.user.userName}"/></td>
							<td><c:out value="${rating.score }"/></td>
							<td><c:out value="${rating.comment }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		
		<br>
		
		<div>
			<form:form action="/ratings/${lego.id}" method="POST" modelAttribute="rating" class="form">

				<form:hidden path="user" value="${userId}" />
				<form:hidden path="lego" value="${lego.id}" />
				
				<form:label path="score" class="form-label">Leave a Rating 1 to 5: </form:label>
				<form:errors path="score" class="text-danger" />
				<form:input path="score" class="form-control" />
			
				<form:label path="comment" class="form-label">Comment: </form:label>
				<form:input path="comment" class="form-control" />
				<form:errors path="comment" class="text-danger" />
				
				<br>
				
				<input type="submit" value="Rate" class="btn btn-primary fw-bold">
				
			</form:form>	
				
				<br>
				
				<button type="button" class="btn btn-light"><a href="/dashboard">Dashboard</a></button>
				
		</div>
		
	</div>

</body>
</html>
