package util.consultas.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@SuppressWarnings("rawtypes")
public class PlanilhaImportacaoCalcenter {

	private String pedidos;
	private List<String> listaTamanhos;
	private List<Numeracao> listaNumeracao;
	private Vector res_Jw_planilha_importacao_calcenter;
	private com.egen.util.jdbc.JdbcUtil jConnection = null;
	
	public Vector getRes_Jw_planilha_importacao_calcenter() {
		return res_Jw_planilha_importacao_calcenter;
	}

	public void setRes_Jw_planilha_importacao_calcenter(Vector res_Jw_planilha_importacao_calcenter) {
		this.res_Jw_planilha_importacao_calcenter = res_Jw_planilha_importacao_calcenter;
	}

	public List<Numeracao> getListaNumeracao() {
		return listaNumeracao;
	}

	public void setListaNumeracao(List<Numeracao> listaNumeracao) {
		this.listaNumeracao = listaNumeracao;
	}

	public String getPedidos() {
		return pedidos;
	}

	public void setPedidos(String pedidos) {
		this.pedidos = pedidos;
	}

	public List<String> getListaTamanhos() {
		return listaTamanhos;
	}

	public void setListaTamanhos(List<String> listaTamanhos) {
		this.listaTamanhos = listaTamanhos;
	}

		
	public PlanilhaImportacaoCalcenter(java.util.Vector res_Jw_planilha_importacao_calcenter, String ped) {
		super();
		this.pedidos = ped;
		this.res_Jw_planilha_importacao_calcenter = res_Jw_planilha_importacao_calcenter;
	}

