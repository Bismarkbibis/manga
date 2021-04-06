package manga.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import manga.model.Abonnement;
import manga.model.Offre;
import manga.model.Utilisateur;
import manga.repository.AbonnementRepository;
import manga.repository.OffreRepository;

@Service
public class AbonnementService {

	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private AbonnementRepository abonnementRepository;

	public String genereNumbre() {
		UUID uuid = UUID.randomUUID();
		String nombre = uuid.toString();
		return nombre;
	}

	public Abonnement creatAbonnee(Utilisateur user, String offre) {
		// convertir en integer
		int offrEntier = Integer.valueOf(offre);
		Optional<Offre> offreClient = offreRepository.findById(offrEntier);
		if (offreClient.isPresent()) {
//			System.out.println("-----------------------------------" + offreClient);
			Offre offre01 = offreClient.get();
			// la date de creation
			Abonnement abonnement = new Abonnement();
			abonnement.setUtilisateur(user);
			abonnement.setNumeroabonnement(genereNumbre());
			abonnement.setPrix(offre01.getPrixHt());
			abonnement.setNom(user.getNom());
			abonnement.setPrenom(user.getPrenom());
			abonnement.setDate(new Date());
			offre01.setAbonnement(abonnement);
			abonnement.setOffre(offre01);

			abonnementRepository.save(abonnement);
			return abonnement;
		}
		return null;
	}
}
