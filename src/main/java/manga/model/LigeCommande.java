package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Controller;
@Controller
public class LigeCommande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = true, unique = false)
	private Integer Id;
	
	@Column(length = 70,nullable = false)
	private float prixHT;
	@Column(length = 70 ,nullable = false)
	private float tauxTva;
	@Column(length = 70,nullable = false)
	private int qte;
	
	// dependance
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Manga manga;

	public LigeCommande() {
		
	}

	public LigeCommande(float prixHT, float tauxTva, int qte) {
		
		this.prixHT = prixHT;
		this.tauxTva = tauxTva;
		this.qte = qte;
	}
	
	

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public float getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(float tauxTva) {
		this.tauxTva = tauxTva;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "LigeCommande [prixHT=" + prixHT + ", tauxTva=" + tauxTva + ", qte=" + qte + ", commande=" + commande
				+ "]";
	}
	
	
	

}
