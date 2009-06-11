<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  <head>
    <title>Inserimento Nuovo Prodotto</title>
    <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
    <%@ page language="java" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
  </head>
  
  <body>
    <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
    <div class="main-frame">
    <h3>Inserimento prodotto</h3>
	<html:form action="riepilogoInserimentoProdotto.do" method="POST">
		  Nome:
          <html:text name="InserimentoProdottoForm" property="nome"/>
          <html:errors property="nome"/><br><br>
		  Descrizione:
          <html:text name="InserimentoProdottoForm" property="descrizione"/>
          <html:errors property="descrizione"/><br><br>
		  Codice:
          <html:text name="InserimentoProdottoForm" property="codice"/>
          <html:errors  property="codice"/><br><br>
		  Prezzo:
          <html:text name="InserimentoProdottoForm" property="prezzo"/>
          <html:errors property="prezzo"/><br><br>
		  Quantita:
          <html:text name="InserimentoProdottoForm" property="quantita"/>
          <html:errors property="quantita"/><br><br>
          <html:submit value="Conferma"/>
	</html:form>
    </div>
  </body>
</html>
