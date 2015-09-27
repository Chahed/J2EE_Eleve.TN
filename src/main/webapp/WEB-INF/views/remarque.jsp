<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>choisir une classe</title>
<%@ include file="/include/js.jsp" %>

</head>
<body style="text-align: center">
<%@ include file="/include/header.jsp" %>


<h3>Veuillez Choisir la classe : </h3>
<ul class="list">
<li> <a href="#">Listes des classes</a>
 <ul class="item2">
   <c:forEach items="${classes}" var="classe">
        
           <li><a href="http://localhost:8080/spring/remarque/${classe.id}"> ${classe.nomclasse}</a></li>
             </c:forEach></ul>
 
  </li>   
  </ul>       
     
</body>
</html>