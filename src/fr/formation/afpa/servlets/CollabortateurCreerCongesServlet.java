package fr.formation.afpa.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.metier.CollaborateurMetier;


public class CollabortateurCreerCongesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/creerdemandeconge.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String listeConges = request.getParameter("listeConges");
		String typeConges = listeConges;
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");
		String commentaire = request.getParameter("commentaire");
		
		HttpSession session1 = request.getSession();
		Collaborateur collaborateur1 = (Collaborateur)session1.getAttribute("Collaborateur");
		int total = Integer.parseInt(dateFin) - Integer.parseInt(dateDebut);
		//VARIABLE PROVISOIRE
		String dateEtatDemande = dateDebut;
		String etatDemande = "En attente de validation";
		//VARIABLE PROVISOIRE
		Conges conges = new Conges(typeConges, dateDebut, dateFin, etatDemande, dateEtatDemande, commentaire);
		boolean valeur = false;
		if(typeConges.equals("Formation")) {
			if(!((collaborateur1.getFormation() - total)  <= 0)) {
				valeur = true;
			}
		}
		else if(typeConges.equals("Maladie")) {
			if(!((collaborateur1.getMaladie() - total)  <= 0)) {
				valeur = true;
			}
		}
		else if(typeConges.equals("Rtt")) {
			if(!((collaborateur1.getRtt() - total)  <= 0)) {
				valeur = true;
			}
		}
		else if(typeConges.equals("Cp")) {
			if(!((collaborateur1.getCp() - total)  <= 0)) {
				valeur = true;
			}
		}
			
		if(valeur == true) {
			HttpSession session = request.getSession();
			Collaborateur collaborateur2 = (Collaborateur)session.getAttribute("Collaborateur");
			System.out.println("creation conges ok");
			
					
			System.out.println("mon conges ="+conges.toString());	
					
			collaborateur2.setListeConges(new ArrayList<Conges>());
					
			collaborateur2.addListeConges(conges);
			conges.setCollaborateur(collaborateur2);
					
					
			CollaborateurMetier collaborateurMetier = new CollaborateurMetier();
			collaborateurMetier.creerConges(conges, collaborateur2);
			response.sendRedirect("./collaborateur");
		}
		else {
			System.out.println("solde "+typeConges+" insuffisant");
			response.sendRedirect("./creerdemandeconge");
		}
		
	}
}

