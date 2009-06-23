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
                <table>

                    <tr class="header">
                        <td class="nome">Nome</td>
                        <td class="codice">Codice</td>
                        <td class="descrizione">Descrizione</td>
                        <td class="prezzo">Prezzo</td>
                        <td class="disponibili">Disponibili</td>
                        <logic:equal name="role" value="admin">
                            <td class="fornitori">Fornitori</td>
                        </logic:equal>
                    </tr>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="prodotto" name="catalogoProdotti">
                        <!--Scrive il corpo del catalogo-->
                        <tr>
                            <td class="nome">
                                <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="prodotto" paramProperty="id"><bean:write name="prodotto" property="nome" /></html:link>
                            </td>
                            <td class="codice"><bean:write name="prodotto" property="codice" /></td>
                            <td class="descrizione"><bean:write name="prodotto" property="descrizione" /></td>
                            <td class="prezzo">
                                <bean:write name="prodotto" property="prezzo" />
                                <bean:message key="text.moneyvalue"/>
                            </td>
                            <td class="disponibili"><bean:write name="prodotto" property="quantita" /></td>

                            <!--Se sta visualizzando la pagina un amministratore aggiunge la possibilta di mostrare i fornitori del prodotto-->
                            <logic:equal name="role" value="admin">
                                <td class="fornitori">
                                    <html:link page="/richiestaFornitori.do" paramId="codiceProdotto" paramName="prodotto" paramProperty="codice">Visualizza</html:link>
                                </td>
                            </logic:equal>
                        </tr>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>
                </table>
            </center>
        </div>
    </body>
</html>
