package udea.proyecto.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	private long cedula;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Usuario")
	private String usuario;
	
	@Column(name = "Contraseña")
	private String contraseña;
	

	public User() {
	}

	public long getCedula() {
		return cedula;
	}

	public User(long cedula, String nombre, String usuario, String contraseña) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
