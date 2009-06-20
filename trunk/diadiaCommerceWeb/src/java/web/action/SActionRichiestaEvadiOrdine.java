/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Ordine;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import persistenza.Facade;
import persistenza.postgresql.Facadepostgresql;

/**
 *
 * @author Kimo
 */
public class SActionRichiestaEvadiOrdine extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "mostraRiepilogoEvadiOrdine";
    
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
        String codiceOrdine = request.getParameter("codiceOrdine");
        Ordine ordine = facade.getOrdinePerCodice(codiceOrdine);
        request.getSession().setAttribute("ordine", ordine);
        request.getSession().setAttribute("righeOrdine", ordine.getRigheOrdine());
        return mapping.findForward(SUCCESS);
    }
}
