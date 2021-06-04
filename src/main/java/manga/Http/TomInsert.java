package manga.Http;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class TomInsert {

	private String nom;
	private String manga;
	private int numero;
	private int nombrePage;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateSortir;

	private String numImage;
	private String titre;
	private float prix;
	private String description;

	public String getNom() {
		return nom;
	}

	public String getManga() {
		return manga;
	}

	public int getNumero() {
		return numero;
	}

	public int getNombrePage() {
		return nombrePage;
	}

	public Date getDateSortir() {
		return dateSortir;
	}

	public String getNumImage() {
		return numImage;
	}

	public String getTitre() {
		return titre;
	}

	public float getPrix() {
		return prix;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "InsertTom [nom=" + nom + ", manga=" + manga + ", numero=" + numero + ", nombrePage=" + nombrePage
				+ ", dateSortir=" + dateSortir + ", numImage=" + numImage + ", titre=" + titre + ", prix=" + prix
				+ ", description=" + description + "]";
	}

}
