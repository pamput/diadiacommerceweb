<%-- 
    Document   : creaOrdine
    Created on : 11-giu-2009, 17.27.43
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creazione Nuovo Ordine</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ page import="modello.Ordine" %>
        <%@ page import="modello.RigaOrdine,modello.Prodotto" %>
        <%@ page import="java.util.List" %>
        <% List<Prodotto> prodotti = (List<Prodotto>)session.getAttribute("catalogoProdotti"); %>
    </head>

    <body>
        <menu-top><jsp:include page="/menu.jsp"/></menu-top><br><br>
        <div class="main-frame">
            <%int costo = 0;%>
            <h3>Creazione nuovo ordine</h3>
            Prodotti ordinati:<br><br>
    <html:form action="/riepilogoOrdine.do">
    <table>
        <TR>
            <TD>Nome</TD>
            <TD>Codice</TD>
            <TD>Descrizione</TD>
            <TD>Prezzo</TD>
            <TD>Disponibili</TD>
            <td><center>-</center></td>
            <td>Ordinati</td>
            <td><center>+</center></td>
        </TR>
        <%for(int i=0;i<prodotti.size();i++){
            Prodotto p = prodotti.get(i);%>
        <TR>
            <TD><a href='dettaglioProdotto.do?idProdotto=<%=p.getID()%>'><%=p.getNome()%></a></TD>
            <TD><%=p.getCodice()%></TD>
            <TD><%=p.getDescrizione()%></TD>
            <TD><%=p.getPrezzo()%></TD>
            <TD><%=p.getQuantita()%></TD>
            <td><html:button property="add" value="-" onclick=""/></td>
            <td><html:text maxlength="3" size="3" property='quantita<%=i%>' disabled="1" value="0"/></td>
            <td><html:button property="add" value="+" onclick=""/></td>
        </TR>
        <%}
        //TODO azione bottoni aggiungi e sottrai
        %>
    </table><br><br>
            Costo totale: <%=costo%><br><br>
            <html:submit property="submit" value="Conferma Ordine"/>
    </html:form>
    </div>
    </body>
</html>
