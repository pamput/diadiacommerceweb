<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Riepilogo Inserimento Nuovo Prodotto</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>Si sta per inserire il prodotto seguente nel catalogo, confermare?</h3>

            <html:form action="inserisciProdotto.do" method="POST">
                <b>Nome:</b> <bean:write name="InserisciProdottoForm" property="nome" /><br><br>
                <b>Codice:</b> <bean:write name="InserisciProdottoForm" property="codice" /><br><br>
                <b>Descrizione:</b> <bean:write name="InserisciProdottoForm" property="descrizione" /><br><br>
                <b>Prezzo:</b> <bean:write name="InserisciProdottoForm" property="prezzo" /><br><br>
                <b>Quantità:</b> <bean:write name="InserisciProdottoForm" property="quantita" /><br><br>

                <input type="button" onclick="javascript:history.back()" value="Annulla"/>
                <html:submit value="Conferma"/>
            </html:form>

        </div>
    </body>
</html>

    