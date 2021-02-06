<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="br.edu.ifsudestemg.barbacena.prog3.dao.*"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.barbacena.ifsudestemg.prog3.modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@include file="autenticacao.jsp" %>
<html>
<head>
<title>Lista de Professor</title>
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
<h3><a href="adiciona-professor.jsp" > Adicionar Professor</a></h3>
	<jsp:useBean id="dao" 
		class="br.edu.ifsudestemg.barbacena.prog3.dao.ProfessorDAO">
		<table>
		<tr>
			<th>Nome </th>
			<th>E-mail</th>
			<th>Grau</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach var="professor" items="${dao.lista}" varStatus="id" >
			<tr bgcolor="#${id.count % 2 ==0 ? 'aaee88' : 'dddddd'}">
			<td>${professor.nome}</td>
			<td>
			<c:if test="${not empty professor.email}">
			<a href="mailto:${professor.email}"> ${professor.email} </a>
			</c:if>
			<c:if test="${empty professor.email}">
			<a href="mailto:${professor.email}">E-mail não Informado</a>
			</c:if>
			</td>
			<td>${professor.grau_formacao}</td>
			<td>
				<a href="altera-professor.jsp?id=${professor.id}&nome=${professor.nome}&mail=${professor.grau_formacao}&grau=${professor.grau_formacao}">
					Alterar
				</a>
			</td>
			 <td>
			 	<a href="mvc?id=${professor.id}&logica=RemoveProfessorLogic"> 
			 		Remover 
			 	</a>
			 </td>
			</tr>
		</c:forEach>
	</table>
</jsp:useBean>
<c:import url="rodape.jsp" ></c:import>
</body>
</html>