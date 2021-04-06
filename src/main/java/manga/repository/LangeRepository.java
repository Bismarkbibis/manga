package manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manga.model.Langue;

public interface LangeRepository extends JpaRepository<Langue, Integer>{

}
