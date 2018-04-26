<%-- 
    Document   : cadastroPacienteForm
    Created on : 12/04/2018, 08:11:34
    Author     : Camila Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Medico</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Novo paciente</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
            </c:forEach>
            </ul>
            <hr>
        </c:if>

        <form action="NovoPacienteServlet" method="post">
            Digite seus dados:<br/>
            CPF: <input name="CPF" type="text" value="${sessionScope.novoPaciente.CPF}" /><br/>
            Nome: <input name="nome" type="text" value="${sessionScope.novoPaciente.nome}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.novoPaciente.senha}" /><br/>
            Telefone: <input name="telefone" type="text" value="${sessionScope.novoPaciente.telefone}" /><br/>
            Sexo: <input name="sexo" type="text" value="${sessionScope.novoPaciente.sexo}" /><br/>
            Data de nascimento: <input name="dataDeNascimento" type="text" value="${sessionScope.novoPaciente.dataDeNascimento}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
