package fr.formation.afpa.interfaceMetier;

import java.util.List;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;

public interface ManagerInter {

	public List<Manager> rechercheCompteManager(String login, String password);
	public boolean modifInfoManager(Manager modifManager, Manager managerSession);
	public List<Manager>infoManagerPourCollaborateur(Collaborateur collaborateurSession);
	public void supprimerCompte();
}
