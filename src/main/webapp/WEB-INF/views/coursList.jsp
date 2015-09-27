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
	  	<th colspan='1'> La liste des cours enseignés dans notre établissement </th>
	  </tr>
	  <tr>
	    <th>Libellé</th>
	   
	  </tr>
	</thead>
	<tbody>
	    <c:forEach items="${listCours}" var="c">
        <tr class="htmw">
            <td>${c.libelle}</td>
            
        </tr>
    </c:forEach>
	 
	 
	</tbody>
	</table>
	
</body>
</html>