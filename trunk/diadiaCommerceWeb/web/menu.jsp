<center>
    <menu-top>Menu:

        <logic:empty name="role">
            <html:link page="/login.jsp">Login  </html:link> |
            <html:link page="/registrati.jsp">Registrati  </html:link> |
            <html:link page="/catalogoProdotti.do">Catalogo Prodotti  </html:link>
        </logic:empty>

        <logic:equal name="role" value="user">
            <html:link page="/logout.do">Logout  </html:link> |
            <html:link page="/homepage.do">Homepage  </html:link> |
            <html:link page="/catalogoProdotti.do">Catalogo Prodotti  </html:link> |
            <html:link page="/richiestaCreaOrdine.do">Crea Ordine  </html:link>
        </logic:equal>

        <logic:equal name="role" value="admin">
            <html:link page="/logout.do">Logout  </html:link> |
            <html:link page="/homepage.do">Homepage  </html:link> |
            <html:link page="/catalogoProdotti.do">Catalogo Prodotti  </html:link> | 
            <html:link page="/richiestaInserisciProdotto.do">Inserisci Prodotto  </html:link>
        </logic:equal>

    </menu-top>
</center>
<br><br>
