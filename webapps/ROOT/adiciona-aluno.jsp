<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Adiciona Aluno</title>
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
<c:import url="cabecalho.jsp" ></c:import>
<h3><a href="menu-principal.jsp" >Voltar</a></h3>
	<form action="mvc" method="post">
		Nome: <input type="text" name="nome"></input><br/><br/>
		E-mail: <input type="email" name="email" /><br/><br/>
		Endereco: <input type="text" name="endereco" /><br/><br/>
		Data Nascimento: <input type="text" name="dataNascimento" /><br/><br/>
		<input type="hidden" name="logica" value="AdicionaAlunoLogic"  />
		<input type="submit" value="Gravar" >
	</form>
<c:import url="rodape.jsp" ></c:import>
</body>
</html>