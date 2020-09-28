package br.com.cesan.importacao.xml.presentation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;

public class LerXML {
	
private String caminho;
	
	public LerXML(String caminho) {
		this.caminho = caminho;
	}
	
	public MensagemTO getMensagem() throws Exception {
		MensagemTO msg = new MensagemTO();
		LerMensagemTISS ler = new LerMensagemTISS();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(caminho);
		Element el = doc.getDocumentElement();
		msg = ler.getMensagem(el);
		return msg;
	}

}
