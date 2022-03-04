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
<title>Create Lego Set</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body style = "background: firebrick; background-size: 100% 100% ;">
	
	<div class="container mt-5 text-white">
		
		<h1>Create a Lego Set</h1>
		
		<form:form action="/legos/new" method="POST" modelAttribute="lego" class="form">

				<form:hidden path="user" value="${userId}" />

			
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
				<form:label path="price" class="form-label">Price: </form:label>
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

	</div>

</body>
</html>