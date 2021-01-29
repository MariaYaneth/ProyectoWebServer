package udea.proyecto.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udea.proyecto.springboot.model.Profesores;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesores, Long> {
	Optional<Profesores> findByNombre(String nombre);
}
