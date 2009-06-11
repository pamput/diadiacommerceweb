/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kimo
 */
public abstract class AccountsHandler {

 	private String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
        	int halfbyte = (data[i] >>> 4) & 0x0F;
        	int two_halfs = 0;
        	do {
	        	if ((0 <= halfbyte) && (halfbyte <= 9))
	                buf.append((char) ('0' + halfbyte));
	            else
	            	buf.append((char) ('a' + (halfbyte - 10)));
	        	halfbyte = data[i] & 0x0F;
        	} while(two_halfs++ < 1);
        }
        return buf.toString();
    }

	protected String string2md5(String text){

		MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

		byte[] md5hash = new byte[32];
        try {
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AccountsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

		md5hash = md.digest();
		return convertToHex(md5hash);
	}

    //Effettua l'autenticazione di un utente dati usename e password, e ne restituisce il ruolo (in caso di autenticazione negativa restituisce null)
    public abstract String authenticate(String username,String password) throws PersistenceException;

    //Dato un username verifica se e gia presente nel DB
    public abstract boolean usernamePresente(String username) throws PersistenceException;

    //Dato un codiceCliente verifica se e effettivamente valido
    public abstract boolean codiceClienteValido(String codiceCliente) throws PersistenceException;

    public abstract void addAccount(String codiceCliente, String user, String password, String role) throws PersistenceException;
}
