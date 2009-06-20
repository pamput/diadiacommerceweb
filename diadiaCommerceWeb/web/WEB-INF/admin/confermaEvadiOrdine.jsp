<%-- 
    Document   : confermaEvadiOrdine
    Created on : 20-giu-2009, 14.28.00
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ page language="java" %>
        <%@ page import="modello.Ordine" %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

        <title>Evadi Ordine</title>
    </head>

    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
           <h3>L'ordine seguente è stato evaso</h3>

           <b>Riepilogo dati ordine:</b><br><br>
                <b>Codice:</b><bean:write name="ordine" property="codice" /><br>
                <b>Cliente:</b><bean:write name="ordine" property="cliente" /><br>
                <b>Data:</b><bean:write name="ordine" property="data" /><br>
           <br><br>

            <b>Prodotti:</b><br><br>
            <center>
            <catalogo>
                <intestazione-catalogo>
                        <cella-intestazione-catalogo class="prodotto">Prodotto</cella-intestazione-catalogo>
                        <cella-intestazione-catalogo class="quantita">Quantita</cella-intestazione-catalogo>
                </intestazione-catalogo>

                <!--Inizializza a 0 il contarore del logic iterate-->
                <% int i=0; %>

                <logic:iterate id="riga" name="righeOrdine">
                    <!--Scrive il corpo della lista di ordini-->
                    <corpo-catalogo>
                        <cella-corpo-catalogo class="prodotto"><bean:write name="riga" property="prodotto" /></cella-corpo-catalogo>
                        <cella-corpo-catalogo class="quantita"><bean:write name="riga" property="quantita" /></cella-corpo-catalogo>
                    </corpo-catalogo>

                    <!--Incrementa il contatore del logic iterate-->
                    <% i++; %>
                </logic:iterate>
            </catalogo>
            </center>

            <html:link page="/homepage.do">
                <html:button value="Torna alla Homepage" property="home"/>
            </html:link>
        </div>
    </body>
</html>
