package util.consultas.com;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CodigoBarrasExcel {

	public String geraExcel(String p_tipo, HttpSession session) throws Exception {
		boolean agruparModelo = false;
		String retorno = "";
		java.util.Vector<?> res_Jw_cod_barra_dum14 = null;
		java.util.Vector<?> res_Jw_cod_barra_ean13 = null;
		java.util.Vector<?> res_Jw_cod_barra_ambos = null;
		if (session.getAttribute("res_Jw_cod_barra_agrupar_modelo") != null) {
			agruparModelo = true;
		}
		if (p_tipo.equalsIgnoreCase("dun14")) {
			res_Jw_cod_barra_dum14 = (java.util.Vector<?>) session.getAttribute("res_Jw_cod_barra_dum14");
		} else if (p_tipo.equalsIgnoreCase("ean13")) {
			res_Jw_cod_barra_ean13 = (java.util.Vector<?>) session.getAttribute("res_Jw_cod_barra");
		} else {
			res_Jw_cod_barra_ambos = (java.util.Vector<?>) session.getAttribute("res_Jw_cod_barra_ambos");
		}
		java.lang.String linha_ref = null;
		java.lang.String linha_ref_cab = null;
		Integer cod_marca = 0;
		String desc_marca = null;
		java.lang.String cabedal = null;
		java.lang.String cor = null;
		String gde_cdgo = null;
		java.lang.Integer qtd_pares = null;
		java.lang.String cod_dum14 = null;
		String cod_ean13 = null;
		java.lang.String status = null;
		Integer cab_cdgo = 0;
		Integer cor_cdgo = 0;
		String num_int = null;
		java.lang.String ref_desc = null;
		String imagem = null;

		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleWrapText;
		

		util.consultas.Parametros parametros = new util.consultas.Parametros();
		//String diretorioImagens = parametros.retornaParametro("diretorio_imagens_grandes");
		String diretorioImagens = "/home/loja_brportal/imagens/grandes/";
		// para testes
		// String diretorioImagens =
		// parametros.retornaParametro("diretorio_arquivos_temporarios");
		String diretorioSemImagem = parametros.retornaParametro("diretorio_imagens_brportal");

		StringBuilder nomeArquivo = new StringBuilder();
		nomeArquivo.append("CodigoBarrasForm").append(util.rand.Palavra.geraPalavra()).append(".xls");
		int rowcount = 0;
		int rowCount_Imagem = 0;
		HSSFSheet testsheet = null;

		style = wb.createCellStyle();
		stylecenter = wb.createCellStyle();
		styleright = wb.createCellStyle();
		stylecenterborda = wb.createCellStyle();
		styleGrade = wb.createCellStyle();
		styleWrapText = wb.createCellStyle();
		styleGrade.setBorderLeft((short) 1);
		styleGrade.setBorderRight((short) 1);
		styleGrade.setBorderTop((short) 1);
		styleGrade.setBorderBottom((short) 1);
		styleGrade.setAlignment((short) 2);
		style.setBorderBottom((short) 1);
		style.setAlignment((short) 1);
		stylecenterborda.setBorderBottom((short) 1);
		stylecenterborda.setAlignment((short) 2);
		stylecenter.setAlignment((short) 2);
		styleright.setAlignment((short) 4);
		styleWrapText.setWrapText(true);

		FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
		// este é pra teste
		//FileOutputStream fos = new FileOutputStream("C:/" + nomeArquivo.toString() );
		try {

			if (p_tipo.equalsIgnoreCase("ean13")) { 
				testsheet = wb.createSheet("Relatorio Ean13");
				HSSFPatriarch patriarch = testsheet.createDrawingPatriarch();
				int i_Jw_cod_barra_ean13 = 0;
				int contador = 0;
				trow = testsheet.createRow(rowcount++);
				if(agruparModelo) {
					testsheet.setColumnWidth(0, 6 * 250); 	// Marca
					testsheet.setColumnWidth(1, 15 * 250);	// Descrição Marca	
					testsheet.setColumnWidth(2, 10 * 250);	// Linha/Ref/Cab
					testsheet.setColumnWidth(3, 25 * 250);	// Descrição Referência
					testsheet.setColumnWidth(4, 35 * 250);	// Descrição Cabedal
					testsheet.setColumnWidth(5, 10 * 250);	// Cor
					testsheet.setColumnWidth(6, 30 * 250);	// Descrição Cor
					testsheet.setColumnWidth(7, 10 * 250);	// Numeração Int.
					testsheet.setColumnWidth(8, 14 * 250);	// Ean13
					testsheet.setColumnWidth(9, 6 * 250);	// Status
				} else {
					testsheet.setColumnWidth(0, 6 * 250); 	// Marca
					testsheet.setColumnWidth(1, 15 * 250);	// Descrição Marca	
					testsheet.setColumnWidth(2, 10 * 250);	// Linha/Ref
					testsheet.setColumnWidth(3, 25 * 250);	// Descrição Referência
					testsheet.setColumnWidth(4, 10 * 250);	// Cabedal
					testsheet.setColumnWidth(5, 35 * 250);	// Descrição Cabedal
					testsheet.setColumnWidth(6, 10 * 250);	// Cor
					testsheet.setColumnWidth(7, 30 * 250);	// Descrição Cor
					testsheet.setColumnWidth(8, 10 * 250);	// Numeração Int.
					testsheet.setColumnWidth(9, 14 * 250);	// Ean13
					testsheet.setColumnWidth(10, 6 * 250);	// Status
				}

				tcell = trow.createCell(contador++);
				tcell.setCellValue("Marca");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Marca");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				if(agruparModelo) {
					tcell.setCellValue("Linha/Ref/Cab");
				} else {
					tcell.setCellValue("Linha/Ref");
				}
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Referencia");
				tcell.setCellStyle(stylecenterborda);
				if(!agruparModelo){
					tcell = trow.createCell(contador++);
					tcell.setCellValue("Cabedal");
					tcell.setCellStyle(stylecenterborda);
				}
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Cabedal");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Cor");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição cor");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Numeração Int");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Ean 13");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Status");
				tcell.setCellStyle(style);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Imagem");
				tcell.setCellStyle(stylecenterborda);

				while (i_Jw_cod_barra_ean13 < res_Jw_cod_barra_ean13.size()) {
					contador = 0;
					rowCount_Imagem = rowcount;
					trow = testsheet.createRow(rowcount++);
					portalbr.dbobj.view.Jw_cod_barra t_jw_cod_barra_ean13 = (portalbr.dbobj.view.Jw_cod_barra) res_Jw_cod_barra_ean13.elementAt(i_Jw_cod_barra_ean13);
					cod_marca = t_jw_cod_barra_ean13.getCodigo_marca();
					desc_marca = t_jw_cod_barra_ean13.getDescricao_marca();
					linha_ref = t_jw_cod_barra_ean13.getLinha_ref() == null ? "" : t_jw_cod_barra_ean13.getLinha_ref();
					linha_ref_cab = t_jw_cod_barra_ean13.getLinha_ref() == null ? "" : (t_jw_cod_barra_ean13.getLinha_ref()+"."+t_jw_cod_barra_ean13.getCab_cdgo());
					ref_desc = t_jw_cod_barra_ean13.getRef_desc();
					cab_cdgo = t_jw_cod_barra_ean13.getCab_cdgo();
					cabedal = t_jw_cod_barra_ean13.getCabedal() == null ? "" : t_jw_cod_barra_ean13.getCabedal();
					cor_cdgo = t_jw_cod_barra_ean13.getCor_cdgo();
					cor = t_jw_cod_barra_ean13.getCor() == null ? "" : t_jw_cod_barra_ean13.getCor();
					num_int = t_jw_cod_barra_ean13.getGrade();
					cod_ean13 = t_jw_cod_barra_ean13.getCod_barra() == null ? "" : t_jw_cod_barra_ean13.getCod_barra();
					status = t_jw_cod_barra_ean13.getStatus() == null ? "" : t_jw_cod_barra_ean13.getStatus();
					imagem = diretorioImagens + t_jw_cod_barra_ean13.getImagem();

					tcell = trow.createCell(contador++);
					tcell.setCellValue(cod_marca);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(desc_marca);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					if(agruparModelo){
						tcell.setCellValue(linha_ref_cab);
					} else {
						tcell.setCellValue(linha_ref);
					}
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(ref_desc);
					tcell.setCellStyle(style);
					if(!agruparModelo){
						tcell = trow.createCell(contador++);
						tcell.setCellValue(cab_cdgo);
						tcell.setCellStyle(stylecenterborda);
					}
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cabedal);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cor_cdgo);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cor);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(num_int);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cod_ean13);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(status);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(imagem);
					tcell.setCellStyle(stylecenterborda);

					i_Jw_cod_barra_ean13++;
				
					try {
						int indice = agruparModelo ? 10:11;
						trow.getCell(indice).getRow().setHeight((short)1450);
						String arquivo = imagem;
						java.io.File f = new java.io.File(arquivo);
						if (!f.isFile()) {
							arquivo = diretorioSemImagem + "sem_imagem.jpg";
							trow.getCell(indice).setCellValue("");
						}
						FileInputStream fis = new FileInputStream(arquivo);
						ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
						int b;
						while ((b = fis.read()) != -1) {
							img_bytes.write(b);
						}
						fis.close();
						trow.getCell(indice).setCellValue("");
						trow.getCell(indice).setCellStyle(styleWrapText);
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (indice), (rowCount_Imagem),	(short) (indice+1), rowCount_Imagem + 1);
						int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
						patriarch.createPicture(anchor, index);
						anchor.setAnchorType(0);
					} catch (Exception e) {
					}
					
				}
				

			} else if (p_tipo.equalsIgnoreCase("dun14")) {
				int contador = 0;
				testsheet = wb.createSheet("Relatorio dun14");
				HSSFPatriarch patriarch = testsheet.createDrawingPatriarch();
				int i_Jw_cod_barra_dum14 = 0;
				if(agruparModelo){
					testsheet.setColumnWidth(0, 10 * 250);	// Linha/Ref/Cab
					testsheet.setColumnWidth(1, 30 * 250);	// Descrição Referência
					testsheet.setColumnWidth(2, 30 * 250);	// Descrição Cabedal
					testsheet.setColumnWidth(3, 10 * 250);	// Cor
					testsheet.setColumnWidth(4, 30 * 250);	// Descrição Cor
					testsheet.setColumnWidth(5, 10 * 250);	// Grade
					testsheet.setColumnWidth(6, 10 * 250);	// Qtde. Pares
					testsheet.setColumnWidth(7, 15 * 250);	// Dun14
					testsheet.setColumnWidth(8, 10 * 250);	// Status					
				} else {
					testsheet.setColumnWidth(0, 10 * 250);	// Linha/Ref
					testsheet.setColumnWidth(1, 30 * 250);	// Descrição Referência
					testsheet.setColumnWidth(2, 10 * 250);	// Cabedal
					testsheet.setColumnWidth(3, 30 * 250);	// Descrição Cabedal
					testsheet.setColumnWidth(4, 10 * 250);	// Cor
					testsheet.setColumnWidth(5, 30 * 250);	// Descrição Cor
					testsheet.setColumnWidth(6, 10 * 250);	// Grade
					testsheet.setColumnWidth(7, 10 * 250);	// Qtde. Pares
					testsheet.setColumnWidth(8, 15 * 250);	// Dun14
					testsheet.setColumnWidth(9, 10 * 250);	// Status
				}

				trow = testsheet.createRow(rowcount++);
				tcell = trow.createCell(contador++);
				if(agruparModelo){
					tcell.setCellValue("Linha/Ref/Cab");	
				} else {
					tcell.setCellValue("Linha/Ref");	
				}
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Referencia");
				tcell.setCellStyle(stylecenterborda);
				if(!agruparModelo){
					tcell = trow.createCell(contador++);
					tcell.setCellValue("Cabedal");
					tcell.setCellStyle(stylecenterborda);
				}
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Cabedal");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Cor");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Cor");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Grade");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Qtd. Pares");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Dun 14");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Status");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Imagem");
				tcell.setCellStyle(stylecenterborda);

				while (i_Jw_cod_barra_dum14 < res_Jw_cod_barra_dum14.size()) {
					contador = 0;
					rowCount_Imagem = rowcount;
					trow = testsheet.createRow(rowcount++);
					portalbr.dbobj.view.Jw_cod_barra_dum14 t_jw_cod_barra_dum14 = (portalbr.dbobj.view.Jw_cod_barra_dum14) res_Jw_cod_barra_dum14.elementAt(i_Jw_cod_barra_dum14);
					linha_ref = t_jw_cod_barra_dum14.getLinha_ref() == null ? "" : t_jw_cod_barra_dum14.getLinha_ref();
					linha_ref_cab = t_jw_cod_barra_dum14.getLinha_ref() == null ? "" : (t_jw_cod_barra_dum14.getLinha_ref()+"."+t_jw_cod_barra_dum14.getCab_cdgo());
					ref_desc = t_jw_cod_barra_dum14.getRef_desc();
					cabedal = t_jw_cod_barra_dum14.getCabedal() == null ? "" : t_jw_cod_barra_dum14.getCabedal();
					cab_cdgo = t_jw_cod_barra_dum14.getCab_cdgo();
					cor_cdgo = t_jw_cod_barra_dum14.getCor_cdgo();
					cor = t_jw_cod_barra_dum14.getCor() == null ? "" : t_jw_cod_barra_dum14.getCor();
					gde_cdgo = t_jw_cod_barra_dum14.getGde_cdgo();
					qtd_pares = t_jw_cod_barra_dum14.getQtd_pares();
					cod_dum14 = t_jw_cod_barra_dum14.getCod_dum14() == null ? "" : t_jw_cod_barra_dum14.getCod_dum14();
					status = t_jw_cod_barra_dum14.getStatus() == null ? "" : t_jw_cod_barra_dum14.getStatus();
					imagem = diretorioImagens + t_jw_cod_barra_dum14.getImagem();

					tcell = trow.createCell(contador++);
					if(agruparModelo){
						tcell.setCellValue(linha_ref_cab);						
					} else {
						tcell.setCellValue(linha_ref);	
					}
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(ref_desc);
					tcell.setCellStyle(style);
					if(!agruparModelo){
						tcell = trow.createCell(contador++);
						tcell.setCellValue(cab_cdgo);
						tcell.setCellStyle(stylecenterborda);
					}
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cabedal);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cor_cdgo);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cor);
					tcell.setCellStyle(style);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(gde_cdgo);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(qtd_pares);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cod_dum14);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(status);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(imagem);
					tcell.setCellStyle(stylecenterborda);

					i_Jw_cod_barra_dum14++;
					
					try {
						int indice = agruparModelo ? 9 : 10;
						trow.getCell(indice).getRow().setHeight((short)1450);
						String arquivo = imagem;
						java.io.File f = new java.io.File(arquivo);
						if (!f.isFile()) {
							arquivo = diretorioSemImagem + "sem_imagem.jpg";
							trow.getCell(indice).setCellValue("");
						}
						FileInputStream fis = new FileInputStream(arquivo);
						ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
						int b;
						while ((b = fis.read()) != -1) {
							img_bytes.write(b);
						}
						fis.close();
						trow.getCell(indice).setCellValue("");
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (indice), (rowCount_Imagem),	(short) (indice+1), rowCount_Imagem + 1);
						
						int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
						patriarch.createPicture(anchor, index);
						anchor.setAnchorType(0);
					} catch (Exception e) {
					}
					

				}

			} else if (p_tipo.equalsIgnoreCase("ambos")) {
				int contador = 0;
				testsheet = wb.createSheet("Relatorio ambos");
				HSSFPatriarch patriarch = testsheet.createDrawingPatriarch();
				int i_Jw_cod_barra_ambos = 0;
				if(agruparModelo){
					testsheet.setColumnWidth(0, 10 * 250);	// Marca
					testsheet.setColumnWidth(1, 30 * 250);	// Descrição Marca
					testsheet.setColumnWidth(2, 10 * 250);	// Lin/Ref/Cab
					testsheet.setColumnWidth(3, 30 * 250);	// Descrição Referência
					testsheet.setColumnWidth(4, 30 * 250);	// Descrição Cabedal
					testsheet.setColumnWidth(5, 10 * 250);	// Cor
					testsheet.setColumnWidth(6, 10 * 250);	// Descrição Cor
					testsheet.setColumnWidth(7, 10 * 250);	// Número Int.
					testsheet.setColumnWidth(8, 14 * 250);	// Ean13
					testsheet.setColumnWidth(9, 10 * 250);	// Grade
					testsheet.setColumnWidth(10, 10 * 250);	// Qtde. Pares
					testsheet.setColumnWidth(11, 15 * 250);	// Dun14
					testsheet.setColumnWidth(12, 6 * 250);	// Status
				} else {
					testsheet.setColumnWidth(0, 10 * 250);	// Marca
					testsheet.setColumnWidth(1, 30 * 250);	// Descrição Marca
					testsheet.setColumnWidth(2, 10 * 250);	// Lin/Ref
					testsheet.setColumnWidth(3, 30 * 250);	// Descrição Referência
					testsheet.setColumnWidth(4, 10 * 250);	// Cabedal
					testsheet.setColumnWidth(5, 30 * 250);	// Descrição Cabedal
					testsheet.setColumnWidth(6, 10 * 250);	// Cor
					testsheet.setColumnWidth(7, 10 * 250);	// Descrição Cor
					testsheet.setColumnWidth(8, 10 * 250);	// Número Int.
					testsheet.setColumnWidth(9, 14 * 250);	// Ean13
					testsheet.setColumnWidth(10, 10 * 250);	// Grade
					testsheet.setColumnWidth(11, 10 * 250);	// Qtde. Pares
					testsheet.setColumnWidth(12, 15 * 250);	// Dun14
					testsheet.setColumnWidth(13, 6 * 250);	// Status
				}

				trow = testsheet.createRow(rowcount++);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Marca");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Marca");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				if(agruparModelo){
					tcell.setCellValue("Lin/Ref/Cab");
				} else {
					tcell.setCellValue("Lin/Ref");
				}
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Referencia");
				tcell.setCellStyle(stylecenterborda);
				if(!agruparModelo){
					tcell = trow.createCell(contador++);
					tcell.setCellValue("Cabedal");
					tcell.setCellStyle(stylecenterborda);
				}
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Cabedal");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Cor");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Descrição Cor");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Numero Int");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Ean13");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Grade");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Qtd. Pares");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Dun 14");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Status");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(contador++);
				tcell.setCellValue("Imagem");
				tcell.setCellStyle(stylecenterborda);

				while (i_Jw_cod_barra_ambos < res_Jw_cod_barra_ambos.size()) {
					contador = 0;
					rowCount_Imagem = rowcount;
					trow = testsheet.createRow(rowcount++);
					portalbr.dbobj.view.Jw_cod_barra_ambos t_jw_cod_barra_ambos = (portalbr.dbobj.view.Jw_cod_barra_ambos) res_Jw_cod_barra_ambos.elementAt(i_Jw_cod_barra_ambos);
					cod_marca = t_jw_cod_barra_ambos.getCodigo_marca();
					desc_marca = t_jw_cod_barra_ambos.getDescricao_marca();
					linha_ref = t_jw_cod_barra_ambos.getLinha_ref() == null ? "" : t_jw_cod_barra_ambos.getLinha_ref();
					linha_ref_cab = t_jw_cod_barra_ambos.getLinha_ref() == null ? "" : (t_jw_cod_barra_ambos.getLinha_ref()+"."+t_jw_cod_barra_ambos.getCab_cdgo());
					ref_desc = t_jw_cod_barra_ambos.getRef_desc();
					cab_cdgo = t_jw_cod_barra_ambos.getCab_cdgo();
					cabedal = t_jw_cod_barra_ambos.getCabedal() == null ? "" : t_jw_cod_barra_ambos.getCabedal();
					cor_cdgo = t_jw_cod_barra_ambos.getCor_cdgo();
					cor = t_jw_cod_barra_ambos.getCor() == null ? "" : t_jw_cod_barra_ambos.getCor();
					num_int = t_jw_cod_barra_ambos.getNumero() == null ? "" : t_jw_cod_barra_ambos.getNumero();
					cod_ean13 = t_jw_cod_barra_ambos.getEan13() == null ? "" : t_jw_cod_barra_ambos.getEan13();
					gde_cdgo = t_jw_cod_barra_ambos.getGde_cdgo() == null ? null : t_jw_cod_barra_ambos.getGde_cdgo().toString();
					qtd_pares = t_jw_cod_barra_ambos.getQtd_pares() == null ? 0 : t_jw_cod_barra_ambos.getQtd_pares();
					status = t_jw_cod_barra_ambos.getStatus();
					imagem = diretorioImagens + t_jw_cod_barra_ambos.getImagem();
					cod_dum14 = t_jw_cod_barra_ambos.getCod_dun14();

					tcell = trow.createCell(contador++);
					tcell.setCellValue(cod_marca);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(desc_marca);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					if(agruparModelo){
						tcell.setCellValue(linha_ref_cab);						
					} else {
						tcell.setCellValue(linha_ref);
					}
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(ref_desc);
					tcell.setCellStyle(stylecenterborda);
					if(!agruparModelo){
						tcell = trow.createCell(contador++);
						tcell.setCellValue(cab_cdgo);
						tcell.setCellStyle(stylecenterborda);
					}
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cabedal);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cor_cdgo);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cor);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(num_int);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cod_ean13);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(gde_cdgo);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(qtd_pares);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(cod_dum14);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(status);
					tcell.setCellStyle(stylecenterborda);
					tcell = trow.createCell(contador++);
					tcell.setCellValue(imagem);
					tcell.setCellStyle(stylecenterborda);

					i_Jw_cod_barra_ambos++;

					try {
						int indice = agruparModelo ? 13 : 14;
						trow.getCell(indice).getRow().setHeight((short)1450);
						String arquivo = imagem;
						java.io.File f = new java.io.File(arquivo);
						if (!f.isFile()) {
							arquivo = diretorioSemImagem + "sem_imagem.jpg";
							trow.getCell(indice).setCellValue("");
						}
						FileInputStream fis = new FileInputStream(arquivo);
						ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
						int b;
						while ((b = fis.read()) != -1) {
							img_bytes.write(b);
						}
						fis.close();
						trow.getCell(indice).setCellValue("");
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (indice), (rowCount_Imagem),	(short) (indice+1), rowCount_Imagem + 1);
						
						int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
						patriarch.createPicture(anchor, index);
						anchor.setAnchorType(0);
					} catch (Exception e) {
					}
					

				}
			}

			
			if (p_tipo.equalsIgnoreCase("ean13")) { 
				testsheet.setColumnWidth((agruparModelo ? 10 : 11), 4600);
			} else if (p_tipo.equalsIgnoreCase("dun14")) {
				testsheet.setColumnWidth((agruparModelo ? 9 : 10), 4600);
			} else if (p_tipo.equalsIgnoreCase("ambos")) {
				testsheet.setColumnWidth((agruparModelo ? 13 : 14), 4600);
			}
			
			wb.write(fos);
			fos.close();
			try {
				retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return retorno;
	}
}
