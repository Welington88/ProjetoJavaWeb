package br.edu.barbacena.ifsudestemg.prog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//Recuperando uma sessão já existente, sem deixar uma nova será criada
	    HttpSession session = req.getSession(false);
	 
	    //Destruindo a sessão
	   session.invalidate();
	   
	  //Redirecionando o usuário para a página de login
	  res.sendRedirect("formulario-login.jsp");
	 }
}