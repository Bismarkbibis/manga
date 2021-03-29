package manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.Offre;


public interface OffreRepository extends JpaRepository<Offre, Integer> {

	@Query("select o from Offre o where o.nom = :roleNom")
	public Optional<Offre> findRoleByNom(String roleNom);
}
