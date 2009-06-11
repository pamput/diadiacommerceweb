package persistenza.postgresql;

import java.sql.*;
import persistenza.PersistenceException;

public class DataSource {
	private String dbURI = "jdbc:postgresql://127.0.0.1/diadiaCommerce";
	private String userName = "postgres";
	private String password = "postgres";

	public Connection getConnection() throws PersistenceException {
		Connection connection;
		try {
			System.out.print("Acquisizione driver..."); //...
		    Class.forName("org.postgresql.Driver");
		    connection = DriverManager.getConnection(dbURI,userName, password);
		} catch (ClassNotFoundException e) {
			throw new PersistenceException(e.getMessage());
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}
}
