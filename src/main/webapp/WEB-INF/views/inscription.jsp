
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ include file="/include/css.jsp" %>
<%@ include file="/include/js.jsp" %>



</head>

<body>
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
		       <li ><a href="/spring/home">Acceuil</a></li>

		        <li><a href="technology.html">Etablissement</a></li>
		        <sec:authorize ifAnyGranted="ROLE_USER">
		        <li><a href="/spring/remarque">Classes</a></li>
		        <li><a href="/spring/emplois">Emplois du temps</a></li>
		        </sec:authorize>
		        
		        <sec:authorize ifAnyGranted="ROLE_PARENT">
		         <li><a href="/spring/listEnseignants">Enseignants</a></li>
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
            <li class="active"><a href="/spring/inscP">Parent</a></li>
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


<table id="restable">

	  <thead>
	  	<tr>
	  	<th colspan='4'> Team TreeHouse Front-end Web Development Course</th>
	  </tr>
	  <tr>
	    <th>Course</th>
	    <th>Stages</th>
	    <th>Progress</th>
	    <th>Difficulty</th>
	  </tr>
	</thead>
	<tbody>
	  <tr class="htmw">
	    <td data-o="Course" >How to make a website</td>
	    <td data-o="Stages">10</td>
	    <td data-o="Progress">100%</td>
	    <td data-o="Difficulty">easy</td>
	  </tr>
	  <tr class="html">
	    <td data-o="Course" >HTML</td>
	    <td data-o="Stages">7</td>
	    <td data-o="Progress">100%</td>
	    <td data-o="Difficulty">easy</td>
	  </tr>
	  <tr class="css">
	    <td data-o="Course" >CSS Fondation</td>
	    <td data-o="Stages">13</td>
	    <td data-o="Progress">100%</td>
	    <td data-o="Difficulty">easy</td>
	  </tr>	
	  <tr class="programming">
	    <td data-o="Course" >Introduction to programming</td>
	    <td data-o="Stages">4</td>
	    <td data-o="Progress">95%</td>
	    <td data-o="Difficulty">medium</td>
	  </tr>
	  <tr class="js">
	    <td data-o="Course" >JavaScript Foundations</td>
	    <td data-o="Stages">6</td>
	    <td data-o="Progress">100%</td>
	    <td data-o="Difficulty">medium</td>
	  </tr>
	  <tr class="jquery">
	    <td data-o="Course" >jQuery Basics</td>
	    <td data-o="Stages">6</td>
	    <td data-o="Progress">100%</td>
	    <td data-o="Difficulty">medium</td>
	  </tr>
	  <tr class="accessibility">
	    <td data-o="Course" >Accessibility</td>
	    <td data-o="Stages">3</td>
	    <td data-o="Progress">33%</td>
	    <td data-o="Difficulty">easy</td>
	  </tr>
	  <tr class="optimization">
	    <td data-o="Course" >Website Optimization</td>
	    <td data-o="Stages">1</td>
	    <td data-o="Progress">0 %</td>
	    <td data-o="Difficulty">medium</td>
	  </tr>
	  <tr class="console">
	    <td data-o="Course" >Console Foundations</td>
	    <td data-o="Stages">5</td>
	    <td data-o="Progress">0 %</td>
	    <td data-o="Difficulty">medium</td>
	  </tr>
	  <tr class="git">
	    <td data-o="Course" >Git Basics</td>
	    <td data-o="Stages">6</td>
	    <td data-o="Progress">20 %</td>
	    <td data-o="Difficulty">hard</td>
	  </tr>
	  <tr class="sass">
	    <td data-o="Course" >Sass Basics</td>
	    <td data-o="Stages">4</td>
	    <td data-o="Progress">0 %</td>
	    <td data-o="Difficulty">hard</td>
	  </tr>
	</tbody>
	</table>
</body>

</html>