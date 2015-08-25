<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remarques/${id}</title>
</head>
<body>
<ul>
<c:forEach items="${P}" var="rmq">
       
            <li>${rmq.text}</li>
            
            
           
           
    </c:forEach><ul>
    
   <h3>Ajouter une remarque pour l'eleve d'id ${id} : </h3>
    <form:form action="http://localhost:8080/spring/remarque/ajout/${id}" method="post">
<table>
    <tr>
      <td><input type="textarea"  Name="a"  ></td>
      <td><input type="submit" Value="Ajouter" ></td>
    </tr>
     </table></form:form>
</body>
</html>