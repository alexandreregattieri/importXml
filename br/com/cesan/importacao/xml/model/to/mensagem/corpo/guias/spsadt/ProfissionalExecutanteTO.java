package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

import br.com.cesan.importacao.xml.model.to.mensagem.common.ConselhoProfissionalTO;

public class ProfissionalExecutanteTO {
	
	private String nomeExecutante;
	private ConselhoProfissionalTO conelhoProfissional;
	private String codigoCBOS;
	
	public String getNomeExecutante() {
		return nomeExecutante;
	}
	public void setNomeExecutante(String nomeExecutante) {
		this.nomeExecutante = nomeExecutante;
	}
	public ConselhoProfissionalTO getConelhoProfissional() {
		return conelhoProfissional;
	}
	public void setConelhoProfissional(ConselhoProfissionalTO conelhoProfissional) {
		this.conelhoProfissional = conelhoProfissional;
	}
	public String getCodigoCBOS() {
		return codigoCBOS;
	}
	public void setCodigoCBOS(String codigoCBOS) {
		this.codigoCBOS = codigoCBOS;
	}

}
