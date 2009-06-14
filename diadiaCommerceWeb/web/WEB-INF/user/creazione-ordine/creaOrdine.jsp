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
        <%@ page import="modello.RigaOrdine" %>
        <%@ page import="java.util.List" %>
    </head>

    <body>
        <menu-top><jsp:include page="/menu.jsp"/></menu-top><br><br>
        <div class="main-frame">
            <%int costo = 0;%>
            <h3>Creazione nuovo ordine</h3>
            Prodotti ordinati:<br><br>
            <table>
                <tr>
                    <td>Nome</td>
                    <td>Codice</td>
                    <td>Descrizione</td>
                    <td>Prezzo</td>
                    <td>Disponibili</td>
                    <td>Ordinati</td>
                </tr>
                <%if(session.getAttribute("ordine") != null){
                    Ordine ordine = (Ordine)session.getAttribute("ordine");
                    List<RigaOrdine> righe = ordine.getRigheOrdine();
                    for(int i=0;i<righe.size();i++){
                        out.print("<tr></tr>");
                    }
                }%>
            </table><br><br>
            Costo totale: <%=costo%><br><br>
            <a href="/aggiungiProdotto.do"><input type="Button" value="Aggiungi Prodotto"></a>
            <a href="/riepilogoOrdine.do"><input type="Button" value="Conferma Ordine"></a>
        </div>
    </body>
</html>
