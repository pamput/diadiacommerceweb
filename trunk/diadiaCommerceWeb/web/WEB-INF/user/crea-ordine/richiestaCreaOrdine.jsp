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
        <title>Creazione Nuovo Ordine</title>
        <%@ include file="/head.jsp" %>
        <script type="text/javascript" language="Javascript" src="./javascript/script.js"></script>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Creazione nuovo ordine</h3>
            Prodotti ordinati:<br><br>

            <html:form action="/riepilogoCreaOrdine.do" method="POST">
                <center>
                    <tabella>
                        <intestazione-tabella>
                            <cella-intestazione-tabella class="nome">Nome</cella-intestazione-tabella>
                            <cella-intestazione-tabella class="codice">Codice</cella-intestazione-tabella>
                            <cella-intestazione-tabella class="descrizione">Descrizione</cella-intestazione-tabella>
                            <cella-intestazione-tabella class="prezzo">Prezzo</cella-intestazione-tabella>
                            <cella-intestazione-tabella class="disponibili">Disponibili</cella-intestazione-tabella>
                            <cella-intestazione-tabella class="ordinati">Ordinati</cella-intestazione-tabella>
                        </intestazione-tabella>

                        <%-- Questa variabile serve per l'indexing delle proprietà --%>
                        <% int i = 0;%>

                        <logic:iterate id="prodotto" name="catalogoProdottiDisponibili">
                            <!-- riga invisibile per visualizzare gli errori -->
                            <corpo-tabella>
                                <cella-corpo-tabella></cella-corpo-tabella>
                                <cella-corpo-tabella></cella-corpo-tabella>
                                <cella-corpo-tabella></cella-corpo-tabella>
                                <cella-corpo-tabella></cella-corpo-tabella>
                                <cella-corpo-tabella></cella-corpo-tabella>
                                <cella-corpo-tabella><html:errors property='<%= "ordine[" + i + "]" %>'/></cella-corpo-tabella>
                            </corpo-tabella>

                            <corpo-tabella>
                                <cella-corpo-tabella class="nome">
                                    <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="prodotto" paramProperty="id">
                                        <bean:write name="prodotto" property="nome" />
                                    </html:link>
                                </cella-corpo-tabella>
                                <cella-corpo-tabella class="codice"><bean:write name="prodotto" property="codice" /></cella-corpo-tabella>
                                <cella-corpo-tabella class="descrizione"><bean:write name="prodotto" property="descrizione" /></cella-corpo-tabella>
                                <cella-corpo-tabella class="prezzo">
                                    <bean:write name="prodotto" property="prezzo" />
                                    <bean:message key="text.moneyvalue"/>
                                </cella-corpo-tabella>
                                <cella-corpo-tabella class="disponibili"><bean:write name="prodotto" property="quantita" /></cella-corpo-tabella>

                                <!-- cella del numero degli ordini -->
                                <cella-corpo-tabella class="ordine">
                                    <input type="button"  onclick="javascript:decrementaDiUno('<%= "ordine" + i%>')" value="-" />
                                    <html:text name="RigaOrdineForm" property='<%= "ordine[" + i + "]" %>' size="2" styleId='<%= "ordine" + i %>' />
                                    <input type="button"  onclick="javascript:aumentaDiUno('<%= "ordine" + i%>')" value="+" />
                                </cella-corpo-tabella>

                            </corpo-tabella>

                            <%-- Incrementa il parametro alla fine di ogni iterazione --%>
                            <% i++;%>
                        </logic:iterate>
                    </tabella>
                </center><br><br>
                    
                <html:submit property="submit" value="Conferma Ordine"/>
            </html:form>

        </div>
    </body>
</html>
