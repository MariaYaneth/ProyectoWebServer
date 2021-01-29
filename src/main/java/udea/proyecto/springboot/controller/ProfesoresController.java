package udea.proyecto.springboot.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import udea.proyecto.springboot.model.Profesores;
import udea.proyecto.springboot.service.ProfesoresService;


@RestController
@RequestMapping("/profesor")
public class ProfesoresController {
	private final Logger log = LoggerFactory.getLogger(userController.class);

    private ProfesoresService profesoresService;
    
    public ProfesoresController(ProfesoresService profesoresService) {
        this.profesoresService = profesoresService;
    }
    
    @GetMapping("")
    @ApiOperation(value = "Toda la lista de estudiantes",  response = Profesores.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuarios listados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Profesores>> getUsers(){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(profesoresService.getProfesores());
    }
    
    @PostMapping("")
    @ApiOperation(value = "Crear un profesor",  response = Profesores.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Profesores> addProfesores(@RequestBody Profesores profesores) {
        return ResponseEntity.ok(profesoresService.addProfesores(profesores));
    }
    
    @GetMapping("{id}")
    @ApiOperation(value = "Busca un Profesor por su id",  response = Profesores.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Profesores> getProfesor(@PathVariable Integer id){
        log.info("Rest request buscar Profesor por id");
        return ResponseEntity.ok(profesoresService.getProfesor(id));
    }
    
    

}
