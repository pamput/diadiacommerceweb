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
                <tabella>
                    <intestazione-tabella>
                        <cella-intestazione-tabella class="nome">Nome</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="indirizzo">Indirizzo</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="telefono">Telefono</cella-intestazione-tabella>
                    </intestazione-tabella>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="fornitore" name="fornitori">
                        <!--Scrive il corpo del catalogo-->
                        <corpo-tabella>
                            <cella-corpo-tabella class="nome"><bean:write name="fornitore" property="nome" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="indirizzo"><bean:write name="fornitore" property="indirizzo" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="telefono"><bean:write name="fornitore" property="telefono" /></cella-corpo-tabella>
                        </corpo-tabella>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </tabella>
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
