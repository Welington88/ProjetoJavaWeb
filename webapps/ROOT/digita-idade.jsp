<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lista De Professores</title>
</head>
<body>
Digite sua idade e pressione o botão: <br/>
<form action="mostra-idade.jsp">
	Idade: 
<input type="text" name="idade"/>
<input type="submit"/>
</form>
</body>
</html>