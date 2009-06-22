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
        <%@ include file="/head.jsp" %>
        <title>Catalogo Prodotti</title>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Prodotti in catalogo</h3><br>
            <center>
                <tabella>

                    <intestazione-tabella>
                        <cella-intestazione-tabella class="nome">Nome</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="codice">Codice</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="descrizione">Descrizione</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="prezzo">Prezzo</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="disponibili">Disponibili</cella-intestazione-tabella>
                        <logic:equal name="role" value="admin">
                            <cella-intestazione-tabella class="fornitori">Fornitori</cella-intestazione-tabella>
                        </logic:equal>
                    </intestazione-tabella>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="prodotto" name="catalogoProdotti">
                        <!--Scrive il corpo del catalogo-->
                        <corpo-tabella>
                            <cella-corpo-tabella class="nome">
                                <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="prodotto" paramProperty="id"><bean:write name="prodotto" property="nome" /></html:link>
                            </cella-corpo-tabella>
                            <cella-corpo-tabella class="codice"><bean:write name="prodotto" property="codice" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="descrizione"><bean:write name="prodotto" property="descrizione" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="prezzo">
                                <bean:write name="prodotto" property="prezzo" />
                                <bean:message key="text.moneyvalue"/>
                            </cella-corpo-tabella>
                            <cella-corpo-tabella class="disponibili"><bean:write name="prodotto" property="quantita" /></cella-corpo-tabella>

                            <!--Se sta visualizzando la pagina un amministratore aggiunge la possibilta di mostrare i fornitori del prodotto-->
                            <logic:equal name="role" value="admin">
                                <cella-corpo-tabella class="fornitori">
                                    <html:link page="/richiestaFornitori.do" paramId="codiceProdotto" paramName="prodotto" paramProperty="codice">Visualizza</html:link>
                                </cella-corpo-tabella>
                            </logic:equal>
                        </corpo-tabella>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </tabella>
            </center>
        </div>
    </body>
</html>
