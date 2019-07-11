package fr.formation.afpa.metier;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.formation.afpa.dao.CollaborateurDao;
import fr.formation.afpa.dao.ManagerDao;
import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.interfaceMetier.CollaborateurInter;
import fr.formation.afpa.utils.HibernateUtils;

public class CollaborateurMetier implements CollaborateurInter{

	
	@Override
	public void creerConges(Conges conges, Collaborateur collaborateur) {
		CollaborateurDao collaborateurDao = new CollaborateurDao();
		Session s = HibernateUtils.getSession();
		try {
			collaborateurDao.creerConges(conges, collaborateur, s);
		} catch (Exception e) {
			System.out.println("erreur dans la methode creerConges(CollaborateurMetier)" + e.getMessage());
		} finally {
			s.close();
		}
	}
	
	@Override
	public List<Collaborateur> rechercheCompteCollaborateur(String login, String password) {
		List<Collaborateur> maListe = new ArrayList<>();
		Session s = HibernateUtils.getSession();
		try {
			maListe = new CollaborateurDao().rechercheCompteCollaborateur(login, password, s);
			if(!maListe.isEmpty()) {
			}
		} catch (Exception e) {
			System.out.println("erreur dans la methode rechercheCompteCollaborateur(CollaborateurMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		return maListe;
	}
	
	
	@Override
	public void creerCompteCollaborateur(Collaborateur collaborateur) {
		CollaborateurDao collaborateurDao = new CollaborateurDao();
		Session s = HibernateUtils.getSession();
		try {
			collaborateurDao.creerCompteCollaborateur(collaborateur, s);
		} catch (Exception e) {
			System.out.println("erreur dans la methode creerCompteCollaborateur(CollaborateurMetier)" + e.getMessage());
		} finally {
			s.close();
		}
	}


	@Override
	public List<Collaborateur> listeCollaborateur(Manager manager) {
		List<Collaborateur> maListe = new ArrayList<>();
		Session s = HibernateUtils.getSession();
		CollaborateurDao collaborateurDao = new CollaborateurDao();
		
		try {
			maListe = collaborateurDao.listeCollaborateur(manager, s);
			if(maListe.isEmpty()) {
				System.out.println("votre liste de collaborateur est vide");
			}
		} catch (Exception e) {
			System.out.println("erreur dans la methode rechercheCompteCollaborateur(CollaborateurMetier)" + e.getMessage());
		} finally {
		}
		return maListe;
	}


	@Override
	public boolean modifInfoCollaborateur(Collaborateur modifCollaborateur, Collaborateur CollaborateurSession) {
		boolean valeur = false;
		CollaborateurDao collaborateurDao = new CollaborateurDao();
		Session s = HibernateUtils.getSession();
		try {
			collaborateurDao.modifInfoCollaborateur(modifCollaborateur, CollaborateurSession, s);
			valeur = true;
		} catch (Exception e) {
			System.out.println("erreur dans la methode modifInfoCollaborateur(CollaborateurMetier)" + e.getMessage());
		}
		return valeur;
	}

}
