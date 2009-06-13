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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dettaglio Prodotto</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ page import='modello.Prodotto;' %>
        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    </head>
    
    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <%Prodotto p = (Prodotto)session.getAttribute("prodotto");%>
        <div class="main-frame">
        <h3>Dettaglio Prodotto</h3><br>
        <b>Nome:</b> <%=p.getNome()%><br>
        <b>Codice:</b> <%=p.getCodice()%><br>
        <b>Descrizione:</b> <%=p.getDescrizione()%><br>
        <b>Prezzo:</b> <%=p.getPrezzo()%><br>
        <b>Quantita:</b> <%=p.getQuantita()%><br><br>
        <%session.removeAttribute("prodotto");%>
        <a href="catalogoProdotti.do"><input type="button" value="Torna al catologo prodotti"></a>
        </div>
    </body>
</html>
