package manga.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class UserControleur {
//
//	@Autowired
//	private UtilisateurService utilisateurService;
//	@Autowired
//	private AccessSecurityService accessSecurityService;
//	
//	@PutMapping("/modification")
//	public void modifUser(HttpServletRequest request,@RequestBody UserModif modif) {
//		Utilisateur utilisateur = accessSecurityService.findUserByToken(request);
//		
//		if (! (utilisateur== null)) {
//			String identifiant =utilisateurService.modifInformation(utilisateur, modif.getIdentifiant());
//		}
//
//	}
}
