package persistenza.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;

import modello.Cliente;
import persistenza.ClienteDAO;
import persistenza.PersistenceException;

public class ClienteDAOpostgresql implements ClienteDAO {

	//Dato un oggetto ResultSet costruisce e restituisce un oggetto Cliente
	public Cliente getClienteFromResultSet(ResultSet result) throws PersistenceException {
		Cliente cliente = new ClienteProxy();
		try{
			cliente.setNome(result.getString("nome"));
			cliente.setID(result.getInt("id"));
			cliente.setPartitaiva(result.getString("partitaiva"));
			cliente.setIndirizzo(result.getString("indirizzo"));
			cliente.setCodice(result.getString("codice"));
		}catch(Exception ex){
			throw new PersistenceException(ex.getMessage());
		}
		return cliente;
	}
	
	//Dato l'Id di un cliente recupera dal DB e costruisce l'oggetto Cliente corrispondente
	public Cliente retrieveClienteByID(int idCliente) throws PersistenceException {
		Cliente cliente = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {	
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * "+
						   "FROM clienti "+
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idCliente);
			//Interrogazione DB
			result = statement.executeQuery();
			if (result.next())
				cliente = getClienteFromResultSet(result);
		}
		catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
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
		return cliente;
	}
	
	//Dato un codice cliente recupera dal DB e costruisce l'oggetto Cliente corrispondente
	public Cliente retrieveClienteByCodice(String codiceCliente) throws PersistenceException {
		Cliente cliente = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {	
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * "+
						   "FROM clienti "+
						   "WHERE codice=?";
			statement = connection.prepareStatement(query);
			statement.setString(1,codiceCliente);
			//Interrogazione DB
			result = statement.executeQuery();
			if (result.next())
				cliente = getClienteFromResultSet(result);
		}
		catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
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
		return cliente;
	}
	
	//Restituisce la lista di tutti i clienti memorizzati nel DB
	public List<Cliente> getClienti() throws PersistenceException{
		List<Cliente> clienti = new LinkedList<Cliente>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * "+
						   "FROM clienti";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while(result.next())
					clienti.add(getClienteFromResultSet(result));	
		}
		catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		finally {
			try {
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
		return clienti;
	}
	
	//Dato un oggetto Cliente lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveCliente(Cliente cliente) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * " +
						   "FROM clienti " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,cliente.getID());
			result = statement.executeQuery();
            boolean exists = false;
			if(result.next()){
				query = "UPDATE clienti " +
						"SET indirizzo=?,nome=?,codice=?,partitaiva=? " +
						"WHERE id=?";
                        exists = true;
            }else{
				query = "INSERT INTO clienti " +
						"(id,indirizzo,nome,codice,partitaiva) " +
						"VALUES (NEXTVAL('sequenzaclienti'),?,?,?,?)";
            }
            statement = connection.prepareStatement(query);
            statement.setString(1,cliente.getIndirizzo());
            statement.setString(2,cliente.getNome());
            statement.setString(3,cliente.getCodice());
            statement.setString(4,cliente.getPartitaiva());
            if(exists)
                statement.setInt(5,cliente.getID());
		    //Interrogazione DB
			statement.executeUpdate();
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
	}
	
	//Dato l'ID di un Cliente lo elimina dal DB se presente
	public void deleteCliente(int idCliente) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "DELETE " +
						   "FROM clienti " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idCliente);
		    //Interrogazione DB
			statement.executeUpdate();
		}catch(Exception ex){
			throw new PersistenceException(ex.getMessage());
		}
		finally {
			try {
				//Chiusura connessione al DB
				if (statement != null) 
					statement.close();
				if (connection!= null)
					connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
}
