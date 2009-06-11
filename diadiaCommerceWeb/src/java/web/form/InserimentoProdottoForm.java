/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import persistenza.Facade;
import persistenza.postgresql.Facadepostgresql;

/**
 *
 * @author Kimo
 */
public class InserimentoProdottoForm extends org.apache.struts.action.ActionForm {
    
    private String nome;
    private String descrizione;
    private String codice;
    private int prezzo;
    private int quantita;

    public InserimentoProdottoForm() {
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
        if (getNome() == null || getNome().length() < 1)
            errors.add("nome", new ActionMessage("errors.required"));
        if (getDescrizione() == null || getDescrizione().length() < 1)
            errors.add("descrizione", new ActionMessage("errors.required"));
        if (getCodice() == null || getCodice().length() < 1)
            errors.add("codice", new ActionMessage("errors.required"));
        if (getPrezzo() == 0)
            errors.add("prezzo", new ActionMessage("errors.zero"));
        if (getQuantita() < 0)
            errors.add("quantita", new ActionMessage("errors.negative"));
        //Controlli sulla persistenza
        try{
            Facade facade = new Facadepostgresql();
            if (facade.getProdottoPerCodice(this.getCodice()) != null)
                errors.add("codice",new ActionMessage("errors.entrycopy"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return errors;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @return the codice
     */
    public String getCodice() {
        return codice;
    }

    /**
     * @return the prezzo
     */
    public int getPrezzo() {
        return prezzo;
    }

    /**
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @param codice the codice to set
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @param quantita the quantita to set
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
