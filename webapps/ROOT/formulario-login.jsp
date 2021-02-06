<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Sistema Acadêmico</title>
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
<c:import url="cabecalho.jsp" ></c:import>
<!--   <form action ="efetuaLogin" method="post"> -->
<form action ="mvc" method="post">
<label for="idlogin">Login:</label> <input type="text" id="idlogin" name="login" /> <br/>
<label for="idsenha">Senha:</label> <input type="password" id="idsenha" name="senha" /> <br />
<input type="hidden" name="logica" value="LoginLogic"  />
<input type="submit" name="Entrar" /> <br />
</form>
<c:import url="rodape.jsp" ></c:import>
</body>
</html>