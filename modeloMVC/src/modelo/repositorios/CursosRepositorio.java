package modelo.repositorios;

import modelo.conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Interface.InterfaceRepositorio;
import modelo.clasesmodelo.CursosModelo;

public class CursosRepositorio implements InterfaceRepositorio<CursosModelo> {

	@Override
	public CursosModelo recuperarID(int id) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "SELECT * FROM alumnos WHERE id = ?";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				return dameEntidadResultSet(resultSet);
			} catch (SQLException e) {
				System.out.println("Error al recuperar resultSet" + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar la consulta" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<CursosModelo> recuperarTodo() {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "SELECT * FROM cursos";
			try (Statement statement = conexion.createStatement();
					ResultSet resultset = statement.executeQuery(consulta);) {
				return this.listaCursos(resultset);
			} catch (SQLException e) {
				System.out.println("Error al recuperar el resultset" + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar el resultset" + e.getMessage());
		}
		return null;
	}

	@Override
	public void agregar(CursosModelo entidad) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "INSERT INTO cursos (nombre_curso, descripcion) VALUES (?,?)";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setString(1, entidad.getNombreCurso());
				preparedStatement.setString(2, entidad.getDescripcion());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error al recuperar el resultSet" + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar consulta" + e.getMessage());
		}
	}

	@Override
	public void modificar(CursosModelo entidad) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "UPDATE cursos SELECT nombre_curso = ?, descripcion = ?, WHERE id = ?";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setString(1, entidad.getNombreCurso());
				preparedStatement.setString(2, entidad.getDescripcion());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error al recuperar el resultSet" + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar consulta" + e.getMessage());
		}

	}

	@Override
	public void eliminar(CursosModelo entidad) {
		try (Connection conexion = ConexionDB.obtenerConexion()) {
			String consulta = "DELETE FROM cursos WHERE id = ?";
			try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
				preparedStatement.setInt(1, entidad.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error al recuperar el resultSet" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error al recuperar consulta" + e.getMessage());
		}

	}

	private List<CursosModelo> listaCursos(ResultSet resultSet) {
		List<CursosModelo> cursos = new ArrayList<CursosModelo>();
		try (resultSet) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombreCurso = resultSet.getString("nombre_curso");
				String descripcion = resultSet.getString("descripcion");
				cursos.add(new CursosModelo(id, nombreCurso, descripcion));
			}
		} catch (Exception e) {
			System.out.println("Error al recuperar para lista de cursos");
		}
		return cursos;
	}

	private CursosModelo dameEntidadResultSet(ResultSet resultSet) {
		int id = 0;
		String nombreCurso = "";
		String descripcion = "";
		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				nombreCurso = resultSet.getString("nombre_curoso");
				descripcion = resultSet.getString("descripcion");
			}
			return new CursosModelo(id, nombreCurso, descripcion);
		} catch (Exception e) {
			System.out.println("Error al recuperar resultSet");
		}
		return null;
	}

}
