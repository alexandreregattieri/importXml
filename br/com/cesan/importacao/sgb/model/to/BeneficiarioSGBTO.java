package br.com.cesan.importacao.sgb.model.to;

public class BeneficiarioSGBTO {
	
	private Long plano;
	private String numtiu;
	private String coddpd;
	private String indtiptiu;
	private Double participacao;
	private String sexo;
	private Long idade;
	
	public Long getPlano() {
		return plano;
	}
	public void setPlano(Long plano) {
		this.plano = plano;
	}
	public String getNumtiu() {
		return numtiu;
	}
	public void setNumtiu(String numtiu) {
		this.numtiu = numtiu;
	}
	public String getCoddpd() {
		return coddpd;
	}
	public void setCoddpd(String coddpd) {
		this.coddpd = coddpd;
	}
	public String getIndtiptiu() {
		return indtiptiu;
	}
	public void setIndtiptiu(String indtiptiu) {
		this.indtiptiu = indtiptiu;
	}
	public Double getParticipacao() {
		return participacao;
	}
	public void setParticipacao(Double participacao) {
		this.participacao = participacao;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getIdade() {
		return idade;
	}
	public void setIdade(Long idade) {
		this.idade = idade;
	}

}
