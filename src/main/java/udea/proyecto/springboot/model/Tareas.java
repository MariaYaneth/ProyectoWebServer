package udea.proyecto.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas")
public class Tareas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Fecha")
	private String fecha;
	

	@Column(name = "Nota")
	private float nota;
	
	@ManyToOne
	@JoinColumn(name = "cursos_id")
	private Cursos curso;
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Tareas(int id, String nombre, String fecha, float nota, Cursos curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.nota = nota;
		this.curso = curso;
	}

	public Tareas() {
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	
	
	
	
}
