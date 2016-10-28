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
		<a href="retourAccueil">Accueil</a>
		<a href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat">Liste des Catégories</a>
		<a href="${pageContext.request.contextPath}/Ecommerce/client/voirPanier">Panier</a>
	</div>

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Produits</h1>
	</div>

	<div align="center">
		<table>
			
			<tr bgcolor="grey" style="">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				
			</tr>
			<c:forEach var="prod" items="${listeProd}">
			<tr bgcolor="lightyellow">
				<td>${prod.id_p }</td>
				<td>${prod.nom }</td>
				<td>${prod.description }</td>
				<td>${prod.prix }</td>
				
				<td><a href="${pageContext.request.contextPath}/Ecommerce/client/AjouterAuPanier/${prod.id_p}/1/${prod.categorie.id_c}">Ajouter au Panier</a></td>				
			</tr>
			</c:forEach>
		</table>
	</div>
<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</body>
</html>