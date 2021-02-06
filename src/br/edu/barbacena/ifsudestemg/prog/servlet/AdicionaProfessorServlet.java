package br.edu.barbacena.ifsudestemg.prog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Professor;
import br.edu.ifsudestemg.barbacena.prog3.dao.ProfessorDAO;

@WebServlet("/adicionaProfessor")
public class AdicionaProfessorServlet extends HttpServlet{
	@Override
	public void service(ServletRequest request, 
			ServletResponse response) throws ServletException, IOException {
			PrintWriter saida = response.getWriter();
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String grau = request.getParameter("grau");
			
			Professor professor = new Professor();
			professor.setNome(nome);
			professor.setEmail(email);
			professor.setGrau_formacao(grau);
			
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.adicionar(professor);
			
			saida.println("<html>");
			saida.println("<body>");
			saida.println("Contato :" + 
			professor.getNome() + " adicionado com sucesso!");
			saida.println("</body>");
			saida.println("</html>");
	}
}

