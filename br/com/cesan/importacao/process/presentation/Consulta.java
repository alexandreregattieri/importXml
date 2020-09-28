package br.com.cesan.importacao.process.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.cesan.importacao.sgb.model.to.FaturaConsultaSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturaItemConsultaSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturasConsultaSGBTO;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaConsultaTO;
import br.com.cesan.importacao.xml.presentation.LerXML;

public class Consulta {
	
	public FaturasConsultaSGBTO getDadosConsulta (String caminho, MensagemTO msg) {
		FaturasConsultaSGBTO fcs = new FaturasConsultaSGBTO();
		LerXML ler = new LerXML(caminho);
		try {
			msg = ler.getMensagem();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		FaturaConsultaSGBTO fc = null;
		FaturaItemConsultaSGBTO fic = null;
		List<FaturaConsultaSGBTO> listaFc = new ArrayList<FaturaConsultaSGBTO>();
		List<GuiaConsultaTO> listaGc = new ArrayList<GuiaConsultaTO>();
		if (msg.getCorpo().getLoteGuias().getGuias().getGuiaFaturamento().getGuiaConsulta() == null) {
			listaGc = null;
		} else {
			listaGc = msg.getCorpo().getLoteGuias().getGuias().getGuiaFaturamento().getGuiaConsulta();
		}
		int i = 0;
		if (listaGc == null) {
			fcs.setFaturas(null);
		} else {
			for (GuiaConsultaTO gc : listaGc) {
				fc = new FaturaConsultaSGBTO();
				fic = new FaturaItemConsultaSGBTO();
				fic.setNumfat(null);
				fic.setIndtipite(null);
				fic.setCoditefat((long)1);
				if (listaGc.get(i).getDadosAtendimento() != null) {
					if (listaGc.get(i).getDadosAtendimento().getDataAtendimento() != null) {
						String dtaatnI = listaGc.get(i).getDadosAtendimento().getDataAtendimento();
						dtaatnI = AjustaData(dtaatnI);
						fic.setDtaatn(dtaatnI);
						fc.setDtaatn(dtaatnI);
					} else {
						JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE ATENDIMENTO.");
						return null;
					}
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE ATENDIMENTO.");
					return null;
				}
				if (listaGc.get(i).getDadosAtendimento() != null) {
					if (listaGc.get(i).getDadosAtendimento().getProcedimento() != null) {
						if (listaGc.get(i).getDadosAtendimento().getProcedimento().getCodigoTabela() != null) {
							fic.setCodtiptab(Long.parseLong(listaGc.get(i).getDadosAtendimento().getProcedimento().getCodigoTabela()));
						} else {
							fic.setCodtiptab((long)43);
						}
					} else {
						fic.setCodtiptab((long)43);
					}
				} else {
					fic.setCodtiptab((long)43);
				}
				if (listaGc.get(i).getDadosAtendimento() != null) {
					if (listaGc.get(i).getDadosAtendimento().getProcedimento() != null) {
						if (listaGc.get(i).getDadosAtendimento().getProcedimento().getCodigoProcedimento() != null) {
							fic.setNuBeneficio(Long.parseLong(listaGc.get(i).getDadosAtendimento().getProcedimento().getCodigoProcedimento()));
						} else {
							fic.setNuBeneficio((long)2);
						}
					} else {
						fic.setNuBeneficio((long)2);
					}
				} else {
					fic.setNuBeneficio((long)2);
				}
				fic.setQteite((long)1);
				fic.setValpre(0.0);
				fic.setValite(0.0);
				fic.setValgls(0.0);
				fic.setValdpsexr(0.0);
				fic.setValusuite(0.0);
				fic.setValplnite(0.0);
				fic.setVaBaseCalculoImposto(0.0);
				fic.setCdEspecAssociada((long)101);
				fic.setCdGlosa(null);
				fic.setVaProcedimentoChUso(0.0);
				fic.setDtaatl("GETDATE()");
				if (msg.getCabecalho() != null) {
					if (msg.getCabecalho().getIdentificacaoTransacao() != null) {
						if (msg.getCabecalho().getIdentificacaoTransacao().getSequencialTransacao() != null) {
							fic.setNuProtocoloTiss(msg.getCabecalho().getIdentificacaoTransacao().getSequencialTransacao());
						} else {
							fic.setNuProtocoloTiss((long)0);
						}
					} else {
						fic.setNuProtocoloTiss((long)0);
					}
				} else {
					fic.setNuProtocoloTiss((long)0);
				}
				if (msg.getCorpo() != null) {
					if (msg.getCorpo().getLoteGuias() != null) {
						if (msg.getCorpo().getLoteGuias().getNumeroLote() != null) {
							fic.setNuLoteTiss(msg.getCorpo().getLoteGuias().getNumeroLote());
						} else {
							fic.setNuLoteTiss((long)0);
						}
					} else {
						fic.setNuLoteTiss((long)0);
					}
				} else {
					fic.setNuLoteTiss((long)0);
				}
				fic.setDtIncusaoItem("GETDATE()");
				fc.setItens(fic);
				if (listaGc.get(i).getDadosContratado().getIdentificacao().getCnpj() != null) {
					fc.setNumcpfcgccri(listaGc.get(i).getDadosContratado().getIdentificacao().getCnpj());
				} else if (listaGc.get(i).getDadosContratado().getIdentificacao().getCpf() != null) {
					fc.setNumcpfcgccri(listaGc.get(i).getDadosContratado().getIdentificacao().getCpf());
				} else if (listaGc.get(i).getDadosContratado().getIdentificacao().getCodigoPrestadorNaOperadora() != null) {
					fc.setNumcpfcgccri(listaGc.get(i).getDadosContratado().getIdentificacao().getCodigoPrestadorNaOperadora());
				} else if (msg.getCabecalho().getOrigem().getCodigoPrestadorNaOperadora().getCnpj() != null){
					fc.setNumcpfcgccri(msg.getCabecalho().getOrigem().getCodigoPrestadorNaOperadora().getCnpj());
				} else if (msg.getCabecalho().getOrigem().getCodigoPrestadorNaOperadora().getCpf() != null){
					fc.setNumcpfcgccri(msg.getCabecalho().getOrigem().getCodigoPrestadorNaOperadora().getCpf());
				} else {
					fc.setNumcpfcgccri(msg.getCabecalho().getOrigem().getCodigoPrestadorNaOperadora().getCodigoPrestadorNaOperadora());
				}
				fc.setIndcpgcgc(null);
				fc.setIndusu(null);
				if (listaGc.get(i).getBeneficiario() != null) {
					if (listaGc.get(i).getBeneficiario().getNumeroCateira() != null) {
						fc.setNumtiu(listaGc.get(i).getBeneficiario().getNumeroCateira());
					} else {
						JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM INFORMAÇÃO DO BENEFICIÁRIO.");
						return null;
					}
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM INFORMAÇÃO DO BENEFICIÁRIO.");
					return null;
				}
				fc.setCoddpd(null);
				fc.setCodemppan(null);
				fc.setCodplncop(null);
				if (listaGc.get(i).getHipoteseDiagnostica() != null) {
					if (listaGc.get(i).getHipoteseDiagnostica().getCid() != null) {
						if (listaGc.get(i).getHipoteseDiagnostica().getCid().getCodigoDiagnostico() != null) {
							fc.setCoditidoe(listaGc.get(i).getHipoteseDiagnostica().getCid().getCodigoDiagnostico());
						} else {
							fc.setCoditidoe("");
						}
					} else {
						fc.setCoditidoe("");
					}
				} else {
					fc.setCoditidoe("");
				}
				fc.setNumauopcdmdc(null);
				fc.setAnoauopcdmdc(null);
				fc.setValtotinr(0.0);
				fc.setValtotgls(0.0);
				fc.setValtotgro(0.0);
				fc.setValdpsexr(0.0);
				fc.setValtotusu(0.0);
				fc.setValtotpln(0.0);
				if (listaGc.get(i).getObservacao() == null) {
					fc.setObsfat("");
				} else {
					fc.setObsfat(listaGc.get(i).getObservacao());
				}
				fc.setCodemppln(null);
				if (listaGc.get(i).getIdentificacaoGuia() != null) {
					if (listaGc.get(i).getIdentificacaoGuia().getNumeroGuiaPrestador() != null) {
						fc.setNuGuiaAtendimentoHospital(listaGc.get(i).getIdentificacaoGuia().getNumeroGuiaPrestador());
					} else {
						fc.setNuGuiaAtendimentoHospital("");
					}
					if (listaGc.get(i).getIdentificacaoGuia().getNumeroGuiaOperadora() == null) {
						if (listaGc.get(i).getIdentificacaoGuia().getNumeroGuiaPrestador() == null) {
							fc.setNuGuiaComplemento("");
						} else {
							fc.setNuGuiaComplemento(fc.getNuGuiaAtendimentoHospital());
						}
					} else {
						fc.setNuGuiaComplemento(listaGc.get(i).getIdentificacaoGuia().getNumeroGuiaOperadora());
					}
				} else {
					fc.setNuGuiaAtendimentoHospital("");
					fc.setNuGuiaComplemento("");
				}
				if (listaGc.get(i).getIdentificacaoGuia() != null) {
					if (listaGc.get(i).getIdentificacaoGuia().getDataEmissaoGuia() != null) {
						String dtEmissaoGuia = listaGc.get(i).getIdentificacaoGuia().getDataEmissaoGuia();
						dtEmissaoGuia = AjustaData(dtEmissaoGuia);
						fc.setDtEmissaoGuia(dtEmissaoGuia);
					} else {
						JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE EMISSÃO.");
						return null;
					}
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE EMISSÃO.");
					return null;
				}
				if (listaGc.get(i).getHipoteseDiagnostica() != null) {
					if (listaGc.get(i).getHipoteseDiagnostica().getTipoDoenca() != null) {
						fc.setIdTipoDoenca(listaGc.get(i).getHipoteseDiagnostica().getTipoDoenca());
					} else {
						fc.setIdTipoDoenca("");
					}
				} else {
					fc.setIdTipoDoenca("");
				}
				if (listaGc.get(i).getHipoteseDiagnostica() != null) {
					if (listaGc.get(i).getHipoteseDiagnostica().getTempoReferidoEvolucaoDoenca() != null) {
						if (listaGc.get(i).getHipoteseDiagnostica().getTempoReferidoEvolucaoDoenca().getUnidadeTempo() != null) {
							fc.setIdTempoDoenca(listaGc.get(i).getHipoteseDiagnostica().getTempoReferidoEvolucaoDoenca().getUnidadeTempo());
						} else {
							fc.setIdTempoDoenca("");
						}
						if (listaGc.get(i).getHipoteseDiagnostica().getTempoReferidoEvolucaoDoenca().getValor() != null) {
							fc.setNuTempoDoenca(Long.parseLong(listaGc.get(i).getHipoteseDiagnostica().getTempoReferidoEvolucaoDoenca().getValor()));
						} else {
							fc.setNuTempoDoenca((long)0);
						}
					} else {
						fc.setIdTempoDoenca("");
						fc.setNuTempoDoenca((long)0);
					}
				} else {
					fc.setIdTempoDoenca("");
					fc.setNuTempoDoenca((long)0);
				}
				if (listaGc.get(i).getHipoteseDiagnostica() != null) {
					if (listaGc.get(i).getHipoteseDiagnostica().getIndicadorAcidente() != null) {
						fc.setIdAcidente(listaGc.get(i).getHipoteseDiagnostica().getIndicadorAcidente());
					} else {
						fc.setIdAcidente("");
					}
				} else {
					fc.setIdAcidente("");
				}
				if (listaGc.get(i).getProfissionalExecutante() != null) {
					if (listaGc.get(i).getProfissionalExecutante().getConselhoProfissional() != null) {
						if (listaGc.get(i).getProfissionalExecutante().getConselhoProfissional().getSiglaConselho() != null) {
							fc.setCdTipoConselho(listaGc.get(i).getProfissionalExecutante().getConselhoProfissional().getSiglaConselho());
						} else {
							fc.setCdTipoConselho("");
						}
						if (listaGc.get(i).getProfissionalExecutante().getConselhoProfissional().getNumeroConselho() != null) {
							fc.setNumcrm(listaGc.get(i).getProfissionalExecutante().getConselhoProfissional().getNumeroConselho());
						} else {
							fc.setNumcrm("");
						}
						if (listaGc.get(i).getProfissionalExecutante().getConselhoProfissional().getUfConselho() != null) {
							fc.setCdUfCrm(listaGc.get(i).getProfissionalExecutante().getConselhoProfissional().getUfConselho());
						} else {
							fc.setCdUfCrm("");
						}
					} else {
						fc.setCdTipoConselho("");
						fc.setNumcrm("");
						fc.setCdUfCrm("");
					}
				} else {
					fc.setCdTipoConselho("");
					fc.setNumcrm("");
					fc.setCdUfCrm("");
				}
				if (listaGc.get(i).getDadosAtendimento() != null) {
					if (listaGc.get(i).getDadosAtendimento().getTipoConsulta() != null) {
						fc.setCdTipoConsulta(Long.parseLong(listaGc.get(i).getDadosAtendimento().getTipoConsulta()));
					} else {
						fc.setCdTipoConsulta((long)1);
					}
					if (listaGc.get(i).getDadosAtendimento().getTipoSaida() != null) {
						fc.setCdTipoSaida(Long.parseLong(listaGc.get(i).getDadosAtendimento().getTipoSaida()));
					} else {
						fc.setCdTipoSaida((long)1);
					}
				} else {
					fc.setCdTipoConsulta((long)1);
					fc.setCdTipoSaida((long)1);
				}
				if (listaGc.get(i).getProfissionalExecutante() != null) {
					if (listaGc.get(i).getProfissionalExecutante().getNomeProfissional() != null) {
						fc.setNmMedicoProfissional(listaGc.get(i).getProfissionalExecutante().getNomeProfissional());
					} else {
						fc.setNmMedicoProfissional("");
					}
				} else {
					fc.setNmMedicoProfissional("");
				}
				fc.setDtInclusao("GETDATE()");
				listaFc.add(fc);
				i++;
			}
			fcs.setFaturas(listaFc);
		}
		return fcs;
	}
	
	private String AjustaData(String data) {
		String result = null;
		String d1, d2, d3;
		if (data == null) {
			result = null;
		} else {
			if (data.indexOf("-") > 0) {
				if (data.indexOf("-") == 4) {
					d1 = data.substring(0, 4);
					d2 = data.substring(5, 7);
					d3 = data.substring(8, 10);
					result = d1 + "-" + d2 + "-" + d3;
				} else if (data.indexOf("-") == 2) {
					d1 = data.substring(0, 2);
					d2 = data.substring(3, 5);
					d3 = data.substring(6, 10);
					result = d3 + "-" + d2 + "-" + d1;
				}
			} else {
				if (data.indexOf("/") > 0) {
					if (data.indexOf("/") == 4) {
						d1 = data.substring(0, 4);
						d2 = data.substring(5, 7);
						d3 = data.substring(8, 10);
						result = d1 + "-" + d2 + "-" + d3;
					} else if (data.indexOf("/") == 2) {
						d1 = data.substring(0, 2);
						d2 = data.substring(3, 5);
						d3 = data.substring(6, 10);
						result = d3 + "-" + d2 + "-" + d1;
					}
				} else {
					result = null;
				}
			}
		}
		return result;
	}
	
	private String AjustaData2(String data) {
		String result = null;
		String d1, d2, d3;
		if (data == null) {
			result = null;
		} else {
			if (data.indexOf("-") > 0) {
				if (data.indexOf("-") == 4) {
					d1 = data.substring(0, 4);
					d2 = data.substring(5, 7);
					d3 = data.substring(8, 10);
					result = d1 + "-" + d3 + "-" + d2;
				} else if (data.indexOf("-") == 2) {
					d1 = data.substring(0, 2);
					d2 = data.substring(3, 5);
					d3 = data.substring(6, 10);
					result = d3 + "-" + d1 + "-" + d2;
				}
			} else {
				if (data.indexOf("/") > 0) {
					if (data.indexOf("/") == 4) {
						d1 = data.substring(0, 4);
						d2 = data.substring(5, 7);
						d3 = data.substring(8, 10);
						result = d1 + "-" + d3 + "-" + d2;
					} else if (data.indexOf("/") == 2) {
						d1 = data.substring(0, 2);
						d2 = data.substring(3, 5);
						d3 = data.substring(6, 10);
						result = d3 + "-" + d1 + "-" + d2;
					}
				} else {
					result = null;
				}
			}
		}
		return result;
	}

}
