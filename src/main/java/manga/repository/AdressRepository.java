package manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manga.model.Adresse;

public interface AdressRepository extends JpaRepository<Adresse, Integer> {

}
