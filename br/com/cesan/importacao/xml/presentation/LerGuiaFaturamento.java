package br.com.cesan.importacao.xml.presentation;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaConsultaTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaFaturamentoTO;
import br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias.GuiaSP_SADTTO;

public class LerGuiaFaturamento {
	
	public GuiaFaturamentoTO getGuiaFaturamento (Element elm) {
		GuiaFaturamentoTO gf = new GuiaFaturamentoTO();
		GuiaConsultaTO gc = null;
		GuiaSP_SADTTO gs = null;
		List<GuiaConsultaTO> listaGc = new ArrayList<GuiaConsultaTO>();
		List<GuiaSP_SADTTO> listaGs = new ArrayList<GuiaSP_SADTTO>();
		LerGuiaConsulta lerGc = new LerGuiaConsulta();
		LerGuiaSP_SADT lerGs = new LerGuiaSP_SADT();
		NodeList nl = elm.getElementsByTagName("ans:guiaConsulta");
		Element el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:guiaConsulta");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				listaGc = null;
			} else {
				for (int i = 0; i < nl.getLength(); i++) {
					Element eml = (Element)nl.item(i);
					gc = new GuiaConsultaTO();
					gc = lerGc.getGuiaConsulta(eml);
					listaGc.add(gc);
				}
			}
		} else {
			for (int i = 0; i < nl.getLength(); i++) {
				Element eml = (Element)nl.item(i);
				gc = new GuiaConsultaTO();
				gc = lerGc.getGuiaConsulta(eml);
				listaGc.add(gc);
			}
		}
		gf.setGuiaConsulta(listaGc);
		nl = elm.getElementsByTagName("ans:guiaSP_SADT");
		el = (Element)nl.item(0);
		if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
			nl = elm.getElementsByTagName("ansTISS:guiaSP_SADT");
			el = (Element)nl.item(0);
			if (el == null || el.getAttributes() == null || el.getFirstChild() == null) {
				listaGs = null;
			} else {
				for (int i = 0; i < nl.getLength(); i++) {
					Element eml = (Element)nl.item(i);
					gs = new GuiaSP_SADTTO();
					gs = lerGs.getGuiaSPSADT(eml);
					listaGs.add(gs);
				}
			}
		} else {
			for (int i = 0; i < nl.getLength(); i++) {
				Element eml = (Element)nl.item(i);
				gs = new GuiaSP_SADTTO();
				gs = lerGs.getGuiaSPSADT(eml);
				listaGs.add(gs);
			}
		}
		gf.setGuiaSP_SADT(listaGs);
		return gf;
	}

}
