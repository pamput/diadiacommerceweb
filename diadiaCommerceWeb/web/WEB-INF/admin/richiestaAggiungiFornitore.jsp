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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aggiungi Fornitore</title>
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
        <h3>Aggiungi un fornitore</h3><br>
        <b>Seleziona un fornitore dalla lista di quelli presenti...</b><br><br>
        <center>
            <catalogo>
                <intestazione-catalogo>
                    <cella-intestazione-catalogo class="nome">Nome</cella-intestazione-catalogo>
                    <cella-intestazione-catalogo class="indirizzo">Indirizzo</cella-intestazione-catalogo>
                    <cella-intestazione-catalogo class="telefono">Telefono</cella-intestazione-catalogo>
                    <cella-intestazione-catalogo class="aggiungi">Aggiungi</cella-intestazione-catalogo>
                </intestazione-catalogo>

            <!--Inizializza a 0 il contarore del logic iterate-->
            <% int i=0; %>

            <logic:iterate id="fornitore" name="fornitori">
                <!--Scrive il corpo del catalogo-->
                <corpo-catalogo>
                    <cella-corpo-catalogo class="nome"><bean:write name="fornitore" property="nome" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="indirizzo"><bean:write name="fornitore" property="indirizzo" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="telefono"><bean:write name="fornitore" property="telefono" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="aggiungi">
                        <html:link page="/confermaAggiungiFornitoreEsistente.do" paramId="nomeFornitore" paramName="fornitore" paramProperty="nome">Aggiungi</html:link>
                    </cella-corpo-catalogo>
                </corpo-catalogo>

                <!--Incrementa il contatore del logic iterate-->
                <% i++; %>
            </logic:iterate>
            </catalogo>
        </center><br><br>

        <b>...o aggiungi un nuovo fornitore:</b><br><br>
        <html:form action="/confermaAggiungiNuovoFornitore.do" method="POST">
		  Nome:
          <html:text name="AggiungiFornitoreForm" property="nome"/>
          <html:errors property="nome"/><br><br>
		  Indirizzo:
          <html:text name="AggiungiFornitoreForm" property="indirizzo"/>
          <html:errors property="indirizzo"/><br><br>
		  Telefono:
          <html:text name="AggiungiFornitoreForm" property="telefono"/>
          <html:errors  property="telefono"/><br><br>
          <html:submit value="Conferma"/>
        </html:form>
        </div>
    </body>
</html>
