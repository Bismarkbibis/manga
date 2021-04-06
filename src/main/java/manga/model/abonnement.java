package manga.model;

import java.io.Serializable;

//import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Abonnement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 70)
	private String nom;
	@Column(nullable = false, length = 70)
	private String prenom;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(nullable = false)
	private int duree;
	@Column(length = 50)
	private float prixHT;
	@Column(nullable = false)
	private String numeroabonnement;

	// dependdance
	@JsonIgnore
	@ManyToOne
	private Utilisateur utilisateur;
	@ManyToOne
	private Manga manga;


	@JsonIgnore
	@OneToOne
	private Offre offre;
	@ManyToOne
	private CompteStatus compteStatus;
	
	public Abonnement() {

	}

	public Abonnement( String nom, String prenom, Date date, int duree, float prixHT,
			String numeroabonnement) {
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.duree = duree;
		this.prixHT = prixHT;
		this.numeroabonnement = numeroabonnement;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public String getNumeroabonnement() {
		return numeroabonnement;
	}

	public void setNumeroabonnement(String numeroabonnement) {
		this.numeroabonnement = numeroabonnement;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getPrix() {
		return prixHT;
	}

	public void setPrix(float prix) {
		this.prixHT = prix;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}
	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}


	public CompteStatus getCompteStatus() {
		return compteStatus;
	}

	public void setCompteStatus(CompteStatus compteStatus) {
		this.compteStatus = compteStatus;
	}

	@Override
	public String toString() {
		return "abonnement [nom=" + nom + ", prenom=" + prenom + ", date=" + date + ", duree=" + duree + ", prix="
				+ prixHT + "]";
	}
}
