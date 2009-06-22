<%-- 
    Document   : confermaAggiungiFornitore
    Created on : 21-giu-2009, 13.45.12
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Conferma Aggiunta Fornitore</title>
        <%@ include file="/head.jsp" %>
        <%@ page import='java.util.List,modello.Prodotto' %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Il fornitore è stato aggiunto</h3>

            <b>Prodotto:</b><bean:write name="prodotto" property="nome"/><br><br><br>

            <b>Dati del fornitore:</b><br><br>
            <b>Nome:</b><bean:write name="fornitore" property="nome" /><br><br>
            <b>Telefono:</b><bean:write name="fornitore" property="telefono" /><br><br>
            <b>Indirizzo:</b><bean:write name="fornitore" property="indirizzo" /><br><br>

            <html:link page="/catalogoProdotti.do">
                <button>Torna al catologo prodotti</button>
            </html:link>

            <%session.removeAttribute("fornitore");
        session.removeAttribute("codiceProdotto");%>
        </div>
    </body>
</html>
    