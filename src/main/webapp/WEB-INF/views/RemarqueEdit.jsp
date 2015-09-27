<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#button{
	font-family: 'Montserrat', Arial, Helvetica, sans-serif;
	
	width: 30%;
	border: #fbfbfb solid 4px;
	cursor:pointer;
	background-color: #FF5454;
	color:white;
	font-size:14px;
	padding-top:10px;
	padding-bottom:10px;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
  margin-top:-4px;
  font-weight:500;
}

#button:hover{
	background-color: rgba(0,0,0,0);
	color: #FF5454;
}
	
.submit:hover {
	color: #FF5454;
}
</style>
<title>Profil</title>
<%@ include file="/include/csss.jsp" %>
<%@ include file="/include/js.jsp" %>

</head>
<body >
<%@ include file="/include/header.jsp" %>


<div >
	<div class="accordion">
		<a href="#" class="active"><i class="fa fa-user"></i> Profil </a>
		<div class="sub-nav active">
			<div class="html about-me">
				<div class="photo">
					<div class="photo-overlay">
						<span class="plus">+</span>
					</div>
				</div>
				<h4>${profil.nom} ${profil.prenom} </h4>
				<h4>Né(e) le :${profil.dateNaissance} </h4>
				<h4>Inscrit sous classe: C1 </h4>
				<div class="social-link">
					<a class="link link-twitter" href="http://twitter.com/khadkamhn/" target="_blank"><i class="fa fa-twitter"></i></a>			
					<a class="link link-facebook" href="http://facebook.com/khadkamhn/" target="_blank"><i class="fa fa-facebook"></i></a>

				</div>
			</div>
		</div>
		
		<a href="#"><i class="fa fa-plus"></i> Ajouter une  Remarque</a>
		<div class="sub-nav" >
			<div class="html chat">
				
				<div class="user user-dribble clearfix" >
					<form:form action="http://localhost:8080/spring/remarque/ajout/${id}" method="post">
					<span class="text-msg"><input type="textarea"  Name="a"  ></span>
					<span><input type="submit"   value="Ajouter" id="button" /></span> 
					</form:form>
				</div>
				
			</div>
		</div>
		
		<a href="#"><i class="fa fa-edit"></i>  Remarques</a>
		<div class="sub-nav">
			<div class="html chat">
				<c:forEach items="${P}" var="rmq">
				<div class="user user-dribble clearfix">
					<span class="photo pull-left" data-username="dribbble"><i class="fa fa-user"></i></span>
					<span class="text-msg">${rmq.text}</span>
				</div>
				</c:forEach>
			</div>
		</div>
		
		
	</div>
</div>

</body>
</html>