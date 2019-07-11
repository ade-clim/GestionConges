package fr.formation.afpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.metier.CongesMetier;

public class CollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collaborateur collaborateurSession = (Collaborateur)session.getAttribute("Collaborateur");
		CongesMetier congesMetier = new CongesMetier();
		
		//RECUPERER HISTORIQUE DES CONGES DU COLLABORATEUR EN SESSION
		List<Conges> listeHistoriqueConges = congesMetier.AfficherConges(collaborateurSession);
		session.setAttribute("listeHistoriqueConges", listeHistoriqueConges);
		//RECUPERER LE SOLDE DE CONGES DU COLLABORATEUR EN SESSION
		
		
		//ENVOIE DANS LA PAGE ACCUEIL
		request.getRequestDispatcher("/WEB-INF/jsp/collaborateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
