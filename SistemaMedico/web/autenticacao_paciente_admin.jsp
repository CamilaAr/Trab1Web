<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String usuario = request.getParameter("login");
String senha = request.getParameter("senha");
if(usuario.equals("admin") && senha.equals("admin")) {
%>
<jsp:forward page="cadastroPacienteForm.jsp"></jsp:forward>
<% }
else { %>
<jsp:forward page="index.jsp" />
<% } %>
