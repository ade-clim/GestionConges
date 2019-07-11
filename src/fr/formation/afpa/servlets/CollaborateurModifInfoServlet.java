package fr.formation.afpa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.CollaborateurMetier;
import fr.formation.afpa.metier.ManagerMetier;

public class CollaborateurModifInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collaborateur collaborateur = (Collaborateur) session.getAttribute("Collaborateur");
		request.getRequestDispatcher("/WEB-INF/jsp/modifinfocollaborateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECUPERATION INFORMATION COLLABORATEUR SESSION
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
				String[] pays = request.getParameterValues("pays");
					
				Collaborateur modifCollaborateur = new Collaborateur(nom, prenom, email, tel, login, password, libelleRue, rue, codePostal, ville, pays[0]);
				CollaborateurMetier collaborateurMetier = new CollaborateurMetier();
				
				//SAVE ANCIEN COLLABORATEUR POUR UPDATE
				HttpSession sessionOld = request.getSession();
				Collaborateur collaborateurSession = (Collaborateur)sessionOld.getAttribute("Collaborateur");
				
				//UPDATE MANAGER OK
				if(collaborateurMetier.modifInfoCollaborateur(modifCollaborateur, collaborateurSession)) {
					System.out.println("modif ok");
					//SESSION UPDATE
					HttpSession sessionNew = request.getSession();
					sessionNew.setAttribute("Collaborateur", modifCollaborateur);
					response.sendRedirect("./collaborateur");
				}
				else {
					System.out.println("erreur update collaborateur");
				}
	}

}
