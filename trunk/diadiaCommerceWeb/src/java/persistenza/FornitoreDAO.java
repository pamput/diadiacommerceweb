package persistenza;

import java.sql.ResultSet;
import java.util.List;

import modello.Fornitore;

public interface FornitoreDAO {

	//Dato un oggetto ResultSet costruisce e restituisce un oggetto Fornitore
	public Fornitore getFornitoreFromResultSet(ResultSet result) throws PersistenceException;
	
	//Dato l'Id di un fornitore recupera dal DB e costruisce l'oggetto Fornitore corrispondente
	public Fornitore retrieveFornitoreByID(int idFornitore) throws PersistenceException;
	
	//Dato il nome di un fornitore recupera dal DB e costruisce l'oggetto Fornitore corrispondente
	public Fornitore retrieveFornitoreByNome(String nomeFornitore) throws PersistenceException;
	
	//Restituisce la lista di tutti i fornitori memorizzati nel DB
	public List<Fornitore> getFornitori() throws PersistenceException;	
	
    //Dato un Fornitore lo aggiunge al DB, lo aggiorna altrimenti
    public void saveFornitore(Fornitore fornitore) throws PersistenceException;
    
	//Dato l'ID di un Fornitore lo elimina dal DB se presente
	public void deleteFornitore(int idFornitore) throws PersistenceException;
	
	//Ritorna la lista dei fornitori che forniscono un certo prodotto
	public List<Fornitore> retrieveFornitoriByCodiceProdotto(String codiceProdotto) throws PersistenceException;
	
	//Dato l'ID di un prodotto e l'ID di un fornitore li associa tra loro
	public void associaFornitoreProdotto(int idProdotto,int idFornitore) throws PersistenceException;
}
