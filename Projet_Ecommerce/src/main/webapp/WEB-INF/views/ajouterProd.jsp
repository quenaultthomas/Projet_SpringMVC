<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>
    
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" action="ajouterProd" modelAttribute="produit">

		<table>
			<tr>
				<td><form:input type="hidden" path="id_p"/></td>
			</tr>
			<tr>
				<td><form:label path="nom">Nom:</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="quantite">Quantite:</form:label></td>
				<td><form:input path="quantite" /></td>
			</tr>
			<tr>
				<td><form:label path="prix">Prix:</form:label></td>
				<td><form:input path="prix" /></td>
			</tr>
			<tr>
				<td><form:label path="categorie.id_c">Categorie</form:label></td>
				<td><form:input path="categorie.id_c" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Ajouter" /></td>
			</tr>
		</table>
	</form:form>
	
	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Categories</h1>
	</div>
	</br>
	

	<div align="center">
		<table class="table table-striped" style="width:50%;">
			
			<tr bgcolor="grey" style="">
				
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				
				
			</tr>
			<c:forEach var="cat" items="${listeCatG}">
			<tr bgcolor="lightyellow">
				
				<td>${cat.id_c }</td>
				<td>${cat.nom }</td>
				<td>${cat.description }</td>	
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>