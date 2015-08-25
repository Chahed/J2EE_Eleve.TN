<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<h2>Parents</h2>
<style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
        .error {
        color: #ff0000; }
    </style>
 
<c:url var="addAction" value="/parent/ajout" ></c:url>
 
<form:form action="${addAction}" commandName="parent">
    <table>
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
   
    <tr>
        <td>
            <form:label path="nom">
                <spring:message text="Nom"/>
            </form:label>
        </td>
        <td>
            <form:input path="nom" />
        </td> 
         <td><form:errors path="nom" cssclass="error"/></td>
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
         <td><form:errors path="prenom" cssclass="error"  text="erooor"/></td>
    </tr>
            <tr>
        <td>
            <form:label path="email">
                <spring:message text="Email"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td> 
    </tr>
           
        <tr>
        <td>
            <form:label path="login">
                <spring:message text="Login"/>
                
            </form:label>
        </td>
        <td>
            <form:input path="login" />
        </td> 
         <td><form:errors path="login" cssclass="error"/></td>
    </tr>

        <tr>
        <td>
            <form:label path="motdepasse">
                <spring:message text="Mot de passe"/>
            </form:label>
        </td>
        <td>
            <form:input path="motdepasse" />
        </td> 
    </tr>
            <tr>
        <td>
            <form:label path="tel">
                <spring:message text="Tel"/>
            </form:label>
        </td>
        <td>
            <form:input path="tel" />
        </td> 
    </tr>
    
    <td colspan="2">
            <c:if test="${!empty parent.nom}">
                <input type="submit"
                    value="<spring:message text="Modifier"/>" />
            </c:if>
            <c:if test="${empty parent.nom}">
                <input type="submit"
                    value="<spring:message text="Ajouter"/>" />
            </c:if>
        </td>
</table>
</form:form>
 
<h3>Users</h3>
<c:if  test="${!empty listparent}">
<table class="tg">
<tr>
       <th width="120">Id</th>
        <th width="120">Nom</th>
        <th width="120">Prenom</th>
        <th width="120">Email</th>
         <th width="120">Login</th>
          <th width="120">Mot de passe</th>
           <th width="120">Telephone</th>
        
    
    <th>&nbsp;</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${listparent}" var="parent">
    <tr>
         <td >${parent.id}</td>
         <td >${parent.nom}</td>
        <td >${parent.prenom}</td>
        <td >${parent.email}</td>
        <td>${parent.login}</td>
        <td>${parent.motdepasse}</td>
        <td>${parent.tel}</td>
  <td><a href="<c:url value='/modifierParent/${parent.id}' />" >Modifier</a></td>
  <td><a href="<c:url value='/suppParent/${parent.id}' />" >Supprimer</a></td>
  <td><a href="parentprofil/classe/${parent.id}"><spring:message text="Enfant"/></a></td>
    </tr>
</c:forEach>
</table>
</c:if>