package br.com.atc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.atc.jdbc.GerarConexao;
import br.com.atc.jdbc.modelo.Motorista;

public class MotoristaDao {
	private Connection conexao;
	
	public MotoristaDao() {
		this.conexao = new GerarConexao().getConexao();
	}
	
	public boolean adiciona(Motorista motorista) {
		boolean adicionou = false;
		String sql = "INSERT INTO motoristas (nome, sobre_nome, telefone, email, cpf, senha) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getSobreNome());
			stmt.setString(3, motorista.getTelefone());
			stmt.setString(4, motorista.getEmail());
			stmt.setString(5, motorista.getCpf());
			stmt.setString(6, motorista.getSenha());
			
			if(stmt.executeUpdate() > 0) {
				adicionou = true;
			} else {
				adicionou = false;
			}
			
			stmt.close();
			return adicionou;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Motorista> getLista(){
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM motoristas ORDER BY nome");
			ResultSet rs = stmt.executeQuery();
			List<Motorista> motoristas = new ArrayList<Motorista>();
			
			while(rs.next()) {
				Motorista motorista = new Motorista();
				
				motorista.setId(rs.getInt("id"));
				motorista.setNome(rs.getString("nome"));
				motorista.setSobreNome(rs.getString("sobre_nome"));
				motorista.setTelefone(rs.getString("telefone"));
				motorista.setEmail(rs.getString("email"));
				motorista.setCpf(rs.getString("cpf"));
				motorista.setSenha(rs.getString("senha"));
				
				motoristas.add(motorista);
			}
			
			rs.close();
			stmt.close();
			return motoristas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean altera(Motorista motorista) {
		String sql = "UPDATE motoristas SET nome = ?, sobre_nome = ?, telefone = ?, email = ?, cpf = ?, senha = ? WHERE id = ?";
		boolean alterou = false;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getSobreNome());
			stmt.setString(3, motorista.getTelefone());
			stmt.setString(4, motorista.getEmail());
			stmt.setString(5, motorista.getCpf());
			stmt.setString(6, motorista.getSenha());
			stmt.setInt(7, motorista.getId());
			
			if(stmt.executeUpdate() > 0) {
				alterou = true;
			} else {
				alterou = false;
			}
			
			stmt.close();
			return alterou;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean remove(Motorista motorista) {
		boolean removeu = false;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM motoristas WHERE id = ?");
			
			stmt.setInt(1, motorista.getId());
			
			if(stmt.executeUpdate() > 0) {
				removeu = true;
			} else {
				removeu = false;
			}
			
			stmt.close();
			return removeu;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Motorista pesquisa(int id) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM motoristas WHERE id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Motorista motorista = new Motorista();
			
			if(rs.next()) {
				motorista.setId(rs.getInt("id"));
				motorista.setNome(rs.getString("nome"));
				motorista.setSobreNome(rs.getString("sobre_nome"));
				motorista.setTelefone(rs.getString("telefone"));
				motorista.setEmail(rs.getString("email"));
				motorista.setCpf(rs.getString("cpf"));
				motorista.setSenha(rs.getString("senha"));
			
				stmt.close();
			} else {
				motorista.setId(-1);
				motorista.setNome("-1");
				motorista.setSobreNome("-1");
				motorista.setTelefone("-1");
				motorista.setEmail("-1");
				motorista.setCpf("-1");
				motorista.setSenha("-1");
			}
			return motorista;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
 