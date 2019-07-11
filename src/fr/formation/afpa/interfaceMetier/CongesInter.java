package fr.formation.afpa.interfaceMetier;

import java.util.List;
import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Conges;
import fr.formation.afpa.entity.Manager;

public interface CongesInter {

	public List<Conges> AfficherConges(Manager manager);
	public List<Conges> AfficherConges(Collaborateur collaborateur);
	public void modifierStatusConges(String etatDemande, int conges, int dureeSolde, String typeConges);
	//public void supprimmerConges(String etatDemande, int idConges);
	public void soldeConges(int valeur, int conges);
}

