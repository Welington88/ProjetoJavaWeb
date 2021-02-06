package br.edu.ifsudestemg.barbacena.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.barbacena.ifsudestemg.prog3.modelo.Usuario;
import br.edu.ifsudestemg.barbacena.prog3.dao.UsuarioDAO;

public class LoginLogic implements Logica {
	@Override
	public void executa(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		 //Recuperando os dados do formul�rio-login
		 String login = req.getParameter("login");
		 String senha = req.getParameter("senha");

		 //String para definirmos a p�gina para onde o usu�rio separa
		 //redirecionado
		 String url;
		 //Comparando se os dados do login s�o iguais aos dados de login
		 // do sistema
		 Usuario usuario = new Usuario();
		 UsuarioDAO dao = new UsuarioDAO();
		 usuario.setUsuario(login);
		 dao.consultarLogin(usuario);
		 if (login.equals(usuario.getUsuario()) && 
			 senha.equals(usuario.getSenha())){

			 //Recuperando uma nova sess�o
			 HttpSession session = req.getSession();
	
			 //Defindo o tempo de sess�o para 3 minutos (180 segundos)
			 session.setMaxInactiveInterval(3*60);
			 
			//Armazenando o status de usu�rio logado como verdadeiro
			 //na sess�o
			 session.setAttribute("usuarioLogado", true);
	
			 //Armazenando o nome do usu�rio logado na sess�o
			 session.setAttribute("login", login);
	
			 //Definindo string para onde o usu�rio ser� redirecionado
			 url = "menu-principal.jsp";

		 }else {
			 url="formulario-login.jsp";
		 }
		 //Realizando o redirecionamento do usu�rio
		 res.sendRedirect(url);
	}
}