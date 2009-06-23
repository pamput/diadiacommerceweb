<%-- 
    Document   : confermaEvadiOrdine
    Created on : 20-giu-2009, 14.28.00
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
            <h3>L'ordine seguente è stato evaso</h3>

            <b>Riepilogo dati ordine:</b><br><br>
            <b>Codice:</b><bean:write name="ordine" property="codice" /><br><br>
            <b>Cliente:</b><bean:write name="ordine" property="cliente" /><br><br>
            <b>Data:</b><bean:write name="ordine" property="data" /><br><br>
            <br><br>

            <b>Prodotti:</b><br><br>
            <center>
                <table>
                    <tr>
                        <td class="prodotto">Prodotto</td>
                        <td class="quantita">Quantita</td>
                    </tr>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="riga" name="righeOrdine">
                        <!--Scrive il corpo della lista di ordini-->
                        <tr>
                            <td class="prodotto"><bean:write name="riga" property="prodotto" /></td>
                            <td class="quantita"><bean:write name="riga" property="quantita" /></td>
                        </tr>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </table>
            </center><br><br>

            <html:link page="/homepage.do">
                Torna alla Homepage
            </html:link>
        </div>
    </body>
</html>
