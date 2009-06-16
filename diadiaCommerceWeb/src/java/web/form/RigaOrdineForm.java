/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author pamput
 */
public class RigaOrdineForm extends org.apache.struts.action.ActionForm {

    private String ordine;
    private HashMap<Integer, String> mappaOrdini;

    public String getOrdine() {
        return ordine;
    }

    public void setOrdine(String ordine) {
        this.ordine = ordine;
    }

    //I seguenti due metodi sono funzionali ai form indexati

    public String getOrdine(int index) {
        return mappaOrdini.get(index);
    }

    public void setOrdine(int index, String value){
        if(mappaOrdini == null)
            mappaOrdini = new HashMap<Integer, String>();
        mappaOrdini.put(index, value);
    }

    @Override
    /**
     *  Il validate sarà solo eseguito sulla lista in quatno non è previsto l'utilizzo sul singolo oggetto String ordine
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        Set<Integer> keyset = mappaOrdini.keySet();

        Iterator<Integer> iterator = keyset.iterator();


        while(iterator.hasNext()){
            int k = iterator.next();        //Inizializziamo la chiave
            int v = 0;      //Inizializziamo il valore
            try{
                v = Integer.parseInt(mappaOrdini.get(k));
                if (v < 0) {
                    errors.add("ordine[" + k + "]", new ActionMessage("errors.negative", "L' ordine"));
                }
            } catch(NumberFormatException e) {
                errors.add("ordine[" + k + "]", new ActionMessage("errors.integer", "L'ordine "));
            }
        }



        return errors;
    }

    @Override
    public String toString(){
        return mappaOrdini.toString();
    }
}
