<%-- 
    Document   : index
    Created on : 11/04/2018, 13:06:13
    Author     : Camila Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="novoPaciente" />
<c:remove scope="session" var="novoMedico" />
<c:remove scope="session" var="novoConsulta" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema médico</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Bem-vindo ao Sistema médico</h1>
        <hr>
         <c:if test="${!empty mensagem}">
            ${mensagem}
            <hr>
        </c:if>
        <p>Escolha o que deseja fazer:</p>
        <a href="Loggin_medico_admin.jsp">Cadastro de médico</a><br/>
        <a href="Loggin_paciente_admin.jsp">Cadastro de pacientes</a><br/><br/>
        <a href="verMedicoServlet">Listagem de todos os médicos</a><br/>
        <a href="escolhaEspecialidade.jsp">Listagem de médicos por especialidade</a><br/>
        <a href="logginConsultaPaciente.jsp">Listagem todas consultas por paciente</a><br/>
        <a href="logginConsultaMedico.jsp">Listagem todos consultas por médico</a><br/><br/>
        <a href="logginPaciente.jsp">Agendamento exame</a><br/>

    </body>
</html>
