<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter Client</title>
</head>
<body>

<h1
		style="background-color: lightgreen; color: darkgreen; text-align: center">${entete}</h1>

	<h2
		style="background-color: lightblue; color: darkblue; font-size: 16pt; text-align: center;">${salutation}</h2>

<form:form method="POST" action="ajouter" modelAttribute="client" class="form-group">
		<table  align="center">
			<tr>
				<td><form:label path="name">Nom</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="mail">Mail</form:label></td>
				<td><form:input path="mail" /></td>
			</tr>
			<tr>
				<td><form:label path="adresse">Adresse</form:label></td>
				<td><form:input path="adresse" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">Telephone</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Valider" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>