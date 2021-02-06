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
		//Recuperando uma sess�o j� existente, sem deixar uma nova ser� criada
	    HttpSession session = req.getSession(false);
	 
	    //Destruindo a sess�o
	   session.invalidate();
	   
	  //Redirecionando o usu�rio para a p�gina de login
	  res.sendRedirect("formulario-login.jsp");
	 }
}