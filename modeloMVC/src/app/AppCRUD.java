package app;

import modelo.clasesmodelo.AlumnosModelo;
import modelo.conexion.ConexionDB;
import modelo.repositorios.AlumnosRepositorio;

public class AppCRUD {

	public static void main(String[] args) {

		 AlumnosRepositorio repositorio = new AlumnosRepositorio();
	        
	        // Crear un nuevo alumno
	        AlumnosModelo nuevoAlumno = new AlumnosModelo(0, "Juan", "Pérez", 25);
	        
	        // Agregar el nuevo alumno a la base de datos
	        repositorio.agregar(nuevoAlumno);
	        
	        // Recuperar y mostrar todos los alumnos para verificar que el nuevo alumno se ha agregado
	        System.out.println("Lista de alumnos después de agregar:");
	        repositorio.recuperarTodo().forEach(System.out::println);
	    }
        
        
    }