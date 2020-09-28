package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

public class IdentificacaoOPMTO {
	
	private TabelaTO opm;
	private Double quantidade;
	private String codigoBarra;
	private Double valorUnitario;
	private Double valorTotal;
	
	public TabelaTO getOpm() {
		return opm;
	}
	public void setOpm(TabelaTO opm) {
		this.opm = opm;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
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
