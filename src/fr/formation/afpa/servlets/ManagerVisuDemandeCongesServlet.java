package fr.formation.afpa.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.metier.CongesMetier;
import fr.formation.afpa.metier.ManagerMetier;


public class ManagerVisuDemandeCongesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DEMANDE DE VISU CONGES PAR LE MANAGER//
		CongesMetier congesMetier = new CongesMetier();
		Conges conges = new Conges();
		HttpSession session = request.getSession();
		Manager manager = (Manager)session.getAttribute("Manager");
		List<Conges> listeConges = congesMetier.AfficherConges(manager);
		//JE SET LA LISTE DE CONGES DANS LA SESSIONS
		session.setAttribute("listeConges", listeConges);
		request.getRequestDispatcher("WEB-INF/jsp/visuconges.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String etatDemande = request.getParameter("etatDemande");
		String typeConges = request.getParameter("typeConges");
		int dateDebut = Integer.parseInt(request.getParameter("dateDebut"));
		int dateFin = Integer.parseInt(request.getParameter("dateFin"));
		int idConges = Integer.parseInt(request.getParameter("idConges"));
		int dureeSolde = dateFin - dateDebut;
		if(etatDemande.equals("demandeValidee")) {
			System.out.println("je suis la ");
			CongesMetier congesMetier = new CongesMetier();
			congesMetier.modifierStatusConges(etatDemande, idConges, dureeSolde, typeConges);
		}
		
		response.sendRedirect("./visuconges");
	}

}
