<%-- 
    Document   : confermaAggiungiFornitore
    Created on : 21-giu-2009, 13.45.12
    Author     : Kimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conferma Aggiunta Fornitore</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />

        <%@ page language="java" %>
        <%@ page import='java.util.List,modello.Prodotto' %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    </head>

    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
            <h3>Il fornitore seguente è stato aggiunto</h3>
            <bean:write name="prodotto" property="nome"/>
            <br><br>
                <b>Nome:</b><bean:write name="fornitore" property="nome" /><br>
                <b>Telefono:</b><bean:write name="fornitore" property="telefono" /><br>
                <b>Indirizzo:</b><bean:write name="fornitore" property="indirizzo" /><br>
            <br><br>

        </div>
    </body>
</html>
