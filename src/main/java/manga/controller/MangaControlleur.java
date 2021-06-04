package manga.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import manga.Http.MangaInsert;
import manga.Outile.CustomedException;
import manga.model.Actualiter;
import manga.model.Manga;
import manga.model.Role;
import manga.service.AccessSecurityService;
import manga.service.AdminService;
import manga.service.MangaService;

@RestController
@CrossOrigin("*")
public class MangaControlleur {

	@Autowired
	private AccessSecurityService accessSecurityService;
	@Autowired
	private AdminService admService;;

	@Autowired
	private MangaService mangaService;

	@GetMapping(value = "/mangas")
	private List<Actualiter> getALLL() {
		List<Actualiter> mangas = mangaService.getAllActu();
		return mangas;
	}

	@GetMapping(value = "/manga/{nom}")
	public ResponseEntity<Optional<Manga>> getMangaByName(@PathVariable("nom") String nomManga) {
		Optional<Manga> manga = mangaService.getMangaByName(nomManga);
		return ResponseEntity.ok(manga);
	}

	@GetMapping(value = "/manga/{langue}")
	public ResponseEntity<List<Manga>> getMangaByLangue(@PathVariable("langue") int langueManga) {
		System.out.println("sdddddddddddddddddd");
		List<Manga> mangas = mangaService.selectMangaByLangue(langueManga);
		return ResponseEntity.ok(mangas);
	}

	@PostMapping("/insert-manga")
	public ResponseEntity<Manga> insertManga(HttpServletRequest request, @RequestBody MangaInsert insertManga)
			throws CustomedException {
		boolean userAdmin = accessSecurityService.verifyRole(request, Role.ADMIN);

		String valueToken = request.getHeader("Authorization");
		System.out.println(" token recu " + valueToken);

		if (userAdmin) {
			try {

				Manga manga = admService.insertMangaAdmin(insertManga.getNumSeri(), insertManga.getNom(),
						insertManga.getDescription(), insertManga.getTitre(), insertManga.getimage(),
						insertManga.getAuteur(), insertManga.getGenre(), insertManga.getStatut(),
						insertManga.getDateSortieManag(), insertManga.getLangue(), insertManga.getEdition(),
						insertManga.getAge(), insertManga.getTva(), insertManga.getPrix());
				System.out.println(" token recu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + manga);
				return ResponseEntity.ok(manga);
			} catch (Exception ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
			}
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé!");
	}
}
