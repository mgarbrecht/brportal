package util.consultas.com;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import java.io.*;
import java.sql.SQLException;

public class EmbarqueAmostrasBackup {

	public String geraExcel(String p_dt_inicial
			               ,String p_dt_final
			               ,String p_marca
			               ,String p_filial
			               ,String p_tipo_linha
			               ,String p_mix_produtos)
			 {
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("Embarque Amostras");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFRow trowfilial;
		org.apache.poi.hssf.usermodel.HSSFRow trowdetalhes;
		org.apache.poi.hssf.usermodel.HSSFRow trowdetalhes2;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleTipoLinha;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleLinha;
		
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
//		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet rsett = null;
		java.sql.ResultSet rsetd = null;
		java.sql.ResultSet rsetf = null;
		java.sql.ResultSet rsetl = null;
		java.sql.ResultSet rsetr = null;	
//		java.sql.PreparedStatement pstmc = null;
//		java.sql.ResultSet rsetc = null;
//		java.sql.PreparedStatement pstmg = null;
//		java.sql.ResultSet rsetg = null;
//		java.sql.ResultSet rsettg = null;
//		java.sql.PreparedStatement pstmtg = null;

		/* novos */
//		String marca = null;
//		String marcaAntiga = null;
//		String tipoLinha = null;
//		String tipoLinhaAntiga = null;
//		String filial = null;
//		String filialAntiga = null;
//		String dataEmbarque = null;
//		String dataEmbarqueAntiga = null;

		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
//		StringBuilder sb = new StringBuilder();
		StringBuilder sbm = new StringBuilder();
		StringBuilder sbt = new StringBuilder();
		StringBuilder sbd = new StringBuilder();
		StringBuilder sbf = new StringBuilder();
		StringBuilder sbl = new StringBuilder();
		StringBuilder sbr = new StringBuilder();
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
			stylecenter.setFillBackgroundColor((short)5);
	
			//--- Style Tipo Linha ------------
		    styleTipoLinha.setAlignment((short) 2);
		    Font font = wb.createFont();
		    font.setFontHeightInPoints((short)16);
		    font.setFontName("Arial");
		    font.setBoldweight((short)2);
		    styleTipoLinha.setFont(font);		
		    //----------------------------------
		    
			//--- Style Linha ------------
		    Font fontLinha = wb.createFont();
		    fontLinha.setFontHeightInPoints((short)14);
		    fontLinha.setFontName("Arial");
		    fontLinha.setItalic(true);
		    fontLinha.setBoldweight((short)4);
		    styleLinha.setFont(fontLinha);		
		    //----------------------------------		    
			styleright.setAlignment((short) 4);

     		FileOutputStream fos=new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+nomeArquivo.toString());
			//FileOutputStream fos = new FileOutputStream("c:/teste/teste.xls");

			j = new com.egen.util.jdbc.JdbcUtil();
			
