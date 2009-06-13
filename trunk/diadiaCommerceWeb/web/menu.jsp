<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

 <head>
  <title>DiaDia Commerce Menu</title>
  <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" /> 
 </head>
 
 <body> 
	Menu:
    <%if(request.getSession().getAttribute("role") == null){%>
        <a href=<%= response.encodeURL("./login.jsp") %>><input type='Button' value='Login'></a>
        <a href=<%= response.encodeURL("./registrati.jsp") %>><input type='Button' value='Registrati'></a>
        <a href=<%= response.encodeURL("./catalogoProdotti.do") %>><input type='Button' value='Catalogo Prodotti'></a>
    <%}if((request.getSession().getAttribute("role") != null)&&(request.getSession().getAttribute("role").equals("user"))){%>
        <a href=<%= response.encodeURL("./logout.do") %>><input type='Button' value='Logout'></a>
        <a href=<%= response.encodeURL("./catalogoProdotti.do") %>><input type='Button' value='Catalogo Prodotti'></a>
        <a href=<%= response.encodeURL("./creaOrdine.do") %>><input type='Button' value='Crea Ordine'></a>
    <%}if((request.getSession().getAttribute("role") != null)&&(request.getSession().getAttribute("role").equals("admin"))){%>
        <a href=<%= response.encodeURL("./logout.do") %>><input type='Button' value='Logout'></a>
        <a href=<%= response.encodeURL("./catalogoProdotti.do") %>><input type='Button' value='Catalogo Prodotti'></a>
        <a href=<%= response.encodeURL("./richiestaInserimentoProdotto.do") %>><input type='Button' value='Inserisci Prodotto'></a>
	<%}%>
 </body>
 
</html>
