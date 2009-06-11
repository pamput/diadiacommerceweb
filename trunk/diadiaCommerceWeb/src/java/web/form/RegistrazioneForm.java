/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.form;

import java.util.regex.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import persistenza.AccountsHandler;
import persistenza.postgresql.AccountsHandlerpostgresql;

/**
 *
 * @author pamput
 */
public class RegistrazioneForm extends org.apache.struts.action.ActionForm {
    
    private String username;
    private String password;
    private String codicecliente;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }


    /**
     *
     */
    public RegistrazioneForm() {
        super();
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        Pattern pattern = Pattern.compile("^[A-Za-z0-9\\.]*$");
        Matcher matcher = pattern.matcher(getUsername());

        if (getUsername() == null)
            errors.add("username", new ActionMessage("errors.required"));
        if (getUsername().length() < 6)
            errors.add("username", new ActionMessage("errors.minlength", 6));
        if(!matcher.find())
            errors.add("username", new ActionMessage("errors.notalphanumeric", getUsername()));

        if (getPassword() == null)
            errors.add("password", new ActionMessage("errors.required"));
        if (getPassword().length() < 6)
            errors.add("password", new ActionMessage("errors.minlength", 6));

        if((getCodicecliente() == null)||(getCodicecliente().length() < 1))
            errors.add("codicecliente", new ActionMessage("errors.required"));
        //Controlli persistenza
        AccountsHandler handler = new AccountsHandlerpostgresql();
        try{
            if(!(handler.codiceClienteValido(getCodicecliente())))
                errors.add("codicecliente", new ActionMessage("errors.notvalid"));
        }catch(Exception ex){
            errors.add("codicecliente", new ActionMessage("errors.notvalid"));
        }
        try{
            if(handler.usernamePresente(getUsername()))
                errors.add("username", new ActionMessage("errors.alreadyused"));
        }catch(Exception ex){
            errors.add("username", new ActionMessage("errors.notvalid"));
        }

        return errors;
    }

    /**
     * @return the codicecliente
     */
    public String getCodicecliente() {
        return codicecliente;
    }

    /**
     * @param codicecliente the codicecliente to set
     */
    public void setCodicecliente(String codicecliente) {
        this.codicecliente = codicecliente;
    }
}

