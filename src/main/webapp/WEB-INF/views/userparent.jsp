<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Profile Page</title>
<%@ include file="/include/js.jsp" %>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
		
		<h3>Bonjour monsieur le parent</h3>
		<a href="http://localhost:8080/spring/remarque">Consulter les profils</a>
		<c:url var="logoutUrl" value="j_spring_security_logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>


</body>
</html>