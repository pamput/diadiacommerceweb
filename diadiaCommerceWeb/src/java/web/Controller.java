/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;


/**
 *
 * @author Kimo
 */
public class Controller extends org.apache.struts.tiles.TilesRequestProcessor{
    private HashMap<String,String> action2role = new HashMap();

    @Override
    public void init(ActionServlet servlet, ModuleConfig moduleConfig) throws ServletException {
        super.init(servlet, moduleConfig);
        action2role = new HashMap();
        action2role.put("/riepilogoInserimentoProdotto.do", "admin");
        action2role.put("/richiestaInserimentoProdotto.do", "admin");
        action2role.put("/confermaInserimentoProdotto.do", "admin");
        action2role.put("/personalPage.do", "user");
        action2role.put("/creaOrdine.do", "user");
    }

    @Override
    public boolean processPreprocess(HttpServletRequest request,HttpServletResponse response){
        boolean forward = true;
        if(action2role.get(request.getServletPath()) != null)
            if(request.getSession().getAttribute("role")=="admin")
                forward = true;
            else if(request.getSession().getAttribute("role")==action2role.get(request.getServletPath()))
                forward = true;
            else {
                forward = false;
            try {
                response.sendRedirect("./index.htm");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return forward;
    }
}
