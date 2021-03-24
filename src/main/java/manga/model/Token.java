package manga.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Controller;

@Controller
public class Token implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(nullable = true)
	private String valeur;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateExpire;

	@ManyToOne
	private Utilisateur  utilisateur;
	
	public Token() {
		
	}

	public Token(String valeur, Date dateExpire) {
		
		this.valeur = valeur;
		this.dateExpire = dateExpire;
	}
	

	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Date getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}

	@Override
	public String toString() {
		return "Token [valeur=" + valeur + ", dateExpire=" + dateExpire + "]";
	}
	
	

}
