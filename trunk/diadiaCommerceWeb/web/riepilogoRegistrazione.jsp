<%-- 
    Document   : riepilogoRegistrazione
    Created on : 8-giu-2009, 3.22.46
    Author     : pamput
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Riepilogo Inserimento Nuovo Prodotto</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Dati registrazione</h3>

            <b>La registrazione è stata effettuata con successo!</b><br><br>

            <b>Username:</b> <bean:write name="RegistrazioneForm" property="username"/><br><br>
            <b>Password:</b> <bean:write name="RegistrazioneForm" property="password"/><br><br>
            <b>Codice Cliente:</b> <bean:write name="RegistrazioneForm" property="codicecliente"/><br><br>
        </div>

        <%session.removeAttribute("RegistrazioneForm");%>
    </body>
</html>
