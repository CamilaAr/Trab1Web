<%-- 
    Document   : escolhaEspecialidade
    Created on : 19/04/2018, 08:35:55
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
        <h1>Listar médicos por especialidade</h1>
        
        <br/>
        Confira antes de enviar os dados:
        <br/><br/>
        
        <form action="verConsultaServlet">
            CPF: <input name="CPF" type="text" value="" /><br/>
            <input type ="submit" value="enviar"/>
            </form>
            <br/>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>