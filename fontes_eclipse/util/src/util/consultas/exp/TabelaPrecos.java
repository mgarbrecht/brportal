package util.consultas.exp;

import acesso.Sessao;
import com.egen.util.jdbc.JdbcUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import util.rand.Palavra;

public class TabelaPrecos {
	public String geraExcel(String p_codigo_livro,String p_versao, String p_dt_inicial,
			String p_dt_final, String p_marca, String p_tipo_linha,
			String cliente, String pais, String p_mix_produtos,
			List<Object[][]> listaProdutos, HttpServletRequest req) {
		boolean passouParametros = false;
		
		Sessao sessao = new Sessao(req.getSession());
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("Tabela de Preços");
		JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbMarcas = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		portalbr.dbobj.view.Jw_tabela_preco_exp r;
		try {
			j = new JdbcUtil();
			util.consultas.Query query = new util.consultas.Query();
			portalbr.dbobj.view.Jw_tabela_preco_exp table = new portalbr.dbobj.view.Jw_tabela_preco_exp();
			if (listaProdutos != null) {
				passouParametros = true;
				for (Object[][] l : listaProdutos) {
					sb = new StringBuilder();
					sb.append(" INSERT INTO tmp_generic_table_brportal ");
					sb.append("      (number_column1, number_column2, varchar_column1) ");
					sb.append(" VALUES (").append(l[0][0]).append(",").append(l[0][1]).append(",").append("'tabelaprecos").append(sessao.getUsuario()).append("')");
					query.execute(j, sb.toString());
				}
			}		
			sb = new StringBuilder();
			sb.append(" SELECT REPLACE(fct_retorna_fit_imagem(tp.codigo_linha_tp, tp.codigo_referencia_tp), '.gif', '.jpg') imagem ");
			sb.append("      , descricao_marca marca ");
			sb.append("      , fct_mask_modelo(tp.codigo_linha_tp, tp.codigo_referencia_tp) modelo ");
			sb.append("      , '' cabedal ");
			sb.append("      , '' cor ");
			sb.append("      , versao_tabela_tp ");
			sb.append("      , nro_ini_brasil ");
			sb.append("      , (SELECT nuco_num_cont FROM numeracao_continentes e WHERE nuco_con_codigo = 'EURO' AND nuco_num_brasil = nro_ini_brasil  )nro_ini_europa ");
			sb.append("      , nro_fin_brasil ");
			sb.append("      , (SELECT nuco_num_cont FROM numeracao_continentes e WHERE nuco_con_codigo = 'EURO' AND nuco_num_brasil = nro_fin_brasil  )nro_fin_europa ");
			sb.append("      , (brio.fct_busca_preco_mercado_ext(versao_tabela, tp.codigo_linha_tp, tp.codigo_referencia_tp, ").append(p_codigo_livro).append(")) preco ");
			sb.append("      , moeda ");
			sb.append("   FROM (SELECT DISTINCT te.versao_tabela ");
			sb.append("                       , rc.lin_cdgo codigo_linha_tp ");
			sb.append("                       , rc.ref_cdgo codigo_referencia_tp ");
			sb.append("                       , te.versao_tabela versao_tabela_tp ");
			sb.append("                       , MIN(q.qtd_nume) nro_ini_brasil ");
			sb.append("                       , MAX(q.qtd_nume) nro_fin_brasil ");
			sb.append("                       , CAST(nvl(tp.moe_codigo,'US$') AS VARCHAR2(10)) moeda ");
			sb.append("                       , mp.descricao_marca ");
			sb.append("           FROM tabela_preco_mercado_externo te ");
			sb.append("              , tabela_preco                 tp ");
			sb.append("              , ref_gde fg ");
			sb.append("              , ref_cor rc ");
			sb.append("              , ref r ");
			sb.append("              , lin l ");
			sb.append("              , qtd q ");
			sb.append("              , marcas_produtos mp ");
			sb.append("          WHERE tp.codigo_livro = te.codigo_livro ");
			sb.append("            AND tp.codigo_pais = te.codigo_pais ");
			sb.append("            AND tp.versao_tabela = te.versao_tabela ");
	        sb.append("            AND q.gde_cdgo = fg.gde_cdgo ");
			sb.append("            AND fg.lin_cdgo = te.codigo_linha ");
			sb.append("            AND fg.ref_cdgo = te.codigo_referencia ");
			sb.append("            AND rc.lin_cdgo = te.codigo_linha ");
			sb.append("            AND rc.ref_cdgo = te.codigo_referencia ");
			sb.append("            AND r.lin_cdgo = rc.lin_cdgo ");
			sb.append("            AND r.ref_cdgo = rc.ref_cdgo ");
			sb.append("            AND r.lin_cdgo = l.lin_cdgo ");
			sb.append("            AND NVL(te.codigo_cabedal, 999) = DECODE(NVL(te.codigo_cabedal, 999), 999, 999, rc.cab_cdgo) ");
			if (passouParametros) {
				sb.append("         AND te.codigo_livro = ").append(p_codigo_livro);
				sb.append("         AND te.codigo_pais = 1 ");
				sb.append("         AND te.versao_tabela = to_date('").append(p_versao).append("','dd/mm/yyyy hh24:mi:ss') ");
				sb.append("         AND EXISTS (SELECT 1 ");
				sb.append("                       FROM tmp_generic_table_brportal tmp ");
				sb.append("                      WHERE tmp.number_column1 = te.codigo_linha ");
				sb.append("                        AND tmp.number_column2 = te.codigo_referencia) ");
			} else {
				sb.append("         AND te.codigo_livro = ").append(p_codigo_livro);
				sb.append("         AND te.codigo_pais = 1 ");
				sb.append("         AND te.versao_tabela = to_date('").append(p_versao).append("','dd/mm/yyyy hh24:mi:ss') ");
			}
			sb.append("            AND fct_marca_produto(fg.lin_cdgo, fg.ref_cdgo) = mp.codigo_marca ");
			if (p_dt_inicial != null) {
				sb.append("        AND r.data_embarque >= to_date('").append(p_dt_inicial).append("','dd/mm/yyyy') ");
			}
			if (p_dt_final != null) {
				sb.append("        AND r.data_embarque <= to_date('").append(p_dt_final).append("','dd/mm/yyyy') ");
			}
			if (p_marca != null) {
				sb.append("        AND nvl(mp.codigo_marca,null) = ").append(p_marca);
			}
			if (p_tipo_linha != null) {
				sb.append("        AND l.ind_aberto_fechado = '").append(p_tipo_linha).append("'");
			}
			sb.append("            AND (NVL('").append(p_mix_produtos).append("', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '").append(p_mix_produtos).append("') ");
			sb.append("            AND rc.rfc_status = 'A' ");
			sb.append("            AND te.status = 'A' ");
			sb.append("          GROUP BY te.versao_tabela ");
			sb.append("                 , rc.lin_cdgo ");
			sb.append("                 , rc.ref_cdgo ");
			sb.append("                 , mp.descricao_marca ");
			sb.append("                 , tp.moe_codigo) tp ");
			sb.append("  GROUP BY tp.versao_tabela_tp ");
			sb.append("         , tp.codigo_linha_tp ");
			sb.append("         , tp.codigo_referencia_tp ");
			sb.append("         , nro_ini_brasil ");
			sb.append("         , nro_fin_brasil ");
			sb.append("         , moeda ");
			sb.append("         , descricao_marca" );
			sb.append("  ORDER BY marca ");
			sb.append("         , modelo ");
			Vector<?> res_Jw_tabela_preco_exp = j.select(table, sb.toString(), null);
			if (res_Jw_tabela_preco_exp != null && res_Jw_tabela_preco_exp.size() > 0) {
				List<String> listaMarcas = new ArrayList<String>();
				for (int x = 0; x < res_Jw_tabela_preco_exp.size(); x++) {
					r = (portalbr.dbobj.view.Jw_tabela_preco_exp) res_Jw_tabela_preco_exp.elementAt(x);
					if (!listaMarcas.contains(r.getMarca())) {
						listaMarcas.add(r.getMarca());
					}
				}
				for (String marca : listaMarcas) {
					if (sbMarcas.length() > 0) {
						sbMarcas.append(",").append(" ").append(marca);
					} else {
						sbMarcas.append(marca);
					}
				}
			}
			nomeArquivo.append("tabelaprecos").append(Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("Tabela de Preços");
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCellStyle stylecenter = wb.createCellStyle();
			HSSFCellStyle styleright = wb.createCellStyle();
			HSSFCellStyle stylecenterborda = wb.createCellStyle();
			HSSFCellStyle styleGrade = wb.createCellStyle();
			HSSFCellStyle styleCabecalho = wb.createCellStyle();
			HSSFCellStyle styleLinha = wb.createCellStyle();
			HSSFCellStyle styleFilial = wb.createCellStyle();
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
			styleCabecalho.setAlignment((short) 2);
			Font font = wb.createFont();
			font.setFontHeightInPoints((short) 12);
			font.setFontName("Arial");
			font.setBoldweight((short) 2);
			styleCabecalho.setFont(font);
			styleCabecalho.setFillForegroundColor((short) 47);
			styleCabecalho.setFillPattern((short) 1);
			Font fontLinha = wb.createFont();
			fontLinha.setFontHeightInPoints((short) 12);
			fontLinha.setFontName("Arial");
			fontLinha.setItalic(true);
			fontLinha.setBoldweight((short) 2);
			styleLinha.setFont(fontLinha);
			styleLinha.setFillForegroundColor((short) 22);
			styleLinha.setFillPattern((short) 1);
			Font fontFilial = wb.createFont();
			fontFilial.setFontHeightInPoints((short) 12);
			fontFilial.setFontName("Arial");
			fontFilial.setBoldweight((short) 24);
			styleFilial.setFont(fontFilial);
			styleFilial.setAlignment((short) 2);
			styleright.setAlignment((short) 4);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+ nomeArquivo.toString());
			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 10);
			region = new CellRangeAddress(0, 0, 0, 10);
			sheet.addMergedRegion(region);
			region = new CellRangeAddress(1, 1, 0, 10);
			sheet.addMergedRegion(region);
			region = new CellRangeAddress(2, 2, 0, 10);
			sheet.addMergedRegion(region);
			region = new CellRangeAddress(3, 3, 0, 10);
			sheet.addMergedRegion(region);
			HSSFRow trow = testsheet.createRow(rowcount);
			HSSFCell tcell = trow.createCell(0);
			tcell.setCellValue("CUSTOMER: " + cliente.toUpperCase());
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("COUNTRY: " + pais.toUpperCase());
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("BRANDS: " + sbMarcas.toString());
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("ALL PRICES ARE FOB - PORT RIO GRANDE/RS/BRAZIL");
			rowcount++;
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			region = new CellRangeAddress(rowcount, rowcount, 0, 2);
			sheet.addMergedRegion(region);
			tcell.setCellValue("Photo");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(3);
			tcell.setCellValue("Brand");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(4);
			tcell.setCellValue("Factory Style");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(5);
			tcell.setCellValue("Currency");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(6);
			tcell.setCellValue("Price");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(7);
			tcell.setCellValue("Size Range");
			tcell.setCellStyle(styleCabecalho);
			rowcount++;
			sb = new StringBuilder();
			sb.append(" DELETE tmp_generic_table_brportal ");
			sb.append("  WHERE varchar_column1 = 'tabelaprecos").append(sessao.getUsuario()).append("'");
			query.execute(j, sb.toString());
			for (int x = 0; x < res_Jw_tabela_preco_exp.size(); x++) {
				r = (portalbr.dbobj.view.Jw_tabela_preco_exp) res_Jw_tabela_preco_exp.elementAt(x);
				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(0);
				tcell = trow.createCell(3);
				tcell.setCellValue(r.getMarca());
				tcell = trow.createCell(4);
				tcell.setCellValue(r.getModelo());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(5);
				tcell.setCellValue(r.getMoeda());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(6);
				tcell.setCellValue(r.getPreco());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(7);
				tcell.setCellValue("BR " + r.getNro_ini_brasil() + "-" + r.getNro_fin_brasil());
				tcell.setCellStyle(stylecenter);
				trow = testsheet.createRow(rowcount + 1);
				tcell = trow.createCell(7);
				tcell.setCellValue("EU " + r.getNro_ini_europa() + "-" + r.getNro_fin_europa());
				tcell.setCellStyle(stylecenter);
				gerou = true;
				String diretorio = "/opt/tomcat/webapps/brportal/imagens/grandes/";
				String arquivo = diretorio + r.getImagem();
				File f = new File(arquivo);
				if (!f.isFile()) {
					arquivo = "/opt/tomcat/webapps/brportal/imagens/pequenas/default_prod.jpg";
				}
				FileInputStream fis = new FileInputStream(arquivo);
				ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
				int b;
				while ((b = fis.read()) != -1) {
					img_bytes.write(b);
				}
				fis.close();
				HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 0, rowcount, (short) 3, rowcount + 7);
				int index = wb.addPicture(img_bytes.toByteArray(), 5);
				patriarch.createPicture(anchor, index);
				anchor.setAnchorType(1);
				rowcount += 7;
			}
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
		if (gerou)
			try {
				retorno = parametros.retornaParametro("diretorio_link_pdf")+ nomeArquivo.toString();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else {
			retorno = "";
		}
		return retorno;
	}
	
	
	public String geraExcelCabedal(String p_codigo_livro,String p_versao, String p_dt_inicial,
			String p_dt_final, String p_marca, String p_tipo_linha,
			String cliente, String pais, String p_mix_produtos,
			List<Object[][]> listaProdutos, HttpServletRequest req) {
		boolean passouParametros = false;
		boolean imprimeImagem = false;
		int quantidadeCabedaisModelo = 0;
		String modeloAnterior = null;
		Sessao sessao = new Sessao(req.getSession());
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("Tabela de Preços");
		JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbMarcas = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		portalbr.dbobj.view.Jw_tabela_preco_exp r;
		try {
			j = new JdbcUtil();
			util.consultas.Query query = new util.consultas.Query();
			if (listaProdutos != null) {
				passouParametros = true;
				for (Object[][] l : listaProdutos) {
					sb = new StringBuilder();
					sb.append(" INSERT INTO tmp_generic_table_brportal ");
					sb.append("      (number_column1, number_column2, varchar_column1) ");
					sb.append(" VALUES (").append(l[0][0]).append(",").append(l[0][1]).append(",").append("'tabelaprecos").append(sessao.getUsuario()).append("')");
					query.execute(j, sb.toString());
				}
			}
			sb = new StringBuilder();
			sb.append(" SELECT REPLACE(fct_retorna_fit_imagem(tp.codigo_linha_tp, tp.codigo_referencia_tp), '.gif', '.jpg') imagem ");
			sb.append("      , descricao_marca marca ");
			sb.append("      , fct_mask_modelo(tp.codigo_linha_tp, tp.codigo_referencia_tp) modelo ");
			sb.append("      , '' cabedal ");
			sb.append("      , '' cor ");
			sb.append("      , versao_tabela_tp ");
			sb.append("      , nro_ini_brasil ");
			sb.append("      , (SELECT nuco_num_cont FROM numeracao_continentes e WHERE nuco_con_codigo = 'EURO' AND nuco_num_brasil = nro_ini_brasil  )nro_ini_europa ");
			sb.append("      , nro_fin_brasil ");
			sb.append("      , (SELECT nuco_num_cont FROM numeracao_continentes e WHERE nuco_con_codigo = 'EURO' AND nuco_num_brasil = nro_fin_brasil  )nro_fin_europa ");
			sb.append("      , (brio.fct_busca_preco_mercado_ext(versao_tabela, tp.codigo_linha_tp, tp.codigo_referencia_tp, ").append(p_codigo_livro).append(", tp.cab_cdgo)) preco ");
			sb.append("      , moeda ");
			sb.append("      , cab_cdgo ");
			sb.append("   FROM (SELECT DISTINCT te.versao_tabela ");
			sb.append("                       , rc.lin_cdgo codigo_linha_tp ");
			sb.append("                       , rc.ref_cdgo codigo_referencia_tp ");
			sb.append("                       , te.versao_tabela versao_tabela_tp ");
			sb.append("                       , MIN(q.qtd_nume) nro_ini_brasil ");
			sb.append("                       , MAX(q.qtd_nume) nro_fin_brasil ");
			sb.append("                       , CAST(nvl(tp.moe_codigo,'US$') AS VARCHAR2(10)) moeda ");
			sb.append("                       , mp.descricao_marca ");
			sb.append("                       , rc.cab_cdgo ");
			sb.append("           FROM tabela_preco_mercado_externo te ");
			sb.append("              , tabela_preco                 tp ");
			sb.append("              , ref_gde fg ");
			sb.append("              , ref_cor rc ");
			sb.append("              , ref r ");
			sb.append("              , lin l ");
			sb.append("              , qtd q ");
			sb.append("              , marcas_produtos mp ");
			sb.append("          WHERE tp.codigo_livro = te.codigo_livro ");
			sb.append("            AND tp.codigo_pais = te.codigo_pais ");
			sb.append("            AND tp.versao_tabela = te.versao_tabela ");
	        sb.append("            AND q.gde_cdgo = fg.gde_cdgo ");
			sb.append("            AND fg.lin_cdgo = te.codigo_linha ");
			sb.append("            AND fg.ref_cdgo = te.codigo_referencia ");
			sb.append("            AND rc.lin_cdgo = te.codigo_linha ");
			sb.append("            AND rc.ref_cdgo = te.codigo_referencia ");
			sb.append("            AND r.lin_cdgo = rc.lin_cdgo ");
			sb.append("            AND r.ref_cdgo = rc.ref_cdgo ");
			sb.append("            AND r.lin_cdgo = l.lin_cdgo ");
			sb.append("            AND NVL(te.codigo_cabedal, 999) = DECODE(NVL(te.codigo_cabedal, 999), 999, 999, rc.cab_cdgo) ");
			if (passouParametros) {
				sb.append("         AND te.codigo_livro = ").append(p_codigo_livro);
				sb.append("         AND te.codigo_pais = 1 ");
				sb.append("         AND te.versao_tabela = to_date('").append(p_versao).append("','dd/mm/yyyy hh24:mi:ss') ");
				sb.append("         AND EXISTS (SELECT 1 ");
				sb.append("                       FROM tmp_generic_table_brportal tmp ");
				sb.append("                      WHERE tmp.number_column1 = te.codigo_linha ");
				sb.append("                        AND tmp.number_column2 = te.codigo_referencia) ");
			} else {
				sb.append("         AND te.codigo_livro = ").append(p_codigo_livro);
				sb.append("         AND te.codigo_pais = 1 ");
				sb.append("         AND te.versao_tabela = to_date('").append(p_versao).append("','dd/mm/yyyy hh24:mi:ss') ");
			}
			sb.append("            AND fct_marca_produto(fg.lin_cdgo, fg.ref_cdgo) = mp.codigo_marca ");
			if (p_dt_inicial != null) {
				sb.append("        AND r.data_embarque >= to_date('").append(p_dt_inicial).append("','dd/mm/yyyy') ");
			}
			if (p_dt_final != null) {
				sb.append("        AND r.data_embarque <= to_date('").append(p_dt_final).append("','dd/mm/yyyy') ");
			}
			if (p_marca != null) {
				sb.append("        AND nvl(mp.codigo_marca,null) = ").append(p_marca);
			}
			if (p_tipo_linha != null) {
				sb.append("        AND l.ind_aberto_fechado = '").append(p_tipo_linha).append("'");
			}
			sb.append("            AND (NVL('").append(p_mix_produtos).append("', 'T') = 'T' OR fct_mix_produto(r.lin_cdgo, r.ref_cdgo) = '").append(p_mix_produtos).append("') ");
			sb.append("            AND rc.rfc_status = 'A' ");
			sb.append("            AND te.status = 'A' ");
			sb.append("          GROUP BY te.versao_tabela ");
			sb.append("                 , rc.lin_cdgo ");
			sb.append("                 , rc.ref_cdgo ");
			sb.append("                 , rc.cab_cdgo ");			
			sb.append("                 , mp.descricao_marca ");
			sb.append("                 , tp.moe_codigo) tp ");
			sb.append("  GROUP BY tp.versao_tabela_tp ");
			sb.append("         , tp.codigo_linha_tp ");
			sb.append("         , tp.codigo_referencia_tp ");
			sb.append("         , tp.cab_cdgo ");			
			sb.append("         , nro_ini_brasil ");
			sb.append("         , nro_fin_brasil ");
			sb.append("         , moeda ");
			sb.append("         , descricao_marca" );
			sb.append("  ORDER BY marca ");
			sb.append("         , modelo ");
			sb.append("         , cab_cdgo ");
			
		
			portalbr.dbobj.view.Jw_tabela_preco_exp table = new portalbr.dbobj.view.Jw_tabela_preco_exp();

			Vector<?> res_Jw_tabela_preco_exp = j.select(table, sb.toString(), null);
			if (res_Jw_tabela_preco_exp != null && res_Jw_tabela_preco_exp.size() > 0) {
				List<String> listaMarcas = new ArrayList<String>();
				for (int x = 0; x < res_Jw_tabela_preco_exp.size(); x++) {
					r = (portalbr.dbobj.view.Jw_tabela_preco_exp) res_Jw_tabela_preco_exp.elementAt(x);
					if (!listaMarcas.contains(r.getMarca())) {
						listaMarcas.add(r.getMarca());
					}
				}
				for (String marca : listaMarcas) {
					if (sbMarcas.length() > 0) {
						sbMarcas.append(",").append(" ").append(marca);
					} else {
						sbMarcas.append(marca);
					}
				}
			}
			nomeArquivo.append("tabelaprecos").append(Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("Tabela de Preços");
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCellStyle stylecenter = wb.createCellStyle();
			HSSFCellStyle styleright = wb.createCellStyle();
			HSSFCellStyle stylecenterborda = wb.createCellStyle();
			HSSFCellStyle styleGrade = wb.createCellStyle();
			HSSFCellStyle styleCabecalho = wb.createCellStyle();
			HSSFCellStyle styleLinha = wb.createCellStyle();
			HSSFCellStyle styleFilial = wb.createCellStyle();
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
			styleCabecalho.setAlignment((short) 2);
			Font font = wb.createFont();
			font.setFontHeightInPoints((short) 12);
			font.setFontName("Arial");
			font.setBoldweight((short) 2);
			styleCabecalho.setFont(font);
			styleCabecalho.setFillForegroundColor((short) 47);
			styleCabecalho.setFillPattern((short) 1);
			Font fontLinha = wb.createFont();
			fontLinha.setFontHeightInPoints((short) 12);
			fontLinha.setFontName("Arial");
			fontLinha.setItalic(true);
			fontLinha.setBoldweight((short) 2);
			styleLinha.setFont(fontLinha);
			styleLinha.setFillForegroundColor((short) 22);
			styleLinha.setFillPattern((short) 1);
			Font fontFilial = wb.createFont();
			fontFilial.setFontHeightInPoints((short) 12);
			fontFilial.setFontName("Arial");
			fontFilial.setBoldweight((short) 24);
			styleFilial.setFont(fontFilial);
			styleFilial.setAlignment((short) 2);
			styleright.setAlignment((short) 4);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+ nomeArquivo.toString());

			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 10);
			region = new CellRangeAddress(0, 0, 0, 10);
			sheet.addMergedRegion(region);
			region = new CellRangeAddress(1, 1, 0, 10);
			sheet.addMergedRegion(region);
			region = new CellRangeAddress(2, 2, 0, 10);
			sheet.addMergedRegion(region);
			region = new CellRangeAddress(3, 3, 0, 10);
			sheet.addMergedRegion(region);

			HSSFRow trow = testsheet.createRow(rowcount);
			HSSFCell tcell = trow.createCell(0);
			tcell.setCellValue("CUSTOMER: " + cliente.toUpperCase());
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("COUNTRY: " + pais.toUpperCase());
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("BRANDS: " + sbMarcas.toString());
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("ALL PRICES ARE FOB - PORT RIO GRANDE/RS/BRAZIL");
			rowcount++;
			rowcount++;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			region = new CellRangeAddress(rowcount, rowcount, 0, 2);
			sheet.addMergedRegion(region);
			tcell.setCellValue("Photo");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(3);
			tcell.setCellValue("Brand");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(4);
			tcell.setCellValue("Factory Style");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(5);
			tcell.setCellValue("Upper");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(6);
			tcell.setCellValue("Currency");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(7);
			tcell.setCellValue("Price");
			tcell.setCellStyle(styleCabecalho);
			tcell = trow.createCell(8);
			region = new CellRangeAddress(rowcount, rowcount, 8, 9);
			sheet.addMergedRegion(region);
			tcell.setCellValue("Size Range");
			tcell.setCellStyle(styleCabecalho);
			sb = new StringBuilder();
			sb.append(" DELETE tmp_generic_table_brportal ");
			sb.append("  WHERE varchar_column1 = 'tabelaprecos").append(sessao.getUsuario()).append("'");
			query.execute(j, sb.toString());
			rowcount++;
			for (int x = 0; x < res_Jw_tabela_preco_exp.size(); x++) {
				r = (portalbr.dbobj.view.Jw_tabela_preco_exp) res_Jw_tabela_preco_exp.elementAt(x);
				if(modeloAnterior == null){
					imprimeImagem = true;
					quantidadeCabedaisModelo = 0;
					modeloAnterior = r.getModelo();
				} else {
					int diminuir = 0;
					if((r.getModelo()).equalsIgnoreCase(modeloAnterior)){
						rowcount++;
						imprimeImagem = false;
						quantidadeCabedaisModelo++;
					} else {
						diminuir = (9-quantidadeCabedaisModelo);
                        if(diminuir < 2){
                        	diminuir = 2;
                        }
                        rowcount += diminuir;
						quantidadeCabedaisModelo = 1;
						imprimeImagem = true;
						modeloAnterior = r.getModelo();
					}
				}
				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(0);
				tcell = trow.createCell(3);
				tcell.setCellValue(r.getMarca());
				tcell = trow.createCell(4);
				tcell.setCellValue(r.getModelo());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(5);
				tcell.setCellValue(r.getCab_cdgo());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(6);
				tcell.setCellValue(r.getMoeda());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(7); 
				tcell.setCellValue(r.getPreco());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(8);
				tcell.setCellValue("BR " + r.getNro_ini_brasil() + "-" + r.getNro_fin_brasil());
				tcell.setCellStyle(stylecenter);
				tcell = trow.createCell(9);
				tcell.setCellValue("EU " + r.getNro_ini_europa() + "-" + r.getNro_fin_europa());
				tcell.setCellStyle(stylecenter);
				gerou = true;
				if(imprimeImagem){
					String diretorio = "/opt/tomcat/webapps/brportal/imagens/grandes/";
					String arquivo = diretorio + r.getImagem();
					File f = new File(arquivo);
					if (!f.isFile()) {
						arquivo = "/opt/tomcat/webapps/brportal/imagens/pequenas/default_prod.jpg";
					}
					FileInputStream fis = new FileInputStream(arquivo);
					ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
					int b;
					while ((b = fis.read()) != -1) {
						img_bytes.write(b);
					}
					fis.close();
					HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 0, rowcount, (short) 3, rowcount + 7);
					int index = wb.addPicture(img_bytes.toByteArray(), 5);
					patriarch.createPicture(anchor, index);
					anchor.setAnchorType(1);
					imprimeImagem = false;
				}
			}
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
		if (gerou)
			try {
				retorno = parametros.retornaParametro("diretorio_link_pdf")+ nomeArquivo.toString();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else {
			retorno = "";
		}
		return retorno;
	}	
	
}