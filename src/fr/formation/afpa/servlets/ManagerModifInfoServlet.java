package fr.formation.afpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.ManagerMetier;

public class ManagerModifInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/modifinfomanager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECUPERATION INFORMATION MANAGER SESSION
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
			
		Manager modifManager = new Manager(nom, prenom, email, tel, login, password, libelleRue, rue, codePostal, ville, pays[0]);
		ManagerMetier managerMetier = new ManagerMetier();
		
		//SAVE ANCIEN MANAGER POUR UPDATE
		HttpSession sessionOld = request.getSession();
		Manager managerSession = (Manager)sessionOld.getAttribute("Manager");
		
		//UPDATE MANAGER OK
		if(managerMetier.modifInfoManager(modifManager, managerSession)) {
			System.out.println("modif ok");
			//SESSION UPDATE
			HttpSession sessionNew = request.getSession();
			sessionNew.setAttribute("Manager", modifManager);
			response.sendRedirect("./manager");
		}
		else {
			System.out.println("erreur update manager");
		}
	}

}
