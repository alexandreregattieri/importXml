package br.com.cesan.importacao.view.model;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import br.com.cesan.importacao.process.presentation.ValidConsulta;
import br.com.cesan.importacao.process.presentation.ValidExame;
import br.com.cesan.importacao.sgb.model.to.FaturasConsultaSGBTO;
import br.com.cesan.importacao.sgb.model.to.FaturasExameSGBTO;
import br.com.cesan.importacao.xml.model.to.mensagem.MensagemTO;
import br.com.cesan.importacao.xml.presentation.LerXML;

public class Principal extends JPanel {
	
	private JLabel tit1, tit2, tit3, tit4, tit5, tit6, tit7, tit8;
	private JLabel esp1, esp2, esp3;
	private JButton but1, but2, but3;
	private JTextField text, text2, text3;
	
	public Principal() {
		tit1 = new JLabel("CESAN");
		tit2 = new JLabel("   ");
		tit3 = new JLabel("Importação de Guias XML");
		tit4 = new JLabel("   ");
		tit5 = new JLabel("   ");
		tit6 = new JLabel("CPF/CNPJ   ");
		tit7 = new JLabel("Lote   ");
		tit8 = new JLabel("   ");
		esp1 = new JLabel("     ");
		esp2 = new JLabel("     ");
		esp3 = new JLabel("     ");
		but1 = new JButton("Escolher");
		but2 = new JButton("Importar");
		but3 = new JButton("Cancelar");
		text = new JTextField(20);
		text.setEditable(false);
		text.setText("");
		text2 = new JTextField(15);
		text2.setEditable(false);
		text2.setText("");
		text3 = new JTextField(15);
		text3.setEditable(false);
		text3.setText("");
		
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				if ((fc.showSaveDialog(tit1) != JFileChooser.APPROVE_OPTION)) {
		        	return;
		        }
		        File arquivo = fc.getSelectedFile();
		        String ret = arquivo.getPath().toString();
		        text.setText(ret.replaceAll("\\\\","/"));
		        text2.setText("");
		        text3.setText("");
			}
		});
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (text.getText() != null) {
					if (text.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(tit1, "Favor informar um arquivo XML.");
					} else {
						String teste = text.getText().substring(text.getText().trim().length()-3, text.getText().trim().length());
						if (teste.equalsIgnoreCase("xml")) {
							String caminho = text.getText().trim().substring(0, text.getText().trim().length()-3) + "xml";
							MensagemTO msg = null;
							LerXML ler = null;
							ValidConsulta validc = null;
							ValidExame valide = null;
							FaturasConsultaSGBTO fatc = null;
							FaturasExameSGBTO fate = null;
							try {
								msg = new MensagemTO();
								ler = new LerXML(caminho);
								validc = new ValidConsulta();
								valide = new ValidExame();
								fatc = new FaturasConsultaSGBTO();
								fate = new FaturasExameSGBTO();
								msg = ler.getMensagem();
								if (msg.getCorpo().getLoteGuias().getGuias().getGuiaFaturamento().getGuiaConsulta() != null) {
									fatc = validc.getValidaConsulta(msg, text.getText().trim());
								} else if (msg.getCorpo().getLoteGuias().getGuias().getGuiaFaturamento().getGuiaSP_SADT() != null) {
									fate = valide.getValidaExame(msg, text.getText().trim());
								} else {
									fatc = null;
									fate = null;
								}
							} catch (Exception e) {
								//System.out.println(e.toString());
							}
							if (fate != null || fatc != null) {
								JOptionPane.showMessageDialog(tit1, "Processo Finalizado ...\nFavor verificar o arquivo de erros.");
								if (fate != null) {
									if (fate.getFaturas() != null) {
										if (fate.getFaturas().get(0) != null) {
											text2.setText(fate.getFaturas().get(0).getNumcpfcgccri());
											text3.setText(fate.getFaturas().get(0).getItens().get(0).getNuLoteTiss().toString());
										}
									}
								}
								if (fatc != null) {
									if (fatc.getFaturas() != null) {
										if (fatc.getFaturas().get(0) != null) {
											text2.setText(fatc.getFaturas().get(0).getNumcpfcgccri());
											text3.setText(fatc.getFaturas().get(0).getItens().getNuLoteTiss().toString());
										}
									}
								}
							} else {
								JOptionPane.showMessageDialog(tit1, "Erro no processamento do arquivo.");
							}
						} else {
							JOptionPane.showMessageDialog(tit1, "O Arquivo informado não está no formato XML.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(tit1, "Favor informar um arquivo XML.");
				}
			}
		});
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JPanel pane = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        pane.setLayout(grid);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(tit1, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(tit2, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(tit3, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(tit4, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(text, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(tit5, c);
        c.gridwidth = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.EAST;
        c.weightx = 0.0;
        pane.add(tit6, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.EAST;
        c.weightx = 0.0;
        pane.add(text2, c);
        c.gridwidth = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.EAST;
        c.weightx = 0.0;
        pane.add(tit7, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.EAST;
        c.weightx = 0.0;
        pane.add(text3, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(tit8, c);
        c.gridwidth = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(esp1, c);
        c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(but1, c);
        c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(esp2, c);
        c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(but2, c);
        c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(esp3, c);
        c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.0;
        pane.add(but3, c);
        
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(pane, BorderLayout.PAGE_START);
        add(leftPane, BorderLayout.LINE_START);
		
	}

	public static void createAndShowGUI() {
        JFrame frame = new JFrame("Importação de Arquivos XML");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.add(new Principal());
        frame.pack();
        frame.setLocation(380,150);
        frame.setVisible(true);
    }
	
}
