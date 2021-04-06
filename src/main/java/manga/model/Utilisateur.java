package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String identifiant;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(length = 50, nullable = false)
	private String prenom;

	@Column(length = 100, unique = true)
	private String email;
	@Column(length = 50, nullable = false)
//	private String dateNaissance;
//	@Column(length = 50)
	int age;

	@Column(length = 50)
	private String numerotel;
	@JsonIgnore
	@Column(nullable = false, unique = true)
	private String mdp;

/// dependance 
	@JsonIgnore
	@ManyToOne
	private Role role;
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Token> tokens;
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Commentaire> commentaires;
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Adresse> adresses;
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Abonnement> abonnements;

	public Utilisateur() {

		abonnements = new ArrayList<>();

		commentaires = new ArrayList<>();
		adresses = new ArrayList<>();
		tokens = new ArrayList<>();
	}

	public Utilisateur(String identifiant, String nom, String prenom, String email, int age, String numerotel,
			String mdp) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.numerotel = numerotel;
		this.mdp = mdp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
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

	public String getNumerotel() {
		return numerotel;
	}

	public void setNumerotel(String numerotel) {
		this.numerotel = numerotel;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Token> getTokens() {
		return tokens;
	}

	public void setTokens(Collection<Token> tokens) {
		this.tokens = tokens;
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

	public Collection<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", age=" + age + ", numerotel=" + numerotel + "]";
	}

}
