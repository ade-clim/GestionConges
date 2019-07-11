package fr.formation.afpa.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.CollaborateurMetier;

public class ManagerCreerCollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/creation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String libelleRue = request.getParameter("libelleRue");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");

		Collaborateur collaborateur1 = new Collaborateur(nom, prenom, email, tel, login, password, libelleRue, rue, codePostal, ville, pays);
		
		
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute( "Manager" );
		manager.setListeCollaborateur(new ArrayList<Collaborateur>());
		collaborateur1.setManager(manager);
		manager.addCollaborateur(collaborateur1);

			
		
		
		CollaborateurMetier collaborateurMetier = new CollaborateurMetier();
		collaborateurMetier.creerCompteCollaborateur(collaborateur1);
		response.sendRedirect("./manager");
	}	
}
