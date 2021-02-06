package br.edu.ifsudestemg.barbacena.prog3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Conexao;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Usuario;

public class UsuarioDAO {
	Conexao con = new Conexao();
	private final Connection connection;
	public UsuarioDAO() {
		this.connection = getConnection();
	}
    public Connection getConnection(){
        try {
            Class.forName(con.getDriver());
            return DriverManager.getConnection(con.getServidor(),
            		con.getUsuario(),con.getSenha());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }  
    public void consultarLogin(Usuario usuario) {
		String sql = "select * from usuario where login=?;";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			java.sql.ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				usuario.setUsuario(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
