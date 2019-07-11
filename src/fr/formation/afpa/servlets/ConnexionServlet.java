package fr.formation.afpa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.formation.afpa.controllers.InfoControle;
import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.CollaborateurMetier;
import fr.formation.afpa.metier.ManagerMetier;


public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerMetier managerMetier = new ManagerMetier();
		CollaborateurMetier collaborateurMetier = new CollaborateurMetier();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String[] status = request.getParameterValues("status");
		
		InfoControle infoControle = new InfoControle();
		boolean boolLogin = infoControle.verifLogin(login);
		boolean boolPassword = infoControle.verifPassword(password);
		System.out.println("login"+boolLogin);
		System.out.println("password"+boolPassword);
		
		if(boolLogin == true && boolPassword == true) {
			if(status[0].equals("manager")) {
				Manager m = managerMetier.rechercheCompteManager(login,password).get(0);
				if(m != null) {
					HttpSession session = request.getSession();
					session.setAttribute("Manager", m);
					response.sendRedirect("./manager");
				}
				else {
					System.out.println("votre compte Manager n'existe pas!");
				}
			}
			else {
				Collaborateur collaborateur = collaborateurMetier.rechercheCompteCollaborateur(login,password).get(0);
				if(collaborateur != null) {
					HttpSession session = request.getSession();
					session.setAttribute("Collaborateur", collaborateur);
					response.sendRedirect("./collaborateur");
				}
				else {
					System.out.println("votre compte Collaborateur n'existe pas!");
				}
			}
			
		}
	}
}
