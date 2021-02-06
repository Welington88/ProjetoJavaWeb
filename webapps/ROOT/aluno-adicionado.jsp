<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Professor</title>
<style type="text/css">
a {
	color:orangered;
	text-decoration:none;
}
a:hover {
	text-decoration:underline;
}
</style>
</head>
<body>
<c:import url="cabecalho.jsp" />
<h4><a href="lista-alunos-elegante.jsp" >Voltar</a></h4>
	Aluno <b> ${param.nome} </b> adicionado com sucesso <br/><br/>
<c:import url="rodape.jsp" />
</body>
</html>