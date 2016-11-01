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
<title>Resultat de votre recherche</title>
</head>
<body>

	<div align="right">
		<a href="${pageContext.request.contextPath}/Ecommerce/gestio/listeCatG">Liste des Catégories</a>
	</div>
	
	<div align="right">
		<a href="${pageContext.request.contextPath}/Ecommerce/gestio/listeProdG">Liste des Produits</a>
	</div>
	
	<div align="right">
		<a href="retourAccueilG">Accueil</a>
	</div>

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Liste des
			Produits correspondant à votre recherche</h1>
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
				
				
			</tr>
			<c:forEach var="prod" items="${resultG}">
			<tr bgcolor="lightyellow">
				
				<td>${prod.id_p }</td>
				<td>${prod.nom }</td>
				<td>${prod.description }</td>
				<td>${prod.prix }</td>
				<td>${prod.quantite }</td>
				<td>${prod.categorie.id_c }</td>		
					
			</tr>
			</c:forEach>
		</table>
	</div>
<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</body>
</html>