package manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manga.model.abonnement;

public interface AbonnementRepository extends JpaRepository<abonnement, Integer> {

}
