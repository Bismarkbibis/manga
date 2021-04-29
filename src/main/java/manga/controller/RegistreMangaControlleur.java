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

import manga.Http.InsertManga;
import manga.Outile.CustomedException;
import manga.model.Manga;
import manga.model.Role;
import manga.service.AccessSecurityService;
import manga.service.AdminService;

@RestController
@CrossOrigin("*")
public class RegistreMangaControlleur {

	@Autowired
	private AccessSecurityService accessSecurityService; 
	@Autowired
	private AdminService admService;;
	
	@PostMapping("/insert-manga")
	public ResponseEntity<Manga> insertManga(HttpServletRequest request,@RequestBody InsertManga insertManga) throws CustomedException{
		boolean userAdmin = accessSecurityService.verifyRole(request, Role.ADMIN);
		
		String valueToken = request.getHeader("Authorization");
		System.out.println(" token recu " + valueToken);
		
		if (userAdmin) {
			try {
			
				Manga manga = admService.insertMangaAdmin(insertManga.getNumSeri(),insertManga.getNom(),insertManga.getDescription(),insertManga.getTitre(),insertManga.getNombrePage(),insertManga.getImageNum(),insertManga.getAuteur(),insertManga.getGenre(),insertManga.getStatut(),insertManga.getDateSortieManag(),insertManga.getLangue()
						, insertManga.getEdition(),insertManga.getAge(),insertManga.getDestination(),insertManga.getTva(), insertManga.getPrix());
				
				System.out.println(" token recu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + valueToken);
				return ResponseEntity.ok(manga);
			} catch (Exception ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
			}
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé!");
	}
}
