package manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer> {

	@Query("SELECT m FROM Manga m WHERE m.numSeri=:paraNumSeri")
	public Optional<Manga> findMangaByNumSeri(String paraNumSeri);
}
