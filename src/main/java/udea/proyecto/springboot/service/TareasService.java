package udea.proyecto.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import udea.proyecto.springboot.exception.BusinessException;
import udea.proyecto.springboot.model.Tareas;
import udea.proyecto.springboot.repository.TareasRepository;
import udea.proyecto.springboot.util.Messages;


@Service
public class TareasService {
	private TareasRepository tareasRepository;
    private Messages messages;

    public TareasService (TareasRepository tareasRepository, Messages messages){
        this.messages = messages;
        this.tareasRepository = tareasRepository;
    }
    
    public Tareas addTarea(Tareas tarea){
        Optional<Tareas> optionalTarea = tareasRepository.findById(tarea.getId());
        if(optionalTarea.isPresent()){
            throw new BusinessException(messages.get("exception.data_duplicate_name.user"));
        }
        return tareasRepository.save(tarea);
    }
    public List<Tareas> getTareas(){
        return tareasRepository.findAll();
    }
    
    public Tareas updateTarea(Tareas tarea){
        return tareasRepository.save(tarea);
    }
}
