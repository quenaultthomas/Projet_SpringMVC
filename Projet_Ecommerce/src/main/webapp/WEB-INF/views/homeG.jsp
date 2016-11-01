<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Gestio</title>
</head>
<body>

<h1
		style="background-color: lightgreen; color: darkgreen; text-align: center">${entete}</h1>

	

	<table align="center" cellspacing="10">
		<tr style="color:blue; font-style: italic; font-size: 14pt;">
			<td align="left">Cliquer Ici</td>
			<td align="right"><a href="listeCatG">Liste des Categories</a></td>
		</tr>
		<tr style="color:blue; font-style: italic; font-size: 14pt;">
			<td align="left">Cliquer Ici</td>
			<td align="right"><a href="listeProdG">Liste des Produits</a></td>
		</tr>
	</table>
	<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

</body>
</html>