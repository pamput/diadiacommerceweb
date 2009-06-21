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
        //Solamente se la lista dei prodotti forniti è vuota effettua l'accesso al DB per caricarla
        if((this.listaProdotti == null)||(this.listaProdotti.size() == 0)){
            List<Prodotto> nuovaListaProdotti = new LinkedList<Prodotto>();
            ProdottoDAOpostgresql prodottoDAO = new ProdottoDAOpostgresql();
            try{
                prodottoDAO = new ProdottoDAOpostgresql();
                nuovaListaProdotti = prodottoDAO.retrieveProdottiByIDFornitore(this.getId());
            }catch (PersistenceException e) {
                System.out.println(e.getMessage());
            }
            this.setListaProdotti(nuovaListaProdotti);
            return this.listaProdotti;
        }else
            return this.listaProdotti;
	}
}
