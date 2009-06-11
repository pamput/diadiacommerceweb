package persistenza;

import java.util.List;
import modello.*;

import java.sql.*;

public interface OrdineDAO {
	
	//Dato un oggetto ResultSet costruisce e restituisce un oggetto Ordine
	public Ordine getOrdineFromResultSet(ResultSet result) throws PersistenceException;

	//Dato un codice ordine recupera dal DB e costruisce l'oggetto Ordine corrispondente
	public Ordine retrieveOrdineByCodice(String codiceOrdine) throws PersistenceException;

	//Ritorna una lista di tutti gli ordini memorizzati nel DB
	public List<Ordine> retrieveAll() throws PersistenceException;
	
	//Dato l'ID di un ordine recupera dal DB e costruisce l'oggetto Ordine corrispondente
	public Ordine retrieveOrdineByID(int idOrdine) throws PersistenceException;
	
	//Dato un l'ID di un cliente recupera dal DB e costruisce la lista degli oggetti Ordine corrispondenti
	public List<Ordine> retrieveOrdineByIDCliente(int idCliente) throws PersistenceException;
	
	//Dato un oggetto Ordine lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveOrdine(Ordine ordine) throws PersistenceException;
	
	//Dato l'ID di un Ordine lo elimina dal DB se presente
	public void deleteOrdine(int idOrdine) throws PersistenceException;

    //Evade un ordine aggiornando al disponibilita dei prodotti
    public void evadiOrdine(Ordine ordine) throws PersistenceException;
}