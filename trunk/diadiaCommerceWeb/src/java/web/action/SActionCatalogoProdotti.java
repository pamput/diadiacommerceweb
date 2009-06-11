/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import modello.*;
import persistenza.*;
import persistenza.postgresql.*;
/**
 *
 * @author Kimo
 */
public class SActionCatalogoProdotti extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "mostraCatalogoProdotti";
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
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception {
        Facade facade = new Facadepostgresql();
        try{
            List<Prodotto> prodotti = facade.getProdotti();
            request.getSession().setAttribute("catalogoProdotti", prodotti);
        }catch(Exception ex){
            return mapping.findForward(FAIL);
        }
        return mapping.findForward(SUCCESS);
    }
}
