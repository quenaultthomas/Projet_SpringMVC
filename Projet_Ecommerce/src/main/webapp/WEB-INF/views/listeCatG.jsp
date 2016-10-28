<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Catégories</title>
</head>
<body>

	<div align="right">
		<a href="retourAccueilG">Accueil</a>
	</div>

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Categories</h1>
	</div>
	</br>
	<td><a href="formulaireCat">Ajouter</a></td>

	<div align="center">
		<table>
			
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
				<td><a href="modifierCat?IdCat=${cat.id_c}">modifier</a></td>
				<td><a href="supprimerCat/${cat.id_c}">supprimer</a></td>	
			</tr>
			</c:forEach>
		</table>
	</div>
<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</body>
</html>