package fr.formation.afpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Conges implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idConges;
	@Column
	private String typeDeConges;
	@Column
	private String dateDebut;
	@Column
	private String dateFin;
	@Column
	private String etatDemande;
	@Column
	private String dateEtatDemande;
	@Column
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="idCollaborateur")
	private Collaborateur collaborateur;
	/**
	 * 
	 */
	public Conges() {
		super();
	}
	/**
	 * @param collaborateur
	 * @param typeDeConges
	 * @param dateDebut
	 * @param dateFin
	 * @param etatDemande
	 * @param dateEtatDemande
	 * @param commentaire
	 */
	public Conges(int idConges, String typeDeConges, String dateDebut, String dateFin,
			String etatDemande, String dateEtatDemande, String commentaire) {
		super();
		this.idConges = idConges;
		this.typeDeConges = typeDeConges;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatDemande = etatDemande;
		this.dateEtatDemande = dateEtatDemande;
		this.commentaire = commentaire;
	}
	
	public Conges(String typeDeConges, String dateDebut, String dateFin,
			String etatDemande, String dateEtatDemande, String commentaire) {
		super();
		this.typeDeConges = typeDeConges;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatDemande = etatDemande;
		this.dateEtatDemande = dateEtatDemande;
		this.commentaire = commentaire;
	}
	
	
	@Override
	public String toString() {
		return "Conges [idConges=" + idConges + ", typeDeConges=" + typeDeConges + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", etatDemande=" + etatDemande + ", dateEtatDemande=" + dateEtatDemande
				+ ", commentaire=" + commentaire + ", collaborateur=" + collaborateur + "]";
	}
	public int getIdConges() {
		return idConges;
	}
	public void setIdConges(int idConges) {
		this.idConges = idConges;
	}
	
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	public String getTypeDeConges() {
		return typeDeConges;
	}
	public void setTypeDeConges(String typeDeConges) {
		this.typeDeConges = typeDeConges;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getEtatDemande() {
		return etatDemande;
	}
	public void setEtatDemande(String etatDemande) {
		this.etatDemande = etatDemande;
	}
	public String getDateEtatDemande() {
		return dateEtatDemande;
	}
	public void setDateEtatDemande(String dateEtatDemande) {
		this.dateEtatDemande = dateEtatDemande;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collaborateur == null) ? 0 : collaborateur.hashCode());
		result = prime * result + ((commentaire == null) ? 0 : commentaire.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateEtatDemande == null) ? 0 : dateEtatDemande.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((etatDemande == null) ? 0 : etatDemande.hashCode());
		result = prime * result + idConges;
		result = prime * result + ((typeDeConges == null) ? 0 : typeDeConges.hashCode());
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
		Conges other = (Conges) obj;
		if (collaborateur == null) {
			if (other.collaborateur != null)
				return false;
		} else if (!collaborateur.equals(other.collaborateur))
			return false;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateEtatDemande == null) {
			if (other.dateEtatDemande != null)
				return false;
		} else if (!dateEtatDemande.equals(other.dateEtatDemande))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (etatDemande == null) {
			if (other.etatDemande != null)
				return false;
		} else if (!etatDemande.equals(other.etatDemande))
			return false;
		if (idConges != other.idConges)
			return false;
		if (typeDeConges == null) {
			if (other.typeDeConges != null)
				return false;
		} else if (!typeDeConges.equals(other.typeDeConges))
			return false;
		return true;
	}

	
	
}


