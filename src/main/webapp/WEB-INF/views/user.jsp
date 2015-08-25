<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>User Profile Page</title>
</head>
<body>
	
		
		<h3>Bonjour monsieur l'utilisateur</h3>
		<a href="http://localhost:8080/spring/remarque">Déposer des remarques</a>
		<c:url var="logoutUrl" value="j_spring_security_logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	

</body>
</html>