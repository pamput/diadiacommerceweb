package persistenza.postgresql;

import java.util.List;
import persistenza.*;
import modello.*;

public class Facadepostgresql implements Facade{

	private ClienteDAOpostgresql clienteDAO = new ClienteDAOpostgresql();
	private ProdottoDAOpostgresql prodottoDAO = new ProdottoDAOpostgresql();
	private OrdineDAOpostgresql ordineDAO = new OrdineDAOpostgresql();
	private FornitoreDAOpostgresql fornitoreDAO = new FornitoreDAOpostgresql();
	
	//Dato un oggetto Cliente lo inserisce nel DB
	public void salvaCliente(Cliente cliente) throws PersistenceException{
		clienteDAO.saveCliente(cliente);
	}
	
	//Ritorna una lista di tutti i clienti memorizzati nel DB
	public List<Cliente> getClienti() throws PersistenceException{
		return clienteDAO.getClienti();
	}
	
	//Dato l'ID di un cliente lo cerca nel DB e lo restituisce
	public Cliente getClientePerId(int idCliente) throws PersistenceException{
		return clienteDAO.retrieveClienteByID(idCliente);
	}

    //Dato il codice di un cliente lo cerca nel DB e lo restituisce
	public Cliente getClientePerCodice(String codice) throws PersistenceException{
        return clienteDAO.retrieveClienteByCodice(codice);
    }
	
	//Dato un oggetto Prodotto lo inserisce nel DB
	public void salvaProdotto(Prodotto prodotto) throws PersistenceException{
		prodottoDAO.saveProdotto(prodotto);
	}
	
	//Ritorna una lista di tutti i prodotti memorizzati nel DB
	public List<Prodotto> getProdotti() throws PersistenceException{
		return prodottoDAO.retrieveAll();
	}
	
	//Ritorna una lista di tutti i prodotti disponibili in magazzino
	public List<Prodotto> getProdottiDisponibili() throws PersistenceException{
		return prodottoDAO.retrieveDisponibili();
	}
	
	//Dato l'ID di un prodotto lo cerca nel DB e lo restituisce
	public Prodotto getProdottoPerId(int idProdotto) throws PersistenceException{
		return prodottoDAO.retrieveProdottoByID(idProdotto);
	}

    //Dato il codice di un prodotto lo cerca nel DB e lo restituisce
	public Prodotto getProdottoPerCodice(String codice) throws PersistenceException{
        return prodottoDAO.retrieveProdottoByCodice(codice);
    }
	
	//Dato un oggetto Ordine lo inserisce nel DB	
	public void salvaOrdine(Ordine ordine) throws PersistenceException{
		ordineDAO.saveOrdine(ordine);
	}
	
	//Ritorna una lista di tutti gli ordini memorizzati nel DB
	public List<Ordine> getOrdini() throws PersistenceException{
		return ordineDAO.retrieveAll();
	}
	
	//Dato un oggetto ordine ne modifica lo stato impostandolo come evaso
	public void evadiOrdine(Ordine ordine) throws PersistenceException{
		ordineDAO.evadiOrdine(ordine);
	}
	
	//Dato l'ID di un ordine lo cerca nel DB e lo restituisce
	public Ordine getOrdinePerId(int idOrdine) throws PersistenceException{
		return ordineDAO.retrieveOrdineByID(idOrdine);
	}

    //Dato il codice di un ordine lo cerca nel DB e lo restituisce
	public Ordine getOrdinePerCodice(String codice) throws PersistenceException{
        return ordineDAO.retrieveOrdineByCodice(codice);
    }
	
	//Ritorna la lista degli ordini effettuati da un cliente
	public List<Ordine> getOrdiniPerCliente(Cliente cliente) throws PersistenceException{
		return ordineDAO.retrieveOrdineByIDCliente(cliente.getID());
	}

    //Aggiunge una riga ordine ad un ordine
    public void addRigaOrdine(Ordine ordine,int quantita,Prodotto prodotto) throws PersistenceException{
        ordine.addRigaOrdine(quantita, prodotto);
    }
	
	//Dato il codice di un prodotto restituisce la lista dei fornitori che forniscono tale prodotto
	public List<Fornitore> getFornitoriPerCodiceProdotto(String codiceProdotto) throws PersistenceException{
		return fornitoreDAO.retrieveFornitoriByCodiceProdotto(codiceProdotto);
	}

    //Dato il nome di un fornitore lo cerca nel DB e lo restituisce
	public Fornitore getFornitorePerNome(String nome) throws PersistenceException{
        return fornitoreDAO.retrieveFornitoreByNome(nome);
    }

    //Restituisce la lista dei fornitori presenti nel DB
	public List<Fornitore> getFornitori() throws PersistenceException{
        return fornitoreDAO.getFornitori();
    }

	//Dato un oggeto Fornitore lo inserisce nel DB
	public void salvaFornitore(Fornitore fornitore) throws PersistenceException{
		fornitoreDAO.saveFornitore(fornitore);
	}
	
	//Dati il codice di un prodotto ed il nome di un fornitore li associa
	public void associaFornitoreProdotto(String nomeFornitore,String codiceProdotto) throws PersistenceException{
		int idProdotto = prodottoDAO.retrieveProdottoByCodice(codiceProdotto).getId();
		int idFornitore = fornitoreDAO.retrieveFornitoreByNome(nomeFornitore).getId();
		fornitoreDAO.associaFornitoreProdotto(idProdotto, idFornitore);
	}
}
