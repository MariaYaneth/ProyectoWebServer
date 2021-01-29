package udea.proyecto.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import udea.proyecto.springboot.repository.ProfesoresRepository;
import udea.proyecto.springboot.exception.BusinessException;
import udea.proyecto.springboot.model.Profesores;
import udea.proyecto.springboot.util.Messages;


@Service
public class ProfesoresService {
	private ProfesoresRepository profesoresRepository;
    private Messages messages;

    public ProfesoresService(ProfesoresRepository profesoresRepository, Messages messages){
        this.messages = messages;
        this.profesoresRepository = profesoresRepository;
    }
    
    public Profesores addProfesores(Profesores profesores){
        Optional<Profesores> optionalProfesores = profesoresRepository.findById(profesores.getCedula());
        if(optionalProfesores.isPresent()){
            throw new BusinessException(messages.get("exception.data_duplicate_name.user"));
        }
        return profesoresRepository.save(profesores);
    }
    public List<Profesores> getProfesores(){
        return profesoresRepository.findAll();
    }
    
    public Profesores getProfesor(long id){
        return profesoresRepository.findById(id).get();
    }
    
}

