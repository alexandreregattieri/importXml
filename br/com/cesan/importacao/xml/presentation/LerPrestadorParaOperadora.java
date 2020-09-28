package br.com.cesan.importacao.xml.presentation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.LoteGuiasTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.PrestadorParaOperadoraTO;

public class LerPrestadorParaOperadora {

	public PrestadorParaOperadoraTO getPrestParOpera (Element elm) {
		PrestadorParaOperadoraTO ppo = new PrestadorParaOperadoraTO();
		LoteGuiasTO lg = new LoteGuiasTO();
		LerLoteGuias lerLg = new LerLoteGuias();
		NodeList nl = elm.getElementsByTagName("ans:loteGuias");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:loteGuias");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				lg.setNumeroLote(null);
				lg.setGuias(null);
			} else {
				lg = lerLg.getLoteGuias(el);
			}
		} else {
			lg = lerLg.getLoteGuias(el);
		}
		ppo.setLoteGuias(lg);
		nl = elm.getElementsByTagName("ans:loteAnexo");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:loteAnexo");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				ppo.setLoteAnexo(null);
			} else {
				ppo.setLoteAnexo(el.getFirstChild().getNodeValue());
			}
		} else {
			ppo.setLoteAnexo(el.getFirstChild().getNodeValue());
		}
		return ppo;
	}
	
}
