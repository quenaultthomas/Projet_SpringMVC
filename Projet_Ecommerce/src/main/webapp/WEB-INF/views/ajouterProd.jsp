<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="POST" action="ajouterProd" >

	<table>
		<tr>
			<td><form:input type="hidden" path="id"/></td>
		</tr>
		<tr>
			<td><form:label path="nom">Nom:</form:label></td>
			<td><form:input path="nom"/></td>
		</tr>
		<tr>
			<td><form:label path="description">Description:</form:label></td>
			<td><form:input path="description"/></td>
		</tr>
		<tr>
			<td><form:label path="quantite">Quantite:</form:label></td>
			<td><form:input path="quantite"/></td>
		</tr>
		<tr>
			<td><form:label path="prix">Prix:</form:label></td>
			<td><form:input path="prix"/></td>
		</tr>
	</table>
</form:form>

</body>
</html>