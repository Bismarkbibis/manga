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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(length = 50, nullable = false)
	private String numSeri;
	@Column(nullable = false)
	private String numImage;
	@Column(length = 100, nullable = false)
	private String titre;
	@Column(length = 50, nullable = false)
	private float prix;
	@Column(length = 200, nullable = false)
	private String description;
	@Column(length = 50, nullable = false)
	private int tom;

	@Column(nullable = false)
	private boolean statut = false;

	@Column(length = 50, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortie;

	@Column(length = 50, nullable = false)
	private int age;

	// dependance
	@JsonIgnore
	@ManyToOne
	private Genre genre;
	@JsonIgnore
	@ManyToOne
	private Edition edition;
	@JsonIgnore
	@ManyToOne
	private Auteur auteur;
	@JsonIgnore
	@ManyToOne
	private Tva tva;
	@JsonIgnore
	@ManyToOne
	private Langue langue;
	@JsonIgnore
	@ManyToOne
	private Emprunter emprunter;
	@JsonIgnore
	@OneToMany(mappedBy = "manga")
	private Collection<Commentaire> commentaires;
	@JsonIgnore
	@OneToMany(mappedBy = "manga")
	private Collection<Type> types;
	@JsonIgnore
	@OneToMany(mappedBy = "manga")
	private Collection<LigneCommande> ligeCommandes;
	@JsonIgnore
	@OneToMany(mappedBy = "manga")
	private Collection<Actualiter> actualiters;
	@JsonIgnore
	@OneToMany(mappedBy = "manga")
	private Collection<Reservation> reservations;
	@JsonIgnore
	@OneToMany(mappedBy ="manga")
	private Collection<Tom> toms;
	
	public Manga() {
		commentaires = new ArrayList<>();
		types = new ArrayList<>();
		ligeCommandes = new ArrayList<>();
		actualiters = new ArrayList<>();
		reservations = new ArrayList<>();
		toms = new ArrayList<>();
	}

	public Manga(String nom, String numSeri, String numImage, String titre, String description, int tom,
			boolean statut, Date dateSortie, int age, float prix) {
		this();
		this.nom = nom;
		this.numSeri = numSeri;
		this.numImage = numImage;
		this.titre = titre;
		this.description = description;
		this.tom = tom;
		this.statut = statut;
		this.dateSortie = dateSortie;
		this.prix = prix;
		this.age = age;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Collection<Tom> getToms() {
		return toms;
	}

	public void setToms(Collection<Tom> toms) {
		this.toms = toms;
	}

	public Emprunter getEmprunter() {
		return emprunter;
	}

	public void setEmprunter(Emprunter emprunter) {
		this.emprunter = emprunter;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
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

	public int getTom() {
		return tom;
	}

	public void setTom(int tom) {
		this.tom = tom;
	}



	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
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

	public Collection<LigneCommande> getLigeCommandes() {
		return ligeCommandes;
	}

	public void setLigeCommandes(Collection<LigneCommande> ligeCommandes) {
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
		return "Manga [id=" + id + ", nom=" + nom + ", numSeri=" + numSeri + ", numImage=" + numImage + ", titre="
				+ titre + ", prix=" + prix + ", description=" + description + ", tom=" + tom + ", statut=" + statut
				+ ", dateSortie=" + dateSortie + ", age=" + age + ", genre=" + genre + ", edition=" + edition
				+ ", auteur=" + auteur + ", tva=" + tva + ", langue=" + langue + ", emprunter=" + emprunter
				+ ", commentaires=" + commentaires + ", types=" + types + ", ligeCommandes=" + ligeCommandes
				+ ", actualiters=" + actualiters + ", reservations=" + reservations + ", toms=" + toms + "]";
	}
	


}
