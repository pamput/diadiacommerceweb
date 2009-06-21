<%-- 
    Document   : personalPage
    Created on : 8-giu-2009, 13.19.52
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
        <%@ page import="modello.Cliente,modello.Ordine" %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

        <title>Homepage di <bean:write name="cliente" property="nome" /></title>
    </head>
    
    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
           <h3>Benvenuto nella tua Homepage <bean:write name="cliente" property="nome" />!</h3>

           <b>Riepilogo dati personali:</b><br><br>
                <b>Nome:</b><bean:write name="cliente" property="nome" /><br>
                <b>Codice:</b><bean:write name="cliente" property="codice" /><br>
                <b>P.Iva:</b><bean:write name="cliente" property="partitaiva" /><br>
                <b>Indirizzo:</b><bean:write name="cliente" property="indirizzo" /><br>
            <br><br>


            <b>Questi sono gli ordini da te effettuati:</b><br><br>
            <catalogo>
                <intestazione-catalogo>
                        <cella-intestazione-catalogo class="codice">Codice</cella-intestazione-catalogo>
                        <cella-intestazione-catalogo class="data">Data</cella-intestazione-catalogo>
                        <cella-intestazione-catalogo class="stato">Stato</cella-intestazione-catalogo>
                </intestazione-catalogo>

                <!--Inizializza a 0 il contarore del logic iterate-->
                <% int i=0; %>
                
                <logic:iterate id="ordine" name="ordini">
                    <!--Scrive il corpo della lista di ordini-->
                    <corpo-catalogo>
                        <cella-corpo-catalogo class="codice"><html:link action="dettaglioOrdine.do" paramId="idOrdine" paramName="ordine" paramProperty="id">
                            <bean:write name="ordine" property="codice" /></html:link></cella-corpo-catalogo>
                        <cella-corpo-catalogo class="data"><bean:write name="ordine" property="data" /></cella-corpo-catalogo>
                        <cella-corpo-catalogo class="stato"><bean:write name="ordine" property="stato" /></cella-corpo-catalogo>
                    </corpo-catalogo>
                </logic:iterate>

            </catalogo>
            <!--Rimuove la lista degli ordini dalla sessione-->
            <%session.removeAttribute("ordini");%>
        </div>
    </body>
</html>
