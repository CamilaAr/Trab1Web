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
        <h1>Novo Cadastro de Paciente</h1>
        Atenção! Os dados estão corretos?
        <br/>
        Confira antes de enviar os dados:
        <br/><br/>
        CPF: ${sessionScope.novoPaciente.CPF}<br/>
        Nome: ${sessionScope.novoPaciente.nome}<br/>
        Senha: ${sessionScope.novoPaciente.senha}<br/>
        Telefone: ${sessionScope.novoPaciente.telefone}<br/>
        Sexo: ${sessionScope.novoPaciente.sexo}<br/>
        Data de Nascimento: ${sessionScope.novoPaciente.dataDeNascimento}<br/>
        <br/>
        <a href="GravarPacienteServlet">Confirmar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
