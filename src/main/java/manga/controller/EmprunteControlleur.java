package manga.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ResponseStatusException;

import manga.Http.ClientEmprunter;
import manga.Outile.CustomedException;
//import manga.Outile.CustomedException;
import manga.model.Emprunter;
import manga.model.Utilisateur;
import manga.service.AccessSecurityService;
import manga.service.EmprunterService;

@RestController
@CrossOrigin("*")
public class EmprunteControlleur {

	@Autowired
	private AccessSecurityService accessSecurityService;
	@Autowired
	private EmprunterService emprunterService;
	
	@PostMapping("/emprunter")
	public ResponseEntity<Emprunter> ClientEmprunt(HttpServletRequest request,@RequestBody ClientEmprunter bollow) throws CustomedException{
		Utilisateur utilisateur = accessSecurityService.findUserByToken(request);
		if (utilisateur != null) {
			try {
				Emprunter emprunter = emprunterService.EmprunterTom(utilisateur, bollow.getTom(), bollow.getRue(), bollow.getCp(),bollow.getVille());
				System.out.println("<<<<<<<<<<<<<<<<<<<"+emprunter);
				return ResponseEntity.ok(emprunter);
				
			} catch (Exception e) {
				e.printStackTrace(); //Il vous dit ce qui s'est passé et où dans le code cela s'est produit.
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
			}
		}
		return null;
	}
}
