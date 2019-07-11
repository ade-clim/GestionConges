package fr.formation.afpa.interfaceDao;

import java.util.List;

import org.hibernate.Session;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;

public interface CollaborateurInterDao {

	public List<Collaborateur> rechercheCompteCollaborateur(String login, String password, Session s);
	public void creerCompteCollaborateur(Collaborateur collaborateur, Session s);
	public List<Collaborateur> listeCollaborateur(Manager manager, Session s);
	public boolean modifInfoCollaborateur(Collaborateur modifCollaborateur, Collaborateur CollaborateurSession, Session s);
	public void creerConges(Conges conges, Collaborateur collaborateur, Session s);
}
