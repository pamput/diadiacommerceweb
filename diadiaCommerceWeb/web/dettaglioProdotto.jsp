<%-- 
    Document   : dettaglioProdotto
    Created on : 9-giu-2009, 17.28.35
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Dettaglio Prodotto</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <menu-top><%@ include file="/menu.jsp" %></menu-top><br><br>
        <div class="main-frame">
            <h3>Dettaglio Prodotto</h3><br>

            <b>Nome: </b> <bean:write name="prodotto" property="nome" /><br>
            <b>Codice: </b> <bean:write name="prodotto" property="codice" /><br>
            <b>Descrizione: </b> <bean:write name="prodotto" property="descrizione" /><br>
            <b>Prezzo: </b> <bean:write name="prodotto" property="prezzo" />
            <bean:message key="text.moneyvalue"/><br>
            <b>Quantita: </b> <bean:write name="prodotto" property="quantita" /><br><br>
                
            <input type="button" onclick="javascript:history.back()" value="Indietro"/>
        </div>

    </body>
</html>
