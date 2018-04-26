
<%-- 
    Document   : Loggin
    Created on : 11/04/2018, 13:50:57
    Author     : Camila Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Médico</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Autenticação</h1>
        <hr>


        <form action="verPacienteServlet" method="post">
            <br/>
            CPF: <input name="CPF" type="text" value="${sessionScope.novoConsulta.CPF}" /><br/>
            Senha: <input name="senha" type="password" value="" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>