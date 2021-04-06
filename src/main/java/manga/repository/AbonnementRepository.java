package manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.Abonnement;


public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {

	
	@Query("select a from Abonnement a where a.numeroabonnement = :paraAbonnement")
	public Optional<Abonnement> findCliendByIdentifiant(String paraAbonnement);
}
