package modelo.repositorios;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Interface.*;
import modelo.clasesmodelo.AlumnosModelo;
import modelo.conexion.*;

public class AlumnosRepositorio implements InterfaceRepositorio<AlumnosModelo> {

	@Override
	public AlumnosModelo recuperarID(int id) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "SELECT * FROM alumnos WHERE id = ?";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setInt(1, id);
				return dameEntidadResultSet(preparedStatement.executeQuery());
			} catch (Exception e) {
				System.out.println("Error al crear el ResultSet");
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta recuperarID");
		}
		return null;
	}

	@Override
	public List<AlumnosModelo> recuperarTodo() {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "SELECT * FROM alumnos";
			try (Statement statement = conexion.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				return this.listaAlumnos(resultSet);
			} catch (Exception e) {
				System.out.println("Error al crear el resultSet");
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta");
		}
		return null;
	}

	@Override
	public void agregar(AlumnosModelo entidad) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "INSERT INTO alumnos (nombres, apellidos, edad) VALUES (?,?,?)";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setString(1, entidad.getNombres());
				preparedStatement.setString(2, entidad.getApellidos());
				preparedStatement.setInt(3, entidad.getEdad());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error al crear el preparedStatement" + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}

	}

	@Override
	public void modificar(AlumnosModelo entidad) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "UPDATE alumnos SELECT nombres = ?, apellidos = ?, edad = ?, WHERE id = ?";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setString(1, entidad.getNombres());
				preparedStatement.setString(2, entidad.getApellidos());
				preparedStatement.setInt(3, entidad.getEdad());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Problema para obtener el preparedStatement " + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta " + e.getMessage());
		}

	}

	@Override
	public void eliminar(AlumnosModelo entidad) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "DELETE FROM alumnos WHERE id = ?";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setInt(1, entidad.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error al crear el preparedStatement " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}

	}


	private List<AlumnosModelo> listaAlumnos(ResultSet resultSet) {
		List<AlumnosModelo> alumnos = new ArrayList<AlumnosModelo>();
		try (resultSet) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombres = resultSet.getString("nombres");
				String apellidos = resultSet.getString("apellidos");
				int edad = resultSet.getInt("edad");
				alumnos.add(new AlumnosModelo(id, nombres, apellidos, edad));
			}
		} catch (Exception e) {
			System.out.println("Error al recuperar para lista de alumnos");
		}
		return alumnos;
	}

	private AlumnosModelo dameEntidadResultSet(ResultSet resultSet) {
		int id = 0;
		String nombres = "";
		String apellidos = "";
		int edad = 0;
		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				nombres = resultSet.getString("nombres");
				apellidos = resultSet.getString("apellidos");
				edad = resultSet.getInt("edad");
			}
			return new AlumnosModelo(id, nombres, apellidos, edad);
		} catch (Exception e) {
			System.out.println("Error al recuperar resultSet");
		}
		return null;
	}

}
