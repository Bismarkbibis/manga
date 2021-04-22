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
public class Penaliter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
//
//	public static final boolean active;
//	public static final boolean bloquer;
	@Column(length = 30)
	private boolean compte;
	
	@OneToMany(mappedBy = "penaliter")
	private Collection<Utilisateur> utilisateurs;


	public Penaliter() {
		utilisateurs = new ArrayList<>();
	}

	public Penaliter(boolean compte) {
		super();
		this.compte = compte;
	}

	public boolean isCompte() {
		return compte;
	}

	public void setCompte(boolean compte) {
		this.compte = compte;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
}
