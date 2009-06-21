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
        <%@ page import='java.util.List,modello.Prodotto' %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    </head>

    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
        <h3>Prodotti in catalogo</h3><br>
        <center>
            <catalogo>

            <intestazione-catalogo>
                <cella-intestazione-catalogo class="nome">Nome</cella-intestazione-catalogo>
                <cella-intestazione-catalogo class="codice">Codice</cella-intestazione-catalogo>
                <cella-intestazione-catalogo class="descrizione">Descrizione</cella-intestazione-catalogo>
                <cella-intestazione-catalogo class="prezzo">Prezzo</cella-intestazione-catalogo>
                <cella-intestazione-catalogo class="disponibili">Disponibili</cella-intestazione-catalogo>
                <logic:equal name="role" value="admin">
                    <cella-intestazione-catalogo class="fornitori">Fornitori</cella-intestazione-catalogo>
                </logic:equal>
            </intestazione-catalogo>

            <!--Inizializza a 0 il contarore del logic iterate-->
            <% int i=0; %>
        
            <logic:iterate id="prodotto" name="catalogoProdotti">
                <!--Scrive il corpo del catalogo-->
                <corpo-catalogo>
                    <cella-corpo-catalogo class="nome">
                        <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="prodotto" paramProperty="id"><bean:write name="prodotto" property="nome" /></html:link>
                    </cella-corpo-catalogo>
                    <cella-corpo-catalogo class="codice"><bean:write name="prodotto" property="codice" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="descrizione"><bean:write name="prodotto" property="descrizione" /></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="prezzo"><bean:write name="prodotto" property="prezzo" />
                        <bean:message key="text.moneyvalue"/></cella-corpo-catalogo>
                    <cella-corpo-catalogo class="disponibili"><bean:write name="prodotto" property="quantita" /></cella-corpo-catalogo>
                    
                    <!--Se sta visualizzando la pagina un amministratore aggiunge la possibilta di mostrare i fornitori del prodotto-->
                    <logic:equal name="role" value="admin">
                        <cella-corpo-catalogo class="fornitori">
                            <html:link page="/richiestaFornitori.do" paramId="codiceProdotto" paramName="prodotto" paramProperty="codice">Visualizza</html:link>
                        </cella-corpo-catalogo>
                    </logic:equal>
                </corpo-catalogo>

                <!--Incrementa il contatore del logic iterate-->
                <% i++; %>
            </logic:iterate>
    </catalogo>
    </center>
    </div>
    </body>
</html>
