package br.com.cesan.importacao.xml.presentation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.cabecalho.IdentificacaoTransacaoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.cabecalho.OrigemTO;
import br.com.cesan.importacao.xml.model.to.mensagem.common.IdentificacaoPrestadorExecutanteTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.CabecalhoTransacaoTO;

public class LerCabecalho {
	
	public CabecalhoTransacaoTO getCabecalho (Element elm) {
		CabecalhoTransacaoTO cab = new CabecalhoTransacaoTO();
		IdentificacaoTransacaoTO it = new IdentificacaoTransacaoTO();
		OrigemTO og = new OrigemTO();
		OrigemTO dest = new OrigemTO();
		NodeList nl = elm.getElementsByTagName("ans:identificacaoTransacao");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:identificacaoTransacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				it = this.getIdentificacao(el);
			} else {
				it.setTipoTransacao(null);
				it.setSequencialTransacao(null);
				it.setDataRegistroTransacao(null);
				it.setHoraRegistroTransacao(null);
			}
		} else {
			it = this.getIdentificacao(el);
		}
		cab.setIdentificacaoTransacao(it);
		nl = elm.getElementsByTagName("ans:origem");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:origem");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				og.setCodigoPrestadorNaOperadora(null);
				og.setRegistroANS(null);
				og.setCnpjpagador(null);
			} else {
				og = this.getOrigem(el);
			}
		} else {
			og = this.getOrigem(el);
		}
		cab.setOrigem(og);
		nl = elm.getElementsByTagName("ans:destino");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:destino");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				dest.setCodigoPrestadorNaOperadora(null);
				dest.setRegistroANS(null);
				dest.setCnpjpagador(null);
			} else {
				dest = this.getOrigem(el);
			}
		} else {
			dest = this.getOrigem(el);
		}
		cab.setDestino(dest);
		nl = elm.getElementsByTagName("ans:versaoPadrao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:versaoPadrao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cab.setVersaoPadrao(null);
			} else {
				cab.setVersaoPadrao(el.getFirstChild().getNodeValue());
			}
		} else {
			cab.setVersaoPadrao(el.getFirstChild().getNodeValue());
		}
		return cab;
	}
	
	private IdentificacaoPrestadorExecutanteTO getIdentifPrestExec(Element elm) {
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
	
	private OrigemTO getOrigem(Element elm) {
		OrigemTO og = new OrigemTO();
		IdentificacaoPrestadorExecutanteTO ipe = new IdentificacaoPrestadorExecutanteTO();
		NodeList nl = elm.getElementsByTagName("ans:codigoPrestadorNaOperadora");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:codigoPrestadorNaOperadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ipe.setCnpj(null);
				ipe.setCpf(null);
				ipe.setCodigoPrestadorNaOperadora(null);
			} else {
				ipe = this.getIdentifPrestExec(el);
			}
		} else {
			ipe = this.getIdentifPrestExec(el);
		}
		og.setCodigoPrestadorNaOperadora(ipe);
		nl = elm.getElementsByTagName("ans:registroANS");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:registroANS");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				og.setRegistroANS(null);
			} else {
				og.setRegistroANS(el.getFirstChild().getNodeValue());
			}
		} else {
			og.setRegistroANS(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:cnpjPagador");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cnpjPagador");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				og.setCnpjpagador(null);
			} else {
				og.setCnpjpagador(el.getFirstChild().getNodeValue());
			}
		} else {
			og.setCnpjpagador(el.getFirstChild().getNodeValue());
		}
		return og;
	}
	
	private IdentificacaoTransacaoTO getIdentificacao(Element elm) {
		IdentificacaoTransacaoTO it = new IdentificacaoTransacaoTO();
		NodeList nl = elm.getElementsByTagName("ans:tipoTransacao");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:tipoTransacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				it.setTipoTransacao(null);
			} else {
				it.setTipoTransacao(el.getFirstChild().getNodeValue());
			}
		} else {
			it.setTipoTransacao(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:sequencialTransacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:sequencialTransacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				it.setSequencialTransacao(null);
			} else {
				it.setSequencialTransacao(Long.parseLong(el.getFirstChild().getNodeValue()));
			}
		} else {
			it.setSequencialTransacao(Long.parseLong(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:dataRegistroTransacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:dataRegistroTransacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				it.setDataRegistroTransacao(null);
			} else {
				it.setDataRegistroTransacao(el.getFirstChild().getNodeValue());
			}
		} else {
			it.setDataRegistroTransacao(el.getFirstChild().getNodeValue());
		}
		nl = elm.getElementsByTagName("ans:horaRegistroTransacao");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:horaRegistroTransacao");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				it.setHoraRegistroTransacao(null);
			} else {
				it.setHoraRegistroTransacao(el.getFirstChild().getNodeValue());
			}
		} else {
			it.setHoraRegistroTransacao(el.getFirstChild().getNodeValue());
		}
		return it;
	}

}
