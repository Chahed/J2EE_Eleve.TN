<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Choisir la classe : </h3>
<ul>
   <c:forEach items="${classes}" var="classe">
        
           <li><a href="http://localhost:8080/spring/eleve/${classe.id}"> ${classe.nomclasse}</a></li>
            
            
     
        
    </c:forEach></ul>
 <h3>Ajouter une classe</h3>
    <form:form action="http://localhost:8080/spring/eleve/ajout" method="post">
<table>
    <tr>
      <td><input type="text"Name="a"  ></td>
      <td><input type="submit" Value="Ajouter" ></td>
    </tr>
     </table></form:form>
    
</body>
</html>