<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Produits</title>
</head>
<body>

	
	<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/gestio/formulaireProd">Ajouter</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/gestio/rechercherFormProd">Rechercher</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/gestio/listeCatG">Liste des Catégories</a>
	<a class="btn btn-default" href="<c:url value="/j_spring_security_logout"/>">Logout</a>

	
		
	
	
	

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Produits</h1>
	</div>
	
	</br>
		

	<div align="center">
		<table class="table table-striped" style="width:50%;">
			
			<tr bgcolor="grey" style="">
				
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Categorie</th>
				<th>Modifier</th>
				<th>Supprimer</th>
				
			</tr>
			<c:forEach var="prod" items="${listeProdG}">
			<tr bgcolor="lightyellow">
				
				<td>${prod.id_p }</td>
				<td>${prod.nom }</td>
				<td>${prod.description }</td>
				<td>${prod.prix }</td>
				<td>${prod.quantite }</td>
				<td>${prod.categorie.id_c }</td>		
				<td><a href="${pageContext.request.contextPath}/Ecommerce/gestio/modifierProd?IdProd=${prod.id_p}">modifier</a></td>
				<td><a href="${pageContext.request.contextPath}/Ecommerce/gestio/supprimerProd/${prod.id_p}">supprimer</a></td>	
			</tr>
			</c:forEach>
		</table>
		
	
		
		
	</div>

</body>
</html>