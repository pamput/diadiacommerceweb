/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action.creaOrdine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import persistenza.postgresql.Facadepostgresql;
import web.form.RigaOrdineForm;

/**
 *
 * @author pamput
 */
public class SActionRichiestaCreaOrdine extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "richiestaCreaOrdine";
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getSession().removeAttribute("ordine");
        
        Facadepostgresql facade = new Facadepostgresql();
        
        //Creiamo l'elenco dei prodotti disponibili
        List listaProdottiDisponibili = facade.getProdottiDisponibili();
        request.getSession().setAttribute("catalogoProdottiDisponibili", listaProdottiDisponibili);

        //Inizializziamo il valore dei prodotti in catalogo
        int numeroProdotti = listaProdottiDisponibili.size();
        RigaOrdineForm rigaOrdineForm = new RigaOrdineForm();

        for(int i = 0; i < numeroProdotti; i++){
            rigaOrdineForm.setOrdine(i, "0");
        }

        request.getSession().setAttribute("RigaOrdineForm", rigaOrdineForm);

        //Forward
        return mapping.findForward(SUCCESS);
    }
}
