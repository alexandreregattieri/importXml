package br.com.cesan.importacao.xml.presentation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.PrestadorParaOperadoraTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.CabecalhoTransacaoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.EpilogoTO;

public class LerMensagemTISS {
	
	public MensagemTO getMensagem(Element elm) {
		MensagemTO msg = new MensagemTO();
		CabecalhoTransacaoTO cab = new CabecalhoTransacaoTO();
		EpilogoTO ep = new EpilogoTO();
		PrestadorParaOperadoraTO ppo = new PrestadorParaOperadoraTO();
		LerCabecalho lerCab = new LerCabecalho();
		LerEpilogo lerEpi = new LerEpilogo();
		LerPrestadorParaOperadora lerPpo = new LerPrestadorParaOperadora();
		NodeList nl = elm.getElementsByTagName("ans:cabecalho");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:cabecalho");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				cab.setIdentificacaoTransacao(null);
				cab.setOrigem(null);
				cab.setDestino(null);
				cab.setVersaoPadrao(null);
			} else {
				cab = lerCab.getCabecalho(el);
			}
		} else {
			cab = lerCab.getCabecalho(el);
		}
		msg.setCabecalho(cab);
		nl = elm.getElementsByTagName("ans:prestadorParaOperadora");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:prestadorParaOperadora");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ppo.setLoteGuias(null);
				ppo.setLoteAnexo(null);
			} else {
				ppo = lerPpo.getPrestParOpera(el);
			}
		} else {
			ppo = lerPpo.getPrestParOpera(el);
		}
		msg.setCorpo(ppo);
		nl = elm.getElementsByTagName("ans:epilogo");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:epilogo");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ep.setHash(null);
			} else {
				ep = lerEpi.getEpilogo(el);
			}
		} else {
			ep = lerEpi.getEpilogo(el);
		}
		msg.setEpilogo(ep);
		return msg;
	}

}
