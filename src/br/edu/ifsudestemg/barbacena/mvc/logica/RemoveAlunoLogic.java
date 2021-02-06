package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.prog3.modelo.Aluno;
import br.edu.ifsudestemg.barbacena.prog3.dao.AlunoDAO;

public class RemoveAlunoLogic implements Logica{
 public void executa(HttpServletRequest request, HttpServletResponse
response)
 throws Exception {

	 Aluno aluno = new Aluno();
	 long id = Long.parseLong(request.getParameter("id"));
	 aluno.setId(id);
	 
	AlunoDAO dao = new AlunoDAO();
	dao.remove(aluno);
	
	RequestDispatcher rd = request
	    .getRequestDispatcher("/lista-alunos-elegante.jsp");
	 	rd.forward(request, response);
	 	System.out.println("Deletando aluno ..." + aluno.getNome());
 }
}