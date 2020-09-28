package br.com.cesan.importacao.xml.model.to.mensagem;

import br.com.cesan.importacao.xml.model.to.mensagem.corpo.PrestadorParaOperadoraTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.CabecalhoTransacaoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.EpilogoTO;

public class MensagemTO {
	
	private CabecalhoTransacaoTO cabecalho;
	private PrestadorParaOperadoraTO corpo;
	private EpilogoTO epilogo;
	
	public CabecalhoTransacaoTO getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(CabecalhoTransacaoTO cabecalho) {
		this.cabecalho = cabecalho;
	}
	public PrestadorParaOperadoraTO getCorpo() {
		return corpo;
	}
	public void setCorpo(PrestadorParaOperadoraTO corpo) {
		this.corpo = corpo;
	}
	public EpilogoTO getEpilogo() {
		return epilogo;
	}
	public void setEpilogo(EpilogoTO epilogo) {
		this.epilogo = epilogo;
	}

}
