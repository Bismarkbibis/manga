package manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manga.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{
	

}
