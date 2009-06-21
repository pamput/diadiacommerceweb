/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import web.form.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Cliente;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import persistenza.AccountsHandler;
import persistenza.Facade;
import persistenza.postgresql.AccountsHandlerpostgresql;
import persistenza.postgresql.Facadepostgresql;

/**
 *
 * @author Kimo
 */
public class SActionLogin extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String USER = "mostraHomepage";
    private final static String ADMIN = "mostraAdminpage";
    private final static String FAIL = "loginNonValido";
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
        LoginForm loginForm = (LoginForm)form;
        AccountsHandler auth = new AccountsHandlerpostgresql();
        String role = null;
        String forwardString = FAIL;
        try{
            role = auth.authenticate(loginForm.getUsername(), loginForm.getPassword());
        }catch(Exception ex){
            return mapping.findForward(forwardString);
        }
        if(role != null){
            //Pulisce la sessione da eventuali residui precedenti
            request.getSession().invalidate();
            if(role.equals("admin")){
                request.getSession().setAttribute("role","admin");
                //Inserisce in sessione i dati necessari per la pagina personale dell'admin
                Facade facade = new Facadepostgresql();
                request.getSession().setAttribute("ordini",facade.getOrdini());
                forwardString = ADMIN;
            }else if(role.equals("user")){
                request.getSession().setAttribute("role","user");
                //Inserisce in sessione i dati necessari per la pagina personale del cliente
                Facade facade = new Facadepostgresql();
                AccountsHandler acchandler = new AccountsHandlerpostgresql();
                String codice = acchandler.retrieveCodiceClienteByUsername(loginForm.getUsername());
                Cliente cliente = facade.getClientePerCodice(codice);
                request.getSession().setAttribute("cliente", cliente);
                request.getSession().setAttribute("ordini", cliente.getOrdini());
                forwardString = USER;
            }
            //Rimuove il form di login dalla sessione
            request.getSession().removeAttribute("LoginForm");
        }else{
            ActionMessages errors = new ActionMessages();
            errors.add("username", new ActionMessage("errors.invalidlogin"));
            this.saveErrors(request, errors);
        }
        return mapping.findForward(forwardString);
        }

}
