package br.com.cesan.importacao.xml.presentation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.GuiasTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaFaturamentoTO;

public class LerGuias {
	
	public GuiasTO getGuias(Element elm) {
		GuiasTO guias = new GuiasTO();
		GuiaFaturamentoTO gf = new GuiaFaturamentoTO();
		LerGuiaFaturamento lerGf = new LerGuiaFaturamento();
		NodeList nl = elm.getElementsByTagName("ans:guiaFaturamento");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:guiaFaturamento");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				gf.setGuiaConsulta(null);
				gf.setGuiaSP_SADT(null);
			} else {
				gf = lerGf.getGuiaFaturamento(el);
			}
		} else {
			gf = lerGf.getGuiaFaturamento(el);
		}
		guias.setGuiaFaturamento(gf);
		return guias;
	}

}
