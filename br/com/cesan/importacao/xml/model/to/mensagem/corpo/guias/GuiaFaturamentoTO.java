package br.com.cesan.importacao.xml.model.to.mensagem.corpo.guias;

import java.util.List;

public class GuiaFaturamentoTO {
	
	private List<GuiaConsultaTO> guiaConsulta;
	private List<GuiaSP_SADTTO> guiaSP_SADT;

	public List<GuiaConsultaTO> getGuiaConsulta() {
		return guiaConsulta;
	}
	public void setGuiaConsulta(List<GuiaConsultaTO> guiaConsulta) {
		this.guiaConsulta = guiaConsulta;
	}
	public List<GuiaSP_SADTTO> getGuiaSP_SADT() {
		return guiaSP_SADT;
	}
	public void setGuiaSP_SADT(List<GuiaSP_SADTTO> guiaSPSADT) {
		guiaSP_SADT = guiaSPSADT;
	}

}
