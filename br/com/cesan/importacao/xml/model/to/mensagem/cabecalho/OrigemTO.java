package br.com.cesan.importacao.xml.model.to.mensagem.cabecalho;

import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoPrestadorExecutanteTO;

public class OrigemTO {
	
	private IdentificacaoPrestadorExecutanteTO codigoPrestadorNaOperadora;
	private String registroANS;
	private String cnpjpagador;
	
	public IdentificacaoPrestadorExecutanteTO getCodigoPrestadorNaOperadora() {
		return codigoPrestadorNaOperadora;
	}
	public void setCodigoPrestadorNaOperadora(IdentificacaoPrestadorExecutanteTO codigoPrestadorNaOperadora) {
		this.codigoPrestadorNaOperadora = codigoPrestadorNaOperadora;
	}
	public String getRegistroANS() {
		return registroANS;
	}
	public void setRegistroANS(String registroANS) {
		this.registroANS = registroANS;
	}
	public String getCnpjpagador() {
		return cnpjpagador;
	}
	public void setCnpjpagador(String cnpjpagador) {
		this.cnpjpagador = cnpjpagador;
	}

}
