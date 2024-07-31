package modelo.clasesmodelo;

public class CursosModelo {

	/* Variables-Atributos */
	private int id;
	private String nombreCurso;
	private String descripcion;

	/* Método constructor */
	public CursosModelo(int id, String nombreCurso, String descripcion) {
		this.id = id;
		this.nombreCurso = nombreCurso;
		this.descripcion = descripcion;
	}

	/* Getters y Setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
