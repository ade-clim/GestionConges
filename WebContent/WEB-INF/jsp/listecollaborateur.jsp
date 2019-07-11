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

<title>Page creation collaborateur</title>

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
			<nav class="nav nav-masthead justify-content-center"> <a
				class="nav-link active" href="./manager">Menu</a> <a
				class="nav-link" href="#">Contact</a> <a class="nav-link"
				href="./deconnexion">deconnexion</a> </nav>
		</div>
		</header>
		<div class="container">
		<main role="main" class="inner cover">

	<div class="row">
		<div class="col-md-auto">
		<h2 class="cover-heading">vos collaborateur</h2>
		
			<!-- CODE A INSERER -->
			<c:if test="${listeCollaborateur.size() > 0}">
				<table class="table table-sm">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nom</th>
							<th scope="col">Prenom</th>
							<th scope="col">Email</th>
							<th scope="col">Tel</th>
							<th scope="col">LibelleRue</th>
							<th scope="col">Rue</th>
							<th scope="col">Code postal</th>
							<th scope="col">Ville</th>
							<th scope="col">Pays</th>
						</tr>
					</thead>
					<c:forEach items="${listeCollaborateur}" var="listeCollaborateur">
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>${listeCollaborateur.nom}</td>
								<td>${listeCollaborateur.prenom}</td>
								<td>${listeCollaborateur.email}</td>
								<td>${listeCollaborateur.tel}</td>
								<td>${listeCollaborateur.libelleRue}</td>
								<td>${listeCollaborateur.rue}</td>
								<td>${listeCollaborateur.codePostal}</td>
								<td>${listeCollaborateur.ville}</td>
								<td>${listeCollaborateur.pays}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${listeCollaborateur.size() <= 0 }">
				<h2>Aucun collaborateur dans votre équipe</h2>
			</c:if>
		</div>
	</div>
	</main>
</div>	
		



		<!-- CODE A INSERER -->

		<footer class="mastfoot mt-auto">
		<div class="inner">
			<p>afpa2018, by amine & aurelien.</p>
		</div>
	</div>
		</footer>


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
