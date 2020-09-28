package br.com.cesan.importacao.xml.model.to.mensagem.common;

public class DiagnosticoAtendimentoTO {
	
	private DiagnosticoTO cid;
	private String tipoDoenca;
	private TempoEvolucaoDoencaTO tempoReferidoEvolucaoDoenca;
	private String indicadorAcidente;
	
	public DiagnosticoTO getCid() {
		return cid;
	}
	public void setCid(DiagnosticoTO cid) {
		this.cid = cid;
	}
	public String getTipoDoenca() {
		return tipoDoenca;
	}
	public void setTipoDoenca(String tipoDoenca) {
		this.tipoDoenca = tipoDoenca;
	}
	public TempoEvolucaoDoencaTO getTempoReferidoEvolucaoDoenca() {
		return tempoReferidoEvolucaoDoenca;
	}
	public void setTempoReferidoEvolucaoDoenca(TempoEvolucaoDoencaTO tempoReferidoEvolucaoDoenca) {
		this.tempoReferidoEvolucaoDoenca = tempoReferidoEvolucaoDoenca;
	}
	public String getIndicadorAcidente() {
		return indicadorAcidente;
	}
	public void setIndicadorAcidente(String indicadorAcidente) {
		this.indicadorAcidente = indicadorAcidente;
	}

}
