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
<style>
a {
	float: right;
}
</style>
<title>Page accueil collaborateur</title>

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
			<h4 class="masthead-brand">Bienvenue ${sessionScope.Collaborateur.prenom}</h4>
			<nav class="nav nav-masthead justify-content-center"> <a
				class="nav-link active" href="./collaborateur">Menu</a> <a
				class="nav-link" href="./visuinfocollaborateur">informations</a> <a
				class="nav-link" href="#">Contact</a> <a class="nav-link"
				href="./deconnexion">deconnexion</a> </nav>
		</div>
		</header>

		<main role="main" class="inner cover">
		<div class="container" align="center">
			<div class="row">
				<div class="col">
				<table>
				<tr>
					<td scope="col">Solde Cp :</td>
					<td scope="col">${sessionScope.Collaborateur.cp}</td>
				</tr>
				<tr>
					<td scope="col">Solde Rtt :</td>
					<td scope="col">${sessionScope.Collaborateur.rtt}</td>
				</tr>
				<tr>
					<td scope="col">Solde Maladie :</td>
					<td scope="col">${sessionScope.Collaborateur.maladie}</td>
				</tr>
				<tr>
					<td scope="col">Solde Formation :</td>
					<td scope="col">${sessionScope.Collaborateur.formation}</td>
				</tr>			
				</table>
				</div>
				
				<div class="col">
					<a href="./creerdemandeconge"><button
							class="btn btn-lg btn-primary" type="submit">Creer un
							conges</button></a>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<!-- CODE POUR HISTORIQUE CONGES -->
					<br><br>
					<p>Historique des conges</p>
					<c:if test="${listeHistoriqueConges.size() > 0}">
						<table class="table table-striped table table-sm">
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
							</thead>
							<c:forEach items="${listeHistoriqueConges}"
								var="listeHistoriqueConges">
								<tbody>
									<tr>
										<c:if test="${listeHistoriqueConges.etatDemande.length() > 0}">
											<th scope="row"></th>
											<td>${listeHistoriqueConges.typeDeConges}</td>
											<td>${listeHistoriqueConges.dateDebut}</td>
											<td>${listeHistoriqueConges.dateFin}</td>
											<td>${listeHistoriqueConges.commentaire}</td>
											<td>${listeHistoriqueConges.dateEtatDemande}</td>

											<c:if test="${listeHistoriqueConges.etatDemande == 'En attente de validation'}">
												<td bgcolor="orange">${listeHistoriqueConges.etatDemande}</td>
											</c:if>

											<c:if
												test="${listeHistoriqueConges.etatDemande == 'demandeValidee'}">
												<td bgcolor="green">${listeHistoriqueConges.etatDemande}</td>
											</c:if>
											<c:if test="${listeHistoriqueConges.etatDemande == 'demandeAnnulee'}">
												<td bgcolor="red">${listeHistoriqueConges.etatDemande}</td>
											</c:if>
											<c:if
												test="${listeHistoriqueConges.etatDemande != 'demandeAnnulee'}">
												<form action="visuhistoriqueconges" method="post">
													<input type="hidden" name="idConges" value="${listeHistoriqueConges.idConges}">
													<td><button class="btn btn-sm btn-danger" type="submit">Annuler</button></td>
												</form>
											</c:if>
											
										</c:if>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${listeHistoriqueConges.size() <= 0 }">
						<h2>Aucun historique de conges actuellement</h2>
					</c:if>
					<!-- CODE POUR HISTORIQUE CONGES -->
				</div>
			</div>
		</div>




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
