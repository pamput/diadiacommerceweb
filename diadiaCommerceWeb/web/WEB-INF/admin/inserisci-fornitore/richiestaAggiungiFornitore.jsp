<%-- 
    Document   : aggiungiFornitore
    Created on : 21-giu-2009, 13.44.59
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Aggiungi Fornitore</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Aggiungi un fornitore</h3><br>
            <b>Seleziona un fornitore dalla lista di quelli presenti...</b><br><br>
            <center>
                <table>
                    <tr class="header">
                        <td class="nome">Nome</td>
                        <td class="indirizzo">Indirizzo</td>
                        <td class="telefono">Telefono</td>
                        <td class="aggiungi">Aggiungi</td>
                    </tr>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="fornitore" name="fornitori">
                        <!--Scrive il corpo del catalogo-->
                        <tr>
                            <td class="nome"><bean:write name="fornitore" property="nome" /></td>
                            <td class="indirizzo"><bean:write name="fornitore" property="indirizzo" /></td>
                            <td class="telefono"><bean:write name="fornitore" property="telefono" /></td>
                            <td class="aggiungi">
                                <html:link page="/confermaAggiungiFornitoreEsistente.do" paramId="nomeFornitore" paramName="fornitore" paramProperty="nome">Aggiungi</html:link>
                            </td>
                        </tr>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </table>
            </center><br><br>

            <b>...o aggiungi un nuovo fornitore:</b><br><br>
            <html:form action="/confermaAggiungiNuovoFornitore.do" method="POST">
                <b>Nome:</b>
                <html:text name="AggiungiFornitoreForm" property="nome"/>
                <html:errors property="nome"/><br><br>
                <b>Indirizzo:</b>
                <html:text name="AggiungiFornitoreForm" property="indirizzo"/>
                <html:errors property="indirizzo"/><br><br>
                <b>Telefono:</b>
                <html:text name="AggiungiFornitoreForm" property="telefono"/>
                <html:errors  property="telefono"/><br><br>

                <input type="button" onclick="javascript:history.back()" value="Annulla"/>
                <html:submit value="Conferma"/>
            </html:form>

        </div>
    </body>
</html>
    