package manga.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.Outile.CustomedException;
import manga.model.Emprunter;
import manga.model.Manga;
import manga.model.Reservation;
import manga.model.Tom;
import manga.model.Utilisateur;
import manga.repository.EmprunterRepository;
import manga.repository.MangaRepository;
import manga.repository.ReservationRepository;
import manga.repository.TomRepository;

@Service
public class EmprunterService {
	
	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private EmprunterRepository emprunterRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private TomRepository tomRepository;

	public static final int MAX_EMPRUNTER = 5;
	public static final int MAX_RETOUR = 10;

	private String numEmprunt() {
		UUID uuid = UUID.randomUUID();
		String numEmprunt = uuid.toString();
		return numEmprunt;
	}

	// reservation
	public Reservation clientReserve(Utilisateur utilisateur, List<HashMap<String, String>> mangaRserver)
			throws CustomedException {

		HashMap< String, String> exception = new HashMap<>();

		if (!mangaRserver.isEmpty()) {
			Reservation reservation2 = new Reservation();
			System.out.println(""+reservation2);
			reservation2.setUtilisateur(utilisateur);
			reservation2.setNumero(numEmprunt());
			for (HashMap<String, String> reserve : mangaRserver) {
				System.out.println(""+reservation2);
				int idManga = Integer.valueOf(reserve.get("id"));
				Optional<Manga> manga01 = mangaRepository.findById(idManga);
				System.out.println(""+manga01);
				if (!manga01.isEmpty()) {
					Manga manga = manga01.get();
// gerer le tom du manga
					int tom = Integer.valueOf(reserve.get("Tom"));
					
					Optional<Tom> tomManga = tomRepository.findTomById(tom);
					System.out.println(""+tomManga);
					if (tomManga.isPresent()) {
						Tom tom2 = tomManga.get();
						tom2.setManga(manga);
					} else {
						exception.put("Tom existant", "veuillez choisir un autre tom ce tom n'existe pas ");
					}
					reservation2.setManga(manga);
//					reservation2.setTom(tom);
					reservation2.setPrixHT(manga.getPrix());
					reservation2.setTauxTva(manga.getTva().getTaux());
				} else {
					exception.put("Manga existant", "le manga n'est pas disponible actuellement");
				}
			}
			if (!exception.isEmpty()) {
				CustomedException ex = new CustomedException(exception, "Erreur sur la reservation");
				throw ex;
			}
			reservationRepository.save(reservation2);
			return reservation2;
		}
		return null;
	}

	public Emprunter EmprunterTom(Utilisateur utilisateur, int idTom,String nom,String prenom, String rue,String cp, String ville) throws CustomedException {
		HashMap<String, String> erreur = new HashMap<>();
		
//		Optional<Manga> manga01 = mangaRepository.findTomByNomManga(idTom);
		Optional<Tom> tomManga = tomRepository.findById(idTom);

		if (utilisateur.getNombreEmprunter() >= MAX_EMPRUNTER) {
			erreur.put("Depassement", "Le nombre manga emprunte est depasser");
		}


//		boolean compte = false;
//		if (utilisateur.getPenaliter() ==compte ) {
//			erreur.put("compte bloquer", "votre compte est bloquer veuiller vous renseigner");
//		}

// verifier si le compte est bloquer ou pas
		System.out.println("<<<<<<<<<<<<<<<<<<<SQSSSSSSQQSQS"+tomManga);
			if (tomManga.isPresent()) {
				
				System.out.println("<<<<<<<<<<<<<<<<<<<SQSSSSSSQQSQS"+tomManga);
				Tom tom = tomManga.get();
				if(tom.getTomStatue().equals(Tom.DISPONIBLE)) {
					
					System.out.println("<<<<<<<<QS"+tomManga);
						Emprunter emprunter = new Emprunter();
						emprunter.setUtilisateur(utilisateur);
						emprunter.setNom(utilisateur.getNom());
						emprunter.setPrenom(utilisateur.getPrenom());
						emprunter.setNumEmprunter(numEmprunt());
						emprunter.setCp(cp);
						emprunter.setRue(rue);
						emprunter.setVille(ville);
						
						// date de emprunt
						Date date01 = new Date();
						emprunter.setDateEmprunt(date01);
						// date de retour
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date01);
						calendar.add(Calendar.DATE, 9);
						date01 = calendar.getTime();
						emprunter.setDateRetour(date01);
						
						tom.setEmprunter(emprunter);
//						tom.setManga(manga);

// 						user nombre emprunter
						utilisateur.setNombreEmprunter(utilisateur.getNombreEmprunter() + 1);
						tom.setTomStatue(Tom.PRETER);
						emprunterRepository.save(emprunter);
						return emprunter;
				}
			} else {
				// si livre pas disponible reserver
				erreur.put("Tom Emprunter", "tom deja emprunter");
			}

