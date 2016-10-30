<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Produits</title>
</head>
<body>

<a class="btn btn-default" href="retourAccueil" role="button">Accueil</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat" role="button">Liste des Catégories</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/voirPanier" role="button">Panier</a>


	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Produits</h1>
	</div>

	<div align="center">
		<table class="table table-striped">
			
			<tr bgcolor="grey" style="">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Action</th>
				
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
</body>
</html>