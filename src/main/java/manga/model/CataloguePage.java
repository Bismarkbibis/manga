package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CataloguePage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	public static final String catalogueInviter = "Inviter";
	public static final String catalogueClient = "Client";
	public static final String catalogueAbonnee = "Abonne";

	@Column(nullable = false, length = 15, unique = true)
	private String nom;

	@ManyToOne
	private Manga manga;

	public CataloguePage() {

	}

	public CataloguePage(String nom) {
		super();
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
		return "CataloguePage [manga=" + manga + "]";
	}

}
