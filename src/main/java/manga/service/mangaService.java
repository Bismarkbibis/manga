package manga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.model.Actualiter;
import manga.repository.ActualiterRepository;

@Service
public class mangaService {
	@Autowired
	private ActualiterRepository actualiterRepository;
	
	public List<Actualiter> getAllActu() {
		return actualiterRepository.findAll();
	}
	
}
