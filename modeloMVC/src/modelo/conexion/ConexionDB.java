package modelo.conexion;
import app.AppCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static Connection conexion;
	private static String usuario = "Miguelyoc";
	private static String clave = "Mikymcvd#16020";
	private static int puerto = 3306;
	private static String db = "crud";
	private static String url = "jdbc:mysql://localhost:" + puerto + "/" + db;

	private ConexionDB() {

	}

	public static Connection obtenerConexion() {
		if (conexion == null || estaCerrada(conexion)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection(url, usuario, clave);
				System.out.println("Conexión a la base de datos exitosa");
			} catch (ClassNotFoundException e) {
				System.out.println("Error al cargar el Driver JDBC");
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion;
	}

	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				System.out.println("Conexión a la base de datos cerrada");
			} catch (SQLException e) {
				System.out.println("Error al intentar cerrar la base");
			}
		}
	}

	public static boolean estaCerrada(Connection conn) {
		try {
			return conn == null || conn.isClosed();
		} catch (SQLException e) {
			System.err.println("Error al verificar el estado de la conexión.");
			e.printStackTrace();
			return true;
		}
	}

}
