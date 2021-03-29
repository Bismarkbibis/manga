package manga.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String USER = "ROLE_USER";
	public static final String ADMIN ="ROLE_ADMIN";
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 50)
	private String nom;

	@OneToMany(mappedBy = "role")
	private Collection<Utilisateur> utilisateurs;
	
	public Role() {
		utilisateurs =new  ArrayList<>();
	}

	public Role(String role) {
		this();
		this.nom = role;
	}
	
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRole() {
		return nom;
	}

	public void setRole(String role) {
		this.nom = role;
	}

	@Override
	public String toString() {
		return "Role [role=" + nom + "]";
	}
}
