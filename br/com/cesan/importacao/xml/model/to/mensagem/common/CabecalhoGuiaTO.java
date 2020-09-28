package br.com.cesan.importacao.xml.model.to.mensagem.common;

public class CabecalhoGuiaTO {

	private IdentificacaoFontePagadoraTO identificacaoFontePagadora;
	private String dataEmissaoGuia;
	private String numeroGuiaPrestador;
	private String numeroGuiaOperadora;
	
	public IdentificacaoFontePagadoraTO getIdentificacaoFontePagadora() {
		return identificacaoFontePagadora;
	}
	public void setIdentificacaoFontePagadora(IdentificacaoFontePagadoraTO identificacaoFontePagadora) {
		this.identificacaoFontePagadora = identificacaoFontePagadora;
	}
	public String getDataEmissaoGuia() {
		return dataEmissaoGuia;
	}
	public void setDataEmissaoGuia(String dataEmissaoGuia) {
		this.dataEmissaoGuia = dataEmissaoGuia;
	}
	public String getNumeroGuiaPrestador() {
		return numeroGuiaPrestador;
	}
	public void setNumeroGuiaPrestador(String numeroGuiaPrestador) {
		this.numeroGuiaPrestador = numeroGuiaPrestador;
	}
	public String getNumeroGuiaOperadora() {
		return numeroGuiaOperadora;
	}
	public void setNumeroGuiaOperadora(String numeroGuiaOperadora) {
		this.numeroGuiaOperadora = numeroGuiaOperadora;
	}
	
}
