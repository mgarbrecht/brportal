package util.consultas.com;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import java.io.*;
import java.sql.SQLException;

public class EmbarqueAmostra {


	public String geraExcel(String p_dt_inicial
			               ,String p_dt_final
			               ,String p_marca
			               ,String p_filial
			               ,String p_tipo_linha
			               ,String p_mix_produtos
			               ,String p_fator
			               ,String p_livro) {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("Embarque Amostras");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFRow trowpares;
		org.apache.poi.hssf.usermodel.HSSFRow trowfilial;
		org.apache.poi.hssf.usermodel.HSSFRow trowdetalhes;
		org.apache.poi.hssf.usermodel.HSSFRow trowdetalhes2;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		// --------------------------------
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleTipoLinha;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleLinha;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleFilial;

		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		java.sql.ResultSet rsett = null;
		java.sql.ResultSet rsetl = null;
		java.sql.ResultSet rsetr = null;
		java.sql.ResultSet rsetresumo = null;

		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sbm = new StringBuilder();
		StringBuilder sbt = new StringBuilder();
		StringBuilder sbl = new StringBuilder();
		StringBuilder sbr = new StringBuilder();
		StringBuilder sbresumo = new StringBuilder();
		
		int rowcount = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			nomeArquivo.append("embarqueamostras").append(util.rand.Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("Embarque Amostras");
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleright = wb.createCellStyle();
			stylecenterborda = wb.createCellStyle();
			styleGrade = wb.createCellStyle();
			styleTipoLinha = wb.createCellStyle();
			styleLinha = wb.createCellStyle();
			styleFilial = wb.createCellStyle();

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
			stylecenter.setFillBackgroundColor((short) 5);

			// --- Style Tipo Linha ------------
			
			styleTipoLinha.setAlignment((short) 2);
			
			Font font = wb.createFont();
			font.setFontHeightInPoints((short) 12);
			font.setFontName("Arial");
			font.setBoldweight((short) 2);
			styleTipoLinha.setFont(font);
			styleTipoLinha.setFillForegroundColor(HSSFColor.TAN.index);
			styleTipoLinha.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			// ----------------------------------

			// --- Style Linha ------------------
			Font fontLinha = wb.createFont();
			fontLinha.setFontHeightInPoints((short) 12);
			fontLinha.setFontName("Arial");
			fontLinha.setItalic(true);
			fontLinha.setBoldweight((short) 2);
			styleLinha.setFont(fontLinha);
			styleLinha.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			styleLinha.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
			
			// --- Style Filial ------------------
			Font fontFilial = wb.createFont();
			fontFilial.setFontHeightInPoints((short) 12);
			fontFilial.setFontName("Arial");
			fontFilial.setBoldweight((short) 24);
			styleFilial.setFont(fontFilial);	
			styleFilial.setAlignment((short)2);
			// ----------------------------------			
			styleright.setAlignment((short) 4);
			
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sbtam = new StringBuilder();
			sbtam.append(" SELECT MAX(refs)*2 FROM ( ");
			sbtam.append(" 		 SELECT r.lin_cdgo ");
			sbtam.append(" 		      , count(r.ref_cdgo) refs ");
			sbtam.append(" 		   FROM ref r   ");
			sbtam.append(" 		      , lin l   ");
			sbtam.append(" 		      , marcas_produtos mp ");  
			sbtam.append(" 		      , filial f  ");
			sbtam.append("  WHERE l.lin_cdgo = r.lin_cdgo  ");
			if(p_dt_inicial != null && !p_dt_inicial.equals("")){
				sbtam.append("    AND r.data_embarque >= to_date('").append(p_dt_inicial).append("','dd/mm/yyyy') "); 				
			}
			if(p_dt_final != null && !p_dt_final.equals("")){
				sbtam.append("    AND r.data_embarque <= to_date('").append(p_dt_final).append("','dd/mm/yyyy') "); 				
			}			
			sbtam.append("    AND (NVL('").append(p_mix_produtos).append("', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '").append(p_mix_produtos).append("') ");
			sbtam.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca  ");
			sbtam.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			if (p_marca != null) {
				sbtam.append("    AND mp.codigo_marca = ").append(p_marca);
			}
			if (p_tipo_linha != null) {
				sbtam.append("    AND l.ind_aberto_fechado = '").append(p_tipo_linha).append("'");
			}
			if (p_filial != null) {
				sbtam.append("    AND f.fil_filial = '").append(p_filial).append("'");
			} 
			sbtam.append(" 		GROUP BY  r.lin_cdgo ) ");
			
			util.consultas.Query query = new util.consultas.Query();
			int tamanho = Integer.parseInt(query.retorna(j, sbtam.toString()));
			// --- Marca ----------------------
			sbm.append(" SELECT DISTINCT fct_marca_produto(r.lin_cdgo, r.ref_cdgo) marca  ");
			sbm.append("      , pck_marcas_produtos.get_nome(fct_marca_produto(r.lin_cdgo, r.ref_cdgo)) descricao_marca  ");
			sbm.append("   FROM ref r  ");
			sbm.append("      , lin l  ");
			sbm.append("      , marcas_produtos mp  ");
			sbm.append("      , filial f ");
			sbm.append("  WHERE l.lin_cdgo = r.lin_cdgo  ");
			if(p_dt_inicial != null && !p_dt_inicial.equals("")){
				sbm.append("    AND r.data_embarque >= to_date('").append(p_dt_inicial).append("','dd/mm/yyyy') "); 				
			}
			if(p_dt_final != null && !p_dt_final.equals("")){
				sbm.append("    AND r.data_embarque <= to_date('").append(p_dt_final).append("','dd/mm/yyyy') "); 				
			}			
			sbm.append("    AND (NVL('").append(p_mix_produtos).append("', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '").append(p_mix_produtos).append("') ");
			sbm.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca  ");
			sbm.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			if (p_marca != null) {
				sbm.append("    AND mp.codigo_marca = ").append(p_marca);
			}
			if (p_tipo_linha != null) {
				sbm.append("    AND l.ind_aberto_fechado = '").append(p_tipo_linha).append("'");
			}
			if (p_filial != null) {
				sbm.append("    AND f.fil_filial = '").append(p_filial).append("'");
			}
			sbm.append("  ORDER BY marca   ");
			
			
			// --- Tipo Linha -------------------
			sbt.append(" SELECT DISTINCT fct_marca_produto(r.lin_cdgo, r.ref_cdgo) marca  ");
			sbt.append("      , pck_marcas_produtos.get_nome(fct_marca_produto(r.lin_cdgo, r.ref_cdgo)) descricao_marca  ");
			sbt.append("      , cg.rv_meaning tipo_linha  ");
			sbt.append("      , l.ind_aberto_fechado  ");
			sbt.append("   FROM REF r  ");
			sbt.append("      , lin l  ");
			sbt.append("      , (SELECT * FROM cg_ref_codes where RV_DOMAIN = 'IND_ABERTO_FECHADO' ) cg  ");
			sbt.append("      , marcas_produtos mp  ");
			sbt.append("      , filial f ");
			sbt.append("  WHERE l.lin_cdgo = r.lin_cdgo  ");
			sbt.append("    AND cg.rv_low_value = l.ind_aberto_fechado  ");
			if(p_dt_inicial != null && !p_dt_inicial.equals("")){
				sbt.append("    AND r.data_embarque >= to_date('").append(p_dt_inicial).append("','dd/mm/yyyy') "); 				
			}
			if(p_dt_final != null && !p_dt_final.equals("")){
				sbt.append("    AND r.data_embarque <= to_date('").append(p_dt_final).append("','dd/mm/yyyy') "); 				
			}		
			sbt.append("    AND (NVL('"	+ p_mix_produtos+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+ p_mix_produtos + "') ");
			sbt.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca  ");
			sbt.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			if (p_marca != null) {
				sbt.append("    AND mp.codigo_marca = " + p_marca);
			}
			if (p_tipo_linha != null) {
				sbt.append("    AND l.ind_aberto_fechado = '" + p_tipo_linha + "'");
			}
			if (p_filial != null) {
				sbt.append("    AND f.fil_filial = '" + p_filial + "'");
			}			
			sbt.append("    AND mp.codigo_marca = ?   ");
			sbt.append("  ORDER BY marca  ");
			sbt.append("         , tipo_linha  ");

			// --- Linha ---
			sbl.append(" SELECT DISTINCT l.lin_cdgo ");
			sbl.append("   FROM REF r ");
			sbl.append("      , lin l ");
			sbl.append("      , marcas_produtos mp ");
			sbl.append("      , filial f ");
			sbl.append("  WHERE l.lin_cdgo = r.lin_cdgo ");
			if(p_dt_inicial != null && !p_dt_inicial.equals("")){
				sbl.append("    AND r.data_embarque >= to_date('"+ p_dt_inicial + "','dd/mm/yyyy') "); 				
			}
			if(p_dt_final != null && !p_dt_final.equals("")){
				sbl.append("    AND r.data_embarque <= to_date('"+ p_dt_final + "','dd/mm/yyyy') "); 				
			}
			sbl.append("    and mp.codigo_marca = ? ");
			sbl.append("    AND l.ind_aberto_fechado = ? ");
			sbl.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
			sbl.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			if (p_marca != null) {
				sbl.append("    AND mp.codigo_marca = " + p_marca);
			}
			if (p_tipo_linha != null) {
				sbl.append("    AND l.ind_aberto_fechado = '" + p_tipo_linha + "'");
			}
			if (p_filial != null) {
				sbl.append("    AND f.fil_filial = '" + p_filial + "'");
			}			
			sbl.append("    AND (NVL('"+ p_mix_produtos	+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+ p_mix_produtos + "') ");
			sbl.append("  ORDER BY lin_cdgo ");
			

			// --- Referencia ---
			sbr.append(" SELECT DISTINCT r.lin_cdgo ");
			sbr.append("               , r.ref_cdgo ");
			sbr.append("               , trunc(brio.fct_preco_medio_vendor(l.lin_cdgo, r.ref_cdgo, 999, sysdate, "+p_livro+") * "+p_fator+") preco ");
			sbr.append("               , (SELECT fct_retorna_fit_imagem(r.lin_cdgo, r.ref_cdgo) from dual) imagem ");
			sbr.append("               , to_char(r.data_embarque,'dd/mm') data_embarque_reduzida ");
			sbr.append("               , f.fil_filial ");
			sbr.append("               , (SELECT trim(to_char(pares_modelo,'999,999,990')) FROM mv_posicao_venda_modelo WHERE lin_cdgo = r.lin_cdgo and ref_cdgo = r.ref_cdgo AND ROWNUM = 1) pares_modelo ");			
			sbr.append("   FROM REF r ");
			sbr.append("      , lin l ");
			sbr.append("      , marcas_produtos mp ");
			sbr.append("      , filial f ");
			sbr.append("  WHERE l.lin_cdgo = r.lin_cdgo ");
			if(p_dt_inicial != null && !p_dt_inicial.equals("")){
				sbr.append("    AND r.data_embarque >= to_date('"+ p_dt_inicial + "','dd/mm/yyyy') "); 				
			}
			if(p_dt_final != null && !p_dt_final.equals("")){
				sbr.append("    AND r.data_embarque <= to_date('"+ p_dt_final + "','dd/mm/yyyy') "); 				
			}		
			sbr.append("    AND mp.codigo_marca = ? ");
			sbr.append("    AND l.ind_aberto_fechado = ? ");
			sbr.append("    AND r.lin_cdgo = ? ");
			sbr.append("    AND (NVL('"+ p_mix_produtos	+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+ p_mix_produtos + "') ");
			sbr.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
			sbr.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			if (p_marca != null) {
				sbr.append("    AND mp.codigo_marca = " + p_marca);
			}
			if (p_tipo_linha != null) {
				sbr.append("    AND l.ind_aberto_fechado = '" + p_tipo_linha + "'");
			}
			if (p_filial != null) {
				sbr.append("    AND f.fil_filial = '" + p_filial + "'");
			}			
			sbr.append("  ORDER by r.ref_cdgo ");
			
			// --- Add Parametros ---
			String mixDesc = null;
			if (p_mix_produtos.equals("T")) {
				mixDesc = "Todos";
			} else if (p_mix_produtos.equals("M")) {
				mixDesc = "No Mix";
			} else {
				mixDesc = "Fora Mix";
			}
			CellRangeAddress region = new CellRangeAddress(rowcount, 0, 0, 10);
			sheet.addMergedRegion(region);
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("Data Embarque: " + p_dt_inicial + " a "	+ p_dt_final + "  | Mix: " + mixDesc);
			rowcount++;
			// ----------------------
			pstm = j.getConn().prepareStatement(sbm.toString());
			rset = pstm.executeQuery();
			// --- Marcas ---
			while (rset.next()) {
				gerou = true;
				String imagem = null;
				String diretorio = "/opt/tomcat/webapps/brportal/img/";
				if (rset.getString("marca").equals("1")) {
					imagem = "vizzano.png";
				} else if (rset.getString("marca").equals("3")) {
					imagem = "beirario.png";
				} else if (rset.getString("marca").equals("16")) {
					imagem = "moleca.png";
				} else if (rset.getString("marca").equals("17")) {
					imagem = "molekinha.png";
				} else if (rset.getString("marca").equals("18")) {
					imagem = "brsport.png";
				} else {
					imagem = "default.jpg";
				}

				String arquivo = diretorio + imagem;
				java.io.File f = new java.io.File(arquivo);

				FileInputStream fis = new FileInputStream(arquivo);
				ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
				int b;
				while ((b = fis.read()) != -1){
					img_bytes.write(b);
				}
				fis.close();
				HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) (0), (rowcount + 1), (short) (2), rowcount + 5);
				int index = wb.addPicture(img_bytes.toByteArray(),	HSSFWorkbook.PICTURE_TYPE_JPEG);
				patriarch.createPicture(anchor, index);
				anchor.setAnchorType(1);

				// --- Tipos Linhas --
				pstm = j.getConn().prepareStatement(sbt.toString());
				pstm.setString(1, rset.getString("marca"));
				rsett = pstm.executeQuery();
				rowcount += 5;

				while (rsett.next()) {
					trow = testsheet.createRow(rowcount);
					region = new CellRangeAddress(rowcount, rowcount, 1, tamanho);
					sheet.addMergedRegion(region);
					tcell = trow.createCell(1);
					tcell.setCellValue(rsett.getString("tipo_linha"));
					tcell.setCellStyle(styleTipoLinha);
					RegionUtil.setBorderBottom(1, region, testsheet, wb);
					RegionUtil.setBorderTop(1, region, testsheet, wb);
					RegionUtil.setBorderLeft(1, region, testsheet, wb);
					RegionUtil.setBorderRight(1, region, testsheet, wb);
					++rowcount;

					// --- Linha -----
					pstm = j.getConn().prepareStatement(sbl.toString());
					pstm.setString(1, rset.getString("marca"));
					pstm.setString(2, rsett.getString("ind_aberto_fechado"));
					rsetl = pstm.executeQuery();
					while (rsetl.next()) {
						trow = testsheet.createRow(rowcount);
						region = new CellRangeAddress(rowcount, rowcount, 1, tamanho);	
						sheet.addMergedRegion(region);						
						tcell = trow.createCell(1);
						tcell.setCellValue(rsetl.getString("lin_cdgo"));
						tcell.setCellStyle(styleLinha);
						RegionUtil.setBorderBottom(1, region, testsheet, wb);
						RegionUtil.setBorderTop(1, region, testsheet, wb);
						RegionUtil.setBorderLeft(1, region, testsheet, wb);
						RegionUtil.setBorderRight(1, region, testsheet, wb);							
						
						/*
						trow = testsheet.createRow(++rowcount);
						region = new CellRangeAddress(rowcount, rowcount, 1, tamanho);	
						sheet.addMergedRegion(region);						
						tcell = trow.createCell(1);
						tcell.setCellValue("Venda Geral: "+ rsetl.getString("pares_linha"));
						//tcell.setCellStyle(styleLinha);
						RegionUtil.setBorderBottom(1, region, testsheet, wb);
						RegionUtil.setBorderTop(1, region, testsheet, wb);
						RegionUtil.setBorderLeft(1, region, testsheet, wb);
						RegionUtil.setBorderRight(1, region, testsheet, wb);
						*/
						
						// --- Referencia -----
						pstm = j.getConn().prepareStatement(sbr.toString());
						pstm.setString(1, rset.getString("marca"));
						pstm.setString(2, rsett.getString("ind_aberto_fechado"));
						pstm.setString(3, rsetl.getString("lin_cdgo"));
						rsetr = pstm.executeQuery();
						int ref = 1;
						trow = testsheet.createRow(++rowcount);
						trowpares = testsheet.createRow(rowcount+1);
						trowdetalhes = testsheet.createRow(rowcount + 6);
						trowdetalhes2 = testsheet.createRow(rowcount + 7);
						while (rsetr.next()) {
							trowfilial = testsheet.createRow(rowcount + 3);
							tcell = trowfilial.createCell(0);
							tcell.setCellValue(rsetr.getString("fil_filial"));
							tcell.setCellStyle(styleFilial);
							 
							region = new CellRangeAddress(rowcount, rowcount,ref, ref + 1);
							sheet.addMergedRegion(region);
							tcell = trow.createCell(ref);
							tcell.setCellValue(rsetl.getString("lin_cdgo")	+ " - " + rsetr.getString("ref_cdgo"));
							tcell.setCellStyle(stylecenter);
							RegionUtil.setBorderBottom(1, region, testsheet, wb);
							RegionUtil.setBorderTop(1, region, testsheet, wb);
							RegionUtil.setBorderLeft(1, region, testsheet, wb);
							RegionUtil.setBorderRight(1, region, testsheet, wb);
							
							region = new CellRangeAddress(rowcount+1, rowcount+1, ref, ref + 1);
							sheet.addMergedRegion(region);
							tcell = trowpares.createCell(ref);
							tcell.setCellValue(rsetr.getString("pares_modelo")==null?"0":rsetr.getString("pares_modelo"));
							tcell.setCellStyle(stylecenter);
							RegionUtil.setBorderBottom(1, region, testsheet, wb);
							RegionUtil.setBorderTop(1, region, testsheet, wb);
							RegionUtil.setBorderLeft(1, region, testsheet, wb);
							RegionUtil.setBorderRight(1, region, testsheet, wb);							
							diretorio = "/opt/tomcat/webapps/brportal/imagens/pequenas/";

							arquivo = diretorio + rsetr.getString("imagem");
							f = new java.io.File(arquivo);
							if (!f.isFile()) {
								arquivo = diretorio + "default_prod.jpg";
							}

							fis = new FileInputStream(arquivo);
							img_bytes = new ByteArrayOutputStream();
							int b1;
							while ((b1 = fis.read()) != -1)
								img_bytes.write(b1);
							fis.close();
							anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) (ref), (rowcount + 2),	(short) (ref + 2), rowcount + 6);
							index = wb.addPicture(img_bytes.toByteArray(),	HSSFWorkbook.PICTURE_TYPE_JPEG);
							patriarch.createPicture(anchor, index);
							anchor.setAnchorType(2);
							
							region = new CellRangeAddress(rowcount + 2,	rowcount + 5, ref, ref + 1);
							sheet.addMergedRegion(region);
							RegionUtil.setBorderBottom(1, region, testsheet, wb);
							RegionUtil.setBorderTop(1, region, testsheet, wb);
							RegionUtil.setBorderLeft(1, region, testsheet, wb);
							RegionUtil.setBorderRight(1, region, testsheet, wb);
							// ------------------------------------------
							tcell = trowdetalhes.createCell(ref);
							tcell.setCellValue("Emb.");
							tcell = trowdetalhes.createCell(ref + 1);
							tcell.setCellStyle(stylecenter);
							tcell.setCellValue("PDV");
							tcell = trowdetalhes2.createCell(ref);
							tcell.setCellValue(rsetr.getString("data_embarque_reduzida"));
							tcell = trowdetalhes2.createCell(ref + 1);
							tcell.setCellStyle(stylecenter);
							tcell.setCellValue(rsetr.getDouble("preco"));
							// ------------------------------------------
							ref += 2;
						}
						// ++rowcount;
						rowcount += 8;
					}
				}
			}
			if(gerou){
				rowcount +=3;
				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(0);
				tcell.setCellValue("Resumo Geral");
				tcell.setCellStyle(styleTipoLinha);
				region = new CellRangeAddress(rowcount, rowcount,0, 1);
				sheet.addMergedRegion(region);				
				rowcount +=2;
				if(rset != null){
					rset.close();
				}
				if(pstm != null){
					pstm.close();
				}
				pstm = j.getConn().prepareStatement(sbm.toString());
				rset = pstm.executeQuery();
				while (rset.next()) {
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(0);
					tcell.setCellValue(rset.getString("descricao_marca"));
					tcell.setCellStyle(styleTipoLinha);
					region = new CellRangeAddress(rowcount, rowcount,0, 2);
					sheet.addMergedRegion(region);	
					//------------
					sbresumo = new StringBuilder();
					sbresumo.append("SELECT cg.rv_meaning tipo_linha ");
					sbresumo.append("     , COUNT(DISTINCT l.lin_cdgo) qtd_linhas ");
					sbresumo.append("  FROM REF r ");
					sbresumo.append("     , lin l ");
					sbresumo.append("     , (SELECT * ");
					sbresumo.append("         FROM cg_ref_codes ");
					sbresumo.append("        WHERE rv_domain = 'IND_ABERTO_FECHADO') cg ");
					sbresumo.append("     , marcas_produtos mp ");
					sbresumo.append("     , filial f ");
					sbresumo.append(" WHERE l.lin_cdgo = r.lin_cdgo ");
					sbresumo.append("   AND cg.rv_low_value = l.ind_aberto_fechado ");
					if(p_dt_inicial != null && !p_dt_inicial.equals("")){
						sbresumo.append("    AND r.data_embarque >= to_date('"+ p_dt_inicial + "','dd/mm/yyyy') "); 				
					}
					if(p_dt_final != null && !p_dt_final.equals("")){
						sbresumo.append("    AND r.data_embarque <= to_date('"+ p_dt_final + "','dd/mm/yyyy') "); 				
					}		
					sbresumo.append("    AND (NVL('"+ p_mix_produtos	+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+ p_mix_produtos + "') ");
					sbresumo.append("   AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
					sbresumo.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
					sbresumo.append("    AND mp.codigo_marca = " + rset.getString("marca"));
					if (p_tipo_linha != null) {
						sbresumo.append("    AND l.ind_aberto_fechado = '" + p_tipo_linha + "'");
					}
					if (p_filial != null) {
						sbresumo.append("    AND f.fil_filial = '" + p_filial + "'");
					} 
					sbresumo.append(" GROUP BY cg.rv_meaning ");
					pstm = j.getConn().prepareStatement(sbresumo.toString());
					rsetresumo = pstm.executeQuery();
					rowcount +=1;
					
					int totalPares = 0;
					
					while (rsetresumo.next()) {
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue(rsetresumo.getString("tipo_linha"));
						tcell = trow.createCell(2);
						tcell.setCellValue(Integer.parseInt(rsetresumo.getString("qtd_linhas")));
						totalPares += Integer.parseInt(rsetresumo.getString("qtd_linhas"));
						
						rowcount++;
					}
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(0);
					tcell.setCellValue("Total");
					tcell.setCellStyle(styleLinha);
					tcell = trow.createCell(1);
					tcell.setCellStyle(styleLinha);
					tcell = trow.createCell(2);
					tcell.setCellValue(totalPares);
					tcell.setCellStyle(styleLinha);
					rowcount+=2;
				}
			}
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (java.sql.SQLException e) {
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (java.sql.SQLException e) {
				}
			}

			if (rsett != null) {
				try {
					rsett.close();
				} catch (java.sql.SQLException e) {
				}
			}

			if (j != null) {
				j.close();
				j = null;
			}
		}
		if (gerou) {
			try {
				retorno = parametros.retornaParametro("diretorio_link_pdf")	+ nomeArquivo.toString();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			retorno = "";
		}
		return retorno;
	}
}