package br.com.atc.jdbc.testes;

import br.com.atc.jdbc.dao.ViagemDao;
import br.com.atc.jdbc.modelo.Viagem;

public class TestaPesquisa {

	public static void main(String[] args) {
		Viagem viagem = new ViagemDao().pesquisa(11);
		
		System.out.println("id: " + viagem.getId());
		System.out.println("motorista_id: " + viagem.getMotoristaId());
		System.out.println("passageiro_id: " + viagem.getPassageiroId());
		System.out.println("inicio_viagem: " + viagem.getInicioViagem());
		System.out.println("destino_viagem: " + viagem.getDestinoViagem());

	}
}
