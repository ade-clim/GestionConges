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

    <title>Page accueil manager</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <%@ include file="accueilmanagercss.jsp" %>
  </head>
<body class="text-center">


    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">Manager</h3>

          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link active" href="./manager">Menu</a>
            <a class="nav-link" href="#">Contact</a>
            <a class="nav-link" href="./deconnexion">deconnexion</a>
          </nav>
        </div>
      </header>
      
      
      
      
      
      
      <main role="main" class="inner cover">
        <h2 class="cover-heading">Vos informations</h2>
        <form action="manager" method="post">
    <div>
      <select id="choix" name="choix">
        <option value="">--Votre choix--</option>
        <option value="creerCollaborateur" name="creerCollaborateur">Creer un collaborateur</option>
        <option value="afficherCollaborateur" name="afficherCollaborateur">Mes collaborateurs</option>
        <option value="modifInfo" name="modifInfo">Modifier mes informations</option>
        <option value="visuConges" name=""visuConges"">Visualisation demandes de congés</option>
      </select>
    </div><br>
    <button class="btn btn-lg btn-primary" type="submit">Valider</button>
  </form>
      </main>

      <footer class="mastfoot mt-auto">
        <div class="inner">
          <p>afpa2018, by amine & aurelien.</p>
        </div>
      </footer>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
  </body>
</html>
