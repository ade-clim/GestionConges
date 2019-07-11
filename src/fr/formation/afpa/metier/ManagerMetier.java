package fr.formation.afpa.metier;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.formation.afpa.dao.ManagerDao;
import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.interfaceMetier.ManagerInter;
import fr.formation.afpa.utils.HibernateUtils;

public class ManagerMetier implements ManagerInter{
	
	
	
	@Override
	// VA RECUPERER LES INFO DU MANAGER ASSOCIE AU COLLABORATEUR
	public List<Manager> infoManagerPourCollaborateur(Collaborateur collaborateurSession) {
		List<Manager> maListe = new ArrayList<>();
		Session s = HibernateUtils.getSession();
		
		try {
			maListe = new ManagerDao().infoManagerPourCollaborateur(collaborateurSession, s);
			if(!maListe.isEmpty()) {
				for (Manager manager : maListe) {
					System.out.println(manager.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("erreur dans la methode infoManagerPourCollaborateur(ManagerMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		return maListe;
	}
	
	
	
	@Override
	public List<Manager> rechercheCompteManager(String login, String password) {
		List<Manager> maListe = new ArrayList<>();
		Session s = HibernateUtils.getSession();
		
		try {
			maListe = new ManagerDao().rechercheCompteManager(login, password, s);
			if(!maListe.isEmpty()) {
				for (Manager manager : maListe) {
					System.out.println(manager.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("erreur dans la methode rechercheCompteManager(ManagerMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		return maListe;
	}
	

	@Override
	public boolean modifInfoManager(Manager modifManager, Manager managerSession) {
		boolean valeur = false;
		ManagerDao managerDao = new ManagerDao();
		Session s = HibernateUtils.getSession();
		try {
			managerDao.modifInfoManager(modifManager, managerSession, s);
			valeur = true;
		} catch (Exception e) {
			System.out.println("erreur dans la methode modifInfoManager(ManagerMetier)" + e.getMessage());
		}
		return valeur;
		
	}	

	@Override
	public void supprimerCompte() {
		try {

		} catch (Exception e) {
			System.out.println("erreur dans la methode supprimerCompte(ManagerMetier)" + e.getMessage());
		}
	}


	




}
