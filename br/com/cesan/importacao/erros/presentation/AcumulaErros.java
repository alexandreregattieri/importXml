package br.com.cesan.importacao.erros.presentation;

import java.util.List;
import br.com.cesan.importacao.erros.model.to.ErrosTO;

public class AcumulaErros {
	
	public List<ErrosTO> getAcumulaUmErro (List<ErrosTO> lista, ErrosTO erro) {
		int num = 0;
		try {
			if (erro.getMensagemErro() != null) {
				if (erro.getCodigoErro() == null || erro.getCodigoErro().trim().equals("")) {
					num = 1;
				} else {
					num = Integer.parseInt(erro.getCodigoErro());
					num = num + 1;
				}
				erro.setCodigoErro(Integer.toString(num));
				lista.add(erro);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lista;
	}

}
