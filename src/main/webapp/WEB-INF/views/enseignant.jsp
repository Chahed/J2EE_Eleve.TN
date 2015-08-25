<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<h2>Users Manager</h2>
 
<c:url var="addAction" value="/enseignant/ajout" ></c:url>
 
<form:form action="${addAction}" commandName="enseignant">
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
    
     <tr>
        <td>
            <form:label path="specialite">
                <spring:message text="Specialite"/>
            </form:label>
        </td>
        <td>
            <form:input path="specialite" />
        </td> 
    </tr>
    <td colspan="2">
            <c:if test="${!empty enseignant.nom}">
                <input type="submit"
                    value="<spring:message text="Modifier"/>" />
            </c:if>
            <c:if test="${empty enseignant.nom}">
                <input type="submit"
                    value="<spring:message text="Ajouter"/>" />
            </c:if>
        </td>
</table>
</form:form>
 
<h3>Users</h3>
<c:if  test="${!empty listenseignant}">
<table>
<tr>
       <th width="80">Id</th>
        <th width="120">Nom</th>
        <th width="120">Prenom</th>
        <th width="120">Email</th>
         <th width="120">Login</th>
          <th width="120">Mot de passe</th>
           <th width="120">Telephone</th>
        <th width="120">Specialite</th>
    
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${listenseignant}" var="enseignant">
    <tr>
        <td>${enseignant.nom}</td>
        <td>${enseignant.prenom}</td>
        <td>${enseignant.email}</td>
        <td>${enseignant.login}</td>
        <td>${enseignant.motdepasse}</td>
        <td>${enseignant.tel}</td>
        <td>${enseignant.specialite}</td>
        
        <td><a href="delete/${enseignant.id}"><spring:message text="Supprimer"/></a></td>
        <td><a href="enseignantcours/${enseignant.id}"><spring:message text="Cours"/></a></td>
    </tr>
</c:forEach>
</table>
</c:if>