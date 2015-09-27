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
<%@ include file="/include/header.jsp" %>

<table id="restable">

	  <thead>
	  	<tr>
	  	<th colspan='4'> La liste des Enseignants  </th>
	  </tr>
	  <tr>
	    <th>Nom & Prénom</th>
	    <th>Spécialité</th>
	    <th>Téléphone</th>
	    <th>Email</th>
	  </tr>
	</thead>
	<tbody>
	    <c:forEach items="${listenseignant}" var="e">
        <tr class="htmw">
            <td>${e.nom}  ${e.prenom}</td>
            <td>${e.specialite}</td>
            <td>${e.tel}</td>
            <td>${e.email}</td>
            
        </tr>
    </c:forEach>
	 
	 
	</tbody>
	</table>
	
</body>
</html>