package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Controller;

@Controller
public class abonnement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@Column(nullable = false, length = 70)
	private String nom ;
	@Column(nullable = false, length = 70)
	private String prenom ;
	@Column(nullable = false)
	private Date date ;
	@Column(nullable = false)
	private int duree;
	@Column(nullable = false)
	private float prix;
	
	
	//dependdance
	@ManyToOne
	private Utilisateur utilisateur;
	@ManyToOne
	private Manga manga;
	
	@OneToMany(mappedBy = "abonnement")
	private Collection<Offre> offres;
	
	
	public abonnement() {
		offres = new ArrayList<>();
	}


	public abonnement(String nom, String prenom, Date date, int duree, float prix) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.duree = duree;
		this.prix = prix;
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
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
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


	public Collection<Offre> getOffres() {
		return offres;
	}


	public void setOffres(Collection<Offre> offres) {
		this.offres = offres;
	}


	@Override
	public String toString() {
		return "abonnement [nom=" + nom + ", prenom=" + prenom + ", date=" + date + ", duree=" + duree + ", prix="
				+ prix + "]";
	}




}
