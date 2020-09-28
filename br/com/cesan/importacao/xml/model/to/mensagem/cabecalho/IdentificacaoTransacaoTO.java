package br.com.cesan.importacao.xml.model.to.mensagem.cabecalho;

public class IdentificacaoTransacaoTO {

	private String tipoTransacao;
	private Long sequencialTransacao;
	private String dataRegistroTransacao;
	private String horaRegistroTransacao;
	
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public Long getSequencialTransacao() {
		return sequencialTransacao;
	}
	public void setSequencialTransacao(Long sequencialTransacao) {
		this.sequencialTransacao = sequencialTransacao;
	}
	public String getDataRegistroTransacao() {
		return dataRegistroTransacao;
	}
	public void setDataRegistroTransacao(String dataRegistroTransacao) {
		this.dataRegistroTransacao = dataRegistroTransacao;
	}
	public String getHoraRegistroTransacao() {
		return horaRegistroTransacao;
	}
	public void setHoraRegistroTransacao(String horaRegistroTransacao) {
		this.horaRegistroTransacao = horaRegistroTransacao;
	}
	
}
