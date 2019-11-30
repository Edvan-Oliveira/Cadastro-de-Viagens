package br.com.atc.jdbc.testes;

import br.com.atc.jdbc.dao.ViagemDao;
import br.com.atc.jdbc.modelo.Viagem;

public class TestaInserir {

	public static void main(String[] args) {
		Viagem viagem = new Viagem();
		
		viagem.setMotoristaId(1);
		viagem.setPassageiroId(1);
		viagem.setInicioViagem("Rua ABC");
		viagem.setDestinoViagem("RUA BCA");

		ViagemDao dao = new ViagemDao();
		boolean resultado = dao.adiciona(viagem);
		
		if(resultado) {
			System.out.println("Viagem de " + viagem.getInicioViagem() + " até " + viagem.getDestinoViagem());
		} else {
			System.out.println("Erro no cadastro.");
		}
	}

}
