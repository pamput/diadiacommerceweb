<center>
    <menu-top>Menu:

        <logic:empty name="role">
            <html:link page="/login.jsp"><input type='Button' value='Login'></html:link>
            <html:link page="/registrati.jsp"><input type='Button' value='Registrati'></html:link>
            <html:link page="/catalogoProdotti.do"><input type='Button' value='Catalogo Prodotti'></html:link>
        </logic:empty>

        <logic:equal name="role" value="user">
            <html:link page="/logout.do"><input type='Button' value='Logout'></html:link>
            <html:link page="/homepage.do"><input type='Button' value='Homepage'></html:link>
            <html:link page="/catalogoProdotti.do"><input type='Button' value='Catalogo Prodotti'></html:link>
            <html:link page="/richiestaCreaOrdine.do"><input type='Button' value='Crea Ordine'></html:link>
        </logic:equal>

        <logic:equal name="role" value="admin">
            <html:link page="/logout.do"><input type='Button' value='Logout'></html:link>
            <html:link page="/homepage.do"><input type='Button' value='Homepage'></html:link>
            <html:link page="/catalogoProdotti.do"><input type='Button' value='Catalogo Prodotti'></html:link>
            <html:link page="/richiestaInserisciProdotto.do"><input type='Button' value='Inserisci Prodotto'></html:link>
        </logic:equal>

    </menu-top>
</center>
<br><br>
