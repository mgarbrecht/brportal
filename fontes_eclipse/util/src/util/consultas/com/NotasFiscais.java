package util.consultas.com;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

 public class NotasFiscais {

	public String geraExcel(String query, String tipo, String parametrosDespesas) throws Exception {

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
		String conhecimento = " ";
		String peso = " ";
		String valor_frete = " ";
		int planilha = 0;
		java.lang.String[] conhecimentos = null;
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			HSSFSheet testsheet = null;
			nomeArquivo.append("nf").append(util.rand.Palavra.geraPalavra()).append(".xls");
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
				// --------- Cabecalho ------------------------
				if (novaPlanilha) {
					if (tipo.equalsIgnoreCase("NF")) {
						int index = 0;
						testsheet = wb.createSheet("nf" + ++planilha);
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Número");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Série");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Código Linha");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Código Referência");
						tcell.setCellStyle(stylecenterborda);						
						tcell = trow.createCell(index++);
						tcell.setCellValue("Cabedal");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Cor");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Tamanho");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("ID");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Emissão");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Qtd. Vol.");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Valor Nota");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Valor Liq.");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Total Pares");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Taxa Dólar");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Chave NFE");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("NCM");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Desc. Mercadoria");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Vlr. Unit.");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Qtd. Pares");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Peso Liq. Nota");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Peso Bruto Nota");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("CFOP");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(index++);
						tcell.setCellValue("Seq. Item");
						tcell.setCellStyle(stylecenterborda);
						novaPlanilha = false;
					} else if (tipo.equalsIgnoreCase("R")) {
						testsheet = wb.createSheet("nf" + ++planilha);
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue("Número");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(1);
						tcell.setCellValue("Série");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(2);
						tcell.setCellValue("Código Linha");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(3);
						tcell.setCellValue("Código Referência");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(4);
						tcell.setCellValue("Emissão");
						tcell = trow.createCell(5);
						tcell.setCellValue("Qtd. Vol.");
						tcell = trow.createCell(6);
						tcell.setCellValue("Valor Nota");
						tcell = trow.createCell(7);
						tcell.setCellValue("Valor Liq.");
						tcell = trow.createCell(8);
						tcell.setCellValue("Total Pares");
						tcell = trow.createCell(9);
						tcell.setCellValue("Taxa Dólar");
						tcell = trow.createCell(10);
						tcell.setCellValue("Chave NFE");
						novaPlanilha = false;
					} else if (tipo.equalsIgnoreCase("id")) {
						testsheet = wb.createSheet("nf" + ++planilha);
						trow = testsheet.createRow(rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue("Número");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(1);
						tcell.setCellValue("Série");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(2);
						tcell.setCellValue("Código Linha");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(3);
						tcell.setCellValue("Código Referência");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(4);
						tcell.setCellValue("Cabedal");
						tcell = trow.createCell(5);
						tcell.setCellValue("Cor");
						tcell = trow.createCell(6);
						tcell.setCellValue("Tamanho");
						tcell = trow.createCell(7);
						tcell.setCellValue("ID");
						tcell = trow.createCell(8);
						tcell.setCellValue("Emissão");
						tcell = trow.createCell(9);
						tcell.setCellValue("Qtd. Vol.");
						tcell = trow.createCell(10);
						tcell.setCellValue("Valor Nota");
						tcell = trow.createCell(11);
						tcell.setCellValue("Valor Liq.");
						tcell = trow.createCell(12);
						tcell.setCellValue("Total Pares");
						tcell = trow.createCell(13);
						tcell.setCellValue("Taxa Dólar");
						tcell = trow.createCell(14);
						tcell.setCellValue("Chave NFE");
						tcell = trow.createCell(15);
						tcell.setCellValue("NCM");
						tcell = trow.createCell(16);
						tcell.setCellValue("Desc. Mercadoria");
						tcell = trow.createCell(17);
						tcell.setCellValue("Vlr. Unit.");
						tcell = trow.createCell(18);
						tcell.setCellValue("Qtd. Pares");
						tcell = trow.createCell(19);
						tcell.setCellValue("Peso Liq. Nota");
						tcell = trow.createCell(20);
						tcell.setCellValue("Peso Bruto Nota");
						tcell = trow.createCell(21);
						tcell.setCellValue("CFOP");
						tcell = trow.createCell(22);
						tcell.setCellValue("Seq. Item.");
						tcell = trow.createCell(23);
						tcell.setCellValue("qTrib");
						novaPlanilha = false;							
					} else if (tipo.equalsIgnoreCase("S")) { 
						tcell = null;
						trow = null;
						try {
							testsheet = wb.createSheet("nf" + ++planilha);
							trow = testsheet.createRow(rowcount);
							tcell = trow.createCell(0);
						} catch (Exception e) {
							e.printStackTrace();
						}
						tcell.setCellValue("Número");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(1);
						tcell.setCellValue("Empresa");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(2);
						tcell.setCellValue("Fil");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(3);
						tcell.setCellValue("Sigla Trans.");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(4);
						tcell.setCellValue("Cliente");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(5);
						tcell.setCellValue("Cidade");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(6);
						tcell.setCellValue("UF");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(7);
						tcell.setCellValue("Linha");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(8);
						tcell.setCellValue("Emissão");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(9);
						tcell.setCellValue("Qtd. Vol");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(10);
						tcell.setCellValue("Qtde Notas");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(11);
						tcell.setCellValue("Vlr. Nota");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(12);
						tcell.setCellValue("Nro. Romaneio");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(13);
						tcell.setCellValue("Data Finalização Romaneio");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(14);
						tcell.setCellValue("Conhecimento");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(15);
						tcell.setCellValue("Peso");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(16);
						tcell.setCellValue("Peso Liq. Nota");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(17);
						tcell.setCellValue("Peso Bruto Nota");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(18);
						tcell.setCellValue("Vlr. Frete");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(19);
						tcell.setCellValue("Total Pares");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(20);
						tcell.setCellValue("Placa Veículo");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(21);
						tcell.setCellValue("Cubagem");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(22);
						tcell.setCellValue("Consignatário");
						tcell.setCellStyle(stylecenterborda);
						tcell = trow.createCell(23);
						tcell.setCellValue("Chave NFE");
						tcell.setCellStyle(stylecenterborda);
						novaPlanilha = false;
					}
				}

				// --------------------------------------------
				++rowcount;
				if (tipo.equalsIgnoreCase("NF")) {
					int index = 0;
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("nota"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("serie"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("linha_cdgo"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("ref_cdgo"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("cab_cdgo"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("cor_cdgo"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("tamanho"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("id"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("nfs_dtemis"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("nfs_qtdvol"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getDouble("nfs_vltot"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getDouble("valorliq"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("nfs_total_pares"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("taxa_dolar"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("chave_nfe"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("ncm"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("nfi_descricao"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getDouble("nfi_vlunit"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getDouble("total_pares"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getDouble("nfs_pesliq"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getDouble("nfs_pesbru"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getString("cfop"));
					tcell = trow.createCell(index++);
					tcell.setCellValue(rset.getInt("nfi_seqitem"));
				} else 	if (tipo.equalsIgnoreCase("R")) {
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(0);
					tcell.setCellValue(rset.getString("nfs_nmro"));
					tcell = trow.createCell(1);
					tcell.setCellValue(rset.getString("nfs_serie"));
					tcell = trow.createCell(2);
					tcell.setCellValue(rset.getInt("linha_cdgo"));
					tcell = trow.createCell(3);
					tcell.setCellValue(rset.getInt("ref_cdgo"));
					tcell = trow.createCell(4);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(rset.getDate("nfs_dtemis"), "dd/MM/yyyy"));
					tcell = trow.createCell(5);
					tcell.setCellValue(rset.getInt("nfs_qtdvol"));
					tcell = trow.createCell(6);
					tcell.setCellValue(rset.getDouble("nfs_vltot"));
					tcell = trow.createCell(7);
					tcell.setCellValue(rset.getDouble("nfs_vltot"));
					tcell = trow.createCell(8);
					tcell.setCellValue(rset.getInt("nfs_total_pares"));
					tcell = trow.createCell(9);
					tcell.setCellValue(rset.getDouble("taxa_dolar"));
					tcell = trow.createCell(10);
					tcell.setCellValue(rset.getString("chave_nfe"));
				} else if (tipo.equalsIgnoreCase("id")){
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(0);
					tcell.setCellValue(rset.getString("nfs_nmro"));
					tcell = trow.createCell(1);
					tcell.setCellValue(rset.getString("nfs_serie"));
					tcell = trow.createCell(2);
					tcell.setCellValue(rset.getInt("linha_cdgo"));
					tcell = trow.createCell(3);
					tcell.setCellValue(rset.getInt("ref_cdgo"));
					tcell = trow.createCell(4);
					tcell.setCellValue(rset.getInt("cab_cdgo"));
					tcell = trow.createCell(5);
					tcell.setCellValue(rset.getInt("cor_cdgo"));
					tcell = trow.createCell(6);
					tcell.setCellValue(rset.getString("tamanho"));
					tcell = trow.createCell(7);
					tcell.setCellValue(rset.getInt("id"));
					tcell = trow.createCell(8);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(rset.getDate("nfs_dtemis"), "dd/MM/yyyy"));
					tcell = trow.createCell(9);
					tcell.setCellValue(rset.getInt("nfs_qtdvol"));
					tcell = trow.createCell(10);
					tcell.setCellValue(rset.getDouble("nfs_vltot"));
					tcell = trow.createCell(11);
					tcell.setCellValue(rset.getDouble("nfs_vltot"));
					tcell = trow.createCell(12);
					tcell.setCellValue(rset.getInt("nfs_total_pares"));
					tcell = trow.createCell(13);
					tcell.setCellValue(rset.getDouble("taxa_dolar"));
					tcell = trow.createCell(14);
					tcell.setCellValue(rset.getString("chave_nfe"));
					tcell = trow.createCell(15);
					tcell.setCellValue(rset.getString("ncm"));
					tcell = trow.createCell(16);
					tcell.setCellValue(rset.getString("nfi_descricao"));
					tcell = trow.createCell(17);
					tcell.setCellValue(rset.getDouble("nfi_vlunit"));
					tcell = trow.createCell(18);
					tcell.setCellValue(rset.getDouble("total_pares"));
					tcell = trow.createCell(19);
					tcell.setCellValue(rset.getDouble("nfs_pesliq"));
					tcell = trow.createCell(20);
					tcell.setCellValue(rset.getDouble("nfs_pesbru"));
					tcell = trow.createCell(21);
					tcell.setCellValue(rset.getString("cfop"));
					tcell = trow.createCell(22);
					tcell.setCellValue(rset.getString("nfi_seqitem"));
					tcell = trow.createCell(23);
					tcell.setCellValue(rset.getString("qtrib"));
				} else if (tipo.equalsIgnoreCase("S")) {
					trow = testsheet.createRow(rowcount);
					tcell = trow.createCell(0);
					tcell.setCellValue(rset.getString("nota"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(1);
					tcell.setCellValue(rset.getString("emp_empresa"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(2);
					tcell.setCellValue(rset.getString("fil_filial"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(3);
					tcell.setCellValue(rset.getString("sigla_trans"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(4);
					tcell.setCellValue(rset.getString("cc"));
					tcell = trow.createCell(5);
					tcell.setCellValue(rset.getString("ecl_cdad"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(6);
					tcell.setCellValue(rset.getString("est_unifed"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(7);
					tcell.setCellValue(rset.getString("linha"));
					tcell = trow.createCell(8);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(rset.getDate("nfs_dtemis"), "dd/MM/yyyy"));
					tcell = trow.createCell(9);
					tcell.setCellValue(rset.getInt("nfs_qtdvol"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(10);
					tcell.setCellValue(rset.getInt("qtde_de_notas"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(11);
					tcell.setCellValue(rset.getDouble("nfs_vltot"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(12);
					tcell.setCellValue(rset.getString("nro_romaneio_embarque"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(13);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(rset.getTimestamp("finalizacao_romaneio"), "dd/MM/yyyy HH:mm:ss")); // ok
					tcell.setCellStyle(stylecenter);
					// ---- Conhecimentos ----
					if (rset.getString("conhecimentos") != null) {
						conhecimentos = rset.getString("conhecimentos").split("#");
						conhecimento = conhecimentos[0];
						peso = Double.parseDouble(conhecimentos[1].replace(",", ".")) + "";
						valor_frete = Double.parseDouble(conhecimentos[2].replace(",", ".")) + "";
					} else {
						conhecimento = " ";
						peso = " ";
						valor_frete = " ";
					}
					// -----------------------
					tcell = trow.createCell(14);
					tcell.setCellValue(conhecimento);
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(15);
					tcell.setCellValue(Double.parseDouble(peso));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(16);
					tcell.setCellValue(rset.getDouble("nfs_pesliq"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(17);
					tcell.setCellValue(rset.getDouble("nfs_pesbru"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(18);
					tcell.setCellValue(Double.parseDouble(valor_frete));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(19);
					tcell.setCellValue(rset.getInt(18));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(20);
					tcell.setCellValue(rset.getString(20));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(21);
					tcell.setCellValue(rset.getDouble(21));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(22);
					tcell.setCellValue(rset.getString("cons"));
					tcell.setCellStyle(stylecenter);
					tcell = trow.createCell(23);
					tcell.setCellValue(rset.getString("chave_nfe"));
					tcell.setCellStyle(stylecenter);
				}
			}
			
			if (tipo.equalsIgnoreCase("id")) {
				if (gerou) {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					StringBuilder sbDespesas = new StringBuilder();
					sbDespesas.append(" SELECT df.descricao_despesa_financeira despesa_financeira ");
					sbDespesas.append("      , dfp.valor_despesa_financeira    valor ");
					sbDespesas.append("   FROM despesas_faturas_proformas dfp ");
					sbDespesas.append("      , despesas_financeiras df ");
					sbDespesas.append("  WHERE dfp.empresa_fatura_proforma = '01' ");
					sbDespesas.append("    AND dfp.codigo_despesa_financeira = df.codigo_despesa_financeira ");
					sbDespesas.append("    AND NVL(dfp.valor_despesa_financeira, 0) > 0 ");
					sbDespesas.append(parametrosDespesas);
					pstm = j.getConn().prepareStatement(sbDespesas.toString());
					rset = pstm.executeQuery();
					boolean cabecalho = false;
					while (rset.next()) {
						if (!cabecalho) {
							trow = testsheet.createRow(++rowcount);
							tcell = trow.createCell(0);
							tcell.setCellValue("Despesa Financeira");
							tcell = trow.createCell(1);
							tcell.setCellValue("Valor");
						}
						trow = testsheet.createRow(++rowcount);
						tcell = trow.createCell(0);
						tcell.setCellValue(rset.getString("despesa_financeira"));
						tcell = trow.createCell(1);
						tcell.setCellValue(rset.getDouble("valor"));
						cabecalho = true;
					}
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
}