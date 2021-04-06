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
public class CompteStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ACTIVE = "Abonnement-Active";
	public static final String FERMER ="Abonnement-Annuler";
	public static final String LISTENOIR ="Abonnement-ListeNoir";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(length = 50)
	private String nom;
	
	@OneToMany(mappedBy = "compteStatus")
	private Collection<Abonnement> abonnements;

	public CompteStatus() {
		abonnements = new ArrayList<>();
	}

	public CompteStatus(String nom) {
		this();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	@Override
	public String toString() {
		return "CompteStatus [nom=" + nom + ", abonnements=" + abonnements + "]";
	}
	

}
