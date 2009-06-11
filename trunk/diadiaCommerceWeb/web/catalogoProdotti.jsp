<%-- 
    Document   : catalogoProdotti
    Created on : 4-giu-2009, 18.11.45
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo Prodotti</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ page language="java" %>
        <%@ page import='java.util.List' %>
        <%@ page import='modello.Prodotto' %>
        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    </head>

    <body>
    <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
    <% List<Prodotto> prodotti = (List<Prodotto>)session.getAttribute("catalogoProdotti"); %>
    <div class="main-frame">
    <h3>Prodotti in catalogo</h3><br>
    <center>
    <TABLE BORDER='10'>
        <TR>
            <TD>Nome</TD>
            <TD>Codice</TD>
            <TD>Descrizione</TD>
            <TD>Quantita</TD>
        </TR>
        <%for(int i=0;i<prodotti.size();i++){
            Prodotto p = prodotti.get(i);%>
        <TR>
            <TD><a href='dettaglioProdotto.do?idProdotto=<%=p.getID()%>'><%=p.getNome()%></a></TD>
            <TD><%=p.getCodice()%></TD>
            <TD><%=p.getDescrizione()%></TD>
            <TD><%=p.getQuantita()%></TD>
        </TR>
        <%}
        session.removeAttribute("catalogoProdotti");%>
    </TABLE>
    </center>
    </div>
    </body>
</html>
