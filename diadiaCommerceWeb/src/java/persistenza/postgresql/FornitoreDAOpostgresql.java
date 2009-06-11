package persistenza.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modello.Fornitore;
import persistenza.FornitoreDAO;
import persistenza.PersistenceException;

public class FornitoreDAOpostgresql implements FornitoreDAO{

	//Dato un oggetto ResultSet costruisce e restituisce un oggetto Fornitore
	public Fornitore getFornitoreFromResultSet(ResultSet result) throws PersistenceException{
		Fornitore fornitore = new FornitoreProxy();
		try{
			fornitore.setNome(result.getString("nome"));
			fornitore.setID(result.getInt("id"));
			fornitore.setTelefono(result.getString("telefono"));
			fornitore.setIndirizzo(result.getString("indirizzo"));
		}catch(Exception ex){
			throw new PersistenceException(ex.getMessage());
		}
		return fornitore;
	}
	
	//Dato l'Id di un fornitore recupera dal DB e costruisce l'oggetto Fornitore corrispondente
	public Fornitore retrieveFornitoreByID(int idFornitore) throws PersistenceException{
		Fornitore fornitore = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {	
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * "+
						   "FROM fornitori "+
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idFornitore);
			//Interrogazione DB
			result = statement.executeQuery();
			if (result.next())
				fornitore = getFornitoreFromResultSet(result);
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
		return fornitore;
	}
	
	//Dato il nome di un fornitore recupera dal DB e costruisce l'oggetto Fornitore corrispondente
	public Fornitore retrieveFornitoreByNome(String nomeFornitore) throws PersistenceException{
		Fornitore fornitore = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {	
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * "+
						   "FROM fornitori "+
						   "WHERE nome=?";
			statement = connection.prepareStatement(query);
			statement.setString(1,nomeFornitore);
			//Interrogazione DB
			result = statement.executeQuery();
			if (result.next())
				fornitore = getFornitoreFromResultSet(result);
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
		return fornitore;
	}
	
	//Restituisce la lista di tutti i fornitori memorizzati nel DB
	public List<Fornitore> getFornitori() throws PersistenceException{
		List<Fornitore> fornitori = new LinkedList<Fornitore>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * "+
						   "FROM fornitori";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while(result.next())
					fornitori.add(getFornitoreFromResultSet(result));	
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
		return fornitori;
	}
	
    //Aggiunge  un fornitore al DB. Lo aggiorna se gi� presente.
    public void saveFornitore(Fornitore fornitore) throws PersistenceException {
        DataSource dataSource = new DataSource();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            connection = dataSource.getConnection();
            String query = "SELECT * " +
                    "FROM fornitori " +
                    "WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, fornitore.getID());
            result = statement.executeQuery();
            //Se trova un risultato vuol dire che il fornitore � gi� presente
            boolean exists = false;
            if(result.next()){
                query = "UPDATE fornitori " +
                        "SET nome=?, indirizzo=?, telefono=? " +
                        "WHERE id=?";
                exists = true;
            } else {
                query = "INSERT INTO fornitori (id, nome, indirizzo, telefono)  " +
                        "VALUES (NEXTVAL('sequenzafornitori'), ?, ?, ?)";
            }
            statement = connection.prepareStatement(query);
            statement.setString(1, fornitore.getNome());
            statement.setString(2, fornitore.getIndirizzo());
            statement.setString(3, fornitore.getTelefono());

            if(exists)
                statement.setInt(4, fornitore.getID());
            
            //Salva nel DB
            statement.executeUpdate();
            
            
        } catch(Exception e) {
            throw new PersistenceException(e.getMessage());
        } finally {
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
    
	//Dato l'ID di un Fornitore lo elimina dal DB se presente
	public void deleteFornitore(int idFornitore) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "DELETE " +
						   "FROM fornitori " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idFornitore);
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
	
	//Ritorna la lista dei fornitori che forniscono un certo prodotto
	public List<Fornitore> retrieveFornitoriByCodiceProdotto(String codiceProdotto) throws PersistenceException{
		List<Fornitore> fornitori = new LinkedList<Fornitore>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT DISTINCT fornitori.* " +
                                "FROM prodotti,fornisce, fornitori " +
                                "WHERE fornisce.idprodotto = prodotti.id AND fornisce.idfornitore = fornitori.id AND prodotti.codice = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1,codiceProdotto);
			result = statement.executeQuery();
			while(result.next())
					fornitori.add(getFornitoreFromResultSet(result));	
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
		return fornitori;
	}
	
	//Dato l'ID di un prodotto e l'ID di un fornitore li associa tra loro
	public void associaFornitoreProdotto(int idProdotto,int idFornitore) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "INSERT INTO fornisce (idprodotto,idfornitore) " +
            			   "VALUES (?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idProdotto);
			statement.setInt(2,idFornitore);
			statement.executeUpdate();
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
	}
}
