<%-- 
    Document   : riepilogoEvadiOrdine
    Created on : 20-giu-2009, 14.12.41
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file="/head.jsp" %>
        <title>Evadi Ordine</title>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Evadere l'ordine seguente?</h3>

            <b>Riepilogo dati ordine:</b><br><br>
            <b>Codice:</b><bean:write name="ordine" property="codice" /><br>
            <b>Cliente:</b><bean:write name="ordine" property="cliente" /><br>
            <b>Data:</b><bean:write name="ordine" property="data" /><br>
            <br><br>

            <b>Prodotti:</b><br><br>
            <center>
                <tabella>
                    <intestazione-tabella>
                        <cella-intestazione-tabella class="prodotto">Prodotto</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="quantita">Quantita</cella-intestazione-tabella>
                    </intestazione-tabella>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="riga" name="righeOrdine">
                        <!--Scrive il corpo della lista di ordini-->
                        <corpo-tabella>
                            <cella-corpo-tabella class="prodotto"><bean:write name="riga" property="prodotto" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="quantita"><bean:write name="riga" property="quantita" /></cella-corpo-tabella>
                        </corpo-tabella>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </tabella>
            </center><br><br>

            <input type="button" onclick="javascript:history.back()" value="Annulla"/>
            <html:link page="/confermaEvadiOrdine.do" paramId="ordine" paramName="ordine">
                <button>Evadi</button>
            </html:link>
        </div>
    </body>
</html>
