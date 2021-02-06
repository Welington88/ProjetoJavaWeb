package br.edu.ifsudestemg.barbacena.prog3.dao;

import br.edu.barbacena.ifsudestemg.prog3.modelo.Professor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProfessorDAO {
    private final Connection connection;
    
    public ProfessorDAO() {
        this.connection = getConnection();
    }
    
    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost/prog3",
                     "postgres","123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void adicionar(Professor professor) {
            String sql = "insert into professores (nome , email, grau)" + " values (?,?,?);";
            try {
                    PreparedStatement stmt = this.connection.prepareStatement(sql);
                    stmt.setString(1, professor.getNome());
                    stmt.setString(2, professor.getEmail());
                    stmt.setString(3, professor.getGrau_formacao());
                    stmt.execute();
                    stmt.close();
            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }
	}

	public void altera(Professor professor) {
		String sql = "update professores set nome=?, email=?, grau=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getGrau_formacao());
			stmt.setLong(4, professor.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Professor professor) {
		String sql = "delete from professores where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, professor.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Professor> getContatos() {
		List<Professor> professores = new ArrayList<Professor>();
		try {
			String sql = "select * from professores";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			java.sql.ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getLong("id"));
				professor.setNome(rs.getString("nome"));
                                professor.setEmail(rs.getString("email"));
				professor.setGrau_formacao(rs.getString("grau"));
				professores.add(professor);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
                    return professores;
	}
}
