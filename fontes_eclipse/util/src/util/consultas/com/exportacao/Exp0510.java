package util.consultas.com.exportacao;

import util.consultas.Query;
import org.apache.poi.hssf.usermodel.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFCell;

@SuppressWarnings("deprecation")
public class Exp0510 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String geraExcel( HttpServletRequest req
			               , String p_emp_empresa
			               , String p_ano
			               , String p_nr_fatura
			               , boolean p_abrir_numeracao
			               , boolean mostraQuery
			               , boolean amostra
			               , String mostrarComprimentoInterno) throws Exception {

		Query query = new Query();
		boolean abrir_comprimento_interno = false;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheetPrincipal = wb.createSheet("faturas");
		if(mostrarComprimentoInterno != null && mostrarComprimentoInterno.equalsIgnoreCase("S")) {
			abrir_comprimento_interno = true;
		}
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
		int rowcount = 0;
		int rowcount_imagem = 0;
		String retorno = "";
		String locale = buscaIdioma(p_emp_empresa, p_ano, p_nr_fatura, amostra);
		String arquivo = "IndustrialResources_" + locale;
		
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String diretorioImagens = "/home/loja_brportal/imagens/pequenas/";
		
		FileOutputStream fos = null;
		try {
			int indiceColuna = 0;
			j = new com.egen.util.jdbc.JdbcUtil();
			nomeArquivo.append("exp0510").append(util.rand.Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("faturas");
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
			StringBuilder sbCliente = new StringBuilder();
			if (amostra) {
				sbCliente.append(" SELECT codigo_cliente || ' - ' || pck_cliente.get_nome(codigo_cliente) cliente ");
				sbCliente.append("   FROM faturas_amostras fp ");
				sbCliente.append("  WHERE fp.empresa_fatura_amostra = '").append(p_emp_empresa).append("' ");
				sbCliente.append("    AND fp.ano_fatura_amostra = ").append(p_ano);
				sbCliente.append("    AND fp.numero_fatura_amostra = ").append(p_nr_fatura);
			} else {
				sbCliente.append(" SELECT codigo_cliente || ' - ' || pck_cliente.get_nome(codigo_cliente) cliente ");
				sbCliente.append("   FROM faturas_proformas fp ");
				sbCliente.append("  WHERE fp.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
				sbCliente.append("    AND fp.ano_fatura_proforma = ").append(p_ano);
				sbCliente.append("    AND fp.numero_fatura_proforma = ").append(p_nr_fatura);
			}
			
			String cliente = query.retorna(j, sbCliente.toString());
			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);
            sheet.addMergedRegion(region);
            CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 4);
            sheet.addMergedRegion(region2);
            trow = sheetPrincipal.createRow(rowcount++);
            tcell = trow.createCell(0);
            tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.cliente")+": " + cliente);
            
            trow = sheetPrincipal.createRow(rowcount);
            tcell = trow.createCell(0);
            tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.fatura")+": " + p_nr_fatura + " / " + p_ano);
            
			rowcount+=2;
			
			trow = sheetPrincipal.createRow(rowcount);
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.marca"));
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.imagem"));
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.descricao_item"));
			tcell.setCellStyle(stylecenterborda);

			if (amostra) {
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.filial"));
				tcell.setCellStyle(stylecenterborda);
			} else {
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.filial"));
				tcell.setCellStyle(stylecenterborda);
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue("Filial Produção");
				tcell.setCellStyle(stylecenterborda);
			}

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.modelo"));
			tcell.setCellStyle(stylecenterborda);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.material"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue("");
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.cabedal"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.cabedal_tipo_textil"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.forro"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.forro_tipo_textil"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.palmilha"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.sola"));
			tcell.setCellStyle(style);
			
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.sola_descricao"));
			tcell.setCellStyle(style);
			
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.tipo_salto"));
			tcell.setCellStyle(style);
			
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.altura_salto"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.tipo_processo_salto"));
			tcell.setCellStyle(style);
			
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.altura_sapato"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.etiqueta"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.ncm"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.unidade_negocio"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.pares"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.preco_unitario"));
			tcell.setCellStyle(style);

			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.valor"));
			tcell.setCellStyle(style);
			
			tcell = trow.createCell(indiceColuna++);
			tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.peso_par"));
			tcell.setCellStyle(style);
			
			if (amostra) {
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.tamanho"));
				tcell.setCellStyle(style);	
			}

			if (p_abrir_numeracao || abrir_comprimento_interno) {
				StringBuilder sbc = new StringBuilder();
				sbc.append(" SELECT DISTINCT gip.numeracao_par numero ");
				sbc.append("   FROM grades_itens_proformas gip ");
				sbc.append("      , faturas_proformas fp ");
				sbc.append("      , itens_faturas_proformas itfp ");
				sbc.append("  WHERE (nvl(itfp.item_cancelado, 'N') = 'N' or fp.especie_fatura = 'A') ");
				sbc.append("    AND fp.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
				sbc.append("    AND fp.ano_fatura_proforma = itfp.ano_fatura_proforma ");
				sbc.append("    AND fp.numero_fatura_proforma = itfp.numero_fatura_proforma ");
				sbc.append("    AND itfp.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
				sbc.append("    AND itfp.ano_fatura_proforma = ").append(p_ano);
				sbc.append("    AND itfp.numero_fatura_proforma = ").append(p_nr_fatura);
				sbc.append("    AND gip.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
				sbc.append("    AND gip.numero_item = itfp.numero_item ");
				sbc.append("    AND gip.ano_fatura_proforma = itfp.ano_fatura_proforma ");
				sbc.append("    AND gip.numero_fatura_proforma = itfp.numero_fatura_proforma ");
				sbc.append("  ORDER BY TO_NUMBER(regexp_substr(numero, '[[:digit:]]+', 1, 1)), numero ");

				pstmi = j.getConn().prepareStatement(sbc.toString());
				rseti = pstmi.executeQuery();
				int contadorc = indiceColuna;
				java.util.List<String> lista = new ArrayList();
				while (rseti.next()) {
					if (p_abrir_numeracao) {
						tcell = trow.createCell(contadorc++);
						tcell.setCellValue(rseti.getString("numero"));
						tcell.setCellStyle(stylecenterborda);
					}
					lista.add(rseti.getString("numero"));
				}
				
				if(abrir_comprimento_interno) {
					contadorc++;
					for(String s : lista) {
						tcell = trow.createCell(contadorc++);
						tcell.setCellValue(s);
						tcell.setCellStyle(stylecenterborda);
					}
				}
				
				tcell = trow.createCell(contadorc++);
				tcell.setCellValue("BRA");
				tcell.setCellStyle(stylecenterborda);
				
				rseti.close();
				pstmi.close();
				
			}

			if (p_abrir_numeracao || abrir_comprimento_interno) {
				StringBuilder sbExterno = new StringBuilder();
				sbExterno.append(" SELECT DISTINCT nvl(fct_numero_exterior(fp.codigo_cliente,fp.estabelecimento_cliente, gip.numeracao_par), gip.numeracao_par) numero_ext ");
				sbExterno.append("      , gip.numeracao_par ");
				sbExterno.append("   FROM grades_itens_proformas gip ");
				sbExterno.append("      , faturas_proformas fp ");
				sbExterno.append("      , itens_faturas_proformas itfp ");
				sbExterno.append("  WHERE (nvl(itfp.item_cancelado, 'N') = 'N' OR fp.especie_fatura = 'A') ");
				sbExterno.append("    AND fp.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
				sbExterno.append("    AND fp.ano_fatura_proforma = itfp.ano_fatura_proforma ");
				sbExterno.append("    AND fp.numero_fatura_proforma = itfp.numero_fatura_proforma ");
				sbExterno.append("    AND itfp.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
				sbExterno.append("    AND itfp.ano_fatura_proforma = ").append(p_ano);
				sbExterno.append("    AND itfp.numero_fatura_proforma = ").append(p_nr_fatura);
				sbExterno.append("    AND gip.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
				sbExterno.append("    AND gip.numero_item = itfp.numero_item ");
				sbExterno.append("    AND gip.ano_fatura_proforma = itfp.ano_fatura_proforma ");
				sbExterno.append("    AND gip.numero_fatura_proforma = itfp.numero_fatura_proforma ");
				sbExterno.append("  ORDER BY TO_NUMBER(regexp_substr(gip.numeracao_par, '[[:digit:]]+', 1, 1)), gip.numeracao_par ");
				
				pstmi = j.getConn().prepareStatement(sbExterno.toString());
				rseti = pstmi.executeQuery();
				trow = sheetPrincipal.createRow(++rowcount);
				int contadorc = indiceColuna;
				java.util.List<String> lista = new ArrayList();
				while (rseti.next()) {
					if (p_abrir_numeracao) {
						tcell = trow.createCell(contadorc++);
						tcell.setCellValue(rseti.getString("numero_ext"));
						tcell.setCellStyle(stylecenterborda);
					}
					lista.add(rseti.getString("numero_ext"));
				}
				
				if(abrir_comprimento_interno) {
					contadorc++;
					for(String s : lista) {
						tcell = trow.createCell(contadorc++);
						tcell.setCellValue(s);
						tcell.setCellStyle(stylecenterborda);
					}
				}
				rseti.close();
				pstmi.close();
			}

			if (amostra) {
		        sb.append(" SELECT modelo ");
			    sb.append("      , cab_cdgo ");
			    sb.append("      , material ");
			    sb.append("      , cabedal ");
			    sb.append("      , forro ");
			    sb.append("      , sola ");
			    sb.append("      , cod_cab ");
			    sb.append("      , cod_sola ");
			    sb.append("      , cod_sola_descricao ");
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
			    sb.append("      , fnc_retorna_filial_lin_ref(codigo_linha, codigo_referencia) filial_linha ");
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
			    sb.append("      , tamanho ");
			    sb.append("      , altura_sapato ");			    
			    sb.append("   FROM (SELECT ifa.numero_fatura_amostra ");
			    sb.append("              , fct_mask_modelo(ifa.codigo_linha, ifa.codigo_referencia) modelo ");
			    sb.append("              , cabe.cab_cdgo ");
			    sb.append("              , cabe.cab_desc material ");
			    sb.append("              , NVL(pck_composicao_produto.get_composicao_cabedal_perc(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal), pck_composicao_produto.get_composicao_cabedal(ifa.codigo_cabedal)) cabedal ");
			    sb.append("              , pck_composicao_produto.get_composicao_forro(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) forro ");
			    sb.append("              , pck_composicao_produto.get_composicao_sola(ifa.codigo_linha, ifa.codigo_referencia) sola ");
			    sb.append("              , cabe.tip_mat_cdgo cod_cab ");
			    sb.append("              , refe.sol_codigo cod_sola ");
			    sb.append("              , pck_tipo_material.get_nome(refe.sol_codigo) cod_sola_descricao ");
			    sb.append("              , pck_composicao_produto.get_ncm(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) ncm ");
			    sb.append("              , fct_retorna_fit_imagem(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) imagem ");
			    sb.append("              , pck_composicao_produto.get_composicao_palmilha(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) palmilha ");
			    sb.append("              , ifa.preco_unitario ");
			    sb.append("              , ifa.quantidade_pares ");
			    sb.append("              , pck_marcas_produtos.get_nome(refe.codigo_marca) marca ");
			    sb.append("              , ifa.codigo_linha ");
			    sb.append("              , ifa.codigo_referencia ");
			    sb.append("              , ifa.codigo_cabedal ");
			    sb.append("              , 0 unn_codigo ");
			    sb.append("              , pck_composicao_produto.get_unidade_negocio(ifa.codigo_linha) unn_descri ");
			    sb.append("              , pck_composicao_produto.get_etiqueta(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) etiqueta ");
			    sb.append("              , pck_composicao_produto.get_tipo_composicao_cabedal(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) tipo_comp_cabedal ");
			    sb.append("              , pck_composicao_produto.get_tipo_composicao_forro(ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) tipo_comp_forro ");
			    sb.append("              , pck_composicao_produto.get_tipo_salto(ifa.codigo_linha, ifa.codigo_referencia) tipo_salto ");
			    sb.append("              , brio.pck_composicao_produto.get_altura_salto(ifa.codigo_linha, ifa.codigo_referencia) altura_salto ");
			    sb.append("              , pck_composicao_produto.get_tipo_processo_salto(ifa.codigo_linha, ifa.codigo_referencia) tipo_processo_salto ");
			    sb.append("              , brio.pck_composicao_produto.get_peso_par_modelo(ifa.codigo_linha, ifa.codigo_referencia) peso_par_modelo ");
			    sb.append("              , brio.pck_composicao_produto.get_descricao_item(fp.codigo_cliente, fp.estabelecimento_cliente, ifa.codigo_linha, ifa.codigo_referencia, ifa.codigo_cabedal) descricao_item ");
			    sb.append("              , fp.codigo_cliente ");
			    sb.append("              , fp.estabelecimento_cliente ");
			    sb.append("              , ifa.tamanho ");
			    sb.append("              , brio.pck_composicao_produto.get_altura_salto(ifa.codigo_linha, ifa.codigo_referencia) altura_sapato ");
			    sb.append("           FROM itens_faturas_amostras ifa ");
			    sb.append("              , faturas_amostras       fp ");
			    sb.append("              , lin                    l ");
			    sb.append("              , ref                    refe ");
			    sb.append("              , cabedal                cabe ");
			    sb.append("          WHERE refe.lin_cdgo = ifa.codigo_linha ");
			    sb.append("            AND refe.ref_cdgo = ifa.codigo_referencia ");
			    sb.append("            AND cabe.cab_cdgo = ifa.codigo_cabedal ");
			    sb.append("            AND l.lin_cdgo = iFA.codigo_linha ");
			    sb.append("            AND fp.empresa_fatura_amostra = ifa.empresa_fatura_amostra ");
			    sb.append("            AND fp.ano_fatura_amostra = ifa.ano_fatura_amostra ");
			    sb.append("            AND fp.numero_fatura_amostra = ifa.numero_fatura_amostra ");
			    sb.append("            AND ifa.empresa_fatura_amostra = '").append(p_emp_empresa).append("' ");
			    sb.append("            AND ifa.ano_fatura_amostra = ").append(p_ano);
			    sb.append("            AND ifa.numero_fatura_amostra = ").append(p_nr_fatura);
			    sb.append("            AND (NVL(ifa.item_cancelado, 'N') = 'N' OR fp.especie_fatura = 'A')) s ");
			    sb.append("  GROUP BY modelo ");
			    sb.append("         , cab_cdgo ");
			    sb.append("         , material ");
			    sb.append("         , cabedal ");
			    sb.append("         , forro ");
			    sb.append("         , sola ");
			    sb.append("         , cod_cab "); 
			    sb.append("         , cod_sola ");
			    sb.append("         , cod_sola_descricao ");
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
			    sb.append("         , tamanho ");
			    sb.append("         , altura_salto ");
			    sb.append("         , altura_sapato ");			    
			    sb.append("   ORDER BY modelo ");
			} else {
				sb.append(" SELECT modelo ");
				sb.append("      , cab_cdgo ");
				sb.append("      , material ");
				sb.append("      , cabedal ");
				sb.append("      , forro ");
				sb.append("      , sola ");
				sb.append("      , cod_cab ");
				sb.append("      , cod_sola ");
				sb.append("      , cod_sola_descricao ");
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
				sb.append("      , fnc_retorna_filial_lin_ref(codigo_linha, codigo_referencia) filial_linha ");
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
				sb.append("      , filial_producao ");
				sb.append("      , altura_sapato ");
				sb.append("   FROM (SELECT itfp.numero_fatura_proforma ");
				sb.append("              , fct_mask_modelo(itfp.codigo_linha, itfp.codigo_referencia) modelo ");
				sb.append("              , cabe.cab_cdgo ");
				sb.append("              , cabe.cab_desc material ");
				sb.append("              , NVL(pck_composicao_produto.get_composicao_cabedal_perc(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal), pck_composicao_produto.get_composicao_cabedal(itfp.codigo_cabedal)) cabedal ");
				sb.append("              , pck_composicao_produto.get_composicao_forro(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) forro ");
				sb.append("              , pck_composicao_produto.get_composicao_sola(itfp.codigo_linha, itfp.codigo_referencia) sola ");
				sb.append("              , cabe.tip_mat_cdgo cod_cab ");
				sb.append("              , refe.sol_codigo cod_sola ");
				sb.append("              , pck_tipo_material.get_nome(refe.sol_codigo) cod_sola_descricao ");
				sb.append("              , pck_composicao_produto.get_ncm(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) ncm ");
				sb.append("              , fct_retorna_fit_imagem(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) imagem ");
				sb.append("              , pck_composicao_produto.get_composicao_palmilha(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) palmilha ");
				sb.append("              , itfp.preco_unitario ");
				sb.append("              , itfp.quantidade_pares ");
				sb.append("              , pck_marcas_produtos.get_nome(refe.codigo_marca) marca ");
				sb.append("              , itfp.codigo_linha ");
				sb.append("              , itfp.codigo_referencia ");
				sb.append("              , itfp.codigo_cabedal ");
				sb.append("              , 0 unn_codigo ");
				sb.append("              , pck_composicao_produto.get_unidade_negocio(itfp.codigo_linha) unn_descri ");
				sb.append("              , pck_composicao_produto.get_etiqueta(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) etiqueta ");
				sb.append("              , pck_composicao_produto.get_tipo_composicao_cabedal(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) tipo_comp_cabedal ");
				sb.append("              , pck_composicao_produto.get_tipo_composicao_forro(itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) tipo_comp_forro ");
				sb.append("              , pck_composicao_produto.get_tipo_salto(itfp.codigo_linha, itfp.codigo_referencia) tipo_salto ");
				sb.append("              , brio.pck_composicao_produto.get_altura_salto(itfp.codigo_linha, itfp.codigo_referencia) altura_salto ");
				sb.append("              , pck_composicao_produto.get_tipo_processo_salto(itfp.codigo_linha, itfp.codigo_referencia) tipo_processo_salto ");
				sb.append("              , brio.pck_composicao_produto.get_peso_par_modelo(itfp.codigo_linha, itfp.codigo_referencia) peso_par_modelo ");
				sb.append("              , brio.pck_composicao_produto.get_descricao_item(fp.codigo_cliente, fp.estabelecimento_cliente, itfp.codigo_linha, itfp.codigo_referencia, itfp.codigo_cabedal) descricao_item ");
				sb.append("              , fp.codigo_cliente ");
				sb.append("              , fp.estabelecimento_cliente ");
	            sb.append("              , case when (fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) = '23' and les_codigo = 100) then '23 CR' else  fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) end filial_producao ");
	            sb.append("              , brio.pck_composicao_produto.get_altura_salto(itfp.codigo_linha, itfp.codigo_referencia) altura_sapato ");	            
				sb.append("           FROM itens_faturas_proformas itfp ");
				sb.append("              , ite                     i ");
				sb.append("              , faturas_proformas       fp ");
				sb.append("              , lin                     l ");
				sb.append("              , ref                     refe ");
				sb.append("              , cabedal                 cabe ");
				sb.append("          WHERE refe.lin_cdgo = itfp.codigo_linha ");
				sb.append("            AND refe.ref_cdgo = itfp.codigo_referencia ");
				sb.append("            AND cabe.cab_cdgo = itfp.codigo_cabedal ");
				sb.append("            AND l.lin_cdgo = itfp.codigo_linha ");
				sb.append("            AND fp.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
				sb.append("            AND fp.ano_fatura_proforma = itfp.ano_fatura_proforma ");
				sb.append("            AND fp.numero_fatura_proforma = itfp.numero_fatura_proforma ");
	            sb.append("            AND i.empresa_fatura_proforma (+) = itfp.empresa_fatura_proforma ");
	            sb.append("            AND i.ano_fatura_proforma (+) = itfp.ano_fatura_proforma ");
	            sb.append("            AND i.numero_fatura_proforma (+) = itfp.numero_fatura_proforma ");
	            sb.append("            AND i.numero_item_fatura_proforma (+) = itfp.numero_item ");				
				sb.append("            AND itfp.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
				sb.append("            AND itfp.ano_fatura_proforma = ").append(p_ano);
				sb.append("            AND itfp.numero_fatura_proforma = ").append(p_nr_fatura);
				sb.append("            AND (nvl(itfp.item_cancelado, 'N') = 'N' OR (fp.especie_fatura = 'A' and itfp.flag_gerar_nova_fatura = 'S'))) s ");
				sb.append("  GROUP BY modelo ");
				sb.append("         , cab_cdgo ");
				sb.append("         , material ");
				sb.append("         , cabedal ");
				sb.append("         , forro ");
				sb.append("         , sola ");
				sb.append("         , cod_cab ");
				sb.append("         , cod_sola ");
				sb.append("         , cod_sola_descricao ");
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
				sb.append("         , filial_producao ");
				sb.append("         , altura_salto ");
				sb.append("         , altura_sapato ");
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
				
				if (amostra) {
					tcell = trow.createCell(indiceColuna++);
					tcell.setCellValue(rset.getString("filial_linha"));
					tcell.setCellStyle(stylecenter);
				} else {
					tcell = trow.createCell(indiceColuna++);
					tcell.setCellValue(rset.getString("filial_linha"));
					tcell.setCellStyle(stylecenter);
					
					tcell = trow.createCell(indiceColuna++);
					tcell.setCellValue(rset.getString("filial_producao"));
					tcell.setCellStyle(stylecenter);
				}

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
				tcell.setCellValue(rset.getString("cod_sola_descricao"));
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
				tcell.setCellValue(rset.getDouble("altura_sapato"));
				tcell.setCellStyle(stylecenter);				
				
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("etiqueta"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getString("ncm"));
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				if(rset.getString("unn_descri").equalsIgnoreCase("MANUFATURADOS")) {
					tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.unidade_negocio.manufaturado"));
				} else if(rset.getString("unn_descri").equalsIgnoreCase("INJECAO DIRETA")) {
					tcell.setCellValue(util.file.Bundle.getKey(arquivo, "Exp0510.unidade_negocio.injecao_direta"));
				} else {
					tcell.setCellValue(rset.getString("unn_descri"));	
				}
				
				tcell.setCellStyle(stylecenter);

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getInt("pares"));

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("preco_unitario"));

				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("valor"));
				
				tcell = trow.createCell(indiceColuna++);
				tcell.setCellValue(rset.getDouble("peso_par_modelo"));

				if (amostra) {
					tcell = trow.createCell(indiceColuna++);
					tcell.setCellValue(rset.getString("tamanho"));	
				}
				
				if (p_abrir_numeracao || abrir_comprimento_interno) {
					int contador = indiceColuna;
					StringBuilder sbi = new StringBuilder();
					sbi.append(" SELECT SUM(pares) pares ");
					sbi.append("      , ref_compr_interno_pe ");   
					sbi.append("   FROM (SELECT g.numeracao_par numero ");
					sbi.append("              , SUM(i.quantidade_pares / (SELECT SUM(q1.quantidade_pares) ");
					sbi.append("                                            FROM grades_itens_proformas q1 ");
					sbi.append("                                           WHERE i.empresa_fatura_proforma = q1.empresa_fatura_proforma ");
					sbi.append("                                             AND i.ano_fatura_proforma = q1.ano_fatura_proforma ");
					sbi.append("                                             AND i.numero_fatura_proforma = q1.numero_fatura_proforma ");
					sbi.append("                                             AND i.numero_item = q1.numero_item) * g.quantidade_pares) pares ");
					sbi.append("           FROM itens_faturas_proformas i ");
					sbi.append("              , faturas_proformas f ");
					sbi.append("              , exp.grades_itens_proformas g ");
					sbi.append("          WHERE i.empresa_fatura_proforma = g.empresa_fatura_proforma ");
					sbi.append("            AND i.ano_fatura_proforma = g.ano_fatura_proforma ");
					sbi.append("            AND i.numero_fatura_proforma = g.numero_fatura_proforma ");
					sbi.append("            AND f.empresa_fatura_proforma = i.empresa_fatura_proforma ");
					sbi.append("            AND (nvl(i.item_cancelado, 'N') = 'N' or f.especie_fatura = 'A') ");
					sbi.append("            AND f.ano_fatura_proforma = i.ano_fatura_proforma ");
					sbi.append("            AND f.numero_fatura_proforma = i.numero_fatura_proforma "); 
					sbi.append("            AND i.numero_item = g.numero_item ");
					sbi.append("            AND i.ano_fatura_proforma = ").append(p_ano);
					sbi.append("            AND i.numero_fatura_proforma = ").append(p_nr_fatura);
					sbi.append("            AND i.codigo_linha = ").append(rset.getInt("codigo_linha"));
					sbi.append("            AND i.codigo_referencia = ").append(rset.getInt("codigo_referencia"));
					sbi.append("            AND i.codigo_cabedal = ").append(rset.getString("codigo_cabedal"));
					sbi.append("            AND i.preco_unitario = ").append(rset.getDouble("preco_unitario"));
					sbi.append("            AND i.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
					sbi.append("          GROUP BY g.numeracao_par ");
					sbi.append("          UNION ");
					sbi.append("         SELECT DISTINCT gip.numeracao_par numero ");
					sbi.append("                       , 0 pares ");
					sbi.append("           FROM grades_itens_proformas gip ");
					sbi.append("              , faturas_proformas f ");
					sbi.append("              , itens_faturas_proformas itfp ");
					sbi.append("          WHERE (nvl(itfp.item_cancelado, 'N') = 'N' or f.especie_fatura = 'A')");
					sbi.append("            AND itfp.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
					sbi.append("            AND itfp.ano_fatura_proforma = ").append(p_ano);
					sbi.append("            AND itfp.numero_fatura_proforma = ").append(p_nr_fatura);
					sbi.append("            AND f.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
					sbi.append("            AND f.ano_fatura_proforma = itfp.ano_fatura_proforma ");
					sbi.append("            AND f.numero_fatura_proforma = itfp.numero_fatura_proforma ");
					sbi.append("            AND gip.empresa_fatura_proforma = itfp.empresa_fatura_proforma ");
					sbi.append("            AND gip.numero_item = itfp.numero_item ");
					sbi.append("            AND gip.ano_fatura_proforma = itfp.ano_fatura_proforma ");
					sbi.append("            AND gip.numero_fatura_proforma = itfp.numero_fatura_proforma) qry ");
				    sbi.append("       , ref_inf_adicionais_num r ");
				    sbi.append("   WHERE r.lin_cdgo(+) = ").append(rset.getInt("codigo_linha"));
				    sbi.append("     AND r.ref_cdgo(+) = ").append(rset.getInt("codigo_referencia"));
				    sbi.append("     AND r.rfn_numero(+) = qry.numero ");
					sbi.append(" GROUP BY numero ");
					sbi.append("        , ref_compr_interno_pe ");
					sbi.append(" ORDER BY TO_NUMBER(regexp_substr(numero, '[[:digit:]]+', 1, 1)), numero ");

					pstmi = j.getConn().prepareStatement(sbi.toString());
					rseti = pstmi.executeQuery();
					List<Float> lista = new ArrayList();
					while (rseti.next()) {
						if (p_abrir_numeracao) {
							tcell = trow.createCell(contador++);
							tcell.setCellValue(rseti.getInt("pares"));
						}
						lista.add(rseti.getFloat("ref_compr_interno_pe"));
					}

					if(abrir_comprimento_interno) {
						contador++;
						for(Float s : lista) {
							tcell = trow.createCell(contador++);
							tcell.setCellValue(s);
						}
					}
					
					rseti.close();
					pstmi.close();
				}
				try {
					String arquivoImagem = diretorioImagens + rset.getString("imagem");
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
					HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (1), (rowcount_imagem), (short) (2), rowcount_imagem + 1);
					int index = wb.addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);
					patriarch.createPicture(anchor, index);
					anchor.setAnchorType(0);
				} catch (Exception e) {
					e.printStackTrace(System.err);
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

	private String buscaIdioma(String p_emp_empresa, String p_ano, String p_nr_fatura, boolean amostra) {
		String locale = null;
		try {
			Query query = new Query();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT DECODE(NVL(e.idio_codigo_idioma, 3), 1, 'en_US', 2, 'es_ES', 5, 'es_ES', 3, 'pt_BR', 'pt_BR') locale ");
			if(amostra) {
				sb.append("   FROM faturas_amostras fp "); 
			} else {
				sb.append("   FROM faturas_proformas fp ");
			}
			sb.append("      , esc               e ");
			if(amostra) {
				sb.append("  WHERE fp.empresa_fatura_amostra = '").append(p_emp_empresa).append("' ");
				sb.append("    AND fp.ano_fatura_amostra = ").append(p_ano);
				sb.append("    AND fp.numero_fatura_amostra = ").append(p_nr_fatura);
			} else {
				sb.append("  WHERE fp.empresa_fatura_proforma = '").append(p_emp_empresa).append("' ");
				sb.append("    AND fp.ano_fatura_proforma = ").append(p_ano);
				sb.append("    AND fp.numero_fatura_proforma = ").append(p_nr_fatura);
			}
			sb.append("    AND fp.codigo_cliente = e.cli_cdgo ");
			sb.append("    AND fp.estabelecimento_cliente = e.esc_seqn ");
			sb.append("    AND rownum = 1 ");
			locale = query.retorna(sb.toString());
		} catch (Exception e) {
			return "pt_BR";
		}
		return locale;
	}
	
}