package fr.formation.afpa.metier;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.formation.afpa.dao.CongesDao;
import fr.formation.afpa.dao.ManagerDao;
import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.interfaceMetier.CongesInter;
import fr.formation.afpa.utils.HibernateUtils;

public class CongesMetier implements CongesInter{

	
	
	@Override
	//MODIFIE LE SOLDE EN FONCTION DU CONGES(RTT ou CP)
	public void soldeConges(int valeur, int conges) {
		Session s = HibernateUtils.getSession();
		try {
			CongesDao congesDao = new CongesDao();
			congesDao.soldeConges(valeur, conges, s);
		} catch (Exception e) {
			System.out.println("erreur dans la methode soldeConges(CongesMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		
	}
	
	
	//AFFICHER CONGES COLLABORATEUR
	@Override
	public List<Conges> AfficherConges(Collaborateur collaborateur) {
		List<Conges> maListe = new ArrayList<>();
		Session s = HibernateUtils.getSession();
		try {
			maListe = new CongesDao().AfficherConges(collaborateur, s);
			if(!maListe.isEmpty()) {
				for (Conges listeConges : maListe) {
					System.out.println(listeConges.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("erreur dans la methode AfficherConges(CongesMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		return maListe;
	}
	
	
	//AFFICHER CONGES MANAGER
	@Override
	public List<Conges> AfficherConges(Manager manager) {
		List<Conges> maListe = new ArrayList<>();
		Session s = HibernateUtils.getSession();
		try {
			maListe = new CongesDao().AfficherConges(manager, s);
//			if(!maListe.isEmpty()) {
//				for (Conges listeConges : maListe) {
//					System.out.println(listeConges.toString());
//				}
//			}
		} catch (Exception e) {
			System.out.println("erreur dans la methode AfficherConges(CongesMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		return maListe;
	}

	@Override
	
	public void modifierStatusConges(String etatDemande, int conges, int dureeSolde, String typeConges) {
		Session s = HibernateUtils.getSession();
		try {
			CongesDao congesDao = new CongesDao();
			congesDao.modifierStatusConges(etatDemande, conges, dureeSolde, typeConges, s);
		} catch (Exception e) {
			System.out.println("erreur dans la methode modifierStatusConges(CongesMetier)" + e.getMessage());
		} finally {
			s.close();
		}
		
	}




//	@Override
//	public void supprimmerConges(String etatDemande, int idConges) {
//		Session s = HibernateUtils.getSession();
//		try {
//			CongesDao congesDao = new CongesDao();
//			congesDao.supprimmerConges(etatDemande, idConges, s);
//		} catch (Exception e) {
//			System.out.println("erreur dans la methode supprimmerConges(CongesMetier)" + e.getMessage());
//		}
//		
//	}


}
