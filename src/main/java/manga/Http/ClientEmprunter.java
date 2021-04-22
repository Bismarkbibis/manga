package manga.Http;

public class ClientEmprunter {



	private int idManga;

	private int tom;

	private String nom;

	private String prenom;

	private String rue;

	private String cp;

	private String ville;

	public ClientEmprunter( int idManga, int tom, String nom, String prenom, String rue, String cp,
			String ville) {
		super();
		
		this.idManga = idManga;
		this.tom = tom;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}

	public int getTom() {
		return tom;
	}

	public void setTom(int tom) {
		this.tom = tom;
	}

	public int getIdManga() {
		return idManga;
	}

	public void setIdManga(int idManga) {
		this.idManga = idManga;
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

	@Override
	public String toString() {
		return "AdressLivraison [nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville
				+ "]";
	}

}
