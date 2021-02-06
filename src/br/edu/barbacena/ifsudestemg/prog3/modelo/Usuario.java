package br.edu.barbacena.ifsudestemg.prog3.modelo;
public class Usuario {
	String usuario,senha;
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String senha) {
		this.usuario=usuario;
		this.senha=senha;
	}
	
	public String getSenha() {
		return senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
