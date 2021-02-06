package br.com.upabicasreal.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.upabicasreal.dao.UsuarioDAO;
import br.com.upabicasreal.modelo.Usuario;

@SessionScoped //essa anota��o cria a sess�o de login
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	// getter and setter 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String efetuaLogin(){
		UsuarioDAO dao =  new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			System.out.println("Usuario Logado");
			System.out.println("Usuario => " + usuario.getLogin());
			System.out.println("Senha   => " + usuario.getSenha());
			return "medico?faces-redirect=true";
		}else {
			this.usuario = new Usuario();
			System.out.println("N�o poss�vel Logar");
			System.out.println("Usuario => " + usuario.getLogin());
			System.out.println("Senha   => " + usuario.getSenha());
			return "login";
		}
	}
	public boolean isUsuarioLogado(){
		return this.usuario.getLogin() != null;
	}
	
	public String logout(){
		System.out.println("Usuario Logado");
		System.out.println("Usuario => " + usuario.getLogin());
		System.out.println("Senha   => " + usuario.getSenha());
		this.usuario = new Usuario();
		System.out.println("Logout feito com sucesso!!!");
		return "login?faces-redirect=true";
	}
	}