            //--- Marca ----------------------
			sbm.append(" SELECT DISTINCT fct_marca_produto(r.lin_cdgo, r.ref_cdgo) marca  ");
			sbm.append("      , pck_marcas_produtos.get_nome(fct_marca_produto(r.lin_cdgo, r.ref_cdgo)) descricao_marca  ");
			sbm.append("   FROM ref r  ");
			sbm.append("      , lin l  ");
			sbm.append("      , marcas_produtos mp  ");
			sbm.append("      , filial f ");
			sbm.append("  WHERE l.lin_cdgo = r.lin_cdgo  ");
			sbm.append("    AND r.data_embarque BETWEEN to_date('"+ p_dt_inicial + "','dd/mm/yyyy') AND to_date('"	+ p_dt_final + "','dd/mm/yyyy') ");
			sbm.append("    AND (NVL('"+p_mix_produtos+"', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+p_mix_produtos+"') ");
			sbm.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca  ");
			sbm.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			if(p_marca != null){
				sbm.append("    AND mp.codigo_marca = " + p_marca);
			}
			if(p_tipo_linha != null){
				sbm.append("    AND l.ind_aberto_fechado = '" + p_tipo_linha + "'");				
			}
			if(p_filial != null){
				sbm.append("    AND f.fil_filial = '" + p_filial + "'");
			}
			sbm.append("  ORDER BY marca   ");	

			//--- Tipo Linha -------------------			
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
			sbt.append("    AND r.data_embarque BETWEEN to_date('"+ p_dt_inicial + "','dd/mm/yyyy') AND to_date('"	+ p_dt_final + "','dd/mm/yyyy') ");
			sbt.append("    AND (NVL('"+p_mix_produtos+"', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+p_mix_produtos+"') ");			
			sbt.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca  ");
			sbt.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			sbt.append("    AND mp.codigo_marca = ?   ");
			sbt.append("  ORDER BY marca  ");
			sbt.append("         , tipo_linha  ");

			//--- Data ---------------------------
			sbd.append(" SELECT DISTINCT to_char(r.data_embarque,'dd/mm/yyyy') data_embarque ");
			sbd.append("      , to_char(r.data_embarque,'dd/mm') data_embarque_reduzida ");
			sbd.append("   FROM REF r ");
			sbd.append("      , lin l ");
			sbd.append("      , marcas_produtos mp ");
			sbd.append("  WHERE l.lin_cdgo = r.lin_cdgo ");
			sbd.append("    AND r.data_embarque BETWEEN to_date('"+ p_dt_inicial + "','dd/mm/yyyy') AND to_date('"	+ p_dt_final + "','dd/mm/yyyy') ");
			sbd.append("    AND (NVL('"+p_mix_produtos+"', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+p_mix_produtos+"') ");			
			sbd.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
			sbd.append("    AND mp.codigo_marca = ? ");
			sbd.append("    AND l.ind_aberto_fechado = ? ");
			sbd.append("  ORDER BY r.lin_cdgo ");
			
			//--- Filial ----------------
			sbf.append(" SELECT DISTINCT f.fil_filial ");
			sbf.append("   FROM REF r ");
			sbf.append("      , lin l ");
			sbf.append("      , marcas_produtos mp ");
			sbf.append("      , filial f ");
			sbf.append("  WHERE l.lin_cdgo = r.lin_cdgo ");
			//sbf.append("    AND r.data_embarque = to_date(?, 'dd/mm/yyyy') ");
			sbf.append("    AND r.data_embarque BETWEEN to_date('"+ p_dt_inicial + "','dd/mm/yyyy') AND to_date('"	+ p_dt_final + "','dd/mm/yyyy') ");			
			sbf.append("    and mp.codigo_marca = ? ");
			sbf.append("    AND l.ind_aberto_fechado = ? ");
			sbf.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
			sbf.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			sbf.append("    AND (NVL('"+p_mix_produtos+"', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+p_mix_produtos+"') ");			
			sbf.append("  ORDER BY fil_filial ");

			//--- Linha ---
			sbl.append(" SELECT DISTINCT l.lin_cdgo ");
			sbl.append("   FROM REF r ");
			sbl.append("      , lin l ");
			sbl.append("      , marcas_produtos mp ");
			sbl.append("      , filial f ");
			sbl.append("  WHERE l.lin_cdgo = r.lin_cdgo ");
			sbl.append("    AND r.data_embarque = to_date(?, 'dd/mm/yyyy') ");
			sbl.append("    and mp.codigo_marca = ? ");
			sbl.append("    AND l.ind_aberto_fechado = ? ");
			sbl.append("    AND f.fil_filial = ? ");
			sbl.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
			sbl.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			sbl.append("    AND (NVL('"+p_mix_produtos+"', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+p_mix_produtos+"') ");			
			sbl.append("  ORDER BY lin_cdgo  ");

			//--- Referencia ---
			sbr.append(" SELECT DISTINCT r.lin_cdgo ");
			sbr.append("               , r.ref_cdgo ");
			sbr.append("               , trunc(brio.fct_preco_medio_vendor(l.lin_cdgo, r.ref_cdgo) * 2.1) preco ");
			sbr.append("               , (SELECT fit_imagem FROM ficha_tec WHERE lin_cdgo = r.lin_cdgo AND ref_cdgo = r.ref_cdgo AND ROWNUM = 1) imagem ");
			sbr.append("   FROM REF r ");
			sbr.append("      , lin l ");
			sbr.append("      , marcas_produtos mp ");
			sbr.append("      , filial f ");
			sbr.append("  WHERE l.lin_cdgo = r.lin_cdgo ");
			sbr.append("    AND r.data_embarque = TO_DATE(?, 'dd/mm/yyyy') ");
			sbr.append("    AND mp.codigo_marca = ? ");
			sbr.append("    AND l.ind_aberto_fechado = ? ");
			sbr.append("    AND f.fil_filial = ? ");
			sbr.append("    AND r.lin_cdgo = ? ");
			sbr.append("    AND (NVL('"+p_mix_produtos+"', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '"+p_mix_produtos+"') ");			
			sbr.append("    AND fct_marca_produto(r.lin_cdgo, r.ref_cdgo) = mp.codigo_marca ");
			sbr.append("    AND fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) = f.fil_filial ");
			
			
			
			//--- Add Parametros ---
			String mixDesc = null;
			if(p_mix_produtos.equals("T")){
				mixDesc = "Todos";
			} else if(p_mix_produtos.equals("M")){
				mixDesc = "No Mix";
			} else {
				mixDesc = "Fora Mix";
			}
			CellRangeAddress region = new CellRangeAddress(rowcount, 0, 0, 10);
			sheet.addMergedRegion(region);
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("Data Embarque: " + p_dt_inicial + " a " + p_dt_final + "  | Mix: " + mixDesc);
			rowcount++;
			//----------------------
//			int cont = 0;
			pstm = j.getConn().prepareStatement(sbm.toString());
			rset = pstm.executeQuery();
			//--- Marcas --- Monta Layout ######################################
			while (rset.next()) {
				gerou = true;
//				rowcount_imagem = rowcount + 1;
				
				String imagem = null;
				
				//trow = testsheet.createRow(rowcount);
				//tcell = trow.createCell(0);
				//tcell.setCellValue(rset.getString("descricao_marca"));
				//tcell.setCellStyle(stylecenter);

  			    String diretorio = "/opt/tomcat/webapps/brportal/img/";
				//String diretorio = "c:/teste/";
  			    
  			    if(rset.getString("marca").equals("1")){
  			    	imagem = "vizzano.png";
  			    }
  			    if(rset.getString("marca").equals("3")){
  			    	imagem = "beirario.png";
  			    }
  			    if(rset.getString("marca").equals("16")){
  			    	imagem = "moleca.png";
  			    }  			    
  			    if(rset.getString("marca").equals("17")){
  			    	imagem = "molekinha.png";
  			    }  			    
  			    if(rset.getString("marca").equals("18")){
  			    	imagem = "brsport.png";
  			    }  			      			    
  			    
			    String arquivo = diretorio + imagem;
  			  java.io.File f = new java.io.File(arquivo);
  	
  			  
  			  FileInputStream fis=new FileInputStream(arquivo);
  			  ByteArrayOutputStream img_bytes=new ByteArrayOutputStream();
  			  int b; 
  			  while((b=fis.read())!=-1)
  				  img_bytes.write(b);  
  			  fis.close();
  			  HSSFClientAnchor anchor = new HSSFClientAnchor(0,0,0,0,(short)(0),(rowcount+1) ,(short)(2),rowcount+5);
  			  int index=wb.addPicture(img_bytes.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG);
  			  patriarch.createPicture(anchor,index);
  			  anchor.setAnchorType(1);

				// --- Tipos Linhas -- Monta Layout ######################################
				pstm = j.getConn().prepareStatement(sbt.toString());
				pstm.setString(1, rset.getString("marca"));
				rsett = pstm.executeQuery();
				
				//++rowcount;
				rowcount += 5;
				
				while (rsett.next()) {
				
					trow = testsheet.createRow(rowcount);
					region = new CellRangeAddress(rowcount, rowcount, 1, 11);
					sheet.addMergedRegion(region);
					tcell = trow.createCell(1);
					tcell.setCellValue(rsett.getString("tipo_linha"));
					tcell.setCellStyle(styleTipoLinha);
					RegionUtil.setBorderBottom( 1,  region, testsheet, wb );
					RegionUtil.setBorderTop( 1,  region, testsheet, wb );
					RegionUtil.setBorderLeft( 1,  region, testsheet, wb );
					RegionUtil.setBorderRight( 1,  region, testsheet, wb );		
					++rowcount;
					
					//--- Data -----
					pstm = j.getConn().prepareStatement(sbd.toString());
					pstm.setString(1, rset.getString("marca"));
					pstm.setString(2, rsett.getString("ind_aberto_fechado"));					
					rsetd = pstm.executeQuery();				
					while (rsetd.next()) {
						/*
						rowcount_imagem = rowcount + 1;
						trow = testsheet.createRow(rowcount);						
						tcell = trow.createCell(0);
						tcell.setCellValue(rsetd.getString("data_embarque"));
						tcell.setCellStyle(stylecenter);
						++rowcount;
						*/
						//--- Filial ----
						pstm = j.getConn().prepareStatement(sbf.toString());
						//pstm.setString(1, rsetd.getString("data_embarque"));
						//pstm.setString(2, rset.getString("marca"));
						//pstm.setString(3, rsett.getString("ind_aberto_fechado"));
						pstm.setString(1, rset.getString("marca"));
						pstm.setString(2, rsett.getString("ind_aberto_fechado"));
						rsetf = pstm.executeQuery();	
						
						while (rsetf.next()) {
							/*
							rowcount_imagem = rowcount + 1;
							trow = testsheet.createRow(rowcount);						
							tcell = trow.createCell(0);
							tcell.setCellValue(rsetf.getString("fil_filial"));
							tcell.setCellStyle(stylecenter);
							++rowcount;
							*/
							//CellRangeAddress region2 = CellRangeAddress.valueOf("B2:E5"); // region
							//--- Linha -----
							pstm = j.getConn().prepareStatement(sbl.toString());
							pstm.setString(1, rsetd.getString("data_embarque"));
							pstm.setString(2, rset.getString("marca"));
							pstm.setString(3, rsett.getString("ind_aberto_fechado"));
							pstm.setString(4, rsetf.getString("fil_filial"));							
							rsetl = pstm.executeQuery();			
							while (rsetl.next()) {
								trow = testsheet.createRow(rowcount);						
								tcell = trow.createCell(1);
								tcell.setCellValue(rsetl.getString("lin_cdgo"));
								tcell.setCellStyle(styleLinha);
								//--- Referencia -----
								pstm = j.getConn().prepareStatement(sbr.toString());
								pstm.setString(1, rsetd.getString("data_embarque"));
								pstm.setString(2, rset.getString("marca"));
								pstm.setString(3, rsett.getString("ind_aberto_fechado"));
								pstm.setString(4, rsetf.getString("fil_filial"));
								pstm.setString(5, rsetl.getString("lin_cdgo"));									
								rsetr = pstm.executeQuery();
								int ref = 1;
								trow = testsheet.createRow(++rowcount);
								trowdetalhes = testsheet.createRow(rowcount+5);
								trowdetalhes2 = testsheet.createRow(rowcount+6);
								while (rsetr.next()) {
								
									trowfilial = testsheet.createRow(rowcount+2);
									tcell = trowfilial.createCell(0);
									tcell.setCellValue(rsetf.getString("fil_filial"));
									
									region = new CellRangeAddress(rowcount, rowcount, ref, ref+1);
									sheet.addMergedRegion(region);	
									tcell = trow.createCell(ref);
									tcell.setCellValue(rsetl.getString("lin_cdgo")+ " - "+rsetr.getString("ref_cdgo"));
									tcell.setCellStyle(stylecenter);
									RegionUtil.setBorderBottom( 1,  region, testsheet, wb );
									RegionUtil.setBorderTop( 1,  region, testsheet, wb );
									RegionUtil.setBorderLeft( 1,  region, testsheet, wb );
									RegionUtil.setBorderRight( 1,  region, testsheet, wb );											
									
									//--- Add imagem ---
									
									  diretorio = "/opt/tomcat/webapps/brportal/imagens/pequenas/";
									  //diretorio = "i:/imagens/";
								      arquivo = diretorio + rsetr.getString("imagem");
					    			  f = new java.io.File(arquivo);
					    			  if(!f.isFile()){
					    				  arquivo = diretorio + "default_prod.jpg";
					    			  }
					    			  
					    			  fis=new FileInputStream(arquivo);
					    			  img_bytes=new ByteArrayOutputStream();
					    			  int b1; 
					    			  while((b1=fis.read())!=-1)
					    				  img_bytes.write(b1);  
					    			  fis.close();
					    			   anchor = new HSSFClientAnchor(0,0,0,0,(short)(ref),(rowcount+1) ,(short)(ref+2),rowcount+5);
					    			  index=wb.addPicture(img_bytes.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG);
					    			  patriarch.createPicture(anchor,index);
					    			  anchor.setAnchorType(2);
					    			  
					    			  
										region = new CellRangeAddress(rowcount+1, rowcount+4, ref, ref+1);
										sheet.addMergedRegion(region);
										RegionUtil.setBorderBottom( 1,  region, testsheet, wb );
										RegionUtil.setBorderTop( 1,  region, testsheet, wb );
										RegionUtil.setBorderLeft( 1,  region, testsheet, wb );
										RegionUtil.setBorderRight( 1,  region, testsheet, wb );					    			  
					    			  
									  
									  
									  //------------------------------------------
										
										tcell = trowdetalhes.createCell(ref);
										tcell.setCellValue("Emb.");
										
										tcell = trowdetalhes.createCell(ref+1);
										tcell.setCellStyle(stylecenter);
										tcell.setCellValue("PDV");			
										
										tcell = trowdetalhes2.createCell(ref);
										tcell.setCellValue(rsetd.getString("data_embarque_reduzida"));
										
										tcell = trowdetalhes2.createCell(ref+1);
										tcell.setCellStyle(stylecenter);
										tcell.setCellValue(rsetr.getDouble("preco"));		
																		
									  //------------------------------------------
										ref+=2;
								}	
								//++rowcount;
								rowcount += 7;
							}								
							//---------------
						}							
						//---------------
					}	
					//--------------
				}
				//------------
			}
			// --------------------------------------------------------------------------------------

//			contador++;

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