<%-- 
    Document   : ConfirmarCadastroPaciente
    Created on : 12/04/2018, 08:42:15
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
        <h1>Novo Cadastro de Agendamento</h1>
        Dados aceitos, deseja continuar?
        <br/>
        Confira antes de enviar os dados:
        <br/><br/>
        CPF: ${sessionScope.novoConsulta.CPF}<br/>
        CRM: ${sessionScope.novoConsulta.CRM}<br/>
        Data do Exame: ${sessionScope.novoConsulta.dataExame}<br/>
        <br/>
        <a href="GravarConsultaServlet">Confirmar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
