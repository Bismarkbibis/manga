package manga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.model.Actualiter;
import manga.model.Manga;
import manga.repository.ActualiterRepository;
import manga.repository.MangaRepository;

@Service
public class MangaService {
	@Autowired
	private ActualiterRepository actualiterRepository;
	@Autowired
	private MangaRepository mangaRepository;
	// envoie tout les manga
	public List<Actualiter> getAllActu() {
		return actualiterRepository.findAll();
	}
	// recherche part nom
	public List<Manga> getMangaByName(String nom){
		List<Manga> mangaNom =mangaRepository.findbyNom(nom);
		return mangaNom;	
	}
	//recherche part disponibiliter 
//	public List<Manga> getAllMangaDisponible() {
//		
//		
//	}
	
}
