<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Professor</title>
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
			Nome: <input type="text" name="nome"  /><br/><br/>
			E-mail: <input type="text" name="email"  /><br/><br/>
			Grau: <input type="text" name="grau"  /><br/><br/>
			<input type="hidden" name="logica" value="AdicionaProfessorLogic"  />
			<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" ></c:import>
</body>
</html>