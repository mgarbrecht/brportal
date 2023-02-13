package util.consultas.com;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ControleClientesEspeciais {

	public String geraExcel(HttpServletRequest req) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("controle");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleleft;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylerightred;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		int posicao = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			nomeArquivo.append("controle").append(util.rand.Palavra.geraPalavra()).append(".xls");
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleleft = wb.createCellStyle();
			styleright = wb.createCellStyle();
			stylerightred = wb.createCellStyle();
			
			HSSFFont font = wb.createFont();
	        font.setColor(HSSFColor.RED.index);
	        stylerightred.setFont(font);
			
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
			stylerightred.setAlignment((short) 3);
			stylerightred.setFillForegroundColor((short)4);
			stylerightred.setFillBackgroundColor((short)3);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			trow = testsheet.createRow(rowcount);
			if (req.getSession().getAttribute("cb_bloqueio_49") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Bloqueio 49");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_alerta_etiqueta") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Alerta Etiqueta");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_bloqueado_credito") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Bloqueado no crédito");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("preco_pdv") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Preço Pdv");
				tcell.setCellStyle(style);
			}		
			
			if (req.getSession().getAttribute("cb_bloqueio_uf") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Bloqueio UF");
				tcell.setCellStyle(style);
			}
			
			if (req.getSession().getAttribute("cb_regional") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Regional");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_situacao") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Situação");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_tipo_pedido") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Tipo");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_especie") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Espécie");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_pedido") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Pedido BR");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_desc_com") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Desc. Com.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_desc_prom") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Desc. Prom.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_desc_pont") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Desc. Pont.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_cnd_cdgo") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Cond. Pagto.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_livro") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Livro");
				tcell.setCellStyle(style);
			}			
			if (req.getSession().getAttribute("cb_invoice") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Invoice");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_oc") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("OC");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_linha") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Linha");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_descricao_item") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Descrição");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_descricao_embalagem") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Tipo da Embalagem");
				tcell.setCellStyle(style);
			}			
			if (req.getSession().getAttribute("cb_obs") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Obs.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_certificado_origem") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Cert.Origem");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_etiquetas") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Etiquetas");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_entrega_etiqueta") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Entrega Etiqueta");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_rec_etiqueta_filial") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Rec. Etiqueta Filial");
				tcell.setCellStyle(style);
			}
			
			if (req.getSession().getAttribute("cb_data_etiquetagem") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Etiquetagem");
				tcell.setCellStyle(style);
			}
			
			
			if (req.getSession().getAttribute("cb_carimbo") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Carimbo");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_cabide") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Normativa");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_pares") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Pares");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_valor") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Valor");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_mini_fabrica") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Mini-Fábrica");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_rem") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Rem.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_fl_prod") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Fl. Prod.");
				tcell.setCellStyle(style);
			}
			
			if (req.getSession().getAttribute("cb_local_estoque") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Local Estoque");
				tcell.setCellStyle(style);
			}
			
			if (req.getSession().getAttribute("cb_tipo_estoque") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Tipo Estoque");
				tcell.setCellStyle(style);
			}
			
			if (req.getSession().getAttribute("cb_fl_fat") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Fl. Fat.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_emiss") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Emissão Pedido");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_digit") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Digit.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_montagem") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Montagem");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_corte") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Corte");
				tcell.setCellStyle(style);
			}			
			if (req.getSession().getAttribute("cb_fat_cli") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Prev. Faturamento");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_marca") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Marca");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_agenda") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Semana Agendamento");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_efetiva") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Agendamento");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_hora") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Hora");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_senha") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Senha");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_portao_entrega") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Portão de Entraga (doca)");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_cd_entrega") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("CD de Entrega");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_emissao") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Faturamento");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_filial") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Filial");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_nf") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("NF");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_volumes") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Volumes");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_romaneio") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Número Romaneio");
				tcell.setCellStyle(style);
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Finalização Romaneio");
				tcell.setCellStyle(style);
			}			
			if (req.getSession().getAttribute("cb_dt_inspecao") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Inspeção");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_entrega") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Previsão Dt. Entrega Cliente");
				tcell.setCellStyle(style);
			}

			if (req.getSession().getAttribute("cb_dt_ultima_ocorrencia") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Dt. Última Ocorrência");
				tcell.setCellStyle(style);
			}

			if (req.getSession().getAttribute("cb_encarte") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Encarte");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_prioridade_embarque") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Prioridade Embarque");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_atacado") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Atacado");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_grupo_economico") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Grupo Econômico");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_cliente") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Cliente");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_seq") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Seq.");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_razao_social") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Razão Social");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_cnpj") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Cnpj");
				tcell.setCellStyle(style);
			}			
			if (req.getSession().getAttribute("cb_cidade") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Cidade");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_loja") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Loja");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_normativa_cliente") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Normativa");
				tcell.setCellStyle(style);
			}						
			if (req.getSession().getAttribute("cb_representante") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Representante");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_obs_pedido") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Obs. Pedido");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_data_bloqueio") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Bloqueio");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_data_prevista_desbloqueio") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Bloqueio");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_solicitacao_alarme") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Solicitação alarme");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_dt_recebimento_alarme") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Recebimento alarme PCP");
				tcell.setCellStyle(style);
			}			
			if (req.getSession().getAttribute("cb_dt_recebimento_alarme_filial") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Data Recebimento alarme filial");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_nota_fiscal_alarme") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Nota Fiscal Alarme");
				tcell.setCellStyle(style);
			}
			//if (req.getSession().getAttribute("cb_nota_fiscal_alarme") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Modelo Alarme");
				tcell.setCellStyle(style);
			//}
			if (req.getSession().getAttribute("cb_distribuicao") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Distribuição");
				tcell.setCellStyle(style);
			}		
			if (req.getSession().getAttribute("cb_tra_cdgo") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Transportadora");
				tcell.setCellStyle(style);
			}
			if (req.getSession().getAttribute("cb_gerar_requisicao") != null) {
				tcell = trow.createCell(posicao++);
				tcell.setCellValue("Gerar Requisição");
				tcell.setCellStyle(style);
			}
			java.util.Vector<?> res_Controle_clientes_especiais_vw = (java.util.Vector<?>) req.getSession().getAttribute("res_Controle_clientes_especiais_vw");

			for (int x = 0; x < res_Controle_clientes_especiais_vw.size(); x++) {
				posicao = 0;
				portalbr.dbobj.table.Controle_clientes_especiais_vw controle = (portalbr.dbobj.table.Controle_clientes_especiais_vw) res_Controle_clientes_especiais_vw.elementAt(x);
				gerou = true;
				++rowcount;
				trow = testsheet.createRow(rowcount);

				String[] n = controle.getModelos().split("#");
				StringBuilder sb = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				int contador = 0;
				for (String s : n) {
					if (contador % 2 != 0) {
						if (sb.length() > 0) {
							sb.append(" - ");
						}
						sb.append(s);
					} else {
						sb2.append(s);
					}
					contador++;
				}
				controle.setModelos(sb2.toString());
				controle.setDescricao_modelos(sb.toString());

				if (req.getSession().getAttribute("cb_bloqueio_49") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getBloqueio_49() != null ? controle.getBloqueio_49() : "");
					tcell.setCellStyle(stylecenter);
				}

				if (req.getSession().getAttribute("cb_alerta_etiqueta") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getAlerta() != null ? controle.getAlerta() : "");
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("cb_bloqueado_credito") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getBloqueado_credito() != null ? controle.getBloqueado_credito() : "");
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("preco_pdv") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPreco_pdv() != null ? controle.getPreco_pdv() : "");
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("cb_bloqueio_uf") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getLiberado_faturar().equals("0") ? "S" : "N");
					tcell.setCellStyle(stylecenter);
				}

				if (req.getSession().getAttribute("cb_regional") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCodigo_regional() + " - " + controle.getNome_regional());
					tcell.setCellStyle(stylecenter);
				}

				if (req.getSession().getAttribute("cb_situacao") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue((controle.getSituacao() != null ? controle.getSituacao() : "")+"-"+(controle.getDescricao_situacao() != null ? controle.getDescricao_situacao() : ""));
					tcell.setCellStyle(stylecenter);
				}

				if (req.getSession().getAttribute("cb_tipo_pedido") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_tipo() != null ? controle.getPed_tipo() : "");
					tcell.setCellStyle(stylecenter);
				}
				if (req.getSession().getAttribute("cb_especie") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(
							controle.getPed_especie_pedido() != null ? controle.getPed_especie_pedido() : "");
					tcell.setCellStyle(styleleft);
				}
				if (req.getSession().getAttribute("cb_pedido") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_nmro() != null ? controle.getPed_nmro() + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_desc_com") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_boni() != null ? controle.getPed_boni() + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_desc_prom") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_boni2() != null ? controle.getPed_boni2() + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_desc_pont") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_desc() != null ? controle.getPed_desc() + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_cnd_cdgo") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCnd_cdgo() != null ? controle.getCnd_cdgo() + "" : "");
					tcell.setCellStyle(styleleft);
				}
				if (req.getSession().getAttribute("cb_livro") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getLivro() != null ? controle.getLivro() + "" : "");
					tcell.setCellStyle(styleleft);
				}
				if (req.getSession().getAttribute("cb_invoice") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_invoice() != null ? controle.getPed_invoice() + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_oc") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getOc() != null ? controle.getOc() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_linha") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getModelos() != null ? controle.getModelos() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_descricao_item") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDescricao_modelos() != null ? controle.getDescricao_modelos() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_descricao_embalagem") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDescricao_embalagem() != null ? controle.getDescricao_embalagem() : "");
					tcell.setCellStyle(styleright);
				}				
				if (req.getSession().getAttribute("cb_obs") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getObse_adicionais() != null ? controle.getObse_adicionais() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_certificado_origem") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCertificado_origem() != null ? controle.getCertificado_origem() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_etiquetas") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getEtiquetas() != null ? controle.getEtiquetas() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_dt_entrega_etiqueta") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_entrega_etiqueta() != null ? com.egen.util.text.FormatDate.format(controle.getDt_entrega_etiqueta(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_dt_rec_etiqueta_filial") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_rec_etiqueta_filial() != null	? com.egen.util.text.FormatDate.format(controle.getDt_rec_etiqueta_filial(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_data_etiquetagem") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getData_etiquetagem() != null	? com.egen.util.text.FormatDate.format(controle.getData_etiquetagem(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_carimbo") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCarimbo() != null ? controle.getCarimbo() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_cabide") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCabide() != null ? controle.getCabide() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_pares") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPrs() != null ? controle.getPrs() + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_valor") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getValor_pedido());
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_mini_fabrica") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getMin_fabr() != null ? controle.getMin_fabr() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_rem") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getRemessa() != null ? controle.getRemessa() : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_fl_prod") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getFilial_prd() != null ? controle.getFilial_prd().replace("#"," - ") : "");
					if ((!controle.getFilial_prd().equals(controle.getFilial_local_estoque()))	&& controle.getFilial_local_estoque() != null) {
						tcell.setCellStyle(stylerightred);
					} else {
						tcell.setCellStyle(styleright);
					}
				}
				
				if (req.getSession().getAttribute("cb_local_estoque") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getLes_codigo() != null ? controle.getLes_codigo() + "" : "");
					if ((!controle.getFilial_prd().equals(controle.getFilial_local_estoque()))	&& controle.getFilial_local_estoque() != null) {
						tcell.setCellStyle(stylerightred);
					} else {
						tcell.setCellStyle(styleright);
					}
				}
				
				if (req.getSession().getAttribute("cb_tipo_estoque") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getTes_codigo() != null ? controle.getTes_codigo() + "" : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_fl_fat") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getFil_filial_fat() != null ? controle.getFil_filial_fat() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_emiss") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_emiss() != null ? com.egen.util.text.FormatDate.format(controle.getDt_emiss(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}
				if (req.getSession().getAttribute("cb_digit") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_digit() != null ? com.egen.util.text.FormatDate.format(controle.getDt_digit(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_dt_montagem") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_montagem() != null ? com.egen.util.text.FormatDate.format(controle.getDt_montagem(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_dt_corte") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_corte() != null ? com.egen.util.text.FormatDate.format(controle.getDt_corte(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_fat_cli") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_fatur() != null ? com.egen.util.text.FormatDate.format(controle.getDt_fatur(), "dd/MM/yyyy") + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_marca") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getMarca() != null ? controle.getMarca() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_agenda") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getAgendamento_cdgo() != null ? controle.getAgendamento_cdgo() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_dt_efetiva") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getData_efetiva() != null ? controle.getData_efetiva() + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_hora") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getHora() != null ? controle.getHora() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_senha") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getSenha() != null ? controle.getSenha() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_portao_entrega") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPortao() != null ? controle.getPortao() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_cd_entrega") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCd_entrega() != null ? controle.getCd_entrega() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_emissao") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_emissao() != null ? com.egen.util.text.FormatDate.format(controle.getDt_emissao(), "dd/MM/yyyy HH:mm:ss") + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_filial") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getFilial() != null ? controle.getFilial() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_nf") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getNotafiscal() != null ? controle.getNotafiscal() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_volumes") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getVolumes() != null ? controle.getVolumes() : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_romaneio") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getNumero_romaneio() != null ? controle.getNumero_romaneio()+"" : "");
					tcell.setCellStyle(styleleft);
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getData_finalizacao_romaneio() != null ? controle.getData_finalizacao_romaneio()+"" : "");
					tcell.setCellStyle(styleleft);
				}				

				if (req.getSession().getAttribute("cb_dt_inspecao") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDt_inspecao() != null ? controle.getDt_inspecao() + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_dt_entrega") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(controle.getData_entrega_cliente(), "dd/MM/yyyy"));
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_dt_ultima_ocorrencia") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getOcorrencia() != null ? controle.getOcorrencia() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_encarte") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getEncarte() != null ? controle.getEncarte() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_prioridade_embarque") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPrioridade_embarque() != null ? controle.getPrioridade_embarque() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_atacado") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getAtacado() != null ? controle.getAtacado() : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_grupo_economico") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getGrupo_economico() != null ? (controle.getGrupo_economico() + " - " + (controle.getGrupo_descricao() != null ? controle.getGrupo_descricao() : "")) : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_cliente") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCli_cdgo() != null ? controle.getCli_cdgo() + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_cliente") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getEsc_seqn() != null ? controle.getEsc_seqn() + "" : "");
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_razao_social") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCli_rzao() != null ? controle.getCli_rzao() + "" : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_cnpj") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCnpj() != null ? controle.getCnpj() + "" : "");
					tcell.setCellStyle(styleright);
				}
				
				if (req.getSession().getAttribute("cb_cidade") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getCidade() != null ? controle.getCidade() + "" : "");
					tcell.setCellStyle(styleleft);
				}
				
				if (req.getSession().getAttribute("cb_loja") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getLoja() != null ? controle.getLoja() + "" : "");
					tcell.setCellStyle(styleleft);
				}				

				if (req.getSession().getAttribute("cb_normativa_cliente") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(
							(controle.getNro_normativa_cliente() + " - " + controle.getDescricao_normativa_cliente()));
					tcell.setCellStyle(styleright);
				}

				if (req.getSession().getAttribute("cb_representante") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getRep_cdgo() != null ? (controle.getRep_cdgo() + " - " + controle.getRep_rzao()) : "");
					tcell.setCellStyle(styleleft);
				}

				if (req.getSession().getAttribute("cb_obs_pedido") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getPed_obse() != null ? controle.getPed_obse() : "");
					tcell.setCellStyle(styleleft);
				}

				if (req.getSession().getAttribute("cb_data_bloqueio") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(controle.getData_bloqueio(), "dd/MM/yyyy"));
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("cb_data_prevista_desbloqueio") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(controle.getData_prevista_desbloqueio(), "dd/MM/yyyy"));
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("cb_dt_solicitacao_alarme") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(controle.getDt_solicitacao_alarme(), "dd/MM/yyyy"));
					tcell.setCellStyle(stylecenter);
				}

				if (req.getSession().getAttribute("cb_dt_recebimento_alarme") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(controle.getDt_rec_alarme_pcp(), "dd/MM/yyyy"));
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("cb_dt_recebimento_alarme_filial") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(com.egen.util.text.FormatDate.format(controle.getDt_rec_alarme_filial(), "dd/MM/yyyy"));
					tcell.setCellStyle(stylecenter);
				}
				
				if (req.getSession().getAttribute("cb_nota_fiscal_alarme") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getNfe_numero() != null ? controle.getNfe_numero()+"" : "");
					tcell.setCellStyle(stylecenter);
				}
				
				//if (req.getSession().getAttribute("cb_nota_fiscal_alarme") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getModelo_alarme() != null ? controle.getModelo_alarme()+"" : "");
					tcell.setCellStyle(stylecenter);
				//}
				
				if (req.getSession().getAttribute("cb_distribuicao") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getDistribuicao() != null ? controle.getDistribuicao()+"" : "");
					tcell.setCellStyle(styleleft);
				}
				
				if (req.getSession().getAttribute("cb_tra_cdgo") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getTra_cdgo() != null ? (controle.getTra_cdgo() +" - " + controle.getTra_rzao()) : "");
					tcell.setCellStyle(styleleft);
				}

				if (req.getSession().getAttribute("cb_gerar_requisicao") != null) {
					tcell = trow.createCell(posicao++);
					tcell.setCellValue(controle.getGerar_requisicao());
					tcell.setCellStyle(stylecenter);
				}
				gerou = true;
			}
			wb.write(fos);
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		} finally {
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}

	public String geraExcelSubtotal(HttpServletRequest req) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("controle");
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleleft;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		int posicao = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			nomeArquivo.append("controle").append(util.rand.Palavra.geraPalavra()).append(".xls");
			style = wb.createCellStyle();
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
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			trow = testsheet.createRow(rowcount);

			tcell = trow.createCell(posicao++);
			tcell.setCellValue("Regional");
			tcell.setCellStyle(style);

			tcell = trow.createCell(posicao++);
			tcell.setCellValue("Pares");
			tcell.setCellStyle(style);

			tcell = trow.createCell(posicao++);
			tcell.setCellValue("Grupo Econômico");
			tcell.setCellStyle(style);

			java.util.Vector<?> res_Controle_clientes_especiais_vw = (java.util.Vector<?>) req.getSession()
					.getAttribute("res_Controle_clientes_especiais_vw");
			for (int x = 0; x < res_Controle_clientes_especiais_vw.size(); x++) {
				posicao = 0;
				portalbr.dbobj.table.Controle_clientes_especiais_vw controle = (portalbr.dbobj.table.Controle_clientes_especiais_vw) res_Controle_clientes_especiais_vw
						.elementAt(x);
				gerou = true;
				++rowcount;
				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(posicao++);
				tcell.setCellValue(controle.getCodigo_regional() + " - " + controle.getNome_regional());
				tcell = trow.createCell(posicao++);
				tcell.setCellValue(controle.getPrs() != null ? controle.getPrs() : 0);
				tcell = trow.createCell(posicao++);
				tcell.setCellValue(controle.getGrupo_economico() != null ? (controle.getGrupo_economico() + " - " + controle.getGrupo_descricao()) : "");
				gerou = true;
			}
			wb.write(fos);
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		} finally {
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}
	
	public List<String> retornaDesconsiderarBloqueioFilialFat(){
		List<String> listaDesconsiderar = new ArrayList<String>();
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT valor cliente ");
			sb.append("   FROM wbrio.parametros ");
			sb.append("  WHERE nome = 'desconsiderar_bloq_fil_fat_controle_cli_esp_cli' ");
			sb.append("    AND par_sist_codigo = 'BRNET' ");
			sb.append("  UNION ");
			sb.append(" SELECT to_char(ge.cli_cdgo) cliente ");
			sb.append("   FROM grupo_economico  ge ");
			sb.append("      , wbrio.parametros p ");
			sb.append("  WHERE p.nome = 'desconsiderar_bloq_fil_fat_controle_cli_esp_grupo' ");
			sb.append("    AND p.par_sist_codigo = 'BRNET' ");
			sb.append("    AND ge.status = 'A' ");
			sb.append("    AND ge.gre_grupo = to_number(p.valor) ");
			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				listaDesconsiderar.add(rset.getString("cliente"));
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
			}
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
			}
			if (j != null) {
				j.close();
			}
		}
		return listaDesconsiderar;
	}

}