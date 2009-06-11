<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Riepilogo Inserimento Nuovo Prodotto</title>
    <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
    <%@ page language="java" %>
    <%@ page import="web.form.InserimentoProdottoForm" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
</head>
  
<body>
  <menu-top><jsp:include page="/menu.jsp" /></menu-top><br><br>
  <%InserimentoProdottoForm form = (InserimentoProdottoForm)session.getAttribute("InserimentoProdottoForm");%>
  
  <div class="main-frame">
  <h3>Si sta per inserire il prodotto seguente nel catalogo, confermare?</h3>

  <html:form action="confermaInserimentoProdotto.do" method="POST">
    Nome: <html:text name="InserimentoProdottoForm" property="nome" disabled="true">
        <%=form.getNome()%>
    </html:text><br><br>
    Codice: <html:text name="InserimentoProdottoForm" property="codice" disabled="true">
        <%=form.getCodice()%>
    </html:text><br><br>
    Descrizione: <html:text name="InserimentoProdottoForm" property="descrizione" disabled="true">
        <%=form.getDescrizione()%>
    </html:text><br><br>
    Prezzo: <html:text name="InserimentoProdottoForm" property="prezzo" disabled="true">
        <%=form.getPrezzo()%>
    </html:text><br><br>
    Quantità: <html:text name="InserimentoProdottoForm" property="quantita" disabled="true">
        <%=form.getQuantita()%>
    </html:text><br><br>
	<a href='richiestaInserimentoProdotto.do'><button type="button">Annulla</button></a>
	<html:submit value="Conferma"/>
  </html:form>
  </div>
</body>
</html>

