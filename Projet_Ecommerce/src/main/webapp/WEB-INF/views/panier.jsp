<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
</head>
<body>

	<div align="right">
		<a
			href="${pageContext.request.contextPath}/Ecommerce/client/retourListeCat">Liste
			des Catégories</a>

	</div>

	<div align="center">
		<h1 style="background-color: lightgreen; color: dark">Panier</h1>
	</div>

	<div align="center">
		<form:form method="POST" action="forumlaire" modelAttribute="employe">
			<table>

				<tr bgcolor="grey" style="">

					<th>Nom</th>
					<th>Prix</th>
					<th>Quantite</th>


				</tr>
				<c:forEach var="ligne" items="${ListeArticle}">
					<tr bgcolor="lightyellow">
						<td>${ligne.produit.nom}</td>
						<td>${ligne.prix}</td>
						<td>${ligne.quantité}</td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="submit" value="Valider la commande" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</body>
</html>