package br.com.atc.jdbc.modelo;

public class Viagem {
	private Integer id;
	private Integer motoristaId;
	private Integer passageiroId;
	private String inicioViagem;
	private String destinoViagem;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMotoristaId() {
		return motoristaId;
	}
	public void setMotoristaId(Integer motoristaId) {
		this.motoristaId = motoristaId;
	}
	public Integer getPassageiroId() {
		return passageiroId;
	}
	public void setPassageiroId(Integer passageiroId) {
		this.passageiroId = passageiroId;
	}
	public String getInicioViagem() {
		return inicioViagem;
	}
	public void setInicioViagem(String inicioViagem) {
		this.inicioViagem = inicioViagem;
	}
	public String getDestinoViagem() {
		return destinoViagem;
	}
	public void setDestinoViagem(String destinoViagem) {
		this.destinoViagem = destinoViagem;
	}
}
