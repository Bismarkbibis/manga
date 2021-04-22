package manga.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import manga.model.Actualiter;
import manga.model.Manga;
import manga.service.MangaService;

@RestController
@CrossOrigin("*")
public class mangaController {
	
	@Autowired
	private MangaService mangaService;
	
	@GetMapping("/mangas")
	private List<Actualiter> getALLL(){
		List<Actualiter> mangas=mangaService.getAllActu();
		return mangas;
	}
	@GetMapping("/manga/{nom}")
	public ResponseEntity<List<Manga>> getMangaByName(@PathVariable("nom") String nomManga){
		List<Manga> manga= mangaService.getMangaByName(nomManga);
		return ResponseEntity.ok(manga);
	}
	
}
