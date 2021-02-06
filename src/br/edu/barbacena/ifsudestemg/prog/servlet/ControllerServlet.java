package br.edu.barbacena.ifsudestemg.prog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsudestemg.barbacena.mvc.logica.Logica;
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
 protected void service(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {

 String parametro = request.getParameter("logica");
 String nomeDaClasse = "br.edu.ifsudestemg.barbacena.mvc.logica." + parametro;

	 try {
		 Class classe = Class.forName(nomeDaClasse);
		
		 Logica logica = (Logica) classe.newInstance();
		 logica.executa(request, response);
	
	 } catch (Exception e) {
		 throw new ServletException("A mvc de "
				 + "negecios causou uma erro", e);
	 }
 }
}

