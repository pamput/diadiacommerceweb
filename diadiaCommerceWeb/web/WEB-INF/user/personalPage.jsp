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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String name = ((LoginForm)session.getAttribute("LoginForm")).getUsername();%>
        <title>Homepage di <%=name%></title>
        <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ page language="java" %>
        <%@ page import="web.form.LoginForm" %>
        <%@ page import="modello.Cliente,modello.Ordine,java.util.List" %>
        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    </head>
    
    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
            <h3>Benvenuto nella tua Homepage <%=name%>!</h3>
            <%if(session.getAttribute("cliente")!= null){
                Cliente cliente = (Cliente)session.getAttribute("cliente");%>
           <b>Riepilogo dati Personali:</b><br><br>
                <b>Nome:</b><%=cliente.getNome()%><br>
                <b>Codice:</b><%=cliente.getCodice()%><br>
                <b>P.Iva:</b><%=cliente.getPartitaiva()%><br>
                <b>Indirizzo:</b><%=cliente.getNome()%><br>
            <br><br>
            <%}%>

            <%if(session.getAttribute("ordini")!= null){
                List<Ordine> ordini = (List<Ordine>)session.getAttribute("ordini");%>
            <b>Questi sono gli ordini da te effettuati:</b><br><br>
                <table>
                    <tr><h3>
                        <td>Codice</td>
                        <td>Data</td>
                        <td>Stato</td>
                    </h3></tr>
                    <%for(int i=0;i<ordini.size();i++){%>
                    <tr>
                        <%
                        Ordine ordine = ordini.get(i);
                        out.print("<td>"+ordine.getCodice()+"</td>");
                        out.print("<td>"+ordine.getData()+"</td>");
                        out.print("<td>"+ordine.getStato()+"</td>");
                        %>
                    </tr>
                    <%}%>
                </table>
            <%}%>
            <%session.removeAttribute("LoginForm");
            session.removeAttribute("ordini");%>
        </div>
    </body>
</html>
