package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

import br.com.cesan.importacao.xml.model.to.mensagem.common.EnderecoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoPrestadorExecutanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoProfissionalTO;

public class PrestadorExecutanteTO {
	
	private IdentificacaoPrestadorExecutanteTO identificacao;
	private String nomeContratado;
	private EnderecoTO enderecoContratado;
	private String numeroCNES;
	private IdentificacaoProfissionalTO profissionalExecutanteCompl;
	
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
	public IdentificacaoProfissionalTO getProfissionalExecutanteCompl() {
		return profissionalExecutanteCompl;
	}
	public void setProfissionalExecutanteCompl(
			IdentificacaoProfissionalTO profissionalExecutanteCompl) {
		this.profissionalExecutanteCompl = profissionalExecutanteCompl;
	}

}
