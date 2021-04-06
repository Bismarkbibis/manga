package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Manga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(length = 50,nullable =  false)
	private String nom;
	@Column(length = 50,nullable =  false)
	private String numSeri;
	@Column(nullable = false)
	private String numImage;
	@Column(length = 100,nullable =  false)
	private String titre;
	@Column(length = 50,nullable =  false)
	private float prix ;
	@Column(length = 200,nullable =  false)
	private String description;

	@Column(length = 50,nullable =  false)
	private int nombrePage;

	@Column(length = 50,nullable =  false)
	private int tom;

	@Column(length = 50,nullable =  false)
	private String statut;

	@Column(length = 50,nullable =  false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortie;

	@Column(length = 50,nullable =  false)
	private int age;

	// dependance
	@ManyToOne
	private Genre genre;
	@ManyToOne
	private Edition edition;
	@ManyToOne
	private Auteur auteur;
	@ManyToOne
	private Tva tva;
	@ManyToOne
	private MangaStatus mangaStatus;

	@ManyToOne
	private Langue langue;

	@OneToMany(mappedBy = "manga")
	private Collection<Commentaire> commentaires;
	@OneToMany(mappedBy = "manga")
	private Collection<Type> types;
	@OneToMany(mappedBy = "manga")
	private Collection<Abonnement> abonnements;
	@OneToMany(mappedBy = "manga")
	private Collection<LigeCommande> ligeCommandes;
	@OneToMany(mappedBy = "manga")
	private Collection<Actualiter> actualiters;
	@OneToMany(mappedBy = "manga")
	private Collection<CataloguePage> cataloguePages;

	public Manga() {
		commentaires = new ArrayList<>();
		types = new ArrayList<>();
		abonnements = new ArrayList<>();
		ligeCommandes = new ArrayList<>();
		actualiters = new ArrayList<>();
		cataloguePages = new ArrayList<>();
	}

	public Manga(String nom, String numSeri, String numImage, String titre, String description, int nombrePage, int tom,
			String statut, Date dateSortie, int age,float prix ) {
		this();
		this.nom = nom;
		this.numSeri = numSeri;
		this.numImage = numImage;
		this.titre = titre;
		this.description = description;
		this.nombrePage = nombrePage;
		this.tom = tom;
		this.statut = statut;
		this.dateSortie = dateSortie;
		this.prix=prix;
		this.age = age;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Collection<CataloguePage> getCataloguePages() {
		return cataloguePages;
	}

	public void setCataloguePages(Collection<CataloguePage> cataloguePages) {
		this.cataloguePages = cataloguePages;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumSeri() {
		return numSeri;
	}

	public void setNumSeri(String numSeri) {
		this.numSeri = numSeri;
	}

	public String getNumImage() {
		return numImage;
	}

	public void setNumImage(String numImage) {
		this.numImage = numImage;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Tva getTva() {
		return tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}
	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
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

	public Collection<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<Abonnement> abonnements) {
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
	
	

	public MangaStatus getMangaStatus() {
		return mangaStatus;
	}

	public void setMangaStatus(MangaStatus mangaStatus) {
		this.mangaStatus = mangaStatus;
	}

	@Override
	public String toString() {
		return "Manga [nom=" + nom + "]";
	}

}
