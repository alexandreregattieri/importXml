package br.com.cesan.importacao.sgb.model.to;

public class TabelaProcedSGBTO {
	
	private Long codtiptab;
	private Long nubeneficio;
	private Double valor;
	private String sexo;
	private String autorizacao;
	private Long idadeinicial;
	private Long idadefinal;
	private String tipodigit;
	
	public Long getCodtiptab() {
		return codtiptab;
	}
	public void setCodtiptab(Long codtiptab) {
		this.codtiptab = codtiptab;
	}
	public Long getNubeneficio() {
		return nubeneficio;
	}
	public void setNubeneficio(Long nubeneficio) {
		this.nubeneficio = nubeneficio;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	public Long getIdadeinicial() {
		return idadeinicial;
	}
	public void setIdadeinicial(Long idadeinicial) {
		this.idadeinicial = idadeinicial;
	}
	public Long getIdadefinal() {
		return idadefinal;
	}
	public void setIdadefinal(Long idadefinal) {
		this.idadefinal = idadefinal;
	}
	public String getTipodigit() {
		return tipodigit;
	}
	public void setTipodigit(String tipodigit) {
		this.tipodigit = tipodigit;
	}

}
