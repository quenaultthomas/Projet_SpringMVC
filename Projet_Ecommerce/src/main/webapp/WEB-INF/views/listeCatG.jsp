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

	<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/gestio/formulaireCat">Ajouter</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/gestio/listeProdG">Liste des Produits</a>
	<a class="btn btn-default" href="<c:url value="/j_spring_security_logout"/>">Logout</a>
	

	

	<div align="right">
		<a href="retourAccueilG">Accueil</a>
	</div>

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
				<th>Modifier</th>
				<th>Supprimer</th>
				
			</tr>
			<c:forEach var="cat" items="${listeCatG}">
			<tr bgcolor="lightyellow">
				
				<td>${cat.id_c }</td>
				<td>${cat.nom }</td>
				<td>${cat.description }</td>
				<td><a href="${pageContext.request.contextPath}/Ecommerce/gestio/modifCat?IdCat=${cat.id_c}">modifier</a></td>
				<td><a href="${pageContext.request.contextPath}/Ecommerce/gestio/supprimerCat/${cat.id_c}">supprimer</a></td>	
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>