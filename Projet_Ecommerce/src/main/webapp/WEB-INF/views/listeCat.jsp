<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Catégories</title>
</head>
<body>

<a class="btn btn-default" href="retourAccueil" role="button">Accueil</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat" role="button">Liste des Catégories</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/voirPanier" role="button">Panier</a>
<a class="btn btn-default" href="afficherCommande" role="button">Votre Commande</a>


	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Categories</h1>
	</div>


	<div align="center">
		<table class="table table-striped" style="width:50%;">
			
			<tr bgcolor="grey" style="">
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Action</th>
				
			</tr>
			<c:forEach var="cat" items="${listeCat}">
			<tr bgcolor="lightyellow">
				<td>${cat.id_c }</td>
				<td>${cat.nom }</td>
				<td>${cat.description }</td>
				
				<td><a href="listeProd/${cat.id_c}">Sélection</a></td>
<%-- 				<td><a href="editEmploye?IdEmploye=${emp.id}">Modifier</a></td> --%>
				
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>