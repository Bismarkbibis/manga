package manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.MangaStatue;

public interface MangaStatueRepository extends JpaRepository<MangaStatue, Integer>{

	@Query("SELECT s FROM MangaStatue s WHERE s.nom =:disponible")
	public Optional<MangaStatue> findMangaStatuNom(String disponible);
}
