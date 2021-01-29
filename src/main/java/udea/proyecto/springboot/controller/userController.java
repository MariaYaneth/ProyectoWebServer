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
import udea.proyecto.springboot.model.User;
import udea.proyecto.springboot.service.userService;

@RestController
@RequestMapping("/user")
public class userController {
	
    private final Logger log = LoggerFactory.getLogger(userController.class);

    private userService Service;
    
    public userController(userService Service) {
        this.Service = Service;
    }

	public Boolean comprobarUsuario(String usuario, String contraseña) {
		return true;
	}
    @PostMapping("")
    @ApiOperation(value = "Crear un usuario",  response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(Service.addUser(user));
    }
	
    @GetMapping("usuarios")
    @ApiOperation(value = "Toda la lista de usuarios",  response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuarios listados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<User>> getUsers(){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(Service.getUsers());
    }
	
    @GetMapping("{cedula}")
    @ApiOperation(value = "Busca un hero por su id",  response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<User> getUser(@PathVariable long cedula){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(Service.getUser(cedula));
    }

}
