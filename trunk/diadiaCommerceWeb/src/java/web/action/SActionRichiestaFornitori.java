/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Fornitore;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import persistenza.Facade;
import persistenza.postgresql.Facadepostgresql;

/**
 *
 * @author Kimo
 */
public class SActionRichiestaFornitori extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "mostraFornitori";
    
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
        //Inserisce la lista dei fornitori in sessione
        Facade facade = new Facadepostgresql();
        String codiceProdotto = (String)request.getParameter("codiceProdotto");
        List<Fornitore> fornitori = facade.getFornitoriPerCodiceProdotto(codiceProdotto);
        request.getSession().setAttribute("fornitori", fornitori);

        return mapping.findForward(SUCCESS);
    }
}
