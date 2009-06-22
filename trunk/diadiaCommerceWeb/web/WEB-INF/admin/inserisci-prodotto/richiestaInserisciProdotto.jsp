<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Inserimento Nuovo Prodotto</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Inserimento prodotto</h3>

            <html:form action="riepilogoInserisciProdotto.do" method="POST">
                <b>Nome:</b>
                <html:text name="InserisciProdottoForm" property="nome" size="60"/>
                <html:errors property="nome"/><br><br>
                <b>Descrizione:</b><br>
                <html:textarea name="InserisciProdottoForm" property="descrizione" rows="3" cols="60" />
                <html:errors property="descrizione"/><br><br>
                <b>Codice:</b>
                <html:text name="InserisciProdottoForm" property="codice"/>
                <html:errors  property="codice"/><br><br>
                <b>Prezzo:</b>
                <html:text name="InserisciProdottoForm" property="prezzo"/>
                <html:errors property="prezzo"/><br><br>
                <b>Quantita:</b>
                <html:text name="InserisciProdottoForm" property="quantita"/>
                <html:errors property="quantita"/><br><br>

                <html:submit value="Conferma"/>
            </html:form>

        </div>
    </body>
</html>
    