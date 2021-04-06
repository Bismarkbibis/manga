package manga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import manga.Http.RegistreRentrant;
import manga.model.Utilisateur;
import manga.service.UtilisateurService;

@RestController
@CrossOrigin("*")
public class RegistreControlleur {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@PostMapping("/inscrption")
	public ResponseEntity<Utilisateur> creatUser(@RequestBody RegistreRentrant Info){
		try {
			Utilisateur user =utilisateurService.createUser(Info.getNom(), Info.getPrenom(),Info.getIdentifiant(), Info.getAge(),Info.getNumero(), Info.getEmail(),Info.getMdp(), Info.getMdp2());
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			System.out.println("les donnee : "+Info);
			e.printStackTrace(); //Il vous dit ce qui s'est passé et où dans le code cela s'est produit.
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}	
	}
}
