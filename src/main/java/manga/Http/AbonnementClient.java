package manga.Http;

import java.util.Date;

public class AbonnementClient {
	
	private String nome;
	private String prenom;
	private int dure;
	private Date date;
	private String offre;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPrenom() {
		return prenom;
	}	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getDure() {
		return dure;
	}
	public void setDure(int dure) {
		this.dure = dure;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOffre() {
		return offre;
	}
	public void setOffre(String offre) {
		this.offre = offre;
	}

	
	

}
