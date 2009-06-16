package persistenza.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modello.Prodotto;
import persistenza.PersistenceException;
import persistenza.ProdottoDAO;

public class ProdottoDAOpostgresql implements ProdottoDAO {

	//Dato un oggetto ResultSet costruisce e restituisce il corrispondente oggetto Prodotto
	public Prodotto getProdottoFromResultSet(ResultSet result) throws PersistenceException{
		Prodotto prodotto = new Prodotto();
		try{
			prodotto.setNome(result.getString("nome"));
			prodotto.setDescrizione(result.getString("descrizione"));
			prodotto.setPrezzo(result.getInt("prezzo"));
			prodotto.setId(result.getInt("id"));
			prodotto.setQuantita(result.getInt("quantita"));
			prodotto.setCodice(result.getString("codice"));
		}catch(Exception ex){
			System.out.println("Impossibile estrarre l'ordine:"+ex.getMessage());
		}
		return prodotto;
	}
	
	//Dato l'ID di un prodotto recupera dal DB e costruisce l'oggetto Prodotto corrispondente
	public Prodotto retrieveProdottoByID(int idProdotto) throws PersistenceException {
		Prodotto prodotto = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * " +
						   "FROM prodotti "+
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idProdotto);
			result = statement.executeQuery();
			if (result.next())
				prodotto = getProdottoFromResultSet(result);
		}catch (SQLException e) {
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
		return prodotto;
	}
	
	//Dato il codice di un prodotto recupera dal DB e costruisce l'oggetto Prodotto corrispondente
	public Prodotto retrieveProdottoByCodice(String codiceProdotto) throws PersistenceException {
		Prodotto prodotto = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * " +
						   "FROM prodotti "+
						   "WHERE codice=?";
			statement = connection.prepareStatement(query);
			statement.setString(1,codiceProdotto);
			result = statement.executeQuery();
			if (result.next())
				prodotto = getProdottoFromResultSet(result);
		}catch (SQLException e) {
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
        return prodotto;
	}

	//Ritorna una lista di tutti i prodotti memorizzati nel DB
	public List<Prodotto> retrieveAll() throws PersistenceException{
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * "+
						   "FROM prodotti";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while(result.next())
					prodotti.add(getProdottoFromResultSet(result));	
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
		return prodotti;
	}
		
	//Ritorna una lista di tutti i prodotti disponibili
	public List<Prodotto> retrieveDisponibili() throws PersistenceException{
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * "+
						   "FROM prodotti " +
						   "WHERE quantita > 0";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while(result.next())
					prodotti.add(getProdottoFromResultSet(result));	
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
		return prodotti;
	}
	
	//Ritorna la lista dei prodotti forniti da un fornitore
	public List<Prodotto> retrieveProdottiByIDFornitore(int IDFornitore) throws PersistenceException{
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * "+
						   "FROM prodotti,fornisce " +
						   "WHERE fornisce.idfornitore = ? AND fornisce.idprodotto = prodotti.id";
			statement = connection.prepareStatement(query);
			statement.setInt(1,IDFornitore);
			result = statement.executeQuery();
			while(result.next())
					prodotti.add(getProdottoFromResultSet(result));	
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
		return prodotti;
	}
	
	//Dato un oggetto Prodotto lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveProdotto(Prodotto prodotto) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * " +
						   "FROM prodotti " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,prodotto.getId());
			result = statement.executeQuery();
			if(result.next()){
				query = "UPDATE prodotti " +
						"SET nome=?,descrizione=?,prezzo=?,codice=?,quantita=? " +
						"WHERE id=?";
                statement = connection.prepareStatement(query);
                statement.setString(1,prodotto.getNome());
                statement.setString(2,prodotto.getDescrizione());
                statement.setInt(3,prodotto.getPrezzo());
                statement.setString(4,prodotto.getCodice());
                statement.setInt(5,prodotto.getQuantita());
                statement.setInt(6,prodotto.getId());
            }else{
				query = "INSERT INTO prodotti " +
						"(nome,descrizione,prezzo,codice,quantita,id) " +
						"VALUES (?,?,?,?,?,NEXTVAL('sequenzaprodotti'))";
                statement = connection.prepareStatement(query);
                statement.setString(1,prodotto.getNome());
                statement.setString(2,prodotto.getDescrizione());
                statement.setInt(3,prodotto.getPrezzo());
                statement.setString(4,prodotto.getCodice());
                statement.setInt(5,prodotto.getQuantita());
            }
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

	//Dato l'ID di un Prodotto lo elimina dal DB se presente
	public void deleteProdotto(int idProdotto) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "DELETE " +
						   "FROM prodotti CASCADE " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idProdotto);
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
