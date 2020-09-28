package br.com.cesan.importacao.xml.presentation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.GuiasTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.LoteGuiasTO;

public class LerLoteGuias {
	
	public LoteGuiasTO getLoteGuias (Element elm) {
		LoteGuiasTO lg = new LoteGuiasTO();
		GuiasTO guias = new GuiasTO();
		LerGuias lerG = new LerGuias();
		NodeList nl = elm.getElementsByTagName("ans:numeroLote");
		Element el = (Element)nl.item(0);
		if(el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:numeroLote");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				lg.setNumeroLote(null);
			} else {
				lg.setNumeroLote(Long.parseLong(el.getFirstChild().getNodeValue()));
			}
		} else {
			lg.setNumeroLote(Long.parseLong(el.getFirstChild().getNodeValue()));
		}
		nl = elm.getElementsByTagName("ans:guias");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:guias");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				guias.setGuiaFaturamento(null);
			} else {
				guias = lerG.getGuias(el);
			}
		} else {
			guias = lerG.getGuias(el);
		}
		lg.setGuias(guias);
		return lg;
	}

}
