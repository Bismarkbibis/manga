package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = true, unique = false)
	private Integer Id;
	
	@Column(length = 70, nullable = false)
	private String nom;
	
	//dependance
	
	@ManyToOne
	private Manga manga;

	public Type() {
		
	}

	public Type(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	@Override
	public String toString() {
		return "Type [nom=" + nom + "]";
	}
	
	
	

}
