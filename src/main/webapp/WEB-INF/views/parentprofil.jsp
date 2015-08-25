<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h3>Les Eleves de cette Classe : </h3>


<form action="http://localhost:8080/spring/parentprofil/addParentProfil" method="post">
<input type="hidden" value="${parent.id}" Name="idParent"/>
<select Name="idProfil" size="1" id="idProfil">
	<c:forEach items="${offeredProfil}" var="profil">
		<option value="${profil.nom}">${profil.nom}</option>
	</c:forEach>
</select>
<input type="submit" value="<spring:message text="Ajouter"/>"/>
</form>


<c:if test="${!empty listProfil}">
<table class="data">
<tr>
    <th><spring:message text="Enfant" /></th>

</tr>
<c:forEach items="${listProfil}" var="profil">
    <tr>
    	<td>${cours.nom}</td>
     
    </tr>
</c:forEach>
</table>
</c:if>