<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>Lista de Alunos</title>
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
<h4><a href="menu-principal.jsp" >Voltar</a></h4>
<h3><a href="adiciona-aluno.jsp" > Adicionar Aluno</a></h3>
	<jsp:useBean id="dao" 
		class="br.edu.ifsudestemg.barbacena.prog3.dao.AlunoDAO">
		<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data Nascimento</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		
		<c:forEach var="aluno" items="${dao.lista}" varStatus="id" >
			<tr bgcolor="#${id.count % 2 ==0 ? 'aaee88' : 'dddddd'}">
			<td>${aluno.nome}</td>
			<td>
			<c:if test="${not empty aluno.email}">
			<a href="mailto:${aluno.email}"> ${aluno.email} </a>
			</c:if>
			<c:if test="${empty aluno.email}">
			<a href="mailto:${aluno.email}">E-mail não Informado</a>
			</c:if>
			</td>
			<td>${aluno.endereco}</td>
			<td> 
			  <fmt:formatDate value="${aluno.datanascimento.time}" pattern="dd/MM/yyyy"  />  
			 </td>
			 <td>
			 	 <% out.println("<a href='altera-aluno.jsp?id="); %>${aluno.id}
			 	 <% out.println("&nome=");%>${aluno.nome}
			 	 <% out.println("&mail="); %>${aluno.email}
			 	 <% out.println("&end="); %>${aluno.endereco}
			 	 <% out.println("&nasc="); %><fmt:formatDate value="${aluno.datanascimento.time}" pattern="dd/MM/yyyy"  />
			 	 <% out.println("'>Alterar</a>"); %>
			 </td>
			 <td>
			 	<a href="mvc?id=${aluno.id}&logica=RemoveAlunoLogic"> 
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