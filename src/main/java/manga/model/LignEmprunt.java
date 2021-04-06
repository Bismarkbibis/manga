package manga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LignEmprunt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(length = 40)
	int qte;
	@Column(length = 40)
	int tom;
	
	@ManyToOne
	private Manga manga;
	@ManyToOne
	private Emprunter emprunter;
	public LignEmprunt() {
		super();
	}
	public LignEmprunt(int qte, int tom) {
		super();
		this.qte = qte;
		this.tom = tom;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getTom() {
		return tom;
	}
	public void setTom(int tom) {
		this.tom = tom;
	}
	public Manga getManga() {
		return manga;
	}
	public void setManga(Manga manga) {
		this.manga = manga;
	}
	public Emprunter getEmprunter() {
		return emprunter;
	}
	public void setEmprunter(Emprunter emprunter) {
		this.emprunter = emprunter;
	}
	@Override
	public String toString() {
		return "LignEmprunt [id=" + id + ", qte=" + qte + ", tom=" + tom + ", manga=" + manga + ", emprunter="
				+ emprunter + "]";
	}
	
	

	
}
