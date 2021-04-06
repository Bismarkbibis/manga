package manga.Http;


public class AbonnementClient {
	
	private String offre;

	public String getOffre() {
		return offre;
	}

	public void setOffre(String offre) {
		this.offre = offre;
	}

	@Override
	public String toString() {
		return "AbonnementClient [offre=" + offre + "]";
	}
}
