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
                    <table>
                        <tr>
                            <td class="nome">Nome</td>
                            <td class="codice">Codice</td>
                            <td class="descrizione">Descrizione</td>
                            <td class="prezzo">Prezzo</td>
                            <td class="disponibili">Disponibili</td>
                            <td class="ordinati">Ordinati</td>
                        </tr>

                        <%-- Questa variabile serve per l'indexing delle proprietà --%>
                        <% int i = 0;%>

                        <logic:iterate id="prodotto" name="catalogoProdottiDisponibili">
                            <!-- riga invisibile per visualizzare gli errori -->
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><html:errors property='<%= "ordine[" + i + "]" %>'/></td>
                            </tr>

                            <tr>
                                <td class="nome">
                                    <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="prodotto" paramProperty="id">
                                        <bean:write name="prodotto" property="nome" />
                                    </html:link>
                                </td>
                                <td class="codice"><bean:write name="prodotto" property="codice" /></td>
                                <td class="descrizione"><bean:write name="prodotto" property="descrizione" /></td>
                                <td class="prezzo">
                                    <bean:write name="prodotto" property="prezzo" />
                                    <bean:message key="text.moneyvalue"/>
                                </td>
                                <td class="disponibili"><bean:write name="prodotto" property="quantita" /></td>

                                <!-- cella del numero degli ordini -->
                                <td class="ordine">
                                    <input type="button"  onclick="javascript:decrementaDiUno('<%= "ordine" + i%>')" value="-" />
                                    <html:text name="RigaOrdineForm" property='<%= "ordine[" + i + "]" %>' size="2" styleId='<%= "ordine" + i %>' />
                                    <input type="button"  onclick="javascript:aumentaDiUno('<%= "ordine" + i%>')" value="+" />
                                </td>

                            </tr>

                            <%-- Incrementa il parametro alla fine di ogni iterazione --%>
                            <% i++;%>
                        </logic:iterate>
                    </table>
                </center><br><br>
                    
                <html:submit property="submit" value="Conferma Ordine"/>
            </html:form>

        </div>
    </body>
</html>
