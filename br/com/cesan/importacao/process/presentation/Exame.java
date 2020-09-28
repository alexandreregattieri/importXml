package br.com.cesan.importacao.process.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.cesan.importacao.sgb.model.to.FaturaExameSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturaItemExameSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturasExameSGBTO;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaSP_SADTTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ProcedimentosTO;
import br.com.cesan.importacao.xml.presentation.LerXML;

public class Exame {

	public FaturasExameSGBTO getDadosExame (String caminho, MensagemTO msg) {
		FaturasExameSGBTO fes = new FaturasExameSGBTO();
		LerXML ler = new LerXML(caminho);
		try {
			msg = ler.getMensagem();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		FaturaExameSGBTO fe = null;
		FaturaItemExameSGBTO fie = null;
		List<FaturaExameSGBTO> listaFe = new ArrayList<FaturaExameSGBTO>();
		List<GuiaSP_SADTTO> listaGs = new ArrayList<GuiaSP_SADTTO>();
		List<FaturaItemExameSGBTO> listaFie = null;
		List<ProcedimentosTO> listaPro = null;
		if (msg.getCorpo().getLoteGuias().getGuias().getGuiaFaturamento().getGuiaSP_SADT() == null) {
			listaGs = null;
		} else {
			listaGs = msg.getCorpo().getLoteGuias().getGuias().getGuiaFaturamento().getGuiaSP_SADT();
		}
		int i = 0;
		if (listaGs == null) {
			fes.setFaturas(null);
		} else {
			for (GuiaSP_SADTTO sp : listaGs) {
				fe = new FaturaExameSGBTO();
				if (listaGs.get(i).getDadosSolicitante() != null) {
					if (listaGs.get(i).getDadosSolicitante().getContratado() != null) {
						if (listaGs.get(i).getDadosSolicitante().getContratado().getIdentificacao() != null) {
							if (listaGs.get(i).getDadosSolicitante().getContratado().getIdentificacao().getConselhoProfissional() != null) {
								if (listaGs.get(i).getDadosSolicitante().getContratado().getIdentificacao().getConselhoProfissional().getSiglaConselho() != null) {
									fe.setCdTipoConselho(listaGs.get(i).getDadosSolicitante().getContratado().getIdentificacao().getConselhoProfissional().getSiglaConselho());
								} else {
									fe.setCdTipoConselho("");
								}
								if (listaGs.get(i).getDadosSolicitante().getContratado().getIdentificacao().getConselhoProfissional().getUfConselho() != null) {
									fe.setCdUfCrm(listaGs.get(i).getDadosSolicitante().getContratado().getIdentificacao().getConselhoProfissional().getUfConselho());
								} else {
									fe.setCdUfCrm("");
								}
								if (listaGs.get(i).getDadosSolicitante().getProfissional().getConselhoProfissional().getNumeroConselho() != null) {
									fe.setNumcrm(listaGs.get(i).getDadosSolicitante().getProfissional().getConselhoProfissional().getNumeroConselho());
								} else {
									fe.setNumcrm("");
								}
							} else {
								fe.setCdTipoConselho("");
								fe.setCdUfCrm("");
								fe.setNumcrm("");
							}
						} else {
							fe.setCdTipoConselho("");
							fe.setCdUfCrm("");
							fe.setNumcrm("");
						}
					} else {
						fe.setCdTipoConselho("");
						fe.setCdUfCrm("");
						fe.setNumcrm("");
					}
				} else {
					fe.setCdTipoConselho("");
					fe.setCdUfCrm("");
					fe.setNumcrm("");
				}
				if (listaGs.get(i).getTipoSaida() == null) {
					fe.setCdTipoSaida((long)5);
				} else {
					fe.setCdTipoSaida(Long.parseLong(listaGs.get(i).getTipoSaida()));
				}
				fe.setCoddpd(null);
				fe.setCodemppan(null);
				fe.setCodemppln(null);
				if (listaGs.get(i).getDiagnosticoAtendimento() != null) {
					if (listaGs.get(i).getDiagnosticoAtendimento().getCid() != null) {
						if (listaGs.get(i).getDiagnosticoAtendimento().getCid().getCodigoDiagnostico() != null) {
							fe.setCoditidoe(listaGs.get(i).getDiagnosticoAtendimento().getCid().getCodigoDiagnostico());
						} else {
							fe.setCoditidoe("");
						}
					} else {
						fe.setCoditidoe("");
					}
				} else {
					fe.setCoditidoe("");
				}
				fe.setCodplncop(null);
				if (listaGs.get(i).getDataHoraAtendimento() != null) {
					String dtaatn = AjustaData(listaGs.get(i).getDataHoraAtendimento());
					fe.setDtaatn(dtaatn);
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE ATENDIMENTO.");
					return null;
				}
				if (listaGs.get(i).getIdentificacaoGuiaSADTSP() != null) {
					if (listaGs.get(i).getIdentificacaoGuiaSADTSP().getDataEmissaoGuia() != null) {
						String dtemissaoguia = AjustaData(listaGs.get(i).getIdentificacaoGuiaSADTSP().getDataEmissaoGuia());
						fe.setDtEmissaoGuia(dtemissaoguia);
					} else {
						JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE EMISSÃO.");
						return null;
					}
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nGUIAS SEM DATA DE EMISSÃO.");
					return null;
				}
				fe.setDtInclusao("GETDATE()");
				if (listaGs.get(i).getDiagnosticoAtendimento() != null) {
					if (listaGs.get(i).getDiagnosticoAtendimento().getIndicadorAcidente() == null) {
						fe.setIdAcidente("");
					} else {
						fe.setIdAcidente(listaGs.get(i).getDiagnosticoAtendimento().getIndicadorAcidente());
					}
				} else {
					fe.setIdAcidente("");
				}
				if (listaGs.get(i).getDiagnosticoAtendimento() != null) {
					if (listaGs.get(i).getDiagnosticoAtendimento().getTempoReferidoEvolucaoDoenca() != null) {
						if (listaGs.get(i).getDiagnosticoAtendimento().getTempoReferidoEvolucaoDoenca().getUnidadeTempo() != null) {
							fe.setIdTempoDoenca(listaGs.get(i).getDiagnosticoAtendimento().getTempoReferidoEvolucaoDoenca().getUnidadeTempo());
						} else {
							fe.setIdTempoDoenca("");
						}
					} else {
						fe.setIdTempoDoenca("");
					}
				} else {
					fe.setIdTempoDoenca("");
				}
				if (listaGs.get(i).getTipoAtendimento() == null) {
					fe.setIdTipoAtendimento((long)5);
				} else {
					fe.setIdTipoAtendimento(Long.parseLong(listaGs.get(i).getTipoAtendimento()));
				}
				if (listaGs.get(i).getDiagnosticoAtendimento() != null) {
					if (listaGs.get(i).getDiagnosticoAtendimento().getTipoDoenca() != null) {
						fe.setIdTipoDoenca(listaGs.get(i).getDiagnosticoAtendimento().getTipoDoenca());
					} else {
						fe.setIdTipoDoenca("");
					}
				} else {
					fe.setIdTipoDoenca("");
				}
				fe.setIndcpgcgc(null);
				fe.setIndusu(null);
				if (listaGs.get(i).getDadosSolicitante() != null) {
					if (listaGs.get(i).getDadosSolicitante().getContratado() != null) {
						if (listaGs.get(i).getDadosSolicitante().getContratado().getNomeContratado() != null) {
							fe.setNmContratado(listaGs.get(i).getDadosSolicitante().getContratado().getNomeContratado());
						} else {
							fe.setNmContratado("");
						}
					} else {
						fe.setNmContratado("");
					}
				} else {
					fe.setNmContratado("");
				}
				if (listaGs.get(i).getDadosSolicitante() != null) {
					if (listaGs.get(i).getDadosSolicitante().getProfissional() != null) {
						if (listaGs.get(i).getDadosSolicitante().getProfissional().getNomeProfissional() != null) {
							fe.setNmMedicoProfissional(listaGs.get(i).getDadosSolicitante().getProfissional().getNomeProfissional());
						} else {
							fe.setNmMedicoProfissional("");
						}
					} else {
						fe.setNmMedicoProfissional("");
					}
				} else {
					fe.setNmMedicoProfissional("");
				}
				if (listaGs.get(i).getIdentificacaoGuiaSADTSP() != null) {
					if (listaGs.get(i).getIdentificacaoGuiaSADTSP().getNumeroGuiaPrestador() != null) {
						fe.setNuGuiaAtendimentoHospital(listaGs.get(i).getIdentificacaoGuiaSADTSP().getNumeroGuiaPrestador());
					} else {
						fe.setNuGuiaAtendimentoHospital("");
					}
					if (listaGs.get(i).getIdentificacaoGuiaSADTSP().getNumeroGuiaOperadora() != null) {
						fe.setNuGuiaComplemento(listaGs.get(i).getIdentificacaoGuiaSADTSP().getNumeroGuiaOperadora());
					} else {
						fe.setNuGuiaComplemento("");
					}
				} else {
					fe.setNuGuiaAtendimentoHospital("");
					fe.setNuGuiaComplemento("");
				}
				fe.setNumauopcdmdc(null);
				if (listaGs.get(i).getPrestadorExecutante() != null) {
					if (listaGs.get(i).getPrestadorExecutante().getIdentificacao() != null) {
						if (listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCnpj() == null) {
							if (listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCpf() == null) {
								if (listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCodigoPrestadorNaOperadora() == null) {
									fe.setNumcpfcgccri(null);
									fe.setNumcpfcgccriContratado(null);
								} else {
									fe.setNumcpfcgccri(listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCodigoPrestadorNaOperadora());
									fe.setNumcpfcgccriContratado(listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCodigoPrestadorNaOperadora());
								}
							} else {
								fe.setNumcpfcgccri(listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCpf());
								fe.setNumcpfcgccriContratado(listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCpf());
							}	
						} else {
							fe.setNumcpfcgccri(listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCnpj());
							fe.setNumcpfcgccriContratado(listaGs.get(i).getPrestadorExecutante().getIdentificacao().getCnpj());
						}
					} else {
						fe.setNumcpfcgccri(null);
						fe.setNumcpfcgccriContratado(null);
					}
				} else {
					fe.setNumcpfcgccri(null);
					fe.setNumcpfcgccriContratado(null);
				}
				fe.setNumfat(null);
				fe.setNumtiu(listaGs.get(i).getDadosBeneficiario().getNumeroCateira());
				if (listaGs.get(i).getDiagnosticoAtendimento() != null) {
					if (listaGs.get(i).getDiagnosticoAtendimento().getTempoReferidoEvolucaoDoenca() != null) {
						if (listaGs.get(i).getDiagnosticoAtendimento().getTempoReferidoEvolucaoDoenca().getValor() != null) {
							fe.setNuTempoDoenca(Long.parseLong(listaGs.get(i).getDiagnosticoAtendimento().getTempoReferidoEvolucaoDoenca().getValor()));
						} else {
							fe.setNuTempoDoenca((long)0);
						}
					} else {
						fe.setNuTempoDoenca((long)0);
					}
				} else {
					fe.setNuTempoDoenca((long)0);
				}
				if (listaGs.get(i).getObservacao() == null) {
					fe.setObsfat("");
				} else {
					fe.setObsfat(listaGs.get(i).getObservacao());
				}
				fe.setValdpsexr(0.0);
				fe.setValtotgls(0.0);
				fe.setValtotgro(0.0);
				fe.setValtotinr(0.0);
				fe.setValtotpln(0.0);
				fe.setValtotusu(0.0);
				listaFie = new ArrayList<FaturaItemExameSGBTO>();
				listaPro = new ArrayList<ProcedimentosTO>();
				listaPro = listaGs.get(i).getProcedimentosRealizados().getProcedimentos();
				int j = 0;
				for (ProcedimentosTO pro : listaPro) {
					fie = new FaturaItemExameSGBTO();
					fie.setCdEspecAssociada(null);
					fie.setCdGlosa(null);
					fie.setCoditefat((long)1);
					if (listaPro.get(j).getProcedimento() != null) {
						if (listaPro.get(j).getProcedimento().getTipoTabela() != null) {
							fie.setCodtiptab(Long.parseLong(listaPro.get(j).getProcedimento().getTipoTabela()));
						} else {
							fie.setCodtiptab(null);
						}
					} else {
						fie.setCodtiptab(null);
					}
					fie.setDtaatl("GETDATE()");
					String dat = AjustaData(listaPro.get(j).getData());
					fie.setDtaatn(dat);
					fie.setDtIncusaoItem("GETDATE()");
					fie.setIndtipite(null);
					if (listaPro.get(j).getProcedimento() != null) {
						if (listaPro.get(j).getProcedimento().getCodigo() != null) {
							fie.setNuBeneficio(Long.parseLong(listaPro.get(j).getProcedimento().getCodigo()));
						} else {
							fie.setNuBeneficio(null);
						}
					} else {
						fie.setNuBeneficio(null);
					}
					if (msg.getCorpo().getLoteGuias() != null) {
						if (msg.getCorpo().getLoteGuias().getNumeroLote() != null) {
							fie.setNuLoteTiss(msg.getCorpo().getLoteGuias().getNumeroLote());
						} else {
							fie.setNuLoteTiss((long)0);
						}
					} else {
						fie.setNuLoteTiss((long)0);
					}
					fie.setNumfat(null);
					if (msg.getCabecalho() != null) {
						if (msg.getCabecalho().getIdentificacaoTransacao() != null) {
							if (msg.getCabecalho().getIdentificacaoTransacao().getSequencialTransacao() != null) {
								fie.setNuProtocoloTiss(msg.getCabecalho().getIdentificacaoTransacao().getSequencialTransacao());
							} else {
								fie.setNuProtocoloTiss((long)0);
							}
						} else {
							fie.setNuProtocoloTiss((long)0);
						}
					} else {
						fie.setNuProtocoloTiss((long)0);
					}
					if (listaPro.get(j).getQuantidadeRealizada() == null) {
						fie.setQteite((long)1);
					} else {
						fie.setQteite(listaPro.get(j).getQuantidadeRealizada());
					}
					fie.setVaBaseCalculoImposto(0.0);
					fie.setValdpsexr(0.0);
					fie.setValgls(0.0);
					fie.setValite(0.0);
					fie.setValplnite(0.0);
					if (listaPro.get(j).getValorTotal() == null) {
						fie.setValpre(0.0);
					} else {
						fie.setValpre(listaPro.get(j).getValorTotal());
					}
					fie.setValusuite(0.0);
					fie.setVaProcedimentoChUso(0.0);
					if (listaPro.get(j).getReducaoAcrescimo() == null) {
						fie.setVaPercProced(100.0);
					} else if (listaPro.get(j).getReducaoAcrescimo() < 100.0f) {
						fie.setVaPercProced(100.0);
					} else {
						fie.setVaPercProced(listaPro.get(j).getReducaoAcrescimo());
					}
					listaFie.add(fie);
					j++;
				}
				fe.setItens(listaFie);
				listaFe.add(fe);
				i++;
			}
			fes.setFaturas(listaFe);
		}
		return fes;
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
