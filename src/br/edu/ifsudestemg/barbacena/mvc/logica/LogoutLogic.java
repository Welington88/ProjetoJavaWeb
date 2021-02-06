package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutLogic implements Logica {
	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		//Recuperando uma sess�o j� existente, sem deixar uma nova ser� criada
	    HttpSession session = req.getSession(false);
	 
	    //Destruindo a sess�o
	    session.invalidate();
	 
	  //Redirecionando o usu�rio para a p�gina de login
	    res.sendRedirect("formulario-login.jsp");
		
	}
}