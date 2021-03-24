package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Controller;

@Controller
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(length = 100,nullable = false)
	private String identifian;
	
	@Column(length = 50)
	private String nom;
	
	@Column(length = 50)
	private String prenom;
	
	@Column(length = 100,unique = true)
	private String email;
	
	@Column(length = 50)
	private Date dateNaissance;
	
	@Column(nullable = false, unique = true)
	private String mdp;
	
	
/// dependance 
	
	@OneToMany
	private Role role;
	
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Token> tokens;
	
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Adresse> adresses;
	
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Exigence> exigences;
	
	@OneToMany(mappedBy = "utilisateur")
	private  Collection<abonnement> abonnements;
	
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Emprunter> emprunters;
	
	public Utilisateur() {
		emprunters = new  ArrayList<>();
		abonnements = new ArrayList<>();
		exigences = new ArrayList<>();
		commentaires = new ArrayList<>();
		adresses = new ArrayList<>();
		tokens = new ArrayList<>();
	}

	public Utilisateur(String identifian, String nom, String prenom, String email, Date dateNaissance, String mdp) {
	    this();
		this.identifian = identifian;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.mdp = mdp;
	}
	
	

	public Collection<abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public Collection<Emprunter> getEmprunters() {
		return emprunters;
	}

	public void setEmprunters(Collection<Emprunter> emprunters) {
		this.emprunters = emprunters;
	}

	public Collection<Exigence> getExigences() {
		return exigences;
	}

	public void setExigences(Collection<Exigence> exigences) {
		this.exigences = exigences;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Collection<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Collection<Token> getTokens() {
		return tokens;
	}

	public void setTokens(Collection<Token> tokens) {
		this.tokens = tokens;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdentifian() {
		return identifian;
	}

	public void setIdentifian(String identifian) {
		this.identifian = identifian;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [identifian=" + identifian + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", dateNaissance=" + dateNaissance + ", mdp=" + mdp + "]";
	}
	
	
	
}
