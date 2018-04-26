<%-- 
    Document   : confirmarCadastroMedico
    Created on : 12/04/2018, 08:32:31
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
        <h1>Novo Cadastro de Médico</h1>
        Atenção! Os dados estão corretos?
        <br/>
        Confira antes de enviar os dados:
        <br/><br/>
        CRM: ${sessionScope.novoMedico.CRM}<br/>
        Nome: ${sessionScope.novoMedico.nome}<br/>
        Senha: ${sessionScope.novoMedico.senha}<br/>
        Especialidade: ${sessionScope.novoMedico.especialidade}<br/>
        <br/>
        <a href="GravarMedicoServlet">Confirmar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>

