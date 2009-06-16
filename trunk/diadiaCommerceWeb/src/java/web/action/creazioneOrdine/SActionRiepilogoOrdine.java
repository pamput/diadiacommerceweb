/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action.creazioneOrdine;

import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Cliente;
import modello.Ordine;
import modello.Prodotto;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import web.form.RigaOrdineForm;

/**
 *
 * @author Kimo
 */
public class SActionRiepilogoOrdine extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "mostraRiepilogoOrdine";
    
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
        /*RigaOrdineForm formRighe = (RigaOrdineForm)form;
        formRighe.getOrdine();
        List<Prodotto> catalogoProdotti = (List<Prodotto>)request.getSession().getAttribute("catalogoProdotti");
        Cliente cliente = (Cliente)request.getSession().getAttribute("cliente");
        //Inizializza un nuovo ordine
        Ordine ordine = new Ordine();
        ordine.setStato("aperto");
        ordine.setCliente(cliente);
        ordine.setData(new Date(System.currentTimeMillis()));
        
        //Inserisce nell'ordine tutti i prodotti richiesti in quantita maggiore di 0
        for(int i=0;i<catalogoProdotti.size();i++){
            int quantita = (Integer)request.getSession().getAttribute("quantita"+i);
            if(quantita!=0){
                ordine.addRigaOrdine(quantita,catalogoProdotti.get(i));
            }
        }

        //Aggiunge l'ordine alla sessione
        request.getSession().setAttribute("ordine", ordine);
        */
        return mapping.findForward(SUCCESS);
    }
}
