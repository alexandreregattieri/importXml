package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta;

public class AtendimentoConsultaTO {
	
	private String dataAtendimento;
	private ProcedimentoTO procedimento;
	private String tipoConsulta;
	private String tipoSaida;
	
	public String getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(String dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	public ProcedimentoTO getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(ProcedimentoTO procedimento) {
		this.procedimento = procedimento;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public String getTipoSaida() {
		return tipoSaida;
	}
	public void setTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
	}

}
