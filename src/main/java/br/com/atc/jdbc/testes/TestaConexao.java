package br.com.atc.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.atc.jdbc.GerarConexao;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new GerarConexao().getConexao();
		System.out.println("Conexão Funcionando!");
		conexao.close();
	}

}
