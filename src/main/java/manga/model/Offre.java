package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Controller;

@Controller
public class Offre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String detaills;
	@Column(length = 50, nullable = false)
	private float prixHt;
	
	//dependance
	@ManyToOne
	private abonnement abonnement;
	@ManyToOne
	private Offre offres;
	
	
	public Offre() {
		
	}
	public Offre(String detaills, float prixHt) {
		
		this.detaills = detaills;
		this.prixHt = prixHt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDetaills() {
		return detaills;
	}
	public void setDetaills(String detaills) {
		this.detaills = detaills;
	}
	public float getPrixHt() {
		return prixHt;
	}
	public void setPrixHt(float prixHt) {
		this.prixHt = prixHt;
	}
	public abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public Offre getOffres() {
		return offres;
	}
	public void setOffres(Offre offres) {
		this.offres = offres;
	}
	@Override
	public String toString() {
		return "Offre [detaills=" + detaills + ", prixHt=" + prixHt + "]";
	}

}
