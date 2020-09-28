package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

import br.com.cesan.importacao.xml.model.to.mensagem.common.ConselhoProfissionalTO;

public class IdentificacaoPrestadorEquipeTO {
	
	private String cpf;
	private String codigoPrestadorNaOperadora;
	private ConselhoProfissionalTO conselhoProfissional;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCodigoPrestadorNaOperadora() {
		return codigoPrestadorNaOperadora;
	}
	public void setCodigoPrestadorNaOperadora(String codigoPrestadorNaOperadora) {
		this.codigoPrestadorNaOperadora = codigoPrestadorNaOperadora;
	}
	public ConselhoProfissionalTO getConselhoProfissional() {
		return conselhoProfissional;
	}
	public void setConselhoProfissional(ConselhoProfissionalTO conselhoProfissional) {
		this.conselhoProfissional = conselhoProfissional;
	}

}
