package udea.proyecto.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udea.proyecto.springboot.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long>{	
}
