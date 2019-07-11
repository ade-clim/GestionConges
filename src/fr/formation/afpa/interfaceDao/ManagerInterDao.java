package fr.formation.afpa.interfaceDao;

import java.util.List;

import org.hibernate.Session;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;

public interface ManagerInterDao {

	public List<Manager> rechercheCompteManager(String login, String password, Session s);
	public boolean modifInfoManager(Manager modifManager,Manager managerSession, Session s);
	public List<Manager>infoManagerPourCollaborateur(Collaborateur collaborateurSession, Session s);
	public void supprimerCompte();
}
