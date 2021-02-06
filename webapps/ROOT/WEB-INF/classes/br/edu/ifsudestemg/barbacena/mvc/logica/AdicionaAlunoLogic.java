package br.edu.ifsudestemg.barbacena.mvc.logica;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Aluno;
import br.edu.ifsudestemg.barbacena.prog3.dao.AlunoDAO;

public class AdicionaAlunoLogic implements Logica{
 public void executa(HttpServletRequest request, HttpServletResponse
response)
 throws Exception {

	 Aluno aluno = new Aluno();
	 aluno.setNome(request.getParameter("nome"));
	 aluno.setEndereco(request.getParameter("endereco"));
	 aluno.setEmail(request.getParameter("email"));
	
	 // Converte a data de String para Calendar
	 String dataEmTexto = request.getParameter("dataNascimento");
	 Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
	 Calendar dataNascimento = Calendar.getInstance();
	 dataNascimento.setTime(date);
	 aluno.setDatanascimento(dataNascimento);
	 AlunoDAO dao = new AlunoDAO();
	 dao.adicionar(aluno);
	 RequestDispatcher rd = request
	    .getRequestDispatcher("/aluno-adicionado.jsp");
	 	rd.forward(request, response);
	 	System.out.println("Adicionando aluno ..." + aluno.getNome());
 }
}