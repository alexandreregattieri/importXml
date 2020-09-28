package br.com.cesan.importacao.xml.model.to.mensagem.common;

public class IdentificacaoProfissionalTO {
	
	private String nomeProfissional;
	private ConselhoProfissionalTO conselhoProfissional;
	private String cbos;
	
	public String getNomeProfissional() {
		return nomeProfissional;
	}
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}
	public ConselhoProfissionalTO getConselhoProfissional() {
		return conselhoProfissional;
	}
	public void setConselhoProfissional(ConselhoProfissionalTO conselhoProfissional) {
		this.conselhoProfissional = conselhoProfissional;
	}
	public String getCbos() {
		return cbos;
	}
	public void setCbos(String cbos) {
		this.cbos = cbos;
	}

}
