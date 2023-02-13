package util.consultas.ind;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import util.consultas.Query;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Est102 {

	@SuppressWarnings("resource")
	public String geraExcel(String p_emp_empresa, String p_fil_filial, String p_les_codigo, String p_tco_codigo,
			String p_ies_codigo, String p_ref_cdgo, String p_cab_cdgo, String p_cor_cdgo, String p_lin_cdgo,
			String p_codigo_marca, String p_mix_produtos, String p_qtde_inicial, String p_qtde_final,
			String p_tipo_produto, String p_tes_codigo, String p_tipo_produtos, String p_imprime_imagens,
			String p_considera_transito, String p_grades, String p_data_inicial, String p_data_final,
			String p_ordenacao, String p_mostra_preco, String p_grade_quebrada, String p_livro, String p_ignorar_95,
			boolean mostra_query, String p_qtde_itens, String p_est_inicial, String p_est_final, String p_continente,
			String p_marcas_selecionadas, String p_linhas_desconsiderar, String p_linhas_considerar, String p_valor_inicial, String p_valor_final, String ignorarGrade99, String layout) throws Exception {

		if (p_continente == null) {
			p_continente = "null";
		} else {
			p_continente = "'" + p_continente + "'";
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFRow trowGradeQuebrada;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet rsett = null;
		java.sql.PreparedStatement pstmc = null;
		java.sql.ResultSet rsetc = null;
		java.sql.PreparedStatement pstmg = null;
		java.sql.ResultSet rsetg = null;
		java.sql.ResultSet rsettg = null;
		java.sql.PreparedStatement pstmtg = null;
		
		String linhasDesconsiderar = null;
		if(!p_linhas_desconsiderar.equals("null")){
		     String linhas = p_linhas_desconsiderar.replaceAll("[^0-9]", " ").trim();
		     linhas = linhas.replaceAll("\\s+", " ");
		     linhas = linhas.replaceAll(" ", "\n");
		     linhas = linhas.replaceAll("\\r\\n|\\r|\\n", ",");
		     if((linhas.charAt(linhas.length()-1)+"").equalsIgnoreCase(",")){
		    	 linhas = linhas.substring(0, linhas.lastIndexOf(","));
		     }
		     linhasDesconsiderar = " AND nvl(i.lin_cdgo,null) NOT IN (" + linhas +")";
		  }
		
		String linhasConsiderar = null;
		if(!p_linhas_considerar.equals("null")){
		     String linhas = p_linhas_considerar.replaceAll("[^0-9]", " ").trim();
		     linhas = linhas.replaceAll("\\s+", " ");
		     linhas = linhas.replaceAll(" ", "\n");
		     linhas = linhas.replaceAll("\\r\\n|\\r|\\n", ",");
		     if((linhas.charAt(linhas.length()-1)+"").equalsIgnoreCase(",")){
		    	 linhas = linhas.substring(0, linhas.lastIndexOf(","));
		     }
		     linhasConsiderar = " AND nvl(i.lin_cdgo,null) IN (" + linhas +")";
		  }
		
		
		
		Query query = new Query();
		com.egen.util.jdbc.JdbcUtil j = null;
		String modeloantigo = null;
		StringBuilder nomeArquivo = new StringBuilder();
		String gradeantiga = null;
		int indexDataLogAfv = 0;
		boolean informouDataLogAfv = false;
		if (p_est_inicial != null || p_est_final != null || p_ordenacao.equals("data_les_lin_ref")) {
			informouDataLogAfv = true;
			indexDataLogAfv = 1;
		}

		int cellcount = -1;
		int contador = 0;
		int contadorGradeQuebrada = 0;
		Long rowcount_imagem = 0l;
		int contadorgrade = 0;
		double qtds_grades = 0;
		double qtds_grd = 0;
		String retorno = "";
		boolean gerou = false;
		int spanPreco = 0;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String diretorioImagens = "/home/loja_brportal/imagens/grandes/";
		//String diretorioImagens = "c:/opt/arquivos_sites/imagens/grandes/";
		String diretorioSemImagem = "/opt/tomcat/webapps/brportal/img/";
		//String diretorioSemImagem = "c:/egen/tomcat/webapps/brportal/img/";
		List<Integer> listaMarcas = new ArrayList<Integer>();
		if (p_marcas_selecionadas == null || p_marcas_selecionadas.isEmpty()) {
			listaMarcas.add(99);
		} else {
			String[] marcas = p_marcas_selecionadas.split(",");
			for (String m : marcas) {
				listaMarcas.add(Integer.parseInt(m));
			}
		}
		try {
			if (p_mostra_preco.equals("S")) {
				spanPreco = 2;
			}
			nomeArquivo.append("est102").append(util.rand.Palavra.geraPalavra()).append(".xls");
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			//FileOutputStream fos = new FileOutputStream("c:/temp/" + nomeArquivo.toString());
			for (Integer marca : listaMarcas) {
				String descricaoPlanilha = null;
				int contadorPlanilha = 0;
				if (p_marcas_selecionadas == null || p_marcas_selecionadas.isEmpty()) {
					descricaoPlanilha = "estoque";
				} else {
					descricaoPlanilha = query.retorna("SELECT descricao_marca FROM marcas_produtos WHERE codigo_marca = " + marca);
					p_codigo_marca = marca + "";
				}
				Long rowcount = 0l;
				HSSFSheet testsheet = wb.createSheet(descricaoPlanilha);
				HSSFSheet sheet = wb.getSheet(descricaoPlanilha);
				HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
				
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
				trow = testsheet.createRow(rowcount.intValue());
				tcell = trow.createCell(0);
				tcell.setCellValue("Emp");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(1);
				tcell.setCellValue("Fil");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(2);
				tcell.setCellValue("Unn");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(3);
				tcell.setCellValue("Local");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(4);
				tcell.setCellValue("Tes");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(5);
				tcell.setCellValue("Tco");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(6);
				tcell.setCellValue("Produto");
				tcell.setCellStyle(style);
				tcell = trow.createCell(7);
				tcell.setCellValue("Descrição");
				tcell.setCellStyle(style);
				if (informouDataLogAfv) {
					tcell = trow.createCell(8);
					tcell.setCellValue("Data Est.");
					tcell.setCellStyle(style);
				}
				if (p_mostra_preco.equals("S")) {
					tcell = trow.createCell(8 + indexDataLogAfv);
					tcell.setCellValue("Livro");
					tcell.setCellStyle(style);
					tcell = trow.createCell(9 + indexDataLogAfv);
					tcell.setCellValue("Preço");
					tcell.setCellStyle(style);
				}
				tcell = trow.createCell(8 + spanPreco + indexDataLogAfv);
				tcell.setCellValue("Fil/Ativa");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(9 + spanPreco + indexDataLogAfv);
				tcell.setCellValue("Cor");
				tcell.setCellStyle(style);
				j = new com.egen.util.jdbc.JdbcUtil();
				StringBuilder sb = new StringBuilder();
				
				sb.append(" SELECT * FROM ( ");
				
				sb.append(" SELECT DISTINCT d.emp_empresa ");
				sb.append("               , d.fil_filial ");
				sb.append("               , d.unn_codigo ");
				sb.append("               , d.les_codigo ");
				sb.append("               , d.tes_codigo ");
				sb.append("               , d.tco_codigo ");
				sb.append("               , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ies_codigox ");
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , d.cor_cdgo ");
				} else {
					sb.append("           , 0 cor_cdgo ");
				}
				sb.append("               , pck_cabedal.get_nome(i.cab_cdgo) desc_cab ");
				sb.append("               , 0 desc_cor ");
				String livroExportacao = "50, 51, 52, 53, 54, 56, 57, 102";
				if(livroExportacao.contains(p_livro)){
					sb.append(" ,      (SELECT tp.preco_unitario ");
					sb.append(" 	      FROM tabela_preco_mercado_externo tp ");
					sb.append(" 	     WHERE tp.codigo_linha = i.lin_cdgo ");
					sb.append(" 	       AND tp.codigo_referencia = i.ref_cdgo ");
					sb.append(" 	       AND tp.codigo_cabedal = i.cab_cdgo ");
					sb.append(" 	       AND tp.codigo_livro = " + p_livro);
					sb.append(" 	       and tp.codigo_pais = 1 ");
					sb.append(" 	       AND tp.status = 'A' ");
					sb.append(" 	       AND tp.versao_tabela = (SELECT MAX(tpp.versao_tabela) ");
					sb.append(" 	                                 FROM tabela_preco_mercado_externo tpp ");
					sb.append(" 	                                WHERE tp.codigo_livro = tpp.codigo_livro ");
					sb.append(" 	                                  AND tp.codigo_linha = tpp.codigo_linha ");
					sb.append(" 	                                  and tpp.codigo_livro = " + p_livro);
					sb.append(" 	                                  and tpp.status = 'A' ");
					sb.append(" 	                                  AND tp.codigo_referencia = tpp.codigo_referencia ");
					sb.append(" 	                                  AND tp.codigo_cabedal = tpp.codigo_cabedal ");
					sb.append(" 	                                  AND tp.codigo_pais = tpp.codigo_pais)) preco_produto ");
				} else {
				   sb.append("               , fct_preco_produto_est102('").append(p_ignorar_95).append("',").append(p_livro).append(", i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) preco_produto ");
				}
				sb.append("               , fnc_retorna_filial_lin_ref(i.lin_cdgo, i.ref_cdgo) filial_ativa ");
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) || d.cor_cdgo   modelo ");
				} else {
					sb.append("           , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)   modelo ");
				}
				sb.append("               , d.ies_codigo ");
				sb.append("               , i.lin_cdgo ");
				sb.append("               , i.ref_cdgo ");

				if (p_ignorar_95.equals("S")) {
					sb.append("           , ").append(p_livro).append(" livro ");
				} else {
					sb.append("           , CASE WHEN ").append(p_livro)
							.append(" = 95 THEN 95 ELSE decode((fct_busca_preco_livro(").append(p_livro)
							.append(", TRUNC(SYSDATE), i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)),0,95,").append(p_livro)
							.append(") END livro ");
				}
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo, d.cor_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
				} else {
					sb.append("           , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
				}
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , SUM(d.qtde_atual) qtde_atual ");
				}
				if (p_ordenacao.equals("data_les_lin_ref") || informouDataLogAfv) {
					sb.append("           , MIN(d.data_log_afv) data_log_afv ");
					sb.append("           , to_char(MIN(d.data_log_afv),'dd/mm/yyyy') data_log_afv_desc ");
				}
				sb.append("   FROM dom_item_estoque i ");
				sb.append("      , REF r ");
				sb.append("      , dom_local_item_estoque_gre d ");
			  //sb.append("      , ficha_tec ft ");
				sb.append("      , (SELECT d.ies_codigo ");
				sb.append("              , d.cor_cdgo ");
				sb.append("              , d.emp_empresa ");
				sb.append("              , d.fil_filial ");
				sb.append("              , d.unn_codigo ");
				sb.append("              , d.les_codigo ");
				sb.append("              , d.tes_codigo ");
				sb.append("              , d.tco_codigo ");
				sb.append("              , SUM(d.qtde_atual) soma ");
				sb.append("           FROM dom_local_item_estoque_gre d ");
				sb.append("          WHERE d.emp_empresa = NVL(").append(p_emp_empresa).append(", d.emp_empresa) ");
				sb.append("            AND d.fil_filial = NVL(").append(p_fil_filial).append(", d.fil_filial) ");
				sb.append("            AND d.les_codigo = NVL(").append(p_les_codigo).append(", d.les_codigo) ");
				sb.append("            AND d.tes_codigo IN (").append(p_tes_codigo).append(") ");
				sb.append("            AND (d.tes_codigo NOT IN (8) OR NVL('").append(p_considera_transito)	.append("', 'N') = 'S') ");
				sb.append("            AND d.tco_codigo = NVL(").append(p_tco_codigo).append(", d.tco_codigo) ");
				sb.append("            AND (" + ((p_ies_codigo + "").equals("null") ? null : 1)	+ " is null or d.ies_codigo in (" + p_ies_codigo + ")) ");
				sb.append("            AND d.cor_cdgo = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
				sb.append("            AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
				if (ignorarGrade99.equals("S")) {
					sb.append("        AND d.gde_cdgo <> 99 ");
				}				
				sb.append("            AND d.qtde_atual > 0 ");
				sb.append("          GROUP BY d.ies_codigo ");
				sb.append("                 , d.cor_cdgo ");
				sb.append("                 , d.emp_empresa ");
				sb.append("                 , d.fil_filial ");
				sb.append("                 , d.unn_codigo ");
				sb.append("                 , d.les_codigo ");
				sb.append("                 , d.tes_codigo ");
				sb.append("                 , d.tco_codigo) dd ");
				sb.append("  WHERE d.ies_codigo            = i.codigo ");
				//sb.append("    AND NVL(i.tipo, NULL)       = 'A' ");
				//sb.append("    AND ft.lin_cdgo             = i.lin_cdgo ");
				//sb.append("    AND ft.ref_cdgo             = i.ref_cdgo ");
				//sb.append("    AND ft.cab_cdgo             = i.cab_cdgo ");
				
				if (linhasDesconsiderar != null) {
					sb.append(linhasDesconsiderar);
				}
				
				if (linhasConsiderar != null) {
					sb.append(linhasConsiderar);
				}				
				
				sb.append("    AND NVL(i.lin_cdgo, NULL)   = NVL(" + p_lin_cdgo + ", i.lin_cdgo) ");
				sb.append("    AND NVL(i.ref_cdgo, NULL)   = NVL(" + p_ref_cdgo + ", i.ref_cdgo) ");
				sb.append("    AND NVL(i.cab_cdgo, NULL)   = NVL(" + p_cab_cdgo + ", i.cab_cdgo) ");
				sb.append("    AND d.tes_codigo            IN (" + p_tes_codigo + ") ");
				sb.append("    AND r.lin_cdgo              = i.lin_cdgo ");
				sb.append("    AND r.ref_cdgo              = i.ref_cdgo ");
				sb.append("    AND r.codigo_marca          = NVL(" + p_codigo_marca + ", r.codigo_marca) ");
				sb.append("    AND (NVL('" + p_mix_produtos	+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '" + p_mix_produtos + "') ");
				sb.append("    AND d.ies_codigo            = i.codigo ");
				sb.append("    AND d.emp_empresa           = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
				sb.append("    AND d.fil_filial            = NVL(" + p_fil_filial + ", d.fil_filial) ");
				sb.append("    AND d.les_codigo            = NVL(" + p_les_codigo + ", d.les_codigo) ");
				sb.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
				sb.append("    AND d.tco_codigo            = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
				sb.append("    AND (" + ((p_ies_codigo + "").equals("null") ? null : 1)	+ " is null or d.ies_codigo in (" + p_ies_codigo + ")) ");
				sb.append("    AND d.cor_cdgo              = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
				if (p_tipo_produtos != null) {
					sb.append("    AND nvl(r.ref_grupo_posicao_fab,null) in (" + p_tipo_produtos + ") ");
				}
				sb.append("    AND d.emp_empresa           = dd.emp_empresa ");
				sb.append("    AND d.fil_filial            = dd.fil_filial ");
				sb.append("    AND d.unn_codigo            = dd.unn_codigo ");
				sb.append("    AND d.cor_cdgo              = dd.cor_cdgo ");
				sb.append("    AND d.les_codigo            = dd.les_codigo ");
				sb.append("    AND d.tes_codigo            = dd.tes_codigo ");
				sb.append("    AND d.tco_codigo            = dd.tco_codigo ");
				sb.append("    AND dd.ies_codigo           = i.codigo ");
				sb.append("    AND (" + p_qtde_inicial + " IS NULL OR NVL(dd.soma, NULL) >= " + p_qtde_inicial + ") ");
				sb.append("    AND (" + p_qtde_final + " IS NULL OR NVL(dd.soma, NULL) <= " + p_qtde_final + ") ");
				sb.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
				if (ignorarGrade99.equals("S")) {
					sb.append(" AND d.gde_cdgo <> 99 ");
				}
				sb.append("    AND NVL(TRUNC(i.dthr_alteracao), TRUNC(SYSDATE)) >= TO_DATE('" + p_data_inicial	+ "', 'dd/mm/yyyy') ");
				sb.append("    AND NVL(TRUNC(i.dthr_alteracao), TRUNC(SYSDATE)) <= TO_DATE('" + p_data_final + "', 'dd/mm/yyyy') ");
				if (p_est_inicial != null) {
					sb.append("    AND NVL(TRUNC(d.data_log_afv), TRUNC(SYSDATE)) >= TO_DATE('" + p_est_inicial	+ "', 'dd/mm/yyyy') ");
				}
				if (p_est_final != null) {
					sb.append("	   AND NVL(TRUNC(d.data_log_afv), TRUNC(SYSDATE)) <= TO_DATE('" + p_est_final + "', 'dd/mm/yyyy') ");
				}
				sb.append("    AND d.qtde_atual            > 0 ");
				if (p_ordenacao.equals("qtd_les_lin_ref") || p_ordenacao.equals("data_les_lin_ref")
						|| informouDataLogAfv) {
					sb.append(" GROUP BY d.emp_empresa ");
					sb.append("	       , d.fil_filial ");
					sb.append("	       , d.unn_codigo ");
					sb.append("	       , d.les_codigo ");
					sb.append("	       , d.tes_codigo ");
					sb.append("	       , d.tco_codigo ");
					sb.append("	       , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ");
					sb.append("	       , pck_cabedal.get_nome(i.cab_cdgo) ");
					sb.append("	       , fnc_retorna_filial_lin_ref(i.lin_cdgo, i.ref_cdgo) ");
					sb.append("	       , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ");
					sb.append("	       , d.ies_codigo ");
					sb.append("	       , i.lin_cdgo ");
					sb.append("	       , i.ref_cdgo ");
					if (p_ordenacao.equals("qtd_les_lin_ref")) {
						sb.append("	   , d.cor_cdgo ");
					}
					sb.append("        , i.cab_cdgo ");
				}

				sb.append(" ) ");
				sb.append(" WHERE 1=1 ");
				sb.append("   AND (" + p_valor_inicial + " IS NULL OR NVL(preco_produto, NULL) >= " + p_valor_inicial + ") ");
				sb.append("   AND (" + p_valor_final + " IS NULL OR NVL(preco_produto, NULL) <= " + p_valor_final + ") ");				  
				
				
				if (p_ordenacao.equals("linha")) {
					sb.append("  ORDER BY 15,16 ");
				} else if (p_ordenacao.equals("normal")) {
					sb.append("  ORDER BY 1,2,4,5,6,7,8 ");
				} else if (p_ordenacao.equals("fil_lin_ref")) {
					sb.append("  ORDER BY 2,15,16 ");
				} else if (p_ordenacao.equals("les_lin_ref")) {
					sb.append("  ORDER BY 4,15,16 ");
				} else if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("  ORDER BY qtde_atual DESC, 4,15,16 ");
				} else if (p_ordenacao.equals("data_les_lin_ref")) {
					sb.append("  ORDER BY data_log_afv asc, 4,15,16");
				} else {
					sb.append("  ORDER BY 4,5,6,7,8 ");
				}

				if (mostra_query) {
					throw new Exception(sb.toString());
				}
				pstm = j.getConn().prepareStatement(sb.toString());
				rset = pstm.executeQuery();
				int quantidadeItens = 0;
				int totalItens = Integer.parseInt(p_qtde_itens);
				String imagem = "";
				while (rset.next() && (quantidadeItens < totalItens)) {
					if (rowcount > 32000) {
						rowcount = 0l;
						rowcount_imagem = 0l;
						testsheet = wb.createSheet(descricaoPlanilha + "_" + ++contadorPlanilha);
						sheet = wb.getSheet(descricaoPlanilha + "_" + contadorPlanilha);
						patriarch = sheet.createDrawingPatriarch();
					
						trow = testsheet.createRow(rowcount.intValue());
						tcell = trow.createCell(0);
						tcell.setCellValue("Emp");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(1);
						tcell.setCellValue("Fil");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(2);
						tcell.setCellValue("Unn");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(3);
						tcell.setCellValue("Local");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(4);
						tcell.setCellValue("Tes");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(5);
						tcell.setCellValue("Tco");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(6);
						tcell.setCellValue("Produto");
						tcell.setCellStyle(style);
						tcell = trow.createCell(7);
						tcell.setCellValue("Descrição");
						tcell.setCellStyle(style);
						if (informouDataLogAfv) {
							tcell = trow.createCell(8);
							tcell.setCellValue("Data Est.");
							tcell.setCellStyle(style);
						}
						if (p_mostra_preco.equals("S")) {
							tcell = trow.createCell(8 + indexDataLogAfv);
							tcell.setCellValue("Livro");
							tcell.setCellStyle(style);
							tcell = trow.createCell(9 + indexDataLogAfv);
							tcell.setCellValue("Preço");
							tcell.setCellStyle(style);
						}
						tcell = trow.createCell(8 + spanPreco + indexDataLogAfv);
						tcell.setCellValue("Fil/Ativa");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(9 + spanPreco + indexDataLogAfv);
						tcell.setCellValue("Cor");
						tcell.setCellStyle(style);
					}

					quantidadeItens++;
					contadorGradeQuebrada = 0;
					gerou = true;
					if ((!rset.getString(13).equals(modeloantigo)) || contador == 0) {
						++rowcount;
						rowcount_imagem = rowcount + 1;
						trow = testsheet.createRow(rowcount.intValue());
						trowGradeQuebrada = trow;
						tcell = trow.createCell(0);
						tcell.setCellValue(rset.getString("emp_empresa"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(1);
						tcell.setCellValue(rset.getString("fil_filial"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(2);
						tcell.setCellValue(rset.getString("unn_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(3);
						tcell.setCellValue(rset.getString("les_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(4);
						tcell.setCellValue(rset.getString("tes_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(5);
						tcell.setCellValue(rset.getString("tco_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(6);
						tcell.setCellValue(rset.getString("ies_codigox"));
						tcell = trow.createCell(7);
						tcell.setCellValue(rset.getString("desc_cab"));
						if (informouDataLogAfv) {
							tcell = trow.createCell(8);
							tcell.setCellValue(rset.getString("data_log_afv_desc"));
						}
						if (p_mostra_preco.equals("S")) {
							tcell = trow.createCell(8 + indexDataLogAfv);
							tcell.setCellValue(rset.getString("livro"));
							tcell.setCellStyle(stylecenter);
							tcell = trow.createCell(9 + indexDataLogAfv);
							tcell.setCellValue(rset.getString("preco_produto"));
							tcell.setCellStyle(stylecenter);
						}

						tcell = trow.createCell(8 + spanPreco + indexDataLogAfv);
						tcell.setCellValue(rset.getString("filial_ativa"));
						tcell.setCellStyle(stylecenter);

						StringBuilder sbc = new StringBuilder();
						sbc.append(" SELECT DISTINCT d.cor_cdgo  ");
						sbc.append("               , pck_cor.get_nome(d.cor_cdgo) desc_cor  ");
						sbc.append("               , CASE WHEN (max(case when instr(d.tai_codigo,'/') > 0 then to_number(substr(d.tai_codigo,(instr(d.tai_codigo,'/')+1), length(d.tai_codigo))) else TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)) end) - ");
						sbc.append("                 MIN(TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)))) = ");
						sbc.append("                 COUNT(DISTINCT TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1))) * sum(distinct case when instr(d.tai_codigo,'/') > 0 then 2 else 1 end) -1 THEN 'N' ELSE 'S' END furada ");
						sbc.append("               , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo, d.cor_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
						sbc.append("   FROM dom_item_estoque i  ");
						sbc.append("      , ref r ");
						sbc.append("      , (SELECT ddd.tai_codigo, ddd.fil_filial, ddd.emp_empresa, ddd.unn_codigo, ddd.les_codigo, ddd.tes_codigo, ddd.tco_codigo, ddd.ies_codigo,ddd.cor_cdgo, ddd.qtde_atual, ddd.gde_cdgo FROM  dom_local_item_estoque_gre ddd) d ");
						sbc.append("      , (SELECT d.ies_codigo ");
						sbc.append("              , d.cor_cdgo ");
						sbc.append("              , d.emp_empresa ");
						sbc.append("              , d.fil_filial ");
						sbc.append("              , d.unn_codigo ");
						sbc.append("              , d.les_codigo ");
						sbc.append("              , d.tes_codigo ");
						sbc.append("              , d.tco_codigo ");
						sbc.append("              , SUM(d.qtde_atual) soma ");
						sbc.append("           FROM dom_local_item_estoque_gre d ");
						sbc.append("          WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
						sbc.append("            AND d.fil_filial = NVL(" + p_fil_filial + ", d.fil_filial) ");
						sbc.append("            AND d.les_codigo = NVL(" + p_les_codigo + ", d.les_codigo) ");
						sbc.append("            AND d.tes_codigo IN (" + p_tes_codigo + ") ");
						sbc.append("            AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
						sbc.append("            AND d.tco_codigo = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
						sbc.append("            AND d.ies_codigo = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
						sbc.append("            AND d.cor_cdgo = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
						sbc.append("            AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
						if (ignorarGrade99.equals("S")) {
							sbc.append("        AND d.gde_cdgo <> 99 ");
						}						
						sbc.append("            AND d.qtde_atual > 0 ");
						sbc.append("          GROUP BY d.ies_codigo ");
						sbc.append("                 , d.cor_cdgo ");
						sbc.append("                 , d.emp_empresa ");
						sbc.append("                 , d.fil_filial ");
						sbc.append("                 , d.unn_codigo ");
						sbc.append("                 , d.les_codigo ");
						sbc.append("                 , d.tes_codigo ");
						sbc.append("                 , d.tco_codigo) dd ");
						sbc.append("  WHERE d.ies_codigo            = i.codigo  ");
					  //sbc.append("    AND NVL(i.tipo, NULL)       = 'A'  ");
						
						if (linhasDesconsiderar != null) {
							sbc.append(linhasDesconsiderar);
						}
						
						if (linhasConsiderar != null) {
							sbc.append(linhasConsiderar);
						}						
						
						sbc.append("    AND NVL(i.lin_cdgo, NULL)   = NVL(" + p_lin_cdgo + ", i.lin_cdgo)  ");
						sbc.append("    AND NVL(i.ref_cdgo, NULL)   = NVL(" + p_ref_cdgo + ", i.ref_cdgo)  ");
						sbc.append("    AND NVL(i.cab_cdgo, NULL)   = NVL(" + p_cab_cdgo + ", i.cab_cdgo)  ");
						sbc.append("    AND d.tes_codigo            IN (" + p_tes_codigo + ")  ");
						sbc.append("    AND r.lin_cdgo              = i.lin_cdgo  ");
						sbc.append("    AND r.ref_cdgo              = i.ref_cdgo  ");
						sbc.append("    AND r.codigo_marca          = NVL(" + p_codigo_marca + ", r.codigo_marca)  ");
						sbc.append("    AND (NVL('" + p_mix_produtos + "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '" + p_mix_produtos + "')  ");
						sbc.append("    AND d.ies_codigo            = i.codigo  ");
						sbc.append("    AND d.emp_empresa           = NVL(" + p_emp_empresa + ", d.emp_empresa)  ");
						sbc.append("    AND d.fil_filial            = NVL(" + p_fil_filial + ", d.fil_filial)  ");
						sbc.append("    AND d.les_codigo            = NVL(" + p_les_codigo + ", d.les_codigo)  ");
						sbc.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S')  ");
						sbc.append("    AND d.tco_codigo            = NVL(" + p_tco_codigo + ", d.tco_codigo)  ");
						sbc.append("    AND d.ies_codigo            = NVL(" + p_ies_codigo + ", d.ies_codigo)  ");
						sbc.append("    AND d.cor_cdgo              = NVL(" + p_cor_cdgo + ", d.cor_cdgo)  ");
						sbc.append("    AND d.emp_empresa           = '" + rset.getString("emp_empresa") + "' ");
						sbc.append("    AND d.fil_filial            = '" + rset.getString("fil_filial") + "' ");
						sbc.append("    AND d.unn_codigo            = '" + rset.getString("unn_codigo") + "' ");
						sbc.append("    AND d.les_codigo            = " + rset.getString("les_codigo"));
						sbc.append("    AND d.tes_codigo            = " + rset.getString("tes_codigo"));
						sbc.append("    AND d.tco_codigo            = " + rset.getString("tco_codigo"));
						sbc.append("    AND d.ies_codigo            = " + rset.getString("ies_codigo"));

						if (p_ordenacao.equals("qtd_les_lin_ref")) {
							sbc.append("    AND d.cor_cdgo              = " + rset.getString("cor_cdgo"));
						}
						if (p_tipo_produtos != null) {
							sbc.append("    AND nvl(r.ref_grupo_posicao_fab,null) in (" + p_tipo_produtos + ") ");
						}
						sbc.append("    AND d.emp_empresa           = dd.emp_empresa ");
						sbc.append("    AND d.fil_filial            = dd.fil_filial ");
						sbc.append("    AND d.unn_codigo            = dd.unn_codigo ");
						sbc.append("    AND d.cor_cdgo              = dd.cor_cdgo ");
						sbc.append("    AND d.les_codigo            = dd.les_codigo ");
						sbc.append("    AND d.tes_codigo            = dd.tes_codigo ");
						sbc.append("    AND d.tco_codigo            = dd.tco_codigo ");
						sbc.append("    AND dd.ies_codigo           = i.codigo ");
						sbc.append("    AND (" + p_qtde_inicial + " IS NULL OR NVL(dd.soma, NULL) >= " + p_qtde_inicial + ") ");
						sbc.append("    AND (" + p_qtde_final + " IS NULL OR NVL(dd.soma, NULL) <= " + p_qtde_final	+ ") ");
						sbc.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
						if (ignorarGrade99.equals("S")) {
							sb.append(" AND d.gde_cdgo <> 99 ");
						}						
						sbc.append("    AND d.qtde_atual > 0 ");
						sbc.append(" GROUP BY d.cor_cdgo ");
						sbc.append("        , i.lin_cdgo ");
						sbc.append("        , i.ref_cdgo ");
						sbc.append("        , i.cab_cdgo ");
						

						if (p_grade_quebrada.equals("S")) {
							sbc.append(" HAVING  CASE WHEN (MAX(case when instr(d.tai_codigo,'/') > 0 then to_number(substr(d.tai_codigo,(instr(d.tai_codigo,'/')+1), length(d.tai_codigo))) else TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)) end) - ");
							sbc.append("                    MIN(TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)))) = ");
							sbc.append("                    COUNT(DISTINCT TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1))) * sum(distinct case when instr(d.tai_codigo,'/') > 0 then 2 else 1 end) -1 THEN 'N' ELSE 'S' END = 'S' ");
						}

						sbc.append("  ORDER BY 1 ");
						pstmc = j.getConn().prepareStatement(sbc.toString());
						rsetc = pstmc.executeQuery();

						int contadorImagem = 0;
						while (rsetc.next()) {
							if(contadorImagem == 0) {
								imagem = rsetc.getString("imagem");
								contadorImagem++;
							}
							contadorGradeQuebrada++;
							if (rsetc.getString(3).equals("S")) {
								styleGrade = wb.createCellStyle();
								HSSFFont font = wb.createFont();
								font.setColor(HSSFColor.WHITE.index);
								styleGrade.setFont(font);
								styleGrade.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.RED.index);
								styleGrade.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
								styleGrade.setBorderLeft((short) 2);
								styleGrade.setBorderRight((short) 2);
								styleGrade.setBorderTop((short) 2);
								styleGrade.setBorderBottom((short) 2);
								styleGrade.setAlignment((short) 2);
							} else {
								styleGrade = wb.createCellStyle();
								styleGrade.setFillPattern(HSSFCellStyle.NO_FILL);
								styleGrade.setBorderLeft((short) 1);
								styleGrade.setBorderRight((short) 1);
								styleGrade.setBorderTop((short) 1);
								styleGrade.setBorderBottom((short) 1);
								styleGrade.setAlignment((short) 2);
							}
							tcell = trow.createCell(9 + spanPreco + indexDataLogAfv);
							tcell.setCellValue(rsetc.getString(1) + "-" + rsetc.getString(2));

							// -------------- tamanhos geral --------------
							StringBuilder sbt = new StringBuilder();
							sbt.append(" SELECT tai_codigo ");
							sbt.append("      , qtde_atual ");
							sbt.append("   FROM ( ");
							sbt.append(" SELECT DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) tai_codigo ");
							sbt.append("      , SUM(d.qtde_atual) qtde_atual ");
							sbt.append("   FROM dom_local_item_estoque_gre d ");
							sbt.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
							sbt.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
							sbt.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
							sbt.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
							sbt.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
							sbt.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
							sbt.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
							sbt.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
							sbt.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
							sbt.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
							sbt.append("    AND d.ies_codigo  = " + rset.getString(14));
							sbt.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
							sbt.append("    AND d.les_codigo  = " + rset.getString(4));
							sbt.append("    AND d.tes_codigo  = " + rset.getString(5));
							sbt.append("    AND d.tco_codigo  = " + rset.getString(6));
							sbt.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
							if (ignorarGrade99.equals("S")) {
								sbt.append(" AND d.gde_cdgo <> 99 ");
							}							
							sbt.append("    AND d.qtde_atual  > 0 ");
							sbt.append("  GROUP BY DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) ");
							sbt.append("  UNION ");
							sbt.append(" SELECT '999' tai_codigo  ");
							sbt.append("      , SUM(d.qtde_atual) qtde_atual ");
							sbt.append("   FROM dom_local_item_estoque_gre d ");
							sbt.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
							sbt.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
							sbt.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
							sbt.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
							sbt.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
							sbt.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
							sbt.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
							sbt.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
							sbt.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
							sbt.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
							sbt.append("    AND d.ies_codigo  = " + rset.getString(14));
							sbt.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
							sbt.append("    AND d.les_codigo  = " + rset.getString(4));
							sbt.append("    AND d.tes_codigo  = " + rset.getString(5));
							sbt.append("    AND d.tco_codigo  = " + rset.getString(6));
							sbt.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
							if (ignorarGrade99.equals("S")) {
								sbt.append(" AND d.gde_cdgo <> 99 ");
							}							
							sbt.append("    AND d.qtde_atual  > 0 ");
							sbt.append("  ) ");
							sbt.append("  ORDER BY TO_NUMBER(regexp_substr(tai_codigo, '[[:digit:]]+', 1, 1)) ");

							pstmt = j.getConn().prepareStatement(sbt.toString());

							rsett = pstmt.executeQuery();
							cellcount = 10 + spanPreco + indexDataLogAfv;
							tcell = trow.createCell(cellcount);
							tcell.setCellValue("Tamanho");
							tcell.setCellStyle(styleGrade);
							trow = testsheet.createRow((++rowcount).intValue());
							tcell = trow.createCell(cellcount);
							tcell.setCellValue("Qtd. Pares");
							tcell.setCellStyle(styleGrade);
							while (rsett.next()) {
								trow = testsheet.getRow((--rowcount).intValue());
								tcell = trow.createCell(++cellcount);
								tcell.setCellValue(rsett.getString(1).replace("999", "Total"));
								tcell.setCellStyle(styleGrade);
								trow = testsheet.getRow((++rowcount).intValue());
								tcell = trow.createCell(cellcount);
								tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(rsett.getString(2)), "##0.##"));
								tcell.setCellStyle(styleGrade);
							}
							trow = testsheet.getRow(rowcount.intValue() - 1);
							tcell = trow.createCell(++cellcount);
							tcell.setCellValue("Cxs");
							tcell.setCellStyle(styleGrade);

							trow = testsheet.getRow(rowcount.intValue());
							tcell = trow.createCell(cellcount);
							tcell.setCellValue("");
							tcell.setCellStyle(styleGrade);

							rsett.close();
							pstmt.close();

							gradeantiga = null;
							contadorgrade = 0;
							StringBuilder sbg = new StringBuilder();
							sbg.append(" SELECT d.gde_cdgo ");
							sbg.append("      , DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) tai_codigo ");
							sbg.append("      , SUM(d.qtde_atual) qtde_atual ");
							sbg.append("   FROM dom_local_item_estoque_gre d ");
							sbg.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
							sbg.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
							sbg.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
							sbg.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
							sbg.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
							sbg.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
							sbg.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
							sbg.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
							sbg.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
							sbg.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
							sbg.append("    AND d.ies_codigo  = " + rset.getString(14));
							sbg.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
							sbg.append("    AND d.les_codigo  = " + rset.getString(4));
							sbg.append("    AND d.tes_codigo  = " + rset.getString(5));
							sbg.append("    AND d.tco_codigo  = " + rset.getString(6));
							sbg.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
							if (ignorarGrade99.equals("S")) {
								sbg.append(" AND d.gde_cdgo <> 99 ");
							}							
							sbg.append("    AND d.qtde_atual  > 0 ");
							sbg.append("  GROUP BY DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) ");
							sbg.append("         , d.gde_cdgo ");
							sbg.append("  ORDER BY 1, TO_NUMBER(regexp_substr(2, '[[:digit:]]+', 1, 1)) ");

							pstmg = j.getConn().prepareStatement(sbg.toString());
							rsetg = pstmg.executeQuery();
							while (rsetg.next()) {
								if ((!rsetg.getString(1).equals(gradeantiga)) || contadorgrade == 0) {
									trow = testsheet.createRow((++rowcount).intValue());
									cellcount = 10 + spanPreco + indexDataLogAfv;
									tcell = trow.createCell(cellcount);
									tcell.setCellValue("Grade " + rsetg.getString(1));
									tcell.setCellStyle(styleGrade);
									StringBuilder sbtg = new StringBuilder();
									sbtg.append(" SELECT DECODE(null, NULL, tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil('ASIA', tai_codigo)) tai_codigo ");
									sbtg.append("      , SUM(qtde_atual) ");
									sbtg.append("      , SUM(qtd) qtd ");
									sbtg.append("   FROM ( ");
									sbtg.append(" SELECT d.tai_codigo ");
									sbtg.append("      , decode(d.gde_cdgo,90,SUM(d.qtde_atual),99,SUM(d.qtde_atual), (SELECT qtd_pars FROM qtd WHERE gde_cdgo = d.gde_cdgo AND qtd_nume = d.tai_codigo)) qtde_atual ");
									sbtg.append("      , SUM(d.qtde_atual) qtd  ");
									sbtg.append("   FROM dom_local_item_estoque_gre d ");
									sbtg.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
									sbtg.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
									sbtg.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
									sbtg.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
									sbtg.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
									sbtg.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
									sbtg.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
									sbtg.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
									sbtg.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
									sbtg.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
									sbtg.append("    AND d.ies_codigo  = " + rset.getString(14));
									sbtg.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
									sbtg.append("    AND d.les_codigo  = " + rset.getString(4));
									sbtg.append("    AND d.tes_codigo  = " + rset.getString(5));
									sbtg.append("    AND d.tco_codigo  = " + rset.getString(6));
									sbtg.append("    AND d.gde_cdgo    = " + rsetg.getString(1));
									sbtg.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades	+ "))) ");
									if (ignorarGrade99.equals("S")) {
										sbtg.append(" AND d.gde_cdgo <> 99 ");
									}									
									sbtg.append("    AND d.qtde_atual  > 0 ");
									sbtg.append("  GROUP BY d.tai_codigo, d.gde_cdgo ");
									sbtg.append("  UNION ");
									sbtg.append(" SELECT d.tai_codigo ");
									sbtg.append("      , 0 qtde_atual ");
									sbtg.append("      , 0 qtd ");
									sbtg.append("   FROM dom_local_item_estoque_gre d ");
									sbtg.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
									sbtg.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
									sbtg.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
									sbtg.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
									sbtg.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
									sbtg.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
									sbtg.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
									sbtg.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
									sbtg.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
									sbtg.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
									sbtg.append("    AND d.ies_codigo  = " + rset.getString(14));
									sbtg.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
									sbtg.append("    AND d.les_codigo  = " + rset.getString(4));
									sbtg.append("    AND d.tes_codigo  = " + rset.getString(5));
									sbtg.append("    AND d.tco_codigo  = " + rset.getString(6));
									sbtg.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades	+ "))) ");
									if (ignorarGrade99.equals("S")) {
										sbtg.append(" AND d.gde_cdgo <> 99 ");
									}									
									sbtg.append("    AND d.qtde_atual  > 0 ");
									sbtg.append("  GROUP BY d.tai_codigo ");
									sbtg.append("  ) ");
									sbtg.append(" GROUP BY  tai_codigo ");
									sbtg.append(" ORDER BY TO_NUMBER(regexp_substr(tai_codigo, '[[:digit:]]+', 1, 1)) ");

									pstmtg = j.getConn().prepareStatement(sbtg.toString());
									rsettg = pstmtg.executeQuery();
									qtds_grades = 0;
									qtds_grd = 0;
									while (rsettg.next()) {
										tcell = trow.createCell(++cellcount);
										tcell.setCellValue(rsettg.getString(2));
										qtds_grades += Double.parseDouble(rsettg.getString(2));
										qtds_grd += Double.parseDouble(rsettg.getString(3));
										tcell.setCellStyle(styleGrade);
									}
									tcell = trow.createCell(++cellcount);
									tcell.setCellValue(com.egen.util.text.FormatNumber.format(qtds_grades, "##,##0.##"));
									tcell.setCellStyle(styleGrade);

									tcell = trow.createCell(++cellcount);
									if (rsetg.getString(1).equals("99") || rsetg.getString(1).equals("90")) {
										tcell.setCellValue("");
										tcell.setCellStyle(styleGrade);
									} else {
										tcell.setCellValue(com.egen.util.text.FormatNumber.format((qtds_grd / qtds_grades), "##,##0.##"));
										tcell.setCellStyle(styleGrade);
									}
									rsettg.close();
									pstmtg.close();
								}
								contadorgrade++;
								gradeantiga = rsetg.getString(1);
							}
							rowcount++;
							rsetg.close();
							pstmg.close();
							// --------------------------------------------------------------------------------------------------
							trow = testsheet.createRow((++rowcount).intValue());
						}
						if ((contadorGradeQuebrada == 0) && (p_grade_quebrada.equals("S"))) {
							testsheet.removeRow(trowGradeQuebrada);
						}
						rsetc.close();
						pstmc.close();
					}
					// --------------------------------------------------------------------------------------
					if (p_imprime_imagens.equals("S")) {
						if (((contadorGradeQuebrada > 0) && (p_grade_quebrada.equals("S")))
								|| (p_grade_quebrada.equals("N"))) {
							//String arquivo = diretorioImagens + rset.getString("imagem");
							String arquivo = diretorioImagens + imagem;
							java.io.File f = new java.io.File(arquivo);
							if (!f.isFile()) {
								arquivo = diretorioSemImagem + "sem_imagem.jpg";
							}
							FileInputStream fis = new FileInputStream(arquivo);
							ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
							int b;
							while ((b = fis.read()) != -1) {
								img_bytes.write(b);
							}
							fis.close();
							HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (1), (rowcount_imagem.intValue()),(short) (6), rowcount_imagem.intValue() + 13);
							int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
							patriarch.createPicture(anchor, index);
							anchor.setAnchorType(2);
							rowcount += 10;

						}
					}
					modeloantigo = rset.getString(13);
					contador++;
				}
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

	@SuppressWarnings("resource")
	public String geraExcelTodasCores(String p_emp_empresa, String p_fil_filial, String p_les_codigo,
			String p_tco_codigo, String p_ies_codigo, String p_ref_cdgo, String p_cab_cdgo, String p_cor_cdgo,
			String p_lin_cdgo, String p_codigo_marca, String p_mix_produtos, String p_qtde_inicial, String p_qtde_final,
			String p_tipo_produto, String p_tes_codigo, String p_tipo_produtos, String p_imprime_imagens,
			String p_considera_transito, String p_grades, String p_data_inicial, String p_data_final,
			String p_ordenacao, String p_mostra_preco, String p_grade_quebrada, String p_livro, String p_ignorar_95,
			boolean mostra_query, String p_qtde_itens, String p_est_inicial, String p_est_final, String p_continente,
			String p_marcas_selecionadas, String p_linhas_desconsiderar, String p_linhas_considerar, String p_valor_inicial, String p_valor_final, String ignorarGrade99, String layout) throws Exception {

		if (p_continente == null) {
			p_continente = "null";
		} else {
			p_continente = "'" + p_continente + "'";
		}
		p_imprime_imagens = "S";
		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFRow trowGradeQuebrada;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet rsett = null;
		java.sql.PreparedStatement pstmc = null;
		java.sql.ResultSet rsetc = null;
		java.sql.PreparedStatement pstmg = null;
		java.sql.ResultSet rsetg = null;
		java.sql.ResultSet rsettg = null;
		java.sql.PreparedStatement pstmtg = null;
		Query query = new Query();
		com.egen.util.jdbc.JdbcUtil j = null;
		String modeloantigo = null;
		StringBuilder nomeArquivo = new StringBuilder();
		String gradeantiga = null;
		int indexDataLogAfv = 0;
		boolean informouDataLogAfv = false;
		
		String linhasDesconsiderar = null;
		if(!p_linhas_desconsiderar.equals("null")){
		     String linhas = p_linhas_desconsiderar.replaceAll("[^0-9]", " ").trim();
		     linhas = linhas.replaceAll("\\s+", " ");
		     linhas = linhas.replaceAll(" ", "\n");
		     linhas = linhas.replaceAll("\\r\\n|\\r|\\n", ",");
		     if((linhas.charAt(linhas.length()-1)+"").equalsIgnoreCase(",")){
		    	 linhas = linhas.substring(0, linhas.lastIndexOf(","));
		     }
		     linhasDesconsiderar = " AND nvl(i.lin_cdgo, null) NOT IN (" + linhas +")";
		}
		
		String linhasConsiderar = null;
		if(!p_linhas_considerar.equals("null")){
		     String linhas = p_linhas_considerar.replaceAll("[^0-9]", " ").trim();
		     linhas = linhas.replaceAll("\\s+", " ");
		     linhas = linhas.replaceAll(" ", "\n");
		     linhas = linhas.replaceAll("\\r\\n|\\r|\\n", ",");
		     if((linhas.charAt(linhas.length()-1)+"").equalsIgnoreCase(",")){
		    	 linhas = linhas.substring(0, linhas.lastIndexOf(","));
		     }
		     linhasConsiderar = " AND nvl(i.lin_cdgo, null) IN (" + linhas +")";
   	    }
		
		if (p_est_inicial != null || p_est_final != null || p_ordenacao.equals("data_les_lin_ref")) {
			informouDataLogAfv = true;
			indexDataLogAfv = 1;
		}

		int cellcount = -1;
		int contador = 0;
		int contadorGradeQuebrada = 0;
		int rowcount_imagem = 0;
		int contadorgrade = 0;
		double qtds_grades = 0;
		double qtds_grd = 0;
		String retorno = "";
		boolean gerou = false;
		int spanPreco = 0;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
        String diretorioImagens = "/home/loja_brportal/imagens/grandes/";
      //String diretorioImagens = "c:/opt/arquivos_sites/imagens/grandes/";
		String diretorioSemImagem = "/opt/tomcat/webapps/brportal/img/";
      //String diretorioSemImagem = "c:/egen/tomcat/webapps/brportal/img/";
		List<Integer> listaMarcas = new ArrayList<Integer>();
		if (p_marcas_selecionadas == null || p_marcas_selecionadas.isEmpty()) {
			listaMarcas.add(99);
		} else {
			String[] marcas = p_marcas_selecionadas.split(",");
			for (String m : marcas) {
				listaMarcas.add(Integer.parseInt(m));
			}
		}
		try {
			if (p_mostra_preco.equals("S")) {
				spanPreco = 2;
			}
			nomeArquivo.append("est102").append(util.rand.Palavra.geraPalavra()).append(".xls");
		    FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
  	      //FileOutputStream fos = new FileOutputStream("c:/temp/" + nomeArquivo.toString());
			for (Integer marca : listaMarcas) {
				String descricaoPlanilha = null;
				int contadorPlanilha = 0;
				if (p_marcas_selecionadas == null || p_marcas_selecionadas.isEmpty()) {
					descricaoPlanilha = "estoque";
				} else {
					descricaoPlanilha = query.retorna("SELECT descricao_marca FROM marcas_produtos WHERE codigo_marca = " + marca);
					p_codigo_marca = marca + "";
				}
				int rowcount = 0;
				HSSFSheet testsheet = wb.createSheet(descricaoPlanilha);
				HSSFSheet sheet = wb.getSheet(descricaoPlanilha);
				HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
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

				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(0);
				tcell.setCellValue("Emp");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(1);
				tcell.setCellValue("Fil");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(2);
				tcell.setCellValue("Unn");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(3);
				tcell.setCellValue("Local");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(4);
				tcell.setCellValue("Tes");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(5);
				tcell.setCellValue("Tco");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(6);
				tcell.setCellValue("Produto");
				tcell.setCellStyle(style);
				tcell = trow.createCell(7);
				tcell.setCellValue("Descrição");
				tcell.setCellStyle(style);
				if (informouDataLogAfv) {
					tcell = trow.createCell(8);
					tcell.setCellValue("Data Est.");
					tcell.setCellStyle(style);
				}
				if (p_mostra_preco.equals("S")) {
					tcell = trow.createCell(8 + indexDataLogAfv);
					tcell.setCellValue("Livro");
					tcell.setCellStyle(style);
					tcell = trow.createCell(9 + indexDataLogAfv);
					tcell.setCellValue("Preço");
					tcell.setCellStyle(style);
				}
				tcell = trow.createCell(8 + spanPreco + indexDataLogAfv);
				tcell.setCellValue("Fil/Ativa");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(9 + spanPreco + indexDataLogAfv);
				tcell.setCellValue("Cor");
				tcell.setCellStyle(style);
				j = new com.egen.util.jdbc.JdbcUtil();
				StringBuilder sb = new StringBuilder();
				
				sb.append(" SELECT * FROM ( ");
				sb.append(" SELECT DISTINCT d.emp_empresa ");
				sb.append("               , d.fil_filial ");
				sb.append("               , d.unn_codigo ");
				sb.append("               , d.les_codigo ");
				sb.append("               , d.tes_codigo ");
				sb.append("               , d.tco_codigo ");
				sb.append("               , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ies_codigox ");
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , d.cor_cdgo ");
				} else {
					sb.append("           , 0 cor_cdgo ");
				}
				sb.append("               , pck_cabedal.get_nome(i.cab_cdgo) desc_cab ");
				sb.append("               , 0 desc_cor ");
				
				String livroExportacao = "50, 51, 52, 53, 54, 56, 57, 102";
				if(livroExportacao.contains(p_livro)){
					sb.append(" ,      (SELECT tp.preco_unitario ");
					sb.append(" 	      FROM tabela_preco_mercado_externo tp ");
					sb.append(" 	     WHERE tp.codigo_linha = i.lin_cdgo ");
					sb.append(" 	       AND tp.codigo_referencia = i.ref_cdgo ");
					sb.append(" 	       AND tp.codigo_cabedal = i.cab_cdgo ");
					sb.append(" 	       AND tp.codigo_livro = " + p_livro);
					sb.append(" 	       and tp.codigo_pais = 1 ");
					sb.append(" 	       AND tp.status = 'A' ");
					sb.append(" 	       AND tp.versao_tabela = (SELECT MAX(tpp.versao_tabela) ");
					sb.append(" 	                                 FROM tabela_preco_mercado_externo tpp ");
					sb.append(" 	                                WHERE tp.codigo_livro = tpp.codigo_livro ");
					sb.append(" 	                                  AND tp.codigo_linha = tpp.codigo_linha ");
					sb.append(" 	                                  and tpp.codigo_livro = " + p_livro);
					sb.append(" 	                                  and tpp.status = 'A' ");
					sb.append(" 	                                  AND tp.codigo_referencia = tpp.codigo_referencia ");
					sb.append(" 	                                  AND tp.codigo_cabedal = tpp.codigo_cabedal ");
					sb.append(" 	                                  AND tp.codigo_pais = tpp.codigo_pais)) preco_produto ");
				} else {
				   sb.append("               , fct_preco_produto_est102('").append(p_ignorar_95).append("',").append(p_livro).append(", i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) preco_produto ");
				}				
				
				sb.append("               , fnc_retorna_filial_lin_ref(i.lin_cdgo, i.ref_cdgo) filial_ativa ");
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) || d.cor_cdgo   modelo ");
				} else {
					sb.append("           , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)   modelo ");
				}
				sb.append("               , d.ies_codigo ");
				sb.append("               , i.lin_cdgo ");
				sb.append("               , i.ref_cdgo ");

				if (p_ignorar_95.equals("S")) {
					sb.append("           , ").append(p_livro).append(" livro ");
				} else {
					sb.append("           , CASE WHEN ").append(p_livro)
							.append(" = 95 THEN 95 ELSE decode((fct_busca_preco_livro(").append(p_livro)
							.append(", TRUNC(SYSDATE), i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)),0,95,").append(p_livro)
							.append(") END livro ");
				}
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo, d.cor_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
				} else {
					sb.append("           , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
				}
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , SUM(d.qtde_atual) qtde_atual ");
				}
				if (p_ordenacao.equals("data_les_lin_ref") || informouDataLogAfv) {
					sb.append("           , MIN(d.data_log_afv) data_log_afv ");
					sb.append("           , to_char(MIN(d.data_log_afv),'dd/mm/yyyy') data_log_afv_desc ");
				}
				sb.append("   FROM dom_item_estoque i ");
				sb.append("      , REF r ");
				sb.append("      , dom_local_item_estoque_gre d ");
			  //sb.append("      , ficha_tec ft ");
				sb.append("      , (SELECT d.ies_codigo ");
				sb.append("              , d.cor_cdgo ");
				sb.append("              , d.emp_empresa ");
				sb.append("              , d.fil_filial ");
				sb.append("              , d.unn_codigo ");
				sb.append("              , d.les_codigo ");
				sb.append("              , d.tes_codigo ");
				sb.append("              , d.tco_codigo ");
				sb.append("              , SUM(d.qtde_atual) soma ");
				sb.append("           FROM dom_local_item_estoque_gre d ");
				sb.append("          WHERE d.emp_empresa = NVL(").append(p_emp_empresa).append(", d.emp_empresa) ");
				sb.append("            AND d.fil_filial = NVL(").append(p_fil_filial).append(", d.fil_filial) ");
				sb.append("            AND d.les_codigo = NVL(").append(p_les_codigo).append(", d.les_codigo) ");
				sb.append("            AND d.tes_codigo IN (").append(p_tes_codigo).append(") ");
				sb.append("            AND (d.tes_codigo NOT IN (8) OR NVL('").append(p_considera_transito).append("', 'N') = 'S') ");
				sb.append("            AND d.tco_codigo = NVL(").append(p_tco_codigo).append(", d.tco_codigo) ");
				sb.append("            AND (" + ((p_ies_codigo + "").equals("null") ? null : 1)+ " is null or d.ies_codigo in (" + p_ies_codigo + ")) ");
				sb.append("            AND d.cor_cdgo = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
				sb.append("            AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
				if (ignorarGrade99.equals("S")) {
					sb.append("        AND d.gde_cdgo <> 99 ");
				}				
				sb.append("            AND d.qtde_atual > 0 ");
				sb.append("          GROUP BY d.ies_codigo ");
				sb.append("                 , d.cor_cdgo ");
				sb.append("                 , d.emp_empresa ");
				sb.append("                 , d.fil_filial ");
				sb.append("                 , d.unn_codigo ");
				sb.append("                 , d.les_codigo ");
				sb.append("                 , d.tes_codigo ");
				sb.append("                 , d.tco_codigo) dd ");
				sb.append("  WHERE d.ies_codigo            = i.codigo ");
				//sb.append("    AND NVL(i.tipo, NULL)       = 'A' ");
				//sb.append("    AND ft.lin_cdgo             = i.lin_cdgo ");
				//sb.append("    AND ft.ref_cdgo             = i.ref_cdgo ");
				//sb.append("    AND ft.cab_cdgo             = i.cab_cdgo ");
				
				if (linhasDesconsiderar != null) {
					sb.append(linhasDesconsiderar);
				}
				
				if (linhasConsiderar != null) {
					sb.append(linhasConsiderar);
				}								
				
				sb.append("    AND NVL(i.lin_cdgo, NULL)   = NVL(" + p_lin_cdgo + ", i.lin_cdgo) ");
				sb.append("    AND NVL(i.ref_cdgo, NULL)   = NVL(" + p_ref_cdgo + ", i.ref_cdgo) ");
				sb.append("    AND NVL(i.cab_cdgo, NULL)   = NVL(" + p_cab_cdgo + ", i.cab_cdgo) ");
				sb.append("    AND d.tes_codigo            IN (" + p_tes_codigo + ") ");
				sb.append("    AND r.lin_cdgo              = i.lin_cdgo ");
				sb.append("    AND r.ref_cdgo              = i.ref_cdgo ");
				sb.append("    AND r.codigo_marca          = NVL(" + p_codigo_marca + ", r.codigo_marca) ");
				sb.append("    AND (NVL('" + p_mix_produtos	+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '" + p_mix_produtos + "') ");
				sb.append("    AND d.ies_codigo            = i.codigo ");
				sb.append("    AND d.emp_empresa           = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
				sb.append("    AND d.fil_filial            = NVL(" + p_fil_filial + ", d.fil_filial) ");
				sb.append("    AND d.les_codigo            = NVL(" + p_les_codigo + ", d.les_codigo) ");
				sb.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
				sb.append("    AND d.tco_codigo            = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
				sb.append("    AND (" + ((p_ies_codigo + "").equals("null") ? null : 1)	+ " is null or d.ies_codigo in (" + p_ies_codigo + ")) ");
				sb.append("    AND d.cor_cdgo              = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
				if (p_tipo_produtos != null) {
					sb.append("    AND nvl(r.ref_grupo_posicao_fab,null) in (" + p_tipo_produtos + ") ");
				}
				sb.append("    AND d.emp_empresa           = dd.emp_empresa ");
				sb.append("    AND d.fil_filial            = dd.fil_filial ");
				sb.append("    AND d.unn_codigo            = dd.unn_codigo ");
				sb.append("    AND d.cor_cdgo              = dd.cor_cdgo ");
				sb.append("    AND d.les_codigo            = dd.les_codigo ");
				sb.append("    AND d.tes_codigo            = dd.tes_codigo ");
				sb.append("    AND d.tco_codigo            = dd.tco_codigo ");
				sb.append("    AND dd.ies_codigo           = i.codigo ");
				sb.append("    AND (" + p_qtde_inicial + " IS NULL OR NVL(dd.soma, NULL) >= " + p_qtde_inicial + ") ");
				sb.append("    AND (" + p_qtde_final + " IS NULL OR NVL(dd.soma, NULL) <= " + p_qtde_final + ") ");
				sb.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
				if (ignorarGrade99.equals("S")) {
					sb.append(" AND d.gde_cdgo <> 99 ");
				}				
				sb.append("    AND NVL(TRUNC(i.dthr_alteracao), TRUNC(SYSDATE)) >= TO_DATE('" + p_data_inicial + "', 'dd/mm/yyyy') ");
				sb.append("    AND NVL(TRUNC(i.dthr_alteracao), TRUNC(SYSDATE)) <= TO_DATE('" + p_data_final + "', 'dd/mm/yyyy') ");
				if (p_est_inicial != null) {
					sb.append("    AND NVL(TRUNC(d.data_log_afv), TRUNC(SYSDATE)) >= TO_DATE('" + p_est_inicial	+ "', 'dd/mm/yyyy') ");
				}
				if (p_est_final != null) {
					sb.append("	   AND NVL(TRUNC(d.data_log_afv), TRUNC(SYSDATE)) <= TO_DATE('" + p_est_final + "', 'dd/mm/yyyy') ");
				}
				sb.append("    AND d.qtde_atual            > 0 ");
				if (p_ordenacao.equals("qtd_les_lin_ref") || p_ordenacao.equals("data_les_lin_ref")
						|| informouDataLogAfv) {
					sb.append(" GROUP BY d.emp_empresa ");
					sb.append("	       , d.fil_filial ");
					sb.append("	       , d.unn_codigo ");
					sb.append("	       , d.les_codigo ");
					sb.append("	       , d.tes_codigo ");
					sb.append("	       , d.tco_codigo ");
					sb.append("	       , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ");
					sb.append("	       , pck_cabedal.get_nome(i.cab_cdgo) ");
					sb.append("	       , fnc_retorna_filial_lin_ref(i.lin_cdgo, i.ref_cdgo) ");
					sb.append("	       , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ");
					sb.append("	       , d.ies_codigo ");
					sb.append("	       , i.lin_cdgo ");
					sb.append("	       , i.ref_cdgo ");
					if (p_ordenacao.equals("qtd_les_lin_ref")) {
						sb.append("	   , d.cor_cdgo ");
					}
					sb.append("        , i.cab_cdgo ");
				}
				
				sb.append(" ) ");
				sb.append(" WHERE 1=1 ");
				sb.append("   AND (" + p_valor_inicial + " IS NULL OR NVL(preco_produto, NULL) >= " + p_valor_inicial + ") ");
				sb.append("   AND (" + p_valor_final + " IS NULL OR NVL(preco_produto, NULL) <= " + p_valor_final + ") ");

				if (p_ordenacao.equals("linha")) {
					sb.append("  ORDER BY 15,16 ");
				} else if (p_ordenacao.equals("normal")) {
					sb.append("  ORDER BY 1,2,4,5,6,7,8 ");
				} else if (p_ordenacao.equals("fil_lin_ref")) {
					sb.append("  ORDER BY 2,15,16 ");
				} else if (p_ordenacao.equals("les_lin_ref")) {
					sb.append("  ORDER BY 4,15,16 ");
				} else if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("  ORDER BY qtde_atual DESC, 4,15,16 ");
				} else if (p_ordenacao.equals("data_les_lin_ref")) {
					sb.append("  ORDER BY data_log_afv asc, 4,15,16");
				} else {
					sb.append("  ORDER BY 4,5,6,7,8 ");
				}

				if (mostra_query) {
					throw new Exception(sb.toString());
				}
				pstm = j.getConn().prepareStatement(sb.toString());
				rset = pstm.executeQuery();
				int quantidadeItens = 0;
				int totalItens = Integer.parseInt(p_qtde_itens);
				String imagem = "";
				while (rset.next() && (quantidadeItens < totalItens)) {
					if (rowcount > 32000) {
						rowcount = 0;
						rowcount_imagem = 0;
						testsheet = wb.createSheet(descricaoPlanilha + "_" + ++contadorPlanilha);
						sheet = wb.getSheet(descricaoPlanilha + "_" + contadorPlanilha);
						patriarch = sheet.createDrawingPatriarch();
					
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue("Emp");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(1);
						tcell.setCellValue("Fil");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(2);
						tcell.setCellValue("Unn");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(3);
						tcell.setCellValue("Local");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(4);
						tcell.setCellValue("Tes");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(5);
						tcell.setCellValue("Tco");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(6);
						tcell.setCellValue("Produto");
						tcell.setCellStyle(style);
						tcell = trow.createCell(7);
						tcell.setCellValue("Descrição");
						tcell.setCellStyle(style);
						if (informouDataLogAfv) {
							tcell = trow.createCell(8);
							tcell.setCellValue("Data Est.");
							tcell.setCellStyle(style);
						}
						if (p_mostra_preco.equals("S")) {
							tcell = trow.createCell(8 + indexDataLogAfv);
							tcell.setCellValue("Livro");
							tcell.setCellStyle(style);
							tcell = trow.createCell(9 + indexDataLogAfv);
							tcell.setCellValue("Preço");
							tcell.setCellStyle(style);
						}
						tcell = trow.createCell(8 + spanPreco + indexDataLogAfv);
						tcell.setCellValue("Fil/Ativa");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(9 + spanPreco + indexDataLogAfv);
						tcell.setCellValue("Cor");
						tcell.setCellStyle(style);
					}
					quantidadeItens++;
					contadorGradeQuebrada = 0;
					gerou = true;
					if ((!rset.getString(13).equals(modeloantigo)) || contador == 0) {
						++rowcount;
						rowcount_imagem = rowcount + 1;
						trow = testsheet.createRow(rowcount);
						trowGradeQuebrada = trow;
						tcell = trow.createCell(0);
						tcell.setCellValue(rset.getString("emp_empresa"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(1);
						tcell.setCellValue(rset.getString("fil_filial"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(2);
						tcell.setCellValue(rset.getString("unn_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(3);
						tcell.setCellValue(rset.getString("les_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(4);
						tcell.setCellValue(rset.getString("tes_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(5);
						tcell.setCellValue(rset.getString("tco_codigo"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(6);
						tcell.setCellValue(rset.getString("ies_codigox"));
						tcell = trow.createCell(7);
						tcell.setCellValue(rset.getString("desc_cab"));
						if (informouDataLogAfv) {
							tcell = trow.createCell(8);
							tcell.setCellValue(rset.getString("data_log_afv_desc"));
						}
						if (p_mostra_preco.equals("S")) {
							tcell = trow.createCell(8 + indexDataLogAfv);
							tcell.setCellValue(rset.getString("livro"));
							tcell.setCellStyle(stylecenter);
							tcell = trow.createCell(9 + indexDataLogAfv);
							tcell.setCellValue(rset.getString("preco_produto"));
							tcell.setCellStyle(stylecenter);
						}

						tcell = trow.createCell(8 + spanPreco + indexDataLogAfv);
						tcell.setCellValue(rset.getString("filial_ativa"));
						tcell.setCellStyle(stylecenter);

						StringBuilder sbc = new StringBuilder();
						sbc.append(" SELECT DISTINCT d.cor_cdgo  ");
						sbc.append("               , pck_cor.get_nome(d.cor_cdgo) desc_cor  ");
						sbc.append("               , CASE WHEN (max(case when instr(d.tai_codigo,'/') > 0 then to_number(substr(d.tai_codigo,(instr(d.tai_codigo,'/')+1), length(d.tai_codigo))) else TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)) end) - ");
						sbc.append("                 MIN(TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)))) = ");
						sbc.append("                 COUNT(DISTINCT TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1))) * sum(distinct case when instr(d.tai_codigo,'/') > 0 then 2 else 1 end) -1 THEN 'N' ELSE 'S' END furada ");
						sbc.append("               , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo, d.cor_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
						sbc.append("   FROM dom_item_estoque i  ");
						sbc.append("      , ref r ");
						sbc.append("      , (SELECT ddd.tai_codigo, ddd.fil_filial, ddd.emp_empresa, ddd.unn_codigo, ddd.les_codigo, ddd.tes_codigo, ddd.tco_codigo, ddd.ies_codigo,ddd.cor_cdgo, ddd.qtde_atual, ddd.gde_cdgo FROM  dom_local_item_estoque_gre ddd) d ");
						sbc.append("      , (SELECT d.ies_codigo ");
						sbc.append("              , d.cor_cdgo ");
						sbc.append("              , d.emp_empresa ");
						sbc.append("              , d.fil_filial ");
						sbc.append("              , d.unn_codigo ");
						sbc.append("              , d.les_codigo ");
						sbc.append("              , d.tes_codigo ");
						sbc.append("              , d.tco_codigo ");
						sbc.append("              , SUM(d.qtde_atual) soma ");
						sbc.append("           FROM dom_local_item_estoque_gre d ");
						sbc.append("          WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
						sbc.append("            AND d.fil_filial = NVL(" + p_fil_filial + ", d.fil_filial) ");
						sbc.append("            AND d.les_codigo = NVL(" + p_les_codigo + ", d.les_codigo) ");
						sbc.append("            AND d.tes_codigo IN (" + p_tes_codigo + ") ");
						sbc.append("            AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
						sbc.append("            AND d.tco_codigo = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
						sbc.append("            AND d.ies_codigo = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
						sbc.append("            AND d.cor_cdgo = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
						sbc.append("            AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
						if (ignorarGrade99.equals("S")) {
							sbc.append("        AND d.gde_cdgo <> 99 ");
						}						
						sbc.append("            AND d.qtde_atual > 0 ");
						sbc.append("          GROUP BY d.ies_codigo ");
						sbc.append("                 , d.cor_cdgo ");
						sbc.append("                 , d.emp_empresa ");
						sbc.append("                 , d.fil_filial ");
						sbc.append("                 , d.unn_codigo ");
						sbc.append("                 , d.les_codigo ");
						sbc.append("                 , d.tes_codigo ");
						sbc.append("                 , d.tco_codigo) dd ");
						sbc.append("  WHERE d.ies_codigo            = i.codigo  ");
						
						if (linhasDesconsiderar != null) {
							sbc.append(linhasDesconsiderar);
						}
						
						if (linhasConsiderar != null) {
							sbc.append(linhasConsiderar);
						}
						
						//sbc.append("    AND NVL(i.tipo, NULL)       = 'A'  ");
						sbc.append("    AND NVL(i.lin_cdgo, NULL)   = NVL(" + p_lin_cdgo + ", i.lin_cdgo)  ");
						sbc.append("    AND NVL(i.ref_cdgo, NULL)   = NVL(" + p_ref_cdgo + ", i.ref_cdgo)  ");
						sbc.append("    AND NVL(i.cab_cdgo, NULL)   = NVL(" + p_cab_cdgo + ", i.cab_cdgo)  ");
						sbc.append("    AND d.tes_codigo            IN (" + p_tes_codigo + ")  ");
						sbc.append("    AND r.lin_cdgo              = i.lin_cdgo  ");
						sbc.append("    AND r.ref_cdgo              = i.ref_cdgo  ");
						sbc.append("    AND r.codigo_marca          = NVL(" + p_codigo_marca + ", r.codigo_marca)  ");
						sbc.append("    AND (NVL('" + p_mix_produtos + "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '" + p_mix_produtos + "')  ");
						sbc.append("    AND d.ies_codigo            = i.codigo  ");
						sbc.append("    AND d.emp_empresa           = NVL(" + p_emp_empresa + ", d.emp_empresa)  ");
						sbc.append("    AND d.fil_filial            = NVL(" + p_fil_filial + ", d.fil_filial)  ");
						sbc.append("    AND d.les_codigo            = NVL(" + p_les_codigo + ", d.les_codigo)  ");
						sbc.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S')  ");
						sbc.append("    AND d.tco_codigo            = NVL(" + p_tco_codigo + ", d.tco_codigo)  ");
						sbc.append("    AND d.ies_codigo            = NVL(" + p_ies_codigo + ", d.ies_codigo)  ");
						sbc.append("    AND d.cor_cdgo              = NVL(" + p_cor_cdgo + ", d.cor_cdgo)  ");
						sbc.append("    AND d.emp_empresa           = '" + rset.getString("emp_empresa") + "' ");
						sbc.append("    AND d.fil_filial            = '" + rset.getString("fil_filial") + "' ");
						sbc.append("    AND d.unn_codigo            = '" + rset.getString("unn_codigo") + "' ");
						sbc.append("    AND d.les_codigo            = " + rset.getString("les_codigo"));
						sbc.append("    AND d.tes_codigo            = " + rset.getString("tes_codigo"));
						sbc.append("    AND d.tco_codigo            = " + rset.getString("tco_codigo"));
						sbc.append("    AND d.ies_codigo            = " + rset.getString("ies_codigo"));

						if (p_ordenacao.equals("qtd_les_lin_ref")) {
							sbc.append("    AND d.cor_cdgo              = " + rset.getString("cor_cdgo"));
						}
						if (p_tipo_produtos != null) {
							sbc.append("    AND nvl(r.ref_grupo_posicao_fab,null) in (" + p_tipo_produtos + ") ");
						}
						sbc.append("    AND d.emp_empresa           = dd.emp_empresa ");
						sbc.append("    AND d.fil_filial            = dd.fil_filial ");
						sbc.append("    AND d.unn_codigo            = dd.unn_codigo ");
						sbc.append("    AND d.cor_cdgo              = dd.cor_cdgo ");
						sbc.append("    AND d.les_codigo            = dd.les_codigo ");
						sbc.append("    AND d.tes_codigo            = dd.tes_codigo ");
						sbc.append("    AND d.tco_codigo            = dd.tco_codigo ");
						sbc.append("    AND dd.ies_codigo           = i.codigo ");
						sbc.append("    AND (" + p_qtde_inicial + " IS NULL OR NVL(dd.soma, NULL) >= " + p_qtde_inicial	+ ") ");
						sbc.append("    AND (" + p_qtde_final + " IS NULL OR NVL(dd.soma, NULL) <= " + p_qtde_final	+ ") ");
						sbc.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
						if (ignorarGrade99.equals("S")) {
							sbc.append(" AND d.gde_cdgo <> 99 ");
						}						
						sbc.append("    AND d.qtde_atual > 0 ");
						sbc.append(" GROUP BY d.cor_cdgo ");
						sbc.append("        , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo, d.cor_cdgo),'.gif','.jpg'), 'default.jpg')  ");

						if (p_grade_quebrada.equals("S")) {
							sbc.append(" HAVING  CASE WHEN (MAX(case when instr(d.tai_codigo,'/') > 0 then to_number(substr(d.tai_codigo,(instr(d.tai_codigo,'/')+1), length(d.tai_codigo))) else TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)) end) - ");
							sbc.append("                    MIN(TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1)))) = ");
							sbc.append("                    COUNT(DISTINCT TO_NUMBER(regexp_substr(d.tai_codigo, '[[:digit:]]+', 1, 1))) * sum(distinct case when instr(d.tai_codigo,'/') > 0 then 2 else 1 end) -1 THEN 'N' ELSE 'S' END = 'S' ");
						}

						sbc.append("  ORDER BY  1 ");
						pstmc = j.getConn().prepareStatement(sbc.toString());

						rsetc = pstmc.executeQuery();
						int contadorCores = 0;
						int contadorImagem = 0;
						while (rsetc.next()) {
							if (contadorImagem == 0) {
								imagem = rsetc.getString("imagem");
								contadorImagem++;
							}
							contadorCores++;
							contadorGradeQuebrada++;
							if (rsetc.getString(3).equals("S")) {
								styleGrade = wb.createCellStyle();
								HSSFFont font = wb.createFont();
								font.setColor(HSSFColor.WHITE.index);
								styleGrade.setFont(font);
								styleGrade.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.RED.index);
								styleGrade.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
								styleGrade.setBorderLeft((short) 2);
								styleGrade.setBorderRight((short) 2);
								styleGrade.setBorderTop((short) 2);
								styleGrade.setBorderBottom((short) 2);
								styleGrade.setAlignment((short) 2);
							} else {
								styleGrade = wb.createCellStyle();
								styleGrade.setFillPattern(HSSFCellStyle.NO_FILL);
								styleGrade.setBorderLeft((short) 1);
								styleGrade.setBorderRight((short) 1);
								styleGrade.setBorderTop((short) 1);
								styleGrade.setBorderBottom((short) 1);
								styleGrade.setAlignment((short) 2);
							}
							tcell = trow.createCell(9 + spanPreco + indexDataLogAfv);
							tcell.setCellValue(rsetc.getString(1) + " - " + rsetc.getString(2));

							// -------------- tamanhos geral --------------
							StringBuilder sbt = new StringBuilder();
							sbt.append(" SELECT DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) tai_codigo ");
							sbt.append("      , SUM(d.qtde_atual) qtde_atual ");
							sbt.append("   FROM dom_local_item_estoque_gre d ");
							sbt.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
							sbt.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
							sbt.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
							sbt.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
							sbt.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
							sbt.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
							sbt.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
							sbt.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
							sbt.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
							sbt.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
							sbt.append("    AND d.ies_codigo  = " + rset.getString(14));
							sbt.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
							sbt.append("    AND d.les_codigo  = " + rset.getString(4));
							sbt.append("    AND d.tes_codigo  = " + rset.getString(5));
							sbt.append("    AND d.tco_codigo  = " + rset.getString(6));
							sbt.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
							if (ignorarGrade99.equals("S")) {
								sbt.append(" AND d.gde_cdgo <> 99 ");
							}							
							sbt.append("    AND d.qtde_atual  > 0 ");
							sbt.append("  GROUP BY DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) ");
							sbt.append("  UNION ");
							sbt.append(" SELECT '999' tai_codigo  ");
							sbt.append("      , SUM(d.qtde_atual) qtde_atual ");
							sbt.append("   FROM dom_local_item_estoque_gre d ");
							sbt.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
							sbt.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
							sbt.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
							sbt.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
							sbt.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
							sbt.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
							sbt.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
							sbt.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
							sbt.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
							sbt.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
							sbt.append("    AND d.ies_codigo  = " + rset.getString(14));
							sbt.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
							sbt.append("    AND d.les_codigo  = " + rset.getString(4));
							sbt.append("    AND d.tes_codigo  = " + rset.getString(5));
							sbt.append("    AND d.tco_codigo  = " + rset.getString(6));
							sbt.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
							if (ignorarGrade99.equals("S")) {
								sbt.append(" AND d.gde_cdgo <> 99 ");
							}							
							sbt.append("    AND d.qtde_atual  > 0 ");
							sbt.append("  ORDER BY 1 ");

							pstmt = j.getConn().prepareStatement(sbt.toString());

							rsett = pstmt.executeQuery();
							cellcount = 10 + spanPreco + indexDataLogAfv;
							tcell = trow.createCell(cellcount);
							tcell.setCellValue("Tamanho");
							tcell.setCellStyle(styleGrade);
							trow = testsheet.createRow(++rowcount);
							tcell = trow.createCell(cellcount);
							tcell.setCellValue("Qtd. Pares");
							tcell.setCellStyle(styleGrade);
							while (rsett.next()) {
								trow = testsheet.getRow(--rowcount);
								tcell = trow.createCell(++cellcount);
								tcell.setCellValue(rsett.getString(1).replace("999", "Total"));
								tcell.setCellStyle(styleGrade);
								trow = testsheet.getRow(++rowcount);
								tcell = trow.createCell(cellcount);
								tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(rsett.getString(2)), "##0.##"));
								tcell.setCellStyle(styleGrade);
							}
							trow = testsheet.getRow(rowcount - 1);
							tcell = trow.createCell(++cellcount);
							tcell.setCellValue("Cxs");
							tcell.setCellStyle(styleGrade);

							trow = testsheet.getRow(rowcount);
							tcell = trow.createCell(cellcount);
							tcell.setCellValue("");
							tcell.setCellStyle(styleGrade);

							rsett.close();
							pstmt.close();
							// --------------------------------------------------------------------------------------------------
							gradeantiga = null;
							contadorgrade = 0;
							StringBuilder sbg = new StringBuilder();
							sbg.append(" SELECT d.gde_cdgo ");
							sbg.append("      , DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) tai_codigo ");
							sbg.append("      , SUM(d.qtde_atual) qtde_atual ");
							sbg.append("   FROM dom_local_item_estoque_gre d ");
							sbg.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
							sbg.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
							sbg.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
							sbg.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
							sbg.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
							sbg.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
							sbg.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
							sbg.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
							sbg.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
							sbg.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
							sbg.append("    AND d.ies_codigo  = " + rset.getString(14));
							sbg.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
							sbg.append("    AND d.les_codigo  = " + rset.getString(4));
							sbg.append("    AND d.tes_codigo  = " + rset.getString(5));
							sbg.append("    AND d.tco_codigo  = " + rset.getString(6));
							sbg.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
							if (ignorarGrade99.equals("S")) {
								sbg.append(" AND d.gde_cdgo <> 99 ");
							}							
							sbg.append("    AND d.qtde_atual  > 0 ");
							sbg.append("  GROUP BY DECODE(").append(p_continente).append(" , NULL, d.tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil(").append(p_continente).append(", d.tai_codigo)) ");
							sbg.append("         , d.gde_cdgo ");
							sbg.append("  ORDER BY 1 ");
							sbg.append("         , TO_NUMBER(regexp_substr(tai_codigo, '[[:digit:]]+', 1, 1)) ");

							pstmg = j.getConn().prepareStatement(sbg.toString());
							rsetg = pstmg.executeQuery();
							while (rsetg.next()) {
								if ((!rsetg.getString(1).equals(gradeantiga)) || contadorgrade == 0) {
									trow = testsheet.createRow(++rowcount);
									cellcount = 10 + spanPreco + indexDataLogAfv;
									tcell = trow.createCell(cellcount);
									tcell.setCellValue("Grade " + rsetg.getString(1));
									tcell.setCellStyle(styleGrade);
									StringBuilder sbtg = new StringBuilder();
									sbtg.append(" SELECT DECODE(null, NULL, tai_codigo, pck_numeracao_continentes.get_numeracao_by_num_brasil('ASIA', tai_codigo)) tai_codigo ");
									sbtg.append("      , SUM(qtde_atual) ");
									sbtg.append("      , SUM(qtd) qtd ");
									sbtg.append("   FROM ( ");
									sbtg.append(" SELECT d.tai_codigo ");
									sbtg.append("      , decode(d.gde_cdgo,90,SUM(d.qtde_atual),99,SUM(d.qtde_atual), (SELECT qtd_pars FROM qtd WHERE gde_cdgo = d.gde_cdgo AND qtd_nume = d.tai_codigo)) qtde_atual ");
									sbtg.append("      , SUM(d.qtde_atual) qtd  ");
									sbtg.append("   FROM dom_local_item_estoque_gre d ");
									sbtg.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
									sbtg.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
									sbtg.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
									sbtg.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
									sbtg.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
									sbtg.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
									sbtg.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
									sbtg.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
									sbtg.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
									sbtg.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
									sbtg.append("    AND d.ies_codigo  = " + rset.getString(14));
									sbtg.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
									sbtg.append("    AND d.les_codigo  = " + rset.getString(4));
									sbtg.append("    AND d.tes_codigo  = " + rset.getString(5));
									sbtg.append("    AND d.tco_codigo  = " + rset.getString(6));
									sbtg.append("    AND d.gde_cdgo    = " + rsetg.getString(1));
									sbtg.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades	+ "))) ");
									if (ignorarGrade99.equals("S")) {
										sbtg.append(" AND d.gde_cdgo <> 99 ");
									}									
									sbtg.append("    AND d.qtde_atual  > 0 ");
									sbtg.append("  GROUP BY d.tai_codigo, d.gde_cdgo ");
									sbtg.append("  UNION ");
									sbtg.append(" SELECT d.tai_codigo ");
									sbtg.append("      , 0 qtde_atual ");
									sbtg.append("      , 0 qtd ");
									sbtg.append("   FROM dom_local_item_estoque_gre d ");
									sbtg.append("  WHERE d.emp_empresa = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
									sbtg.append("    AND d.fil_filial  = NVL(" + p_fil_filial + ", d.fil_filial) ");
									sbtg.append("    AND d.les_codigo  = NVL(" + p_les_codigo + ", d.les_codigo) ");
									sbtg.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
									sbtg.append("    AND d.tco_codigo  = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
									sbtg.append("    AND d.ies_codigo  = NVL(" + p_ies_codigo + ", d.ies_codigo) ");
									sbtg.append("    AND d.cor_cdgo    = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
									sbtg.append("    AND d.emp_empresa = '" + rset.getString(1) + "' ");
									sbtg.append("    AND d.fil_filial  = '" + rset.getString(2) + "' ");
									sbtg.append("    AND d.unn_codigo  = '" + rset.getString(3) + "' ");
									sbtg.append("    AND d.ies_codigo  = " + rset.getString(14));
									sbtg.append("    AND d.cor_cdgo    = " + rsetc.getString(1));
									sbtg.append("    AND d.les_codigo  = " + rset.getString(4));
									sbtg.append("    AND d.tes_codigo  = " + rset.getString(5));
									sbtg.append("    AND d.tco_codigo  = " + rset.getString(6));
									sbtg.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades	+ "))) ");
									if (ignorarGrade99.equals("S")) {
										sbtg.append(" AND d.gde_cdgo <> 99 ");
									}									
									sbtg.append("    AND d.qtde_atual  > 0 ");
									sbtg.append("  GROUP BY d.tai_codigo ");
									sbtg.append("  ) ");
									sbtg.append(" GROUP BY tai_codigo ");
									sbtg.append(" ORDER BY TO_NUMBER(regexp_substr(tai_codigo, '[[:digit:]]+', 1, 1)) ");

									pstmtg = j.getConn().prepareStatement(sbtg.toString());
									rsettg = pstmtg.executeQuery();
									qtds_grades = 0;
									qtds_grd = 0;
									while (rsettg.next()) {
										tcell = trow.createCell(++cellcount);
										tcell.setCellValue(rsettg.getString(2));
										qtds_grades += Double.parseDouble(rsettg.getString(2));
										qtds_grd += Double.parseDouble(rsettg.getString(3));
										tcell.setCellStyle(styleGrade);
									}
									tcell = trow.createCell(++cellcount);
									tcell.setCellValue(com.egen.util.text.FormatNumber.format(qtds_grades, "##,##0.##"));
									tcell.setCellStyle(styleGrade);

									tcell = trow.createCell(++cellcount);
									if (rsetg.getString(1).equals("99") || rsetg.getString(1).equals("90")) {
										tcell.setCellValue("");
										tcell.setCellStyle(styleGrade);
									} else {
										tcell.setCellValue(com.egen.util.text.FormatNumber.format((qtds_grd / qtds_grades), "##,##0.##"));
										tcell.setCellStyle(styleGrade);
									}
									rsettg.close();
									pstmtg.close();
								}
								contadorgrade++;
								gradeantiga = rsetg.getString(1);
							}
							rowcount++;
							rsetg.close();
							pstmg.close();
							// --------------------------------------------------------------------------------------------------

							if (contadorCores > 1) {
						        String arquivo = diretorioImagens + rsetc.getString("imagem");
								//String arquivo = diretorioImagens + imagem;
								java.io.File f = new java.io.File(arquivo);
								if (!f.isFile()) {
									arquivo = diretorioSemImagem + "sem_imagem.jpg";
								}
								FileInputStream fis = new FileInputStream(arquivo);
								ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
								int b;
								while ((b = fis.read()) != -1) {
									img_bytes.write(b);
								}
								fis.close();
								HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (1),
										(/* rowcount_imagem */rowcount - 3), (short) (6),
										/* rowcount_imagem */ (rowcount - 3) + 13);
								int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
								patriarch.createPicture(anchor, index);
								anchor.setAnchorType(2);
							}
							rowcount += 12;
							trow = testsheet.createRow(rowcount);
						}
						rowcount -= 12;
						if ((contadorGradeQuebrada == 0) && (p_grade_quebrada.equals("S"))) {
							testsheet.removeRow(trowGradeQuebrada);
						}
						rsetc.close();
						pstmc.close();
					}
					// --------------------------------------------------------------------------------------
					if (p_imprime_imagens.equals("S")) {
						if (((contadorGradeQuebrada > 0) && (p_grade_quebrada.equals("S")))
								|| (p_grade_quebrada.equals("N"))) {
							//String arquivo = diretorioImagens + rset.getString("imagem");
							String arquivo = diretorioImagens + imagem;

							java.io.File f = new java.io.File(arquivo);
							if (!f.isFile()) {
								arquivo = diretorioSemImagem + "sem_imagem.jpg";
							}
							FileInputStream fis = new FileInputStream(arquivo);
							ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
							int b;
							while ((b = fis.read()) != -1){
								img_bytes.write(b);
							}
							fis.close();
							HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (1), (rowcount_imagem), (short) (6), rowcount_imagem + 13);
							int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
							patriarch.createPicture(anchor, index);
							anchor.setAnchorType(2);
							rowcount += 10;

						}
					}
					// --------------------------------------------------------------------------------------
					modeloantigo = rset.getString(13);
					contador++;
				}
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
	
	@SuppressWarnings("resource")
	public String geraExcelPadraoNovo(String p_emp_empresa, String p_fil_filial, String p_les_codigo,
			String p_tco_codigo, String p_ies_codigo, String p_ref_cdgo, String p_cab_cdgo, String p_cor_cdgo,
			String p_lin_cdgo, String p_codigo_marca, String p_mix_produtos, String p_qtde_inicial, String p_qtde_final,
			String p_tipo_produto, String p_tes_codigo, String p_tipo_produtos, String p_imprime_imagens,
			String p_considera_transito, String p_grades, String p_data_inicial, String p_data_final,
			String p_ordenacao, String p_mostra_preco, String p_grade_quebrada, String p_livro, String p_ignorar_95,
			boolean mostra_query, String p_qtde_itens, String p_est_inicial, String p_est_final, String p_continente,
			String p_marcas_selecionadas, String p_linhas_desconsiderar, String p_linhas_considerar, String p_valor_inicial, String p_valor_final, String ignorarGrade99, String layout) throws Exception {

		if (p_continente == null) {
			p_continente = "null";
		} else {
			p_continente = "'" + p_continente + "'";
		}
		p_imprime_imagens = "S";
		HSSFWorkbook wb = new HSSFWorkbook();
		autoSizeColumns(wb);
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		Query query = new Query();
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		boolean informouDataLogAfv = false;
		String linhasDesconsiderar = null;
		if(!p_linhas_desconsiderar.equals("null")){
		     String linhas = p_linhas_desconsiderar.replaceAll("[^0-9]", " ").trim();
		     linhas = linhas.replaceAll("\\s+", " ");
		     linhas = linhas.replaceAll(" ", "\n");
		     linhas = linhas.replaceAll("\\r\\n|\\r|\\n", ",");
		     if((linhas.charAt(linhas.length()-1)+"").equalsIgnoreCase(",")){
		    	 linhas = linhas.substring(0, linhas.lastIndexOf(","));
		     }
		     linhasDesconsiderar = " AND nvl(i.lin_cdgo, null) NOT IN (" + linhas +")";
		}
		
		String linhasConsiderar = null;
		if(!p_linhas_considerar.equals("null")){
		     String linhas = p_linhas_considerar.replaceAll("[^0-9]", " ").trim();
		     linhas = linhas.replaceAll("\\s+", " ");
		     linhas = linhas.replaceAll(" ", "\n");
		     linhas = linhas.replaceAll("\\r\\n|\\r|\\n", ",");
		     if((linhas.charAt(linhas.length()-1)+"").equalsIgnoreCase(",")){
		    	 linhas = linhas.substring(0, linhas.lastIndexOf(","));
		     }
		     linhasConsiderar = " AND nvl(i.lin_cdgo, null) IN (" + linhas +")";
   	    }
		
		if (p_est_inicial != null || p_est_final != null || p_ordenacao.equals("data_les_lin_ref")) {
			informouDataLogAfv = true;
		}

		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String diretorioImagens = "/home/loja_brportal/imagens/grandes/";
		//String diretorioImagens = "r:/";
		List<Integer> listaMarcas = new ArrayList<Integer>();
		if (p_marcas_selecionadas == null || p_marcas_selecionadas.isEmpty()) {
			listaMarcas.add(99);
		} else {
			String[] marcas = p_marcas_selecionadas.split(",");
			for (String m : marcas) {
				listaMarcas.add(Integer.parseInt(m));
			}
		}
		try {
			if (p_mostra_preco.equals("S")) {
			}
			nomeArquivo.append("est102").append(util.rand.Palavra.geraPalavra()).append(".xls");
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());///
			//FileOutputStream fos = new FileOutputStream("c:/temp/" + nomeArquivo.toString());
			for (Integer marca : listaMarcas) {
				String descricaoPlanilha = null;
				int contadorPlanilha = 0;
				if (p_marcas_selecionadas == null || p_marcas_selecionadas.isEmpty()) {
					descricaoPlanilha = "estoque";
				} else {
					descricaoPlanilha = query.retorna("SELECT descricao_marca FROM marcas_produtos WHERE codigo_marca = " + marca);
					p_codigo_marca = marca + "";
				}
				int rowcount = 0;
				HSSFSheet testsheet = wb.createSheet(descricaoPlanilha);
				HSSFSheet sheet = wb.getSheet(descricaoPlanilha);
				for(int x=0; x<4; x++) {
				testsheet.autoSizeColumn(x);
				}
				for(int x=0; x<4; x++) {
					sheet.autoSizeColumn(x);
					}
				
				HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
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

				trow = testsheet.createRow(rowcount);
				
				tcell = trow.createCell(0);
				tcell.setCellValue("Article");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(1);
				tcell.setCellValue("Category");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(2);
				tcell.setCellValue("Upper");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(3);
				tcell.setCellValue("Colour");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(4);
				tcell.setCellValue("Grid");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(5);
				tcell.setCellValue("Quantity");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(6);
				tcell.setCellValue("Photo");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(7);
				tcell.setCellValue("Price");
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(8);
				tcell.setCellValue("Composition");
				tcell.setCellStyle(style);
				j = new com.egen.util.jdbc.JdbcUtil();
				StringBuilder sb = new StringBuilder();
				
		        sb.append(" SELECT fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo) || '-' || qry.cor_cdgo article ");
				sb.append("      , pck_cat_produtos.get_descricao_referencia(lin_cdgo, ref_cdgo, 1) category ");
				sb.append("      , pck_cat_produtos.get_descricao_cabedal(cab_cdgo, 1) cabedal "); 
				sb.append("      , nvl(ic.descricao_cor, co.cor_desc) colour ");
				sb.append("      , soma quantity ");
				sb.append("      , NVL(REPLACE(fct_retorna_fit_imagem(lin_cdgo, ref_cdgo, cab_cdgo, qry.cor_cdgo), '.gif', '.jpg'), 'default.jpg') photo ");
				sb.append("      , CAST(case when l.tipo_mercado = 'MI' then 'R$' else NVL(tp.moe_codigo, 'US$') end AS VARCHAR2(10)) moeda ");
				sb.append("      , fct_preco_produto_est102('").append(p_ignorar_95).append("', ").append(p_livro).append(", lin_cdgo, ref_cdgo, cab_cdgo) price ");
				sb.append("      , (NVL(pck_composicao_produto.get_composicao_cabedal_perc(lin_cdgo, ref_cdgo, cab_cdgo), pck_composicao_produto.get_composicao_cabedal(cab_cdgo))) composition ");
				sb.append("      , gde_cdgo grade ");
				sb.append(" FROM ( ");
				sb.append(" SELECT DISTINCT i.cab_cdgo, d.emp_empresa ");
				sb.append("               , d.fil_filial ");
				sb.append("               , d.unn_codigo ");
				sb.append("               , d.les_codigo ");
				sb.append("               , d.tes_codigo ");
				sb.append("               , d.tco_codigo ");
				sb.append("               , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ies_codigox ");
				sb.append("               , d.cor_cdgo ");
				sb.append("               , pck_cabedal.get_nome(i.cab_cdgo) desc_cab ");
				sb.append("               , 0 desc_cor ");
				
				String livroExportacao = "50, 51, 52, 53, 54, 56, 57, 102";
				if(livroExportacao.contains(p_livro)){
					sb.append(" ,      (SELECT tp.preco_unitario ");
					sb.append(" 	      FROM tabela_preco_mercado_externo tp ");
					sb.append(" 	     WHERE tp.codigo_linha = i.lin_cdgo ");
					sb.append(" 	       AND tp.codigo_referencia = i.ref_cdgo ");
					sb.append(" 	       AND tp.codigo_cabedal = i.cab_cdgo ");
					sb.append(" 	       AND tp.codigo_livro = " + p_livro);
					sb.append(" 	       and tp.codigo_pais = 1 ");
					sb.append(" 	       AND tp.status = 'A' ");
					sb.append(" 	       AND tp.versao_tabela = (SELECT MAX(tpp.versao_tabela) ");
					sb.append(" 	                                 FROM tabela_preco_mercado_externo tpp ");
					sb.append(" 	                                WHERE tp.codigo_livro = tpp.codigo_livro ");
					sb.append(" 	                                  AND tp.codigo_linha = tpp.codigo_linha ");
					sb.append(" 	                                  and tpp.codigo_livro = " + p_livro);
					sb.append(" 	                                  and tpp.status = 'A' ");
					sb.append(" 	                                  AND tp.codigo_referencia = tpp.codigo_referencia ");
					sb.append(" 	                                  AND tp.codigo_cabedal = tpp.codigo_cabedal ");
					sb.append(" 	                                  AND tp.codigo_pais = tpp.codigo_pais)) preco_produto ");
				} else {
				   sb.append("               , fct_preco_produto_est102('").append(p_ignorar_95).append("',").append(p_livro).append(", i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) preco_produto ");
				}				
				
				sb.append("               , fnc_retorna_filial_lin_ref(i.lin_cdgo, i.ref_cdgo) filial_ativa ");
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) || d.cor_cdgo   modelo ");
				} else {
					sb.append("           , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)   modelo ");
				}
				sb.append("               , d.ies_codigo ");
				sb.append("               , i.lin_cdgo ");
				sb.append("               , i.ref_cdgo ");

				if (p_ignorar_95.equals("S")) {
					sb.append("           , ").append(p_livro).append(" livro ");
				} else {
					sb.append("           , CASE WHEN ").append(p_livro)
							.append(" = 95 THEN 95 ELSE decode((fct_busca_preco_livro(").append(p_livro)
							.append(", TRUNC(SYSDATE), i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)),0,95,").append(p_livro)
							.append(") END livro ");
				}
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo, d.cor_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
				} else {
					sb.append("           , NVL(REPLACE(fct_retorna_fit_imagem(i.lin_cdgo,i.ref_cdgo,i.cab_cdgo),'.gif','.jpg'), 'default.jpg') imagem ");
				}
				if (p_ordenacao.equals("qtd_les_lin_ref")) {
					sb.append("           , SUM(d.qtde_atual) qtde_atual ");
				}
				if (p_ordenacao.equals("data_les_lin_ref") || informouDataLogAfv) {
					sb.append("           , MIN(d.data_log_afv) data_log_afv ");
					sb.append("           , to_char(MIN(d.data_log_afv),'dd/mm/yyyy') data_log_afv_desc ");
				}
				sb.append(" , soma ");
				sb.append(" , d.gde_cdgo ");
				sb.append("   FROM dom_item_estoque i ");
				sb.append("      , ref r ");
				sb.append("      , dom_local_item_estoque_gre d ");
		      //sb.append("      , ficha_tec ft ");
				sb.append("      , (SELECT d.ies_codigo ");
				sb.append("              , d.cor_cdgo ");
				sb.append("              , d.emp_empresa ");
				sb.append("              , d.fil_filial ");
				sb.append("              , d.gde_cdgo ");
				sb.append("              , d.unn_codigo ");
				sb.append("              , d.les_codigo ");
				sb.append("              , d.tes_codigo ");
				sb.append("              , d.tco_codigo ");
				sb.append("              , SUM(d.qtde_atual) soma ");
				sb.append("           FROM dom_local_item_estoque_gre d ");
				sb.append("          WHERE d.emp_empresa = NVL(").append(p_emp_empresa).append(", d.emp_empresa) ");
				sb.append("            AND d.fil_filial = NVL(").append(p_fil_filial).append(", d.fil_filial) ");
				sb.append("            AND d.les_codigo = NVL(").append(p_les_codigo).append(", d.les_codigo) ");
				sb.append("            AND d.tes_codigo IN (").append(p_tes_codigo).append(") ");
				sb.append("            AND (d.tes_codigo NOT IN (8) OR NVL('").append(p_considera_transito).append("', 'N') = 'S') ");
				sb.append("            AND d.tco_codigo = NVL(").append(p_tco_codigo).append(", d.tco_codigo) ");
				sb.append("            AND (" + ((p_ies_codigo + "").equals("null") ? null : 1)+ " is null or d.ies_codigo in (" + p_ies_codigo + ")) ");
				sb.append("            AND d.cor_cdgo = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
				sb.append("            AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
				if (ignorarGrade99.equals("S")) {
					sb.append("        AND d.gde_cdgo <> 99 ");
				}				
				sb.append("            AND d.qtde_atual > 0 ");
				sb.append("          GROUP BY d.ies_codigo ");
				sb.append("                 , d.cor_cdgo ");
				sb.append("                 , d.gde_cdgo ");
				sb.append("                 , d.emp_empresa ");
				sb.append("                 , d.fil_filial ");
				sb.append("                 , d.unn_codigo ");
				sb.append("                 , d.les_codigo ");
				sb.append("                 , d.tes_codigo ");
				sb.append("                 , d.tco_codigo) dd ");
				sb.append("  WHERE d.ies_codigo            = i.codigo ");
				//sb.append("    AND NVL(i.tipo, NULL)       = 'A' ");
				//sb.append("    AND ft.lin_cdgo             = i.lin_cdgo ");
				//sb.append("    AND ft.ref_cdgo             = i.ref_cdgo ");
				//sb.append("    AND ft.cab_cdgo             = i.cab_cdgo ");
				
				if (linhasDesconsiderar != null) {
					sb.append(linhasDesconsiderar);
				}
				
				if (linhasConsiderar != null) {
					sb.append(linhasConsiderar);
				}								
				
				sb.append("    AND NVL(i.lin_cdgo, NULL)   = NVL(" + p_lin_cdgo + ", i.lin_cdgo) ");
				sb.append("    AND NVL(i.ref_cdgo, NULL)   = NVL(" + p_ref_cdgo + ", i.ref_cdgo) ");
				sb.append("    AND NVL(i.cab_cdgo, NULL)   = NVL(" + p_cab_cdgo + ", i.cab_cdgo) ");
				sb.append("    AND d.tes_codigo            IN (" + p_tes_codigo + ") ");
				sb.append("    AND r.lin_cdgo              = i.lin_cdgo ");
				sb.append("    AND r.ref_cdgo              = i.ref_cdgo ");
				sb.append("    AND r.codigo_marca          = NVL(" + p_codigo_marca + ", r.codigo_marca) ");
				sb.append("    AND (NVL('" + p_mix_produtos	+ "', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '" + p_mix_produtos + "') ");
				sb.append("    AND d.ies_codigo            = i.codigo ");
				sb.append("    AND d.emp_empresa           = NVL(" + p_emp_empresa + ", d.emp_empresa) ");
				sb.append("    AND d.fil_filial            = NVL(" + p_fil_filial + ", d.fil_filial) ");
				sb.append("    AND d.les_codigo            = NVL(" + p_les_codigo + ", d.les_codigo) ");
				sb.append("    AND (d.tes_codigo NOT IN (8) OR NVL('" + p_considera_transito + "', 'N') = 'S') ");
				sb.append("    AND d.tco_codigo            = NVL(" + p_tco_codigo + ", d.tco_codigo) ");
				sb.append("    AND (" + ((p_ies_codigo + "").equals("null") ? null : 1)	+ " is null or d.ies_codigo in (" + p_ies_codigo + ")) ");
				sb.append("    AND d.cor_cdgo              = NVL(" + p_cor_cdgo + ", d.cor_cdgo) ");
				if (p_tipo_produtos != null) {
					sb.append("    AND nvl(r.ref_grupo_posicao_fab,null) in (" + p_tipo_produtos + ") ");
				}
				sb.append("    AND d.emp_empresa           = dd.emp_empresa ");
				sb.append("    AND d.fil_filial            = dd.fil_filial ");
				sb.append("    AND d.unn_codigo            = dd.unn_codigo ");
				sb.append("    AND d.cor_cdgo              = dd.cor_cdgo ");
				sb.append("    AND d.les_codigo            = dd.les_codigo ");
				sb.append("    AND d.tes_codigo            = dd.tes_codigo ");
				sb.append("    AND d.tco_codigo            = dd.tco_codigo ");
				sb.append("    AND d.gde_cdgo              = dd.gde_cdgo ");
				sb.append("    AND dd.ies_codigo           = i.codigo ");
				sb.append("    AND (" + p_qtde_inicial + " IS NULL OR NVL(dd.soma, NULL) >= " + p_qtde_inicial + ") ");
				sb.append("    AND (" + p_qtde_final + " IS NULL OR NVL(dd.soma, NULL) <= " + p_qtde_final + ") ");
				sb.append("    AND (('" + p_grades + "' = 'null') OR (d.gde_cdgo in (" + p_grades + "))) ");
				if (ignorarGrade99.equals("S")) {
					sb.append(" AND d.gde_cdgo <> 99 ");
				}				
				sb.append("    AND NVL(TRUNC(i.dthr_alteracao), TRUNC(SYSDATE)) >= TO_DATE('" + p_data_inicial + "', 'dd/mm/yyyy') ");
				sb.append("    AND NVL(TRUNC(i.dthr_alteracao), TRUNC(SYSDATE)) <= TO_DATE('" + p_data_final + "', 'dd/mm/yyyy') ");
				if (p_est_inicial != null) {
					sb.append("    AND NVL(TRUNC(d.data_log_afv), TRUNC(SYSDATE)) >= TO_DATE('" + p_est_inicial	+ "', 'dd/mm/yyyy') ");
				}
				if (p_est_final != null) {
					sb.append("	   AND NVL(TRUNC(d.data_log_afv), TRUNC(SYSDATE)) <= TO_DATE('" + p_est_final + "', 'dd/mm/yyyy') ");
				}
				sb.append("    AND d.qtde_atual            > 0 ");
				if (p_ordenacao.equals("qtd_les_lin_ref") || p_ordenacao.equals("data_les_lin_ref")
						|| informouDataLogAfv) {
					sb.append(" GROUP BY d.emp_empresa ");
					sb.append("	       , d.fil_filial ");
					sb.append("	       , d.unn_codigo ");
					sb.append("	       , d.les_codigo ");
					sb.append("	       , d.tes_codigo ");
					sb.append("	       , d.tco_codigo ");
					sb.append("	       , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ");
					sb.append("	       , pck_cabedal.get_nome(i.cab_cdgo) ");
					sb.append("	       , fnc_retorna_filial_lin_ref(i.lin_cdgo, i.ref_cdgo) ");
					sb.append("	       , d.emp_empresa || d.fil_filial || d.unn_codigo || d.les_codigo || d.tes_codigo || d.tco_codigo || fct_mask_modelo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ");
					sb.append("	       , d.ies_codigo ");
					sb.append("	       , i.lin_cdgo ");
					sb.append("	       , i.ref_cdgo ");
					if (p_ordenacao.equals("qtd_les_lin_ref")) {
						sb.append("	   , d.cor_cdgo ");
					}
					sb.append("        , i.cab_cdgo ");
				}
				
				sb.append(" ) qry ");
			    sb.append("  , tabela_preco  tp ");
			    sb.append("  , idiomas_cores ic ");
			    sb.append("  , cor           co ");	
			    sb.append("  , livro l ");
				sb.append(" WHERE l.liv_codigo = ").append(p_livro);
				sb.append("   AND tp.codigo_livro (+) = l.liv_codigo ");
				sb.append("   AND co.cor_cdgo = qry.cor_cdgo ");
				sb.append("	  AND ic.codigo_cor(+) = co.cor_cdgo ");
				sb.append("	  AND ic.codigo_idioma(+) = 1 ");
				sb.append("	  AND tp.codigo_pais (+) = 1 ");
				sb.append("	  AND (l.tipo_mercado = 'MI' OR (tp.versao_tabela = (SELECT MAX(t.versao_tabela) ");
				sb.append("	                                                       FROM tabela_preco t ");
				sb.append("	                      							      WHERE t.codigo_livro = tp.codigo_livro ");
				sb.append("	                       							        AND t.codigo_pais = tp.codigo_pais ");
				sb.append("	                        						        AND t.status = 'A'))) ");				
				sb.append("   AND (" + p_valor_inicial + " IS NULL OR NVL(preco_produto, NULL) >= " + p_valor_inicial + ") ");
				sb.append("   AND (" + p_valor_final + " IS NULL OR NVL(preco_produto, NULL) <= " + p_valor_final + ") ");
				sb.append(" ORDER BY lin_cdgo, ref_cdgo, cab_cdgo, qry.cor_cdgo ");

			
				if (mostra_query) {
					throw new Exception(sb.toString());
				}
				pstm = j.getConn().prepareStatement(sb.toString());
				rset = pstm.executeQuery();
				int quantidadeItens = 0;
				int totalItens = Integer.parseInt(p_qtde_itens);
				while (rset.next() && (quantidadeItens < totalItens)) {
					
					// ---------------------------------------------------------------------------------
					if (rowcount > 32000) {
						rowcount = 0;
						testsheet = wb.createSheet(descricaoPlanilha + "_" + ++contadorPlanilha);
						sheet = wb.getSheet(descricaoPlanilha + "_" + contadorPlanilha);
						patriarch = sheet.createDrawingPatriarch();
						sheet.autoSizeColumn(0);
						sheet.autoSizeColumn(1);
						sheet.autoSizeColumn(2);
						sheet.autoSizeColumn(3);
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue("Article");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(1);
						tcell.setCellValue("Category");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(2);
						tcell.setCellValue("Upper");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(3);
						tcell.setCellValue("Colour");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(4);
						tcell.setCellValue("Grid");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(5);
						tcell.setCellValue("Quantity");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(6);
						tcell.setCellValue("Photo");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(7);
						tcell.setCellValue("Price");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(8);
						tcell.setCellValue("Composition");
						tcell.setCellStyle(style);
					}
					// ---------------------------------------------------------------------------------
					
					quantidadeItens++;
					gerou = true;
					if(true) {
					//if ((!rset.getString(13).equals(modeloantigo)) || contador == 0) {
						++rowcount;
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue(rset.getString("article"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(1);
						tcell.setCellValue(rset.getString("category"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(2);
						tcell.setCellValue(rset.getString("cabedal"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(3);
						tcell.setCellValue(rset.getString("colour"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(4);
						tcell.setCellValue(rset.getString("grade"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(5);
						tcell.setCellValue(rset.getString("quantity"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(6);
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(7);
						tcell.setCellValue(rset.getString("moeda") + " " + rset.getString("price"));
						tcell.setCellStyle(stylecenter);
						tcell = trow.createCell(8);
						tcell.setCellValue(rset.getString("composition"));
						tcell.setCellStyle(stylecenter);

					}
					// --------------------------------------------------------------------------------------
					if(true){
					try {
						String arquivoImagem = diretorioImagens + rset.getString("photo");
						java.io.File f = new java.io.File(arquivoImagem);
						if (!f.isFile()) {
							arquivoImagem = diretorioImagens + "sem_imagem.jpg";
						}
						FileInputStream fis = new FileInputStream(arquivoImagem);
						ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
						int b;
						while ((b = fis.read()) != -1) {
							img_bytes.write(b);
						}
						fis.close();
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (6), (rowcount), (short) (7), rowcount + 1);
						int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
						patriarch.createPicture(anchor, index);
						anchor.setAnchorType(ClientAnchor.MOVE_AND_RESIZE);
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
					}
				}
			}
			autoSizeColumns(wb);
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

	public void autoSizeColumns(Workbook workbook) {
	    int numberOfSheets = workbook.getNumberOfSheets();
	    for (int i = 0; i < numberOfSheets; i++) {
	        Sheet sheet = workbook.getSheetAt(i);
	        if (sheet.getPhysicalNumberOfRows() > 0) {
	            Row row = sheet.getRow(sheet.getFirstRowNum());
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                int columnIndex = cell.getColumnIndex();
	                sheet.autoSizeColumn(columnIndex);
	            }
	        }
	    }
	}

}