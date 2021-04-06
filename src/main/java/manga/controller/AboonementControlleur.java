package manga.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import manga.Http.AbonnementClient;
import manga.model.Abonnement;
import manga.model.Utilisateur;
import manga.service.AbonnementService;
import manga.service.AccessSecurityService;

@RestController
@CrossOrigin
public class AboonementControlleur {

	@Autowired
	private AccessSecurityService accessSecurityService;
	@Autowired
	private AbonnementService abonnementService;
	
	@PostMapping("/abonnement")
	private ResponseEntity<Abonnement> creatAbonnement(HttpServletRequest request,@RequestBody AbonnementClient infoAbonnee){
//		String reque = request.getHeader("Authorization");
//		System.out.println(""+reque);
//		System.out.println(""+infoAbonnee);
		Utilisateur utilisateur= accessSecurityService.findUserByToken(request);
		
		
		if (utilisateur!= null) {
			Abonnement abonnement = abonnementService.creatAbonnee(utilisateur, infoAbonnee.getOffre());
			return ResponseEntity.ok(abonnement);
		} else {
		
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Abonnement incorrecte!");
		
		}
		
	}

	
}
