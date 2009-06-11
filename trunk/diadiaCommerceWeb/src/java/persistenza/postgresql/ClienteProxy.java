package persistenza.postgresql;

import java.util.List;
import java.util.LinkedList;
import persistenza.PersistenceException;
import modello.*;

public class ClienteProxy extends Cliente {
	
	//Restituisce la lista degli ordini effettuati da un cliente
	public List<Ordine> getOrdini() {
		List<Ordine> listaOrdini = new LinkedList<Ordine>();
		OrdineDAOpostgresql ordineDAO = null;
		try{
			ordineDAO = new OrdineDAOpostgresql();
			listaOrdini = ordineDAO.retrieveOrdineByIDCliente(this.getID());
		}
		catch (PersistenceException e) {
			//throw new PersistenceException(e.getMessage());
		}
		this.setOrdini(listaOrdini);
		return listaOrdini;
	}
}