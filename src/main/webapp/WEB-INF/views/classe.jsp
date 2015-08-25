<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

<title>Eleves</title>
</head>
<body>
<h1>
  Ajouter Un Eleve à cette classe : 
</h1>
 
<c:url var="addAction" value="http://localhost:8080/spring/eleve/${id1}/ajout" ></c:url>
 
<form:form action="${addAction}" commandName="eleve">
<table>
    <c:if test="${!empty eleve.nom}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="nom">
                <spring:message text="Nom"/>
            </form:label>
        </td>
        <td>
            <form:input path="nom" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="prenom">
                <spring:message text="Prenom"/>
            </form:label>
        </td>
        <td>
            <form:input path="prenom" />
        </td>
    </tr>
            <tr>
        <td>
            <form:label path="dateNaissance">
                <spring:message text="Date de Naissance"/>
            </form:label>
        </td>
        <td>
            <form:input path="dateNaissance" />
        </td> 
    </tr>
  
    <tr>
        <td colspan="2">
            <c:if test="${!empty eleve.nom}">
                <input type="submit"
                    value="<spring:message text="Modifier"/>" />
            </c:if>
            <c:if test="${empty eleve.nom}">
                <input type="submit"
                    value="<spring:message text="Ajouter"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>La liste des eleves dans cette classe (${id1}): </h3>
    <c:if test="${!empty P}">
    <table class="tg">
    <tr>
        <th width="80">Id</th>
        <th width="120">Nom</th>
        <th width="120">Prenom</th>
        <th width="120">Date de Naissance</th>
        <th width="60">Modifier</th>
        <th width="60">Supprimer</th>
    </tr>
    <c:forEach items="${P}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.nom}</td>
            <td>${person.prenom}</td>
            <td>${person.dateNaissance}</td>
          
            
            
            <td><a href="<c:url value='http://localhost:8080/spring/eleve/modifier/${person.id}' />" >Modifier</a></td>
            <td><a href="<c:url value='http://localhost:8080/spring/eleve/supp/${person.id}' />" >Supprimer</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>