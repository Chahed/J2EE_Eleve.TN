<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login | Beingjavaguys.com</title>
</head>
<body>
	<center>
		<br /> <br /> <br />
		<div style="border: 1px solid black; width: 300px; padding-top: 10px;">
			<br />Veuillez Saisir Votre Nom et Votre Mot De Passe :<br /> <span
				style="color: red">${message}</span> <br />
			<form:form method="post" action="j_spring_security_check"
				modelAttribute="users">
				<table>
					<tr>
						<td>Nom</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>Mot de passe :</td>
						<td><form:input type="password" path="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="Connexion" value="Connexion"/></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>

</body>
</html>