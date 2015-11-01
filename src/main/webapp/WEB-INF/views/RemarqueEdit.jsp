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
<div class="header_bg">
<div class="container">
	<div class="row header">
		<div class="logo navbar-left">
			<h1><a href="index.html">Elève.TN </a></h1>
		</div>	
		<div class="h_search navbar-right">
			<form>
				<input type="text" class="text" value="Enter text here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter text here';}">
				<input type="submit" value="Search">
			</form>
		</div>
	
		<div class="clearfix"></div>
	</div>
</div>
</div>
<div class="container">
	<div class="row h_menu">
		<nav class="navbar navbar-default navbar-left" role="navigation">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        
		      </button>
		     <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      <sec:authorize ifNotGranted="ROLE_USER,ROLE_PARENT,ROLE_ADMIN">  
		       <li ><a href="/spring/home">Acceuil</a></li>
		        <li><a href="technology.html">Etablissement</a></li>
		           </sec:authorize>
		        <sec:authorize ifAnyGranted="ROLE_USER">
		          <li ><a href="/spring/user">Acceuil</a></li>
		            <li><a href="technology.html">Etablissement</a></li>
		        <li class="active"><a href="/spring/remarque">Classes</a></li>
		        <li><a href="/spring/emplois">Emplois du temps</a></li>
		        </sec:authorize>
		        
		        <sec:authorize ifAnyGranted="ROLE_PARENT">
		         <li class="active"><a href="/spring/userparent">Acceuil</a></li>
		           <li><a href="technology.html">Etablissement</a></li>
		         <li><a href="/spring/listEnseignants">Enseignants</a></li>
		         <li><a href="/spring/coursList">Cours</a></li>
		        <li ><a href="/spring/remarque">Classes</a></li>
		        <li><a href="/spring/emplois">Emplois du temps</a></li>
		        </sec:authorize>
				
		        
		      </ul>
		    </div><!-- /.navbar-collapse -->
		    <!-- start soc_icons -->
		</nav>
		<div class=" collapse navbar-collapse" >
			<ul class="nav  navbar-nav navbar-right">
			<li class="dropdown">
			<sec:authorize ifNotGranted="ROLE_USER,ROLE_PARENT"> 
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">S'inscrire <b class="caret"></b></a>
        <ul class="dropdown-menu" class="item">
            <li><a href="/spring/inscEnseignant">Enseignant</a></li>
            <li><a href="/spring/inscP">Parent</a></li>
        </ul>
        </sec:authorize>
    </li>
    <sec:authorize ifNotGranted="ROLE_USER,ROLE_PARENT">  
		<li><a href="/spring/login">Se connecter</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_PARENT,ROLE_USER">
		<li><c:url value="/j_spring_security_logout" var="logoutUrl" />
             <a href="${logoutUrl}">Se déconnecter</a> </li>
		</sec:authorize>



    

			</ul>	
		</div>
	</div>
</div>

<div class="slider_bg2"><!-- start slider -->
	<div class="container">
		<div id="da-slider" class="da-slider text-center">

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
</div>
</div>
</div>
 <%@ include file="/include/footer.jsp" %>
</body>
</html>