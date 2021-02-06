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
 <h4><a href="lista-professores-elegante.jsp" >Voltar</a></h4>
 <h2>Formulário para alteração de Professores:</h2>
 <form action="mvc" method="post">
 Id: <input type="text" name="id" readonly="readonly" value="${param.id}" /><br /><br />
 Nome: <input type="text" name="nome" value="${param.nome}" size="40" /><br /><br />
 E-mail: <input type="text" name="email" value="${param.mail}" size="35" /><br /><br />
 Grau: <input type="text" name="grau" value="${param.grau}" size="40" /><br /><br />
 <input type="hidden" name="logica" value="AlteraProfessorLogic"  />
 <input type="submit" value="Enviar" />
 </form>
 <c:import url="rodape.jsp" />
 </body>
 </html>