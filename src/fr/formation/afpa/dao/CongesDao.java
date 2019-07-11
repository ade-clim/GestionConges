package fr.formation.afpa.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.interfaceDao.CongesInterDao;

public class CongesDao implements CongesInterDao{

	
	
	@Override
	public void soldeConges(int valeur, int conges, Session s) {
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("update Collaborateur set valeurConges= :valeurCongesIn where idConges= :idCongesIn");
//			query.setParameter("typeDeCongesIn", etatDemande);
//			query.setParameter("idCongesIn", idConges);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erreur dans la methode soldeConges(CongesDao)"+e.getMessage());
		}
		
	}
	
	@Override
	//Methode qui affiche les conges en etat : "tous sauf demande supprimer"
	public List<Conges> AfficherConges(Collaborateur collaborateur, Session s) {
		List<Conges> maListe = new ArrayList<>();
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("from Conges where idCollaborateur= :idCollaborateurIn and etatDemande!= :etatDemandeIn");
			query.setParameter("idCollaborateurIn", collaborateur.getIdCollaborateur());
			query.setParameter("etatDemandeIn", "demandeSuprimee");
			maListe = query.list();
			tx.commit();
		}catch (Exception e) {
			System.out.println("erreur dans la methode AfficherConges(CongesDao)"+e.getMessage());
		}
		return maListe;
	}
	
	
	
	@Override
	//Methode qui affiche les conges en etat : "En attente de validation"
	public List<Conges> AfficherConges(Manager manager, Session s) {
		List<Conges> maListe = new ArrayList<>();
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("select conges from Conges as conges join conges.collaborateur as collab where collab.manager.idManager = :idManagerIn and etatDemande= :etatDemandeIn");
			query.setParameter("idManagerIn", manager.getIdManager());
			query.setParameter("etatDemandeIn", "En attente de validation");
			maListe = query.list();
			tx.commit();
		}catch (Exception e) {
			System.out.println("erreur dans la methode AfficherConges(CongesDao)"+e.getMessage());
		}
		return maListe;
	}

	@Override
	//Methode qui modifie l'etat du conges : "Valider/Annuler/Supprimer"
	
	// A REFAIRE RECUPERER LE COLLABORATEUR EN ENTIER, collaborateur.etatDemande - dureeSolde
	public void modifierStatusConges(String etatDemande, int idConges, int dureeSolde, String typeConges, Session s) {
		try {
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery("update Conges set etatDemande= :etatDemandeIn where idConges= :idCongesIn");
			query.setParameter("etatDemandeIn", etatDemande);
			query.setParameter("idCongesIn", idConges);
			query.executeUpdate();
			if(typeConges.equals("Formation")) {
				Query query1 = s.createQuery("update Collaborateur set formation= :formationIn where idCollaborateur= :idCollaborateurIn");
				query1.setParameter("formationIn", -dureeSolde);
				query1.setParameter("idCollaborateurIn", 1);
				query1.executeUpdate();
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println("erreur dans la methode modifierStatusConges(CongesDao)"+e.getMessage());
		}
		
	}





//	@Override
//	public void supprimmerConges(String etatDemande, int idConges, Session s) {
//		try {
//			Transaction tx = s.beginTransaction();
//			Query query = s.createQuery("delete from Conges where idConges= :idCongesIn");
//			query.setParameter("idCongesIn", idConges);
//			query.executeUpdate();
//		} catch (Exception e) {
//			System.out.println("erreur dans la methode modifierStatusConges(ManagerDao)"+e.getMessage());
//		}
//	}


}
