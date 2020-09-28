package br.com.cesan.importacao.process.presentation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.cesan.importacao.sgb.model.dao.ValidaAtendimentoDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaInsercaoDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaTabelaDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaTissDAO;
import br.com.cesan.importacao.sgb.model.to.BeneficiarioSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturaExameSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturaItemExameSGBTO;
import br.com.cesan.importacao.sgb.model.to.SomaItensFaturaTO;
import br.com.cesan.importacao.sgb.model.to.TabelaProcedSGBTO;

public class InsereExame {

	public String setInsereExame(FaturaExameSGBTO fesgb, BeneficiarioSGBTO benef, String caminho, Long numlote) {
		String retorno = null;
		String autoriz = null;
		String fat = null;
		Long espec = null;
		Double somaExr = 0.0;
		Double somaGls = 0.0;
		Double somaGro = 0.0;
		Double somaInr = 0.0;
		Double somaPln = 0.0;
		Double somaUsu = 0.0;
		String sql = "INSERT E09_FATURA (INDDONFAT,NUMCPFCGCCRI,INDCPFCGC,DTAATN,INDUSU,NUMTIU,CODDPD,CODEMPASN,CODEMPPAN,CODPLNCOP,TIPATN,INDATN,CODITIDOE,NUMAUOPCDMDC,ANOAUOPCDMDC,INDSIT,VALTOTINR,VALTOTGLS,VALTOTGRO,VALDPSEXR,VALTOTUSU,VALTOTPLN,OBSFAT,CODEMPPLN,CD_IDC_PAGAR_CREDENCIADO,CD_IDC_COBRAR_USUARIO,CD_IDC_GUIA_EMITIDA,CD_ENDERECO_CREDENCIADO,CD_FINALIDADE,CD_MOTIVO_ATENDIMENTO,NU_GUIA_ATENDIMENTO_HOSPITAL,NU_VIA_CARTEIRA,NU_GUIA_COMPLEMENTO,NU_DIAS_VALIDADE_GUIA,NU_MATRICULA_INCLUSAO,DT_EMISSAO_GUIA,ID_FATURA_ELETRONICA,QA_TEMPO_PERFORMANCE,ID_TIPO_FATURA,ID_TIPO_DOENCA,ID_TEMPO_DOENCA,NU_TEMPO_DOENCA,ID_ACIDENTE,NU_REGISTRO_ANS,CD_TIPO_CONSELHO,NUMCRM,CD_UF_CRM,CD_TIPO_SAIDA,NM_MEDICO_PROFISSIONAL,DT_INCLUSAO,NUMCPFCGCCRI_CONTRATADO,NM_CONTRATADO,ID_TIPO_ATENDIMENTO)";
		ValidaAtendimentoDAO valAtend = null;
		ValidaInsercaoDAO valInser = null;
		ValidaTissDAO valTiss = null;
		ValidaTabelaDAO valTab = null;
		TabelaProcedSGBTO tab = null;
		InsereItemExame insItem = null;
		SomaItensFaturaTO soma = null;
		List<FaturaItemExameSGBTO> listaFie = fesgb.getItens();
		if (fesgb.getNumcpfcgccri() != null) {
			if (fesgb.getCodemppan() != null) {
				if (fesgb.getDtaatn() != null) {
					try {
						valAtend = new ValidaAtendimentoDAO();
						valInser = new ValidaInsercaoDAO();
						autoriz = valAtend.getNumeroAutoriz(fesgb.getDtaatn());
						sql = sql + " VALUES ('M','" + fesgb.getNumcpfcgccri() + "','" + fesgb.getIndcpgcgc() + "','" + fesgb.getDtaatn() + "','" + fesgb.getIndusu() + "','" + fesgb.getNumtiu() + "','" + fesgb.getCoddpd() + "','E'," + fesgb.getCodemppan() + "," + fesgb.getCodplncop() + ",'N','C','" + fesgb.getCoditidoe() + "','" + autoriz + "'," + fesgb.getDtaatn().substring(0, 4) + ",'D',0,0,0,0,0,0,'" + fesgb.getObsfat() + "'," + fesgb.getCodemppln() + ",'S','S','N',1,0,1,'" + fesgb.getNuGuiaAtendimentoHospital() + "',1,'" + fesgb.getNuGuiaComplemento() + "',90,'TISS','" + fesgb.getDtEmissaoGuia() + "','S',0,'S','" + fesgb.getIdTipoDoenca() + "','" + fesgb.getIdTempoDoenca() + "'," + fesgb.getNuTempoDoenca() + ",'" + fesgb.getIdAcidente() + "',392405,'";
						sql = sql + fesgb.getCdTipoConselho().trim().toUpperCase() + "','" + fesgb.getNumcrm().trim().toUpperCase() + "','" + fesgb.getCdUfCrm().trim().toUpperCase() + "'," + fesgb.getCdTipoSaida() + ",'" + fesgb.getNmMedicoProfissional().trim().toUpperCase() + "'," + fesgb.getDtInclusao() + ",'" + fesgb.getNumcpfcgccriContratado() + "','" + fesgb.getNmContratado().toUpperCase() + "','" + fesgb.getIdTipoAtendimento() + "')";
						int i = 0;
						int j = 0;
						int k = 1;
						for (FaturaItemExameSGBTO fie : listaFie) {
							valAtend = new ValidaAtendimentoDAO();
							valInser = new ValidaInsercaoDAO();
							valTiss = new ValidaTissDAO();
							soma = new SomaItensFaturaTO();
							insItem = new InsereItemExame();
							tab = new TabelaProcedSGBTO();
							valTab = new ValidaTabelaDAO();
							tab = valTab.getTabelas(listaFie.get(i).getCodtiptab(), listaFie.get(i).getNuBeneficio().toString());
							if (tab.getCodtiptab() != null && tab.getNubeneficio() != null) {
								if (tab.getAutorizacao().equals("N")) {
									if (valAtend.getFatProcedJaRealiz(fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getNumcpfcgccri(), listaFie.get(i).getCodtiptab(), listaFie.get(i).getNuBeneficio(), listaFie.get(i).getVaPercProced(), listaFie.get(i).getDtaatn()) == null) {
										if (tab.getSexo().equals("A") || tab.getSexo().equals(benef.getSexo())) {
											if (tab.getIdadeinicial() <= benef.getIdade() && tab.getIdadefinal() > benef.getIdade()) {
												if (j == 0) {
													Long guiaimport = valTiss.getGuiaImportTiss(fesgb.getNumcpfcgccri(), fesgb.getItens().get(0).getNuLoteTiss(), fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getItens().get(i).getCodtiptab(), fesgb.getItens().get(i).getNuBeneficio());
													if (numlote > 0) {
														if (guiaimport > 0) {
															soma = null;
															retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "GUIA JÁ IMPORTADA.");
														} else {
															valInser.setInsereFatura(sql);
															fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
														}
													} else {
														valInser.setInsereFatura(sql);
														fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
													}
												}
												j = 1;
												listaFie.get(i).setCodtiptab(tab.getCodtiptab());
												listaFie.get(i).setNuBeneficio(tab.getNubeneficio());
												listaFie.get(i).setValite(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
												listaFie.get(i).setValgls(this.ajustaFormatoNumerico((listaFie.get(i).getValite()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite())/100-listaFie.get(i).getValpre()));
												if (fesgb.getNumcrm().trim().equals("6964") || fesgb.getNumcrm().trim().equals("7188")) {
													listaFie.get(i).setValusuite(0.0);
													listaFie.get(i).setValplnite(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
												} else {
													listaFie.get(i).setValusuite(this.ajustaFormatoNumerico(tab.getValor()*benef.getParticipacao()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100));
													listaFie.get(i).setValplnite(this.ajustaFormatoNumerico(tab.getValor()*(1-benef.getParticipacao())*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100));
												}
												listaFie.get(i).setVaBaseCalculoImposto(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
												listaFie.get(i).setVaProcedimentoChUso(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
												if (listaFie.get(i).getValgls() > 0) {
													listaFie.get(i).setCdGlosa((long)1706);
												} else if (listaFie.get(i).getValgls() < 0) {
													listaFie.get(i).setCdGlosa((long)1705);
												} else {
													listaFie.get(i).setCdGlosa((long)0);
												}
												espec = valAtend.getEspecPrincipal(fesgb.getNumcpfcgccri(), tab.getCodtiptab());
												if (espec == null) {
													listaFie.get(i).setCdEspecAssociada((long)101);
												} else {
													listaFie.get(i).setCdEspecAssociada(espec);
												}
												listaFie.get(i).setCoditefat((long)k);
												k++;
												soma = insItem.setIsereItemExame(listaFie.get(i), tab, fat);
												} else {
												listaFie.get(i).setCodtiptab(tab.getCodtiptab());
												listaFie.get(i).setNuBeneficio(tab.getNubeneficio());
												listaFie.get(i).setValplnite(0.0);
												listaFie.get(i).setValgls(listaFie.get(i).getValpre());
												listaFie.get(i).setValusuite(0.0);
												listaFie.get(i).setValplnite(0.0);
												listaFie.get(i).setVaBaseCalculoImposto(0.0);
												listaFie.get(i).setVaProcedimentoChUso(0.0);
												listaFie.get(i).setCdGlosa((long)1706);
												espec = valAtend.getEspecPrincipal(fesgb.getNumcpfcgccri(), tab.getCodtiptab());
												if (espec == null) {
													listaFie.get(i).setCdEspecAssociada((long)22);
												} else {
													listaFie.get(i).setCdEspecAssociada(espec);
												}
												listaFie.get(i).setCoditefat((long)k);
												k++;
												soma = insItem.setIsereItemExame(listaFie.get(i), tab, fat);
											}
										} else {
											if (j == 0) {
												Long guiaimport = valTiss.getGuiaImportTiss(fesgb.getNumcpfcgccri(), fesgb.getItens().get(0).getNuLoteTiss(), fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getItens().get(i).getCodtiptab(), fesgb.getItens().get(i).getNuBeneficio());
												if (numlote > 0) {
													if (guiaimport > 0) {
														soma = null;
														retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "GUIA JÁ IMPORTADA.");
													} else {
														valInser.setInsereFatura(sql);
														fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
													}
												} else {
													valInser.setInsereFatura(sql);
													fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
												}
											}
											j = 1;
											listaFie.get(i).setCodtiptab(tab.getCodtiptab());
											listaFie.get(i).setNuBeneficio(tab.getNubeneficio());
											listaFie.get(i).setValplnite(0.0);
											listaFie.get(i).setValgls(listaFie.get(i).getValpre());
											listaFie.get(i).setValusuite(0.0);
											listaFie.get(i).setValplnite(0.0);
											listaFie.get(i).setVaBaseCalculoImposto(0.0);
											listaFie.get(i).setVaProcedimentoChUso(0.0);
											listaFie.get(i).setCdGlosa((long)1706);
											espec = valAtend.getEspecPrincipal(fesgb.getNumcpfcgccri(), tab.getCodtiptab());
											if (espec == null) {
												listaFie.get(i).setCdEspecAssociada((long)1802);
											} else {
												listaFie.get(i).setCdEspecAssociada(espec);
											}
											listaFie.get(i).setCoditefat((long)k);
											k++;
											soma = insItem.setIsereItemExame(listaFie.get(i), tab, fat);
										}
									} else {
										if (j == 0) {
											Long guiaimport = valTiss.getGuiaImportTiss(fesgb.getNumcpfcgccri(), fesgb.getItens().get(0).getNuLoteTiss(), fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getItens().get(i).getCodtiptab(), fesgb.getItens().get(i).getNuBeneficio());
											if (numlote > 0) {
												if (guiaimport > 0) {
													soma = null;
													retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "GUIA JÁ IMPORTADA.");
												} else {
													valInser.setInsereFatura(sql);
													fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
												}
											} else {
												valInser.setInsereFatura(sql);
												fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
											}
										}
										j = 1;
										listaFie.get(i).setCodtiptab(tab.getCodtiptab());
										listaFie.get(i).setNuBeneficio(tab.getNubeneficio());
										listaFie.get(i).setValplnite(0.0);
										listaFie.get(i).setValgls(listaFie.get(i).getValpre());
										listaFie.get(i).setValusuite(0.0);
										listaFie.get(i).setValplnite(0.0);
										listaFie.get(i).setVaBaseCalculoImposto(0.0);
										listaFie.get(i).setVaProcedimentoChUso(0.0);
										listaFie.get(i).setCdGlosa((long)1706);
										espec = valAtend.getEspecPrincipal(fesgb.getNumcpfcgccri(), tab.getCodtiptab());
										if (espec == null) {
											listaFie.get(i).setCdEspecAssociada((long)33);
										} else {
											listaFie.get(i).setCdEspecAssociada(espec);
										}
										listaFie.get(i).setCoditefat((long)k);
										k++;
										soma = insItem.setIsereItemExame(listaFie.get(i), tab, fat);
									}
								} else {
									if (j == 0) {
										Long guiaimport = valTiss.getGuiaImportTiss(fesgb.getNumcpfcgccri(), fesgb.getItens().get(0).getNuLoteTiss(), fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getItens().get(i).getCodtiptab(), fesgb.getItens().get(i).getNuBeneficio());
										if (numlote > 0) {
											if (guiaimport > 0) {
												soma = null;
												retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "GUIA JÁ IMPORTADA.");
											} else {
												valInser.setInsereFatura(sql);
												fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
											}
										} else {
											valInser.setInsereFatura(sql);
											fat = valInser.getNumFatura(autoriz, fesgb.getDtaatn());
										}
									}
									j = 1;
									listaFie.get(i).setCodtiptab(tab.getCodtiptab());
									listaFie.get(i).setNuBeneficio(tab.getNubeneficio());
									if (valAtend.getFatExisteAut(fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getNumcpfcgccri(), listaFie.get(i).getCodtiptab(), listaFie.get(i).getNuBeneficio()) == null) {
										listaFie.get(i).setValplnite(0.0);
										listaFie.get(i).setValgls(listaFie.get(i).getValpre());
										listaFie.get(i).setValusuite(0.0);
										listaFie.get(i).setValplnite(0.0);
										listaFie.get(i).setVaBaseCalculoImposto(0.0);
										listaFie.get(i).setVaProcedimentoChUso(0.0);
										listaFie.get(i).setCdGlosa((long)3);
										espec = valAtend.getEspecPrincipal(fesgb.getNumcpfcgccri(), tab.getCodtiptab());
										if (espec == null) {
											listaFie.get(i).setCdEspecAssociada((long)3);
										} else {
											listaFie.get(i).setCdEspecAssociada(espec);
										}
										listaFie.get(i).setCoditefat((long)k);
										k++;
										soma = insItem.setIsereItemExame(listaFie.get(i), tab, fat);
									} else {
										listaFie.get(i).setValite(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
										listaFie.get(i).setValgls(this.ajustaFormatoNumerico((listaFie.get(i).getValite()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite())/100-listaFie.get(i).getValpre()));
										if (fesgb.getNumcrm().trim().equals("6964") || fesgb.getNumcrm().trim().equals("7188")) {
											listaFie.get(i).setValusuite(0.0);
											listaFie.get(i).setValplnite(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
										} else {
											listaFie.get(i).setValusuite(this.ajustaFormatoNumerico(tab.getValor()*benef.getParticipacao()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100));
											listaFie.get(i).setValplnite(this.ajustaFormatoNumerico(tab.getValor()*(1-benef.getParticipacao())*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100));
										}
										listaFie.get(i).setVaBaseCalculoImposto(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
										listaFie.get(i).setVaProcedimentoChUso(tab.getValor()*listaFie.get(i).getVaPercProced()*listaFie.get(i).getQteite()/100);
										if (listaFie.get(i).getValgls() > 0) {
											listaFie.get(i).setCdGlosa((long)1706);
										} else if (listaFie.get(i).getValgls() < 0) {
											listaFie.get(i).setCdGlosa((long)1705);
										} else {
											listaFie.get(i).setCdGlosa((long)0);
										}
										Long aut = valAtend.getFatExisteAut(fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getNumcpfcgccri(), listaFie.get(i).getCodtiptab(), listaFie.get(i).getNuBeneficio());
										Long ite = valAtend.getIteExisteAut(fesgb.getNumtiu(), fesgb.getCoddpd(), fesgb.getCodemppan(), fesgb.getNumcpfcgccri(), listaFie.get(i).getCodtiptab(), listaFie.get(i).getNuBeneficio());
										valAtend.setAtualizaItem((double)listaFie.get(i).getQteite(), listaFie.get(i).getValpre(), listaFie.get(i).getValgls(), listaFie.get(i).getValite(), listaFie.get(i).getVaPercProced(), listaFie.get(i).getValusuite(), listaFie.get(i).getValplnite(), aut, listaFie.get(i).getCdGlosa(), listaFie.get(i).getNuProtocoloTiss(), listaFie.get(i).getNuLoteTiss(), listaFie.get(i).getDtaatn(), ite);
									}
								}
							} else {
								soma = null;
								retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "TABELA NÃO INFORMADA/INEXISTENTE.");
							}
							if (soma != null) {
								somaExr = somaExr + soma.getValexr();
								somaGls = somaGls + soma.getValgls();
								somaGro = somaGro + soma.getValgro();
								somaInr = somaInr + soma.getValinr();
								somaPln = somaPln + soma.getValpln();
								somaUsu = somaUsu + soma.getValusu();
							}
							i++;
						}
						if (fat != null) {
							valAtend.setAtualizaGuia(somaInr, somaGls, somaGro, somaExr, somaUsu, somaPln, Long.parseLong(fat));
						}
					} catch (Exception e) {
						System.out.println("EXAME " + e.toString());
					}
				} else {
					soma = null;
					retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "GUIA SEM DATA DE ATENDIMENTO.");
				}
			} else {
				soma = null;
				retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "BENEFICIÁRIO NÃO CADASTRADO/MATRÍCULA INCORRETA.");
			}
		} else {
			soma = null;
			retorno = ajustaDadosErro(fesgb.getNumtiu(), fesgb.getDtaatn(), fesgb.getNuGuiaAtendimentoHospital(), "PRESTADOR NÃO LOCALIZADO/NÃO CADASTRADO.");
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
	
	private Double ajustaFormatoNumerico(Double numero) {
		Double numeroForm = null;
		NumberFormat formato = DecimalFormat.getInstance(Locale.ENGLISH);
		formato.setMaximumFractionDigits(2);
		numeroForm = Double.parseDouble(formato.format(numero));
		return numeroForm;
	}
	
}
