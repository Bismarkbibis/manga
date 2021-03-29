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

import manga.Http.LoginEntrant;
import manga.Http.LoginSortant;
import manga.service.UtilisateurService;


@RestController
@CrossOrigin("*")
public class LoginControlleur {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	//HttpServletRequest : il encapsule les donner de la requete  a voir 
	@PostMapping("/test")
	public String testerPoste(HttpServletRequest request ) {
		String valeurtoken = request.getHeader("Authorization");
		 System.out.println(" requet "+valeurtoken);
		return "bon connexion";
	}
	
	
	//@RequestBody :les information de notre requete on convertie vers un ibjet de type loginentrant
	@PostMapping("/connexion")
	public ResponseEntity<LoginSortant> login(@RequestBody LoginEntrant info) {
	
		try {
			LoginSortant loginSortant=  utilisateurService.login(info.getEmail(), info.getPasseword());
			return ResponseEntity.ok(loginSortant);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
		}
		
	}
}
