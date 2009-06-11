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
    <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
    <%@ page language="java" %>
    <%@ page import="web.form.RegistrazioneForm" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
</head>
    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <% RegistrazioneForm form = (RegistrazioneForm)session.getAttribute("RegistrazioneForm"); %>
        <div class="main-frame">
            <h3>Dati registrazione</h3>
            Username: <%=form.getUsername() %><br><br>
            Password: <%=form.getPassword() %><br><br>
            Codice Cliente: <%=form.getCodicecliente() %><br><br>
        </div>
    </body>
</html>
