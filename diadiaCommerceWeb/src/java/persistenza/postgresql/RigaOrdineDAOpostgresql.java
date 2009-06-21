package persistenza.postgresql;

import modello.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import persistenza.*;

public class RigaOrdineDAOpostgresql implements RigaOrdineDAO{
	
	//Dato un oggetto ResultSet costruisce e restituisce il corrispondente oggetto RigaOrdine
	public RigaOrdine getRigaOrdineFromResultSet(ResultSet result) throws PersistenceException{
		RigaOrdine riga = new RigaOrdine();
		try{
			riga.setID(result.getInt("id"));
			riga.setNumeroRiga(result.getInt("numeroriga"));
			riga.setQuantita(result.getInt("quantita"));
			Prodotto prodotto = (new ProdottoDAOpostgresql()).retrieveProdottoByID(result.getInt("idprodotto"));
			riga.setProdotto(prodotto);
		}catch(Exception ex){
			System.out.println("Impossibile acquisire riga ordine: "+ex.getMessage());
			throw new PersistenceException(ex.getMessage());
		}
		return riga;
	}
	
	//Dato un oggetto ResultSet costruisce e restituisce il corrispondente oggetto RigaOrdine
	public List<RigaOrdine> retrieveRigheOrdineByIDOrdine(int idOrdine) throws PersistenceException{
		List<RigaOrdine> listaRighe = new LinkedList<RigaOrdine>();
		DataSource dataSource = new DataSource();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		String query;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			query = "SELECT * " +
					"FROM righeordine " +
					"WHERE idordine=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idOrdine);
			//Interrogazione DB
			result = statement.executeQuery();
			while(result.next())
				listaRighe.add(getRigaOrdineFromResultSet(result));
		}catch(Exception ex){
			throw new PersistenceException(ex.getMessage());
		}finally {
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
		return listaRighe;
	}
	
	//Dato un oggetto RigaOrdine lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveRigaOrdine(RigaOrdine rigaOrdine,Ordine ordine) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "SELECT * " +
						   "FROM righeordine " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,rigaOrdine.getID());
			result = statement.executeQuery();
			if(result.next()){
				query = "UPDATE righeordine " +
						"SET numeroriga=?,quantita=?,idprodotto=? " +
						"WHERE id=?";
            	statement = connection.prepareStatement(query);
                statement.setInt(1,rigaOrdine.getNumeroRiga());
                statement.setInt(2,rigaOrdine.getQuantita());
                statement.setInt(3,rigaOrdine.getProdotto().getId());
                statement.setInt(4,rigaOrdine.getID());
            }else{
				query = "INSERT INTO righeordine " +
						"(numeroriga,quantita,idprodotto,idordine,id) " +
						"VALUES (?,?,?,?,NEXTVAL('sequenzarigheordine'))";
                statement = connection.prepareStatement(query);
                statement.setInt(1,rigaOrdine.getNumeroRiga());
                statement.setInt(2,rigaOrdine.getQuantita());
                statement.setInt(3,rigaOrdine.getProdotto().getId());
                statement.setInt(4,ordine.getID());
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

    //Dato un oggetto RigaOrdine lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public int saveRigaOrdine(RigaOrdine rigaOrdine, Ordine ordine, Connection conn) throws PersistenceException{
		Connection connection = conn;
		PreparedStatement statement = null;
		ResultSet result = null;
        int success = 0;
		try{
			//Preparazione query
			String query = "SELECT * " +
						   "FROM righeordine " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,rigaOrdine.getID());
			result = statement.executeQuery();
			if(result.next()){
				query = "UPDATE righeordine " +
						"SET numeroriga=?,quantita=?,idprodotto=? " +
						"WHERE id=?";
            	statement = connection.prepareStatement(query);
                statement.setInt(1,rigaOrdine.getNumeroRiga());
                statement.setInt(2,rigaOrdine.getQuantita());
                statement.setInt(3,rigaOrdine.getProdotto().getId());
                statement.setInt(4,rigaOrdine.getID());
            }else{
				query = "INSERT INTO righeordine " +
						"(numeroriga,quantita,idprodotto,idordine,id) " +
						"VALUES (?,?,?,?,NEXTVAL('sequenzarigheordine'))";
                statement = connection.prepareStatement(query);
                statement.setInt(1,rigaOrdine.getNumeroRiga());
                statement.setInt(2,rigaOrdine.getQuantita());
                statement.setInt(3,rigaOrdine.getProdotto().getId());
                statement.setInt(4,ordine.getID());
            }
		    //Interrogazione DB
			success = statement.executeUpdate();
		}catch(Exception ex){
			throw new PersistenceException(ex.getMessage());
		}
        return success;
	}
	
	//Dato l'ID di una RigaOrdine la elimina dal DB se presente
	public void deleteRigaOrdine(int idRigaOrdine) throws PersistenceException{
		DataSource dataSource = new DataSource();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			//Connessione al DB
			connection = dataSource.getConnection();
			//Preparazione query
			String query = "DELETE " +
						   "FROM righeordine " +
						   "WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idRigaOrdine);
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
}
