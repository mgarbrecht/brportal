package util.consultas.ind;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Font;

import util.consultas.Query;

public class Pse0053 {

	public String geraExcel(javax.servlet.http.HttpSession session) {
		String retorno = "";
		try {
			java.util.Vector<?> res_Jw_pse0053_total_fechado = (java.util.Vector<?>) session.getAttribute("res_Jw_pse0053_total_fechado");
			java.util.Vector<?> res_Jw_pse0053_total_aberto = (java.util.Vector<?>) session.getAttribute("res_Jw_pse0053_total_aberto");
			java.util.Vector<?> res_Jw_pse0053_notas_fiscais = (java.util.Vector<?>) session.getAttribute("res_Jw_pse0053_notas_fiscais");
			java.util.Vector<?> res_Jw_processo_fab_sub_processo = session.getAttribute("res_Jw_processo_fab_sub_processo") != null ? (java.util.Vector<?>) session.getAttribute("res_Jw_processo_fab_sub_processo") : null;
	        java.lang.Integer codigo_item =  null;
	        java.lang.String descricao_produtos =  null;
	        java.lang.Integer linha =  null;
	        java.lang.Integer referencia =  null;
	        java.lang.Integer cabedal =  null;
	        java.lang.Integer pares1 =  null;
	        java.lang.Double preco1 =  null;
	        java.lang.Double total1 =  null;
	        @SuppressWarnings("unused")
			java.lang.Integer pro_numero2 =  null;
	        java.lang.String fil_filial =  null;
	        java.lang.Integer nfs_nmro =  null;
	        java.lang.String nfs_serie =  null;	
	        java.lang.String remessas = null;
			HSSFWorkbook wb = new HSSFWorkbook();
			org.apache.poi.hssf.usermodel.HSSFRow trow;
			org.apache.poi.hssf.usermodel.HSSFCell tcell;
			org.apache.poi.hssf.usermodel.HSSFCellStyle style;
			org.apache.poi.hssf.usermodel.HSSFCellStyle styleTipoLinha;
			org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
			org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
			org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
			org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
			StringBuilder nomeArquivo = new StringBuilder();
			brportal.ind.Pse0053 p = new brportal.ind.Pse0053();
			java.lang.Double valor_total_nota = 0.0;
			java.lang.Double valor_processo = 0.0;
			double total_pares = 0d;
			int rowcount = 0;
			styleTipoLinha = wb.createCellStyle();
			styleTipoLinha.setAlignment((short) 2);
			Font font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName("Arial");
			font.setBoldweight((short) 2);
			styleTipoLinha.setFont(font);
			styleTipoLinha.setFillForegroundColor(HSSFColor.TAN.index);
			styleTipoLinha.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);			
			boolean gerou = false;
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			String filial = (String) session.getAttribute("pse0053_filial");
			String tipo = (String)session.getAttribute("pse0053_tipo");
			HSSFSheet pse0053sheet = null;
			nomeArquivo.append("pse0053").append(util.rand.Palavra.geraPalavra()).append(".xls");
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
			pse0053sheet = wb.createSheet("Resumo Geral");
			java.lang.Integer pro_numero = null;
			java.lang.Double pares = null;
			java.lang.Double preco = null;
			java.lang.Double total = null;
			int i_bl_report_Jw_pse0053_total_fechado = 0;
			int i_bl_report_Jw_pse0053_total_aberto = 0;
			int i_bl_report_Jw_pse0053_notas_fiscais = 0;
			trow = pse0053sheet.createRow(rowcount++);
			tcell = trow.createCell(0);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Pares");
			tcell = trow.createCell(1);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Preço MO.");
			tcell = trow.createCell(2);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Total");
			String processo = null;
			while (i_bl_report_Jw_pse0053_total_fechado < res_Jw_pse0053_total_fechado.size()) {
				trow = pse0053sheet.createRow(rowcount++);
				portalbr.dbobj.view.Jw_pse0053_total_fechado t_jw_pse0053_total_fechado = (portalbr.dbobj.view.Jw_pse0053_total_fechado) res_Jw_pse0053_total_fechado.elementAt(i_bl_report_Jw_pse0053_total_fechado);
				pro_numero = t_jw_pse0053_total_fechado.getPro_numero();
				pares = t_jw_pse0053_total_fechado.getPares();
				preco = t_jw_pse0053_total_fechado.getPreco();
				total = t_jw_pse0053_total_fechado.getTotal();
				valor_total_nota += total;
				total_pares += pares;
				tcell = trow.createCell(0);
				tcell.setCellValue(pares);
				tcell = trow.createCell(1);
				tcell.setCellValue(preco);
				tcell = trow.createCell(2);
				tcell.setCellValue(total);
				processo = t_jw_pse0053_total_fechado.getPro_numero() + " - " + t_jw_pse0053_total_fechado.getPro_nome();
				i_bl_report_Jw_pse0053_total_fechado++;
			}
			
			java.util.Vector<?> res_Jw_pse0053_total_fechado_itens = session.getAttribute("pse0053_resumo")!=null?p.getRetorno_simbolico_itens_resumo(pro_numero , filial, session):p.getRetorno_simbolico_itens(pro_numero , filial, session);
			if (tipo.equalsIgnoreCase("R")) {
				rowcount = 0;
				wb.createSheet("Valor do retorno simbólico");
				pse0053sheet = wb.getSheet("Valor do retorno simbólico");
				trow = pse0053sheet.createRow(rowcount++);
				tcell = trow.createCell(0);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Processo");
				tcell = trow.createCell(1);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Quantidade");
				tcell = trow.createCell(2);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Valor Processo");
				tcell = trow.createCell(3);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Total");
				valor_processo = p.getProcesso_fab_custo(pro_numero + "", filial);
				trow = pse0053sheet.createRow(rowcount++);
				tcell = trow.createCell(0);
				tcell.setCellValue(processo);
				tcell = trow.createCell(1);
				tcell.setCellValue(total_pares);
				tcell = trow.createCell(2);
				tcell.setCellValue(valor_processo);
				tcell = trow.createCell(3);
				tcell.setCellValue(total_pares * valor_processo);
				valor_total_nota += (total_pares * valor_processo);
				int i_bl_sub_processos = 0;
				if (res_Jw_processo_fab_sub_processo != null && res_Jw_processo_fab_sub_processo.size() > 0) {
					while (i_bl_sub_processos < res_Jw_processo_fab_sub_processo.size()) {
						portalbr.dbobj.view.Jw_processo_fab_sub_processo t_jw_processo_fab_sub_processo = (portalbr.dbobj.view.Jw_processo_fab_sub_processo) res_Jw_processo_fab_sub_processo.elementAt(i_bl_sub_processos);
						valor_processo = p.getProcesso_fab_custo(t_jw_processo_fab_sub_processo.getPro_numero_sub_processo() + "", filial);
						trow = pse0053sheet.createRow(rowcount++);
						tcell = trow.createCell(0);
						tcell.setCellValue(t_jw_processo_fab_sub_processo.getPro_numero_sub_processo() + " - " + t_jw_processo_fab_sub_processo.getPro_nome());
						tcell = trow.createCell(1);
						tcell.setCellValue(total_pares);
						tcell = trow.createCell(2);
						tcell.setCellValue(valor_processo);
						tcell = trow.createCell(3);
						tcell.setCellValue(total_pares * valor_processo);
						valor_total_nota += (total_pares * valor_processo);
						i_bl_sub_processos++;
					}
				}
				int i_bl_report_Jw_pse0053_total_fechado_itens = 0;
				while (i_bl_report_Jw_pse0053_total_fechado_itens < res_Jw_pse0053_total_fechado_itens.size()) {
					portalbr.dbobj.view.Jw_pse0053_total_fechado t_jw_pse0053_total_fechado_itens = (portalbr.dbobj.view.Jw_pse0053_total_fechado) res_Jw_pse0053_total_fechado_itens.elementAt(i_bl_report_Jw_pse0053_total_fechado_itens);
					trow = pse0053sheet.createRow(rowcount++);
					tcell = trow.createCell(0);
					tcell.setCellValue(t_jw_pse0053_total_fechado_itens.getPro_numero() + " - " + t_jw_pse0053_total_fechado_itens.getPro_nome());
					tcell = trow.createCell(1);
					tcell.setCellValue(t_jw_pse0053_total_fechado_itens.getPares());
					tcell = trow.createCell(2);
					tcell.setCellValue(t_jw_pse0053_total_fechado_itens.getPreco());
					tcell = trow.createCell(3);
					tcell.setCellValue(t_jw_pse0053_total_fechado_itens.getTotal());
					valor_total_nota += t_jw_pse0053_total_fechado_itens.getTotal();
					i_bl_report_Jw_pse0053_total_fechado_itens++;
				}
				java.util.Vector<?> res_Jw_pse0053_descontos = p.getDescontos(pro_numero, filial, session);
				if (res_Jw_pse0053_descontos != null && res_Jw_pse0053_descontos.size() > 0) {
					rowcount = 0;
					wb.createSheet("Descontos");
					pse0053sheet = wb.getSheet("Descontos");
					trow = pse0053sheet.createRow(rowcount++);
					tcell = trow.createCell(0);
					tcell.setCellStyle(styleTipoLinha);
					tcell.setCellValue("Processo");
					tcell = trow.createCell(1);
					tcell.setCellStyle(styleTipoLinha);
					tcell.setCellValue("Quantidade");
					tcell = trow.createCell(2);
					tcell.setCellStyle(styleTipoLinha);
					tcell.setCellValue("Valor Processo");
					tcell = trow.createCell(3);
					tcell.setCellStyle(styleTipoLinha);
					tcell.setCellValue("Total");
					int i_bl_report_Jw_pse0053_descontos = 0;
					while (i_bl_report_Jw_pse0053_descontos < res_Jw_pse0053_descontos.size()) {
						portalbr.dbobj.view.Jw_pse0053_total_fechado t_jw_pse0053_descontos = (portalbr.dbobj.view.Jw_pse0053_total_fechado) res_Jw_pse0053_descontos.elementAt(i_bl_report_Jw_pse0053_descontos);
						trow = pse0053sheet.createRow(rowcount++);
						tcell = trow.createCell(0);
						tcell.setCellValue(t_jw_pse0053_descontos.getPro_numero() + " - " + t_jw_pse0053_descontos.getPro_nome());
						tcell = trow.createCell(1);
						tcell.setCellValue(t_jw_pse0053_descontos.getPares());
						tcell = trow.createCell(2);
						tcell.setCellValue(t_jw_pse0053_descontos.getPreco());
						tcell = trow.createCell(3);
						tcell.setCellValue(t_jw_pse0053_descontos.getTotal());
						valor_total_nota -= t_jw_pse0053_descontos.getTotal();
						i_bl_report_Jw_pse0053_descontos++;
					}
				}
			}
			rowcount = 0;
			wb.createSheet("Resumo Por Modelo");
			pse0053sheet = wb.getSheet("Resumo Por Modelo");
			trow = pse0053sheet.createRow(rowcount++);
			tcell = trow.createCell(0);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Codigo do Item");
			tcell = trow.createCell(1);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Descrição dos Produtos");			
			tcell = trow.createCell(2);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Linha");
			tcell = trow.createCell(3);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Referencia");
			tcell = trow.createCell(4);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Cabedal");
			tcell = trow.createCell(5);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Pares");
			tcell = trow.createCell(6);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Preço MO.");
			tcell = trow.createCell(7);
			tcell.setCellStyle(styleTipoLinha);
			tcell.setCellValue("Total");
			while (i_bl_report_Jw_pse0053_total_aberto < res_Jw_pse0053_total_aberto.size()) {
				trow = pse0053sheet.createRow(rowcount++);
				portalbr.dbobj.view.Jw_pse0053_total_aberto t_jw_pse0053_total_aberto = (portalbr.dbobj.view.Jw_pse0053_total_aberto) res_Jw_pse0053_total_aberto.elementAt(i_bl_report_Jw_pse0053_total_aberto);
		        codigo_item = t_jw_pse0053_total_aberto.getCodigo_item();
		        descricao_produtos = t_jw_pse0053_total_aberto.getDescricao_produtos();
		        linha = t_jw_pse0053_total_aberto.getLinha();
		        referencia = t_jw_pse0053_total_aberto.getReferencia();
		        cabedal = t_jw_pse0053_total_aberto.getCabedal();
		        pares1 = t_jw_pse0053_total_aberto.getPares();
		        preco1 = t_jw_pse0053_total_aberto.getPreco();
		        total1 = t_jw_pse0053_total_aberto.getTotal();
		        tcell = trow.createCell(0);
				tcell.setCellValue(codigo_item);
				tcell = trow.createCell(1);
				tcell.setCellValue(descricao_produtos);
				tcell = trow.createCell(2);
				tcell.setCellValue(linha);
				tcell = trow.createCell(3);
				tcell.setCellValue(referencia);
				tcell = trow.createCell(4);
				tcell.setCellValue(cabedal);
				tcell = trow.createCell(5);
				tcell.setCellValue(pares1);
				tcell = trow.createCell(6);
				tcell.setCellValue(preco1);
				tcell = trow.createCell(7);
				tcell.setCellValue(total1);		       
				i_bl_report_Jw_pse0053_total_aberto ++;
			}
			if(tipo.equalsIgnoreCase("R")){
				rowcount = 0;
				wb.createSheet("Notas Fiscais");
				pse0053sheet = wb.getSheet("Notas Fiscais");
				trow = pse0053sheet.createRow(rowcount++);
				tcell = trow.createCell(0);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Filial");
				tcell = trow.createCell(1);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Nota Fiscal");
				tcell = trow.createCell(2);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Série");
				tcell = trow.createCell(3);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Remessas");
				while (i_bl_report_Jw_pse0053_notas_fiscais < res_Jw_pse0053_notas_fiscais.size()) {
					trow = pse0053sheet.createRow(rowcount++);
			    	portalbr.dbobj.view.Jw_pse0053_notas_fiscais t_jw_pse0053_notas_fiscais = (portalbr.dbobj.view.Jw_pse0053_notas_fiscais)res_Jw_pse0053_notas_fiscais.elementAt(i_bl_report_Jw_pse0053_notas_fiscais);
			    	pro_numero2 = t_jw_pse0053_notas_fiscais.getPro_numero();
			    	fil_filial = t_jw_pse0053_notas_fiscais.getFil_filial()==null?"":t_jw_pse0053_notas_fiscais.getFil_filial();
			    	nfs_nmro = t_jw_pse0053_notas_fiscais.getNfs_nmro();
	  	        	nfs_serie = t_jw_pse0053_notas_fiscais.getNfs_serie()==null?"":t_jw_pse0053_notas_fiscais.getNfs_serie();
	  	        	remessas = t_jw_pse0053_notas_fiscais.getRemessas()==null?"":t_jw_pse0053_notas_fiscais.getRemessas();
	  	        	tcell = trow.createCell(0);
					tcell.setCellValue(fil_filial);
					tcell = trow.createCell(1);
					tcell.setCellValue(nfs_nmro);
					tcell = trow.createCell(2);
					tcell.setCellValue(nfs_serie);
					tcell = trow.createCell(3);
					tcell.setCellValue(remessas);
					i_bl_report_Jw_pse0053_notas_fiscais ++;
				}	
				trow = pse0053sheet.createRow(rowcount++);
				tcell = trow.createCell(2);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue("Total Nota: ");
				tcell = trow.createCell(3);
				tcell.setCellStyle(styleTipoLinha);
				tcell.setCellValue(com.egen.util.text.FormatNumber.format(valor_total_nota, "##,##0.00"));
			}
			wb.write(fos);
			fos.close();
			gerou = true;
			if (gerou) {
				try {
					retorno = parametros.retornaParametro("diretorio_link_pdf")	+ nomeArquivo.toString();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			} else {
				retorno = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	
	
	public String geraExcelRemessas(javax.servlet.http.HttpSession session) throws Exception {
		Query queryUtil = new Query();
		String query = (String)session.getAttribute("pse0053_m_query");
		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			HSSFSheet testsheet = null;
			nomeArquivo.append("pse0053").append(util.rand.Palavra.geraPalavra()).append(".xls");
			stylecenterborda = wb.createCellStyle();
			stylecenterborda.setBorderBottom((short) 1);
			stylecenterborda.setAlignment((short) 2);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(query);
			rset = pstm.executeQuery();
			testsheet = wb.createSheet("pse0053");
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(0);
			tcell.setCellValue("Remessa");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(1);
			tcell.setCellValue("Talão");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(2);
			tcell.setCellValue("Linha");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(3);
			tcell.setCellValue("Referência");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(4);
			tcell.setCellValue("Cabedal");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(5);
			tcell.setCellValue("Cor");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(6);
			tcell.setCellValue("Processo");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(7);
			tcell.setCellValue("Pares");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(8);
			tcell.setCellValue("Data Pre Envio");
			tcell.setCellStyle(stylecenterborda);
			while (rset.next()) {
				++rowcount;
				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(0);
				tcell.setCellValue(rset.getInt("rem_nro"));
				tcell = trow.createCell(1);
				tcell.setCellValue(rset.getInt("tal_nro"));
				tcell = trow.createCell(2);
				String[] linRef =  (queryUtil.retorna("select cab_cdgo||'#'||cor_Cdgo abertura from talao t where t.tal_nro = "+rset.getInt("tal_nro")+"and t.rem_nro = " + rset.getInt("rem_nro"))).split("#");
				tcell.setCellValue(rset.getInt("lin_cdgo"));
				tcell = trow.createCell(3);
				tcell.setCellValue(rset.getInt("ref_cdgo"));
				tcell = trow.createCell(4);
				tcell.setCellValue(linRef[0]);
				tcell = trow.createCell(5);
				tcell.setCellValue(linRef[1]);
				tcell = trow.createCell(6);
				tcell.setCellValue(rset.getInt("pro_numero"));
				tcell = trow.createCell(7);
				tcell.setCellValue(rset.getInt("tal_pares"));
				tcell = trow.createCell(8);
				tcell.setCellValue(com.egen.util.text.FormatDate.format(rset.getTimestamp("data_pre_envio"), "dd/MM/yyyy HH:mm:ss"));
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
		retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		return retorno;
	}

}