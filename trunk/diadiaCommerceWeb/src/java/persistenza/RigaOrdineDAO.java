package persistenza;

import java.sql.ResultSet;
import java.util.List;

import modello.*;

public interface RigaOrdineDAO {
	
	//Dato un oggetto ResultSet costruisce e restituisce il corrispondente oggetto RigaOrdine
	public RigaOrdine getRigaOrdineFromResultSet(ResultSet result) throws PersistenceException;
	
	//Dato l'ID di un ordine recupera dal DB e costruisce la lista degli oggetti RigaOrdine corrispondenti
	public List<RigaOrdine> retrieveRigheOrdineByIDOrdine(int idOrdine) throws PersistenceException;	

	//Dato un oggetto RigaOrdine lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveRigaOrdine(RigaOrdine rigaOrdine,Ordine ordine) throws PersistenceException;
	
	//Dato l'ID di una RigaOrdine la elimina dal DB se presente
	public void deleteRigaOrdine(int idRigaOrdine) throws PersistenceException;
}
