<%-- 
    Document   : CadastroMedico
    Created on : 11/04/2018, 13:12:00
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
        <h1>Novo medico</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
            </c:forEach>
            </ul>
            <hr>
        </c:if>


        <form action="NovoMedicoServlet" method="post">
            Digite seus dados:<br/>
            CRM: <input name="CRM" type="text" value="${sessionScope.novoMedico.CRM}" /><br/>
            Nome: <input name="nome" type="text" value="${sessionScope.novoMedico.nome}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.novoMedico.senha}" /><br/>
            Especialidade: <input name="especialidade" type="text" value="${sessionScope.novoMedico.especialidade}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
