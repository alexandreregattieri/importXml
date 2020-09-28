package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta;

import br.com.cesan.importacao.xml.model.to.mensagem.common.EnderecoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoPrestadorExecutanteTO;

public class ContratadoTO {
	
	private IdentificacaoPrestadorExecutanteTO identificacao;
	private String nomeContratado;
	private EnderecoTO enderecoContratado;
	private String numeroCNES;
	
	public IdentificacaoPrestadorExecutanteTO getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(IdentificacaoPrestadorExecutanteTO identificacao) {
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
