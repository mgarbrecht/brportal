package util.consultas.com;

import util.consultas.Query;
import org.apache.poi.hssf.usermodel.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.util.CellRangeAddress;

@SuppressWarnings("deprecation")
public class Sbr0510 {

	public String geraExcel( HttpServletRequest req
			, String p_pedido
			, String p_linha
			, String p_referencia
			, String p_cabedal
			, boolean p_abrir_numeracao
			, boolean mostraQuery) throws Exception {

		Query query = new Query();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheetPrincipal = wb.createSheet("produtos");
		HSSFRow trow;
		HSSFCell tcell;
		HSSFCellStyle style;
		HSSFCellStyle stylecenterborda;
		HSSFCellStyle stylecenter;
		HSSFCellStyle styleleft;
		HSSFCellStyle styleGrade;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		PreparedStatement pstmi = null;
		ResultSet rseti = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		String cliente = new String();
		int rowcount = 0;
		int rowcount_imagem = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String diretorioImagens = parametros.retornaParametro("diretorio_imagens_report");
		FileOutputStream fos = null;

		try {
			int indiceColuna = 0;
			j = new com.egen.util.jdbc.JdbcUtil();
			nomeArquivo.append("sbr0510").append(util.rand.Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("produtos");
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleleft = wb.createCellStyle();
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
			fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+ nomeArquivo.toString());

			if((p_pedido + "").equals("")) {
				p_abrir_numeracao = false;
			}

			if(!(p_pedido + "").equals("")) {
				StringBuilder sbCliente = new StringBuilder();
				sbCliente.append(" SELECT cli_cdgo || ' - ' || pck_cliente.get_nome(cli_cdgo) cliente ");
				sbCliente.append("   FROM ped ");
				sbCliente.append("  WHERE ped_nmro = ").append(p_pedido);
				cliente = query.retorna(j, sbCliente.toString());
			}

			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);
			sheet.addMergedRegion(region);
			CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 4);
			sheet.addMergedRegion(region2);

			if(!(p_pedido + "").equals("")) {
				trow = sheetPrincipal.createRow(rowcount++);
				tcell = trow.createCell(0);
				tcell.setCellValue("Cliente: " + cliente);
				trow = sheetPrincipal.createRow(rowcount++);
				tcell = trow.createCell(0);
				tcell.setCellValue("Pedido: " + p_pedido);
				rowcount++;
			}

