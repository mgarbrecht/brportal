package util.consultas.com.exportacao;

import org.apache.poi.hssf.usermodel.*;
import java.io.*;

public class Exp0505 {

	public String geraExcel(String p_emp_empresa, String p_ano,
			String p_nr_fatura) throws Exception {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("faturas");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleleft;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		String moeda = null;
		String pares_total = null;
		String valor_total = null;
		int rowcount = 0;
		int rowcount_imagem = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		//String diretorioImagens = parametros.retornaParametro("diretorio_imagens_report");
		String diretorioImagens = "/home/loja_brportal/imagens/pequenas/";
		try {
			util.consultas.Query query = new util.consultas.Query();
			nomeArquivo.append("exp0505").append(util.rand.Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("faturas");
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleleft = wb.createCellStyle();
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
			styleleft.setAlignment((short) 0);
			styleright.setAlignment((short) 3);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+ nomeArquivo.toString());
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sbm = new StringBuilder();
			sbm.append(" SELECT codigo_moeda ");
			sbm.append("   FROM faturas_amostras f ");
			sbm.append("  WHERE f.empresa_fatura_amostra = '").append(p_emp_empresa).append("' ");
			sbm.append("    AND f.ano_fatura_amostra = ").append(p_ano);
			sbm.append("    AND f.numero_fatura_amostra = ").append(p_nr_fatura);
			moeda = query.retorna(j, sbm.toString());
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("   Foto   ");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(1);
			tcell.setCellValue("NCM");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(2);
			tcell.setCellValue("Modelo");
			tcell.setCellStyle(style);
			tcell = trow.createCell(3);
			tcell.setCellValue("Descrição");
			tcell.setCellStyle(style);
			tcell = trow.createCell(4);
			tcell.setCellValue("Pares");
			tcell.setCellStyle(style);
			tcell = trow.createCell(5);
			tcell.setCellValue("Preço Unit. " + moeda);
			tcell.setCellStyle(style);
			tcell = trow.createCell(6);
			tcell.setCellValue("Total");
			tcell.setCellStyle(style);

			sb.append(" SELECT i.descricao_item ncm ");
			sb.append("      , fct_mask_modelo (i.codigo_linha , i.codigo_referencia) modelo ");
			sb.append("      , fct_descricao_produto_exp(f.codigo_cliente,f.estabelecimento_cliente,i.codigo_linha , i.codigo_referencia,i.codigo_cabedal,i.codigo_cor,f.codigo_pais_tabela) descricao_item ");
			sb.append("      , i.quantidade_pares / 2 quantidade_pares  ");
			sb.append("      , i.preco_unitario * 2 preco_unitario ");
			sb.append("      , nvl(i.valor_total_item, i.quantidade_pares * i.preco_unitario) valor_total ");
			sb.append("      , sum(i.quantidade_pares) over() / 2 quantidade_pares_total ");
			sb.append("      , sum(i.valor_total_item) over() valor_total ");
			sb.append("      , f.codigo_moeda ");
			sb.append("      , fct_retorna_fit_imagem(i.codigo_linha, i.codigo_referencia) imagem ");
			sb.append("  FROM faturas_amostras f ");
			sb.append("     , idiomas m ");
			sb.append("     , esc e ");
			sb.append("     , cli c ");
			sb.append("     , ecl n ");
			sb.append("     , estados u ");
			sb.append("     , paises p ");
			sb.append("     , itens_faturas_amostras i ");
			sb.append("     , dom_item_estoque d ");
			sb.append("     , ipi  ");
			sb.append("     , ficha_tec ft ");
			sb.append(" WHERE f.numero_fatura_amostra = ").append(p_nr_fatura);
			sb.append("   AND f.ano_fatura_amostra = ").append(p_ano);
			sb.append("   AND f.empresa_fatura_amostra = '").append(p_emp_empresa).append("' ");
			sb.append("   AND ft.lin_cdgo = i.codigo_linha ");
			sb.append("   AND ft.ref_cdgo = i.codigo_referencia ");
			sb.append("   AND ft.cab_cdgo = i.codigo_cabedal ");
			sb.append("   AND e.cli_cdgo = f.codigo_cliente ");
			sb.append("   AND e.esc_seqn = f.estabelecimento_cliente ");
			sb.append("   AND c.cli_cdgo = e.cli_cdgo ");
			sb.append("   AND n.cli_cdgo = f.codigo_cliente ");
			sb.append("   AND n.esc_seqn = f.estabelecimento_cliente ");
			sb.append("   AND n.ned_cdgo = 'UNI' ");
			sb.append("   AND e.est_unifed = u.est_unifed ");
			sb.append("   AND u.pais_codigo = p.codigo ");
			sb.append("   AND i.numero_fatura_amostra = f.numero_fatura_amostra ");
			sb.append("   AND d.lin_cdgo = i.codigo_linha ");
			sb.append("   AND d.ref_cdgo = i.codigo_referencia ");
			sb.append("   AND d.cab_cdgo = i.codigo_cabedal ");
			sb.append("   AND ipi.ipi_codred = d.ipi_codred ");
			sb.append("   AND nvl(i.item_cancelado, 'N') = 'N' ");
			sb.append("   AND i.ano_fatura_amostra = f.ano_fatura_amostra ");
			sb.append("   AND i.empresa_fatura_amostra = f.empresa_fatura_amostra ");
			sb.append("   AND m.codigo_idioma(+) = f.codigo_pais_tabela ");
			sb.append(" ORDER BY i.codigo_linha ");
			sb.append("        , i.codigo_referencia ");
			sb.append("        , i.codigo_cabedal ");
			sb.append("        , i.codigo_cor ");

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				pares_total = com.egen.util.text.FormatNumber.format(Double.parseDouble(rset.getString(7)), "##,##0.00").replace(",", ".");
				valor_total = com.egen.util.text.FormatNumber.format(Double.parseDouble(rset.getString(8)), "##,##0.00").replace(",", ".");
				gerou = true;
				++rowcount;
				rowcount_imagem = rowcount;
				trow = testsheet.createRow(rowcount);

				tcell = trow.createCell(1);
				tcell.setCellValue(rset.getString(1));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(2);
				tcell.setCellValue(rset.getString(2));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(3);
				tcell.setCellValue(rset.getString(3));
				tcell.setCellStyle(styleleft);

				tcell = trow.createCell(4);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(rset.getString(4)), "##,##0.00").replace(",", "."));
				tcell.setCellStyle(styleright);

