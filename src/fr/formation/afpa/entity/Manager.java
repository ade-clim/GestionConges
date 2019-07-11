package fr.formation.afpa.entity;

import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table
public class Manager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idManager;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String email;
	@Column
	private String tel;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private String libelleRue;
	@Column
	private String rue;
	@Column
	private String codePostal;
	@Column
	private String ville;
	@Column
	private String pays;
	
	@OneToMany(mappedBy="manager")
	private List<Collaborateur> listeCollaborateur;
	
	public void addCollaborateur(Collaborateur collaborateur){
		listeCollaborateur.add(collaborateur) ;
	}
	
	/**
	 * 
	 */
	
	public Manager() {
		super();
	}
	
	/**
	 * @param idManager
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param login
	 * @param password
	 * @param libelleRue
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param pays
	 */
	//constructeur sans id
	public Manager(String nom, String prenom, String email, String tel, String login, String password,
			String libelleRue, String rue, String codePostal, String ville, String pays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.login = login;
		this.password = password;
		this.libelleRue = libelleRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	
	public Manager(int idManager, String nom, String prenom, String email, String tel, String login, String password,
			String libelleRue, String rue, String codePostal, String ville, String pays) {
		super();
		this.idManager = idManager;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.login = login;
		this.password = password;
		this.libelleRue = libelleRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	
	@Override
	public String toString() {
		return "Manager [idManager=" + idManager + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", tel=" + tel + ", login=" + login + ", password=" + password + ", libelleRue=" + libelleRue
				+ ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + "]";
	}



	public List<Collaborateur> getListeCollaborateur() {
		return listeCollaborateur;
	}
	
	public void setListeCollaborateur(List<Collaborateur> listeCollaborateur) {
		this.listeCollaborateur = listeCollaborateur;
	}

	public int getIdManager() {
		return idManager;
	}
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLibelleRue() {
		return libelleRue;
	}
	public void setLibelleRue(String libelleRue) {
		this.libelleRue = libelleRue;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idManager;
		result = prime * result + ((libelleRue == null) ? 0 : libelleRue.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idManager != other.idManager)
			return false;
		if (libelleRue == null) {
			if (other.libelleRue != null)
				return false;
		} else if (!libelleRue.equals(other.libelleRue))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	
	
	
}
