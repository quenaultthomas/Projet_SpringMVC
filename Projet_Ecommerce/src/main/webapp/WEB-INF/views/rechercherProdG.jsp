<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/ressources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/ressources/javascript/bootstrap.js" />"></script>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RechercherProdG</title>
</head>
<body>

<form:form method="POST" action="rechercherProd" modelAttribute="produit">

		
			
			<tr>
				<td><form:label path="keyWord">Mot-clé:</form:label></td>
				<td><form:input path="keyWord" /></td>
			</tr>
			
			
			<tr>
				<td><input type="submit" value="Rechercher" /></td>
			</tr>
	</form:form>

</body>
</html>