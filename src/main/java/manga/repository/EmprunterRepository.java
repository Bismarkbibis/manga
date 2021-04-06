package manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manga.model.Emprunter;

public interface EmprunterRepository extends JpaRepository<Emprunter, String>{

}
