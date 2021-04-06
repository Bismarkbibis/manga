package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class EmpruntInforClient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 70)
	private String nom;
	@Column(length = 70)
	private String prenom;
	@Column(length = 70)
	private String email;
	@Column(length = 70)
	private long telephone;
	
	@ManyToOne
	private Emprunter emprunters;

	public EmpruntInforClient() {
		
	}

	public EmpruntInforClient(String nom, String prenom, String email, long telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}


	public Emprunter getEmprunters() {
		return emprunters;
	}

	public void setEmprunters(Emprunter emprunters) {
		this.emprunters = emprunters;
	}

	@Override
	public String toString() {
		return "InfoClientEmprunt [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone
				+ "]";
	}
}
