package br.com.atc.jdbc.testes;

import java.util.List;

import br.com.atc.jdbc.dao.ViagemDao;
import br.com.atc.jdbc.modelo.Viagem;

public class TestaLista {

	public static void main(String[] args) {
		List<Viagem> viagens = new ViagemDao().getLista();
		
		for(Viagem viagem: viagens) {
			System.out.println("id: " + viagem.getId());
			System.out.println("motorista_id: " + viagem.getMotoristaId());
			System.out.println("passageiro_id: " + viagem.getPassageiroId());
			System.out.println("inicio_viagem: " + viagem.getInicioViagem());
			System.out.println("destino_viagem: " + viagem.getDestinoViagem());
			System.out.println("-----------------------------------\n");
		}
	}

}
