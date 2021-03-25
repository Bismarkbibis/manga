package manga.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.Outile.CustomedException;
import manga.model.Role;
import manga.model.Utilisateur;
import manga.repository.RoleRepository;
import manga.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private PasswordEncoderService passwordEncoderService;
	@Autowired
	private RoleRepository roleRepository;

	HashMap<String, String> erreurs = new HashMap<>();

	public Utilisateur createUser(String nom, String prenom, String identifiant, String dateNaissance, String email,
			String mdp01, String mdp02) throws CustomedException, java.text.ParseException {
		// verification de date de niassance

		// verification identifiant
		Optional<Utilisateur> optionalIdentifant = utilisateurRepository.chercherUtilisateurParidentifiant(identifiant);
		if (optionalIdentifant.isPresent()) {
			erreurs.put("identifant present", "idenfiant est deja utiliser veuiller choisir un autre");
		}

		// verification email
		String regex = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*";
		if (!email.matches(regex)) {
			erreurs.put("errEmail", "email incprrecte");
		}

		Optional<Utilisateur> optionUtilisateur = utilisateurRepository.chercherUtilisateurParEmail(email);
		if (optionUtilisateur.isPresent()) {
			erreurs.put("errEmail", "Email existe dejas");
		}

		// verification du mdp
		if (!mdp01.equals(mdp02) || !mdp02.equals(mdp01)) {
			erreurs.put("erreur Mots de passe ", "Les mots de passe ne sont pas identiques");
		} else if (mdp01.equals(mdp02) && mdp01.length() > 10) {
			erreurs.put("erreursMdp", "il faut au moins 10 caractères pour Mdp");
		}

		if (!erreurs.isEmpty()) {
			CustomedException ex = new CustomedException(erreurs, "Echec de l'inscription");
			throw ex;
		}

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		// a modifier
		utilisateur.setDateNaissance(dateNaissance);
		String encodPasseword = passwordEncoderService.encoder(mdp01);
		utilisateur.setMdp(encodPasseword);
		utilisateur.setEmail(email);
		Optional<Role> optional = roleRepository.findRoleByNom(Role.USER);
		Role roleUser = optional.get();
		utilisateur.setRole(roleUser);
		utilisateurRepository.save(utilisateur);

		return utilisateur;
	}

}