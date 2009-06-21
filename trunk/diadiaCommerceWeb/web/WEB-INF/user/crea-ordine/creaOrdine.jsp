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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creazione Nuovo Ordine</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <script type="text/javascript" language="Javascript" src="./javascript/script.js"></script>

        <%@ page language="java" %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

        <%@ page import="modello.RigaOrdine, modello.Prodotto, web.form.RigaOrdineForm, java.util.List, modello.Ordine" %>
    </head>
    <body>
        
        <menu-top><jsp:include page="/menu.jsp"/></menu-top><br><br>
            <div class="main-frame">
        <h3>L'ordine è stato effettuato</h3>
        Il suo ordine è stato registrato con successo. Può accedere ai dettagli dalla sua pagina utente.
        </div>
    </body>
</html>
