package manga.Http;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class InsertManga {

	private String numSeri;

	private String nom;

	private String description;

	private String titre;

	private int nombrePage;

	private String imageNum;

	private String auteur;

	private String genre;

	private String statut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortieManag;

	private String langue;

	private String edition;

	private int age;

	private int destination;

	private int tva;

	private float prix;

	
	public InsertManga() {
		
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

	public int getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}

	public String getImageNum() {
		return imageNum;
	}

	public void setImageNum(String imageNum) {
		this.imageNum = imageNum;
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

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
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
