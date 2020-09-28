package br.com.cesan.importacao.process.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.cesan.importacao.sgb.model.dao.ValidaBeneficiarioDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaPrestadorDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaTissDAO;
import br.com.cesan.importacao.sgb.model.to.BeneficiarioSGBTO;
import br.com.cesan.importacao.sgb.model.to.CredenciadoSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturaExameSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturasExameSGBTO;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;

public class ValidExame {
	
	public FaturasExameSGBTO getValidaExame (MensagemTO msg, String caminho) {
		String erros = "";
		//ErrosConsulta erro = new ErrosConsulta();
		FaturasExameSGBTO fat = new FaturasExameSGBTO();
		Exame exame = new Exame();
		ValidaBeneficiarioDAO valBenef = null;
		ValidaPrestadorDAO valPrest = null;
		ValidaTissDAO valTiss = null;
		BeneficiarioSGBTO benef = null;
		CredenciadoSGBTO prest = null;
		InsereExame insere = null;
		fat = null;
		fat = exame.getDadosExame(caminho, msg);
		if (fat != null) {
			List<FaturaExameSGBTO> lista = new ArrayList<FaturaExameSGBTO>();
			lista = fat.getFaturas();
			String cam = caminho.substring(0, caminho.length()-4) + "_erros.pdf";
			int i = 0;
			try {
				valPrest = new ValidaPrestadorDAO();
				prest = new CredenciadoSGBTO();
				prest = valPrest.getInstConsulta(lista.get(i).getNumcpfcgccri(), lista.get(i).getCdTipoConselho(), lista.get(i).getNumcrm(), lista.get(i).getCdUfCrm());
				/*if (msg.getCabecalho() != null) {
					if (msg.getCabecalho().getDestino() != null) {
						if (msg.getCabecalho().getDestino().getCnpjpagador() != null) {
							if (msg.getCabecalho().getDestino().getCnpjpagador().trim() != "28151363000147") {
								JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO É REFERENTE A UM FATURAMENTO CESAN.");
								return null;
							} else {
								if (msg.getCabecalho().getDestino().getRegistroANS().trim().equals("392405") || msg.getCabecalho().getDestino().getRegistroANS().trim().equals("39240-5") || msg.getCabecalho().getDestino().getRegistroANS().trim().equals("39.240-5")) {
									//
								} else {
									JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO É REFERENTE A UM FATURAMENTO CESAN.");
									return null;
								}
							}
						} else {
							if (msg.getCabecalho().getDestino().getRegistroANS() != null) {
								if (msg.getCabecalho().getDestino().getRegistroANS().trim().equals("392405") || msg.getCabecalho().getDestino().getRegistroANS().trim().equals("39240-5") || msg.getCabecalho().getDestino().getRegistroANS().trim().equals("39.240-5")) {
									//
								} else {
									JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO É REFERENTE A UM FATURAMENTO CESAN.");
									return null;
								}
							} else {
								JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO POSSUI DESTINO NO CABEÇALHO TISS.");
								return null;
							}
						}
					} else {
						JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO POSSUI DESTINO NO CABEÇALHO TISS.");
						return null;
					}
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO POSSUI CABEÇALHO TISS.");
					return null;
				}
				if (prest.getNumcpfcgccri() == null) {
					JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nPRESTADOR NÃO CADASTRADO OU CÓDIGO INCORRETO.");
					return null;
				}*/
				valTiss = new ValidaTissDAO();
				JOptionPane.showMessageDialog(new JOptionPane(), "IMPORTANTE !!! \n\nANOTE ESTES DADOS\n\nCPF/CNPJ: " + prest.getNumcpfcgccri() + "\nLOTE TISS: " + lista.get(i).getItens().get(0).getNuLoteTiss());
				Long tiss = valTiss.getExisteTiss(lista.get(i).getItens().get(0).getNuLoteTiss(), prest.getNumcpfcgccri());
				if (tiss > 0) {
					JOptionPane.showMessageDialog(new JOptionPane(), "Este protocolo já foi importado para este Credenciado.\n\nSó serão importadas as guias que não foram importadas no arquivo anterior.");
				}
				for (FaturaExameSGBTO li : lista) {
					String retorno = null;
					valBenef = new ValidaBeneficiarioDAO();
					benef = new BeneficiarioSGBTO();
					benef.setPlano(valBenef.getPlano(lista.get(i).getDtaatn(), lista.get(i).getNumtiu()));
					if (benef.getPlano() == null) {
						benef = null;
					} else {
						benef.setNumtiu(valBenef.getNumtiu(benef.getPlano(), lista.get(i).getNumtiu()));
						benef.setCoddpd(valBenef.getDepend(benef.getPlano(), lista.get(i).getNumtiu(), benef.getNumtiu()));
						benef = valBenef.getBenefSGB(benef.getPlano(), benef.getNumtiu(), benef.getCoddpd(), lista.get(i).getDtaatn());
					}
					lista.get(i).setCodemppan(benef.getPlano());
					lista.get(i).setCodemppln(benef.getPlano());
					lista.get(i).setCodplncop(benef.getPlano());
					lista.get(i).setNumtiu(benef.getNumtiu());
					lista.get(i).setCoddpd(benef.getCoddpd());
					lista.get(i).setIndusu(benef.getIndtiptiu());
					lista.get(i).setNumcpfcgccri(prest.getNumcpfcgccri());
					lista.get(i).setNumcpfcgccriContratado(prest.getNumcpfcgccri());
					lista.get(i).setIndcpgcgc(prest.getIndcpfcgc());
					insere = new InsereExame();
					retorno = insere.setInsereExame(lista.get(i), benef, cam, (long)1);
					if (retorno != null) {
						erros = erros + "\n\n" + retorno;
					}
					i++;
				}
				fat.setFaturas(lista);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			if (cam != null) {
				//erro.setInsereTexto(cam, erros, lista.get(0).getNumcpfcgccri(), lista.get(0).getItens().get(0).getNuLoteTiss().toString());
			}
		}
		return fat;
	}

}
