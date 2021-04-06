package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprunter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int EmprunteMax = 5;
	public static final int DelaiMax = 10;

	@Id
	@Column(nullable = true, unique = false)
	private String numEmprunter;    
	
	
	@Column(length = 50)
	private String nom;
	
	@Column(length = 50)
	private String prenom;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEmprunt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRetour;

	// dependance
	@ManyToOne
	private Abonnement abonnement;
	

	
	@OneToMany(mappedBy = "emprunter")
	private Collection<LignEmprunt> lignEmprunts;
	@OneToMany(mappedBy = "emprunters")
	private Collection<EmpruntInforClient> empruntInforClients;
	
	public Emprunter() {
		lignEmprunts = new ArrayList<>();
		empruntInforClients = new ArrayList<>();
	}

	public Emprunter(String numEmprunter, String nom, String prenom, Date dateEmprunt, Date dateRetour) {
		this();
		this.numEmprunter = numEmprunter;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
	}

	
	
	public Collection<EmpruntInforClient> getEmpruntInforClients() {
		return empruntInforClients;
	}

	public void setEmpruntInforClients(Collection<EmpruntInforClient> empruntInforClients) {
		this.empruntInforClients = empruntInforClients;
	}



	public String getNumEmprunter() {
		return numEmprunter;
	}

	public void setNumEmprunter(String numEmprunter) {
		this.numEmprunter = numEmprunter;
	}

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public Collection<LignEmprunt> getLignEmprunts() {
		return lignEmprunts;
	}

	public void setLignEmprunts(Collection<LignEmprunt> lignEmprunts) {
		this.lignEmprunts = lignEmprunts;
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

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	@Override
	public String toString() {
		return "Emprunter [nom=" + nom + ", prenom=" + prenom + ", dateEmprunt=" + dateEmprunt + ", dateRetour="
				+ dateRetour + "]";
	}

}
