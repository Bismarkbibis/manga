package manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.CataloguePage;

public interface CataloguePageRepository extends JpaRepository<CataloguePage, Integer> {

	@Query("SELECT c FROM CataloguePage c WHERE c.nom =:paraCatalogue")
	public Optional<CataloguePage> findByCatalogue(String paraCatalogue);

}
