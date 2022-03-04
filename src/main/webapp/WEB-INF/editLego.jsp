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
<title>Edit Lego</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body style = "background: green; background-size: 100% 100% ;">

	<div class="container mt-5 text-white">
		
		<h1><c:out value = "${lego.legoName}"/></h1>
		
		<form:form action="/legos/edit/${lego.id}" method="POST" modelAttribute="lego" class="form">
			<input type="hidden" name="_method" value="put"/>
			
			<form:hidden path="user" value="${lego.user.id}" />

			<div>
				<form:label path="legoName" class="form-label">Lego Set Name:</form:label>
				<form:errors path="legoName" class="text-dangert"/>
				<form:input path="legoName" class="form-label"/>
			</div>

			<div>
				<form:label path="modelNumber" class="form-label">Model #: </form:label>
				<form:input path="modelNumber" class="form-control" />
				<form:errors path="modelNumber" class="text-danger" />
			</div>
			
			<div>
				<form:label path="numberPieces" class="form-label"># Pieces: </form:label>
				<form:input path="numberPieces" class="form-control" />
				<form:errors path="numberPieces" class="text-danger" />
			</div>

 			<div>
				<form:label path="price" class="form-label">Drop in Price: </form:label>
				<form:input path="price" class="form-control" />
				<form:errors path="price" class="text-danger" />
			</div>
 
			<div>
				<form:label path="description" class="form-label">Description: </form:label>
				<form:input path="description" type="description" class="form-control" />
				<form:errors path="description" class="text-danger" />
			</div>
			
			<br>
			
			<input type="submit" value="Submit" class="btn btn-dark fw-bold">

		</form:form>
		
			<br>
		
			<button type="button" class="btn btn-light"><a href="/dashboard">Cancel</a></button>
			
			<div>
				<br>
				<form action="/legos/${lego.id }" method="POST">
				<input type="hidden" name="_method" value="delete" />
				<button class="btn btn-warning">Delete</button></form>
			</div>
			
	</div>

</body>
</html>