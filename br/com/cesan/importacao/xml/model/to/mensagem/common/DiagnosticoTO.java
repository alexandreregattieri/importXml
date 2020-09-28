package br.com.cesan.importacao.xml.model.to.mensagem.common;

public class DiagnosticoTO {
	
	private String nomeTabela;
	private String codigoDiagnostico;
	private String descricaoDiagnostico;
	
	public String getNomeTabela() {
		return nomeTabela;
	}
	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	public String getCodigoDiagnostico() {
		return codigoDiagnostico;
	}
	public void setCodigoDiagnostico(String codigoDiagnostico) {
		this.codigoDiagnostico = codigoDiagnostico;
	}
	public String getDescricaoDiagnostico() {
		return descricaoDiagnostico;
	}
	public void setDescricaoDiagnostico(String descricaoDiagnostico) {
		this.descricaoDiagnostico = descricaoDiagnostico;
	}

}
