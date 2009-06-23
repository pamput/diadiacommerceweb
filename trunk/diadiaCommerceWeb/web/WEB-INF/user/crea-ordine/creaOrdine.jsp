<%-- 
    Document   : confermaOrdine
    Created on : 15-giu-2009, 20.56.39
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file="/head.jsp" %>
        <title>Creazione Nuovo Ordine</title>
        <script type="text/javascript" language="Javascript" src="./javascript/script.js"></script>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>L'ordine è stato effettuato</h3>
            <b>Il suo ordine è stato registrato con successo. Può accedere ai dettagli dalla sua pagina utente.</b><br><br>

            <html:link page="/homepage.do">
                Torna alla Homepage
            </html:link>
        </div>
    </body>
</html>
