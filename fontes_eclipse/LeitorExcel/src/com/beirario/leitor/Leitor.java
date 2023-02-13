package com.beirario.leitor;

import com.beirario.excel.ArquivoExcel;
import au.com.bytecode.opencsv.CSVReader;

public class Leitor {

	public static void ler(ArquivoExcel arquivoExcel, String filialFaturamento, String ordemCompra) throws Exception {
		String tipoArquivo = arquivoExcel.getArquivo().getName().substring(arquivoExcel.getArquivo().getName().lastIndexOf(".") + 1, arquivoExcel.getArquivo().getName().length());
		if (tipoArquivo.equalsIgnoreCase("csv")) {
			CSVReader csvReader = new CSVReader(new java.io.FileReader(arquivoExcel.getCaminhoExcel()), ";".charAt(0),"'".charAt(0), 1);
			arquivoExcel.setDados(csvReader.readAll());
			csvReader.close();
		} else {
			arquivoExcel.setDadosExcel(tipoArquivo);
		}
		AtualizaRefCliGde.atualiza(arquivoExcel, filialFaturamento, ordemCompra);
	}
}
