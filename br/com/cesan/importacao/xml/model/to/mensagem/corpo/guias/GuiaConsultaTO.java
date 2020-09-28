package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias;

import br.com.cesan.importacao.xml.model.to.mensagem.common.BeneficiarioTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.CabecalhoGuiaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.DiagnosticoAtendimentoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoProfissionalTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta.AtendimentoConsultaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta.ContratadoTO;

public class GuiaConsultaTO {

	private CabecalhoGuiaTO identificacaoGuia;
	private BeneficiarioTO beneficiario;
	private ContratadoTO dadosContratado;
	private IdentificacaoProfissionalTO profissionalExecutante;
	private DiagnosticoAtendimentoTO hipoteseDiagnostica;
	private AtendimentoConsultaTO dadosAtendimento;
	private String observacao;
	
	public CabecalhoGuiaTO getIdentificacaoGuia() {
		return identificacaoGuia;
	}
	public void setIdentificacaoGuia(CabecalhoGuiaTO identificacaoGuia) {
		this.identificacaoGuia = identificacaoGuia;
	}
	public BeneficiarioTO getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(BeneficiarioTO beneficiario) {
		this.beneficiario = beneficiario;
	}
	public ContratadoTO getDadosContratado() {
		return dadosContratado;
	}
	public void setDadosContratado(ContratadoTO dadosContratado) {
		this.dadosContratado = dadosContratado;
	}
	public IdentificacaoProfissionalTO getProfissionalExecutante() {
		return profissionalExecutante;
	}
	public void setProfissionalExecutante(IdentificacaoProfissionalTO profissionalExecutante) {
		this.profissionalExecutante = profissionalExecutante;
	}
	public DiagnosticoAtendimentoTO getHipoteseDiagnostica() {
		return hipoteseDiagnostica;
	}
	public void setHipoteseDiagnostica(DiagnosticoAtendimentoTO hipoteseDiagnostica) {
		this.hipoteseDiagnostica = hipoteseDiagnostica;
	}
	public AtendimentoConsultaTO getDadosAtendimento() {
		return dadosAtendimento;
	}
	public void setDadosAtendimento(AtendimentoConsultaTO dadosAtendimento) {
		this.dadosAtendimento = dadosAtendimento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
