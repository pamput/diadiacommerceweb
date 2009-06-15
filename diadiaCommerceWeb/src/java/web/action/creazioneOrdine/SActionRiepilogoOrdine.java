/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action.creazioneOrdine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

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
        //TODO deve prendere dalla sessione il catalogoProdotti e le property quantitaX per generare l'oggetto ordine (e infilarlo poi in sessione)
        return mapping.findForward(SUCCESS);
    }
}
