package br.com.cesan.importacao.xml.model.to.mensagem.corpo;

public class LoteGuiasTO {
	
	private Long numeroLote;
	private GuiasTO guias;
	
	public Long getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(Long numeroLote) {
		this.numeroLote = numeroLote;
	}
	public GuiasTO getGuias() {
		return guias;
	}
	public void setGuias(GuiasTO guias) {
		this.guias = guias;
	}

}
