package br.com.cesan.importacao.sgb.model.to;

import java.sql.Date;

public class ProtocoloSGBTO {
	
	private Long numpto;
	private Long anopto;
	private String numcpfcgccri;
	private String indcpfcgc;
	private Date datapevpgt;
	private String obspto;
	private Date dtfaturamento;
	
	public Long getNumpto() {
		return numpto;
	}
	public void setNumpto(Long numpto) {
		this.numpto = numpto;
	}
	public Long getAnopto() {
		return anopto;
	}
	public void setAnopto(Long anopto) {
		this.anopto = anopto;
	}
	public String getNumcpfcgccri() {
		return numcpfcgccri;
	}
	public void setNumcpfcgccri(String numcpfcgccri) {
		this.numcpfcgccri = numcpfcgccri;
	}
	public String getIndcpfcgc() {
		return indcpfcgc;
	}
	public void setIndcpfcgc(String indcpfcgc) {
		this.indcpfcgc = indcpfcgc;
	}
	public Date getDatapevpgt() {
		return datapevpgt;
	}
	public void setDatapevpgt(Date datapevpgt) {
		this.datapevpgt = datapevpgt;
	}
	public String getObspto() {
		return obspto;
	}
	public void setObspto(String obspto) {
		this.obspto = obspto;
	}
	public Date getDtfaturamento() {
		return dtfaturamento;
	}
	public void setDtfaturamento(Date dtfaturamento) {
		this.dtfaturamento = dtfaturamento;
	}

}
