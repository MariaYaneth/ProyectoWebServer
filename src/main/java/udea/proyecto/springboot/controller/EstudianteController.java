package udea.proyecto.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import udea.proyecto.springboot.model.Estudiante;
import udea.proyecto.springboot.service.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	private final Logger log = LoggerFactory.getLogger(EstudianteController.class);

    private EstudianteService estudianteService;
    
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }
    
    @GetMapping("")
    @ApiOperation(value = "Toda la lista de estudiantes",  response = Estudiante.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuarios listados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Estudiante>> getUsers(){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(estudianteService.getEstudiantes());
    }
    
    @PostMapping("")
    @ApiOperation(value = "Crear un estudiante",  response = Estudiante.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Estudiante> addEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.addEstudiante(estudiante));
    }
    
    @PutMapping("")
    @ApiOperation(value = "Actualizar un estudiante",  response = Estudiante.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero actualizado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Estudiante> updateHero(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.updateHero(estudiante));
    }
    

}


