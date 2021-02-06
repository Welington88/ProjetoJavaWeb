package br.edu.barbacena.ifsudestemg.prog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.edu.barbacena.ifsudestemg.prog3.modelo.Aluno;
import br.edu.ifsudestemg.barbacena.prog3.dao.AlunoDAO;

@WebServlet("/adicionaAluno")
public class AdicionaAlunoServlet extends HttpServlet{
	@Override
	public void service(ServletRequest request, 
			ServletResponse response) throws ServletException, IOException {
			PrintWriter saida = response.getWriter();
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String email = request.getParameter("email");
			String dataEmTexto = request.getParameter("dataNascimento");
			Calendar dataNascimento = null;
			try {
				Date data = new 
				SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(data);
			} catch (java.text.ParseException e) {
				saida.println("Erro na convers�o da data");
				return;
			}
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setEmail(email);
			aluno.setEndereco(endereco);
			aluno.setDatanascimento(dataNascimento);
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.adicionar(aluno);
			RequestDispatcher rd = request.getRequestDispatcher("/aluno-adicionado.jsp");
			rd.forward(request,response);
	}
}
