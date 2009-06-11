<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

 <head>
  <title>Inserimento Prodotto Completato</title>
  <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
    <%@ page language="java" %>
    <%@ page import="web.form.InserimentoProdottoForm" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 </head>
 
 <body>
    <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
    <div class="main-frame">
        <h3>L'inserimento e stato completato con successo</h3>
        <%InserimentoProdottoForm form = (InserimentoProdottoForm)session.getAttribute("InserimentoProdottoForm");%>
        Nome: <%=form.getNome()%><br><br>
        Descrizione: <%=form.getDescrizione()%><br><br>
        Codice: <%=form.getCodice()%><br><br>
        Prezzo: <%=form.getPrezzo()%><br><br>
        Quantita: <%=form.getQuantita()%><br><br>
        <a href='./richiestaInserimentoProdotto.do'><input type='Button' value='Inserisci un nuovo prodotto'></a>
        <%session.removeAttribute("InserimentoProdottoForm");%>
    </div>
</body>
 
</html>
