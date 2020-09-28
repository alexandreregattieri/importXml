package br.com.cesan.importacao.xml.presentation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.EpilogoTO;

public class LerEpilogo {

	public EpilogoTO getEpilogo (Element elm) {
		EpilogoTO ep = new EpilogoTO();
		NodeList nl = elm.getElementsByTagName("ans:hash");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:hash");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ep.setHash(null);
			} else {
				ep.setHash(el.getFirstChild().getNodeValue());
			}
		} else {
			ep.setHash(el.getFirstChild().getNodeValue());
		}
		return ep;
	}
	
}
