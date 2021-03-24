package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Auteur  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(length = 50, nullable = false)
	private String nom;
	
	@Column(length = 50)
	private String prenom;

	//dependance
	@OneToMany(mappedBy = "auteur2")
	private Collection<Manga> mangas;
	
	public Auteur() {
		mangas = new ArrayList<>();
	}

	public Auteur(String nom, String prenom) {
		this();
		this.nom = nom;
		this.prenom = prenom;
	}



	public Collection<Manga> getMangas() {
		return mangas;
	}

	public void setMangas(Collection<Manga> mangas) {
		this.mangas = mangas;
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

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	

}
