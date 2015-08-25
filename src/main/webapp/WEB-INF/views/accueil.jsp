<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
</head>
<body>
<h3>Bonjour Monsieur l' admin</h3>
<a href="./enseignants">Gérer les Enseignants</a></br>
<a href="./eleve">Gérer les Eleves</a></br>
<a href="./parent">Gérer les parents</a></br>
<a href="./cours">Gérer les Cours</a></br>
<a href="./remarque">Déposer des remarques</a>

<c:url var="logoutUrl" value="j_spring_security_logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
</body>
</html>