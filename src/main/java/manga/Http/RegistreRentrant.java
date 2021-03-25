package manga.Http;



public class RegistreRentrant {

	private String nom;
	private String prenom;
	private String identifiant;
	private String dateNaissance;
	private String mdp;
	private String mdp2;
	private String email;
	
	
	public RegistreRentrant() {
		super();
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



	public String getIdentifiant() {
		return identifiant;
	}



	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}



	public String getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getMdp2() {
		return mdp2;
	}



	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "RegistreRentrant [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant
				+ ", dateNaissance=" + dateNaissance + ", email=" + email + "]";
	}

}
