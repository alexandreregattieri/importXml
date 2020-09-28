package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

public class AutorizacaoGuiaTO {
	
	private String dataAutorizacao;
	private String senhaAutorizacao;
	private String validadeSenha;
	
	public String getDataAutorizacao() {
		return dataAutorizacao;
	}
	public void setDataAutorizacao(String dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}
	public String getSenhaAutorizacao() {
		return senhaAutorizacao;
	}
	public void setSenhaAutorizacao(String senhaAutorizacao) {
		this.senhaAutorizacao = senhaAutorizacao;
	}
	public String getValidadeSenha() {
		return validadeSenha;
	}
	public void setValidadeSenha(String validadeSenha) {
		this.validadeSenha = validadeSenha;
	}

}
