<%--
    Document   : creaOrdine
    Created on : 15-giu-2009, 17.27.43
    Author     : pamput
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creazione Nuovo Ordine</title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ page language="java" %>

        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

        <%@ page import="modello.Ordine" %>
        <%@ page import="modello.RigaOrdine, modello.Prodotto, persistenza.Facade,
        persistenza.postgresql.Facadepostgresql" %>
        <%@ page import="java.util.List" %>
        <%@ page import="web.form.RigaOrdineForm" %>


    </head>


    <body>
        <menu-top><jsp:include page="/menu.jsp"/></menu-top><br><br>
        <div class="main-frame">
            <h3>Creazione nuovo ordine</h3>
            Riepilogo del nuovo ordine:<br><br>

                <logic:iterate id="riga" name="listaRighaOrdine">

                </logic:iterate>



<% RigaOrdineForm form = (RigaOrdineForm) session.getAttribute("RigaOrdineForm"); %>


riepilogo: <%=form %><br><br>
<%=(List) session.getAttribute("listaRighaOrdine") %>
<br>
<input type="button" onclick="javascript:history.back()" value="Indietro"/>
    </div>
    </body>
</html>
