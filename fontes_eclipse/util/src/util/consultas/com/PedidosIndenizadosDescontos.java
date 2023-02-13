package util.consultas.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.DynaActionForm;

import com.egen.util.jdbc.JdbcUtil;

import portalbr.dbobj.table.Ite_motivo_indenizacao;
import portalbr.dbobj.table.Ped_desconto_indenizacao;
import portalbr.dbobj.view.Jw_ped_desconto_indenizacao;
import portalbr.lov.LvPedidosIndenizadosDescontosActionForm;

public class PedidosIndenizadosDescontos {

	private String descricaoErroValidacao;
	private Double valorTotalDesconto = 0d;
	private Jw_ped_desconto_indenizacao jwPedDescontoIndenizacao;

	public Double retornaSaldo(com.egen.util.jdbc.JdbcUtil j, Integer codigoCliente, Integer codigoMarca, Integer estabelecimentoCliente) throws Exception {
		util.consultas.Query query = new util.consultas.Query();
		Double saldo = 0d;
		// int grupoEconomico;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		StringBuilder sb = new StringBuilder();
		try {
			saldo = Double.parseDouble(query.retorna(j, "SELECT to_number(valor) valor from parametros WHERE nome = 'valor_maximo_desconto_quinzenal' AND par_sist_codigo = 'BRNET'"));
			// grupoEconomico = Integer.parseInt(query.retorna(j, "SELECT
			// nvl(pck_cliente.get_grupo_economico("+codigoCliente+"), 0) FROM
			// dual"));
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        pa.valor valor_maximo_quinzenal ");
			sb.append("      , SUM(pd.valor_desconto) valor_desconto ");
			sb.append("      , CASE WHEN (NVL(TO_NUMBER(pa.valor) - SUM(pd.valor_desconto),0)) < 0 THEN 0 ELSE (NVL(TO_NUMBER(pa.valor) - SUM(pd.valor_desconto),0)) END saldo ");
			sb.append("   FROM ped_desconto_indenizacao pd ");
			sb.append("      , ped p ");
			// if (grupoEconomico != 0) {
			// sb.append(" , grupo_economico ge ");
			// }
			sb.append("      , wbrio.parametros pa ");
			// sb.append(" , (SELECT MIN(data) data_inicial ");
			// sb.append(" , MAX(data) data_final ");
			// sb.append(" FROM calendarios_semanal ");
			// sb.append(" WHERE periodo = (SELECT periodo ");
			// sb.append(" FROM calendarios_semanal ");
			// sb.append(" WHERE cod_filial = 'MT' ");
			// sb.append(" AND data = TRUNC(SYSDATE)) ");
			// sb.append(" AND cod_empresa = '01' ");
			// sb.append(" AND cod_filial = 'MT' ");
			// sb.append(" AND extract(YEAR FROM data) = extract(YEAR FROM
			// SYSDATE)) c ");
			sb.append("      , (SELECT CASE WHEN quinzena_mes = 1 THEN to_date('01/' || to_char(SYSDATE, 'mm/yyyy'), 'dd/mm/yyyy') ");
			sb.append("			          ELSE to_date('16/' || to_char(SYSDATE, 'mm/yyyy'), 'dd/mm/yyyy') END data_inicial ");
			sb.append("			     , CASE WHEN quinzena_mes = 1 THEN to_date('15/' || to_char(SYSDATE, 'mm/yyyy'), 'dd/mm/yyyy') ");
			sb.append("			          ELSE TRUNC(last_day(SYSDATE)) END data_final ");
			sb.append("			  FROM (SELECT CASE WHEN TO_NUMBER(TO_CHAR(SYSDATE, 'DD')) < 16 THEN 1 ELSE 2 END AS quinzena_mes ");
			sb.append("			          FROM DUAL)) c ");
			sb.append("  WHERE pd.ped_nmro = p.ped_nmro ");
			// if (grupoEconomico != 0) {
			// sb.append(" AND ge.status = 'A' ");
			// sb.append(" AND ge.cli_cdgo = p.cli_cdgo ");
			// sb.append(" AND ge.gre_grupo = ? ");
			// } else {
			sb.append("    AND p.cli_cdgo = ? ");
			sb.append("    AND p.esc_seqn = ? ");
			// }
			sb.append("    AND EXISTS (SELECT 1 ");
			sb.append("  	             FROM ite i ");
			sb.append("      	        WHERE i.ped_nmro = p.ped_nmro ");
			sb.append("			          AND fct_marca_produto(i.lin_cdgo, i.ref_cdgo) = ?) ");
			sb.append("    AND TRUNC(data_criacao) BETWEEN c.data_inicial AND c.data_final ");
			sb.append("    AND pa.par_sist_codigo = 'BRNET' ");
			sb.append("    AND pa.nome = 'valor_maximo_desconto_semanal' ");
			sb.append("    AND situacao <> 'C' ");
			sb.append("  GROUP BY pa.valor ");
			pstm = j.getConn().prepareStatement(sb.toString());
			// if (grupoEconomico != 0) {
			// pstm.setInt(1, grupoEconomico);
			// } else {
			pstm.setInt(1, codigoCliente);
			// }
			pstm.setInt(2, estabelecimentoCliente);
			pstm.setInt(3, codigoMarca);
			rset = pstm.executeQuery();
			while (rset.next()) {
				saldo = rset.getDouble("saldo");
			}
		} catch (Exception e) {
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return saldo;
	}

	public boolean usuarioLiberado(HttpSession session) {
		boolean liberado = false;
		try {
			acesso.Sessao sessao = new acesso.Sessao(session);
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			if (!parametros.retornaParametro("pedidos_indenizados_descontos", sessao.getUsuario()).isEmpty()) {
				liberado = true;
			}
		} catch (Exception e) {
		}
		return liberado;
	}

	@SuppressWarnings("unchecked")
	public void salvarAlteracoes(JdbcUtil j, ActionForm form, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		try {
			if (validarAlteracoes(j, form, request)) {
				Ped_desconto_indenizacao table = new Ped_desconto_indenizacao();
				acesso.Sessao sessao = new acesso.Sessao(session);
				util.consultas.Query query = new util.consultas.Query();
				DynaActionForm _ge_grid = (DynaActionForm) form;
				portalbr.lov.LvPedidosIndenizadosDescontosActionForm[] _ge_grid_array = (portalbr.lov.LvPedidosIndenizadosDescontosActionForm[]) _ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
				LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
				String existe = query.retorna(j, "SELECT 1 FROM ped_desconto_indenizacao WHERE ped_nmro = "+ (String) session.getAttribute("LvPedidosIndenizadosDescontosPedNmro"));
				if ((existe + "").equalsIgnoreCase("1")) {
					@SuppressWarnings("rawtypes")
					Vector sets = new Vector(10, 2);
					table.setPed_nmro(this.jwPedDescontoIndenizacao.getPed_nmro());
					sets.addElement("ped_nmro");
					table.setTipo_desconto(2);
					sets.addElement("tipo_desconto");
					table.setPed_obse(null);
					sets.addElement("ped_obse");
					table.setValor_desconto(this.valorTotalDesconto);
					sets.addElement("valor_desconto");
					table.setCnd_cdgo(this.jwPedDescontoIndenizacao.getCnd_cdgo());
					sets.addElement("cnd_cdgo");
					table.setSituacao(this.jwPedDescontoIndenizacao.getSituacao());
					sets.addElement("situacao");
					table.setUsuario_criacao(sessao.getUsuario());
					sets.addElement("usuario_criacao");
					table.setData_criacao(new java.sql.Timestamp(new java.util.Date().getTime()));
					sets.addElement("data_criacao");
					if (sets != null && sets.size() > 0) {
						String[] set = new String[sets.size()];
						for (int i = 0; i < sets.size(); i++) {
							set[i] = (String) sets.elementAt(i);
						}
						j.update(table, set);
					}
				} else {
					String sit = this.jwPedDescontoIndenizacao.getSituacao();
					if (sit.equalsIgnoreCase("N")) {
						sit = "A";
					}
					Object[][] name_value = {
							{ "ped_nmro", this.jwPedDescontoIndenizacao.getPed_nmro() },
							{ "tipo_desconto", 2 },
							{ "ped_obse", null }, 
							{ "valor_desconto", this.valorTotalDesconto },
							{ "cnd_cdgo", this.jwPedDescontoIndenizacao.getCnd_cdgo() }, 
							{ "situacao", sit },
							{ "prazo_adicional", null }, 
							{ "usuario_criacao", sessao.getUsuario() },
							{ "data_criacao", new java.sql.Timestamp(new java.util.Date().getTime()) } 
					};
					j.insert(table, name_value);
					session.setAttribute("LvPedidosIndenizadosValorTotalDesconto", this.valorTotalDesconto);
				}
				
				portalbr.lov.LvPedidosIndenizadosDescontosActionForm[] _ge_grid_itens_array = (portalbr.lov.LvPedidosIndenizadosDescontosActionForm[]) _ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
				LvPedidosIndenizadosDescontosActionForm fItens = _ge_grid_array[0];
				Ite_motivo_indenizacao tableItens = new Ite_motivo_indenizacao();
				for (int _ge_grid_itens_array_index = 0; _ge_grid_itens_array_index < _ge_grid_itens_array.length; _ge_grid_itens_array_index++) {
					fItens = _ge_grid_array[_ge_grid_itens_array_index];
					query.execute(j, "DELETE brio.ite_motivo_indenizacao WHERE ped_nmro = "+fItens.getPed_nmro()+" AND ite_seqn = " + fItens.getIte_seqn());
					if(validaItem(fItens)) {
						tableItens = new Ite_motivo_indenizacao();
						Object[][] name_value = {
							{ "ped_nmro", com.egen.util.text.FormatNumber.toInteger(fItens.getPed_nmro()) },
							{ "ite_seqn", com.egen.util.text.FormatNumber.toInteger(fItens.getIte_seqn()) },
							{ "quantidade_pares", com.egen.util.text.FormatNumber.toInteger(fItens.getQuantidade()) },
							{ "moco_codigo", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_motivo_troca()) },
							{ "observacao", fItens.getObservacao() },
							{ "usuario_criacao", sessao.getUsuario() },
							{ "data_criacao", new java.sql.Timestamp(new java.util.Date().getTime()) },
							{ "ped_nmro_indenizado", this.jwPedDescontoIndenizacao.getPed_nmro() }
						};
						j.insert(tableItens, name_value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		if (this.descricaoErroValidacao != null) {
			session.setAttribute("LvPedidosIndenizadosDescontosErros", this.descricaoErroValidacao);
		} else {
			session.removeAttribute("LvPedidosIndenizadosDescontosErros");
		}
	}

	private boolean validarAlteracoes(JdbcUtil j, ActionForm form, HttpServletRequest request) {
		boolean validou = true;
		try {
			buscarJwPedDescontoIndenizacao(j, request);
			HttpSession session = request.getSession(true);
			acesso.Sessao sessao = new acesso.Sessao(session);
			util.consultas.Query query = new util.consultas.Query();
			this.descricaoErroValidacao = null;
			this.valorTotalDesconto = 0d;
			session.removeAttribute("LvPedidosIndenizadosValorTotalDesconto");
			DynaActionForm _ge_grid = (DynaActionForm) form;
			portalbr.lov.LvPedidosIndenizadosDescontosActionForm[] _ge_grid_array = (portalbr.lov.LvPedidosIndenizadosDescontosActionForm[]) _ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
			LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			int limiteBonificacao = Integer.parseInt(parametros.retornaParametro("limite_bonificacao_pedido"));
			String liberadoLimite = query.retorna(j, "SELECT 'S' FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'usuario_liberado_limite_bonificacao_pedido' and valor = '"+ sessao.getUsuario() + "'");
			if (liberadoLimite.equalsIgnoreCase("s")) {
				limiteBonificacao = 99999;
			}
			for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
				f = _ge_grid_array[_ge_grid_array_index];
				if(validaItem(f)) {
					this.valorTotalDesconto += com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getIte_prco_descontos()) * com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getQuantidade());
				}
			}
			if (this.valorTotalDesconto > limiteBonificacao) {
				validou = false;
				this.descricaoErroValidacao = "Limite excedido (Limite bonificação: " + limiteBonificacao + ", bonificação informada: " + this.valorTotalDesconto + ")";
			}
			if (validou) {
				String valor_pedido = ((String) query.retorna("select fct_valor_pedido(" + (String)session.getAttribute("LvPedidosIndenizadosDescontosPedNmro") + ") from dual"));
				if (this.valorTotalDesconto > Double.parseDouble(valor_pedido)) {
					this.descricaoErroValidacao = "Valor desconto não pode ser maior que o valor do pedido.";
					validou = false;
				}
			}
			if (validou) {
				Double saldo = retornaSaldo(j, this.jwPedDescontoIndenizacao.getCli_cdgo(), this.jwPedDescontoIndenizacao.getCodigo_marca(), this.jwPedDescontoIndenizacao.getEsc_seqn());
				if ((saldo - this.valorTotalDesconto) < 0) {
					this.descricaoErroValidacao = "O saldo total que pode ser solicitado pelo cliente/loja/pedido/marca ("+ this.jwPedDescontoIndenizacao.getCli_cdgo() + "/" + this.jwPedDescontoIndenizacao.getEsc_seqn() + "/" + this.jwPedDescontoIndenizacao.getPed_nmro() + "/"+ this.jwPedDescontoIndenizacao.getCodigo_marca() + ") é: " + com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") + "! (Valor informado: "+ com.egen.util.text.FormatNumber.format(this.valorTotalDesconto, "##,##0.00") + ")";
					validou = false;
				}
			}
			if(validou) {
				if(this.valorTotalDesconto == 0) {
					this.descricaoErroValidacao = "Nenhum registro informado!";
					validou = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		this.valorTotalDesconto = Math.round(this.valorTotalDesconto * 100.0) / 100.0;
		return validou;
	}

	private void buscarJwPedDescontoIndenizacao(JdbcUtil j, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			this.jwPedDescontoIndenizacao = null;
			Jw_ped_desconto_indenizacao table = new Jw_ped_desconto_indenizacao();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT ped.ped_nmro ");
			sb.append("      , pd.tipo_desconto ");
			sb.append("      , pd.ped_obse ");
			sb.append("      , pd.valor_desconto ");
			sb.append("      , pd.percentual_desc ");
			sb.append("      , ped.cnd_cdgo ");
			sb.append("      , NVL(pd.situacao, 'N') situacao ");
			sb.append("      , pd.prazo_adicional ");
			sb.append("      , (SELECT 'S' FROM ped_desconto_indenizacao WHERE ped_nmro = ped.ped_nmro) banco ");
			sb.append("      , ped_sequencial_maquina ");
			sb.append("      , c.cli_cdgo || '-' || esc_seqn || '-' || INITCAP(c.cli_rzao) cliente ");
			sb.append("      , ped.ped_stat ");
			sb.append("      , fct_valor_pedido(ped.ped_nmro) valor ");
			sb.append("      , pck_cnd.get_nome(ped.cnd_cdgo) cnd_desc ");
			sb.append("      , ped.ped_especie_pedido ");
			sb.append("      , nvl((SELECT DISTINCT 'N' aceita_desconto ");
			sb.append("                        FROM ped p ");
			sb.append("                           , ite i ");
			sb.append("                       WHERE p.ped_nmro = i.ped_nmro ");
			sb.append("                         AND ((NVL(p.ped_boni, 0) > 0) OR (NVL(p.ped_boni2, 0) > 0) OR (NVL(fct_valor_pedido(p.ped_nmro), 0) > 0)) ");
			sb.append("                         AND p.ped_nmro = ped.ped_nmro ");
			sb.append("                         AND p.ped_tipo <> 'EX' ");
			sb.append("                         AND p.ped_especie_pedido <> 'A' ");
			sb.append("                         AND EXISTS (SELECT 1 ");
			sb.append("                                       FROM ref_sem_desconto rsd ");
			sb.append("                                      WHERE rsd.lin_cdgo = i.lin_cdgo ");
			sb.append("                                        AND rsd.ref_cdgo = i.ref_cdgo)),'S') aceita_desconto ");
			sb.append("      , c.cli_cdgo ");
			sb.append("      , (select fct_marca_produto(i.lin_cdgo, i.ref_cdgo) from ite i where i.ped_nmro = ped.ped_nmro and rownum = 1) codigo_marca ");
			sb.append("      , ped.esc_seqn ");
			sb.append("   FROM ped ped ");
			sb.append("      , ped_desconto_indenizacao pd  ");
			sb.append("      , cli c ");
			sb.append("      , rep r ");
			sb.append("      , regionais_vendas rv ");
			sb.append("      , gerentes_regionais_vendas gr ");
			sb.append("  WHERE ped.rep_cdgo = r.rep_cdgo ");
			sb.append("    AND c.cli_cdgo = ped.cli_cdgo ");
			sb.append("    AND gr.codigo_gerente = r.codigo_gerente ");
			sb.append("    AND rv.codigo_regional = r.codigo_regional ");
			sb.append("    AND ped.ped_stat NOT IN ('C') ");
			sb.append("    AND pd.ped_nmro (+) = ped.ped_nmro ");
			sb.append("    AND ped.ped_nmro = " + (String)session.getAttribute("LvPedidosIndenizadosDescontosPedNmro"));
			sb.append("  ORDER BY ped.ped_nmro ");
			@SuppressWarnings("rawtypes")
			Vector res_Ped_desconto_indenizacao = j.select(table, sb.toString(), null);
			this.jwPedDescontoIndenizacao = (Jw_ped_desconto_indenizacao) res_Ped_desconto_indenizacao.elementAt(0);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private boolean validaItem(LvPedidosIndenizadosDescontosActionForm f) {
		boolean validou = true;
		try {
			if (!f.getQuantidade().isEmpty()) {
				try {
					int quantidade = Integer.parseInt(f.getQuantidade());
					if (quantidade > 0) {
						if ((f.getCodigo_motivo_troca().isEmpty()) && (f.getObservacao().isEmpty())) {
							validou = false;
						}
					} else {
						validou = false;
					}
				} catch (Exception e) {
				}
			} else {
				validou = false;
			}
		} catch (Exception e) {
		}
		return validou;
	}

}