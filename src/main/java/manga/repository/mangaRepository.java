package manga.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.Manga;
public interface MangaRepository extends JpaRepository<Manga, Integer> {
	@Query("SELECT m FROM Manga m WHERE m.nom=:paraNom")
	public List<Manga> findbyNom(String paraNom);
	
	@Query("SELECT m FROM Manga m WHERE m.numSeri=:paraNumSeri")
	public Optional<Manga> findMangaByNumSeri(String paraNumSeri);
	
	@Query("SELECT m FROM Manga m WHERE m.nom=:paraNom")
	public Optional<Manga> findMangaByNom (String paraNom);
	
	@Query("SELECT m FROM Manga m WHERE m.statut=:parastatut")
	public Optional<Manga> findMangaBystatut(String parastatut);
	
	@Query("SELECT m FROM Manga m WHERE m.tom=:parastom")
	public List<Manga> findMangaByTom(int parastom);
	
	@Query("SELECT m FROM Manga m WHERE m.nom=:paraNom")
	public Manga findMangaOneByNom (String paraNom);
	
	
	@Query("SELECT m FROM Manga m join m.toms t WHERE t.id = :paaraId")
	public Optional<Manga> findTomByNomManga (int paaraId);
	
	
	
//	@Query("SELECT m FROM Manga m WHERE m.tom=:parastom")
//	public Optional<Manga> findMangaByTom(int tom);
	
//	@Query("SELECT m FROM Manga m join m.mangaStatus s WHERE s.id=:paraStatue")
//	public Optional<MangaStatus> findMangaStatue(String paraStatue);
	

}
