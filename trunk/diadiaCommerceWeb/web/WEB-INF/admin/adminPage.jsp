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
                <tabella>
                    <intestazione-tabella>
                        <cella-intestazione-tabella class="codice">Codice</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="cliente">Cliente</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="data">Data</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="stato">Stato</cella-intestazione-tabella>
                        <cella-intestazione-tabella class="evadi">Evadi</cella-intestazione-tabella>
                    </intestazione-tabella>

                    <!--Inizializza a 0 il contarore del logic iterate-->
                    <% int i = 0;%>

                    <logic:iterate id="ordine" name="ordini">
                        <!--Scrive il corpo della lista di ordini-->
                        <corpo-tabella>
                            <cella-corpo-tabella class="codice"><bean:write name="ordine" property="codice" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="cliente"><bean:write name="ordine" property="cliente" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="data"><bean:write name="ordine" property="data" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="stato"><bean:write name="ordine" property="stato" /></cella-corpo-tabella>
                            <cella-corpo-tabella class="stato">
                                <logic:equal value="chiuso" name="ordine" property="stato">
                                    <html:link page="/richiestaEvadiOrdine.do" paramId="codiceOrdine" paramName="ordine" paramProperty="codice">Evadi</html:link>
                                </logic:equal>
                            </cella-corpo-tabella>
                        </corpo-tabella>

                        <!--Incrementa il contatore del logic iterate-->
                        <% i++;%>
                    </logic:iterate>

                </tabella>
            </center><br><br>

            <!--Rimuove la lista degli ordini dalla sessione-->
            <%session.removeAttribute("ordini");%>
        </div>
    </body>
</html>
    