package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

public class DespesaTO {
	
	private TabelaTO identificadorDespesa;
	private String tipoDespesa;
	private String dataRealizacao;
	private String horaInicial;
	private String horaFinal;
	private Double reducaoAcescimo;
	private Double quantidade;
	private Double valorUnitario;
	private Double valorTotal;
	
	public TabelaTO getIdentificadorDespesa() {
		return identificadorDespesa;
	}
	public void setIdentificadorDespesa(TabelaTO identificadorDespesa) {
		this.identificadorDespesa = identificadorDespesa;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public String getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public String getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public Double getReducaoAcescimo() {
		return reducaoAcescimo;
	}
	public void setReducaoAcescimo(Double reducaoAcescimo) {
		this.reducaoAcescimo = reducaoAcescimo;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
