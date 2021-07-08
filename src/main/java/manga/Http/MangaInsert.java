package manga.Http;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MangaInsert {

	private String numSeri;
	private String nom;
	private String description;
	private String titre;
	private String image;
	private String auteur;
	private String genre;
	private String statut;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortieManag;

	private String langue;
	private String edition;
	private int age;

	private int tva;
	private float prix;

	public MangaInsert() {
		
	}

	public String getNumSeri() {
		return numSeri;
	}

	public void setNumSeri(String numSeri) {
		this.numSeri = numSeri;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getimage() {
		return image;
	}

	public void setimage(String imageNum) {
		this.image = imageNum;
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

	public Date getDateSortieManag() {
		return dateSortieManag;
	}

	public void setDateSortieManag(Date dateSortieManag) {
		this.dateSortieManag = dateSortieManag;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTva() {
		return tva;
	}

	public void setTva(int tva) {
		this.tva = tva;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	
// getteur setteur 



}
