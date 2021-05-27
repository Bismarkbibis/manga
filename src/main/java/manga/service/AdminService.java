package manga.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.Outile.CustomedException;
import manga.model.Auteur;
import manga.model.CataloguePage;
import manga.model.Edition;
import manga.model.Genre;
import manga.model.Langue;
import manga.model.Manga;

import manga.model.Tom;
import manga.model.Tva;
import manga.model.Utilisateur;
import manga.repository.AuteurRepository;
import manga.repository.CataloguePageRepository;
import manga.repository.EditionRepository;
import manga.repository.GenreRepository;
import manga.repository.LangueRepository;
import manga.repository.MangaRepository;
import manga.repository.TomRepository;
import manga.repository.TvaRepository;

@Service
public class AdminService {

	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private AuteurRepository auteurRepository;
	@Autowired
	private LangueRepository langueRepository;
	@Autowired
	private TvaRepository tvaRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private EditionRepository editionRepository;
	@Autowired
	private CataloguePageRepository cataloguePageRepository;
	@Autowired
	private TomRepository tomRepository;


	public List<Manga> mangas() {
		List<Manga> mangas = mangaRepository.findAll();
		return mangas;
	}

	public Optional<Manga> seachMangaByName(String nom) {
		Optional<Manga> mangaName = mangaRepository.findMangaByNom(nom);
		return mangaName;
	}

	public Optional<Manga> seachMangaByStatus(String statue) {
		Optional<Manga> mangaStatus = mangaRepository.findMangaBystatut(statue);
		return mangaStatus;
	}

// a tester pou rplus tard attribuer un numSerie directement base de donnee
	public String NumeroSeri() {
		UUID uuid = UUID.randomUUID();
		String nume = uuid.toString();
		return nume;
	}

	
// insertion d'un manga
	public Manga insertMangaAdmin(String numSeri, String nom, String description, String titre, int nombrePage,
			String imageNum,String auteur, String genre, String statut, Date dateSortieManag, String langue,
			String edition, int age, int destination, int tva, float prix) throws CustomedException {

		HashMap<String, String> erreurs = new HashMap<>();
//		numSeri = numSeriManga();
		Optional<Manga> numSeriMaanga = mangaRepository.findMangaByNumSeri(numSeri);
// a discuter
		Optional<Tva> tva01 = tvaRepository.findById(tva);
		Optional<Auteur> auteur01 = auteurRepository.findAuteurByName(nom);
		Optional<Genre> genre01 = genreRepository.findGenreByName(genre);
		Optional<Langue> langue01 = langueRepository.findGenreBylangue(langue);
		Optional<Edition> edition01 = editionRepository.findGenreByEdition(edition);
		Optional<CataloguePage> catalogue01 = cataloguePageRepository.findById(destination);

		if (!numSeriMaanga.isPresent()) {
			Manga manga01 = new Manga();
			manga01.setNom(nom);
			manga01.setDescription(description);
			manga01.setNumSeri(numSeri);
			manga01.setNombrePage(nombrePage); //supprimer
			manga01.setNumImage(imageNum);
			manga01.setTom(0);
			manga01.setDateSortie(dateSortieManag);
			manga01.setTitre(titre);
			manga01.setAge(age);
			manga01.setPrix(prix);
			manga01.setStatut(true);
			manga01.setTva(tva01.get());

			// Auteur
			if (auteur01.isPresent()) {
				Auteur auteur2 = auteur01.get();
				manga01.setAuteur(auteur2);
			} else {
				Auteur auteur2 = new Auteur();
				auteur2.setNom(auteur);
				manga01.setAuteur(auteur2);
				auteurRepository.save(auteur2);
			}
			// Genre
			if (genre01.isPresent()) {
				Genre genre2 = genre01.get();
				manga01.setGenre(genre2);
			} else {
				Genre genre2 = new Genre();
				genre2.setNom(genre);
				manga01.setGenre(genre2);
				genreRepository.save(genre2);
			}
			// langue
			if (langue01.isPresent()) {
				Langue langue2 = langue01.get();
				manga01.setLangue(langue2);
			} else {
				Langue langue2 = new Langue();
				langue2.setNom(langue);
				manga01.setLangue(langue2);
				langueRepository.save(langue2);
			}

			// Edition
			if (edition01.isPresent()) {
				Edition edition2 = edition01.get();
				manga01.setEdition(edition2);
			} else {
				Edition edition2 = new Edition();
				edition2.setNom(edition);
				manga01.setEdition(edition2);
				editionRepository.save(edition2);
			}
			// catalogue
			if (catalogue01.isPresent()) {
				CataloguePage cataloguePage = catalogue01.get(); // recuperation de catalogue concernee;
				cataloguePage.setManga(manga01);
			} else {
				erreurs.put("Destination introvable",
						"page introvable veuiller verifier votre choix de catalogur 1: Inviter 2: Client 3: Abonne");
			}
			// save manga
			mangaRepository.save(manga01);
			return manga01;

		} else {
			erreurs.put("Manga existant", "ce manga existe deja veuilleur insert une autre");
			CustomedException ex = new CustomedException(erreurs, "Echec de l'insertion");
			throw ex;
		}
	}

	public Tom insertTomManga(Utilisateur utilisateur, String nom, String Manga, int numero, int nombrePage,
			Date dateSortir,String numImage,String titre,float prix,String description) throws CustomedException {
		HashMap<String, String> erreurInsertTom = new HashMap<>();

		Optional<Manga> manga = mangaRepository.findMangaByNom(Manga);
		Optional<Tom> tom = tomRepository.findTomByNom(nom);
		
		if (manga.isPresent()) {
			Manga manga2 = manga.get();
			
			if (tom.isPresent()) {
				erreurInsertTom.put("Deja existant", "Le tom que vous essayer de inserer est deja existant ");
			} else {
				Tom tom01 = new Tom();
				tom01.setNom(nom);
				tom01.setNumero(numero);
				tom01.setNumSeri(NumeroSeri());
				tom01.setNumImage(numImage);
				tom01.setDateDeSortie(dateSortir);
				tom01.setDescription(description);
				tom01.setTitre(titre);
				tom01.setPrix(prix);
				tom01.setStatut(true);

				tom01.setManga(manga2);
				tomRepository.save(tom01);
				return tom01;
			}
		} else {
			erreurInsertTom.put("Le manga n'existe pas", "Le manga que vous essayer de inserer un tom n'existe pas ");
		}
		if (!erreurInsertTom.isEmpty()) {
			CustomedException exception = new CustomedException(erreurInsertTom);
			throw exception;
		}

		return null;

	}
	
	
}
