package util.consultas.com;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Teste {
	
	public static void main (String args[]) {
		Teste t = new Teste();
		t.geraExcel();
	}

	public void geraExcel() {

		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;

		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		boolean gerou = false;
		try {
			HSSFSheet testsheet = null;
			nomeArquivo.append("nf").append(util.rand.Palavra.geraPalavra()).append(".xls");
			FileOutputStream fos = new FileOutputStream("c:/" + nomeArquivo.toString());

			testsheet = wb.createSheet("nf");
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("Número");
			tcell = trow.createCell(1);
			tcell.setCellValue("Série");
			tcell = trow.createCell(2);
			tcell.setCellValue("Código Linha");
			tcell = trow.createCell(3);
			tcell.setCellValue("Código Referência");
			tcell = trow.createCell(4);
			tcell.setCellValue("Emissão");
			tcell = trow.createCell(5);
			tcell.setCellValue("Qtd. Vol.");
			tcell = trow.createCell(6);
			tcell.setCellValue("Valor Nota");
			tcell = trow.createCell(7);
			tcell.setCellValue("Valor Liq.");
			tcell = trow.createCell(8);
			tcell.setCellValue("Total Pares");
			tcell = trow.createCell(9);
			tcell.setCellValue("Taxa Dólar");
			tcell = trow.createCell(10);
			tcell.setCellValue("Chave NFE");
			
			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("rowcount: " + rowcount);
			
			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("rowcount: " + rowcount);
			
			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("rowcount: " + rowcount);
			
			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("rowcount: " + rowcount);
			
			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("rowcount: " + rowcount);
			
			wb.write(fos);
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		} finally {
		}
		if (gerou) {
			retorno = nomeArquivo.toString();
		} else {
			retorno = "";
		}
		System.out.println("gerou: " + retorno);
	}
}