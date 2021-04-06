package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class AdresseEmprunt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(nullable = false, length = 70)
	private String nom;

	@Column(nullable = false, length = 70)
	private String prenom;
	
	@Column(nullable = false, length = 70)
	private String rue;
	
	@Column(nullable = false, length = 50)
	private String cp;
	
	@Column(nullable = false, length = 50)
	private String ville;
		
//DEPENDANCE
	@OneToMany
	private Collection<Emprunter> emprunters;


	public AdresseEmprunt() {
		emprunters = new ArrayList<>();
	}


	public AdresseEmprunt( String nom, String prenom, String rue, String cp, String ville) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Collection<Emprunter> getEmprunters() {
		return emprunters;
	}

	public void setEmprunters(Collection<Emprunter> emprunters) {
		this.emprunters = emprunters;
	}

	@Override
	public String toString() {
		return "AdresseEmprunt [nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville
				+ "]";
	}	
	
}
