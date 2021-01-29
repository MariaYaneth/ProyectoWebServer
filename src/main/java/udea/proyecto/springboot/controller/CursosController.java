package udea.proyecto.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import udea.proyecto.springboot.model.Cursos;
import udea.proyecto.springboot.model.Profesores;
import udea.proyecto.springboot.model.Tareas;
import udea.proyecto.springboot.service.CursosService;

@RestController
@RequestMapping("/curso")
public class CursosController {
	private final Logger log = LoggerFactory.getLogger(EstudianteController.class);

    private CursosService cursosService;
    
    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }
    
    @GetMapping("")
    @ApiOperation(value = "Toda la lista de cursos",  response = Cursos.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cursos listados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Cursos>> getCursos(){
        log.info("Rest request buscar cursos por id");
        return ResponseEntity.ok(cursosService.getCursos());
    }
    
    @GetMapping("{codigo}")
    @ApiOperation(value = "Toda la lista de cursos",  response = Cursos.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cursos listados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Cursos> getCurso(@PathVariable Integer codigo){
        log.info("Rest request buscar cursos por id");
        return ResponseEntity.ok(cursosService.getCurso(codigo));
    }
    
    @PostMapping("")
    @ApiOperation(value = "Crear un curso",  response = Cursos.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Curso creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Cursos> addCursos(@RequestBody Cursos cursos) {
        return ResponseEntity.ok(cursosService.addCursos(cursos));
    }
    
    @PutMapping("")
    @ApiOperation(value = "Actualizar un curso",  response = Cursos.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Curso actualizado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Cursos> updateCurso(@RequestBody Cursos cursos) {
        return ResponseEntity.ok(cursosService.updateCurso(cursos));
    }
    
    @GetMapping("tareas/{codigo}")
    @ApiOperation(value = "Busca lista de tareas por su id",  response = Cursos.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Tareas>> listaTareas(@PathVariable Integer codigo){
        log.info("Rest request buscar lista de tareas por codigo");
        return ResponseEntity.ok(cursosService.listaTareas(codigo));
    }
    

}
