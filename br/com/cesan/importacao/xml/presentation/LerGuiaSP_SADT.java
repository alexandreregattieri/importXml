package br.com.cesan.importacao.xml.presentation;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.common.BeneficiarioTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.CabecalhoGuiaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.ConselhoProfissionalTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.DiagnosticoAtendimentoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.DiagnosticoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.EnderecoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoFontePagadoraTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoPrestadorExecutanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoProfissionalTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.TempoEvolucaoDoencaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaSP_SADTTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.AutorizacaoGuiaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ContratadoSolicitanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.DespesaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.IdentificacaoEquipeTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.IdentificacaoOPMTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.IdentificacaoPrestadorEquipeTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.IdentificacaoPrestadorTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.MembroEquipeTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.OPMUtilizadaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.OpmTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.OutrasDespesasTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.PrestadorExecutanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ProcedimentoRealizadoEquipeTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ProcedimentosTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ProfissionalExecutanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.SolicitanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.TabelaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.spsadt.ValorTotalServicosTO;

public class LerGuiaSP_SADT {

	public GuiaSP_SADTTO getGuiaSPSADT (Element elm) {
		GuiaSP_SADTTO guia = new GuiaSP_SADTTO();
		CabecalhoGuiaTO cab = new CabecalhoGuiaTO();
		AutorizacaoGuiaTO aut = new AutorizacaoGuiaTO();
		BeneficiarioTO benef = new BeneficiarioTO();
		SolicitanteTO sol = new SolicitanteTO();
		ValorTotalServicosTO vts = new ValorTotalServicosTO();
		PrestadorExecutanteTO pe = new PrestadorExecutanteTO();
		OPMUtilizadaTO out = new OPMUtilizadaTO();
		OutrasDespesasTO desp = new OutrasDespesasTO();
		ProcedimentoRealizadoEquipeTO pre = new ProcedimentoRealizadoEquipeTO();
		DiagnosticoAtendimentoTO da = new DiagnosticoAtendimentoTO();
		NodeList nl = elm.getElementsByTagName("ans:identificacaoGuiaSADTSP");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacaoGuiaSADTSP");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cab.setIdentificacaoFontePagadora(null);
				cab.setDataEmissaoGuia(null);
				cab.setNumeroGuiaPrestador(null);
				cab.setNumeroGuiaOperadora(null);
			} else {
				cab = this.getIdentifGuiaSPSADT(el);
			}
		} else {
			cab = this.getIdentifGuiaSPSADT(el);
		}
		guia.setIdentificacaoGuiaSADTSP(cab);
		nl = elm.getElementsByTagName("ans:numeroGuiaPrincipal");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroGuiaPrincipal");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setNumeroGuiaPrincipal(null);
			} else {
				guia.setNumeroGuiaPrincipal(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setNumeroGuiaPrincipal(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:dadosAutorizacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dadosAutorizacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				aut.setDataAutorizacao(null);
				aut.setSenhaAutorizacao(null);
				aut.setValidadeSenha(null);
			} else {
				aut = this.getAutGuia(el);
			}
		} else {
			aut = this.getAutGuia(el);
		}
		guia.setDadosAutorizacao(aut);
		nl = elm.getElementsByTagName("ans:dadosBeneficiario");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dadosBeneficiario");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setNumeroCateira(null);
				benef.setNomeBeneficicario(null);
				benef.setNomePlano(null);
				benef.setValidadeCarteira(null);
				benef.setNumeroCNS(null);
				benef.setIdentificadorBeneficiario(null);
			} else {
				benef = this.getBeneficiario(el);
			}
		} else {
			benef = this.getBeneficiario(el);
		}
		guia.setDadosBeneficiario(benef);
		nl = elm.getElementsByTagName("ans:dadosSolicitante");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dadosSolicitante");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				sol.setContratado(null);
				sol.setProfissional(null);
			} else {
				sol = this.getDadosSolicitante(el);
			}
		} else {
			sol = this.getDadosSolicitante(el);
		}
		guia.setDadosSolicitante(sol);
		nl = elm.getElementsByTagName("ans:prestadorExecutante");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:prestadorExecutante");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pe.setIdentificacao(null);
				pe.setNomeContratado(null);
				pe.setEnderecoContratado(null);
				pe.setNumeroCNES(null);
				pe.setProfissionalExecutanteCompl(null);
			} else {
				pe = this.getPrestExecutante(el);
			}
		} else {
			pe = this.getPrestExecutante(el);
		}
		guia.setPrestadorExecutante(pe);
		nl = elm.getElementsByTagName("ans:indicacaoClinica");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:indicacaoClinica");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setIdicacaoClinica(null);
			} else {
				guia.setIdicacaoClinica(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setIdicacaoClinica(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:caraterAtendimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:caraterAtendimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setCaraterAtendimento(null);
			} else {
				guia.setCaraterAtendimento(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setCaraterAtendimento(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:dataHoraAtendimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dataHoraAtendimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setDataHoraAtendimento(null);
			} else {
				guia.setDataHoraAtendimento(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setDataHoraAtendimento(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:diagnosticoAtendimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:diagnosticoAtendimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				da.setCid(null);
				da.setTipoDoenca(null);
				da.setTempoReferidoEvolucaoDoenca(null);
				da.setIndicadorAcidente(null);
			} else {
				da = this.getHipotDiag(el);
			}
		} else {
			da = this.getHipotDiag(el);
		}
		guia.setDiagnosticoAtendimento(da);
		nl = elm.getElementsByTagName("ans:tipoSaida");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoSaida");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setTipoSaida(null);
			} else {
				guia.setTipoSaida(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setTipoSaida(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:tipoAtendimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoAtendimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setTipoAtendimento(null);
			} else {
				guia.setTipoAtendimento(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setTipoAtendimento(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:procedimentosRealizados");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:procedimentosRealizados");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pre.setProcedimentos(null);
			} else {
				pre = this.getProcEquipe(el);
			}
		} else {
			pre = this.getProcEquipe(el);
		}
		guia.setProcedimentosRealizados(pre);
		nl = elm.getElementsByTagName("ans:outrasDespesas");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:outrasDespesas");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setDespesa(null);
			} else {
				desp = this.getOutrasDesp(el);
			}
		} else {
			desp = this.getOutrasDesp(el);
		}
		guia.setOutrasDespesas(desp);
		nl = elm.getElementsByTagName("ans:OPMUtilizada");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:OPMUtilizada");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				out.setOpm(null);
				out.setValorTotalOPM(null);
			} else {
				out = this.getOPMUtiliz(el);
			}
		} else {
			out = this.getOPMUtiliz(el);
		}
		guia.setOpmUtilizada(out);
		nl = elm.getElementsByTagName("ans:valorTotal");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valorTotal");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setServicosExecutados(null);
				vts.setDiarias(null);
				vts.setTaxas(null);
				vts.setMateriais(null);
				vts.setMedicamentos(null);
				vts.setGases(null);
				vts.setTotalGeral(null);
			} else {
				vts = this.getValorTotal(el);
			}
		} else {
			vts = this.getValorTotal(el);
		}
		guia.setValorTotal(vts);
		nl = elm.getElementsByTagName("ans:observacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:observacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guia.setObservacao(null);
			} else {
				guia.setObservacao(el.getFirstChild().getNodeValue());
			}
		} else {
			guia.setObservacao(el.getFirstChild().getNodeValue());
		}
		return guia;
	}
	
	private CabecalhoGuiaTO getIdentifGuiaSPSADT (Element elm) {
		CabecalhoGuiaTO cab = new CabecalhoGuiaTO();
		IdentificacaoFontePagadoraTO ip = new IdentificacaoFontePagadoraTO();
		NodeList nl = elm.getElementsByTagName("ans:identificacaoFontePagadora");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacaoFontePagadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setRegistroANS(null);
				ip.setCnpjFontePagadora(null);
			} else {
				ip = this.getIdetifFontPag(el);
			}
		} else {
			ip = this.getIdetifFontPag(el);
		}
		cab.setIdentificacaoFontePagadora(ip);
		nl = elm.getElementsByTagName("ans:dataEmissaoGuia");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dataEmissaoGuia");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cab.setDataEmissaoGuia(null);
			} else {
				cab.setDataEmissaoGuia(el.getFirstChild().getNodeValue());
			}
		} else {
			cab.setDataEmissaoGuia(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:numeroGuiaPrestador");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroGuiaPrestador");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cab.setNumeroGuiaPrestador(null);
			} else {
				cab.setNumeroGuiaPrestador(el.getFirstChild().getNodeValue());
			}
		} else {
			cab.setNumeroGuiaPrestador(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:numeroGuiaOperadora");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroGuiaOperadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cab.setNumeroGuiaOperadora(null);
			} else {
				cab.setNumeroGuiaOperadora(el.getFirstChild().getNodeValue());
			}
		} else {
			cab.setNumeroGuiaOperadora(el.getFirstChild().getNodeValue());
		}
		return cab;
	}
	
	
	private IdentificacaoFontePagadoraTO getIdetifFontPag (Element elm) {
		IdentificacaoFontePagadoraTO ip = new IdentificacaoFontePagadoraTO();
		NodeList nl = elm.getElementsByTagName("ans:registroANS");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:registroANS");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setRegistroANS(null);
			} else {
				ip.setRegistroANS(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setRegistroANS(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:cnpjFontePagadora");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cnpjFontePagadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setCnpjFontePagadora(null);
			} else {
				ip.setCnpjFontePagadora(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setCnpjFontePagadora(el.getFirstChild().getNodeValue());
		}
		return ip;
	}
	
	
	private AutorizacaoGuiaTO getAutGuia (Element elm) {
		AutorizacaoGuiaTO aut = new AutorizacaoGuiaTO();
		NodeList nl = elm.getElementsByTagName("ans:dataAutorizacao");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dataAutorizacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				aut.setDataAutorizacao(null);
			} else {
				aut.setDataAutorizacao(el.getFirstChild().getNodeValue());
			}
		} else {
			aut.setDataAutorizacao(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:senhaAutorizacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:senhaAutorizacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				aut.setSenhaAutorizacao(null);
			} else {
				aut.setSenhaAutorizacao(el.getFirstChild().getNodeValue());
			}
		} else {
			aut.setSenhaAutorizacao(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:validadeSenha");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:validadeSenha");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				aut.setValidadeSenha(null);
			} else {
				aut.setValidadeSenha(el.getFirstChild().getNodeValue());
			}
		} else {
			aut.setValidadeSenha(el.getFirstChild().getNodeValue());
		}
		return aut;
	}
	
	
	private BeneficiarioTO getBeneficiario(Element elm) {
		BeneficiarioTO benef = new BeneficiarioTO();
		NodeList nl = elm.getElementsByTagName("ans:numeroCarteira");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroCarteira");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setNumeroCateira(null);
			} else {
				benef.setNumeroCateira(el.getFirstChild().getNodeValue());
			}
		} else {
			benef.setNumeroCateira(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:nomeBeneficiario");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeBeneficiario");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setNomeBeneficicario(null);
			} else {
				benef.setNomeBeneficicario(el.getFirstChild().getNodeValue());
			}
		} else {
			benef.setNomeBeneficicario(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:nomePlano");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomePlano");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setNomePlano(null);
			} else {
				benef.setNomePlano(el.getFirstChild().getNodeValue());
			}
		} else {
			benef.setNomePlano(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:validadeCarteira");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:validadeCarteira");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setValidadeCarteira(null);
			} else {
				benef.setValidadeCarteira(el.getFirstChild().getNodeValue());
			}
		} else {
			benef.setValidadeCarteira(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:numeroCNS");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroCNS");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setNumeroCNS(null);
			} else {
				benef.setNumeroCNS(el.getFirstChild().getNodeValue());
			}
		} else {
			benef.setNumeroCNS(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:identificadorBeneficiario");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificadorBeneficiario");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				benef.setIdentificadorBeneficiario(null);
			} else {
				benef.setIdentificadorBeneficiario(el.getFirstChild().getNodeValue());
			}
		} else {
			benef.setIdentificadorBeneficiario(el.getFirstChild().getNodeValue());
		}
		return benef;
	}
	
	
	private EnderecoTO getEndereco (Element elm) {
		EnderecoTO end = new EnderecoTO();
		NodeList nl = elm.getElementsByTagName("ans:tipoLogradouro");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoLogradouro");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setTipoLogradouro(null);
			} else {
				end.setTipoLogradouro(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setTipoLogradouro(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:logradouro");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:logradouro");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setLogradouro(null);
			} else {
				end.setLogradouro(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setLogradouro(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:numero");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numero");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setNumero(null);
			} else {
				end.setNumero(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setNumero(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:complemento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:complemento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setComplemento(null);
			} else {
				end.setComplemento(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setComplemento(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoIBGEMunicipio");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoIBGEMunicipio");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setCodigoIBGEMunicipio(null);
			} else {
				end.setCodigoIBGEMunicipio(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setCodigoIBGEMunicipio(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:municipio");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:municipio");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setMunicipio(null);
			} else {
				end.setMunicipio(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setMunicipio(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoUF");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoUF");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setCodigoUF(null);
			} else {
				end.setCodigoUF(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setCodigoUF(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:cep");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cep");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setCep(null);
			} else {
				end.setCep(el.getFirstChild().getNodeValue());
			}
		} else {
			end.setCep(el.getFirstChild().getNodeValue());
		}
		return end;
	}
	
	
	private ConselhoProfissionalTO getConselho (Element elm) {
		ConselhoProfissionalTO cp = new ConselhoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:siglaConselho");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:siglaConselho");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setSiglaConselho(null);
			} else {
				cp.setSiglaConselho(el.getFirstChild().getNodeValue());
			}
		} else {
			cp.setSiglaConselho(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:numeroConselho");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroConselho");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setNumeroConselho(null);
			} else {
				cp.setNumeroConselho(el.getFirstChild().getNodeValue());
			}
		} else {
			cp.setNumeroConselho(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:ufConselho");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:ufConselho");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setUfConselho(null);
			} else {
				cp.setUfConselho(el.getFirstChild().getNodeValue());
			}
		} else {
			cp.setUfConselho(el.getFirstChild().getNodeValue());
		}
		return cp;
	}
	
	
	private IdentificacaoProfissionalTO getProfExecutante(Element elm) {
		IdentificacaoProfissionalTO ip = new IdentificacaoProfissionalTO();
		ConselhoProfissionalTO cp = new ConselhoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:nomeProfissional");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setNomeProfissional(null);
			} else {
				ip.setNomeProfissional(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setNomeProfissional(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:conselhoProfissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:conselhoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setSiglaConselho(null);
				cp.setNumeroConselho(null);
				cp.setUfConselho(null);
			} else {
				cp = this.getConselho(el);
			}
		} else {
			cp = this.getConselho(el);
		}
		ip.setConselhoProfissional(cp);
		nl = elm.getElementsByTagName("ans:cbos");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cbos");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setCbos(null);
			} else {
				ip.setCbos(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setCbos(el.getFirstChild().getNodeValue());
		}
		return ip;
	}
	

	private IdentificacaoPrestadorTO getIdentifPrestador(Element elm) {
		IdentificacaoPrestadorTO ip = new IdentificacaoPrestadorTO();
		ConselhoProfissionalTO cp = new ConselhoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:CNPJ");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:CNPJ");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setCnpj(null);
			} else {
				ip.setCnpj(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setCnpj(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:CPF");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:CPF");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setCpf(null);
			} else {
				ip.setCpf(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setCpf(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoPrestadorNaOperadora");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoPrestadorNaOperadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setCodigoPrestadorNaOperadora(null);
			} else {
				ip.setCodigoPrestadorNaOperadora(el.getFirstChild().getNodeValue());
			}
		} else {
			ip.setCodigoPrestadorNaOperadora(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:conselhoProfissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:conselhoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setSiglaConselho(null);
				cp.setNumeroConselho(null);
				cp.setUfConselho(null);
			} else {
				cp = this.getConselho(el);
			}
		} else {
			cp = this.getConselho(el);
		}
		ip.setConselhoProfissional(cp);
		return ip;
	}
	

	private ContratadoSolicitanteTO getContratado (Element elm) {
		ContratadoSolicitanteTO cs = new ContratadoSolicitanteTO();
		IdentificacaoPrestadorTO ip = new IdentificacaoPrestadorTO();
		EnderecoTO end = new EnderecoTO();
		NodeList nl = elm.getElementsByTagName("ans:identificacao");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setCpf(null);
				ip.setCnpj(null);
				ip.setCodigoPrestadorNaOperadora(null);
				ip.setConselhoProfissional(null);
			} else {
				ip = this.getIdentifPrestador(el);
			}
		} else {
			ip = this.getIdentifPrestador(el);
		}
		cs.setIdentificacao(ip);
		nl = elm.getElementsByTagName("ans:nomeContratado");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeContratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cs.setNomeContratado(null);
			} else {
				cs.setNomeContratado(el.getFirstChild().getNodeValue());
			}
		} else {
			cs.setNomeContratado(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:enderecoContratado");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:enderecoContratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setTipoLogradouro(null);
				end.setLogradouro(null);
				end.setNumero(null);
				end.setComplemento(null);
				end.setCodigoIBGEMunicipio(null);
				end.setMunicipio(null);
				end.setCodigoUF(null);
				end.setCep(null);
			} else {
				end = this.getEndereco(el);
			}
		} else {
			end = this.getEndereco(el);
		}
		cs.setEnderecoContratado(end);
		nl = elm.getElementsByTagName("ans:numeroCNES");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroCNES");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cs.setNumeroCNES(null);
			} else {
				cs.setNumeroCNES(el.getFirstChild().getNodeValue());
			}
		} else {
			cs.setNumeroCNES(el.getFirstChild().getNodeValue());
		}
		return cs;
	}
	

	private SolicitanteTO getDadosSolicitante (Element elm) {
		SolicitanteTO sol = new SolicitanteTO();
		ContratadoSolicitanteTO cs = new ContratadoSolicitanteTO();
		IdentificacaoProfissionalTO ip = new IdentificacaoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:contratado");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:contratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cs.setIdentificacao(null);
				cs.setNomeContratado(null);
				cs.setEnderecoContratado(null);
				cs.setNumeroCNES(null);
			} else {
				cs = this.getContratado(el);
			}
		} else {
			cs = this.getContratado(el);
		}
		sol.setContratado(cs);
		nl = elm.getElementsByTagName("ans:profissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:profissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setNomeProfissional(null);
				ip.setConselhoProfissional(null);
				ip.setCbos(null);
			} else {
				ip = this.getProfExecutante(el);
			}
		} else {
			ip = this.getProfExecutante(el);
		}
		sol.setProfissional(ip);
		return sol;
	}
	

	private IdentificacaoPrestadorExecutanteTO getIdenPrestExec(Element elm) {
		IdentificacaoPrestadorExecutanteTO ipe = new IdentificacaoPrestadorExecutanteTO();
		NodeList nl = elm.getElementsByTagName("ans:CNPJ");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:CNPJ");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCnpj(null);
			} else {
				ipe.setCnpj(el.getFirstChild().getNodeValue());
			}
		} else {
			ipe.setCnpj(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:CPF");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:CPF");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCpf(null);
			} else {
				ipe.setCpf(el.getFirstChild().getNodeValue());
			}
		} else {
			ipe.setCpf(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoPrestadorNaOperadora");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoPrestadorNaOperadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCodigoPrestadorNaOperadora(null);
			} else {
				ipe.setCodigoPrestadorNaOperadora(el.getFirstChild().getNodeValue());
			}
		} else {
			ipe.setCodigoPrestadorNaOperadora(el.getFirstChild().getNodeValue());
		}
		return ipe;
	}
	

	private PrestadorExecutanteTO getPrestExecutante(Element elm) {
		PrestadorExecutanteTO pe = new PrestadorExecutanteTO();
		IdentificacaoPrestadorExecutanteTO ipe = new IdentificacaoPrestadorExecutanteTO();
		EnderecoTO end = new EnderecoTO();
		IdentificacaoProfissionalTO ip = new IdentificacaoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:identificacao");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCnpj(null);
				ipe.setCpf(null);
				ipe.setCodigoPrestadorNaOperadora(null);
			} else {
				ipe = this.getIdenPrestExec(el);
			}
		} else {
			ipe = this.getIdenPrestExec(el);
		}
		pe.setIdentificacao(ipe);
		nl = elm.getElementsByTagName("ans:nomeContratado");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeContratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pe.setNomeContratado(el.getFirstChild().getNodeValue());
			} else {
				pe.setNomeContratado(null);
			}
		} else {
			pe.setNomeContratado(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:enderecoContratado");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:enderecoContratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				end.setTipoLogradouro(null);
				end.setLogradouro(null);
				end.setNumero(null);
				end.setComplemento(null);
				end.setCodigoIBGEMunicipio(null);
				end.setMunicipio(null);
				end.setCodigoUF(null);
				end.setCep(null);
			} else {
				end = this.getEndereco(el);
			}
		} else {
			end = this.getEndereco(el);
		}
		pe.setEnderecoContratado(end);
		nl = elm.getElementsByTagName("ans:numeroCNES");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroCNES");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pe.setNumeroCNES(null);
			} else {
				pe.setNumeroCNES(el.getFirstChild().getNodeValue());
			}
		} else {
			pe.setNumeroCNES(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:profissionalExecutanteCompl");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:profissionalExecutanteCompl");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ip.setNomeProfissional(null);
				ip.setConselhoProfissional(null);
				ip.setCbos(null);
			} else {
				ip = this.getProfExecutante(el);
			}
		} else {
			ip = this.getProfExecutante(el);
		}
		pe.setProfissionalExecutanteCompl(ip);
		return pe;
	}
	

	private ValorTotalServicosTO getValorTotal (Element elm) {
		ValorTotalServicosTO vts = new ValorTotalServicosTO();
		NodeList nl = elm.getElementsByTagName("ans:servicosExecutados");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:servicosExecutados");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setServicosExecutados(null);
			} else {
				vts.setServicosExecutados(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setServicosExecutados(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:diarias");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:diarias");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setDiarias(null);
			} else {
				vts.setDiarias(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setDiarias(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:taxas");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:taxas");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setTaxas(null);
			} else {
				vts.setTaxas(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setTaxas(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:materiais");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:materiais");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setMateriais(null);
			} else {
				vts.setMateriais(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setMateriais(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:medicamentos");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:medicamentos");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setMedicamentos(null);
			} else {
				vts.setMedicamentos(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setMedicamentos(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:gases");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:gases");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setGases(null);
			} else {
				vts.setGases(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setGases(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:totalGeral");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:totalGeral");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				vts.setTotalGeral(null);
			} else {
				vts.setTotalGeral(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			vts.setTotalGeral(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		return vts;
	}
	

	private TabelaTO getTabela (Element elm) {
		TabelaTO tab = new TabelaTO();
		NodeList nl = elm.getElementsByTagName("ans:codigo");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigo");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				tab.setCodigo(null);
			} else {
				tab.setCodigo(el.getFirstChild().getNodeValue());
			}
		} else {
			tab.setCodigo(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:tipoTabela");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoTabela");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				tab.setTipoTabela(null);
			} else {
				tab.setTipoTabela(el.getFirstChild().getNodeValue());
			}
		} else {
			tab.setTipoTabela(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:descricao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:descricao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				tab.setDescricao(null);
			} else {
				tab.setDescricao(el.getFirstChild().getNodeValue());
			}
		} else {
			tab.setDescricao(el.getFirstChild().getNodeValue());
		}
		return tab;
	}
	
	private IdentificacaoOPMTO getIdentifOPM (Element elm) {
		IdentificacaoOPMTO io = new IdentificacaoOPMTO();
		TabelaTO tab = new TabelaTO();
		NodeList nl = elm.getElementsByTagName("ans:OPM");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:OPM");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				tab.setCodigo(null);
				tab.setTipoTabela(null);
				tab.setDescricao(null);
			} else {
				tab = this.getTabela(el);
			}
		} else {
			tab = this.getTabela(el);
		}
		io.setOpm(tab);
		nl = elm.getElementsByTagName("ans:quantidade");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:quantidade");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				io.setQuantidade(null);
			} else {
				io.setQuantidade(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			io.setQuantidade(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:codigoBarra");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoBarra");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				io.setCodigoBarra(null);
			} else {
				io.setCodigoBarra(el.getFirstChild().getNodeValue());
			}
		} else {
			io.setCodigoBarra(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:valorUnitario");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valorUnitario");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				io.setValorUnitario(null);
			} else {
				io.setValorUnitario(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			io.setValorUnitario(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:valorTotal");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ans:valorTotal");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				io.setValorTotal(null);
			} else {
				io.setValorTotal(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			io.setValorTotal(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		return io;
	}
	
	private OpmTO getOPM (Element elm) {
		OpmTO opm = new OpmTO();
		IdentificacaoOPMTO id = null;
		List<IdentificacaoOPMTO> lista = new ArrayList<IdentificacaoOPMTO>();
		NodeList nl = elm.getElementsByTagName("ans:identificacaoOPM");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacaoOPM");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				lista = null;
			} else {
				for (int i = 0; i < nl.getLength(); i++) {
					Element eml = (Element)nl.item(i);
					id = new IdentificacaoOPMTO();
					id = this.getIdentifOPM(eml);
					lista.add(id);
				}
			}
		} else {
			for (int i = 0; i < nl.getLength(); i++) {
				Element eml = (Element)nl.item(i);
				id = new IdentificacaoOPMTO();
				id = this.getIdentifOPM(eml);
				lista.add(id);
			}
		}
		opm.setIdentificacaoOpm(lista);
		return opm;
	}
	
	private OPMUtilizadaTO getOPMUtiliz (Element elm){
		OPMUtilizadaTO out = new OPMUtilizadaTO();
		OpmTO opm = new OpmTO();
		NodeList nl = elm.getElementsByTagName("ans:OPM");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:OPM");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				opm.setIdentificacaoOpm(null);
			} else {
				opm = this.getOPM(el);
			}
		} else {
			opm = this.getOPM(el);
		}
		out.setOpm(opm);
		nl = elm.getElementsByTagName("ans:valorTotalOPM");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valorTotalOPM");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				out.setValorTotalOPM(null);
			} else {
				out.setValorTotalOPM(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			out.setValorTotalOPM(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		return out;
	}
	
	private DespesaTO getDespesa (Element elm) {
		DespesaTO desp = new DespesaTO();
		TabelaTO tab = new TabelaTO();
		NodeList nl = elm.getElementsByTagName("ans:identificadorDespesa");
		Element el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificadorDespesa");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				tab.setCodigo(null);
				tab.setTipoTabela(null);
				tab.setDescricao(null);
			} else {
				tab = this.getTabela(el);
			}
		} else {
			tab = this.getTabela(el);
		}
		desp.setIdentificadorDespesa(tab);
		nl = elm.getElementsByTagName("ans:tipoDespesa");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoDespesa");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setTipoDespesa(null);
			} else {
				desp.setTipoDespesa(el.getFirstChild().getNodeValue());
			}
		} else {
			desp.setTipoDespesa(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:dataRealizacao");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dataRealizacao");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setDataRealizacao(null);
			} else {
				desp.setDataRealizacao(el.getFirstChild().getNodeValue());
			}
		} else {
			desp.setDataRealizacao(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:horaInicial");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:horaInicial");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setHoraInicial(null);
			} else {
				desp.setHoraInicial(el.getFirstChild().getNodeValue());
			}
		} else {
			desp.setHoraInicial(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:horaFinal");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:horaFinal");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setHoraFinal(null);
			} else {
				desp.setHoraFinal(el.getFirstChild().getNodeValue());
			}
		} else {
			desp.setHoraFinal(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:reducaoAcrescimo");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:reducaoAcrescimo");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setReducaoAcescimo(null);
			} else {
				desp.setReducaoAcescimo(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			desp.setReducaoAcescimo(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:quantidade");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:quantidade");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setQuantidade(null);
			} else {
				desp.setQuantidade(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			desp.setQuantidade(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:valorUnitario");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valorUnitario");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setValorUnitario(null);
			} else {
				desp.setValorUnitario(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			desp.setValorUnitario(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:valorTotal");
		el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valorTotal");
			el = (Element)nl.item(0);
			if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				desp.setValorTotal(null);
			} else {
				desp.setValorTotal(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			desp.setValorTotal(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		return desp;
	}
	
	private List<DespesaTO> getDespesas (Element elm) {
		DespesaTO desp = null;
		List<DespesaTO> lista = new ArrayList<DespesaTO>();
		NodeList nl = elm.getElementsByTagName("ans:despesa");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:despesa");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				lista = null;
			} else {
				for (int i = 0; i < nl.getLength(); i++) {
					Element eml = (Element)nl.item(i);
					desp = new DespesaTO();
					desp = this.getDespesa(eml);
					lista.add(desp);
				}
			}
		} else {
			for (int i = 0; i < nl.getLength(); i++) {
				Element eml = (Element)nl.item(i);
				desp = new DespesaTO();
				desp = this.getDespesa(eml);
				lista.add(desp);
			}
		}
		return lista;
	}
	
	private OutrasDespesasTO getOutrasDesp (Element elm) {
		OutrasDespesasTO out = new OutrasDespesasTO();
		out.setDespesa(this.getDespesas(elm));
		return out;
	}
	
	private ProcedimentosTO getProcedimentos (Element elm) {
		ProcedimentosTO proc = new ProcedimentosTO();
		IdentificacaoEquipeTO ie = new IdentificacaoEquipeTO();
		TabelaTO tab = new TabelaTO();
		NodeList nl = elm.getElementsByTagName("ans:equipe");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:equipe");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ie.setMembroEquipe(null);
			} else {
				ie = this.getIdentifEquipe(el);
			}
		} else {
			ie = this.getIdentifEquipe(el);
		}
		proc.setEquipe(ie);
		nl = elm.getElementsByTagName("ans:procedimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:procedimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				tab.setCodigo(null);
				tab.setTipoTabela(null);
				tab.setDescricao(null);
			} else {
				tab = this.getTabela(el);
			}
		} else {
			tab = this.getTabela(el);
		}
		proc.setProcedimento(tab);
		nl = elm.getElementsByTagName("ans:data");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:data");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setData(null);
			} else {
				proc.setData(el.getFirstChild().getNodeValue());
			}
		} else {
			proc.setData(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:horaInicio");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:horaInicio");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setHoraInicio(null);
			} else {
				proc.setHoraInicio(el.getFirstChild().getNodeValue());
			}
		} else {
			proc.setHoraInicio(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:horaFim");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:horaFim");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setHoraFim(null);
			} else {
				proc.setHoraFim(el.getFirstChild().getNodeValue());
			}
		} else {
			proc.setHoraFim(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:quantidadeRealizada");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:quantidadeRealizada");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setQuantidadeRealizada(null);
			} else {
				proc.setQuantidadeRealizada(Long.parseLong(el.getFirstChild().getNodeValue()));
			}
		} else {
			proc.setQuantidadeRealizada(Long.parseLong(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:viaDeAcesso");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:viaDeAcesso");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setViaDeAcesso(null);
			} else {
				proc.setViaDeAcesso(el.getFirstChild().getNodeValue());
			}
		} else {
			proc.setViaDeAcesso(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:tecnicaUtilizada");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tecnicaUtilizada");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setTecnicaUtilizada(null);
			} else {
				proc.setTecnicaUtilizada(el.getFirstChild().getNodeValue());
			}
		} else {
			proc.setTecnicaUtilizada(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:reducaoAcrescimo");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:reducaoAcrescimo");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setReducaoAcrescimo(null);
			} else {
				proc.setReducaoAcrescimo(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			proc.setReducaoAcrescimo(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:valor");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valor");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setValor(null);
			} else {
				proc.setValor(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			proc.setValor(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:valorTotal");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valorTotal");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				proc.setValorTotal(null);
			} else {
				proc.setValorTotal(Double.parseDouble(el.getFirstChild().getNodeValue()));
			}
		} else {
			proc.setValorTotal(Double.parseDouble(el.getFirstChild().getNodeValue()));
		}
		return proc;
	}
	
	private IdentificacaoEquipeTO getIdentifEquipe (Element elm) {
		IdentificacaoEquipeTO ie = new IdentificacaoEquipeTO();
		MembroEquipeTO me = new MembroEquipeTO();
		NodeList nl = elm.getElementsByTagName("ans:membroEquipe");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:membroEquipe");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				me.setCodigoProfissional(null);
				me.setIdentificacaoProfissional(null);
				me.setCpf(null);
				me.setPosicaoProfissional(null);
			} else {
				me = this.getMembroEquipe(el);
			}
		} else {
			me = this.getMembroEquipe(el);
		}
		ie.setMembroEquipe(me);
		return ie;
	}
	
	private MembroEquipeTO getMembroEquipe (Element elm) {
		MembroEquipeTO me = new MembroEquipeTO();
		IdentificacaoPrestadorEquipeTO ipe = new IdentificacaoPrestadorEquipeTO();
		ProfissionalExecutanteTO pe = new ProfissionalExecutanteTO();
		NodeList nl = elm.getElementsByTagName("ans:codigoProfissional");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCpf(null);
				ipe.setCodigoPrestadorNaOperadora(null);
				ipe.setConselhoProfissional(null);
			} else {
				ipe = this.getIdentifPrestEquipe(el);
			}
		} else {
			ipe = this.getIdentifPrestEquipe(el);
		}
		me.setCodigoProfissional(ipe);
		nl = elm.getElementsByTagName("ans:identificacaoProfissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacaoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pe.setNomeExecutante(null);
				pe.setConelhoProfissional(null);
				pe.setCodigoCBOS(null);
			} else {
				pe = this.getIdentifProf(el);
			}
		} else {
			pe = this.getIdentifProf(el);
		}
		me.setIdentificacaoProfissional(pe);
		nl = elm.getElementsByTagName("ans:cpf");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cpf");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				me.setCpf(null);
			} else {
				me.setCpf(el.getFirstChild().getNodeValue());
			}
		} else {
			me.setCpf(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:posicaoProfissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:posicaoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				me.setPosicaoProfissional(null);
			} else {
				me.setPosicaoProfissional(el.getFirstChild().getNodeValue());
			}
		} else {
			me.setPosicaoProfissional(el.getFirstChild().getNodeValue());
		}
		return me;
	}
	
	private ProfissionalExecutanteTO getIdentifProf (Element elm) {
		ProfissionalExecutanteTO pe = new ProfissionalExecutanteTO();
		ConselhoProfissionalTO cp = new ConselhoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:nomeExecutante");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeExecutante");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pe.setNomeExecutante(null);
			} else {
				pe.setNomeExecutante(el.getFirstChild().getNodeValue());
			}
		} else {
			pe.setNomeExecutante(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:conselhoProfissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:conselhoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setSiglaConselho(null);
				cp.setNumeroConselho(null);
				cp.setUfConselho(null);
			} else {
				cp = this.getConselho(el);
			}
		} else {
			cp = this.getConselho(el);
		}
		pe.setConelhoProfissional(cp);
		nl = elm.getElementsByTagName("ans:codigoCBOS");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoCBOS");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pe.setCodigoCBOS(null);
			} else {
				pe.setCodigoCBOS(el.getFirstChild().getNodeValue());
			}
		} else {
			pe.setCodigoCBOS(el.getFirstChild().getNodeValue());
		}
		return pe;
	}

	
	private IdentificacaoPrestadorEquipeTO getIdentifPrestEquipe (Element elm) {
		IdentificacaoPrestadorEquipeTO ipe = new IdentificacaoPrestadorEquipeTO();
		ConselhoProfissionalTO cp = new ConselhoProfissionalTO();
		NodeList nl = elm.getElementsByTagName("ans:cpf");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cpf");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCpf(null);
			} else {
				ipe.setCpf(el.getFirstChild().getNodeValue());
			}
		} else {
			ipe.setCpf(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoPrestadorNaOperadora");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoPrestadorNaOperadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCodigoPrestadorNaOperadora(null);
			} else {
				ipe.setCodigoPrestadorNaOperadora(el.getFirstChild().getNodeValue());
			}
		} else {
			ipe.setCodigoPrestadorNaOperadora(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:conselhoProfissional");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:conselhoProfissional");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setSiglaConselho(null);
				cp.setNumeroConselho(null);
				cp.setUfConselho(null);
			} else {
				cp = getConselho(el);
			}
		} else {
			cp = getConselho(el);
		}
		ipe.setConselhoProfissional(cp);
		return ipe;
	}

	private List<ProcedimentosTO> getTodosProced (Element elm) {
		ProcedimentosTO proc = null;
		List<ProcedimentosTO> lista = new ArrayList<ProcedimentosTO>();
		NodeList nl = elm.getElementsByTagName("ans:procedimentos");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:procedimentos");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				lista = null;
			} else {
				for (int i = 0; i < nl.getLength(); i++) {
					Element eml = (Element)nl.item(i);
					proc = new ProcedimentosTO();
					proc = this.getProcedimentos(eml);
					lista.add(proc);
				}
			}
		} else {
			for (int i = 0; i < nl.getLength(); i++) {
				Element eml = (Element)nl.item(i);
				proc = new ProcedimentosTO();
				proc = this.getProcedimentos(eml);
				lista.add(proc);
			}
		}
		return lista;
	}
	
	private ProcedimentoRealizadoEquipeTO getProcEquipe (Element elm) {
		ProcedimentoRealizadoEquipeTO pre = new ProcedimentoRealizadoEquipeTO();
		pre.setProcedimentos(this.getTodosProced(elm));
		return pre;
	}

	private DiagnosticoAtendimentoTO getHipotDiag (Element elm) {
		DiagnosticoAtendimentoTO da = new DiagnosticoAtendimentoTO();
		DiagnosticoTO diag = new DiagnosticoTO();
		TempoEvolucaoDoencaTO td = new TempoEvolucaoDoencaTO();
		NodeList nl = elm.getElementsByTagName("ans:CID");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:CID");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				diag.setNomeTabela(null);
				diag.setCodigoDiagnostico(null);
				diag.setDescricaoDiagnostico(null);
			} else {
				diag = this.getCid(el);
			}
		} else {
			diag = this.getCid(el);
		}
		da.setCid(diag);
		nl = elm.getElementsByTagName("ans:tipoDoenca");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoDoenca");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				da.setTipoDoenca(null);
			} else {
				da.setTipoDoenca(el.getFirstChild().getNodeValue());
			}
		} else {
			da.setTipoDoenca(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ansTISS:tempoReferidoEvolucaoDoenca");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tempoReferidoEvolucaoDoenca");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				td.setValor(null);
				td.setUnidadeTempo(null);
			} else {
				td = this.getTempEvo(el);
			}
		} else {
			td = this.getTempEvo(el);
		}
		da.setTempoReferidoEvolucaoDoenca(td);
		nl = elm.getElementsByTagName("ans:indicadorAcidente");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:indicadorAcidente");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				da.setIndicadorAcidente(null);
			} else {
				da.setIndicadorAcidente(el.getFirstChild().getNodeValue());
			}
		} else {
			da.setIndicadorAcidente(el.getFirstChild().getNodeValue());
		}
		return da;
	}
	
	private DiagnosticoTO getCid (Element elm) {
		DiagnosticoTO diag = new DiagnosticoTO();
		NodeList nl = elm.getElementsByTagName("ans:nomeTabela");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeTabela");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				diag.setNomeTabela(null);
			} else {
				diag.setNomeTabela(el.getFirstChild().getNodeValue());
			}
		} else {
			diag.setNomeTabela(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoDiagnostico");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoDiagnostico");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				diag.setCodigoDiagnostico(null);
			} else {
				diag.setCodigoDiagnostico(el.getFirstChild().getNodeValue());
			}
		} else {
			diag.setCodigoDiagnostico(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:descricaoDiagnostico");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:descricaoDiagnostico");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				diag.setDescricaoDiagnostico(null);
			} else {
				diag.setDescricaoDiagnostico(el.getFirstChild().getNodeValue());
			}
		} else {
			diag.setDescricaoDiagnostico(el.getFirstChild().getNodeValue());
		}
		return diag;
	}
	
	private TempoEvolucaoDoencaTO getTempEvo (Element elm) {
		TempoEvolucaoDoencaTO td = new TempoEvolucaoDoencaTO();
		NodeList nl = elm.getElementsByTagName("ans:valor");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:valor");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				td.setValor(null);
			} else {
				td.setValor(el.getFirstChild().getNodeValue());
			}
		} else {
			td.setValor(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:unidadeTempo");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:unidadeTempo");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				td.setUnidadeTempo(null);
			} else {
				td.setUnidadeTempo(el.getFirstChild().getNodeValue());
			}
		} else {
			td.setUnidadeTempo(el.getFirstChild().getNodeValue());
		}
		return td;
	}

}