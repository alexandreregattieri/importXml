package br.com.cesan.importacao.xml.presentation;

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
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaConsultaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta.AtendimentoConsultaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta.ContratadoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.consulta.ProcedimentoTO;

public class LerGuiaConsulta {
	
	public GuiaConsultaTO getGuiaConsulta (Element elm) {
		GuiaConsultaTO cons = new GuiaConsultaTO();
		CabecalhoGuiaTO cab = new CabecalhoGuiaTO();
		BeneficiarioTO benef = new BeneficiarioTO();
		ContratadoTO cont = new ContratadoTO();
		IdentificacaoFontePagadoraTO ifp = new IdentificacaoFontePagadoraTO();
		IdentificacaoProfissionalTO ip = new IdentificacaoProfissionalTO();
		IdentificacaoPrestadorExecutanteTO ipe = new IdentificacaoPrestadorExecutanteTO();
		EnderecoTO end = new EnderecoTO();
		ConselhoProfissionalTO cp = new ConselhoProfissionalTO();
		DiagnosticoTO diag = new DiagnosticoTO();
		TempoEvolucaoDoencaTO td = new TempoEvolucaoDoencaTO();
		DiagnosticoAtendimentoTO da = new DiagnosticoAtendimentoTO();
		AtendimentoConsultaTO ac = new AtendimentoConsultaTO();
		ProcedimentoTO pd = new ProcedimentoTO();
		NodeList nl = elm.getElementsByTagName("ans:identificacaoGuia");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacaoGuia");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ifp.setRegistroANS(null);
				ifp.setCnpjFontePagadora(null);
				cab.setIdentificacaoFontePagadora(ifp);
			} else {
				cab = this.getIdentificacaoGuia(el);
			}
		} else {
			cab = this.getIdentificacaoGuia(el);
		}
		cons.setIdentificacaoGuia(cab);
		nl = elm.getElementsByTagName("ans:beneficiario");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:beneficiario");
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
		cons.setBeneficiario(benef);
		nl = elm.getElementsByTagName("ans:dadosContratado");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dadosContratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCnpj(null);
				ipe.setCpf(null);
				ipe.setCodigoPrestadorNaOperadora(null);
				end.setTipoLogradouro(null);
				end.setLogradouro(null);
				end.setNumero(null);
				end.setComplemento(null);
				end.setCodigoIBGEMunicipio(null);
				end.setMunicipio(null);
				end.setCodigoUF(null);
				end.setCep(null);
				cont.setIdentificacao(ipe);
				cont.setNomeContratado(null);
				cont.setEnderecoContratado(end);
				cont.setNumeroCNES(null);
			} else {
				cont = this.getDadosContratado(el);
			}
		} else {
			cont = this.getDadosContratado(el);
		}
		cons.setDadosContratado(cont);
		nl = elm.getElementsByTagName("ans:profissionalExecutante");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:profissionalExecutante");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cp.setSiglaConselho(null);
				cp.setNumeroConselho(null);
				cp.setUfConselho(null);
				ip.setNomeProfissional(null);
				ip.setConselhoProfissional(cp);
				ip.setCbos(null);
			} else {
				ip = this.getProfExecutante(el);
			}
		} else {
			ip = this.getProfExecutante(el);
		}
		cons.setProfissionalExecutante(ip);
		nl = elm.getElementsByTagName("ans:hipoteseDiagnostica");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:hipoteseDiagnostica");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				diag.setNomeTabela(null);
				diag.setCodigoDiagnostico(null);
				diag.setDescricaoDiagnostico(null);
				td.setValor(null);
				td.setUnidadeTempo(null);
				da.setCid(diag);
				da.setTipoDoenca(null);
				da.setTempoReferidoEvolucaoDoenca(td);
				da.setIndicadorAcidente(null);
			} else {
				da = this.getHipotDiag(el);
			}
		} else {
			da = this.getHipotDiag(el);
		}
		cons.setHipoteseDiagnostica(da);
		nl = elm.getElementsByTagName("ans:dadosAtendimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dadosAtendimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pd.setCodigoTabela(null);
				pd.setCodigoProcedimento(null);
				ac.setDataAtendimento(null);
				ac.setProcedimento(pd);
				ac.setTipoConsulta(null);
				ac.setTipoSaida(null);
			} else {
				ac = this.getDadosAtend(el);
			}
		} else {
			ac = this.getDadosAtend(el);
		}
		cons.setDadosAtendimento(ac);
		nl = elm.getElementsByTagName("ans:observacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:observacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cons.setObservacao(null);
			} else {
				cons.setObservacao(el.getFirstChild().getNodeValue());
			}
		} else {
			cons.setObservacao(el.getFirstChild().getNodeValue());
		}
		return cons;
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

	private CabecalhoGuiaTO getIdentificacaoGuia(Element elm) {
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
				ip = this.getIdenFontePag (el);
			}
		} else {
			ip = this.getIdenFontePag (el);
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
	
	private ContratadoTO getDadosContratado(Element elm) {
		ContratadoTO cont = new ContratadoTO();
		IdentificacaoPrestadorExecutanteTO ipe = new IdentificacaoPrestadorExecutanteTO();
		EnderecoTO end = new EnderecoTO();
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
		cont.setIdentificacao(ipe);
		nl = elm.getElementsByTagName("ans:nomeContratado");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeContratado");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cont.setNomeContratado(null);
			} else {
				cont.setNomeContratado(el.getFirstChild().getNodeValue());
			}
		} else {
			cont.setNomeContratado(el.getFirstChild().getNodeValue());
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
		cont.setEnderecoContratado(end);
		nl = elm.getElementsByTagName("ans:nomeCNES");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:nomeCNES");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cont.setNumeroCNES(null);
			} else {
				cont.setNumeroCNES(el.getFirstChild().getNodeValue());
			}
		} else {
			cont.setNumeroCNES(el.getFirstChild().getNodeValue());
		}
		return cont;
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
		nl = elm.getElementsByTagName("ans:tempoReferidoEvolucaoDoenca");
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
	
	private AtendimentoConsultaTO getDadosAtend (Element elm) {
		AtendimentoConsultaTO atd = new AtendimentoConsultaTO();
		ProcedimentoTO pd = new ProcedimentoTO();
		NodeList nl = elm.getElementsByTagName("ans:dataAtendimento");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dataAtendimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				atd.setDataAtendimento(null);
			} else {
				atd.setDataAtendimento(el.getFirstChild().getNodeValue());
			}
		} else {
			atd.setDataAtendimento(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:procedimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:procedimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pd.setCodigoTabela(null);
				pd.setCodigoProcedimento(null);
			} else {
				pd = this.getProced(el);
			}
		} else {
			pd = this.getProced(el);
		}
		atd.setProcedimento(pd);
		nl = elm.getElementsByTagName("ans:tipoConsulta");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoConsulta");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				atd.setTipoConsulta(null);
			} else {
				atd.setTipoConsulta(el.getFirstChild().getNodeValue());
			}
		} else {
			atd.setTipoConsulta(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:tipoSaida");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoSaida");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				atd.setTipoSaida(null);
			} else {
				atd.setTipoSaida(el.getFirstChild().getNodeValue());
			}
		} else {
			atd.setTipoSaida(el.getFirstChild().getNodeValue());
		}
		return atd;
	}
	
	private IdentificacaoFontePagadoraTO getIdenFontePag(Element elm) {
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
	
	private ProcedimentoTO getProced (Element elm) {
		ProcedimentoTO pd = new ProcedimentoTO();
		NodeList nl = elm.getElementsByTagName("ans:codigoTabela");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoTabela");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pd.setCodigoTabela(null);
			} else {
				pd.setCodigoTabela(el.getFirstChild().getNodeValue());
			}
		} else {
			pd.setCodigoTabela(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:codigoProcedimento");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoProcedimento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				pd.setCodigoProcedimento(null);
			} else {
				pd.setCodigoProcedimento(el.getFirstChild().getNodeValue());
			}
		} else {
			pd.setCodigoProcedimento(el.getFirstChild().getNodeValue());
		}
		return pd;
	}
	
}
