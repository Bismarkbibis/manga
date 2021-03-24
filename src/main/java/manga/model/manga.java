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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Controller;
@Controller
public class Manga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(length = 50, nullable = false)
	private String nom;
	
	@Column(length = 100, nullable = false)
	private String titre;
	
	@Column(length = 200, nullable = false)
	private String description;

	@Column(length = 50, nullable = false)
	private int nombrePage;
	
	@Column(length = 50, nullable = false)
	private int tom;
	
	@Column(length = 50, nullable = false)
	private String auteur;
	
	@Column(length = 50, nullable = false)
	private String genre;
	
	@Column(length = 50, nullable = false)
	private String statut;
	
	@Column(length = 50, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortie;
	
	@Column(length = 50, nullable = false)
	private String langue;
	
	@Column(length = 50, nullable = false)
	private String Edition;
	
	// dependance 
	@ManyToOne
	private Genre genre2;
	@ManyToOne 
	private Emprunter emprunter;
	@ManyToOne 
	private Edition edition2;
	@ManyToOne
	private Auteur auteur2;
	@ManyToOne
	private Tva tva;
	@OneToMany(mappedBy = "manga")
	private Collection<Commentaire> commentaires;
	@OneToMany(mappedBy = "manga")
	private Collection<Type> types;
	@OneToMany(mappedBy = "manga")
	private Collection<abonnement> abonnements;
	@OneToMany(mappedBy = "manga")
	private Collection<LigeCommande> ligeCommandes;
	@OneToMany(mappedBy = "manga")
	private Collection<Actualiter> actualiters;
	
	
	public Manga() {
		commentaires =new ArrayList<>();
		types =new ArrayList<>();
		abonnements =new ArrayList<>();
		ligeCommandes =new ArrayList<>();
		actualiters =new ArrayList<>();
	}


	public Manga(String nom, String titre, String description, int nombrePage, int tom, String auteur, String genre,
			String statut, Date dateSortie, String langue, String edition) {
		this();
		this.nom = nom;
		this.titre = titre;
		this.description = description;
		this.nombrePage = nombrePage;
		this.tom = tom;
		this.auteur = auteur;
		this.genre = genre;
		this.statut = statut;
		this.dateSortie = dateSortie;
		this.langue = langue;
		Edition = edition;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getNombrePage() {
		return nombrePage;
	}


	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}


	public int getTom() {
		return tom;
	}


	public void setTom(int tom) {
		this.tom = tom;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Date getDateSortie() {
		return dateSortie;
	}


	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}


	public String getLangue() {
		return langue;
	}


	public void setLangue(String langue) {
		this.langue = langue;
	}


	public String getEdition() {
		return Edition;
	}


	public void setEdition(String edition) {
		Edition = edition;
	}


	public Genre getGenre2() {
		return genre2;
	}


	public void setGenre2(Genre genre2) {
		this.genre2 = genre2;
	}


	public Emprunter getEmprunter() {
		return emprunter;
	}


	public void setEmprunter(Emprunter emprunter) {
		this.emprunter = emprunter;
	}


	public Edition getEdition2() {
		return edition2;
	}


	public void setEdition2(Edition edition2) {
		this.edition2 = edition2;
	}


	public Auteur getAuteur2() {
		return auteur2;
	}


	public void setAuteur2(Auteur auteur2) {
		this.auteur2 = auteur2;
	}


	public Tva getTva() {
		return tva;
	}


	public void setTva(Tva tva) {
		this.tva = tva;
	}


	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	public Collection<Type> getTypes() {
		return types;
	}


	public void setTypes(Collection<Type> types) {
		this.types = types;
	}


	public Collection<abonnement> getAbonnements() {
		return abonnements;
	}


	public void setAbonnements(Collection<abonnement> abonnements) {
		this.abonnements = abonnements;
	}


	public Collection<LigeCommande> getLigeCommandes() {
		return ligeCommandes;
	}


	public void setLigeCommandes(Collection<LigeCommande> ligeCommandes) {
		this.ligeCommandes = ligeCommandes;
	}


	public Collection<Actualiter> getActualiters() {
		return actualiters;
	}


	public void setActualiters(Collection<Actualiter> actualiters) {
		this.actualiters = actualiters;
	}


	@Override
	public String toString() {
		return "Manga [nom=" + nom + "]";
	}
	

}
