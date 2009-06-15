/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action.creazioneOrdine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import persistenza.Facade;
import persistenza.postgresql.Facadepostgresql;

/**
 *
 * @author Kimo
 */
public class SActionCreaOrdine extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "richiestaCreazioneOrdine";
    private final static String FAIL = "catalogoNonDisponibile";
    
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
        try{
            request.getSession().setAttribute("catalogoProdotti", facade.getProdottiDisponibili());
        }catch(Exception ex){
            return mapping.findForward(FAIL);
        }
        return mapping.findForward(SUCCESS);
    }
}
