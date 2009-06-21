/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Fornitore;
import modello.Prodotto;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import persistenza.Facade;
import persistenza.postgresql.Facadepostgresql;
import web.form.AggiungiFornitoreForm;

/**
 *
 * @author Kimo
 */
public class SActionConfermaAggiungiFornitore extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "confermaAggiungiFornitore";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Facade facade = new Facadepostgresql();
        Fornitore fornitore = null;
        if(request.getParameter("nomeFornitore") != null){
            //Nel caso sia stato selezionato un fornitore esistente lo recupera dal DB
            String nomeFornitore = (String)request.getParameter("nomeFornitore");
            fornitore = facade.getFornitorePerNome(nomeFornitore);
        }else{
            //Nel caso sia stato inserito un nuovo fornitore lo crea e lo inizializza con i dati del form
            fornitore = new Fornitore();
            AggiungiFornitoreForm formFornitore = (AggiungiFornitoreForm)form;
            fornitore.setIndirizzo(formFornitore.getIndirizzo());
            fornitore.setNome(formFornitore.getNome());
            fornitore.setTelefono(formFornitore.getTelefono());
            request.getSession().removeAttribute("AggiungiFornitoreForm");
        }
        //Aggiunge il prodotto al fornitore ed esegue l'update
        String codiceProdotto = (String)request.getSession().getAttribute("codiceProdotto");
        Prodotto prodotto = facade.getProdottoPerCodice(codiceProdotto);
        fornitore.addProdotto(prodotto);
        facade.salvaFornitore(fornitore);
        //Aggiunge il fornitore ed il prodotto alla sessione per poterli visualizzare nella conferma dell'inserimento
        request.getSession().setAttribute("fornitore", fornitore);
        request.getSession().setAttribute("prodotto", prodotto);
        return mapping.findForward(SUCCESS);
    }
}