		if (!erreur.isEmpty()) {
			CustomedException ex = new CustomedException(erreur, "Echec DE L'emprunt");
			throw ex;
		}
		return null;
	}

//	public Emprunter EmprunterManga(Utilisateur utilisateur, int idMaanga, int tom, String rue,String cp, String ville) throws CustomedException {
//		HashMap<String, String> erreur = new HashMap<>();
//		Optional<Manga> manga01 = mangaRepository.findById(idMaanga);
//		Optional<Tom> tomManga = tomRepository.findTomById(tom);
//
//		if (utilisateur.getNombreEmprunter() >= MAX_EMPRUNTER) {
//			erreur.put("Depassement", "Le nombre manga emprunte est depasser");
//		}
//		System.out.println(">>>>>><<<<>>>>>>>><<<<<<   " + utilisateur.getNombreEmprunter() + ">>>>>>>>>>>>>>>>>>>>>");
//
////		boolean compte = false;
////		if (utilisateur.getPenaliter() ==compte ) {
////			erreur.put("compte bloquer", "votre compte est bloquer veuiller vous renseigner");
////		}
//
//// verifier si le compte est bloquer ou pas
//		
//			if (manga01.isPresent()) {
//				Manga manga = manga01.get();
//				System.out.println("<<<<<<<<<<<<<<<<<<<BISMMMMMM"+manga);
//				//String disponible = MangaStatue.DISPONIBLE;
//				if (manga.getNomManagaStatus().equals(Manga.DISPONIBLE)) {
//					System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmcdddddddc" + manga);
//					Emprunter emprunter = new Emprunter();
//					emprunter.setUtilisateur(utilisateur);
//					emprunter.setNom(utilisateur.getNom());
//					emprunter.setPrenom(utilisateur.getPrenom());
//					emprunter.setNumEmprunter(numEmprunt());
//					if (tomManga.isPresent()) {
//						Tom tom2 = tomManga.get();
//						tom2.setManga(manga);
//					} else {
//					erreur.put("Emprunter", "tom deja emprunter");
//					}
//					emprunter.setCp(cp);
//					emprunter.setRue(rue);
//					emprunter.setVille(ville);
//					// date de emprunt
//					Date date01 = new Date();
//					emprunter.setDateEmprunt(date01);
//					// date de retour
//					Calendar calendar = Calendar.getInstance();
//					calendar.setTime(date01);
//					calendar.add(Calendar.DATE, 9);
//					date01 = calendar.getTime();
//					emprunter.setDateRetour(date01);
//
//					manga.setEmprunter(emprunter);
//					manga.setTom(tom);
//					// user nombre emprunter
//					utilisateur.setNombreEmprunter(utilisateur.getNombreEmprunter() + 1);
//					manga.setNomManagaStatus(Manga.PRETER);
//
//					emprunterRepository.save(emprunter);
//					return emprunter;
//				}
//			} else {
//				// si livre pas disponible reserver
//				erreur.put("manga emprunter", "manga deja emprunter");
//			}
//
//		if (!erreur.isEmpty()) {
//			CustomedException ex = new CustomedException(erreur, "Echec DE L'emprunt");
//			throw ex;
//		}
//		return null;
//	}

}
