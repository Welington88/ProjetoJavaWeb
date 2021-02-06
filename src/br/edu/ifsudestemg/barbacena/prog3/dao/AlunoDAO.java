package br.edu.ifsudestemg.barbacena.prog3.dao;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Aluno;
import br.edu.barbacena.ifsudestemg.prog3.modelo.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlunoDAO {
	Conexao con = new Conexao();
    private final Connection connection;
    
    public AlunoDAO() {
    	this.connection = getConnection();
    }
    
    public Connection getConnection(){
        try {//conexao
        	Class.forName(con.getDriver());
            return DriverManager.getConnection(con.getServidor(),
            		con.getUsuario(),con.getSenha());//fim
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void adicionar(Aluno aluno) {
		String sql = "insert into alunos (nome , email, endereco, datanascimento)" + "	values (?,?,?,?);";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getEndereco());
			stmt.setDate(4, new Date(aluno.getDatanascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
	public void altera(Aluno aluno) {
		String sql = "update alunos set nome=?, email=?," + "endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getEndereco());
			stmt.setDate(4, new Date(aluno.getDatanascimento().getTimeInMillis()));
			stmt.setLong(5, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Aluno aluno) {
		String sql = "delete from alunos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Aluno> getLista() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			String sql = "select * from alunos";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			java.sql.ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDatanascimento(data);
				alunos.add(aluno);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        return alunos;
	}
}


