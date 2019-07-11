<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Page de connexion</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <%@ include file="connexioncss.jsp" %>
  </head>

  <body class="text-center">
    <form  action= "connexion" method="post" class="form-signin">
      <img class="mb-4" src="./img/logo.svg" alt="" width="100" height="100">



      <!--CODE A IMPLENTER -->
    
      <label class="sr-only">Login</label>
      <input type="text" id="inputEmail" class="form-control" name= "login" placeholder="Login" required autofocus>
      <label class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" name= "password" placeholder="Password" required>
      <div class="checkbox mb-3">
        <select id="status" name="status">
          <option value="">--Votre status--</option>
          <option value="manager" name="manager"style="color:red;">Manager</option>
          <option value="collaborateur" name="collaborateur"style="color:blue;">Collaborateur</option>
        </select>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
      <p class="mt-5 mb-3 text-muted">&copy; afpa2018, by amine & aurelien.</p>
      </form>
      
      <!--CODE A IMPLENTER -->

  </body>
</html>