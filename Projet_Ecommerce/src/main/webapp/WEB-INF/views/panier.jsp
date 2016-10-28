<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
</head>
<body>

<a class="btn btn-default" href="retourAccueil" role="button">Accueil</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat" role="button">Liste des Catégories</a>


	<h1
		style="background-color: lightgreen; color: darkgreen; text-align: center">${entete}</h1>

	<h2
		style="background-color: lightblue; color: darkblue; font-size: 16pt; text-align: center;">${salutation}</h2>
		
		

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Panier</h1>
	</div>

	<div align="center">
		<form:form method="POST" action="ValiderCommande" modelAttribute="employe">
			<table>

				<tr bgcolor="grey" style="">

					<th>Nom</th>
					<th>Prix unitaire</th>
					<th>Quantite</th>
					<th>Prix total</th>
					<th>Action</th>

				</tr>
				<c:forEach var="ligne" items="${ListeArticle}">
					<tr bgcolor="lightyellow">
						<td>${ligne.produit.nom}</td>
						<td>${ligne.prix}</td>
						<td>${ligne.quantité}</td>
						<td>${ligne.quantité*ligne.prix}</td>
						<td><a href="${pageContext.request.contextPath}/Ecommerce/client/deleteArticle/${ligne.produit.id_p}">Supprimer</a></td>
					</tr>
				</c:forEach>
				
				<tr>
					<td><input type="submit" value="Valider la commander" /></td>
				</tr>
								
			</table>
		</form:form>
		
		<h1>Le cout du panier est ${panier.coutTotal} euros</h1>
	</div>
</body>
</html>