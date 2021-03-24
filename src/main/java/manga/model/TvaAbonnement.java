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
public class TvaAbonnement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 50,nullable = false)
	private float taux;
	
	@Column(length = 50,nullable = false)
	private String nom;
	
	//dependance 
	@OneToMany(mappedBy = "offres")
	private Collection<Offre> offres;

	public TvaAbonnement() {
		offres = new ArrayList<>();
	}

	public TvaAbonnement(float taux, String nom) {
		this();
		this.taux = taux;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Offre> getOffres() {
		return offres;
	}

	public void setOffres(Collection<Offre> offres) {
		this.offres = offres;
	}

	@Override
	public String toString() {
		return "TvaAbonnement [taux=" + taux + ", nom=" + nom + ", offres=" + offres + "]";
	}
	
	
	
	
	

}
