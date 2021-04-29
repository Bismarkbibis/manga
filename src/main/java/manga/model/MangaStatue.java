package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MangaStatue implements Serializable{

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
	
	@OneToMany(mappedBy = "mangaStatue")
	private Collection<Tom> toms;
	
	@OneToMany(mappedBy = "mangaStatue")
	private Collection<Manga> manga;

	public MangaStatue() {
		manga = new ArrayList<>();
		toms = new ArrayList<>();
	}

	public MangaStatue(String nom) {
		this();
		this.nom = nom;
	}
 
	
	public Collection<Tom> getToms() {
		return toms;
	}

	public void setToms(Collection<Tom> toms) {
		this.toms = toms;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Collection<Manga> getManga() {
		return manga;
	}

	public void setManga(Collection<Manga> manga) {
		this.manga = manga;
	}

	@Override
	public String toString() {
		return "MangaStatue [nom=" + nom + ", manga=" + manga + "]";
	}
	
	

}
