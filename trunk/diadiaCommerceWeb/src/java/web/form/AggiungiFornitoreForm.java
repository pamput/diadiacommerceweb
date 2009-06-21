/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Kimo
 */
public class AggiungiFornitoreForm extends org.apache.struts.action.ActionForm {
    
    private String nome;
    private String indirizzo;
    private String telefono;

    /**
     *
     */
    public AggiungiFornitoreForm() {
        super();
        // TODO Auto-generated constructor stub
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
        if (getNome() == null || getNome().length() < 1)
            errors.add("name", new ActionMessage("errors.required"));

        if (getIndirizzo() == null || getIndirizzo().length() < 1)
            errors.add("indirizzo", new ActionMessage("errors.required"));

        if (getTelefono() == null || getTelefono().length() < 1)
            errors.add("telefono", new ActionMessage("errors.required"));

        return errors;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param indirizzo the indirizzo to set
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
