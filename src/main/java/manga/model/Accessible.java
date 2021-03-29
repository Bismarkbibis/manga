package manga.model;

import java.io.Serializable;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Accessible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	
	public static final String premiere = "0-12 ans";
	public static final String deuxieme ="13-17 ans";
	public static final String troisiem ="18 ++ ans";
	
	@OneToMany(mappedBy ="accessible")
	private Manga manga;

	
	public Accessible() {
		
	}


	public Manga getManga() {
		return manga;
	}


	public void setManga(Manga manga) {
		this.manga = manga;
	}


	@Override
	public String toString() {
		return "Accessible [premiere=" + premiere + ", deuxieme=" + deuxieme + ", troisiem=" + troisiem + ", manga="
				+ manga + "]";
	}

}
