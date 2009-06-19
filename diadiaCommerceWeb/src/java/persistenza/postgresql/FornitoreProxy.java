package persistenza.postgresql;

import java.util.LinkedList;
import java.util.List;

import persistenza.PersistenceException;
import modello.Fornitore;
import modello.Prodotto;

public class FornitoreProxy extends Fornitore {
	//Restituisce la lista dei prodotti forniti
    @Override
	public List<Prodotto> getListaProdotti() {
		List<Prodotto> listaProdotti = new LinkedList<Prodotto>();
		ProdottoDAOpostgresql prodottoDAO = new ProdottoDAOpostgresql();
		try{
			prodottoDAO = new ProdottoDAOpostgresql();
			listaProdotti = prodottoDAO.retrieveProdottiByIDFornitore(this.getId());
		}catch (PersistenceException e) {
			System.out.println(e.getMessage());
			listaProdotti = null;
		}
		this.setListaProdotti(listaProdotti);
		return listaProdotti;
	}
}