				tcell = trow.createCell(5);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(rset.getString(5)), "##,##0.00").replace(",", "."));
				tcell.setCellStyle(styleright);

				tcell = trow.createCell(6);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(rset.getString(6)), "##,##0.00").replace(",", "."));
				tcell.setCellStyle(styleright);
				// --------------------------------------------------------------------------------------
				
				String arquivo = diretorioImagens + rset.getString("imagem");
				java.io.File f = new java.io.File(arquivo);
				if (!f.isFile()) {
					arquivo = diretorioImagens + "sem_imagem.jpg";
				}
				FileInputStream fis = new FileInputStream(arquivo);
				ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
				int b;
				while ((b = fis.read()) != -1)
					img_bytes.write(b);
				fis.close();
				HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) (0), (rowcount_imagem), (short) (1), rowcount_imagem + 1);
				int index = wb.addPicture(img_bytes.toByteArray(),	HSSFWorkbook.PICTURE_TYPE_JPEG);
				patriarch.createPicture(anchor, index);
				anchor.setAnchorType(0);
			}
			trow = testsheet.createRow(++rowcount);

			tcell = trow.createCell(0);
			tcell.setCellValue("Total");
			tcell.setCellStyle(styleleft);

			tcell = trow.createCell(4);
			tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(pares_total), "##,##0.00").replace(",","."));
			tcell.setCellStyle(styleright);
			tcell = trow.createCell(6);
			tcell.setCellValue(com.egen.util.text.FormatNumber.format(Double.parseDouble(valor_total), "##,##0.00").replace(",","."));
			tcell.setCellStyle(styleright);

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
			retorno = parametros.retornaParametro("diretorio_link_pdf")+ nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}
}