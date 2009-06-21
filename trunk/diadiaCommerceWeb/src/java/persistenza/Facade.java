package persistenza;

import modello.*;
import java.util.List;

import persistenza.PersistenceException;

public interface Facade {
	
	//Dato un oggetto Cliente lo inserisce nel DB
	public void salvaCliente(Cliente cliente) throws PersistenceException;
	
	//Ritorna una lista di tutti i clienti memorizzati nel DB
	public List<Cliente> getClienti() throws PersistenceException;
	
	//Dato l'ID di un cliente lo cerca nel DB e lo restituisce
	public Cliente getClientePerId(int idCliente) throws PersistenceException;

    //Dato il codice di un cliente lo cerca nel DB e lo restituisce
	public Cliente getClientePerCodice(String codice) throws PersistenceException;
	
	//Dato un oggetto Prodotto lo inserisce nel DB
	public void salvaProdotto(Prodotto prodotto) throws PersistenceException;
	
	//Ritorna una lista di tutti i prodotti memorizzati nel DB
	public List<Prodotto> getProdotti() throws PersistenceException;

	//Ritorna la lista di tutti i prodotti disponibili in magazzino
	public List<Prodotto> getProdottiDisponibili() throws PersistenceException;
	
	//Dato l'ID di un prodotto lo cerca nel DB e lo restituisce
	public Prodotto getProdottoPerId(int id) throws PersistenceException;

    //Dato il codice di un prodotto lo cerca nel DB e lo restituisce
	public Prodotto getProdottoPerCodice(String codice) throws PersistenceException;
	
	//Dato un oggetto Ordine lo inserisce nel DB	
	public void salvaOrdine(Ordine ordine) throws PersistenceException;
	
	//Ritorna una lista di tutti gli ordini memorizzati nel DB
	public List<Ordine> getOrdini() throws PersistenceException;
	
	//Dato un oggetto ordine ne modifica lo stato impostandolo come evaso
	public void evadiOrdine(Ordine ordine) throws PersistenceException;
	
	//Dato l'ID di un ordine lo cerca nel DB e lo restituisce
	public Ordine getOrdinePerId(int idOrdine) throws PersistenceException;

    //Dato il codice di un ordine lo cerca nel DB e lo restituisce
	public Ordine getOrdinePerCodice(String codice) throws PersistenceException;
	
	//Ritorna la lista degli ordini effettuati da un cliente
	public List<Ordine> getOrdiniPerCliente(Cliente cliente) throws PersistenceException;

    //Aggiunge una riga ordine ad un ordine
    public void addRigaOrdine(Ordine ordine,int quantita,Prodotto prodotto) throws PersistenceException;
	
	//Dato il codice di un prodotto restituisce la lista dei fornitori che forniscono tale prodotto
	public List<Fornitore> getFornitoriPerCodiceProdotto(String codiceProdotto) throws PersistenceException;

    //Dato il nome di un fornitore lo cerca nel DB e lo restituisce
	public Fornitore getFornitorePerNome(String nome) throws PersistenceException;

    //Restituisce la lista dei fornitori presenti nel DB
	public List<Fornitore> getFornitori() throws PersistenceException;

	//Dato un oggeto Fornitore lo inserisce nel DB
	public void salvaFornitore(Fornitore fornitore) throws PersistenceException;
}
