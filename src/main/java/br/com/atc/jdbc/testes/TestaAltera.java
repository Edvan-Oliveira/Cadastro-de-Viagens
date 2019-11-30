package br.com.atc.jdbc.testes;

import br.com.atc.jdbc.dao.ViagemDao;
import br.com.atc.jdbc.modelo.Viagem;

public class TestaAltera {

	public static void main(String[] args) {
		Viagem viagem = new Viagem();
		
		viagem.setId(11);
		viagem.setMotoristaId(1);
		viagem.setPassageiroId(1);
		viagem.setInicioViagem("Rua ABC");
		viagem.setDestinoViagem("Rua BBB");

		
		ViagemDao dao = new ViagemDao();
		boolean resultado = dao.altera(viagem);
		
		if(resultado) {
			System.out.println("Dados alterados com sucesso!");
		} else {
			System.out.println("Erro ao alterar.");
		}
	}
}
