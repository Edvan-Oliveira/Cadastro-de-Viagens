package br.com.atc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.atc.jdbc.GerarConexao;
import br.com.atc.jdbc.modelo.Passageiro;

public class PassageiroDao {
	private Connection conexao;
	
	public PassageiroDao() {
		this.conexao = new GerarConexao().getConexao();
	}
	
	public boolean adiciona(Passageiro passageiro) {
		boolean adicionou = false;
		String sql = "INSERT INTO passageiros (nome, sobre_nome, telefone, email, cpf, senha) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, passageiro.getNome());
			stmt.setString(2, passageiro.getSobreNome());
			stmt.setString(3, passageiro.getTelefone());
			stmt.setString(4, passageiro.getEmail());
			stmt.setString(5, passageiro.getCpf());
			stmt.setString(6, passageiro.getSenha());
			
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
	
	public List<Passageiro> getLista(){
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM passageiros ORDER BY nome");
			ResultSet rs = stmt.executeQuery();
			List<Passageiro> passageiros = new ArrayList<Passageiro>();
			
			while(rs.next()) {
				Passageiro passageiro = new Passageiro();
				
				passageiro.setId(rs.getInt("id"));
				passageiro.setNome(rs.getString("nome"));
				passageiro.setSobreNome(rs.getString("sobre_nome"));
				passageiro.setTelefone(rs.getString("telefone"));
				passageiro.setEmail(rs.getString("email"));
				passageiro.setCpf(rs.getString("cpf"));
				passageiro.setSenha(rs.getString("senha"));
				
				passageiros.add(passageiro);
			}
			
			rs.close();
			stmt.close();
			return passageiros;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean altera(Passageiro passageiro) {
		String sql = "UPDATE passageiros SET nome = ?, sobre_nome = ?, telefone = ?, email = ?, cpf = ?, senha = ? WHERE id = ?";
		boolean alterou = false;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, passageiro.getNome());
			stmt.setString(2, passageiro.getSobreNome());
			stmt.setString(3, passageiro.getTelefone());
			stmt.setString(4, passageiro.getEmail());
			stmt.setString(5, passageiro.getCpf());
			stmt.setString(6, passageiro.getSenha());
			stmt.setInt(7, passageiro.getId());
			
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
	
	public boolean remove(Passageiro passageiro) {
		boolean removeu = false;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM passageiros WHERE id = ?");
			
			stmt.setInt(1, passageiro.getId());
			
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
	
	public Passageiro pesquisa(int id) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM passageiros WHERE id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Passageiro passageiro = new Passageiro();
			
			if(rs.next()) {
				passageiro.setId(rs.getInt("id"));
				passageiro.setNome(rs.getString("nome"));
				passageiro.setSobreNome(rs.getString("sobre_nome"));
				passageiro.setTelefone(rs.getString("telefone"));
				passageiro.setEmail(rs.getString("email"));
				passageiro.setCpf(rs.getString("cpf"));
				passageiro.setSenha(rs.getString("senha"));
				
				stmt.close();
			} else {
				passageiro.setId(-1);
				passageiro.setNome("-1");
				passageiro.setSobreNome("-1");
				passageiro.setTelefone("-1");
				passageiro.setEmail("-1");
				passageiro.setCpf("-1");
				passageiro.setSenha("-1");
			}
			return passageiro;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
