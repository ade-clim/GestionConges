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
				class="nav-link active" href="./collaborateur">Menu</a> <a
				class="nav-link" href="#">Contact</a> <a class="nav-link"
				href="./deconnexion">deconnexion</a> </nav>
		</div>
		</header>
		<div>
			<main role="main" class="inner cover">
			<h2 class="cover-heading">Creer un conges</h2>
			<!-- CODE A INSERER -->
			<div align="center">
				<form action="creerdemandeconge" method="post">
					<table>
						<tr>
							<td>type de congés:</td>
							<td><select name="listeConges">
								<option value="">--Conges souhaites--</option>
							<c:if test="${sessionScope.Collaborateur.maladie > 0}">
								<option value="Maladie" name="Maladie">Maladie(${sessionScope.Collaborateur.maladie})</option>
							</c:if>
							<c:if test="${sessionScope.Collaborateur.formation > 0}">
								<option value="Formation" name="Formation">Formation(${sessionScope.Collaborateur.formation})</option>
							</c:if>
							<c:if test="${sessionScope.Collaborateur.cp > 0}">
								<option value="Cp" name="Cp">Cp(${sessionScope.Collaborateur.cp})</option>
							</c:if>
								<c:if test="${sessionScope.Collaborateur.rtt > 0}">
								<option value="Rtt" name="Rtt">Rtt(${sessionScope.Collaborateur.rtt})</option>
							</c:if>
							</select></td>
						</tr>
						<tr>
							<td>Date de début :</td>
							<td><input type="text" name="dateDebut" placeholder="Debut conge"></td>
						</tr>
						<tr>
							<td>Date de fin :</td>
							<td><input type="text" name="dateFin" placeholder="Fin conge"></td>
						</tr>
					</table>
					<textarea name="commentaire" value="commentaire" rows="5" cols="35"></textarea>
					<br>
					<br>
					<button class="btn btn-lg btn-primary" type="submit">Valider</button>
					
				</form>
			</div>
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
