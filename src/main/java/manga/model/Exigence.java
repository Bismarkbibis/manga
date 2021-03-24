package manga.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Controller;
@Controller
public class Exigence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private boolean bloque;
	
	private boolean debloque;
	
	///dependance 
	@ManyToOne
	private Utilisateur utilisateur;
	
	
	public Exigence() {
		
	}

	public Exigence(boolean bloque, boolean debloque) {
		
		this.bloque = bloque;
		this.debloque = debloque;
	}

	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}

	public boolean isDebloque() {
		return debloque;
	}

	public void setDebloque(boolean debloque) {
		this.debloque = debloque;
	}

	@Override
	public String toString() {
		return "Exigence [bloque=" + bloque + ", debloque=" + debloque + "]";
	}
	
	

}
