package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias;

import br.com.cesan.importacao.xml.model.to.mensagem.cabecalho.IdentificacaoTransacaoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.cabecalho.OrigemTO;

public class CabecalhoTransacaoTO {
	
	private IdentificacaoTransacaoTO identificacaoTransacao;
	private OrigemTO origem;
	private OrigemTO destino;
	private String versaoPadrao;
	
	public IdentificacaoTransacaoTO getIdentificacaoTransacao() {
		return identificacaoTransacao;
	}
	public void setIdentificacaoTransacao(IdentificacaoTransacaoTO identificacaoTransacao) {
		this.identificacaoTransacao = identificacaoTransacao;
	}
	public OrigemTO getOrigem() {
		return origem;
	}
	public void setOrigem(OrigemTO origem) {
		this.origem = origem;
	}
	public OrigemTO getDestino() {
		return destino;
	}
	public void setDestino(OrigemTO destino) {
		this.destino = destino;
	}
	public String getVersaoPadrao() {
		return versaoPadrao;
	}
	public void setVersaoPadrao(String versaoPadrao) {
		this.versaoPadrao = versaoPadrao;
	}

}
