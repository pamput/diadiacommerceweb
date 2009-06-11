<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//IT" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  <head>
    <title>Errore</title>
  <link rel="stylesheet" type="text/css" href="./diadiacommerce.css" />
  <%@ page contentType="text/html; charset=UTF-8" %>
  </head>
  
  <body> 
  Si è verificato un errore, il messaggio generato dal sistema è:<br>
  <errore><%= request.getParameter("messaggio")%></errore>
  </body>
</html>

