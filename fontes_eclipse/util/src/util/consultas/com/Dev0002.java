package util.consultas.com;

import org.apache.poi.hssf.usermodel.*;
import java.io.*;

public class Dev0002 {

	public String geraExcel(String p_situacao
			               ,String p_marca
			               ,String p_preco
			               ,String p_livro_alternativo
			               ,String p_atraso_fim
			               ,String p_atraso
			               ,String p_regional
			               ,String p_rep
			               ,String p_unid_negocio
			               ,String p_cliente
			               ,String p_grupo
			               ,String p_linha
			               ,String p_ind_aberto_fechado
			               ,String p_tra
			               ,String p_fil_filial
			               ,String p_nfs_nmro
			               ,String p_perfil_representante) throws Exception {
	
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		 
		String p_livro = "null";
		if (p_atraso.equals("null")) {
			p_atraso = "30";
		}
		if (p_atraso_fim.equals("null")) {
			p_atraso_fim = "0";
		}
		if (p_unid_negocio.equals("null")) {
			p_unid_negocio = "";
		} else {
			p_unid_negocio = " AND lin.unid_negocio = NVL('" + p_unid_negocio+ "', lin.unid_negocio) ";
		}
		if (p_grupo.equals("null")) {
			p_grupo = "";
		} else {
			p_grupo = " AND exists (select 1 from grupo_economico gec where gec.cli_cdgo = cli.cli_cdgo and gec.gre_grupo = '"	+ p_grupo + "')";
		}

		if (p_linha.equals("null")) {
			p_linha = "";
		} else {
			p_linha = " where exists (select null from nf_item i where i.emp_empresa = n.emp_empresa and i.fil_filial = n.fil_filial and i.nfs_nmro = n.nfs_nmro and i.nfs_serie = n.nfs_serie and nvl(i.lin_cdgo, null) = "+ p_linha + ") ";
		}
		if (p_ind_aberto_fechado.equalsIgnoreCase("T")) {
			p_ind_aberto_fechado = "";
		} else {
			p_ind_aberto_fechado = " AND nvl(lin.ind_aberto_fechado, 'F') = NVL('"+ p_ind_aberto_fechado + "', lin.ind_aberto_fechado) ";
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("dev0002");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
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
		int contadorTamanho = 0;
		int contadorUnidade = 0;
		java.sql.PreparedStatement pstmp = null;
		java.sql.ResultSet rsetp = null;
		int contadorPares = 0;

		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		int rowcount = 0;
		int contador = 0;
		int totalPares = 0;
		int totalParesGeral = 0;
		String retorno = "";
		boolean gerou = false;

		String unidadeNegocio = null;
		String unidadeNegocioAnterior = null;

		String modelo = null;
		String modeloAnterior = null;

		String nota = null;
		String notaAnterior = null;
		String diretorioImagens = parametros.retornaParametro("diretorio_imagens_report");
		try {
			nomeArquivo.append("dev0002").append(util.rand.Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("dev0002");
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
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			trow = testsheet.createRow(rowcount);
			j = new com.egen.util.jdbc.JdbcUtil();
			sb.append(" SELECT DISTINCT ");
			sb.append("        une.unn_descri ");
			sb.append("      , dvm.data_cad ");
			sb.append("      , nfi.lin_cdgo ");
			sb.append("      , nfi.ref_cdgo ");
			sb.append("      , cab.cab_cdgo || '-' || cab.cab_desc cab_cdgo ");
			sb.append("      , cor.cor_cdgo || '-' || cor.cor_desc cor_cdgo ");
			sb.append("      , 99 gde_cdgo ");
			sb.append("      , itd.total_pares ite_qtde ");
			sb.append("      , DECODE("+ p_preco+ ", -2, nfi.nfi_vlunit, -1, NULL, DECODE(NVL(fct_busca_preco_livro("+ p_livro	+ ", TRUNC(SYSDATE), nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo), 0), 0, fct_busca_preco_livro("	+ p_livro_alternativo+ ", TRUNC(SYSDATE), nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo), fct_busca_preco_livro("+ p_livro+ ", TRUNC(SYSDATE), nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo))) ite_prco ");
			sb.append("      , fct_mask_modelo(nfi.lin_cdgo, nfi.ref_cdgo) modelo ");
			sb.append("      , itd.nfs_emp_empresa ");
			sb.append("      , itd.nfs_fil_filial ");
			sb.append("      , itd.nfs_numero ");
			sb.append("      , itd.nfs_serie ");
			sb.append("      , itd.nfi_seqitem ");
			sb.append("      , itd.nfs_emp_empresa||itd.nfs_fil_filial||itd.nfs_numero||itd.nfs_serie ");
			sb.append("      , nfs.nfs_dtemis ");
			sb.append("      , nfs.nfs_nmro ");
			sb.append("      , fct_retorna_fit_imagem(nfi.lin_cdgo, nfi.ref_cdgo) imagem ");
			sb.append("   FROM nf_item nfi ");
			sb.append("      , (SELECT * FROM nf_saida n " + p_linha + ") nfs ");
			sb.append("      , numeracoes_itens_devolucoes nid ");
			sb.append("      , itens_devolucoes itd ");
			sb.append("      , devolucoes_mercadorias dvm ");
			sb.append("      , ecl ");
			sb.append("      , cli ");
			sb.append("      , tra ");
			sb.append("      , ficha_tec fit ");
			sb.append("      , cabedal cab ");
			sb.append("      , ref ");
			sb.append("      , cor cor ");
			sb.append("      , lin lin ");
			sb.append("      , rep ");
			sb.append("      , regionais_vendas rev ");
			sb.append("      , uni_negocio une ");
			sb.append("      , marcas_produtos mp ");
			sb.append("  WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
			sb.append("    AND nfi.fil_filial = itd.nfs_fil_filial ");
			sb.append("    AND nfi.nfs_nmro = itd.nfs_numero ");
			sb.append("    AND nfi.nfs_serie = itd.nfs_serie ");
			sb.append("    AND nfi.nfi_seqitem = itd.nfi_seqitem ");
			sb.append("    AND nfs.emp_empresa = dvm.nfs_emp_empresa ");
			sb.append("    AND nfs.fil_filial = dvm.nfs_fil_filial ");
			sb.append("    AND nfs.nfs_nmro = dvm.nfs_numero ");
			sb.append("    AND nfs.nfs_serie = dvm.nfs_serie ");
			sb.append("    AND NVL(nfs.cli_cdgo, NULL) = NVL(NULL, nfs.cli_cdgo) ");
			sb.append("    AND nid.devmerc_codigo = itd.devmerc_codigo ");
			sb.append("    AND nid.itdev_sequencia = itd.sequencia ");
			sb.append("    AND itd.devmerc_codigo = dvm.codigo ");
			sb.append("    AND dvm.sitdev_codigo = " + p_situacao);
			sb.append("    AND dvm.motdev_codigo != 54 ");
			sb.append("    AND dvm.data_cad >= TRUNC(SYSDATE) - " + p_atraso);
			sb.append("    AND dvm.data_cad <= TRUNC(SYSDATE) - "+ p_atraso_fim);
			sb.append("    AND dvm.tra_cdgo = NVL(" + p_tra	+ ", dvm.tra_cdgo) ");
			sb.append("    AND ecl.cli_cdgo = nfs.cli_cdgo ");
			sb.append("    AND ecl.esc_seqn = nfs.esc_seqn ");
			sb.append("    AND ecl.ned_cdgo IN ('UNI', 'ENT') ");
			sb.append("    AND cli.cli_cdgo = ecl.cli_cdgo ");
			sb.append("    AND tra.tra_cdgo = dvm.tra_cdgo ");
			sb.append("    AND fit.lin_cdgo = nfi.lin_cdgo ");
			sb.append("    AND fit.ref_cdgo = nfi.ref_cdgo ");
			sb.append("    AND fit.cab_cdgo = nfi.cab_cdgo ");
			sb.append("    AND EXISTS (SELECT MAX(tec.fit_versao) ");
			sb.append("                  FROM ficha_tec tec ");
			sb.append("                 WHERE tec.lin_cdgo = fit.lin_cdgo ");
			sb.append("                   AND tec.ref_cdgo = fit.ref_cdgo ");
			sb.append("                   AND tec.cab_cdgo = fit.cab_cdgo HAVING MAX(tec.fit_versao) = fit.fit_versao) ");
			sb.append("    AND cab.cab_cdgo = nfi.cab_cdgo ");
			sb.append("    AND ref.lin_cdgo = nfi.lin_cdgo ");
			sb.append("    AND ref.ref_cdgo = nfi.ref_cdgo ");
			sb.append("    AND cor.cor_cdgo = nid.cor_cdgo ");
			sb.append("    AND lin.lin_cdgo = ref.lin_cdgo ");
			sb.append("    AND rep.rep_cdgo = nfs.rep_cdgo ");
			sb.append("    AND rep.codigo_regional = nvl(" + p_regional + ", rep.codigo_regional) ");
			sb.append("    AND rev.codigo_regional = rep.codigo_regional ");
			sb.append("    AND une.unn_codigo = lin.unid_negocio ");
			sb.append("    AND mp.codigo_marca = ref.codigo_marca ");
			sb.append("    AND mp.status = 'A' ");
			sb.append("    AND mp.codigo_marca = NVL(" + p_marca + ", mp.codigo_marca) ");
			sb.append("    AND NVL(nfs.cli_cdgo, NULL) = NVL(" + p_cliente	+ ", nfs.cli_cdgo) ");
			
			if(p_perfil_representante.equalsIgnoreCase("N")){
				sb.append(" AND NVL(nfs.rep_cdgo, NULL) = NVL(" + p_rep	+ ", nfs.rep_cdgo) ");
			} else {
				sb.append(" AND NVL(rep.codigo_regional, NULL) = (SELECT codigo_regional ");
				sb.append(" 	                                    FROM rep ");
				sb.append("            	                           WHERE rep_cdgo = '"+p_rep+"') ");
				sb.append("	AND EXISTS (SELECT 1 ");
				sb.append("	              FROM representante_marca rp ");
				sb.append("	             WHERE rp.situacao = 'A' ");
				sb.append("                AND rp.codigo_representante = '"+p_rep+"' ");
				sb.append("	               AND rp.marca_produto = mp.codigo_marca) ");				
			}
			
			sb.append("    AND NVL(nfs.fil_filial, NULL) = NVL(" + p_fil_filial	+ ", nfs.fil_filial) ");
			if((!(p_nfs_nmro.equals("null")))){
				sb.append("    AND NVL(nfs.nfs_nmro, NULL) IN (" + p_nfs_nmro	+ ") ");	
			}
			sb.append(p_unid_negocio);
			sb.append(p_grupo);
			sb.append(p_ind_aberto_fechado);
			sb.append("  ORDER BY unn_descri ");
			sb.append("         , nfs.nfs_dtemis ");
			sb.append("         , nfs.nfs_nmro ");
			sb.append("         , dvm.data_cad ");
			sb.append("         , lin_cdgo ");
			sb.append("         , ref_cdgo ");
			sb.append("         , cab_cdgo ");
			sb.append("         , cor_cdgo ");
			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				if (contadorUnidade == 0) {
					unidadeNegocio = rset.getString(1);
					unidadeNegocioAnterior = rset.getString(1);
					trow = testsheet.createRow(rowcount++);
					tcell = trow.createCell(0);
					tcell.setCellValue("Unidade Negócio :");
					tcell = trow.createCell(1);
					tcell.setCellValue(rset.getString(1));
					unidadeNegocio = rset.getString(1);
					unidadeNegocioAnterior = unidadeNegocio;
					contadorUnidade++;
				}
				unidadeNegocio = rset.getString(1);
				modelo = rset.getString(10);
				nota = rset.getString(16);

				if ((modelo == null || (!modelo.equals(modeloAnterior)))
						|| (nota == null || (!nota.equals(notaAnterior)))) {

					if (contador > 0) {
						trow = testsheet.createRow(++rowcount);
						tcell = trow.createCell(4);
						tcell.setCellValue("Total pares NF:");
						tcell = trow.createCell(5);
						tcell.setCellValue(totalPares);
						totalParesGeral += totalPares;
						totalPares = 0;
					}

					if (unidadeNegocio == null	|| (!unidadeNegocio.equals(unidadeNegocioAnterior))) {
						unidadeNegocio = rset.getString(1);
						unidadeNegocioAnterior = rset.getString(1);
						trow = testsheet.createRow(rowcount += 2);
						tcell = trow.createCell(0);
						tcell.setCellValue("Unidade Negócio :");
						tcell = trow.createCell(1);
						tcell.setCellValue(rset.getString(1));
						unidadeNegocio = rset.getString(1);
						unidadeNegocioAnterior = unidadeNegocio;
						contadorUnidade++;
					}
					trow = testsheet.createRow(rowcount = rowcount + 2);
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

					HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) (0), (rowcount), (short) (1), rowcount + 3);
					int index = wb.addPicture(img_bytes.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG);
					patriarch.createPicture(anchor, index);
					anchor.setAnchorType(2);
					tcell = trow.createCell(0);
					tcell.setCellValue("Foto");
					tcell = trow.createCell(1);
					tcell.setCellValue("Linha");
					tcell = trow.createCell(2);
					tcell.setCellValue("Referencia");
					tcell = trow.createCell(3);
					tcell.setCellValue("Cabedal");
					tcell = trow.createCell(4);
					tcell.setCellValue("Cor");
					tcell = trow.createCell(5);
					tcell.setCellValue("Pares");
					tcell = trow.createCell(6);
					tcell.setCellValue("Preço");

					modelo = rset.getString(10);
					modeloAnterior = modelo;

					nota = rset.getString(16);
					notaAnterior = nota;
					// ------------ Tamanhos ------------------
					StringBuilder sbt = new StringBuilder();
					sbt.append(" SELECT DISTINCT nid.numeracao qtp_nume ");
					sbt.append("   FROM nf_item nfi ");
					sbt.append("      , numeracoes_itens_devolucoes nid ");
					sbt.append("      , itens_devolucoes itd ");
					sbt.append("      , devolucoes_mercadorias dvm ");
					sbt.append("  WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
					sbt.append("    AND nfi.fil_filial = itd.nfs_fil_filial ");
					sbt.append("    AND nfi.nfs_nmro = itd.nfs_numero ");
					sbt.append("    AND nfi.nfs_serie = itd.nfs_serie ");
					sbt.append("    AND nfi.nfi_seqitem = itd.nfi_seqitem ");
					sbt.append("    AND nid.devmerc_codigo = itd.devmerc_codigo ");
					sbt.append("    AND nid.itdev_sequencia = itd.sequencia ");
					sbt.append("    AND itd.devmerc_codigo = dvm.codigo ");
					sbt.append("    AND dvm.motdev_codigo != 54 ");
					sbt.append("    AND nfi.emp_empresa = '"+ rset.getString(11) + "' ");
					sbt.append("    AND nfi.fil_filial = '"+ rset.getString(12) + "' ");
					sbt.append("    AND nfi.nfs_nmro = " + rset.getInt(13));
					sbt.append("    AND nfi.nfs_serie = '" + rset.getString(14) + "' ");
					sbt.append("  ORDER BY qtp_nume ");

					pstmt = j.getConn().prepareStatement(sbt.toString());
					rsett = pstmt.executeQuery();
					contadorTamanho = 1;
					while (rsett.next()) {
						tcell = trow.createCell(6 + contadorTamanho++);
						tcell.setCellValue(rsett.getString(1));
						tcell.setCellStyle(styleGrade);
					}
					if (rsett != null) {
						rsett.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				}
				// -----
				trow = testsheet.createRow(++rowcount);
				tcell = trow.createCell(1);
				tcell.setCellValue(rset.getString(3));
				tcell = trow.createCell(2);
				tcell.setCellValue(rset.getString(4));
				tcell = trow.createCell(3);
				tcell.setCellValue(rset.getString(5));
				tcell = trow.createCell(4);
				tcell.setCellValue(rset.getString(6));
				tcell = trow.createCell(5);
				tcell.setCellValue(rset.getInt(8));
				tcell = trow.createCell(6);
				tcell.setCellValue(rset.getDouble(9));
				// ------------ Pares --------------
				StringBuilder sbp = new StringBuilder();
				sbp.append(" SELECT SUM(pares) pares ");
				sbp.append("   FROM (SELECT DISTINCT ");
				sbp.append("                nid.numeracao ");
				sbp.append("              , 0 pares ");
				sbp.append("           FROM nf_item nfi ");
				sbp.append("              , numeracoes_itens_devolucoes nid ");
				sbp.append("              , itens_devolucoes itd ");
				sbp.append("              , devolucoes_mercadorias dvm ");
				sbp.append("          WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
				sbp.append("            AND nfi.fil_filial = itd.nfs_fil_filial ");
				sbp.append("            AND nfi.nfs_nmro = itd.nfs_numero ");
				sbp.append("            AND nfi.nfs_serie = itd.nfs_serie ");
				sbp.append("            AND nfi.nfi_seqitem = itd.nfi_seqitem ");
				sbp.append("            AND nid.devmerc_codigo = itd.devmerc_codigo ");
				sbp.append("            AND nid.itdev_sequencia = itd.sequencia ");
				sbp.append("            AND itd.devmerc_codigo = dvm.codigo ");
				sbp.append("            AND dvm.motdev_codigo != 54 ");
				sbp.append("            AND nfi.emp_empresa = '"+ rset.getString(11) + "' ");
				sbp.append("            AND nfi.fil_filial = '"+ rset.getString(12) + "' ");
				sbp.append("            AND nfi.nfs_nmro = " + rset.getInt(13));
				sbp.append("            AND nfi.nfs_serie = '"+ rset.getString(14) + "' ");
				sbp.append("         UNION ");
				sbp.append("         SELECT nid.numeracao ");
				sbp.append("              , SUM(nid.total_pares) pares ");
				sbp.append("           FROM nf_item nfi ");
				sbp.append("              , numeracoes_itens_devolucoes nid ");
				sbp.append("              , itens_devolucoes itd ");
				sbp.append("              , devolucoes_mercadorias dvm ");
				sbp.append("          WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
				sbp.append("            AND nfi.fil_filial = itd.nfs_fil_filial ");
				sbp.append("            AND nfi.nfs_nmro = itd.nfs_numero ");
				sbp.append("            AND nfi.nfs_serie = itd.nfs_serie ");
				sbp.append("            AND nfi.nfi_seqitem = itd.nfi_seqitem ");
				sbp.append("            AND nid.devmerc_codigo = itd.devmerc_codigo ");
				sbp.append("            AND nid.itdev_sequencia = itd.sequencia ");
				sbp.append("            AND itd.devmerc_codigo = dvm.codigo ");
				sbp.append("            AND dvm.motdev_codigo != 54 ");
				sbp.append("            AND nfi.emp_empresa = '"+ rset.getString(11) + "' ");
				sbp.append("            AND nfi.fil_filial = '"	+ rset.getString(12) + "' ");
				sbp.append("            AND nfi.nfs_nmro = " + rset.getInt(13));
				sbp.append("            AND nfi.nfs_serie = '"+ rset.getString(14) + "' ");
				sbp.append("            AND nfi.nfi_seqitem = "+ rset.getString(15));
				sbp.append("          GROUP BY nid.numeracao) ");
				sbp.append("  GROUP BY numeracao ");
				pstmp = j.getConn().prepareStatement(sbp.toString());
				rsetp = pstmp.executeQuery();
				contadorPares = 1;
				while (rsetp.next()) {
					tcell = trow.createCell(6 + contadorPares++);
					if (rsetp.getInt(1) > 0) {
						tcell.setCellValue(rsetp.getInt(1));
						tcell.setCellStyle(styleGrade);
						totalPares += rsetp.getInt(1);

					}
				}
				if (rsetp != null) {
					rsetp.close();
				}
				if (pstmp != null) {
					pstmp.close();
				}
				// -------------------------------------------------------------------------
				contador++;
			}

			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(4);
			tcell.setCellValue("Total pares NF:");
			tcell = trow.createCell(5);
			tcell.setCellValue(totalPares);
			totalParesGeral += totalPares;

			rowcount += 2;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(4);
			tcell.setCellValue("Total Geral:");
			tcell = trow.createCell(5);
			tcell.setCellValue(totalParesGeral);

			wb.write(fos);
			fos.close();
			gerou = true;
		} catch (IOException ioe) {
			ioe.printStackTrace(System.out);
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
			retorno = parametros.retornaParametro("diretorio_link_pdf")	+ nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}


	public String geraExcelAgrupado(String p_situacao
			                       ,String p_marca
			                       ,String p_preco
			                       ,String p_livro_alternativo
			                       ,String p_atraso_fim
			                       ,String p_atraso
			                       ,String p_regional
			                       ,String p_rep
			                       ,String p_unid_negocio
			                       ,String p_cliente
			                       ,String p_grupo
			                       ,String p_linha
			                       ,String p_ind_aberto_fechado
			                       ,String p_tra
			                       ,String p_fil_filial
			                       ,String p_nfs_nmro
			                       ,String p_perfil_representante) throws Exception {

		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String p_livro = "null";
		if (p_atraso.equals("null")) {
			p_atraso = "30";
		}
		if (p_atraso_fim.equals("null")) {
			p_atraso_fim = "0";
		}
		if (p_unid_negocio.equals("null")) {
			p_unid_negocio = "";
		} else {
			p_unid_negocio = " AND lin.unid_negocio = NVL('"+p_unid_negocio+"', lin.unid_negocio) ";
		}
		if (p_grupo.equals("null")) {
			p_grupo = "";
		} else {
			p_grupo = " AND exists (select 1 from grupo_economico gec where gec.cli_cdgo = cli.cli_cdgo and gec.gre_grupo = '"+ p_grupo + "')";
		}

		if (p_linha.equals("null")) {
			p_linha = "";
		} else {
			p_linha = " where exists (select null from nf_item i where i.emp_empresa = n.emp_empresa and i.fil_filial = n.fil_filial and i.nfs_nmro = n.nfs_nmro and i.nfs_serie = n.nfs_serie and nvl(i.lin_cdgo, null) = " + p_linha + ") ";
		}
		if (p_ind_aberto_fechado.equalsIgnoreCase("T")) {
			p_ind_aberto_fechado = "";
		} else {
			p_ind_aberto_fechado = " AND nvl(lin.ind_aberto_fechado, 'F') = NVL('" + p_ind_aberto_fechado + "', lin.ind_aberto_fechado) ";
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("dev0002");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
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
		int contadorTamanho = 0;
		int contadorUnidade = 0;
		java.sql.PreparedStatement pstmp = null;
		java.sql.ResultSet rsetp = null;
		int contadorPares = 0;

		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		int rowcount = 0;
		int contador = 0;
		int totalPares = 0;
		int totalParesGeral = 0;
		String retorno = "";
		boolean gerou = false;
		String unidadeNegocio = null;
		String unidadeNegocioAnterior = null;
		String modelo = null;
		String modeloAnterior = null;
		String diretorioImagens = parametros.retornaParametro("diretorio_imagens_report");
		try {
			nomeArquivo.append("dev0002").append(util.rand.Palavra.geraPalavra()).append(".xls");
			HSSFSheet sheet = wb.getSheet("dev0002");
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

			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());

			trow = testsheet.createRow(rowcount);
			j = new com.egen.util.jdbc.JdbcUtil();
			sb.append(" SELECT DISTINCT ");
			sb.append("        une.unn_descri ");
			sb.append("      , dvm.data_cad ");
			sb.append("      , nfi.lin_cdgo ");
			sb.append("      , nfi.ref_cdgo ");
			sb.append("      , cab.cab_cdgo || '-' || cab.cab_desc cab_cdgo ");
			sb.append("      , cor.cor_cdgo || '-' || cor.cor_desc cor_cdgo ");
			sb.append("      , 99 gde_cdgo ");
			sb.append("      , itd.total_pares ite_qtde ");
			sb.append("      , DECODE("+ p_preco+ ", -2, nfi.nfi_vlunit, -1, NULL, DECODE(NVL(fct_busca_preco_livro("+ p_livro+ ", TRUNC(SYSDATE), nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo), 0), 0, fct_busca_preco_livro("+ p_livro_alternativo+ ", TRUNC(SYSDATE), nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo), fct_busca_preco_livro("+ p_livro+ ", TRUNC(SYSDATE), nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo))) ite_prco ");
			sb.append("      , fct_mask_modelo(nfi.lin_cdgo, nfi.ref_cdgo) modelo ");
			sb.append("      , itd.nfs_emp_empresa ");
			sb.append("      , itd.nfs_fil_filial ");
			sb.append("      , 0 itd.nfs_numero ");
			sb.append("      , 0 itd.nfs_serie ");
			sb.append("      , itd.nfi_seqitem ");
			sb.append("      , itd.nfs_emp_empresa||itd.nfs_fil_filial||itd.nfs_numero||itd.nfs_serie ");
			sb.append("      , nfs.nfs_dtemis ");
			sb.append("      , 0 nfs.nfs_nmro ");
			sb.append("      , brio.fct_retorna_fit_imagem(nfi.lin_cdgo, nfi.ref_cdgo) imagem ");
			sb.append("   FROM nf_item nfi ");
			sb.append("      , (SELECT * FROM nf_saida n " + p_linha + ") nfs ");
			sb.append("      , numeracoes_itens_devolucoes nid ");
			sb.append("      , itens_devolucoes itd ");
			sb.append("      , devolucoes_mercadorias dvm ");
			sb.append("      , ecl ");
			sb.append("      , cli ");
			sb.append("      , tra ");
			sb.append("      , ficha_tec fit ");
			sb.append("      , cabedal cab ");
			sb.append("      , ref ");
			sb.append("      , cor cor ");
			sb.append("      , lin lin ");
			sb.append("      , rep ");
			sb.append("      , regionais_vendas rev ");
			sb.append("      , uni_negocio une ");
			sb.append("      , marcas_produtos mp ");
			sb.append("  WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
			sb.append("    AND nfi.fil_filial = itd.nfs_fil_filial ");
			sb.append("    AND nfi.nfs_nmro = itd.nfs_numero ");
			sb.append("    AND nfi.nfs_serie = itd.nfs_serie ");
			sb.append("    AND nfi.nfi_seqitem = itd.nfi_seqitem ");
			sb.append("    AND nfs.emp_empresa = dvm.nfs_emp_empresa ");
			sb.append("    AND nfs.fil_filial = dvm.nfs_fil_filial ");
			sb.append("    AND nfs.nfs_nmro = dvm.nfs_numero ");
			sb.append("    AND nfs.nfs_serie = dvm.nfs_serie ");
			sb.append("    AND NVL(nfs.cli_cdgo, NULL) = NVL(NULL, nfs.cli_cdgo) ");
			sb.append("    AND nid.devmerc_codigo = itd.devmerc_codigo ");
			sb.append("    AND nid.itdev_sequencia = itd.sequencia ");
			sb.append("    AND itd.devmerc_codigo = dvm.codigo ");
			sb.append("    AND dvm.sitdev_codigo = " + p_situacao);
			sb.append("    AND dvm.motdev_codigo != 54 ");
			sb.append("    AND dvm.data_cad >= TRUNC(SYSDATE) - " + p_atraso);
			sb.append("    AND dvm.data_cad <= TRUNC(SYSDATE) - " + p_atraso_fim);
			sb.append("    AND dvm.tra_cdgo = NVL(" + p_tra	+ ", dvm.tra_cdgo) ");
			sb.append("    AND ecl.cli_cdgo = nfs.cli_cdgo ");
			sb.append("    AND ecl.esc_seqn = nfs.esc_seqn ");
			sb.append("    AND ecl.ned_cdgo IN ('UNI', 'ENT') ");
			sb.append("    AND cli.cli_cdgo = ecl.cli_cdgo ");
			sb.append("    AND tra.tra_cdgo = dvm.tra_cdgo ");
			sb.append("    AND fit.lin_cdgo = nfi.lin_cdgo ");
			sb.append("    AND fit.ref_cdgo = nfi.ref_cdgo ");
			sb.append("    AND fit.cab_cdgo = nfi.cab_cdgo ");
			sb.append("    AND EXISTS (SELECT MAX(tec.fit_versao) ");
			sb.append("                  FROM ficha_tec tec ");
			sb.append("                 WHERE tec.lin_cdgo = fit.lin_cdgo ");
			sb.append("                   AND tec.ref_cdgo = fit.ref_cdgo ");
			sb.append("                   AND tec.cab_cdgo = fit.cab_cdgo HAVING MAX(tec.fit_versao) = fit.fit_versao) ");
			sb.append("    AND cab.cab_cdgo = nfi.cab_cdgo ");
			sb.append("    AND ref.lin_cdgo = nfi.lin_cdgo ");
			sb.append("    AND ref.ref_cdgo = nfi.ref_cdgo ");
			sb.append("    AND cor.cor_cdgo = nid.cor_cdgo ");
			sb.append("    AND lin.lin_cdgo = ref.lin_cdgo ");
			sb.append("    AND rep.rep_cdgo = nfs.rep_cdgo ");
			sb.append("    AND rep.codigo_regional = nvl(" + p_regional	+ ", rep.codigo_regional) ");
			sb.append("    AND rev.codigo_regional = rep.codigo_regional ");
			sb.append("    AND une.unn_codigo = lin.unid_negocio ");
			sb.append("    AND mp.codigo_marca = ref.codigo_marca ");
			sb.append("    AND mp.status = 'A' ");
			sb.append("    AND mp.codigo_marca = NVL(" + p_marca + ", mp.codigo_marca) ");
			sb.append("    AND NVL(nfs.cli_cdgo, NULL) = NVL(" + p_cliente + ", nfs.cli_cdgo) ");
			if(p_perfil_representante.equalsIgnoreCase("N")){
				sb.append(" AND NVL(nfs.rep_cdgo, NULL) = NVL(" + p_rep	+ ", nfs.rep_cdgo) ");
			} else {
				sb.append(" AND NVL(rep.codigo_regional, NULL) = (SELECT codigo_regional ");
				sb.append(" 	                                    FROM rep ");
				sb.append("            	                           WHERE rep_cdgo = '"+p_rep+"') ");
				sb.append("	AND EXISTS (SELECT 1 ");
				sb.append("	              FROM representante_marca rp ");
				sb.append("	             WHERE rp.situacao = 'A' ");
				sb.append("                AND rp.codigo_representante = '"+p_rep+"' ");
				sb.append("	               AND rp.marca_produto = mp.codigo_marca) ");				
			}
			sb.append("    AND NVL(nfs.fil_filial, NULL) = NVL(" + p_fil_filial + ", nfs.fil_filial) ");
			sb.append("    AND NVL(nfs.nfs_nmro, NULL) = NVL(" + p_nfs_nmro + ", nfs.nfs_nmro) ");
			sb.append(p_unid_negocio);
			sb.append(p_grupo);
			sb.append(p_ind_aberto_fechado);
			sb.append("  ORDER BY unn_descri ");
			sb.append("         , nfs.nfs_dtemis ");
			sb.append("         , nfs.nfs_nmro ");
			sb.append("         , dvm.data_cad ");
			sb.append("         , lin_cdgo ");
			sb.append("         , ref_cdgo ");
			sb.append("         , cab_cdgo ");
			sb.append("         , cor_cdgo ");
			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				// --------------------------------------------------------------------------------------
				if (contadorUnidade == 0) {
					unidadeNegocio = rset.getString(1);
					unidadeNegocioAnterior = rset.getString(1);
					trow = testsheet.createRow(rowcount++);
					tcell = trow.createCell(0);
					tcell.setCellValue("Unidade Negócio :");
					tcell = trow.createCell(1);
					tcell.setCellValue(rset.getString(1));
					unidadeNegocio = rset.getString(1);
					unidadeNegocioAnterior = unidadeNegocio;
					contadorUnidade++;
				}

				unidadeNegocio = rset.getString(1);
				modelo = rset.getString(10);

				if ((modelo == null || (!modelo.equals(modeloAnterior)))) {

					if (contador > 0) {
						trow = testsheet.createRow(++rowcount);
						tcell = trow.createCell(4);
						tcell.setCellValue("Total pares :");
						tcell = trow.createCell(5);
						tcell.setCellValue(totalPares);
						totalParesGeral += totalPares;
						totalPares = 0;
					}

					if (unidadeNegocio == null || (!unidadeNegocio.equals(unidadeNegocioAnterior))) {
						unidadeNegocio = rset.getString(1);
						unidadeNegocioAnterior = rset.getString(1);
						trow = testsheet.createRow(rowcount += 2);
						tcell = trow.createCell(0);
						tcell.setCellValue("Unidade Negócio :");
						tcell = trow.createCell(1);
						tcell.setCellValue(rset.getString(1));
						unidadeNegocio = rset.getString(1);
						unidadeNegocioAnterior = unidadeNegocio;
						contadorUnidade++;
					}

					trow = testsheet.createRow(rowcount = rowcount + 2);
					// -----
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

					HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,
							(short) (0), (rowcount), (short) (1), rowcount + 3);
					int index = wb.addPicture(img_bytes.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG);
					patriarch.createPicture(anchor, index);
					anchor.setAnchorType(2);
					// --------------------------------------------------------------------------------------
					tcell = trow.createCell(0);
					tcell.setCellValue("Foto");
					tcell = trow.createCell(1);
					tcell.setCellValue("Linha");
					tcell = trow.createCell(2);
					tcell.setCellValue("Referencia");
					tcell = trow.createCell(3);
					tcell.setCellValue("Cabedal");
					tcell = trow.createCell(4);
					tcell.setCellValue("Cor");
					tcell = trow.createCell(5);
					tcell.setCellValue("Pares");
					tcell = trow.createCell(6);
					tcell.setCellValue("Preço");
					modelo = rset.getString(10);
					modeloAnterior = modelo;
					// ------------ Tamanhos -------------
					StringBuilder sbt = new StringBuilder();
					sbt.append(" SELECT DISTINCT nid.numeracao qtp_nume ");
					sbt.append("   FROM nf_item nfi ");
					sbt.append("      , numeracoes_itens_devolucoes nid ");
					sbt.append("      , itens_devolucoes itd ");
					sbt.append("      , devolucoes_mercadorias dvm ");
					sbt.append("  WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
					sbt.append("    AND nfi.fil_filial = itd.nfs_fil_filial ");
					sbt.append("    AND nfi.nfs_nmro = itd.nfs_numero ");
					sbt.append("    AND nfi.nfs_serie = itd.nfs_serie ");
					sbt.append("    AND nfi.nfi_seqitem = itd.nfi_seqitem ");
					sbt.append("    AND nid.devmerc_codigo = itd.devmerc_codigo ");
					sbt.append("    AND nid.itdev_sequencia = itd.sequencia ");
					sbt.append("    AND itd.devmerc_codigo = dvm.codigo ");
					sbt.append("    AND dvm.motdev_codigo != 54 ");
					sbt.append("    AND nfi.emp_empresa = '"+ rset.getString(11)+ "' ");
					sbt.append("    AND nfi.fil_filial = '"+ rset.getString(12)+ "' ");
					sbt.append("    AND nfi.nfs_nmro = "+ rset.getInt(13));
					sbt.append("    AND nfi.nfs_serie = '"+ rset.getString(14)+ "' ");
					sbt.append("  ORDER BY qtp_nume ");

					pstmt = j.getConn().prepareStatement(sbt.toString());
					rsett = pstmt.executeQuery();
					contadorTamanho = 1;
					while (rsett.next()) {
						tcell = trow.createCell(6 + contadorTamanho++);
						tcell.setCellValue(rsett.getString(1));
						tcell.setCellStyle(styleGrade);
					}
					if (rsett != null) {
						rsett.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					// -------------------------------------------------------------------------
				}
				trow = testsheet.createRow(++rowcount);
				tcell = trow.createCell(1);
				tcell.setCellValue(rset.getString(3));
				tcell = trow.createCell(2);
				tcell.setCellValue(rset.getString(4));
				tcell = trow.createCell(3);
				tcell.setCellValue(rset.getString(5));
				tcell = trow.createCell(4);
				tcell.setCellValue(rset.getString(6));
				tcell = trow.createCell(5);
				tcell.setCellValue(rset.getInt(8));
				tcell = trow.createCell(6);
				tcell.setCellValue(rset.getDouble(9));
				// ------------ Pares ------------
				StringBuilder sbp = new StringBuilder();
				sbp.append(" SELECT SUM(pares) pares ");
				sbp.append("   FROM (SELECT DISTINCT nid.numeracao ");
				sbp.append("                       , 0 pares ");
				sbp.append("           FROM nf_item nfi ");
				sbp.append("              , numeracoes_itens_devolucoes nid ");
				sbp.append("              , itens_devolucoes itd ");
				sbp.append("              , devolucoes_mercadorias dvm ");
				sbp.append("          WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
				sbp.append("            AND nfi.fil_filial = itd.nfs_fil_filial ");
				sbp.append("            AND nfi.nfs_nmro = itd.nfs_numero ");
				sbp.append("            AND nfi.nfs_serie = itd.nfs_serie ");
				sbp.append("            AND nfi.nfi_seqitem = itd.nfi_seqitem ");
				sbp.append("            AND nid.devmerc_codigo = itd.devmerc_codigo ");
				sbp.append("            AND nid.itdev_sequencia = itd.sequencia ");
				sbp.append("            AND itd.devmerc_codigo = dvm.codigo ");
				sbp.append("            AND dvm.motdev_codigo != 54 ");
				sbp.append("            AND nfi.emp_empresa = '" + rset.getString(11) + "' ");
				sbp.append("            AND nfi.fil_filial = '"	+ rset.getString(12) + "' ");
				sbp.append("            AND nfi.nfs_nmro = " + rset.getInt(13));
				sbp.append("            AND nfi.nfs_serie = '" + rset.getString(14) + "' ");
				sbp.append("         UNION ");
				sbp.append("         SELECT nid.numeracao ");
				sbp.append("              , SUM(nid.total_pares) pares ");
				sbp.append("           FROM nf_item nfi ");
				sbp.append("              , numeracoes_itens_devolucoes nid ");
				sbp.append("              , itens_devolucoes itd ");
				sbp.append("              , devolucoes_mercadorias dvm ");
				sbp.append("          WHERE nfi.emp_empresa = itd.nfs_emp_empresa ");
				sbp.append("            AND nfi.fil_filial = itd.nfs_fil_filial ");
				sbp.append("            AND nfi.nfs_nmro = itd.nfs_numero ");
				sbp.append("            AND nfi.nfs_serie = itd.nfs_serie ");
				sbp.append("            AND nfi.nfi_seqitem = itd.nfi_seqitem ");
				sbp.append("            AND nid.devmerc_codigo = itd.devmerc_codigo ");
				sbp.append("            AND nid.itdev_sequencia = itd.sequencia ");
				sbp.append("            AND itd.devmerc_codigo = dvm.codigo ");
				sbp.append("            AND dvm.motdev_codigo != 54 ");
				sbp.append("            AND nfi.emp_empresa = '"+ rset.getString(11) + "' ");
				sbp.append("            AND nfi.fil_filial = '"	+ rset.getString(12) + "' ");
				sbp.append("            AND nfi.nfs_nmro = " + rset.getInt(13));
				sbp.append("            AND nfi.nfs_serie = '"	+ rset.getString(14) + "' ");
				sbp.append("            AND nfi.nfi_seqitem = "	+ rset.getString(15));
				sbp.append("          GROUP BY nid.numeracao) ");
				sbp.append("  GROUP BY numeracao ");
				pstmp = j.getConn().prepareStatement(sbp.toString());
				rsetp = pstmp.executeQuery();
				contadorPares = 1;
				while (rsetp.next()) {
					tcell = trow.createCell(6 + contadorPares++);
					if (rsetp.getInt(1) > 0) {
						tcell.setCellValue(rsetp.getInt(1));
						tcell.setCellStyle(styleGrade);
						totalPares += rsetp.getInt(1);
					}
				}
				if (rsetp != null) {
					rsetp.close();
				}
				if (pstmp != null) {
					pstmp.close();
				}
				contador++;
			}

			trow = testsheet.createRow(++rowcount);
			tcell = trow.createCell(4);
			tcell.setCellValue("Total pares NF:");
			tcell = trow.createCell(5);
			tcell.setCellValue(totalPares);
			totalParesGeral += totalPares;

			rowcount += 2;
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(4);
			tcell.setCellValue("Total Geral:");
			tcell = trow.createCell(5);
			tcell.setCellValue(totalParesGeral);

			wb.write(fos);
			fos.close();
			gerou = true;
		} catch (IOException ioe) {
			ioe.printStackTrace(System.out);
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (java.sql.SQLException e) {
					e.printStackTrace(System.out);
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (java.sql.SQLException e) {
					e.printStackTrace(System.out);
				}
			}
			if (j != null) {
				j.close();
				j = null;
			}
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf")	+ nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}

}