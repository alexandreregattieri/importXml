package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias;

import br.com.cesan.importacao.xml.model.to.mensagem.common.BeneficiarioTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.CabecalhoGuiaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.DiagnosticoAtendimentoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.AutorizacaoGuiaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.OPMUtilizadaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.OutrasDespesasTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.PrestadorExecutanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ProcedimentoRealizadoEquipeTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.SolicitanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ValorTotalServicosTO;

public class GuiaSP_SADTTO {
	
	private CabecalhoGuiaTO identificacaoGuiaSADTSP;
	private String numeroGuiaPrincipal;
	private AutorizacaoGuiaTO dadosAutorizacao;
	private BeneficiarioTO dadosBeneficiario;
	private SolicitanteTO dadosSolicitante;
	private PrestadorExecutanteTO prestadorExecutante;
	private String idicacaoClinica;
	private String caraterAtendimento;
	private String dataHoraAtendimento;
	private DiagnosticoAtendimentoTO diagnosticoAtendimento;
	private String tipoSaida;
	private String tipoAtendimento;
	private ProcedimentoRealizadoEquipeTO procedimentosRealizados;
	private OutrasDespesasTO outrasDespesas;
	private OPMUtilizadaTO opmUtilizada;
	private ValorTotalServicosTO valorTotal;
	private String observacao;
	
	public CabecalhoGuiaTO getIdentificacaoGuiaSADTSP() {
		return identificacaoGuiaSADTSP;
	}
	public void setIdentificacaoGuiaSADTSP(CabecalhoGuiaTO identificacaoGuiaSADTSP) {
		this.identificacaoGuiaSADTSP = identificacaoGuiaSADTSP;
	}
	public String getNumeroGuiaPrincipal() {
		return numeroGuiaPrincipal;
	}
	public void setNumeroGuiaPrincipal(String numeroGuiaPrincipal) {
		this.numeroGuiaPrincipal = numeroGuiaPrincipal;
	}
	public AutorizacaoGuiaTO getDadosAutorizacao() {
		return dadosAutorizacao;
	}
	public void setDadosAutorizacao(AutorizacaoGuiaTO dadosAutorizacao) {
		this.dadosAutorizacao = dadosAutorizacao;
	}
	public BeneficiarioTO getDadosBeneficiario() {
		return dadosBeneficiario;
	}
	public void setDadosBeneficiario(BeneficiarioTO dadosBeneficiario) {
		this.dadosBeneficiario = dadosBeneficiario;
	}
	public SolicitanteTO getDadosSolicitante() {
		return dadosSolicitante;
	}
	public void setDadosSolicitante(SolicitanteTO dadosSolicitante) {
		this.dadosSolicitante = dadosSolicitante;
	}
	public PrestadorExecutanteTO getPrestadorExecutante() {
		return prestadorExecutante;
	}
	public void setPrestadorExecutante(PrestadorExecutanteTO prestadorExecutante) {
		this.prestadorExecutante = prestadorExecutante;
	}
	public String getIdicacaoClinica() {
		return idicacaoClinica;
	}
	public void setIdicacaoClinica(String idicacaoClinica) {
		this.idicacaoClinica = idicacaoClinica;
	}
	public String getCaraterAtendimento() {
		return caraterAtendimento;
	}
	public void setCaraterAtendimento(String caraterAtendimento) {
		this.caraterAtendimento = caraterAtendimento;
	}
	public String getDataHoraAtendimento() {
		return dataHoraAtendimento;
	}
	public void setDataHoraAtendimento(String dataHoraAtendimento) {
		this.dataHoraAtendimento = dataHoraAtendimento;
	}
	public DiagnosticoAtendimentoTO getDiagnosticoAtendimento() {
		return diagnosticoAtendimento;
	}
	public void setDiagnosticoAtendimento(DiagnosticoAtendimentoTO diagnosticoAtendimento) {
		this.diagnosticoAtendimento = diagnosticoAtendimento;
	}
	public String getTipoSaida() {
		return tipoSaida;
	}
	public void setTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
	}
	public String getTipoAtendimento() {
		return tipoAtendimento;
	}
	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	public ProcedimentoRealizadoEquipeTO getProcedimentosRealizados() {
		return procedimentosRealizados;
	}
	public void setProcedimentosRealizados(ProcedimentoRealizadoEquipeTO procedimentosRealizados) {
		this.procedimentosRealizados = procedimentosRealizados;
	}
	public OutrasDespesasTO getOutrasDespesas() {
		return outrasDespesas;
	}
	public void setOutrasDespesas(OutrasDespesasTO outrasDespesas) {
		this.outrasDespesas = outrasDespesas;
	}
	public OPMUtilizadaTO getOpmUtilizada() {
		return opmUtilizada;
	}
	public void setOpmUtilizada(OPMUtilizadaTO opmUtilizada) {
		this.opmUtilizada = opmUtilizada;
	}
	public ValorTotalServicosTO getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(ValorTotalServicosTO valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
