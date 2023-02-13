package util.consultas.ind;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DadosTecnicosProdutos {

	public String geraExcelProduto(String query, String tipo) throws Exception {

		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		boolean novaPlanilha = true;
		boolean tipoFatura = (tipo+"").equalsIgnoreCase("F");
		String retorno = "";
		int planilha = 0;
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			HSSFSheet testsheet = null;
			nomeArquivo.append("dadostecnicos").append(util.rand.Palavra.geraPalavra()).append(".xls");
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleright = wb.createCellStyle();
			stylecenterborda = wb.createCellStyle();
			styleGrade = wb.createCellStyle();
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
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(query);
			rset = pstm.executeQuery();
			while (rset.next()) {
				gerou = true;
				if (rowcount > 65000) {
					novaPlanilha = true;
					rowcount = 0;
				}
				if (novaPlanilha) {
					testsheet = wb.createSheet("dadostecnicos" + ++planilha);
					int indiceCabecalho = 0;
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Etiqueta");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Linha");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Ref.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Cab.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Cor");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Desc. Cor");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Produto");
					tcell = trow.createCell(indiceCabecalho++);
					if (tipoFatura) {
						tcell.setCellValue("Número Brasil");
						tcell = trow.createCell(indiceCabecalho++);
						tcell.setCellValue("Número");
						tcell = trow.createCell(indiceCabecalho++);
						tcell.setCellValue("Qtd. Pares");
						tcell = trow.createCell(indiceCabecalho++);
						tcell.setCellValue("Item Preço");
						tcell = trow.createCell(indiceCabecalho++);
					} else {
						tcell.setCellValue("Número");
						tcell = trow.createCell(indiceCabecalho++);
						
					}
					tcell.setCellValue("ID Item");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Marca");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Desc. Marca");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Filial");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("CNPJ");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("EAN13");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("DUN14");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Classif. Fiscal");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Comp. da Embalagem (m)");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Larg. da Embalagem (m)");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Alt. da Embalagem (m)");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Peso Embalagem");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Peso Sapato");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Ref. Fornec.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Razão Social");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Fecham. Sapato");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Salto");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Elástico");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Mat. Predo. Palmilha");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Mat. Predo. Sola");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Mat. Predo. Salto");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Mat. Predo. Meiapata");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Comp. Caixa (cm)");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Larg. Caixa (cm)");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Alt. Caixa (cm)");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Observação");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Larg. Int.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Comp. Int.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Alt. Sapato");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Larg. Ext.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Comp. Ext.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Alt. Salto");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Alt. Meia.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Alt. Cano");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Diam. Boca.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo de Produto");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Material Predominante");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Material Solado");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Material Forro");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Perc. Cabedal");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Perc. Solado");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("FCI");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("CST");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Mix Produtos");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Preço PDV");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Altura Alça");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Altura Bolsa");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Bolso Interno");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Fechamento Bolsa");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Largura Bolsa");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Peso Bolsa");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Profundidade Bolsa");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Quantidade Bolsos");    
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Regulagem");    
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Alça");    
					novaPlanilha = false;
				}

				++rowcount;
				trow = testsheet.createRow(rowcount);
				int indiceCabecalho = 0;
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tem_etiqueta"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("lin_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("ref_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("cab_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("cor_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("descricao_cor"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("desc_produto"));
				if (tipoFatura) {
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue(rset.getString("qtp_nume"));
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue(rset.getString("numero_exterior"));
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue(rset.getString("qtp_pars")+"");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue(rset.getString("ite_prco")+"");
				
					
				} else {
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue(rset.getString("qtp_nume"));
					
				}
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("id_produto"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("marca"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("marca_descricao"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("filial"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("cnpj"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ean13"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("dun14"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("classificacao_fiscal"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("comprimento_embalagem"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("largura_embalagem"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("altura_embalagem"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getDouble("peso_embalamgem"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getDouble("peso_sapato"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ra_fornecedor"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("razao_social"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_fechamento_sapato"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_tipo_salto"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_bota_possui_elastico"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_palmilha"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_tip_mat_cdgo_entresola")!=null?(rset.getString("ref_tip_mat_cdgo_entresola")+"-"+rset.getString("tip_mat_entresola_descricao")):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_tip_mat_cdgo_salto")!=null?(rset.getString("ref_tip_mat_cdgo_salto")+"-"+rset.getString("tip_mat_salto_descricao")):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_tip_mat_cdgo_meiapata")!=null?(rset.getString("ref_tip_mat_cdgo_meiapata")+"-"+rset.getString("tip_mat_meiapata_descricao")):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("comprimento_caixa")!=null?(rset.getString("comprimento_caixa")):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("largura_caixa")!=null?(rset.getString("largura_caixa")):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("altura_caixa")!=null?(rset.getString("altura_caixa")):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("observacao"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_largura_interna_pe"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_compr_interno_pe"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_altura_sapato"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_largura_ext_sapato"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_compr_ext_sapato"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_altura_salto"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_altura_meiapata"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_altura_canobota"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(rset.getDouble("ref_diametro_boca_bota"), "##,##0.00"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("grupo_posicao_fabrica"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_predominante"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_solado"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_forro"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_perc_cabedal")!=null?rset.getString("ref_perc_cabedal"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("ref_perc_solado")!=null?rset.getString("ref_perc_solado"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("fci"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("cst"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("mix_produtos"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("preco_pdv"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("altura_alca")!=null?rset.getString("altura_alca"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("altura_bolsa")!=null?rset.getString("altura_bolsa"):"");				
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("bolso_interno")!=null?rset.getString("bolso_interno"):"");				
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("fechamento_bolsa")!=null?rset.getString("fechamento_bolsa"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("largura_bolsa")!=null?rset.getString("largura_bolsa"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("peso_bolsa")!=null?rset.getString("peso_bolsa"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("profundidade_bolsa")!=null?rset.getString("profundidade_bolsa"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("quantidade_bolsos")!=null?rset.getString("quantidade_bolsos"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("regulagem")!=null?rset.getString("regulagem"):"");
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_alca")!=null?rset.getString("tipo_alca"):"");				
			}
			wb.write(fos);
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
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
			if (j != null) {
				j.close();
				j = null;
			}
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}
	
	
	
	public String geraExcelPedido(String query) throws Exception {

		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		boolean novaPlanilha = true;
		String retorno = "";
		int planilha = 0;
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			HSSFSheet testsheet = null;
			nomeArquivo.append("dadostecnicos").append(util.rand.Palavra.geraPalavra()).append(".xls");
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleright = wb.createCellStyle();
			stylecenterborda = wb.createCellStyle();
			styleGrade = wb.createCellStyle();
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
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(query);
			rset = pstm.executeQuery();
			while (rset.next()) {
				gerou = true;
				if (rowcount > 65000) {
					novaPlanilha = true;
					rowcount = 0;
				}
				if (novaPlanilha) {
					testsheet = wb.createSheet("dadostecnicos" + ++planilha);
					int indiceCabecalho = 0;
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Etiqueta");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Linha");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Ref.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Cab.");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Cor");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Desc. Cor");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Mat. Predo. Palmilha");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Material Predominante");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Material Solado");
					tcell = trow.createCell(indiceCabecalho++);
					tcell.setCellValue("Tipo Material Forro");
					novaPlanilha = false;
				}

				++rowcount;
				trow = testsheet.createRow(rowcount);
				int indiceCabecalho = 0;
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tem_etiqueta"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("lin_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("ref_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("cab_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getInt("cor_cdgo"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("descricao_cor"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_palmilha"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_predominante"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_solado"));
				tcell = trow.createCell(indiceCabecalho++);
				tcell.setCellValue(rset.getString("tipo_material_forro"));
			}
			wb.write(fos);
			fos.close(); 
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
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
			if (j != null) {
				j.close();
				j = null;
			}
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}	
	
	
}