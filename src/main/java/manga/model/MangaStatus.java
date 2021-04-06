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
public class MangaStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	
	public static final String RESERVER = "Manga-Reserer";
	public static final String DISPONIBLE ="Manga-Disponible";
	public static final String PERDU ="Manga-PERDU";
	public static final String PRETER ="Manga-PRETER";

	@Column(length = 50)
	private String nom;
	
	@OneToMany(mappedBy = "mangaStatus")
	private Collection<Manga> mangas;

	public MangaStatus() {
		mangas = new ArrayList<>();
	}
	
	
	

	public MangaStatus(String nom) {
		this();
		this.nom = nom;
	}




	public Collection<Manga> getMangas() {
		return mangas;
	}

	public void setMangas(Collection<Manga> mangas) {
		this.mangas = mangas;
	}

	@Override
	public String toString() {
		return "MangaStatus [mangas=" + mangas + "]";
	}
}
