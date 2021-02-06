<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bem Vindo</title>
</head>
<body>
<%-- comentário em JSP aqui: nossa primeira página JSP --%>
<% String mensagem = "Bem-vindo ao sistema de gestão acadêmica!"; %>
<% out.println(mensagem); %><br />
<% String desenvolvido = "Desenvolvido por Welington"; %>
<%=desenvolvido%><br />
<%System.out.println("Tudo foi executado!"); %>
</body>
</html>