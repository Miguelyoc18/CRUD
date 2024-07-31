package modelo.clasesmodelo;

public class AlumnosModelo {

	
	/*Variables-Atributos*/
	private int id;
	private String nombres;
	private String apellidos;
	private int edad;
	
	
	/*Método constructor*/

	public AlumnosModelo(int id, String nombres, String apellidos, int edad) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	/*Getters y Setters*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
		
}
