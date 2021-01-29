package udea.proyecto.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Cursos")
public class Cursos {
	
	@Id
	private long codigo;
	
	@Column(name = "Curso")
	private String nombre;
	
	@Column(name = "Creditos")
	private int creditos;
	
	@Column(name = "Imagen")
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name = "profesor_id")
	private Profesores profesor;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tareas> tareas = new ArrayList<>();
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}

	public Cursos() {
		
	}
	public Cursos(long codigo, String nombre, int creditos, Profesores profesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.profesor = profesor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Tareas> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tareas> tareas) {
		this.tareas = tareas;
	}

	
	

}
