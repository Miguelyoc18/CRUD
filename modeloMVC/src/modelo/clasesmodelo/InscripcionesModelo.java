package modelo.clasesmodelo;

public class InscripcionesModelo {

	/* Variables-Atributos */
	private int alumnosId;
	private int cursosId;
	private int diaInscripcion;

	/* Método constructor */
	public InscripcionesModelo(int alumnosId, int cursosId, int diaInscripcion) {
		this.alumnosId = alumnosId;
		this.cursosId = cursosId;
		this.diaInscripcion = diaInscripcion;
	}

	/* Getters y Setters */
	public int getAlumnosId() {
		return alumnosId;
	}

	public void setAlumnosId(int alumnosId) {
		this.alumnosId = alumnosId;
	}

	public int getCursosId() {
		return cursosId;
	}

	public void setCursosId(int cursosId) {
		this.cursosId = cursosId;
	}

	public int getDiaInscripcion() {
		return diaInscripcion;
	}

	public void setDiaInscripcion(int diaInscripcion) {
		this.diaInscripcion = diaInscripcion;
	}

}
