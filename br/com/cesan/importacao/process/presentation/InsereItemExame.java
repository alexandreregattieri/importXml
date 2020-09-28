package br.com.cesan.importacao.process.presentation;

import br.com.cesan.importacao.sgb.model.dao.ValidaInsercaoDAO;
import br.com.cesan.importacao.sgb.model.to.FaturaItemExameSGBTO;
import br.com.cesan.importacao.sgb.model.to.SomaItensFaturaTO;
import br.com.cesan.importacao.sgb.model.to.TabelaProcedSGBTO;

public class InsereItemExame {
	
	public SomaItensFaturaTO setIsereItemExame (FaturaItemExameSGBTO fie, TabelaProcedSGBTO tab, String fat) {
		SomaItensFaturaTO soma = new SomaItensFaturaTO();
		ValidaInsercaoDAO valInser = new ValidaInsercaoDAO();
		String sql = null;
		try {
			sql = "INSERT E09_FATURA_ITEM (INDDONFAT,NUMFAT,INDTIPITE,CODITEFAT,DTAATN,CODTIPTAB,NU_BENEFICIO,INDPOFEEC,TIPPGT,QTEITE,VALPRE,VALITE,VALGLS,VALDPSEXR,VALUSUITE,VALPLNITE,VA_BASE_CALCULO_IMPOSTO,CODMSG,VA_PERC_PROCED,CD_ESPEC_ASSOCIADA,CD_GLOSA,ID_SITUACAO,VA_PROCEDIMENTO_CH_USO,DTAATL,MATRESULTATL,OBSFAT_ITEM,NU_PROTOCOLO_TISS,NU_LOTE_TISS,DT_INCLUSAO_ITEM,SQ_BENEFICIO,VA_PLUS,VALTAXPLN,VALTAXUSU,VA_TAXA_INTERCAMBIO_PLANO,VA_TAXA_INTERCAMBIO_USUARIO,PERSERPOF,NUMCPFCGCCRI,INDCPFCGC)";
			sql = sql + " VALUES ('M'," + fat + ",'" + tab.getTipodigit() + "'," + fie.getCoditefat() + ",'" + fie.getDtaatn() + "'," + tab.getCodtiptab() + "," + tab.getNubeneficio() + ",'','H',1," + fie.getValpre() + "," + fie.getValite() + "," + fie.getValgls() + ",0," + fie.getValusuite() + "," + fie.getValplnite() + "," + fie.getVaBaseCalculoImposto() + ",0,100," + fie.getCdEspecAssociada() + ",";
			sql = sql + fie.getCdGlosa() + ",'D'," + fie.getVaProcedimentoChUso() + "," + fie.getDtaatl() + ",'TISS',''," + fie.getNuProtocoloTiss() + "," + fie.getNuLoteTiss() + "," + fie.getDtIncusaoItem() + ",1,0,0,0,0,0," + fie.getVaPercProced() + ",'','')";
			valInser.setInsereItem(sql);
			soma.setValexr(fie.getValdpsexr());
			soma.setValgls(fie.getValgls());
			soma.setValgro(fie.getValite());
			soma.setValinr(fie.getValpre());
			soma.setValpln(fie.getValplnite());
			soma.setValusu(fie.getValusuite());
		} catch (Exception e) {
			System.out.println("ITEM EXAME " + e.toString());
		}
		return soma;
	}

}
