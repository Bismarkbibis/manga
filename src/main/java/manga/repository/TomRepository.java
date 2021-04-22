package manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import manga.model.Tom;

public interface TomRepository extends JpaRepository<Tom, Integer> {

//	@Query("select t from Tom t JOIN t.manga m where m.Id =:paraManga")
//	public Optional<Tom> findTomById(int paraManga);
//	
	@Query("select t from Tom t WHERE t.id =:tomManga")
	public Optional<Tom> findTomById(int tomManga);
	
	@Query("SELECT t FROM Tom t WHERE t.nom=:paraNom")
	public Optional<Tom> findTomByNom (String paraNom);
	

}
