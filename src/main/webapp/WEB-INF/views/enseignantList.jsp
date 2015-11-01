<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Eleves</title>
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
		    </div>
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      <sec:authorize ifNotGranted="ROLE_USER,ROLE_PARENT,ROLE_ADMIN">  
		       <li ><a href="/spring/home">Acceuil</a></li>
		        <li><a href="technology.html">Etablissement</a></li>
		           </sec:authorize>
		        <sec:authorize ifAnyGranted="ROLE_USER">
		        <li><a href="/spring/remarque">Classes</a></li>
		        <li><a href="/spring/emplois">Emplois du temps</a></li>
		        </sec:authorize>
		        
		        <sec:authorize ifAnyGranted="ROLE_PARENT">
		         <li ><a href="/spring/userparent">Acceuil</a></li>
		           <li><a href="technology.html">Etablissement</a></li>
		         <li class="active"><a href="/spring/listEnseignants">Enseignants</a></li>
		         <li><a href="/spring/coursList">Cours</a></li>
		        <li><a href="/spring/remarque">Classes</a></li>
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
<table id="restable">

	  <thead>
	  	<tr>
	  	<th colspan='5'> La liste des Enseignants  </th>
	  </tr>
	  <tr>
	    <th>Nom & Prénom</th>
	    <th>Spécialité</th>
	    <th>Téléphone</th>
	    <th>Email</th>
	    <th></th>
	  </tr>
	</thead>
	<tbody>
	    <c:forEach items="${listenseignant}" var="e">
        <tr class="htmw">
            <td>${e.nom}  ${e.prenom}</td>
            <td>${e.specialite}</td>
            <td>${e.tel}</td>
            <td>${e.email}</td>
            <td><a href="mailto:sirineghezaiel1993@gmail.com" >Contacter</a></td>
        </tr>
    </c:forEach>
	 
	 
	</tbody>
	</table>
</div>
</div>
</div>	
 <%@ include file="/include/footer.jsp" %>
</body>
</html>