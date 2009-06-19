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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fornitori</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />

        <%@ page language="java" %>
        <%@ page import='java.util.List,modello.Prodotto' %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    </head>

    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
        <h3>Elenco dei fornitori</h3><br>
        <center>
            <catalogo>
                <intestazione-catalogo>
                    <cella-intestazione-catalogo class="nome">Nome</cella-intestazione-catalogo>
                    <cella-intestazione-catalogo class="indirizzo">Codice</cella-intestazione-catalogo>
                    <cella-intestazione-catalogo class="telefono">Descrizione</cella-intestazione-catalogo>
                </intestazione-catalogo>

            <!--Inizializza a 0 il contarore del logic iterate-->
            <% int i=0; %>

            <logic:iterate id="fornitore" name="fornitori">
                <!--Scrive il corpo del catalogo-->
                <corpo-catalogo>
                    <cella-corpo-catalogo class="nome"><bean:write name="fornitore" property="nome" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="indirizzo"><bean:write name="fornitore" property="indirizzo" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="telefono"><bean:write name="fornitore" property="telefono" /></cella-corpo-catalogo>
                </corpo-catalogo>

                <!--Incrementa il contatore del logic iterate-->
                <% i++; %>
            </logic:iterate>
            </catalogo>
        </center><br><br>

        <html:link page="richiestaAggiuntaFornitore.do">
            <html:button property="aggiungiFornitore" value="Aggiungi Fornitore"/>
        </html:link>
        </div>
    </body>
</html>
