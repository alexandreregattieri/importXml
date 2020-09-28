package br.com.cesan.importacao.xml.model.to.mensagem.corpo;

public class PrestadorParaOperadoraTO {
	
	private LoteGuiasTO loteGuias;
	private String loteAnexo;
	
	public LoteGuiasTO getLoteGuias() {
		return loteGuias;
	}
	public void setLoteGuias(LoteGuiasTO loteGuias) {
		this.loteGuias = loteGuias;
	}
	public String getLoteAnexo() {
		return loteAnexo;
	}
	public void setLoteAnexo(String loteAnexo) {
		this.loteAnexo = loteAnexo;
	}

}
