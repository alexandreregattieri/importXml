package br.com.cesan.importacao.process.presentation;

import br.com.cesan.importacao.sgb.model.dao.ValidaAtendimentoDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaInsercaoDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaTissDAO;
import br.com.cesan.importacao.sgb.model.to.BeneficiarioSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturasConsultaSGBTO;
import br.com.cesan.importacao.sgb.model.to.TabelaProcedSGBTO;

public class InsereConsulta {
	
	public String setInsereConsulta(FaturasConsultaSGBTO fcsgb, int pos, TabelaProcedSGBTO tab, BeneficiarioSGBTO benef, Long numlote, String nega) {
		String retorno = null;
		String autoriz = null;
		String fat = null;
		String sql = "INSERT E09_FATURA (INDDONFAT,NUMCPFCGCCRI,INDCPFCGC,DTAATN,INDUSU,NUMTIU,CODDPD,CODEMPASN,CODEMPPAN,CODPLNCOP,TIPATN,INDATN,CODITIDOE,NUMAUOPCDMDC,ANOAUOPCDMDC,INDSIT,VALTOTINR,VALTOTGLS,VALTOTGRO,VALDPSEXR,VALTOTUSU,VALTOTPLN,OBSFAT,CODEMPPLN,CD_IDC_PAGAR_CREDENCIADO,CD_IDC_COBRAR_USUARIO,CD_IDC_GUIA_EMITIDA,CD_ENDERECO_CREDENCIADO,CD_FINALIDADE,CD_MOTIVO_ATENDIMENTO,NU_GUIA_ATENDIMENTO_HOSPITAL,NU_VIA_CARTEIRA,NU_GUIA_COMPLEMENTO,NU_DIAS_VALIDADE_GUIA,NU_MATRICULA_INCLUSAO,DT_EMISSAO_GUIA,ID_FATURA_ELETRONICA,QA_TEMPO_PERFORMANCE,ID_TIPO_FATURA,ID_TIPO_DOENCA,ID_TEMPO_DOENCA,NU_TEMPO_DOENCA,ID_ACIDENTE,NU_REGISTRO_ANS,CD_TIPO_CONSELHO,NUMCRM,CD_UF_CRM,CD_TIPO_CONSULTA,CD_TIPO_SAIDA,NM_MEDICO_PROFISSIONAL,DT_INCLUSAO)";
		ValidaAtendimentoDAO valAtend = new ValidaAtendimentoDAO();
		ValidaInsercaoDAO valInser = new ValidaInsercaoDAO();
		ValidaTissDAO valTiss = new ValidaTissDAO();
		if (fcsgb.getFaturas().get(pos).getNumcpfcgccri() != null) {
			if (fcsgb.getFaturas().get(pos).getCodemppan() != null) {
				if (fcsgb.getFaturas().get(pos).getDtaatn() != null) {
					if (fcsgb.getFaturas().get(pos).getItens().getCodtiptab() != null) {
						try {
							autoriz = valAtend.getNumeroAutoriz(fcsgb.getFaturas().get(pos).getDtaatn());
							sql = sql + " VALUES ('M','" + fcsgb.getFaturas().get(pos).getNumcpfcgccri() + "','" + fcsgb.getFaturas().get(pos).getIndcpgcgc() + "','" + fcsgb.getFaturas().get(pos).getDtaatn() +"',";
							sql = sql + "'" + fcsgb.getFaturas().get(pos).getIndusu() + "','" + fcsgb.getFaturas().get(pos).getNumtiu() + "','" + fcsgb.getFaturas().get(pos).getCoddpd() + "','E'," + fcsgb.getFaturas().get(pos).getCodemppan() + "," + fcsgb.getFaturas().get(pos).getCodplncop() + ",";
							sql = sql + "'N','C','" + fcsgb.getFaturas().get(pos).getCoditidoe() + "','" + autoriz + "'," + fcsgb.getFaturas().get(pos).getDtaatn().substring(0, 4) + ",'D',0,0,0,0,0,0,'" + fcsgb.getFaturas().get(pos).getObsfat() + "'," + fcsgb.getFaturas().get(pos).getCodemppln() + ",";
							sql = sql + "'S','S','N',1,0,1,'" + fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital() + "',1,'" + fcsgb.getFaturas().get(pos).getNuGuiaComplemento() + "',90,'TISS','" + fcsgb.getFaturas().get(pos).getDtEmissaoGuia() + "','S',0,'C','" + fcsgb.getFaturas().get(pos).getIdTipoDoenca() + "',";
							sql = sql + "'" + fcsgb.getFaturas().get(pos).getIdTempoDoenca() + "'," + fcsgb.getFaturas().get(pos).getNuTempoDoenca() + ",'" + fcsgb.getFaturas().get(pos).getIdAcidente() + "',392405,'" + fcsgb.getFaturas().get(pos).getCdTipoConselho().trim().toUpperCase() + "','" + fcsgb.getFaturas().get(pos).getNumcrm().trim().toUpperCase() + "',";
							sql = sql + "'" + fcsgb.getFaturas().get(pos).getCdUfCrm().trim().toUpperCase() + "'," + fcsgb.getFaturas().get(pos).getCdTipoConsulta() + "," + fcsgb.getFaturas().get(pos).getCdTipoSaida() + ",'" + fcsgb.getFaturas().get(pos).getNmMedicoProfissional().trim().toUpperCase() + "'," + fcsgb.getFaturas().get(pos).getDtInclusao() + ")";
							Long guiaimport = valTiss.getGuiaImportTiss(fcsgb.getFaturas().get(pos).getNumcpfcgccri(), fcsgb.getFaturas().get(pos).getItens().getNuLoteTiss(), fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getCoddpd(), fcsgb.getFaturas().get(pos).getCodemppan(), fcsgb.getFaturas().get(pos).getItens().getCodtiptab(), fcsgb.getFaturas().get(pos).getItens().getNuBeneficio());
							if (numlote > 0) {
								if (guiaimport > 0) {
									retorno = ajustaDadosErro(fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getDtaatn(), fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital(), "GUIA JÁ IMPORTADA.");
								} else {
									valInser.setInsereFatura(sql);
								}
							} else {
								valInser.setInsereFatura(sql);
							}
							fat = valInser.getNumFatura(autoriz, fcsgb.getFaturas().get(pos).getDtaatn());
							if (fcsgb.getFaturas().get(pos).getItens().getValpre() == 0.0f) {
								if (nega.equals("N")) {
									fcsgb.getFaturas().get(pos).getItens().setValpre(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setValgls(0.0);
									fcsgb.getFaturas().get(pos).getItens().setValite(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setValplnite(tab.getValor()*(1-benef.getParticipacao()));
									fcsgb.getFaturas().get(pos).getItens().setValusuite(tab.getValor()*benef.getParticipacao());
									fcsgb.getFaturas().get(pos).getItens().setVaBaseCalculoImposto(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setVaProcedimentoChUso(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setCdGlosa((long)0);
								} else {
									fcsgb.getFaturas().get(pos).getItens().setValpre(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setValgls(0.0 - tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setValite(0.0);
									fcsgb.getFaturas().get(pos).getItens().setValplnite(0.0);
									fcsgb.getFaturas().get(pos).getItens().setValusuite(0.0);
									fcsgb.getFaturas().get(pos).getItens().setVaBaseCalculoImposto(0.0);
									fcsgb.getFaturas().get(pos).getItens().setVaProcedimentoChUso(0.0);
									fcsgb.getFaturas().get(pos).getItens().setCdGlosa((long)1702);
								}
							} else {
								if (nega.equals("N")) {
									fcsgb.getFaturas().get(pos).getItens().setValgls(fcsgb.getFaturas().get(pos).getItens().getValite()-tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setValite(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setValplnite(tab.getValor()*(1-benef.getParticipacao()));
									fcsgb.getFaturas().get(pos).getItens().setValusuite(tab.getValor()*benef.getParticipacao());
									fcsgb.getFaturas().get(pos).getItens().setVaBaseCalculoImposto(tab.getValor());
									fcsgb.getFaturas().get(pos).getItens().setVaProcedimentoChUso(tab.getValor());
									if (fcsgb.getFaturas().get(pos).getItens().getValite()-tab.getValor() > 0) {
										fcsgb.getFaturas().get(pos).getItens().setCdGlosa((long)1706);
									} else {
										fcsgb.getFaturas().get(pos).getItens().setCdGlosa((long)1705);
									}
								} else {
									fcsgb.getFaturas().get(pos).getItens().setValgls(0.0 - fcsgb.getFaturas().get(pos).getItens().getValpre());
									fcsgb.getFaturas().get(pos).getItens().setValite(0.0);
									fcsgb.getFaturas().get(pos).getItens().setValplnite(0.0);
									fcsgb.getFaturas().get(pos).getItens().setValusuite(0.0);
									fcsgb.getFaturas().get(pos).getItens().setVaBaseCalculoImposto(0.0);
									fcsgb.getFaturas().get(pos).getItens().setVaProcedimentoChUso(0.0);
									fcsgb.getFaturas().get(pos).getItens().setCdGlosa((long)1702);
								}
							}
							sql = "INSERT E09_FATURA_ITEM (INDDONFAT,NUMFAT,INDTIPITE,CODITEFAT,DTAATN,CODTIPTAB,NU_BENEFICIO,INDPOFEEC,TIPPGT,QTEITE,VALPRE,VALITE,VALGLS,VALDPSEXR,VALUSUITE,VALPLNITE,VA_BASE_CALCULO_IMPOSTO,CODMSG,VA_PERC_PROCED,CD_ESPEC_ASSOCIADA,CD_GLOSA,ID_SITUACAO,VA_PROCEDIMENTO_CH_USO,DTAATL,MATRESULTATL,OBSFAT_ITEM,NU_PROTOCOLO_TISS,NU_LOTE_TISS,DT_INCLUSAO_ITEM,SQ_BENEFICIO,VA_PLUS,VALTAXPLN,VALTAXUSU,VA_TAXA_INTERCAMBIO_PLANO,VA_TAXA_INTERCAMBIO_USUARIO)";
							sql = sql + " VALUES ('M'," + fat + ",'" + tab.getTipodigit() + "',1,'" + fcsgb.getFaturas().get(pos).getDtaatn() + "'," + tab.getCodtiptab() + "," + tab.getNubeneficio() + ",'','H',1," + fcsgb.getFaturas().get(pos).getItens().getValpre() + "," + fcsgb.getFaturas().get(pos).getItens().getValite() + "," + fcsgb.getFaturas().get(pos).getItens().getValgls() + ",";
							sql = sql + "0," + fcsgb.getFaturas().get(pos).getItens().getValusuite() + "," + fcsgb.getFaturas().get(pos).getItens().getValplnite() + "," + fcsgb.getFaturas().get(pos).getItens().getVaBaseCalculoImposto() + ",0,100," + fcsgb.getFaturas().get(pos).getItens().getCdEspecAssociada() + "," + fcsgb.getFaturas().get(pos).getItens().getCdGlosa() + ",'D',";
							sql = sql + fcsgb.getFaturas().get(pos).getItens().getVaProcedimentoChUso() + "," + fcsgb.getFaturas().get(pos).getItens().getDtaatl() + ",'TISS',''," + fcsgb.getFaturas().get(pos).getItens().getNuProtocoloTiss() + "," + fcsgb.getFaturas().get(pos).getItens().getNuLoteTiss() + "," + fcsgb.getFaturas().get(pos).getItens().getDtIncusaoItem() + ",1,0,0,0,0,0)";
							if (guiaimport <= 0) {
								valInser.setInsereItem(sql);
								valAtend.setAtualizaGuia(fcsgb.getFaturas().get(pos).getItens().getValpre(), fcsgb.getFaturas().get(pos).getItens().getValgls(), fcsgb.getFaturas().get(pos).getItens().getValite(), fcsgb.getFaturas().get(pos).getItens().getValdpsexr(), fcsgb.getFaturas().get(pos).getItens().getValusuite(), fcsgb.getFaturas().get(pos).getItens().getValplnite(), Long.parseLong(fat));
							}
							if (tab.getValor() == 0.0f) {
								retorno = ajustaDadosErro(fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getDtaatn(), fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital(), "PROCEDIMENTO JÁ REALIZADO.");
							}
						} catch (Exception e) {
							System.out.println("CONSULTA " + e.toString());
						}
					} else {
						retorno = ajustaDadosErro(fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getDtaatn(), fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital(), "TABELA NÃO INFORMADA/INEXISTENTE.");
					}
				} else {
					retorno = ajustaDadosErro(fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getDtaatn(), fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital(), "GUIA SEM DATA DE ATENDIMENTO.");
				}
			} else {
				retorno = ajustaDadosErro(fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getDtaatn(), fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital(), "MATRÍCULA NÃO CADASTRADA/NÃO ATIVA.");
			}
		} else {
			retorno = ajustaDadosErro(fcsgb.getFaturas().get(pos).getNumtiu(), fcsgb.getFaturas().get(pos).getDtaatn(), fcsgb.getFaturas().get(pos).getNuGuiaAtendimentoHospital(), "PRESTADOR NÃO IDENTIFICADO.");
		}
		return retorno;
	}
	
	private String ajustaDadosErro(String numtiu, String data, String guia, String erro) {
		String ret = null;
		String numtiuAux, dataAux, guiaAux;
		if (numtiu == null) {
			numtiuAux = "0000000";
		} else {
			numtiuAux = numtiu;
		}
		if (data == null) {
			dataAux = "00/00/0000";
		} else {
			dataAux = data.substring(8,10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
		}
		if (guia == null) {
			guiaAux = "          ";
		} else {
			guiaAux = guia;
		}
		ret = "MATRÍCULA: " + numtiuAux + " -   DATA: " + dataAux + " -   GUIA: " + guiaAux + " -   ERRO: " + erro;
		return ret;
	}

}
