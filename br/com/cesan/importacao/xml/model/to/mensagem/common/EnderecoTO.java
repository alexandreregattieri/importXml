package br.com.cesan.importacao.xml.model.to.mensagem.common;

public class EnderecoTO {
	
	private String tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String codigoIBGEMunicipio;
	private String municipio;
	private String codigoUF;
	private String cep;
	
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCodigoIBGEMunicipio() {
		return codigoIBGEMunicipio;
	}
	public void setCodigoIBGEMunicipio(String codigoIBGEMunicipio) {
		this.codigoIBGEMunicipio = codigoIBGEMunicipio;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCodigoUF() {
		return codigoUF;
	}
	public void setCodigoUF(String codigoUF) {
		this.codigoUF = codigoUF;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

}
