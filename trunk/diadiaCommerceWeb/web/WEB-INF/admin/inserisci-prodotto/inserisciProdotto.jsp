<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Inserimento Prodotto Completato</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <%@ include file="/menu.jsp" %>

        <div class="main-frame">
            <h3>L'inserimento e stato completato con successo</h3>

            <b>Nome:</b> <bean:write name="InserisciProdottoForm" property="nome" /><br><br>
            <b>Codice:</b> <bean:write name="InserisciProdottoForm" property="codice" /><br><br>
            <b>Descrizione:</b> <bean:write name="InserisciProdottoForm" property="descrizione" /><br><br>
            <b>Prezzo:</b> <bean:write name="InserisciProdottoForm" property="prezzo" /><br><br>
            <b>Quantità:</b> <bean:write name="InserisciProdottoForm" property="quantita" /><br><br>

            <html:link page='/richiestaInserisciProdotto.do'>
                <button>Inserisci un nuovo prodotto</button>
            </html:link>

            <%session.removeAttribute("InserimentoProdottoForm");%>

        </div>
    </body>
</html>
    