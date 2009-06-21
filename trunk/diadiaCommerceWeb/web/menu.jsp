<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

 <head>
  <title>DiaDia Commerce Menu</title>
  <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
        <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
 </head>
 
 <body>
	<center>Menu:
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
        <html:link page="/richiestaCreaOrdine.do"><input type='Button' value='Crea Ordine'></html:link>
	</logic:equal>
    </center>
 </body>
 
</html>