	public String geraExcel() throws Exception {
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
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		int planilha = 0;
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			this.jConnection = new com.egen.util.jdbc.JdbcUtil();
			buscaNumeracao();
			HSSFSheet testsheet = null;
			nomeArquivo.append("importacao").append(util.rand.Palavra.geraPalavra()).append(".xls");
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
			int indice = 0;
			int indiceCell = 0;
			// --------- Cabecalho ------------------------
			testsheet = wb.createSheet("importacao" + ++planilha);
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("TT");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Pedido Igual");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Hierarquia");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Texto Material");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Nome");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Marca");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Referência");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cor Base");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cluster Clima");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Época");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Coleção");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("CVP");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Preço Compra");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Preço Venda");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Semana");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Ano");
			tcell.setCellStyle(stylecenterborda);
			// -----NUMERACAO-------------------------
			for (String t : this.listaTamanhos) {
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t);
				tcell.setCellStyle(stylecenterborda);
			}
			//----------------------------------------
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Volumes");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Local Entrega");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Forma Compra");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("CD ou FT");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Promocional");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cond. Pagamento");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Importado?");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Estoque no CD");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Armazenagem");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cor Fornecedor");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Estampa");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Estilo do Produto");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Tipo Material");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cabedal");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Construção do Salto");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Tema Coleção");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Altura Salto");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Bico");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Enfeite");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Material Sola");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("NCM");
			tcell.setCellStyle(stylecenterborda);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Obs");
			tcell.setCellStyle(stylecenterborda);

			while (indice < this.res_Jw_planilha_importacao_calcenter.size()) {portalbr.dbobj.view.Jw_planilha_importacao_calcenter t_jw_planilha_importacao_calcenter = (portalbr.dbobj.view.Jw_planilha_importacao_calcenter) this.res_Jw_planilha_importacao_calcenter.elementAt(indice);
				gerou = true;
				indiceCell = 0;
				// --------------------------------------------
				trow = testsheet.createRow(++rowcount);
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getColuna1() != null ? t_jw_planilha_importacao_calcenter.getColuna1() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getColuna2() != null ? t_jw_planilha_importacao_calcenter.getColuna2() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getTt() != null ? t_jw_planilha_importacao_calcenter.getTt() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getPedido_igual() != null ? t_jw_planilha_importacao_calcenter.getPedido_igual() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getHierarquia() != null ? t_jw_planilha_importacao_calcenter.getHierarquia() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getTexto_material() != null ? t_jw_planilha_importacao_calcenter.getTexto_material() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getNome() != null ? t_jw_planilha_importacao_calcenter.getNome() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getMarca() != null ? t_jw_planilha_importacao_calcenter.getMarca() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getReferencia() != null ? t_jw_planilha_importacao_calcenter.getReferencia() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCor_base() != null ? t_jw_planilha_importacao_calcenter.getCor_base() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCluster_clima() != null ? t_jw_planilha_importacao_calcenter.getCluster_clima() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getEpoca() != null ? t_jw_planilha_importacao_calcenter.getEpoca() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getColecao() != null ? t_jw_planilha_importacao_calcenter.getColecao() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCvp() != null ? t_jw_planilha_importacao_calcenter.getCvp() : "");
				tcell = trow.createCell(indiceCell++);
				if (t_jw_planilha_importacao_calcenter.getPreco_compra() != null) {
					tcell.setCellValue(t_jw_planilha_importacao_calcenter.getPreco_compra());
				}
				tcell = trow.createCell(indiceCell++);
				if (t_jw_planilha_importacao_calcenter.getPreco_venda() != null) {
					tcell.setCellValue(t_jw_planilha_importacao_calcenter.getPreco_venda());
				}
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getSemana() != null ? t_jw_planilha_importacao_calcenter.getSemana() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getAno() != null ? t_jw_planilha_importacao_calcenter.getAno() : "");
				// -----NUMERACAO-------------------------
				String n = t_jw_planilha_importacao_calcenter.getNumeracao();
				String t[] = n.split("#");
				for (String tam : this.listaTamanhos) {
					tcell = trow.createCell(indiceCell++);
					for(String s : t){
						String o[] = s.split("x");
						if(tam.equalsIgnoreCase(o[0])){
							tcell.setCellValue(o[1]);
						}
					}
				}
				
				//----------------------------------------
				tcell = trow.createCell(indiceCell++);
				if (t_jw_planilha_importacao_calcenter.getVolumes() != null) {
					tcell.setCellValue(t_jw_planilha_importacao_calcenter.getVolumes());
				}
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getLocal_entrega() != null ? t_jw_planilha_importacao_calcenter.getLocal_entrega() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getForma_compra() != null ? t_jw_planilha_importacao_calcenter.getForma_compra() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCd_ou_ft() != null ? t_jw_planilha_importacao_calcenter.getCd_ou_ft() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getPromocional() != null ? t_jw_planilha_importacao_calcenter.getPromocional() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCond_pagamento() != null ? t_jw_planilha_importacao_calcenter.getCond_pagamento() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getImportado() != null ? t_jw_planilha_importacao_calcenter.getImportado() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getEstoque_no_cd() != null ? t_jw_planilha_importacao_calcenter.getEstoque_no_cd() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getArmazenagem() != null ? t_jw_planilha_importacao_calcenter.getArmazenagem() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCor_fornecedor() != null ? t_jw_planilha_importacao_calcenter.getCor_fornecedor() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getEstampa() != null ? t_jw_planilha_importacao_calcenter.getEstampa() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getEstilo_do_produto() != null ? t_jw_planilha_importacao_calcenter.getEstilo_do_produto() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getTipo_material() != null ? t_jw_planilha_importacao_calcenter.getTipo_material() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getCabedal() != null ? t_jw_planilha_importacao_calcenter.getCabedal() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getConstrucao_do_salto() != null ? t_jw_planilha_importacao_calcenter.getConstrucao_do_salto() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getTema_colecao() != null ? t_jw_planilha_importacao_calcenter.getTema_colecao() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getAltura_salto() != null ? t_jw_planilha_importacao_calcenter.getAltura_salto() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getBico() != null ? t_jw_planilha_importacao_calcenter.getBico() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getEnfeite() != null ? t_jw_planilha_importacao_calcenter.getEnfeite() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getMaterial_sola() != null ? t_jw_planilha_importacao_calcenter.getMaterial_sola() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getNcm() != null ? t_jw_planilha_importacao_calcenter.getNcm() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_planilha_importacao_calcenter.getObs() != null ? t_jw_planilha_importacao_calcenter.getObs() : "");
				indice++;
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
			if (this.jConnection != null) {
				this.jConnection.close();
				this.jConnection = null;
			}
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	private void buscaNumeracao() {
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		try {
			this.listaTamanhos = new ArrayList();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT DISTINCT qtp_nume ");
			sb.append("   FROM qtd_prg qp ");
			sb.append("  WHERE ped_nmro IN ("+this.pedidos+")");
			sb.append("  ORDER BY TO_NUMBER(regexp_substr(qp.qtp_nume, '[[:digit:]]+', 1, 1)) ");
			pstm = jConnection.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()){
				this.listaTamanhos.add(rset.getString("qtp_nume"));
			}
		} catch (Exception e) {
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
		}
	}

	public class Numeracao {
		private String tamanho;
		private Integer quantidade;

		public Numeracao(String tamanho, Integer quantidade) {
			super();
			this.tamanho = tamanho;
			this.quantidade = quantidade;
		}

		public String getTamanho() {
			return tamanho;
		}

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}

	}
}
