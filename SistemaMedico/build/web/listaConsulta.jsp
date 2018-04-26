<%-- 
    Document   : ListagemConsultaMedico
    Created on : 11/04/2018, 13:46:34
    Author     : Camila Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Consultas por Paciente</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Consultas por paciente</h1>
        <hr>
        <c:if test="${empty requestScope.listaConsulta}">
            Não há consultas!
        </c:if>
        <c:if test="${!empty requestScope.listaConsulta}">
            <table>
                <tr>
                    <th class="esquerda">Consulta</th>
                    <th>CPF</th>
                    <th>CRM</th>
                    <th>Data do Exame</th>
                </tr>
                <c:forEach items="${requestScope.listaConsulta}" var="consulta">
                    <tr>
                        <td class="esquerda">${consulta.CPF}</td>
                        <td>${consulta.CPF}</td>
                        <td>${consulta.CRM}</td>
                        <td>${consulta.dataExame}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
