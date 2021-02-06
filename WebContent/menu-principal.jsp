<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu principal</title>
<style type="text/css">
a {
	color:orangered;
	text-decoration:none;
}
a:hover {
	text-decoration:underline;
}
input {
	margin:10px;
}
</style>
</head>
<body>
<c:import url="cabecalho.jsp" />
<!-- recuperando o objeto login armazenado dentro da sessão no arquivo LoginServlet.java -->
 Olá ${sessionScope.login}, Bem-vindo ao Sistema Acadêmico. Clique
<a
 href="mvc?logica=LogoutLogic">aqui</a> para sair!
 <ul>
 <li><a href="adiciona-aluno.jsp">Adicionar novo Aluno
</a></li>
 <li><a href="lista-alunos-elegante.jsp">Listar Alunos </a></li>
<li><a href="adiciona-professor.jsp">Adicionar novo Professor </a></li>
<li><a href="lista-professores-elegante.jsp">Listar Professores
</a></li> </ul><br/><br/>
<c:import url="rodape.jsp" />
</body>
</html>