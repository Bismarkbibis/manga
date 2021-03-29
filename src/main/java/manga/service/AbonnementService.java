package manga.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.model.Offre;
import manga.model.Utilisateur;
import manga.model.abonnement;
import manga.repository.OffreRepository;

@Service
public class AbonnementService {

	@Autowired
	private OffreRepository offreRepository;

	public String genereNumbre() {
		UUID uuid = UUID.randomUUID();
		String nombre = uuid.toString();
		return nombre;
	}

	public abonnement creatAbonnee(Utilisateur user, String offre, String email) {

		Optional<Offre> offreClient = offreRepository.findRoleByNom(offre);
		if (offreClient.isPresent()) {
			Offre offre01 = offreClient.get();
			// la date de creation
			abonnement abonnement = new abonnement();
			abonnement.set
		} else {
			return null;
		}

		return null;
	}
}
