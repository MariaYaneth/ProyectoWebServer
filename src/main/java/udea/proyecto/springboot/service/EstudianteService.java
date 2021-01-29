package udea.proyecto.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import udea.proyecto.springboot.exception.BusinessException;
import udea.proyecto.springboot.model.Estudiante;
import udea.proyecto.springboot.repository.EstudianteRepository;
import udea.proyecto.springboot.util.Messages;

@Service
public class EstudianteService {
	private EstudianteRepository estudianteRepository;
    private Messages messages;

    public EstudianteService(EstudianteRepository estudianteRepository, Messages messages){
        this.messages = messages;
        this.estudianteRepository = estudianteRepository;
    }
    
    public Estudiante addEstudiante(Estudiante estudiante){
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(estudiante.getCedula());
        if(optionalEstudiante.isPresent()){
            throw new BusinessException(messages.get("exception.data_duplicate_name.user"));
        }
        return estudianteRepository.save(estudiante);
    }
    public List<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }
    
    public Estudiante updateHero(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
}
