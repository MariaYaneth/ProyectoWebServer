package udea.proyecto.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import udea.proyecto.springboot.exception.BusinessException;
import udea.proyecto.springboot.model.Cursos;
import udea.proyecto.springboot.model.Tareas;
import udea.proyecto.springboot.repository.CursosRepository;
import udea.proyecto.springboot.util.Messages;

@Service
public class CursosService {
	private CursosRepository cursosRepository;
    private Messages messages;

    public CursosService(CursosRepository cursosRepository, Messages messages){
        this.messages = messages;
        this.cursosRepository = cursosRepository;
    }
    
    public Cursos addCursos(Cursos cursos){
        Optional<Cursos> optionalCurso = cursosRepository.findById(cursos.getCodigo());
        if(optionalCurso.isPresent()){
            throw new BusinessException(messages.get("exception.data_duplicate_name.user"));
        }
        return cursosRepository.save(cursos);
    }
    public List<Cursos> getCursos(){
        return cursosRepository.findAll();
    }
    
    public Cursos updateCurso(Cursos cursos){
        return cursosRepository.save(cursos);
    }
    
    public Cursos getCurso(long codigo) {
    	return cursosRepository.findById(codigo).get();
    }
    
    public List<Tareas> listaTareas(long codigo){
    	return cursosRepository.findById(codigo).get().getTareas();
    }
}
