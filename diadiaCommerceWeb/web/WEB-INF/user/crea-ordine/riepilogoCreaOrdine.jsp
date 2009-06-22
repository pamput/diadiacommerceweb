<%--
    Document   : creaOrdine
    Created on : 15-giu-2009, 17.27.43
    Author     : pamput
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Creazione Nuovo Ordine</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Creazione nuovo ordine</h3>
            <b>Riepilogo del nuovo ordine:</b><br><br>

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

                    <logic:iterate id="riga" name="listaRigaOrdine">
                        <corpo-tabella>
                            <cella-corpo-tabella class="nome">
                                <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="riga" paramProperty="prodotto.id">
                                    <bean:write name="riga" property="prodotto.nome" />
                                </html:link>
                            </cella-corpo-tabella>
                            <cella-corpo-tabella class="codice"><bean:write name="riga" property="prodotto.codice" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="descrizione"><bean:write name="riga" property="prodotto.descrizione" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="prezzo">
                                <bean:write name="riga" property="prodotto.prezzo" />
                                <bean:message key="text.moneyvalue"/>
                            </cella-corpo-tabella>
                            <cella-corpo-tabella class="disponibili"><bean:write name="riga" property="prodotto.quantita" /></cella-corpo-tabella>

                            <!-- cella del numero degli ordini -->
                            <cella-corpo-tabella class="disponibili">
                                <bean:write name="riga" property="quantita" />
                            </cella-corpo-tabella>
                        </corpo-tabella>
                    </logic:iterate>

                </tabella>
            </center><br><br>

            <input type="button" onclick="javascript:history.back()" value="Annulla"/>
            <html:link page="/creaOrdine.do">
                <button>Conferma l'ordine</button>
            </html:link>
        </div>
    </body>
</html>
