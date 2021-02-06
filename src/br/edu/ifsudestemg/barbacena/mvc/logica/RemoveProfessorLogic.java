package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Professor;
import br.edu.ifsudestemg.barbacena.prog3.dao.ProfessorDAO;

public class RemoveProfessorLogic implements Logica{
 public void executa(HttpServletRequest request, HttpServletResponse
response)
 throws Exception {

	 Professor professor = new Professor();
	 long id = Long.parseLong(request.getParameter("id"));
	 professor.setId(id);
	 
	ProfessorDAO dao = new ProfessorDAO();
	dao.remove(professor);
	
	RequestDispatcher rd = request
	    .getRequestDispatcher("/lista-professores-elegante.jsp");
	 	rd.forward(request, response);
	 	System.out.println("Deletando aluno ..." + professor.getNome());
 }
}