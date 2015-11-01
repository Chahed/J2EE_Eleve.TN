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
		<div class="slider_bg2"><!-- start slider -->
	<div class="container">
		<div id="da-slider" class="da-slider text-center">
			
			<div class="da-slide">
				<h2>El�ve.Tn</h2>
				<p>Espace pour les parents :<span class="hide_text">El�ve.Tn offre un espace parental pour la suivie des leurs enfants et consulter les remarques de leurs enseignants concernant chaque mati�re.</span></p>
				<h3 class="da-link"><a href="single-page.html" class="fa-btn btn-1 btn-1e">Voirplus</a></h3>
			</div>
		
	   </div>
	</div>
</div><!-- end slider -->
		
		
		<c:url var="logoutUrl" value="j_spring_security_logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

 <%@ include file="/include/footer.jsp" %>
</body>
</html>