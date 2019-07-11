package fr.formation.afpa.interfaceMetier;

import java.util.List;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;

public interface CollaborateurInter {

	public List<Collaborateur> rechercheCompteCollaborateur(String login, String password);
	public void creerCompteCollaborateur(Collaborateur collaborateur);
	public List<Collaborateur> listeCollaborateur(Manager manager);
	public boolean modifInfoCollaborateur(Collaborateur modifCollaborateur, Collaborateur CollaborateurSession);
	public void creerConges(Conges conges, Collaborateur collaborateur);
}
