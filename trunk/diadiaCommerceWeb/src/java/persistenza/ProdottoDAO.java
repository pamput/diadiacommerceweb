package persistenza;

import java.util.List;
import modello.*;

import java.sql.*;

public interface ProdottoDAO {

	//Dato un oggetto ResultSet costruisce e restituisce il corrispondente oggetto Prodotto
	public Prodotto getProdottoFromResultSet(ResultSet result) throws PersistenceException;
	
	//Dato l'ID di un prodotto recupera dal DB e costruisce l'oggetto Prodotto corrispondente
	public Prodotto retrieveProdottoByID(int idProdotto) throws PersistenceException;
	
	//Dato il codice di un prodotto recupera dal DB e costruisce l'oggetto Prodotto corrispondente
	public Prodotto retrieveProdottoByCodice(String codiceProdotto) throws PersistenceException;
	
	//Ritorna una lista di tutti i prodotti memorizzati nel DB
	public List<Prodotto> retrieveAll() throws PersistenceException;
	
	//Ritorna una lista di tutti i prodotti disponibili
	public List<Prodotto> retrieveDisponibili() throws PersistenceException;
	
	//Ritorna la lista dei prodotti forniti da un fornitore
	public List<Prodotto> retrieveProdottiByIDFornitore(int idFornitore) throws PersistenceException;
	
	//Dato un oggetto Prodotto lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveProdotto(Prodotto prodotto) throws PersistenceException;
	
	//Dato l'ID di un Prodotto lo elimina dal DB se presente
	public void deleteProdotto(int idProdotto) throws PersistenceException;
}
