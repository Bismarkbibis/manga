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
public class Tom implements Serializable {

	/**
	 * 
	 */
	public static final String RESERVER = "Manga-Reserer";
	public static final String DISPONIBLE = "Manga-Disponible";
	public static final String PRETER = "Manga-PRETER";

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(length = 50)
	private String nom;
	@Column(length = 50)
	private String numImage;
	@Column(length = 50)
	private int numero;
	@Column(length = 50)
	private String tomStatue;
	@Column(length = 50)
	private String numSeri;
	@Column(length = 100)
	private String titre;
	@Column(length = 50)
	private float prix;
	@Column(length = 200)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeSortie;
	@JsonIgnore
	@ManyToOne
	private Manga manga;
	@JsonIgnore
	@ManyToOne
	private MangaStatue mangaStatue;
	@ManyToOne
	private Emprunter emprunter;
	@JsonIgnore
	@OneToMany(mappedBy = "manga")
	private Collection<Commentaire> commentaires;

	public Tom() {
		commentaires = new ArrayList<>();
	}

	public Tom(String nom, String numImage, int numero, String nomManagaStatus, String numSeri, String titre,
			float prix, String description, Date dateDeSortie) {
		this();
		this.nom = nom;
		this.numImage = numImage;
		this.numero = numero;
		this.tomStatue = nomManagaStatus;
		this.numSeri = numSeri;
		this.titre = titre;
		this.prix = prix;
		this.description = description;
		this.dateDeSortie = dateDeSortie;
	}

	public String getTomStatue() {
		return tomStatue;
	}

	public void setTomStatue(String tomStatue) {
		this.tomStatue = tomStatue;
	}

	public String getNumSeri() {
		return numSeri;
	}

	public void setNumSeri(String numSeri) {
		this.numSeri = numSeri;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MangaStatue getMangaStatue() {
		return mangaStatue;
	}

	public void setMangaStatue(MangaStatue mangaStatue) {
		this.mangaStatue = mangaStatue;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	public Date getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public String getNumImage() {
		return numImage;
	}

	public void setNumImage(String numImage) {
		this.numImage = numImage;
	}

	public Emprunter getEmprunter() {
		return emprunter;
	}

	public void setEmprunter(Emprunter emprunter) {
		this.emprunter = emprunter;
	}

	@Override
	public String toString() {
		return "Tom [nom=" + nom + ", numImage=" + numImage + ", numero=" + numero + ", dateDeSortie=" + dateDeSortie
				+ "]";
	}
}
