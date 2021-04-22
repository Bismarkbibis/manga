package manga.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import manga.Http.ClientCommentaire;
import manga.model.Commentaire;
import manga.model.Utilisateur;
import manga.service.AccessSecurityService;
import manga.service.CommentaireService;

@RestController
@CrossOrigin("*")
public class CommentaireControlleur {

	@Autowired
	private AccessSecurityService accessSecurityService;
	@Autowired
	private CommentaireService commentaireService;
	
	
	@PostMapping("/avis")
	public ResponseEntity<Commentaire> getAllAvisInsert(HttpServletRequest request,
			@RequestBody ClientCommentaire avisClient01) {

		Utilisateur utilisateur = accessSecurityService.findUserByToken(request);
		if (!(utilisateur == null)) {
			try {
				Commentaire avis= commentaireService.insertAvis(utilisateur, avisClient01.getIdManga(), avisClient01.getAvis());
				return ResponseEntity.ok(avis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
			}	
		}
		return null;
	}
	
	@GetMapping("/manga/avis")
	public ResponseEntity<List<Commentaire>> getAllAvis(){
		List<Commentaire> commentaires =commentaireService.getAllCommentaire();
		return ResponseEntity.ok(commentaires);
	}
	
	

}
