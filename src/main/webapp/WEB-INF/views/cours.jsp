<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admin</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
  Ajouter Un Cours
</h1>
 
<c:url var="addAction" value="/cours/ajout" ></c:url>
 
<form:form action="${addAction}" commandName="cours">
<table>
    <c:if test="${!empty cours.libelle}">
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
            <form:label path="libelle">
                <spring:message text="libelle"/>
            </form:label>
        </td>
        <td>
            <form:input path="libelle" />
        </td> 
    </tr>
  
    <tr>
        <td colspan="2">
            <c:if test="${!empty cours.libelle}">
                <input type="submit"
                    value="<spring:message text="Modifier"/>" />
            </c:if>
            <c:if test="${empty cours.libelle}">
                <input type="submit"
                    value="<spring:message text="Ajouter"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>La Liste des Cours: </h3>
<c:if test="${!empty listCours}">
    <table class="tg">
    <tr>
        <th width="80">Id</th>
        <th width="120">Libelle</th>
       
        
    </tr>
    <c:forEach items="${listCours}" var="cours">
        <tr>
            <td>${cours.id}</td>
            <td>${cours.libelle}</td>
            
            
            <td><a href="<c:url value='/modifierCours/${cours.id}' />" >Modifier</a></td>
            <td><a href="<c:url value='/suppCours/${cours.id}' />" >Supprimer</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>