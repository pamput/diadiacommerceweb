<%-- 
    Document   : register
    Created on : 8-giu-2009, 2.53.23
    Author     : pamput
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <head>
        <title>Registrazione</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Registrazione nuovo utente</h3><br>
            <html:form action="/registrati.do" method="POST">
                <b>Username:</b>
                <html:text name="RegistrazioneForm" property="username"/>
                <html:errors property="username"/><br><br>
                <b>Password:</b>
                <html:password name="RegistrazioneForm" property="password"/>
                <html:errors property="password"/><br><br>
                <b>Conferma Password:</b>
                <html:password name="RegistrazioneForm" property="passwordconf"/>
                <html:errors property="passwordconf"/><br><br>
                <b>Codice Cliente:</b>
                <html:text name="RegistrazioneForm" property="codicecliente"/>
                <html:errors property="codicecliente"/><br><br>
                <html:submit value="Registra"/>
            </html:form>
        </div>
    </body>
</html>
