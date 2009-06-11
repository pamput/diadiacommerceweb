package persistenza;

import modello.Cliente;
import java.sql.*;
import java.util.List;

public interface ClienteDAO {

	//Dato un oggetto ResultSet costruisce e restituisce un oggetto Cliente
	public Cliente getClienteFromResultSet(ResultSet result) throws PersistenceException;
	
	//Dato un codice cliente recupera dal DB e costruisce l'oggetto Cliente corrispondente
	public Cliente retrieveClienteByCodice(String codiceCliente) throws PersistenceException;
	
	//Dato l'Id di un cliente recupera dal DB e costruisce l'oggetto Cliente corrispondente
	public Cliente retrieveClienteByID(int idCliente) throws PersistenceException;
	
	//Restituisce la lista di tutti i clienti memorizzati nel DB
	public List<Cliente> getClienti() throws PersistenceException;

	//Dato un oggetto Cliente lo inserisce nel DB se non presente, lo aggiorna altrimenti
	public void saveCliente(Cliente cliente) throws PersistenceException;
	
	//Dato l'ID di un Cliente lo elimina dal DB se presente
	public void deleteCliente(int idCliente) throws PersistenceException;
}
