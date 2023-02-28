package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

	private static final String CONTROLLER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/prueba";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456789";

	static {
		try {
			Class.forName(CONTROLLER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading database");
			e.printStackTrace();
		}
	}

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// System.out.println("The connection has been established successfully");
		} catch (SQLException e) {
			System.out.println("A connection error has occurred");
			e.printStackTrace();
		}
		return conn;
	}

}
