<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

 <head>
  <title>Inserimento Prodotto Completato</title>
  <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
    <%@ page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ page language="java" %>
    <%@ page import="web.form.InserisciProdottoForm" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 </head>
 
 <body>
    <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
    <div class="main-frame">
        <h3>L'inserimento e stato completato con successo</h3>

        Nome: <bean:write name="InserisciProdottoForm" property="nome" />
        <br>

        Codice: <bean:write name="InserisciProdottoForm" property="codice" />
        <br>

        Descrizione: <bean:write name="InserisciProdottoForm" property="descrizione" />
        <br>

        Prezzo: <bean:write name="InserisciProdottoForm" property="prezzo" />
        <br>

        Quantità: <bean:write name="InserisciProdottoForm" property="quantita" />
        <br>

        <a href='./richiestaInserisciProdotto.do'><input type='Button' value='Inserisci un nuovo prodotto'></a>

        
    </div>
</body>
 
</html>
