package br.com.cesan.importacao.process.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.cesan.importacao.sgb.model.dao.ValidaAtendimentoDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaBeneficiarioDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaPrestadorDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaTabelaDAO;
import br.com.cesan.importacao.sgb.model.dao.ValidaTissDAO;
import br.com.cesan.importacao.sgb.model.to.BeneficiarioSGBTO;
import br.com.cesan.importacao.sgb.model.to.CredenciadoSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturaConsultaSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturasConsultaSGBTO;
import br.com.cesan.importacao.sgb.model.to.TabelaProcedSGBTO;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;


public class ValidConsulta {

	public FaturasConsultaSGBTO getValidaConsulta (MensagemTO msg, String caminho) {
		String erros = "";
		//ErrosConsulta erro = new ErrosConsulta();
		FaturasConsultaSGBTO fcs = new FaturasConsultaSGBTO();
		Consulta cons = new Consulta();
		ValidaBeneficiarioDAO valBenef = null;
		ValidaTabelaDAO valTab = null;
		ValidaPrestadorDAO valPrest = null;
		ValidaAtendimentoDAO valAtend = null;
		ValidaTissDAO valTiss = null;
		BeneficiarioSGBTO benef = null;
		TabelaProcedSGBTO tab = null;
		CredenciadoSGBTO prest = null;
		InsereConsulta insere = null;
		List<BeneficiarioSGBTO> listaBenef = new ArrayList<BeneficiarioSGBTO>();
		List<TabelaProcedSGBTO> listaTabela = new ArrayList<TabelaProcedSGBTO>();
		List<CredenciadoSGBTO> listaPrest = new ArrayList<CredenciadoSGBTO>();
		fcs = null;
		fcs = cons.getDadosConsulta(caminho, msg);
		if (fcs != null) {
			List<FaturaConsultaSGBTO> lista = new ArrayList<FaturaConsultaSGBTO>();
			lista = fcs.getFaturas();
			int i = 0;
			String cam = null;
			try {
				valPrest = new ValidaPrestadorDAO();
				prest = new CredenciadoSGBTO();
				prest = valPrest.getInstConsulta(lista.get(i).getNumcpfcgccri(), lista.get(i).getCdTipoConselho(), lista.get(i).getNumcrm(), lista.get(i).getCdUfCrm());
				if (msg.getCabecalho() != null) {
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
							if (msg.getCabecalho().getDestino().getRegistroANS().trim().equals("392405") || msg.getCabecalho().getDestino().getRegistroANS().trim().equals("39240-5") || msg.getCabecalho().getDestino().getRegistroANS().trim().equals("39.240-5")) {
								//
							} else {
								JOptionPane.showMessageDialog(new JOptionPane(), "ERRO !!! \n\nFAVOR DEVOLVER ESTE LOTE XML AO PRESTADOR.\n\nLOTE NÃO É REFERENTE A UM FATURAMENTO CESAN.");
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
				}
				valTiss = new ValidaTissDAO();
				JOptionPane.showMessageDialog(new JOptionPane(), "IMPORTANTE !!! \n\nANOTE ESTES DADOS\n\nCPF/CNPJ: " + prest.getNumcpfcgccri() + "\nLOTE TISS: " + lista.get(i).getItens().getNuLoteTiss());
				Long tiss = valTiss.getExisteTiss(lista.get(i).getItens().getNuLoteTiss(), prest.getNumcpfcgccri());
				if (tiss > 0) {
					JOptionPane.showMessageDialog(new JOptionPane(), "Este protocolo já foi importado para este Credenciado.\n\nSó serão importadas as guias que não foram importadas no arquivo anterior.");
				}
				for (FaturaConsultaSGBTO fat : lista) {
					String retorno = null;
					valBenef = new ValidaBeneficiarioDAO();
					benef = new BeneficiarioSGBTO();
					benef.setPlano(valBenef.getPlano(lista.get(i).getDtaatn(), lista.get(i).getNumtiu()));
					if (benef.getPlano() == null) {
						benef.setCoddpd(null);
						benef.setIdade(null);
						benef.setIndtiptiu(null);
						benef.setNumtiu(null);
						benef.setParticipacao(null);
						benef.setPlano(null);
						benef.setSexo(null);
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
					listaBenef.add(benef);
					valTab = new ValidaTabelaDAO();
					tab = new TabelaProcedSGBTO();
					tab = valTab.getTabelas(lista.get(i).getItens().getCodtiptab(), lista.get(i).getItens().getNuBeneficio().toString().trim());
					lista.get(i).getItens().setCodtiptab(tab.getCodtiptab());
					lista.get(i).getItens().setNuBeneficio(tab.getNubeneficio());
					listaTabela.add(tab);
					lista.get(i).setNumcpfcgccri(prest.getNumcpfcgccri());
					lista.get(i).setIndcpgcgc(prest.getIndcpfcgc());
					listaPrest.add(prest);
					valAtend = new ValidaAtendimentoDAO();
					Long teste = valAtend.getAtendConsulta(benef.getNumtiu(), benef.getCoddpd(), benef.getPlano(), lista.get(i).getCoditidoe(), lista.get(i).getDtaatn(), prest.getNumcpfcgccri());
					insere = new InsereConsulta();
					cam = caminho.substring(0, caminho.length()-4) + "_erros.pdf";
					String nega = null;
					if (teste > 0) {
						nega = "S";
					} else {
						nega = "N";
					}
					retorno = insere.setInsereConsulta(fcs, i, tab, benef, tiss, nega);
					if (retorno != null) {
						erros = erros + "\n\n" + retorno;
					}
					i++;
				}
				fcs.setFaturas(lista);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			if (cam != null) {
				//erro.setInsereTexto(cam, erros, lista.get(0).getNumcpfcgccri(), lista.get(0).getItens().getNuLoteTiss().toString());
			}
		}
		return fcs;
	}
}
