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

<title>visu information</title>

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
			<h3 class="masthead-brand">Collaborateur</h3>
			<nav class="nav nav-masthead justify-content-center"> <a
				class="nav-link active" href="./collaborateur">Menu</a> <a
				class="nav-link" href="#">Contact</a> <a class="nav-link"
				href="./deconnexion">deconnexion</a></nav>
		</div>
		</header>

		<main role="main" class="inner cover">
			
<div class="container">
	<div class="row">
		<div class="col">
			<!-- CODE A INSERER -->
			<h2 class="cover-heading">Mes informations</h2>
			<table>
				<tr>
					<th scope="row">Nom</th>
					<td>${sessionScope.Collaborateur.nom}</td>
				</tr>
				<tr>
					<td>Prenom</td>
					<td>${sessionScope.Collaborateur.prenom}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${sessionScope.Collaborateur.email}</td>
				</tr>
				<tr>
					<td>tel</td>
					<td>${sessionScope.Collaborateur.tel}</td>
				</tr>
				<tr>
					<td>LibelleRue</td>
					<td>${sessionScope.Collaborateur.libelleRue}</td>
				</tr>
				<tr>
					<td>Rue</td>
					<td>${sessionScope.Collaborateur.rue}</td>
				</tr>
				<tr>
					<td>Code postal</td>
					<td>${sessionScope.Collaborateur.codePostal}</td>
				</tr>
				<tr>
					<td>Ville</td>
					<td>${sessionScope.Collaborateur.ville}</td>
				</tr>
				<tr>
					<td>Pays</td>
					<td>${sessionScope.Collaborateur.pays}</td>
				</tr>
			</table>
			<br>
			<a href="./modifinfocollaborateur"><button class="btn btn-lg btn-primary" type="submit">Modifier</button></a>
		</div>
	<div class="col">
			<c:forEach items="${ManagerDuCollaborateur}" var="ManagerDuCollaborateur">
			<h2>Mon manager</h2>
				<table class="tableaux">
					<tr>
						<td>Nom</td>
						<td>${ManagerDuCollaborateur.nom}</td>
					</tr>
					<tr>
						<td>Prenom</td>
						<td>${ManagerDuCollaborateur.prenom}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td>${ManagerDuCollaborateur.email}</td>
					</tr>
					<tr>
						<td>tel</td>
						<td>${ManagerDuCollaborateur.tel}</td>
					</tr>
					<tr>
						<td>LibelleRue</td>
						<td>${ManagerDuCollaborateur.libelleRue}</td>
					</tr>
					<tr>
						<td>Rue</td>
						<td>${ManagerDuCollaborateur.rue}</td>
					</tr>
					<tr>
						<td>Code postal</td>
						<td>${ManagerDuCollaborateur.codePostal}</td>
					</tr>
					<tr>
						<td>Ville</td>
						<td>${ManagerDuCollaborateur.ville}</td>
					</tr>
					<tr>
						<td>Pays</td>
						<td>${ManagerDuCollaborateur.pays}</td>
					</tr>
				</table>
			</c:forEach> 
		</div>
	</div>
</div>
</main>
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
