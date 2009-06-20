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
    <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
    <%@ page language="java" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
  </head>
    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
        <h3>Registrazione nuovo utente</h3><br>
        <html:form action="/registrati.do" method="POST">
            Username:
            <html:text name="RegistrazioneForm" property="username"/>
            <html:errors property="username"/><br><br>
            Password:
            <html:password name="RegistrazioneForm" property="password"/>
            <html:errors property="password"/><br><br>
            Conferma Password:
            <html:password name="RegistrazioneForm" property="passwordconf"/>
            <html:errors property="passwordconf"/><br><br>
            Codice Cliente:
            <html:text name="RegistrazioneForm" property="codicecliente"/>
            <html:errors property="codicecliente"/><br><br>
            <html:submit value="Registra"/>
        </html:form>
        </div>
    </body>
</html>
