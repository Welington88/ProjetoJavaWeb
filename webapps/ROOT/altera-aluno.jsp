<%@page import="br.edu.barbacena.ifsudestemg.prog3.modelo.Aluno"%>
<%@page import="br.edu.ifsudestemg.barbacena.prog3.dao.AlunoDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
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
 <h2>Formulário para alteração de alunos:</h2>
 <form action="mvc" method="post">
 Id: <input type="text" name="id" readonly="readonly" value="${param.id}" /><br /><br />
 Nome: <input type="text" name="nome" value="${param.nome}" size="40" /><br /><br />
 E-mail: <input type="text" name="email" value="${param.mail}" size="35" /><br /><br />
 Endereço: <input type="text" name="endereco" value="${param.end}" size="40" /><br /><br />
 Data de Nascimento: <input type="text" name="dataNascimento" value="${param.nasc}" size="40" /><br /><br />
 <input type="hidden" name="logica" value="AlteraAlunoLogic"  />
 <input type="submit" value="Enviar" />
 </form>
 <c:import url="rodape.jsp" />
 </body>
 </html>