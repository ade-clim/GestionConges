package fr.formation.afpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.interfaceDao.ManagerInterDao;
import fr.formation.afpa.utils.HibernateUtils;

public class ManagerDao implements ManagerInterDao{
	
	
	
	@Override
	// VA RECUPERER LES INFO DU MANAGER ASSOCIE AU COLLABORATEUR
	public List<Manager> infoManagerPourCollaborateur(Collaborateur collaborateurSession, Session s) {
		List<Manager> maListe = new ArrayList<>();
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("from Manager where idManager= :idManagerIn");
			query.setParameter("idManagerIn", collaborateurSession.getManager().getIdManager());
			maListe = query.list();
			tx.commit();
		}catch (Exception e) {
			System.out.println("erreur dans la methode infoManagerPourCollaborateur(ManagerDao)"+e.getMessage());
		}
		return maListe;
	}
	
	
	
	@Override
	public List<Manager> rechercheCompteManager(String login, String password, Session s) {
		List<Manager> maListe = new ArrayList<>();
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("from Manager where login= :loginIn  and password= :passIn");
			query.setParameter("loginIn", login);
			query.setParameter("passIn", password);
			maListe = query.list();
			tx.commit();
		}catch (Exception e) {
			System.out.println("erreur dans la methode rechercheCompteManager(ManagerDao)"+e.getMessage());
		}
		return maListe;
	}
	
	
	@Override
	public boolean modifInfoManager(Manager modifManager, Manager managerSession, Session s) {
		boolean valeur = false;
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("update Manager set nom= :nomIn, prenom= :prenomIn, email= :emailIn, tel= :telIn, login= :loginIn, password= :passwordIn, libelleRue= :libelleRueIn, rue= :rueIn, codePostal= :codePostalIn, ville= :villeIn, pays= :paysIn where idManager = :idManagerIn");
			query.setParameter("nomIn", modifManager.getNom());
			query.setParameter("prenomIn", modifManager.getPrenom());
			query.setParameter("emailIn", modifManager.getEmail());
			query.setParameter("telIn", modifManager.getTel());
			query.setParameter("loginIn", modifManager.getLogin());
			query.setParameter("passwordIn", modifManager.getPassword());
			query.setParameter("libelleRueIn", modifManager.getLibelleRue());
			query.setParameter("rueIn", modifManager.getRue());
			query.setParameter("codePostalIn", modifManager.getCodePostal());
			query.setParameter("villeIn", modifManager.getVille());
			query.setParameter("paysIn", modifManager.getPays());
			query.setParameter("idManagerIn", managerSession.getIdManager());
			query.executeUpdate();
			tx.commit();
			valeur = true;
		} catch (Exception e) {
			System.out.println("erreur dans la methode modifInfoManager(ManagerDao)"+e.getMessage());
		}
		return valeur;
	}
	
	
	@Override
	public void supprimerCompte() {
		// TODO Auto-generated method stub
		
	}


	


}
