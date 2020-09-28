package br.com.cesan.importacao.xml.model.to.mensagem.common;

public class IdentificacaoPrestadorExecutanteTO {

	private String cnpj;
	private String cpf;
	private String codigoPrestadorNaOperadora;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
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
	
}
