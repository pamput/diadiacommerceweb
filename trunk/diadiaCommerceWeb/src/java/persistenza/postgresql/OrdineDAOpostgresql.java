package persistenza.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import persistenza.*;

import modello.Ordine;
import modello.Prodotto;
import modello.RigaOrdine;
import persistenza.PersistenceException;

public class OrdineDAOpostgresql implements OrdineDAO{

	//Dato un oggetto ResultSet costruisce e restituisce un oggetto Ordine
	public Ordine getOrdineFromResultSet(ResultSet result) throws PersistenceException{
		Ordine ordine = new OrdineProxy();
		try{
			ordine.setCodice(result.getString("codice"));
			ordine.setID(result.getInt("id"));
			ordine.setData(result.getDate("data"));
			ordine.setStato(result.getString("stato"));
			ordine.setCliente(new ClienteDAOpostgresql().retrieveClienteByID(result.getInt("idcliente")));
		}catch(Exception ex){
			System.out.println("Impossibile estrarre l'ordine:"+ex.getMessage());
		}
		return ordine;
	}
	
	//Dato un codice ordine recupera dal DB e costruisce l'oggetto Ordine corrispondente
	public Ordine retrieveOrdineByCodice(String codiceOrdine) throws PersistenceException{
		Ordine ordine = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			//Connessione al DB
			connection = dataSource.getConnection();
			//Interrogazione DB
			String retrieve = "SELECT * "+
							  "FROM ordini "+
							  "WHERE codice=?";
			statement = connection.prepareStatement(retrieve);
			statement.setString(1, codiceOrdine);
			result = statement.executeQuery();
			if (result.next())
				ordine = getOrdineFromResultSet(result);
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
		return ordine;		
	}
	
	//Dato l'ID di un ordine recupera dal DB e costruisce l'oggetto Ordine corrispondente
	public Ordine retrieveOrdineByID(int idOrdine) throws PersistenceException{
		Ordine ordine = null;
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			//Connessione al DB
			connection = dataSource.getConnection();
			//Interrogazione DB
			String retrieve = "SELECT * "+
							  "FROM ordini "+
							  "WHERE id=?";
			statement = connection.prepareStatement(retrieve);
			statement.setInt(1,idOrdine);
			result = statement.executeQuery();
			if (result.next())
				ordine = getOrdineFromResultSet(result);
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
		return ordine;		
	}
	
	//Ritorna una lista di tutti gli ordini memorizzati nel DB
	public List<Ordine> retrieveAll() throws PersistenceException{
		List<Ordine> ordini = new LinkedList<Ordine>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {			
			connection = dataSource.getConnection();
			String query = "SELECT * "+
						   "FROM ordini";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while(result.next())
					ordini.add(getOrdineFromResultSet(result));	
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
		return ordini;
	}
	
	//Dato un l'ID di un cliente recupera dal DB e costruisce la lista degli oggetti Ordine corrispondenti
	public List<Ordine> retrieveOrdineByIDCliente(int idCliente) throws PersistenceException{
		List<Ordine> ordini = new LinkedList<Ordine>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {	
			//Connessione al DB
			connection = dataSource.getConnection();
			//Interrogazione DB
			String retrieve = "SELECT * "+
							  "FROM ordini "+
							  "WHERE idcliente=?";
			statement = connection.prepareStatement(retrieve);
			statement.setInt(1,idCliente);
			result = statement.executeQuery();
			while(result.next())
				ordini.add(getOrdineFromResultSet(result));
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
		return ordini;		
	}
	
	//Dato un oggetto Ordine lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveOrdine(Ordine ordine) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

			//Preparazione query
			String query = "SELECT * " +
						   "FROM ordini " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,ordine.getID());
			result = statement.executeQuery();
			if(result.next()){
				query = "UPDATE ordini " +
						"SET idcliente=?,data=?,stato=?,codice=? " +
						"WHERE id=?";
                statement = connection.prepareStatement(query);
                statement.setInt(1,ordine.getCliente().getID());
                statement.setDate(2,ordine.getData());
                statement.setString(3,ordine.getStato());
                statement.setString(4,ordine.getCodice());
                statement.setInt(5,ordine.getID());
            }else{
				query = "INSERT INTO ordini " +
						"(idcliente,data,stato,codice,id) " +
						"VALUES (?,?,?,'ORD' || NEXTVAL('sequenzacodiceordine'),NEXTVAL('sequenzaordini'))";
                statement = connection.prepareStatement(query);
                statement.setInt(1,ordine.getCliente().getID());
                statement.setDate(2,ordine.getData());
                statement.setString(3,ordine.getStato());
            }
            RigaOrdineDAOpostgresql rigaOrdineDAO = new RigaOrdineDAOpostgresql();
            int successcount = 0;

            //Interrogazione DB
			successcount += statement.executeUpdate();
            int id = dataSource.getLastSequenceValue("sequenzacodiceordine");
            ordine.setID(id);

            for(int i = 0;i < ordine.getRigheOrdine().size();i++){
                successcount += rigaOrdineDAO.saveRigaOrdine(ordine.getRigheOrdine().get(i), ordine, connection);
            }

            if(successcount != 1+ordine.getRigheOrdine().size())
                connection.rollback();
            else
                connection.commit();
		}catch(Exception ex){
            try {
                connection.rollback();
                throw new PersistenceException("Transaction failed: " + ex.getMessage());
            } catch (SQLException sqx) {
                throw new PersistenceException("Rollback failed: " + sqx.getMessage());
            }
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
	
	//Dato l'ID di un Ordine lo elimina dal DB se presente
	public void deleteOrdine(int idOrdine) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "DELETE " +
						   "FROM ordini " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idOrdine);
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

    //Evade un ordine aggiornando al disponibilita dei prodotti
    public void evadiOrdine(Ordine ordine) throws PersistenceException{
        DataSource dataSource = new DataSource();
		Connection connection = null;
        PreparedStatement updateProd = null;
        PreparedStatement updateOrd = null;
        try {
            //Connessione al DB
			connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            String aggiornamentoProdotti = "";
            for(int i=0;i<ordine.getRigheOrdine().size();i++){
                aggiornamentoProdotti = aggiornamentoProdotti + "UPDATE prodotti SET quantita=(quantita - ?) WHERE codice = ? ;";
            }
            updateProd = connection.prepareStatement(aggiornamentoProdotti);
            int cont = 1;
            for(int i=0;i<ordine.getRigheOrdine().size();i++){
                updateProd.setInt(cont, ordine.getRigheOrdine().get(i).getQuantita());
                cont++;
                updateProd.setString(cont, ordine.getRigheOrdine().get(i).getProdotto().getCodice());
                cont++;
            }

            updateOrd = connection.prepareStatement("UPDATE ordini SET stato = 'evaso' where id=?");
            updateOrd.setInt(1, ordine.getID());

            int nProd = updateProd.executeUpdate();
            int nOrd  = updateOrd.executeUpdate();
            if (nProd+nOrd != 2)
            	connection.rollback();
            else
                connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
                throw new PersistenceException("Transaction failed: " + ex.getMessage());
            } catch (SQLException sqx) {
                throw new PersistenceException("Rollback failed: " + sqx.getMessage());
            }
      }finally {
			try {
				//Chiusura connessione al DB
				if (updateOrd != null)
					updateOrd.close();
				if (updateProd != null)
					updateProd.close();
				if (connection!= null)
					connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
    }


}
