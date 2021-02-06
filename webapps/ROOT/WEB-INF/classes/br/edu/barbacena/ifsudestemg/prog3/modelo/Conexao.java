package br.edu.barbacena.ifsudestemg.prog3.modelo;

public final class Conexao {
	final String servidor = "jdbc:mysql://localhost:3306/escola";
	final String usuario = "root";
	final String senha = "";
	final String driver = "com.mysql.jdbc.Driver";
	
	public Conexao() {
		// TODO Auto-generated constructor stub
	}
	
	public final String getServidor() {
		return servidor;
	}
	public final String getUsuario() {
		return usuario;
	}
	public final String getSenha() {
		return senha;
	}
	public final String getDriver() {
		return driver;
	}
	
}