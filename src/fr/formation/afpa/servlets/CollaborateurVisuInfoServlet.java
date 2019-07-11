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
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.ManagerMetier;


public class CollaborateurVisuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerMetier managerMetier = new ManagerMetier();
		HttpSession session = request.getSession();
		Collaborateur collaborateurSession = (Collaborateur)session.getAttribute("Collaborateur");
		//ON VA RECUPERER LE MANAGER DU COLLABORATEUR EN SESSION
		List<Manager> manager = managerMetier.infoManagerPourCollaborateur(collaborateurSession);
		request.setAttribute("ManagerDuCollaborateur", manager);
		request.getRequestDispatcher("/WEB-INF/jsp/visuinfocollaborateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
