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
<%@ include file="/include/header.jsp" %>

<div id="form-main">
  <div id="form-div">
  <br />Veuillez Saisir Votre Nom et Votre Mot De Passe :<br /> <span
				style="color: red">${message}</span> <br />
    <form:form class="form" id="form1"  method="post" action="j_spring_security_check"
				modelAttribute="users">
      
      
       <p >
      
        <input name="username" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" placeholder="Login"  />
      </p>
    
       <p >
        <input name="password" type="password" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="password" placeholder="Password"  />
      </p>
 
     
     
      <div class="submit">
     
                <input type="submit" id="button-blue"
                    value="<spring:message text="Connexion"/>" />
           
        <div class="ease"></div>
      </div>
    </form:form>
  </div>
  </div>
   
</body>
</html>