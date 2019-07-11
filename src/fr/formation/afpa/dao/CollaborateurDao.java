package fr.formation.afpa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.interfaceDao.CollaborateurInterDao;

public class CollaborateurDao implements CollaborateurInterDao{

	
	@Override
	public void creerConges(Conges conges, Collaborateur collaborateur, Session s) {
		try {
			Transaction tx = s.beginTransaction();
			s.persist(conges);
			tx.commit();
		} catch (Exception e) {
			System.out.println("erreur dans la methode creerConges(CollaborateurDao)"+e.getMessage());
		}
	}
	
	@Override
	public void creerCompteCollaborateur(Collaborateur collaborateur, Session s) {
		try {
			Transaction tx = s.beginTransaction();
			s.persist(collaborateur);
			tx.commit();
		} catch (Exception e) {
			System.out.println("erreur dans la methode creerCompteCollaborateur(CollaborateurDao)"+e.getMessage());
		}	
	}
	
	@Override
	public List<Collaborateur> rechercheCompteCollaborateur(String login, String password, Session s) {
		List<Collaborateur> maListe = new ArrayList<>();
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("from Collaborateur where login= :loginIn  and password= :passIn");
			query.setParameter("loginIn", login);
			query.setParameter("passIn", password);
			maListe = query.list();
			tx.commit();
			if(maListe.isEmpty()) {
				System.out.println("votre collaborateur n'est pas dans la liste");
			}
			else {
				for (Collaborateur mesCollaborateur : maListe) {
					System.out.println(mesCollaborateur.toString());
				}
			}	
		}catch (Exception e) {
			System.out.println("erreur dans la methode rechercheCompteCollaborateur(CollaborateurDao)"+e.getMessage());
		}
		return maListe;
	}
	
	

	@Override
	public List<Collaborateur> listeCollaborateur(Manager manager, Session s) {
		List<Collaborateur> maListe = new ArrayList<>();
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("from Collaborateur where idManager= :idManagerIn");
			query.setParameter("idManagerIn", manager.getIdManager());
			maListe = query.list();
			tx.commit();
			if(maListe.isEmpty()) {
				System.out.println("votre liste de collaborateur est vide");
			}
			else {
				for (Collaborateur mesCollaborateur : maListe) {
					System.out.println(mesCollaborateur.toString());
				}
			}	
		}catch (Exception e) {
			System.out.println("erreur dans la methode listeCollaborateur(CollaborateurDao)"+e.getMessage());
		}
		return maListe;
	}

	@Override
	public boolean modifInfoCollaborateur(Collaborateur modifCollaborateur, Collaborateur CollaborateurSession, Session s) {
		boolean valeur = false;
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("update Collaborateur set nom= :nomIn, prenom= :prenomIn, email= :emailIn, tel= :telIn, login= :loginIn, password= :passwordIn, libelleRue= :libelleRueIn, rue= :rueIn, codePostal= :codePostalIn, ville= :villeIn, pays= :paysIn where idCollaborateur= :idCollaborateurIn");
			query.setParameter("nomIn", modifCollaborateur.getNom());
			query.setParameter("prenomIn", modifCollaborateur.getPrenom());
			query.setParameter("emailIn", modifCollaborateur.getEmail());
			query.setParameter("telIn", modifCollaborateur.getTel());
			query.setParameter("loginIn", modifCollaborateur.getLogin());
			query.setParameter("passwordIn", modifCollaborateur.getPassword());
			query.setParameter("libelleRueIn", modifCollaborateur.getLibelleRue());
			query.setParameter("rueIn", modifCollaborateur.getRue());
			query.setParameter("codePostalIn", modifCollaborateur.getCodePostal());
			query.setParameter("villeIn", modifCollaborateur.getVille());
			query.setParameter("paysIn", modifCollaborateur.getPays());
			query.setParameter("idCollaborateurIn", CollaborateurSession.getIdCollaborateur());
			tx.commit();
			query.executeUpdate();
			valeur = true;
		} catch (Exception e) {
			System.out.println("erreur dans la methode modifInfoCollaborateur(CollaborateurDao)"+e.getMessage());
		}
		return valeur;
	}
}
