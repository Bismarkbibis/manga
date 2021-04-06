package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Offre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String premiere = "0-12 ans";
	public static final String deuxieme ="13-17 ans";
	public static final String troisiem ="18 ++";
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nom;
	@Column(length = 100)
	private float prixHt;
	
	//dependance
	@OneToOne
	private Abonnement abonnement;
	@ManyToOne
	private TvaAbonnement tvaAbonnement;
	
	
	public Offre() {
		
	}
	public Offre(String detaills, float prixHt) {
		
		this.nom = detaills;
		this.prixHt = prixHt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String detaills) {
		this.nom = detaills;
	}
	public float getPrixHt() {
		return prixHt;
	}
	public void setPrixHt(float prixHt) {
		this.prixHt = prixHt;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	
	public TvaAbonnement getTvaAbonnement() {
		return tvaAbonnement;
	}
	public void setTvaAbonnement(TvaAbonnement tvaAbonnement) {
		this.tvaAbonnement = tvaAbonnement;
	}
	@Override
	public String toString() {
		return "Offre [detaills=" + nom + ", prixHt=" + prixHt + "]";
	}

}
