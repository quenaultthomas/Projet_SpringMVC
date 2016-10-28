<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Accueil Client</title>
</head>
<body>
	<h1
		style="background-color: lightgreen; color: darkgreen; text-align: center">${entete}</h1>

	<h2
		style="background-color: lightblue; color: darkblue; font-size: 16pt; text-align: center;">${salutation}</h2>

	<table align="center" cellspacing="10">
		<tr style="color:blue; font-style: italic; font-size: 14pt;">
			<td align="left">Cliquer Ici</td>
			<td align="right"><a href="listeCat">Liste des Categories</a></td>
		</tr>
		<tr style="color:blue; font-style: italic; font-size: 14pt;">
			<td align="left">Cliquer Ici</td>
			<td align="right"><a
			href="formulaire">Enregistrer vous !!</a></td>
		</tr>
	</table>
	<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
</body>
</html>