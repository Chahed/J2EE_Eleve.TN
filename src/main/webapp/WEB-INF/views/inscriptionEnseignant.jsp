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
  <c:url  var="addAction" value="/enseignant/ajout" ></c:url>
    <form:form class="form" id="form1" action="${addAction}" commandName="inscriptionEnseignant">
      
      <p >
        <input name="nom" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" placeholder="Nom"   />
      </p>
       <p >
       
        <input name="prenom" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" id="name" placeholder="Prénom" />
      </p>
       <p >
        <input name="tel" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="telephone" placeholder="Téléphone"   >
      </p>
      
      <p >
        <input name="specialite" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="name" placeholder="Spécialité"   >
      </p>
      <p >
     
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
 <%@ include file="/include/footer.jsp" %>  
</body>
</html>