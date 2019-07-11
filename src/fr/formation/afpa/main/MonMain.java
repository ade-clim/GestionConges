package fr.formation.afpa.main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.formation.afpa.entity.Collaborateur;
import fr.formation.afpa.entity.Manager;
import fr.formation.afpa.utils.HibernateUtils;


public class MonMain {

	public static void main(String[] args) {
		Session s = HibernateUtils.getSession();
		Manager manager = new Manager("Toto", "gros", "grostoto@gmail.com", "0665544858", "gros", "gros",
				"55", "rue des macdo", "59000", "gras", "France");
		Collaborateur collaborateur = new Collaborateur("Marcel", "dupont", "marceldupont@gmail.com", "0665544858", "petit", "petit",
				"556", "rue des haricots", "59000", "baguette", "France");
		Transaction tx = s.beginTransaction();
		s.persist(manager);
		s.persist(collaborateur);
		tx.commit();
		s.close();
	}

}
