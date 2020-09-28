package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

public class ProcedimentosTO {
	
	private IdentificacaoEquipeTO equipe;
	private TabelaTO procedimento;
	private String data;
	private String horaInicio;
	private String horaFim;
	private Long quantidadeRealizada;
	private String viaDeAcesso;
	private String tecnicaUtilizada;
	private Double reducaoAcrescimo;
	private Double valor;
	private Double valorTotal;
	
	public IdentificacaoEquipeTO getEquipe() {
		return equipe;
	}
	public void setEquipe(IdentificacaoEquipeTO equipe) {
		this.equipe = equipe;
	}
	public TabelaTO getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(TabelaTO procedimento) {
		this.procedimento = procedimento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	public Long getQuantidadeRealizada() {
		return quantidadeRealizada;
	}
	public void setQuantidadeRealizada(Long quantidadeRealizada) {
		this.quantidadeRealizada = quantidadeRealizada;
	}
	public String getViaDeAcesso() {
		return viaDeAcesso;
	}
	public void setViaDeAcesso(String viaDeAcesso) {
		this.viaDeAcesso = viaDeAcesso;
	}
	public String getTecnicaUtilizada() {
		return tecnicaUtilizada;
	}
	public void setTecnicaUtilizada(String tecnicaUtilizada) {
		this.tecnicaUtilizada = tecnicaUtilizada;
	}
	public Double getReducaoAcrescimo() {
		return reducaoAcrescimo;
	}
	public void setReducaoAcrescimo(Double reducaoAcrescimo) {
		this.reducaoAcrescimo = reducaoAcrescimo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
