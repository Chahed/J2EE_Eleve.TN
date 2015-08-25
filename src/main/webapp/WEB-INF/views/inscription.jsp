<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ include file="/include/css.jsp" %>
<%@ include file="/include/js.jsp" %>


</head>

<body class="align">
<%@ include file="/include/header.jsp" %>

  <div class="site__container">

    <div class="grid__container">

      <form action="" method="post" class="form form--login">

        <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Nom</span></label>
          <input id="login__username" type="text" class="form__input" placeholder="Nom" required>
        </div>
        
        <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Prénom</span></label>
          <input id="login__username" type="text" class="form__input" placeholder="Prénom" required>
        </div>
        
        <div class="form__field">
          <label class="fa fa-phone" for="login__username"><span class="hidden">Téléphone</span></label>
          <input id="login__username" type="text" class="form__input" placeholder="Téléphone" required>
        </div>
        
        <div class="form__field">
          <label class="fa  fa-envelope" for="login__username"><span class="hidden">Email</span></label>
          <input id="login__username" type="text" class="form__input" placeholder="Email" required>
        </div>
           <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Login</span></label>
          <input id="login__username" type="text" class="form__input" placeholder="Login" required>
        </div>

        <div class="form__field">
          <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
          <input id="login__password" type="password" class="form__input" placeholder="Password" required>
        </div>
        

        <div class="form__field">
          <input type="submit" value="Enregistrer">
        </div>

      </form>

    </div>

  </div>

</body>

</html>