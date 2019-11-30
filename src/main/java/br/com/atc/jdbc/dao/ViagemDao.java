package br.com.atc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.atc.jdbc.GerarConexao;
import br.com.atc.jdbc.modelo.Viagem;

public class ViagemDao {
	private Connection conexao;
	
	public ViagemDao() {
		this.conexao = new GerarConexao().getConexao();
	}
	
	public boolean adiciona(Viagem viagem) {
		boolean adicionou = false;
		String sql = "INSERT INTO viagens (motorista_id, passageiro_id, inicio_viagem, destino_viagem) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setInt(1, viagem.getMotoristaId());
			stmt.setInt(2, viagem.getPassageiroId());
			stmt.setString(3, viagem.getInicioViagem());
			stmt.setString(4, viagem.getDestinoViagem());
			
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
	
	public List<Viagem> getLista(){
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM viagens ORDER BY id");
			ResultSet rs = stmt.executeQuery();
			List<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()) {
				Viagem viagem = new Viagem();
				
				viagem.setId(rs.getInt("id"));
				viagem.setMotoristaId(rs.getInt("motorista_id"));
				viagem.setPassageiroId(rs.getInt("passageiro_id"));
				viagem.setInicioViagem(rs.getString("inicio_viagem"));
				viagem.setDestinoViagem(rs.getString("destino_viagem"));
				
				viagens.add(viagem);
			}
			
			rs.close();
			stmt.close();
			return viagens;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean altera(Viagem viagem) {
		String sql = "UPDATE viagens SET motorista_id = ?, passageiro_id = ?, inicio_viagem = ?, destino_viagem = ? WHERE id = ?";
		boolean alterou = false;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setInt(1, viagem.getMotoristaId());
			stmt.setInt(2, viagem.getPassageiroId());
			stmt.setString(3, viagem.getInicioViagem());
			stmt.setString(4, viagem.getDestinoViagem());
			stmt.setInt(5, viagem.getId());

			
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
	
	public boolean remove(Viagem viagem) {
		boolean removeu = false;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM viagens WHERE id = ?");
			
			stmt.setInt(1, viagem.getId());
			
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
	
	public Viagem pesquisa(int id) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM viagens WHERE id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Viagem viagem = new Viagem();
			
			if(rs.next()) {
				viagem.setId(rs.getInt("id"));
				viagem.setMotoristaId(rs.getInt("motorista_id"));
				viagem.setPassageiroId(rs.getInt("passageiro_id"));
				viagem.setInicioViagem(rs.getString("inicio_viagem"));
				viagem.setDestinoViagem(rs.getString("destino_viagem"));
				
				stmt.close();
			} else {
				viagem.setId(-1);
				viagem.setMotoristaId(-1);
				viagem.setPassageiroId(-1);
				viagem.setInicioViagem("-1");
				viagem.setDestinoViagem("-1");
			}
			
			return viagem;
				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
