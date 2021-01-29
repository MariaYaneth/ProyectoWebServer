package udea.proyecto.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udea.proyecto.springboot.model.Estudiante;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

}
