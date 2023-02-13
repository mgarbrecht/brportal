package com.beirario.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.beirario.excel.ArquivoExcel;
import com.beirario.leitor.Leitor;

public class Tela extends JFrame {
 
	private static final long serialVersionUID = 1L;

	public Tela() {
		final JTextField txtArquivo = new JTextField("C:\\Users\\daniel_pauletti\\Desktop\\OC 4500036149 - copia.csv");
		txtArquivo.setBounds(20, 10, 400, 20);

		JButton btnInicia = new JButton("Arquivo");
		btnInicia.setBounds(20, 30, 100, 20);

		JButton btnLer = new JButton("Ler");
		btnLer.setBounds(20, 50, 100, 20);

		final JTextField txtOrdemCompra = new JTextField("4500036149");
		txtOrdemCompra.setBounds(20, 120, 100, 20);

		final JTextField txtFilial = new JTextField("30");
		txtFilial.setBounds(20, 140, 100, 20);

		btnInicia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtArquivo.setText(selecionaArquivo().getAbsolutePath());
			}

		});

		btnLer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lerArquivo(txtArquivo.getText(), txtOrdemCompra.getText(), txtFilial.getText());
			}

		});

		getContentPane().add(txtArquivo);
		getContentPane().add(btnInicia);
		getContentPane().add(btnLer);
		getContentPane().add(txtOrdemCompra);
		getContentPane().add(txtFilial);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setBounds(300, 400, 500, 300);
		setLayout(null);
		setVisible(true);
	}

	private static File selecionaArquivo() {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Escolha o(s) arquivo(s)...");
		fc.setDialogType(JFileChooser.OPEN_DIALOG);
		fc.setApproveButtonText("OK");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(false);
		int resultado = fc.showOpenDialog(fc);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		} else {
			return null;
		}
	}

	private static void lerArquivo(String caminho, String ordemCompra, String filialFaturamento) {
		try {
			Leitor.ler(new ArquivoExcel(new java.io.File(caminho)), filialFaturamento, ordemCompra);
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
