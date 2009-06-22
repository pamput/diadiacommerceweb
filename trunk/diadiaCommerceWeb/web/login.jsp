<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Login</title>
        <%@ include file="/head.jsp" %>
    </head>

    <body>
        <center>
            <%@ include file="/menu.jsp" %>

            <div class="main-frame">
                <welcome-message>Benvenuto in DiaDia Commerce!</welcome-message><br>
                <% String role = "Utente anonimo";
        if (session.getAttribute("role") != null) {
            role = (String) session.getAttribute("role");
        }
        out.print("<h3>Sei attualmente loggato come: <loggato-come>" + role + "</loggato-come></h3><br><br>");%>

                <html:form action="login.do" focus="username">
                    <b>Username:</b><br>
                    <html:text name="LoginForm" property='username'/><br>
                    <html:errors property="username"/>
                    <br>
                    <b>Password:</b><br>
                    <html:password name="LoginForm" property='password'/><br>
                    <html:errors property="password"/>
                    <br>
                    <html:submit value="Login"/>
                    <html:reset value="Ripristina"/>
                </html:form>

            </div>
        </center>
    </body>

</html>
