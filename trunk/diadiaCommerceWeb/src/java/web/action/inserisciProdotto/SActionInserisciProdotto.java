/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action.inserisciProdotto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import modello.*;
import persistenza.*;
import persistenza.postgresql.*;
import web.form.InserisciProdottoForm;
/**
 *
 * @author Kimo
 */
public class SActionInserisciProdotto extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "inserisciProdotto";
    private final static String FAIL = "erroreInserisciProdotto";
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
        InserisciProdottoForm formProdotto = (InserisciProdottoForm) form;
        Prodotto prodotto = new Prodotto();
        prodotto.setNome(formProdotto.getNome());
        prodotto.setDescrizione(formProdotto.getDescrizione());
        prodotto.setPrezzo(formProdotto.getPrezzo());
        prodotto.setQuantita(formProdotto.getQuantita());
        prodotto.setCodice(formProdotto.getCodice());
        Facade facade = new Facadepostgresql();
        try {
             facade.salvaProdotto(prodotto);
        }catch (Exception ex){
             return mapping.findForward(FAIL);
        }
		return mapping.findForward(SUCCESS);
    }
}
