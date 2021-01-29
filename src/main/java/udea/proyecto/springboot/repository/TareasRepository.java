package udea.proyecto.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udea.proyecto.springboot.model.Tareas;


@Repository
public interface TareasRepository extends JpaRepository<Tareas, Long>{

}
