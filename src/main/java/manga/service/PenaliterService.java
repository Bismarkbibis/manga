package manga.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.model.Emprunter;
import manga.model.Penaliter;
import manga.repository.EmprunterRepository;

@Service
public class PenaliterService {

	@Autowired
	private EmprunterRepository emprunterRepository;
	
	private Penaliter ClientPenaliter(Date paradateRetour) {
		Optional<Emprunter> Emprunte01 = emprunterRepository.findEmprunteBydateRetour(paradateRetour);
		
		return null;
		
	}
}
