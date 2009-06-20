/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza;

import org.apache.catalina.realm.RealmBase;

/**
 *
 * @author Kimo
 */
public abstract class AccountsHandler {

	protected String string2md5(String text){
        return RealmBase.Digest(text, "MD5", "iso-8859-1");
	}

    //Effettua l'autenticazione di un utente dati username e password, e ne restituisce il ruolo (in caso di autenticazione negativa restituisce null)
    public abstract String authenticate(String username,String password) throws PersistenceException;

    //Dato un username verifica se e gia presente nel DB
    public abstract boolean usernamePresente(String username) throws PersistenceException;

    //Dato un codiceCliente verifica se e effettivamente valido
    public abstract boolean codiceClienteValido(String codiceCliente) throws PersistenceException;

    //Dati i dati, inserisce un nuovo account nel DB
    public abstract void addAccount(String codiceCliente, String user, String password, String role) throws PersistenceException;

    //Dato un username ritorna il codice del cliente associato, in caso di esito negativo ritorna null
    public abstract String retrieveCodiceClienteByUsername(String username) throws PersistenceException;
}
