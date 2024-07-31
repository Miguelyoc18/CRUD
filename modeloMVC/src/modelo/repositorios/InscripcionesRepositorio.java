package modelo.repositorios;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.Interface.InterfaceRepositorio;
import modelo.clasesmodelo.*;
import modelo.conexion.ConexionDB;

public class InscripcionesRepositorio implements InterfaceRepositorio<InscripcionesModelo> {
	
	private AlumnosRepositorio alumnosRepositorio = new AlumnosRepositorio();
	private CursosRepositorio cursosRepositorio = new CursosRepositorio();

	@Override
	public InscripcionesModelo recuperarID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InscripcionesModelo> recuperarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregar(InscripcionesModelo entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(InscripcionesModelo entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(InscripcionesModelo entidad) {
		// TODO Auto-generated method stub
		
	}
	
	private List<InscripcionesModelo> dameListaInscripciones(ResultSet resultset){
		
		return null;
	}


}
