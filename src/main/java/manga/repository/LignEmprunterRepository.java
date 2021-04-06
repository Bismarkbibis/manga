package manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manga.model.LignEmprunt;

public interface LignEmprunterRepository extends JpaRepository<LignEmprunt,Integer>{

}
