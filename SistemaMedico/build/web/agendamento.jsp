<%-- 
    Document   : agendamento
    Created on : 12/04/2018, 08:12:12
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
        <h1>Agendamento</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
            </c:forEach>
            </ul>


        <form action="NovaConsultaServlet" method="post">
            Digite os dados:<br/>
            CRM:<input name="CRM" type="text" value="${sessionScope.novoConsulta.CRM}" /><br/>
            CPF:<input name="CPF" type="text" value="${sessionScope.novoConsulta.CPF}" /><br/>
            Data: <input name="dataExame" type="text" value="${sessionScope.novoConsulta.dataExame}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>