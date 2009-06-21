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

    public int getLastSequenceValue(String label) throws PersistenceException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
        int i;
		try{
			//Connessione al DB
			connection = getConnection();
			//Preparazione query
			String query = "SELECT last_value FROM sequenzaordini";
			statement = connection.prepareStatement(query);
            //statement.setString(1, label);
		    //Interrogazione DB
			result = statement.executeQuery();

            result.next();
            i = result.getInt("last_value");

		}catch(Exception ex){
			throw new PersistenceException(ex.getMessage());
		}
		finally {
			try {
				//Chiusura connessione al DB
				if (result != null)
					result.close();
				if (statement != null)
					statement.close();
				if (connection!= null)
					connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
        return i;
    }
}
