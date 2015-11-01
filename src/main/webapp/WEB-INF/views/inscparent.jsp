<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="/include/csss.jsp" %>
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

<div class="slider_bg"><!-- start slider -->
	<div class="container">
		<div id="da-slider" class="da-slider text-center">
<div id="form-main">
  <div id="form-div">
  <c:url  var="addAction" value="/parent/ajout" ></c:url>
    <form:form class="form" id="form1" action="${addAction}" commandName="inscriptionParent">
      
      <p >
        <input name="nom" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" placeholder="Nom"   />
      </p>
       <p >
       
        <input name="prenom" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" placeholder="Prénom" />
      </p>
       <p >
        <input name="tel" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="telephone" placeholder="Téléphone"   >
      </p>

     
        <input name="email" type="text" class="validate[required,custom[email]] feedback-input" id="email" placeholder="Email" />
      </p>
      
       <p >
      
        <input name="login" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" placeholder="Login"  />
      </p>
    
       <p >
        <input name="motdepasse" type="password" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="password" placeholder="Password"  />
      </p>
 
     
     
      <div class="submit">
     
                <input type="submit" id="button-blue"
                    value="<spring:message text="Enregistrer"/>" />
           
        <div class="ease"></div>
      </div>
    </form:form>
  </div>
  </div>
  </div>
  </div>
  </div>
   <%@ include file="/include/footer.jsp" %>
</body>
</html>