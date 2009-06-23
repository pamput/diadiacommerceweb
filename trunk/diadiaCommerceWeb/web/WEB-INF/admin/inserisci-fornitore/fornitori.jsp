<%-- 
    Document   : fornitori
    Created on : 19-giu-2009, 16.13.51
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Fornitori</title>
        <%@ include file="/head.jsp" %>
        <%@ page import='java.util.List,modello.Prodotto' %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Elenco dei fornitori</h3><br>

            <center>
                <table>
                    <tr class="header">
                        <td class="nome">Nome</td>
                        <td class="indirizzo">Indirizzo</td>
                        <td class="telefono">Telefono</td>
                    </tr>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="fornitore" name="fornitori">
                        <!--Scrive il corpo del catalogo-->
                        <tr>
                            <td class="nome"><bean:write name="fornitore" property="nome" /></td>
                            <td class="indirizzo"><bean:write name="fornitore" property="indirizzo" /></td>
                            <td class="telefono"><bean:write name="fornitore" property="telefono" /></td>
                        </tr>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </table>
            </center><br><br>

            <html:link page="/catalogoProdotti.do">
                <button>Torna al catalogo</button>
            </html:link>
            <html:link page="/richiestaAggiungiFornitore.do">
                <button>Aggiungi fornitore</button>
            </html:link>

        </div>
    </body>
</html>
