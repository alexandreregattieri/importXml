package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

public class MembroEquipeTO {
	
	private IdentificacaoPrestadorEquipeTO codigoProfissional;
	private ProfissionalExecutanteTO identificacaoProfissional;
	private String cpf;
	private String posicaoProfissional;
	
	public IdentificacaoPrestadorEquipeTO getCodigoProfissional() {
		return codigoProfissional;
	}
	public void setCodigoProfissional(IdentificacaoPrestadorEquipeTO codigoProfissional) {
		this.codigoProfissional = codigoProfissional;
	}
	public ProfissionalExecutanteTO getIdentificacaoProfissional() {
		return identificacaoProfissional;
	}
	public void setIdentificacaoProfissional(
			ProfissionalExecutanteTO identificacaoProfissional) {
		this.identificacaoProfissional = identificacaoProfissional;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPosicaoProfissional() {
		return posicaoProfissional;
	}
	public void setPosicaoProfissional(String posicaoProfissional) {
		this.posicaoProfissional = posicaoProfissional;
	}

}
