<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Visu demande de conges</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
  crossorigin="anonymous">

<!-- Custom styles for this template -->
<%@ include file="accueilmanagercss.jsp"%>
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

  <div align="center">
    <main role="main" class="inner cover">
    <h2 class="cover-heading">Liste de conges</h2>
    
    <!-- CODE A INSERER -->
  <c:if test="${listeConges.size() > 0}">
    <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Type de conges</th>
      <th scope="col">Date debut</th>
      <th scope="col">Date fin</th>
      <th scope="col">Commentaire</th>
      <th scope="col">Date demande</th>
      <th scope="col">Etat demande</th>
    </tr>
      <c:forEach items="${listeConges}" var="conge">
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>${conge.typeDeConges}</td>
      <td>${conge.dateDebut}</td>
      <td>${conge.dateFin}</td>
      <td>${conge.commentaire}</td>
      <td>${conge.dateEtatDemande}</td>
        <form action="visuconges" method="post">
        <td><select name="etatDemande">
          <option value="">${conge.etatDemande}</option>
          <option value="demandeValidee" name="demandeValidee"style="color:blue;">Demande validée</option>
          <option value="demandeAnnulee" name="demandeAnnulee"style="color:red;">Demande annulée</option>
          <option value="demandeSuprimee" name="demandeSuprimee"style="color:black;">Demande supprimée</option>
        </select></td>
        <input type="hidden" name="idConges" value="${conge.idConges}">
        <input type="hidden" name="typeConges" value="${conge.typeDeConges}">
        <input type="hidden" name="dateDebut" value="${conge.dateDebut}">
        <input type="hidden" name="dateFin" value="${conge.dateFin}">
        <td><button class="btn btn-sm btn-primary" type="submit">Modifier</button></td> 
        </form>
    </tr>
  </tbody>
  </c:forEach>
</table>
 </c:if>
  <c:if test="${listeConges.size() <= 0 }">
		<h2>Aucune demande de conges actuellement</h2>
	</c:if>
  </main>
   </div>

    <!-- CODE A INSERER -->

    <footer class="mastfoot mt-auto">
    <div class="inner">
      <p>afpa2018, by amine & aurelien.</p>
    </div>
    </footer>
  </div>


  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script>
    window.jQuery
        || document
            .write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
  </script>
  <script src="../../assets/js/vendor/popper.min.js"></script>
  <script src="../../dist/js/bootstrap.min.js"></script>
</body>
</html>
