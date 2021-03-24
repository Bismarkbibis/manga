package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Controller;


@Controller
public class Tva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50,nullable = false)
    private String nom;
	
	@Column(nullable = false)
    private float taux;
	
	//dependance
	@OneToMany(mappedBy = "tva")
	private Collection<Manga> mangas;

	public Tva() {
		mangas = new ArrayList<>();
	}

	public Tva(String nom, float taux) {
		this();
		this.nom = nom;
		this.taux = taux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public Collection<Manga> getMangas() {
		return mangas;
	}

	public void setMangas(Collection<Manga> mangas) {
		this.mangas = mangas;
	}

	@Override
	public String toString() {
		return "Tva [nom=" + nom + ", taux=" + taux + "]";
	}
}
