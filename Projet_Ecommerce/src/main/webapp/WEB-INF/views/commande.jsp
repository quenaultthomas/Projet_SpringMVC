<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Récapitulatif de votre Commande</title>
</head>
<body>

<a class="btn btn-default" href="retourAccueil" role="button">Accueil</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat" role="button">Liste des Catégories</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/voirPanier" role="button">Panier</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/Ecommerce/client/afficherCommande" role="button">Votre Commande</a>


	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Votre Commande en détail</h1>
	</div>

	<div align="center">
	
	<table style="width:50%;">
	
	<tr>
				<td>Date de Commande</td>
				<td>${commande.DateDeCommande}</td>
				</tr>
				<tr>
				<td>Nom Client</td>
				<td>${client.name}</td>
				</tr>
				<tr>
				<td>Adresse</td>
				<td>${client.adresse}</td>
				</tr>
				<tr>
				<td>Cout total</td>
				<td>${panier.coutTotal}</td>
				</tr>
	
	</table>
	
	
		<table class="table table-striped">
			
			<tr bgcolor="grey" style="">
				<th>Nom</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Prix Total</th>
				
				
			</tr>
			<c:forEach var="ligne" items="${ListeArticle}">
					<tr bgcolor="lightyellow">
						<td>${ligne.produit.nom}</td>
						<td>${ligne.prix}</td>
						<td>${ligne.quantité}</td>
						<td>${ligne.quantité*ligne.prix}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>