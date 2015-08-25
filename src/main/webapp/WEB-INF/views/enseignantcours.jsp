<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<form:form method="post" action="addEnseignantCours" commandName="enseignant">
<table>
	<tr>
		<td><spring:message text="Nom"/>: </td>
		<td>${enseignant.nom }</td>
	</tr>

	<tr>
		<td><spring:message text="Prenom"/>: </td>
		<td>${enseignant.prenom }</td>
	</tr>
<form:hidden path="id"/>
</table>
</form:form>


<form action="addEnseignantCours" method="post">
<input type="hidden" value="${enseignant.id}" Name="idEnseignant"/>
<select Name="idCours" size="1" id="idCours">
	<c:forEach items="${offeredCours}" var="cours">
		<option value="${cours.id}">${cours.libelle}</option>
	</c:forEach>
</select>
<input type="submit" value="<spring:message text="Ajouter"/>"/>
</form>


<c:if test="${!empty listCours}">
<table class="data">
<tr>
    <th><spring:message text="Cours" /></th>

</tr>
<c:forEach items="${listCours}" var="cours">
    <tr>
    	<td>${cours.libelle }</td>
     
    </tr>
</c:forEach>
</table>
</c:if>