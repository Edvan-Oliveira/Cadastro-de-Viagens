package br.com.atc.jdbc.testes;

import br.com.atc.jdbc.dao.ViagemDao;
import br.com.atc.jdbc.modelo.Viagem;

public class TestaRemove {

	public static void main(String[] args) {
		Viagem viagem = new Viagem();
		viagem.setId(4);
		
		ViagemDao dao = new ViagemDao();
		boolean resultado = dao.remove(viagem);
		
		if(resultado) {
			System.out.println("Removido com sucesso!");
		} else {
			System.out.println("Erro ao remover.");
		}
	}
}
