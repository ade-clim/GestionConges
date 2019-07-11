package fr.formation.afpa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.afpa.entity.Manager;

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/manager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] choixManager = request.getParameterValues("choix");
		if(choixManager[0].equals("creerCollaborateur")) {
			response.sendRedirect("./creation");
		}
		if(choixManager[0].equals("afficherCollaborateur")) {
			response.sendRedirect("./listecollaborateur");
		}
		if(choixManager[0].equals("modifInfo")) {
			response.sendRedirect("./modifinfomanager");
		}
		if(choixManager[0].equals("visuConges")) {
			response.sendRedirect("./visuconges");
		}
	}

}
