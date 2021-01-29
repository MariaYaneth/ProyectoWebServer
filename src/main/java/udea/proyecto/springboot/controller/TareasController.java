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
import udea.proyecto.springboot.model.Tareas;
import udea.proyecto.springboot.service.TareasService;

@RestController
@RequestMapping("/tareas")
public class TareasController {
	private final Logger log = LoggerFactory.getLogger(TareasController.class);

    private TareasService tareasService;
    
    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }
    
    @GetMapping("")
    @ApiOperation(value = "Toda la lista de tareas",  response = Tareas.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tareas listados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Tareas>> getTareas(){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(tareasService.getTareas());
    }
    
    @PostMapping("")
    @ApiOperation(value = "Crear una tarea",  response = Tareas.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tarea creada existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Tareas> addTarea(@RequestBody Tareas tarea) {
        return ResponseEntity.ok(tareasService.addTarea(tarea));
    }
    
    @PutMapping("")
    @ApiOperation(value = "Actualizar una tarea",  response = Tareas.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tarea actualizado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Tareas> updateTarea(@RequestBody Tareas tarea) {
        return ResponseEntity.ok(tareasService.updateTarea(tarea));
    }
    
    

}
