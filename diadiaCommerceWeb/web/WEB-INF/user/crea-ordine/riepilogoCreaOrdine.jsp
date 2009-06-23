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
                <table>
                    <tr>
                        <td class="nome">Nome</td>
                        <td class="codice">Codice</td>
                        <td class="descrizione">Descrizione</td>
                        <td class="prezzo">Prezzo</td>
                        <td class="disponibili">Disponibili</td>
                        <td class="ordinati">Ordinati</td>
                    </tr>

                    <logic:iterate id="riga" name="listaRigaOrdine">
                        <tr>
                            <td class="nome">
                                <html:link page="/dettaglioProdotto.do" paramId="idProdotto" paramName="riga" paramProperty="prodotto.id">
                                    <bean:write name="riga" property="prodotto.nome" />
                                </html:link>
                            </td>
                            <td class="codice"><bean:write name="riga" property="prodotto.codice" /></td>
                            <td class="descrizione"><bean:write name="riga" property="prodotto.descrizione" /></td>
                            <td class="prezzo">
                                <bean:write name="riga" property="prodotto.prezzo" />
                                <bean:message key="text.moneyvalue"/>
                            </td>
                            <td class="disponibili"><bean:write name="riga" property="prodotto.quantita" /></td>

                            <!-- cella del numero degli ordini -->
                            <td class="disponibili">
                                <bean:write name="riga" property="quantita" />
                            </td>
                        </tr>
                    </logic:iterate>

                </table>
            </center><br><br>

            <input type="button" onclick="javascript:history.back()" value="Annulla"/>
            <html:link page="/creaOrdine.do">
                <button>Conferma l'ordine</button>
            </html:link>
        </div>
    </body>
</html>
