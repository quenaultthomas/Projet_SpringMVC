<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Accueil Client</title>
</head>
<body>

	<a class="btn btn-default" href="retourAccueil" role="button">Accueil</a>
	<a class="btn btn-default"
		href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat"
		role="button">Liste des Catégories</a>
	<a class="btn btn-default"
		href="${pageContext.request.contextPath}/Ecommerce/client/voirPanier"
		role="button">Panier</a>


	<h1
		style="background-color: lightgreen; color: darkgreen; text-align: center">${entete}</h1>

	<h2
		style="background-color: lightblue; color: darkblue; font-size: 16pt; text-align: center;">${salutation}</h2>

	<h3 style="text-align: center;">Vous pouvez consulter nos
		catégories de produits</h3>

	<table align="center" cellspacing="10">
		<tr style="color: blue; font-style: italic; font-size: 14pt;">
			<td align="left">Cliquer Ici : </td>
			<td align="right"><a href="listeCat">Liste des Categories</a></td>
		</tr>
	</table>

	<br>
	<br>

	<div align="center">

		<h1>Voici quelques chansons de la légende</h1>

		<iframe width="854" height="480"
			src="https://www.youtube.com/embed/IQ8OmLVn-f8" frameborder="0"
			allowfullscreen></iframe>

		<br>

		<iframe width="854" height="480"
			src="https://www.youtube.com/embed/ELKoY1qQyZA" frameborder="0"
			allowfullscreen></iframe>

		<br>

		<iframe width="854" height="480"
			src="https://www.youtube.com/embed/xMS3EBWdZ2c" frameborder="0"
			allowfullscreen></iframe>

	</div>

</body>
</html>