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
<body>
<%@ include file="/include/header.jsp" %>

<h3>La liste des eleves dans cette classe (${id1}): </h3>
    <c:if test="${!empty P}">
    <table class="tg">
    <tr>
        <th width="80">Id</th>
        <th width="120">Nom</th>
        <th width="120">Prenom</th>
        <th width="120">Date de Naissance</th>
        <th width="60">Les Remarques</th>
        
    </tr>
    <c:forEach items="${P}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.nom}</td>
            <td>${person.prenom}</td>
            <td>${person.dateNaissance}</td>
          
            
            
            <td><a href="<c:url value='http://localhost:8080/spring/remarque/details/${person.id}' />" >Voir</a></td>
            
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>