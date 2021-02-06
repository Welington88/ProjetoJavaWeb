package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.barbacena.ifsudestemg.prog3.modelo.Professor;
import br.edu.ifsudestemg.barbacena.prog3.dao.ProfessorDAO;

public class AdicionaProfessorLogic implements Logica{
 public void executa(HttpServletRequest request, HttpServletResponse
response)
 throws Exception {

 Professor professor = new Professor();
 //long id = Long.parseLong(request.getParameter("id"));aluno.setId(id);
 professor.setNome(request.getParameter("nome"));
 professor.setEmail(request.getParameter("email"));
 professor.setGrau_formacao(request.getParameter("grau"));

 ProfessorDAO dao = new ProfessorDAO();
dao.adicionar(professor);
 RequestDispatcher rd = request
    .getRequestDispatcher("/lista-professores-elegante.jsp");
 	rd.forward(request, response);
 	System.out.println("Adicionando aluno ..." + professor.getNome());
 }
}