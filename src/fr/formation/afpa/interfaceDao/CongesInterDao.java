package fr.formation.afpa.interfaceDao;

import java.util.List;
import org.hibernate.Session;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;

public interface CongesInterDao {

	public List<Conges> AfficherConges(Manager manager, Session s);
	public List<Conges> AfficherConges(Collaborateur collaborateur, Session s);
	public void modifierStatusConges(String etatDemande, int conges, int dureeSolde, String typeConges, Session s);
	//public void supprimmerConges(String etatDemande, int idConges, Session s);
	public void soldeConges(int valeur, int conges, Session s);
}
