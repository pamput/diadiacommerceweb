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
        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    </head>
    
    <body>
        <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
        <div class="main-frame">
            <h3>Benvenuto nella tua Homepage <%=name%>!</h3>
            <%session.removeAttribute("LoginForm");%>
        </div>
    </body>
</html>
