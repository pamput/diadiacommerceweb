<%-- 
    Document   : personalPage
    Created on : 8-giu-2009, 13.19.52
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file="/head.jsp" %>
        <title>Homepage di <bean:write name="cliente" property="nome" /></title>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Benvenuto nella tua Homepage <bean:write name="cliente" property="nome" />!</h3>

            <b>Riepilogo dati personali:</b><br><br>
            <b>Nome: </b><bean:write name="cliente" property="nome" /><br>
            <b>Codice: </b><bean:write name="cliente" property="codice" /><br>
            <b>P.Iva: </b><bean:write name="cliente" property="partitaiva" /><br>
            <b>Indirizzo: </b><bean:write name="cliente" property="indirizzo" /><br>
            <br><br>


            <b>Questi sono gli ordini da te effettuati:</b><br><br>
            <table>
                <tr class="header">
                    <td class="codice">Codice</td>
                    <td class="data">Data</td>
                    <td class="stato">Stato</td>
                </tr>

                <!--Inizializza a 0 il contarore del logic iterate-->
                <% int i = 0;%>

                <logic:iterate id="ordine" name="ordini">
                    <!--Scrive il corpo della lista di ordini-->
                    <tr>
                        <td class="codice">
                            <html:link action="dettaglioOrdine.do" paramId="idOrdine" paramName="ordine" paramProperty="id">
                                <bean:write name="ordine" property="codice" />
                            </html:link>
                        </td>
                        <td class="data"><bean:write name="ordine" property="data" /></td>
                        <td class="stato"><bean:write name="ordine" property="stato" /></td>
                    </tr>
                </logic:iterate>

            </table>
            <!--Rimuove la lista degli ordini dalla sessione-->
            <%session.removeAttribute("ordini");%>
        </div>
    </body>
</html>
