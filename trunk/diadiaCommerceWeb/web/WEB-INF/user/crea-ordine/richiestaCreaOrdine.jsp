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
        <script type="text/javascript" language="Javascript" src="./javascript/script.js"></script>

        <%@ page language="java" %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        
        <%@ page import="modello.RigaOrdine, modello.Prodotto, web.form.RigaOrdineForm, java.util.List, modello.Ordine" %>
    </head>


    


    <body>
        <menu-top><jsp:include page="/menu.jsp"/></menu-top><br><br>
        <div class="main-frame">
            <h3>Creazione nuovo ordine</h3>
            Prodotti ordinati:<br><br>

   <html:form action="/riepilogoCreaOrdine.do" method="POST">

<center>
    <catalogo>
        <intestazione-catalogo>
            <cella-intestazione-catalogo class="nome">Nome</cella-intestazione-catalogo>
            <cella-intestazione-catalogo class="codice">Codice</cella-intestazione-catalogo>
            <cella-intestazione-catalogo class="descrizione">Descrizione</cella-intestazione-catalogo>
            <cella-intestazione-catalogo class="prezzo">Prezzo</cella-intestazione-catalogo>
            <cella-intestazione-catalogo class="disponibili">Disponibili</cella-intestazione-catalogo>
            <cella-intestazione-catalogo class="ordinati">Ordinati</cella-intestazione-catalogo>
            
        </intestazione-catalogo>

        <%-- Questa variabile serve per l'indexing delle proprietà --%>
        <% int i=0; %>
        
        <logic:iterate id="prodotto" name="catalogoProdottiDisponibili">

        <!-- riga invisibile per visualizzare gli errori -->
        <corpo-catalogo>
            <cella-corpo-catalogo></cella-corpo-catalogo>
            <cella-corpo-catalogo></cella-corpo-catalogo>
            <cella-corpo-catalogo></cella-corpo-catalogo>
            <cella-corpo-catalogo></cella-corpo-catalogo>
            <cella-corpo-catalogo></cella-corpo-catalogo>
            <cella-corpo-catalogo><html:errors property='<%= "ordine[" + i + "]" %>'/></cella-corpo-catalogo>
        </corpo-catalogo>

        <corpo-catalogo>
            <cella-corpo-catalogo class="nome"><html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="prodotto" paramProperty="id">
                <bean:write name="prodotto" property="nome" /></html:link>
            </cella-corpo-catalogo>
            <cella-corpo-catalogo class="codice"><bean:write name="prodotto" property="codice" /></cella-corpo-catalogo>
            <cella-corpo-catalogo class="descrizione"><bean:write name="prodotto" property="descrizione" /></cella-corpo-catalogo>
            <cella-corpo-catalogo class="prezzo"><bean:write name="prodotto" property="prezzo" />
                <bean:message key="text.moneyvalue"/></cella-corpo-catalogo>
            <cella-corpo-catalogo class="disponibili"><bean:write name="prodotto" property="quantita" /></cella-corpo-catalogo>

            <!-- cella del numero degli ordini -->
            <cella-corpo-catalogo class="ordine">
                <input type="button"  onclick="javascript:decrementaDiUno('<%= "ordine" + i %>')" value="-" />
                <html:text name="RigaOrdineForm" property='<%= "ordine[" + i + "]" %>' size="2" styleId='<%= "ordine" + i %>' />
                <input type="button"  onclick="javascript:aumentaDiUno('<%= "ordine" + i %>')" value="+" />
                
            </cella-corpo-catalogo>
        </corpo-catalogo>

        <%-- Incrementa il parametro alla fine di ogni iterazione --%>
        <% i++; %>
        </logic:iterate>
    </catalogo>
    </center>

    <br>
    <br>

        <html:submit property="submit" value="Conferma Ordine"/>
    </html:form>

    </div>
    </body>
</html>
