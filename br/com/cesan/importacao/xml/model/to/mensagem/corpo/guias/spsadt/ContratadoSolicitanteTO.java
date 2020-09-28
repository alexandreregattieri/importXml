package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

import br.com.cesan.importacao.xml.model.to.mensagem.common.EnderecoTO;

public class ContratadoSolicitanteTO {
	
	private IdentificacaoPrestadorTO identificacao;
	private String nomeContratado;
	private EnderecoTO enderecoContratado;
	private String numeroCNES;
	
	public IdentificacaoPrestadorTO getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(IdentificacaoPrestadorTO identificacao) {
		this.identificacao = identificacao;
	}
	public String getNomeContratado() {
		return nomeContratado;
	}
	public void setNomeContratado(String nomeContratado) {
		this.nomeContratado = nomeContratado;
	}
	public EnderecoTO getEnderecoContratado() {
		return enderecoContratado;
	}
	public void setEnderecoContratado(EnderecoTO enderecoContratado) {
		this.enderecoContratado = enderecoContratado;
	}
	public String getNumeroCNES() {
		return numeroCNES;
	}
	public void setNumeroCNES(String numeroCNES) {
		this.numeroCNES = numeroCNES;
	}

}
