<%-- 
    Document   : adminPage
    Created on : 20-giu-2009, 11.48.05
    Author     : Kimo
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file="/head.jsp" %>
        <%@ page import="modello.Ordine" %>
        <title>Pannello amministratore</title>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Benvenuto nel pannello di amministrazione!</h3>

            <b>Questa è la lista degli ordini:</b><br><br>
            <center>
                <table>
                    <tr class="header">
                        <td class="codice">Codice</td>
                        <td class="cliente">Cliente</td>
                        <td class="data">Data</td>
                        <td class="stato">Stato</td>
                        <td class="evadi">Evadi</td>
                    </tr>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="ordine" name="ordini">
                        <!--Scrive il corpo della lista di ordini-->
                        <tr>
                            <td class="codice"><bean:write name="ordine" property="codice" /></td>
                            <td class="cliente"><bean:write name="ordine" property="cliente" /></td>
                            <td class="data"><bean:write name="ordine" property="data" /></td>
                            <td class="stato"><bean:write name="ordine" property="stato" /></td>
                            <td class="stato">
                                <logic:equal value="chiuso" name="ordine" property="stato">
                                    <html:link page="/richiestaEvadiOrdine.do" paramId="codiceOrdine" paramName="ordine" paramProperty="codice">Evadi</html:link>
                                </logic:equal>
                            </td>
                        </tr>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>

                </table>
            </center><br><br>

            <!--Rimuove la lista degli ordini dalla sessione-->
            <%session.removeAttribute("ordini");%>
        </div>
    </body>
</html>
    