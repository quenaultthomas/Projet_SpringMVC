<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Produits</title>
</head>
<body>

	<div align="right">
		<a href="${pageContext.request.contextPath}/Ecommerce/gestio/retourListeCatG">Liste des Catégories</a>
	</div>

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Produits</h1>
	</div>
	
	</br>
	<td><a href="formulaireProd">Ajouter</a></td>

	<div align="center">
		<table>
			
			<tr bgcolor="grey" style="">
				
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
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
				<td>${prod.categorie.id_c }</td>		
				<td><a href="modifierProd?IdProd=${prod.id_p}">modifier</a></td>
				<td><a href="supprimerProd/${prod.id_p}">supprimer</a></td>		
			</tr>
			</c:forEach>
		</table>
	</div>
<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</body>
</html>