			trow = sheetPrincipal.createRow(rowcount++);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Marca");
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Imagem");
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Descrição");
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Filial");
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Modelo");
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Material");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Cabedal");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Cabedal Tipo");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Forro");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Forro Tipo");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Palmilha");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Sola");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Tipo de Salto");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Altura Salto");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Tipo Processo Salto" );
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Etiqueta");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("NCM");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Unidade de Negócio");
			tcell.setCellStyle(style);

			if(!(p_pedido + "").equals("")) {

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue("Pares");
				tcell.setCellStyle(style);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue("Preço Unitário");
				tcell.setCellStyle(style);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue("Valor");
				tcell.setCellStyle(style);

			}

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("Peso por Par (KG)");
			tcell.setCellStyle(style);

			if (p_abrir_numeracao) {
				StringBuilder sbc = new StringBuilder();
				sbc.append(" SELECT DISTINCT qp.qtp_nume numero ");
				sbc.append("   FROM qtd_prg qp ");
				sbc.append("      , ite ");
				sbc.append("      , ped ");
				sbc.append("  WHERE ped.ped_nmro = ite.ped_nmro ");
				sbc.append("    AND ite.ped_nmro = qp.ped_nmro ");
				sbc.append("    AND ite.ite_seqn = qp.ite_seqn ");
				sbc.append("    AND ped.ped_nmro = ").append(p_pedido );
				sbc.append("    AND ped.ped_stat <> 'C' ");
				sbc.append("  ORDER BY TO_NUMBER(regexp_substr(qp.qtp_nume, '[[:digit:]]+', 1, 1)) ");

				pstmi = j.getConn().prepareStatement(sbc.toString());
				rseti = pstmi.executeQuery();
				int contadorc = indiceColuna;
				while (rseti.next()) {
					tcell = trow.createCell(contadorc++);
					tcell.setCellValue(rseti.getString("numero"));
					tcell.setCellStyle(stylecenterborda);
				}
				rseti.close();
				pstmi.close();
			}

			if(!(p_pedido + "").equals("")) {
				sb.append(" SELECT modelo ");
				sb.append("      , cab_cdgo ");
				sb.append("      , material ");
				sb.append("      , cabedal ");
				sb.append("      , forro ");
				sb.append("      , sola ");
				sb.append("      , cod_cab ");
				sb.append("      , cod_sola ");
				sb.append("      , etiqueta ");
				sb.append("      , ncm ");
				sb.append("      , imagem ");
				sb.append("      , palmilha ");
				sb.append("      , marca ");
				sb.append("      , SUM(quantidade_pares) pares ");
				sb.append("      , preco_unitario ");
				sb.append("      , SUM(quantidade_pares * preco_unitario) valor ");
				sb.append("      , codigo_linha ");
				sb.append("      , codigo_referencia ");
				sb.append("      , 0 codigo_grade ");
				sb.append("      , fnc_retorna_filial_lin_ref(codigo_linha, codigo_referencia) filial_producao ");
				sb.append("      , codigo_cabedal ");
				sb.append("      , unn_codigo ");
				sb.append("      , unn_descri ");
				sb.append("      , tipo_comp_cabedal ");
				sb.append("      , tipo_comp_forro ");
				sb.append("      , tipo_salto ");
				sb.append("      , altura_salto ");
				sb.append("      , tipo_processo_salto ");
				sb.append("      , peso_par_modelo ");
				sb.append("      , descricao_item ");
				sb.append("   FROM (SELECT i.ped_nmro ");
				sb.append("              , fct_mask_modelo(i.lin_cdgo, i.ref_cdgo) modelo ");
				sb.append("              , c.cab_cdgo ");
				sb.append("              , c.cab_desc material ");
				sb.append("              , NVL(pck_composicao_produto.get_composicao_cabedal_perc(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo), pck_composicao_produto.get_composicao_cabedal(i.cab_cdgo)) cabedal ");
				sb.append("              , pck_composicao_produto.get_composicao_forro(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) forro ");
				sb.append("              , pck_composicao_produto.get_composicao_sola(i.lin_cdgo, i.ref_cdgo) sola ");
				sb.append("              , c.tip_mat_cdgo cod_cab ");
				sb.append("              , r.sol_codigo cod_sola ");
				sb.append("              , pck_composicao_produto.get_ncm(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) ncm ");
				sb.append("              , fct_retorna_fit_imagem(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) imagem ");
				sb.append("              , pck_composicao_produto.get_composicao_palmilha(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) palmilha ");
				sb.append("              , i.ite_prco preco_unitario ");
				sb.append("              , i.ite_qtde quantidade_pares ");
				sb.append("              , pck_marcas_produtos.get_nome(r.codigo_marca) marca ");
				sb.append("              , i.lin_cdgo codigo_linha ");
				sb.append("              , i.ref_cdgo codigo_referencia ");
				sb.append("              , i.cab_cdgo codigo_cabedal ");
				sb.append("              , 0 unn_codigo ");
				sb.append("              , pck_composicao_produto.get_unidade_negocio(i.lin_cdgo) unn_descri ");
				sb.append("              , pck_composicao_produto.get_etiqueta(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) etiqueta ");
				sb.append("              , pck_composicao_produto.get_tipo_composicao_cabedal(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) tipo_comp_cabedal ");
				sb.append("              , pck_composicao_produto.get_tipo_composicao_forro(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) tipo_comp_forro ");
				sb.append("              , pck_composicao_produto.get_tipo_salto(i.lin_cdgo, i.ref_cdgo) tipo_salto ");
				sb.append("              , brio.pck_composicao_produto.get_altura_salto(i.lin_cdgo, i.ref_cdgo) altura_salto ");
				sb.append("              , pck_composicao_produto.get_tipo_processo_salto(i.lin_cdgo, i.ref_cdgo) tipo_processo_salto ");
				sb.append("              , brio.pck_composicao_produto.get_peso_par_modelo(i.lin_cdgo, i.ref_cdgo) peso_par_modelo ");
				sb.append("              , brio.pck_composicao_produto.get_descricao_item(p.cli_cdgo, p.esc_seqn, i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) descricao_item ");
				sb.append("              , p.cli_cdgo codigo_cliente ");
				sb.append("              , p.esc_seqn estabelecimento_cliente ");
				sb.append("           FROM ite i ");
				sb.append("              , ped p ");
				sb.append("              , lin l ");
				sb.append("              , ref r ");
				sb.append("              , cabedal c ");
				sb.append("          WHERE l.lin_cdgo = r.lin_cdgo ");
				sb.append("            AND r.lin_cdgo = i.lin_cdgo ");
				sb.append("            AND r.ref_cdgo = i.ref_cdgo ");
				sb.append("            AND c.cab_cdgo = i.cab_cdgo ");
				sb.append("            AND p.ped_nmro = i.ped_nmro ");
				sb.append("            AND p.ped_nmro = ").append(p_pedido);
				if(!(p_linha + "").equals("")) {
					sb.append("            AND r.lin_cdgo = ").append(p_linha);
				}
				if(!(p_referencia + "").equals("")) {
					sb.append("            AND r.ref_cdgo = ").append(p_referencia);
				}
				if(!(p_cabedal + "").equals("")) {
					sb.append("            AND c.cab_cdgo = ").append(p_cabedal);
				}
				sb.append("            AND p.ped_stat <> 'C') s ");
				sb.append("  GROUP BY modelo ");
				sb.append("         , cab_cdgo ");
				sb.append("         , material ");
				sb.append("         , cabedal ");
				sb.append("         , forro ");
				sb.append("         , sola ");
				sb.append("         , cod_cab ");
				sb.append("         , cod_sola ");
				sb.append("         , ncm ");
				sb.append("         , imagem ");
				sb.append("         , palmilha ");
				sb.append("         , marca ");
				sb.append("         , preco_unitario ");
				sb.append("         , codigo_linha ");
				sb.append("         , codigo_referencia ");
				sb.append("         , codigo_cabedal ");
				sb.append("         , unn_codigo ");
				sb.append("         , unn_descri ");
				sb.append("         , etiqueta ");
				sb.append("         , tipo_comp_cabedal ");
				sb.append("         , tipo_comp_forro ");
				sb.append("         , tipo_salto ");
				sb.append("         , tipo_processo_salto ");
				sb.append("         , peso_par_modelo ");
				sb.append("         , descricao_item ");
				sb.append("         , codigo_cliente ");
				sb.append("         , estabelecimento_cliente ");
				sb.append("  ORDER BY modelo ");
			} else {
				sb.append(" SELECT modelo ");
				sb.append("      , cab_cdgo ");
				sb.append("      , material ");
				sb.append("      , cabedal ");
				sb.append("      , forro ");
				sb.append("      , sola ");
				sb.append("      , cod_cab ");
				sb.append("      , cod_sola ");
				sb.append("      , etiqueta ");
				sb.append("      , ncm ");
				sb.append("      , imagem ");
				sb.append("      , palmilha ");
				sb.append("      , codigo_linha ");
				sb.append("      , codigo_referencia ");
				sb.append("      , marca ");
				sb.append("      , fnc_retorna_filial_lin_ref(codigo_linha, codigo_referencia) filial_producao ");
				sb.append("      , codigo_cabedal ");
				sb.append("      , unn_codigo ");
				sb.append("      , unn_descri ");
				sb.append("      , tipo_comp_cabedal ");
				sb.append("      , tipo_comp_forro ");
				sb.append("      , tipo_salto ");
				sb.append("      , altura_salto ");
				sb.append("      , tipo_processo_salto ");
				sb.append("      , peso_par_modelo ");
				sb.append("      , descricao_item ");
				sb.append("   FROM (SELECT fct_mask_modelo(r.lin_cdgo, r.ref_cdgo) modelo ");
				sb.append("              , c.cab_cdgo ");
				sb.append("              , c.cab_desc material ");
				sb.append("              , NVL(pck_composicao_produto.get_composicao_cabedal_perc(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo), pck_composicao_produto.get_composicao_cabedal(c.cab_cdgo)) cabedal ");
				sb.append("              , pck_composicao_produto.get_composicao_forro(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) forro ");
				sb.append("              , pck_composicao_produto.get_composicao_sola(r.lin_cdgo, r.ref_cdgo) sola ");
				sb.append("              , c.tip_mat_cdgo cod_cab ");
				sb.append("              , r.sol_codigo cod_sola ");
				sb.append("              , pck_composicao_produto.get_etiqueta(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) etiqueta ");
				sb.append("              , pck_composicao_produto.get_ncm(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) ncm ");
				sb.append("              , fct_retorna_fit_imagem(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) imagem ");
				sb.append("              , pck_composicao_produto.get_composicao_palmilha(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) palmilha ");
				sb.append("              , r.lin_cdgo codigo_linha ");
				sb.append("              , r.ref_cdgo codigo_referencia ");
				sb.append("              , pck_marcas_produtos.get_nome(r.codigo_marca) marca ");
				sb.append("              , c.cab_cdgo codigo_cabedal ");
				sb.append("              , 0 unn_codigo ");
				sb.append("              , pck_composicao_produto.get_unidade_negocio(r.lin_cdgo) unn_descri ");
				sb.append("              , pck_composicao_produto.get_tipo_composicao_cabedal(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) tipo_comp_cabedal ");
				sb.append("              , pck_composicao_produto.get_tipo_composicao_forro(r.lin_cdgo, r.ref_cdgo, c.cab_cdgo) tipo_comp_forro ");
				sb.append("              , pck_composicao_produto.get_tipo_salto(r.lin_cdgo, r.ref_cdgo) tipo_salto ");
				sb.append("              , brio.pck_composicao_produto.get_altura_salto(r.lin_cdgo, r.ref_cdgo) altura_salto ");
				sb.append("              , pck_composicao_produto.get_tipo_processo_salto(r.lin_cdgo, r.ref_cdgo) tipo_processo_salto ");
				sb.append("              , brio.pck_composicao_produto.get_peso_par_modelo(r.lin_cdgo, r.ref_cdgo) peso_par_modelo ");
				sb.append("              , brio.pck_referencia.get_nome(r.lin_cdgo, r.ref_cdgo) descricao_item ");
				sb.append("         FROM lin l ");
				sb.append("            , ref r ");
				sb.append("            , ref_cab rc ");
				sb.append("            , cabedal c ");
				sb.append("        WHERE l.lin_cdgo = r.lin_cdgo ");
				sb.append("          AND r.lin_cdgo = rc.lin_cdgo ");
				sb.append("          AND r.ref_cdgo = rc.ref_cdgo ");
				sb.append("          AND rc.cab_cdgo = c.cab_cdgo ");
				sb.append("          AND r.lin_cdgo = ").append(p_linha);
				if(!(p_referencia + "").equals("")) {
					sb.append("            AND r.ref_cdgo = ").append(p_referencia);
				}
				if(!(p_cabedal + "").equals("")) {
					sb.append("            AND c.cab_cdgo = ").append(p_cabedal);
				}
				sb.append("         ) s ");
				sb.append("  GROUP BY modelo ");
				sb.append("         , cab_cdgo ");
				sb.append("         , material ");
				sb.append("         , cabedal ");
				sb.append("         , forro ");
				sb.append("         , sola ");
				sb.append("         , cod_cab ");
				sb.append("         , cod_sola ");
				sb.append("         , etiqueta ");
				sb.append("         , ncm ");
				sb.append("         , imagem ");
				sb.append("         , palmilha ");
				sb.append("         , codigo_linha ");
				sb.append("         , codigo_referencia ");
				sb.append("         , marca ");
				sb.append("         , codigo_cabedal ");
				sb.append("         , unn_codigo ");
				sb.append("         , unn_descri ");
				sb.append("         , tipo_comp_cabedal ");
				sb.append("         , tipo_comp_forro ");
				sb.append("         , tipo_salto ");
				sb.append("         , altura_salto ");
				sb.append("         , tipo_processo_salto ");
				sb.append("         , peso_par_modelo ");
				sb.append("         , descricao_item ");
				sb.append("  ORDER BY modelo ");
			}

			if(mostraQuery){
				req.setAttribute("query", sb.toString());
			}

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();

			while (rset.next()) {
				indiceColuna = 0;
				gerou = true;
				++rowcount;
				rowcount_imagem = rowcount;
				trow = sheetPrincipal.createRow(rowcount);
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("marca"));
				tcell.setCellStyle(stylecenter);
				indiceColuna++;

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("descricao_item"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("filial_producao"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("modelo"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("cab_cdgo"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("material"));
				tcell.setCellStyle(styleleft);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("cabedal"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("tipo_comp_cabedal")!=null?(rset.getString("tipo_comp_cabedal").replaceAll("#", "#")):null);
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("forro"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("tipo_comp_forro")!=null?(rset.getString("tipo_comp_forro").replaceAll("#", "#")):null);
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("palmilha"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("sola"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("tipo_salto"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("altura_salto"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("tipo_processo_salto"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("etiqueta"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("ncm"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("unn_descri"));
				tcell.setCellStyle(stylecenter);
				
				if(!(p_pedido + "").equals("")) {

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getInt("pares"));

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("preco_unitario"));

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("valor"));
				
				}

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("peso_par_modelo"));

				if (p_abrir_numeracao) {
					int contador = indiceColuna;
					StringBuilder sbi = new StringBuilder();
					sbi.append(" SELECT SUM(pares) pares ");
					sbi.append("   FROM (SELECT qp.qtp_nume numero ");
					sbi.append("              , SUM(ite.ite_qtde / (SELECT SUM(q1.qtp_pars) ");
					sbi.append("                                      FROM qtd_prg q1 ");
					sbi.append("                                     WHERE ite.ped_nmro = q1.ped_nmro ");
					sbi.append("                                       AND ite.ite_seqn = q1.ite_seqn) * qp.qtp_pars) pares ");
					sbi.append("           FROM qtd_prg qp ");
					sbi.append("              , ite ");
					sbi.append("              , ped ");
					sbi.append("          WHERE ped.ped_nmro = ite.ped_nmro ");
					sbi.append("            AND ite.ped_nmro = qp.ped_nmro ");
					sbi.append("            AND ite.ite_seqn = qp.ite_seqn ");
					sbi.append("            AND ped.ped_nmro = ").append(p_pedido);
					sbi.append("            AND ped.ped_stat <> 'C' ");
					sbi.append("          GROUP BY qp.qtp_nume ");
					sbi.append("         UNION ");
					sbi.append("         SELECT DISTINCT qp.qtp_nume numero ");
					sbi.append("                        ,0 pares ");
					sbi.append("           FROM qtd_prg qp ");
					sbi.append("              , ite ");
					sbi.append("              , ped ");
					sbi.append("          WHERE ped.ped_nmro = ite.ped_nmro ");
					sbi.append("            AND ite.ped_nmro = qp.ped_nmro ");
					sbi.append("            AND ite.ite_seqn = qp.ite_seqn ");
					sbi.append("            AND ped.ped_nmro = ").append(p_pedido);
					sbi.append("            AND ped.ped_stat <> 'C') ");
					sbi.append("  GROUP BY numero ");
					sbi.append("  ORDER BY TO_NUMBER(regexp_substr(numero, '[[:digit:]]+', 1, 1)) ");

					pstmi = j.getConn().prepareStatement(sbi.toString());
					rseti = pstmi.executeQuery();
					while (rseti.next()) {
						tcell = trow.createCell(contador++);
						tcell.setCellValue(rseti.getInt("pares"));
					}
					rseti.close();
					pstmi.close();
				}
				try {
					String arquivo = diretorioImagens + rset.getString("imagem");
					java.io.File f = new java.io.File(arquivo);
					if (!f.isFile()) {
						arquivo = diretorioImagens + "sem_imagem.jpg";
					}
					FileInputStream fis = new FileInputStream(arquivo);
					ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
					int b;
					while ((b = fis.read()) != -1) {
						img_bytes.write(b);
					}
					fis.close();
					HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (1), (rowcount_imagem), (short) (2), rowcount_imagem + 1);
					int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
					patriarch.createPicture(anchor, index);
					anchor.setAnchorType(0);
				} catch (Exception e) {

				}
			}
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
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
			if (rseti != null) {
				try {
					rseti.close();
				} catch (java.sql.SQLException e) {
				}
			}
			if (pstmi != null) {
				try {
					pstmi.close();
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
