package fr.formation.afpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.CollaborateurMetier;

public class ManagerListeCollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollaborateurMetier collaborateurMetier = new CollaborateurMetier();
		
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("Manager");
		int id = manager.getIdManager();
		List<Collaborateur> listeCollaborateur = collaborateurMetier.listeCollaborateur(manager);
		
		request.setAttribute("listeCollaborateur", listeCollaborateur);
		request.getRequestDispatcher("/WEB-INF/jsp/listecollaborateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
