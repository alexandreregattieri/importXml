package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt;

import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoProfissionalTO;

public class SolicitanteTO {
	
	private ContratadoSolicitanteTO contratado;
	private IdentificacaoProfissionalTO profissional;
	
	public ContratadoSolicitanteTO getContratado() {
		return contratado;
	}
	public void setContratado(ContratadoSolicitanteTO contratado) {
		this.contratado = contratado;
	}
	public IdentificacaoProfissionalTO getProfissional() {
		return profissional;
	}
	public void setProfissional(IdentificacaoProfissionalTO profissional) {
		this.profissional = profissional;
	}

}
