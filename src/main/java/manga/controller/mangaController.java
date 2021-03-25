package manga.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import manga.model.Actualiter;

import manga.service.mangaService;

@RestController
@CrossOrigin("*")
public class mangaController {
	
	@Autowired
	private mangaService MangaService;
	
	@GetMapping("/mangas")
	private List<Actualiter> getALLL(){
		List<Actualiter> mangas=MangaService.getAllActu();
		return mangas;
	}
}
