package manga.Http;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class InsertTom {

	private String nomTom;

	private int numeroTom;

	private String nomManga;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateSortir;

	private int nombrePage;

	public String getNomTom() {
		return nomTom;
	}

	public void setNomTom(String nomTom) {
		this.nomTom = nomTom;
	}

	public int getNumeroTom() {
		return numeroTom;
	}

	public void setNumeroTom(int numeroTom) {
		this.numeroTom = numeroTom;
	}

	public String getNomManga() {
		return nomManga;
	}

	public void setNomManga(String nomManga) {
		this.nomManga = nomManga;
	}

	public Date getDateSortir() {
		return dateSortir;
	}

	public void setDateSortir(Date dateSortir) {
		this.dateSortir = dateSortir;
	}

	public int getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}

	@Override
	public String toString() {
		return "InsertTom [nomTom=" + nomTom + ", numeroTom=" + numeroTom + ", nomManga=" + nomManga + ", dateSortir="
				+ dateSortir + "]";
	}

}
