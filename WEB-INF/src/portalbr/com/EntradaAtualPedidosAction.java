package portalbr.com;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/09/2014 15:35:48
 * Last Modify Date 01/03/2023 17:45:00
 */

public class EntradaAtualPedidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    session.removeAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas_2");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_clientes");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_grupos");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_faturamento");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_faturamento_regional");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_estilos");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_unidades");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_unidades_me");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_tipo_produto");
    session.removeAttribute("res_Jw_entrada_atual_pedidos_filtro_segmento");
    session.removeAttribute("clientes_mercado_interno");
    session.removeAttribute("clientes_mercado_externo");
    session.removeAttribute("mensagem_dois_bilhoes");
    session.removeAttribute("entrada_pedidos_representantes_vendas_mostrar_segmentos");
    util.consultas.Query queryDia = new util.consultas.Query();
    String diaAtual = queryDia.retorna(j, "SELECT to_char(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END, 'dd/mm/yyyy') dia_atual FROM dual ");
    boolean mostraMensagemDoisBilhoes = false;
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    StringBuilder sbMi = new StringBuilder();
    StringBuilder sbMe = new StringBuilder();
    StringBuilder sbMensagem = new StringBuilder();
    String tipoQuebra = (String) session.getAttribute("tipoQuebra");
    if (!tipoQuebra.equalsIgnoreCase("giro_producao")) {
      session.removeAttribute("giroProducao");
    }
    sbMensagem.append(" SELECT 'S' ");
    sbMensagem.append("   FROM parametros ");
    sbMensagem.append("  WHERE par_sist_codigo = 'BRNET' ");
    sbMensagem.append("    AND nome = 'usuario_mensagem_bilhao_entrada_pedidos_atual' ");
    sbMensagem.append("    AND valor = '"+sessao.getUsuario() + "' ");
    String mostraMensagem = query.retorna(sbMensagem.toString());
    if (mostraMensagem.equalsIgnoreCase("S")) {
      mostraMensagemDoisBilhoes = true;
    }

    if (mostraMensagemDoisBilhoes) {
      String retorno = query.retorna("select valor from wbrio.entrada_pedidos_atual_msg_vw");
      session.setAttribute("mensagem_dois_bilhoes", retorno);
    }

    String[][] select = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()} };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");

      portalbr.dbobj.table.Entrada_pedidos_atual_vw t_entrada_pedidos_atual_vw = new portalbr.dbobj.table.Entrada_pedidos_atual_vw();
      String geral = null;
      String regional = null;
      String representante = null;
      String analista = null;
      String filtroRep = "";
      String filtroCodigoRepresentante = "";
      boolean usuarioRepresentante = false;

      StringBuilder sbParametros = new StringBuilder();
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");

      if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
        sbParametros.append(" AND ctl.codigo_representante = " + sessao.getChave());
        filtroCodigoRepresentante = " AND codigo_representante = " + sessao.getChave();
        filtroRep = " AND r.rep_cdgo = '"+sessao.getChave() + "' ";
        usuarioRepresentante = true;
      }

      if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
        sbParametros.append(" AND rep.codigo_gerente = " + sessao.getChave());
      }
      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        sbParametros.append(" AND reg.codigo_regional = " + sessao.getChave());
        regional = sessao.getChave();
      }

      String marcaSelec = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
      if (!marcaSelec.equalsIgnoreCase("T")) {
        sbParametros.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelec);
      }

      StringBuilder sb = new StringBuilder();
      String tipoSelecionado = (String) session.getAttribute("tipoSelecionado");

      String anterior = " AND 1=2 ";
      String atual = " AND 1=2 ";
      String mes = " AND 1=2 ";
      String semana_atual = " AND 1=2 ";
      if (tipoSelecionado.equalsIgnoreCase("anterior")) {
        anterior = " AND 1=1 ";
      }
      if (tipoSelecionado.equalsIgnoreCase("atual")) {
        atual = " AND 1=1 ";
      }
      if (tipoSelecionado.equalsIgnoreCase("mes")) {
        mes = " AND 1=1 ";
      }
      if (tipoSelecionado.equalsIgnoreCase("semana_atual")) {
        semana_atual = " AND 1=1 ";
      }


      if (tipoQuebra.equalsIgnoreCase("geral")) {
        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'GERAL' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , '' rep_cdgo ");
        sb.append("      , NULL rep_rzao ");
        sb.append("      , NULL sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(anterior);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                     FROM semanas sem ");
        sb.append("                    WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                    FROM semanas sem ");
        sb.append("                                   WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'GERAL' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , '' rep_cdgo ");
        sb.append("      , NULL rep_rzao ");
        sb.append("      , NULL sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(atual);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'GERAL' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , '' rep_cdgo ");
        sb.append("      , NULL rep_rzao ");
        sb.append("      , NULL sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(mes);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'GERAL' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , '' rep_cdgo ");
        sb.append("      , NULL rep_rzao ");
        sb.append("      , NULL sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(semana_atual);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sb.append("                                        FROM semanas sem ");
        sb.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
      }

      if (tipoQuebra.equalsIgnoreCase("faturamento")) {
        String tipo = null;
        Jw_entrada_atual_pedidos_faturamento tablefat = new Jw_entrada_atual_pedidos_faturamento();
        String dia_anteriorf = " and 1=2 ";
        String dia_atualf = " and 1=2 ";
        String mesf = " and 1=2 ";
        String semana_atualf = " and 1=2 ";
        if (tipoSelecionado.equalsIgnoreCase("anterior")) {
          dia_anteriorf = " ";
        }
        if (tipoSelecionado.equalsIgnoreCase("atual")) {
          dia_atualf = " ";
        }
        if (tipoSelecionado.equalsIgnoreCase("mes")) {
          mesf = " ";
        }
        if (tipoSelecionado.equalsIgnoreCase("semana_atual")) {
          semana_atualf = " ";
        }
        StringBuilder sbf = new StringBuilder();
        sbf.append(" SELECT /*+ all_rows */ ");
        sbf.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'dia_anterior' tipo ");
        sbf.append("      , 1 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , null regional ");
        sbf.append("      , null tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("  WHERE empresa = '01' ");
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append(dia_anteriorf);
        sbf.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbf.append("                      FROM semanas sem ");
        sbf.append("                     WHERE data = (SELECT sem.data_mapa ");
        sbf.append("                                     FROM semanas sem ");
        sbf.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'dia_atual' tipo ");
        sbf.append("      , 2 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , null regional ");
        sbf.append("      , null tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append(dia_atualf);
        sbf.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbf.append("                      FROM semanas sem ");
        sbf.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbf.append("  UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'SEMANA ATUAL' datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'semana_atual' tipo ");
        sbf.append("      , 3 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , null regional ");
        sbf.append("      , null tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append(semana_atualf);
        sbf.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sbf.append("                                        FROM semanas sem ");
        sbf.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'SEMANA ATUAL' ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'SEMANA ' || ctl.semana_mapa datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'mes' tipo ");
        sbf.append("      , 4 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , null regional ");
        sbf.append("      , null tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("  WHERE empresa = '01' and 1=2 ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append(mesf);
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'SEMANA ' || ctl.semana_mapa ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'MÊS' datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'mes' tipo ");
        sbf.append("      , 5 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , null regional ");
        sbf.append("      , null tipo_mercado ");
        sbf.append("      , SUM(NVL(ctl.fat_real_pares, 0) + NVL(ctl.fat050_pares, 0)) pares_ano ");
        sbf.append("      , SUM(NVL(ctl.fat_real_vlr, 0) + NVL(ctl.fat050_vlr, 0)) valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        //   sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append(mesf);
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'MÊS' ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'ANO' datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'mes' tipo ");
        sbf.append("      , 6 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , null regional ");
        sbf.append("      , null tipo_mercado ");
        sbf.append("      , SUM(NVL(ctl.fat_real_pares, 0) + NVL(ctl.fat050_pares, 0)) pares_ano ");
        sbf.append("      , SUM(NVL(ctl.fat_real_vlr, 0) + NVL(ctl.fat050_vlr, 0)) valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append(mesf);
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'ANO' ");
        sbf.append("  ORDER BY ordem ");
        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          //        throw new Exception(sbf.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_faturamento = j.select(tablefat, sbf.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_faturamento",res_Jw_entrada_atual_pedidos_faturamento);

        sbf = new StringBuilder();
        sbf.append(" SELECT /*+ all_rows */ ");
        sbf.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'dia_anterior' tipo ");
        sbf.append("      , 1 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) regional ");
        sbf.append("      , rep.rep_tipo_mercado tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("      , rep ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append("    AND ctl.codigo_representante = rep.rep_cdgo ");
        sbf.append(dia_anteriorf);
        sbf.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbf.append("                      FROM semanas sem ");
        sbf.append("                     WHERE data = (SELECT sem.data_mapa ");
        sbf.append("                                     FROM semanas sem ");
        sbf.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbf.append("         , pck_regionais_vendas.get_sigla(rep.codigo_regional) ");
        sbf.append("         , rep.rep_tipo_mercado ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'dia_atual' tipo ");
        sbf.append("      , 2 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) regional ");
        sbf.append("      , rep.rep_tipo_mercado tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("      , rep ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append("    AND ctl.codigo_representante = rep.rep_cdgo ");
        sbf.append(dia_atualf);
        sbf.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbf.append("                      FROM semanas sem ");
        sbf.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbf.append("         , pck_regionais_vendas.get_sigla(rep.codigo_regional) ");
        sbf.append("         , rep.rep_tipo_mercado ");
        sbf.append("  UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'SEMANA ATUAL' datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'semana_atual' tipo ");
        sbf.append("      , 3 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) regional ");
        sbf.append("      , rep.rep_tipo_mercado tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("      , rep ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append("    AND ctl.codigo_representante = rep.rep_cdgo ");
        sbf.append(semana_atualf);
        sbf.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sbf.append("                                        FROM semanas sem ");
        sbf.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'SEMANA ATUAL' ");
        sbf.append("         , pck_regionais_vendas.get_sigla(rep.codigo_regional) ");
        sbf.append("         , rep.rep_tipo_mercado ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'SEMANA ' || ctl.semana_mapa datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'mes' tipo ");
        sbf.append("      , 4 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) regional ");
        sbf.append("      , rep.rep_tipo_mercado tipo_mercado ");
        sbf.append("      , 0 pares_ano ");
        sbf.append("      , 0 valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("      , rep ");
        sbf.append("  WHERE empresa = '01' and 1=2 ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append("    AND ctl.codigo_representante = rep.rep_cdgo ");
        sbf.append(mesf);
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'SEMANA ' || ctl.semana_mapa ");
        sbf.append("         , pck_regionais_vendas.get_sigla(rep.codigo_regional) ");
        sbf.append("         , rep.rep_tipo_mercado ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'MÊS' datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'mes' tipo ");
        sbf.append("      , 5 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) regional ");
        sbf.append("      , rep.rep_tipo_mercado tipo_mercado ");
        sbf.append("      , SUM(NVL(ctl.fat_real_pares, 0) + NVL(ctl.fat050_pares, 0)) pares_ano ");
        sbf.append("      , SUM(NVL(ctl.fat_real_vlr, 0) + NVL(ctl.fat050_vlr, 0)) valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("      , rep ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        //   sbf.append("    AND ctl.ped_tipo IS NOT NULL ");
        sbf.append("    AND ctl.codigo_representante = rep.rep_cdgo ");
        sbf.append(mesf);
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'MÊS' ");
        sbf.append("         , pck_regionais_vendas.get_sigla(rep.codigo_regional) ");
        sbf.append("         , rep.rep_tipo_mercado ");
        sbf.append(" UNION ");
        sbf.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbf.append("      , 'ANO' datam ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_pares else 0 end) pares_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_pares else 0 end) pares_pg ");
        sbf.append("      , SUM(case when ctl.ped_tipo = 'PP' then ctl.fat_real_vlr else 0 end) valor_pp ");
        sbf.append("      , SUM(case when ctl.ped_tipo <> 'PP' then ctl.fat_real_vlr else 0 end) valor_pg ");
        sbf.append("      , SUM(ctl.fat_real_pares) pares_total ");
        sbf.append("      , SUM(ctl.fat_real_vlr) valor_total ");
        sbf.append("      , 'mes' tipo ");
        sbf.append("      , 6 ordem ");
        sbf.append("      , null ped_tipo ");
        sbf.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) regional ");
        sbf.append("      , rep.rep_tipo_mercado tipo_mercado ");
        sbf.append("      , SUM(NVL(ctl.fat_real_pares, 0) + NVL(ctl.fat050_pares, 0)) pares_ano ");
        sbf.append("      , SUM(NVL(ctl.fat_real_vlr, 0) + NVL(ctl.fat050_vlr, 0)) valor_ano ");
        sbf.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbf.append("      , rep ");
        sbf.append("  WHERE empresa = '01' ");
        if (regional != null) {
          sbf.append(" AND pck_representante.get_regional(codigo_representante) = ").append(regional);
        }
        sbf.append("    AND ctl.codigo_representante = rep.rep_cdgo ");
        sbf.append(mesf);
        sbf.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbf.append("         , 'ANO' ");
        sbf.append("         , pck_regionais_vendas.get_sigla(rep.codigo_regional) ");
        sbf.append("         , rep.rep_tipo_mercado ");
        sbf.append("  ORDER BY tipo_mercado desc ");
        sbf.append("         , valor_total desc ");
        if (usuario.mostraQuery()) {
          throw new Exception(sbf.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_faturamento_regional = j.select(tablefat, sbf.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_faturamento_regional",res_Jw_entrada_atual_pedidos_faturamento_regional);

      }



      if (tipoQuebra.equalsIgnoreCase("marca")) {
        Jw_entrada_atual_pedidos_resumo_marcas table2 = new Jw_entrada_atual_pedidos_resumo_marcas();

        String tipoMercadoMarca = "T";
        if (session.getAttribute("entrada_pedidos_tipo_mercado_marca") != null) {
          tipoMercadoMarca = (String) session.getAttribute("entrada_pedidos_tipo_mercado_marca");
        }

        String dia = null;
        String dt = null;
        if (tipoSelecionado.equalsIgnoreCase("anterior")) {
          dia = f.getDia_anterior();
          dt = " AND data = to_date('"+dia + "','dd/mm/yyyy') ";
        }
        if (tipoSelecionado.equalsIgnoreCase("atual")) {
          dia = f.getDia_atual();
          dt = " AND data = to_date('"+dia + "','dd/mm/yyyy') ";
        }
        if (tipoSelecionado.equalsIgnoreCase("mes")) {
          dia = f.getDia_atual();
        }
        if (tipoSelecionado.equalsIgnoreCase("semana_atual")) {
          dia = f.getDia_atual();
          dt = " AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana FROM semanas sem WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ";
        }

        StringBuilder sbr = new StringBuilder();
        sbr.append(" SELECT /*+ all_rows */ ");
        sbr.append("        atualizacao ");
        sbr.append("      , datam ");
        sbr.append("      , codigo_marca ");
        sbr.append("      , descricao_marca ");
        sbr.append("      , mes ");
        sbr.append("      , pr_mes ");
        sbr.append("      , vlr_mes ");
        sbr.append("      , mes1 ");
        sbr.append("      , pr_mes1 ");
        sbr.append("      , vlr_mes1 ");
        sbr.append("      , mes2 ");
        sbr.append("      , pr_mes2 ");
        sbr.append("      , vlr_mes2 ");
        sbr.append("      , mesn ");
        sbr.append("      , pr_mesn ");
        sbr.append("      , vlr_mesn ");
        sbr.append("      , pr_mes1 + pr_mes2 + pr_mesn total_pares ");
        sbr.append("      , vlr_mes1 + vlr_mes2 + vlr_mesn total_valor ");
        sbr.append("      , clientes ");
        sbr.append("      , total_pares_ano ");
        sbr.append("      , total_valor_ano ");
        sbr.append("      , clientes_atendidos_ano ");
        sbr.append("      , clientes_mes1 ");
        sbr.append("      , clientes_mes2 ");
        sbr.append("      , clientes_mesn ");
        sbr.append("      , clientes_atendidos_geral_ano ");
        sbr.append("   FROM (SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        if (tipoSelecionado.equalsIgnoreCase("mes")) {
          sbr.append("           , 'MÊS' datam ");
        } else if (tipoSelecionado.equalsIgnoreCase("semana_atual")) {
          sbr.append("           , 'SEMANA ATUAL' datam ");
        } else {
          sbr.append("           , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        }
        sbr.append("              , mar.codigo_marca ");
        sbr.append("              , mar.descricao_marca ");
        sbr.append("              , INITCAP(RTRIM(TO_CHAR(TO_DATE('"+dia + "','dd/mm/yyyy'), 'Mon', 'nls_date_language = portuguese')) || '/' || TO_CHAR(TO_DATE('"+dia + "','dd/mm/yyyy'), 'yyyy')) mes ");
        sbr.append("              , SUM(NVL(ctl.entped_nomes_pares, 0)) pr_mes ");
        sbr.append("              , SUM(NVL(ctl.entped_nomes_vlr, 0)) vlr_mes ");
        sbr.append("              , INITCAP('Calçados') mes1 ");
        sbr.append("              , SUM(NVL(case when  ctl.faltas not in (7,17,26) then ctl.entped_nomes_pares else 0 end, 0)) pr_mes1 ");
        sbr.append("              , SUM(NVL(case when ctl.faltas not in (7,17,26) then ctl.entped_nomes_vlr else 0 end, 0)) vlr_mes1 ");
        sbr.append("              , INITCAP('Bolsas') mes2 ");
        sbr.append("              , SUM(NVL(case when  ctl.faltas in (7,17) then ctl.entped_nomes_pares else 0 end, 0)) pr_mes2 ");
        sbr.append("              , SUM(NVL(case when ctl.faltas in (7,17) then ctl.entped_nomes_vlr else 0 end, 0)) vlr_mes2 ");
        sbr.append("              , INITCAP('Meias') mesn ");
        sbr.append("              , SUM(NVL(case when  ctl.faltas = 26 then ctl.entped_nomes_pares else 0 end, 0)) pr_mesn ");
        sbr.append("              , SUM(NVL(case when ctl.faltas = 26 then ctl.entped_nomes_vlr else 0 end, 0)) vlr_mesn ");
        sbr.append("              , count(distinct ctl.cli_cdgo) clientes ");
        sbr.append("              , (select (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) + NVL(entped_nomes_geral_pares, 0))) from tmp_mapa_automatico_resumo where codigo_marca = mar.codigo_marca "+filtroCodigoRepresentante + ") total_pares_ano ");
        sbr.append("              , (select (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) from tmp_mapa_automatico_resumo where codigo_marca = mar.codigo_marca "+filtroCodigoRepresentante + ") total_valor_ano ");
        sbr.append("              , (SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc where cc.codigo_marca = mar.codigo_marca "+filtroCodigoRepresentante + " UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.codigo_marca = mar.codigo_marca "+filtroCodigoRepresentante + ")) clientes_atendidos_ano ");
        sbr.append("              , count(distinct case when ctl.faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_mes1 ");
        sbr.append("              , count(distinct case when ctl.faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_mes2 ");
        sbr.append("              , count(distinct case when ctl.faltas = 26 then ctl.cli_cdgo else null end) clientes_mesn ");
        sbr.append("              , (SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca)) clientes_atendidos_geral_ano ");
        sbr.append("           FROM tmp_mapa_automatico_resumo ctl ");
        sbr.append("              , regionais_vendas reg ");
        sbr.append("              , rep rep ");
        sbr.append("              , marcas_produtos mar ");
        sbr.append("          WHERE empresa = '01' ");
        sbr.append("            <parametros> ");
        sbr.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        if (dt != null) {
          sbr.append(dt);
        }
        sbr.append(sbParametros.toString());
        sbr.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbr.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sbr.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sbr.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sbr.append("            AND NVL(ctl.codigo_marca, NULL) = mar.codigo_marca ");
        sbr.append("          GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");

        if (tipoSelecionado.equalsIgnoreCase("mes")) {
          sbr.append("                 , 'MÊS' ");
        } else if (tipoSelecionado.equalsIgnoreCase("semana_atual")) {
          sbr.append("                 , 'SEMANA ATUAL' ");
        } else {
          sbr.append("                 , TO_CHAR(data, 'DD/MM/YYYY') ");
        }
        sbr.append("                 , mar.codigo_marca ");
        sbr.append("                 , mar.descricao_marca) ");
        sbr.append(" ORDER BY total_valor DESC ");


        Vector res_Jw_entrada_atual_pedidos_resumo_marcas = null;
        Vector res_Jw_entrada_atual_pedidos_resumo_marcas_2 = null;

        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sbr.toString());
        }

        String filtroMercado = " AND 1=1 ";
        if (tipoMercadoMarca.equalsIgnoreCase("T")) {
          res_Jw_entrada_atual_pedidos_resumo_marcas = j.select(table2, sbr.toString().replace("<parametros>",filtroMercado), null);
          session.setAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas",res_Jw_entrada_atual_pedidos_resumo_marcas);
        } else {
          if (tipoMercadoMarca.equalsIgnoreCase("A")) {
            res_Jw_entrada_atual_pedidos_resumo_marcas = j.select(table2, sbr.toString().replace("<parametros>","AND rep.rep_tipo_mercado = 'MI'"), null);
            session.setAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas",res_Jw_entrada_atual_pedidos_resumo_marcas);
            res_Jw_entrada_atual_pedidos_resumo_marcas_2 = j.select(table2, sbr.toString().replace("<parametros>","AND rep.rep_tipo_mercado = 'ME'"), null);
            session.setAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas_2",res_Jw_entrada_atual_pedidos_resumo_marcas_2);
          } else {
            filtroMercado = " AND rep.rep_tipo_mercado = '"+tipoMercadoMarca + "'";
            res_Jw_entrada_atual_pedidos_resumo_marcas = j.select(table2, sbr.toString().replace("<parametros>",filtroMercado), null);
            session.setAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas",res_Jw_entrada_atual_pedidos_resumo_marcas);
          }
        }



        session.setAttribute("tipoQuebra", "marca");
        session.removeAttribute("res_Entrada_pedidos_atual_vw");


      }


      if (tipoQuebra.equalsIgnoreCase("regional")) {
        String marcaSelecionada = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
        sbMi.append(" SELECT /*+ all_rows */ ");
        sbMi.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMi.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMi.append("      , 'REGIONAL' tipo ");
        sbMi.append("      , 0 codigo_gerente ");
        sbMi.append("      , rep.codigo_regional ");
        sbMi.append("      , '' rep_cdgo ");
        sbMi.append("      , NULL rep_rzao ");
        sbMi.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMi.append("      , NULL marca ");
        sbMi.append("      , NULL descricao_marca ");
        sbMi.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMi.append("      , 0 total_pares_ano ");
        sbMi.append("      , 0.0 total_valor_ano ");
        sbMi.append("      , 0 clientes_atendidos_ano ");
        sbMi.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMi.append("      , rep rep ");
        sbMi.append("      , regionais_vendas reg ");
        sbMi.append("  WHERE empresa = '01' ");
        sbMi.append(anterior);
        sbMi.append("    AND rep.rep_tipo_MERCADO = 'MI' ");
        sbMi.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMi.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbMi.append("                      FROM semanas sem ");
        sbMi.append("                     WHERE data = (SELECT sem.data_mapa ");
        sbMi.append("                                     FROM semanas sem ");
        sbMi.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sbMi.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMi.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMi.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMi.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMi.append(sbParametros.toString());
        sbMi.append("  GROUP BY rep.codigo_regional ");
        sbMi.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMi.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbMi.append(" UNION ");
        sbMi.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMi.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMi.append("      , 'REGIONAL' tipo ");
        sbMi.append("      , 0 codigo_gerente ");
        sbMi.append("      , rep.codigo_regional ");
        sbMi.append("      , '' rep_cdgo ");
        sbMi.append("      , NULL rep_rzao ");
        sbMi.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMi.append("      , NULL marca ");
        sbMi.append("      , NULL descricao_marca ");
        sbMi.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMi.append("      , 0 total_pares_ano ");
        sbMi.append("      , 0.0 total_valor_ano ");
        sbMi.append("      , 0 clientes_atendidos_ano ");
        sbMi.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMi.append("      , rep rep ");
        sbMi.append("      , regionais_vendas reg ");
        sbMi.append("  WHERE empresa = '01' ");
        sbMi.append(atual);
        sbMi.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sbMi.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMi.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbMi.append("                     FROM semanas sem ");
        sbMi.append("                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sbMi.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMi.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMi.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMi.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMi.append(sbParametros.toString());
        sbMi.append("  GROUP BY rep.codigo_regional ");
        sbMi.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMi.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbMi.append(" UNION ");
        sbMi.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMi.append("      , 'MÊS' datam ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMi.append("      , 'REGIONAL' tipo ");
        sbMi.append("      , 0 codigo_gerente ");
        sbMi.append("      , rep.codigo_regional ");
        sbMi.append("      , '' rep_cdgo ");
        sbMi.append("      , NULL rep_rzao ");
        sbMi.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMi.append("      , NULL marca ");
        sbMi.append("      , NULL descricao_marca ");
        sbMi.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMi.append("        ,(SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) + ");
        sbMi.append("                   NVL(entped_nomes_geral_pares, 0))) FROM tmp_mapa_automatico_resumo cc, rep r ");
        sbMi.append("          WHERE cc.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional  ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append("         AND ctl.codigo_marca = codigo_marca ");
        }
        sbMi.append("              ) total_pares_ano ");
        sbMi.append("        ,(SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + ");
        sbMi.append("               NVL(entped_nomes_geral_vlr, 0))) FROM tmp_mapa_automatico_resumo cc, rep r");
        sbMi.append("           WHERE cc.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append("         AND ctl.codigo_marca = codigo_marca ");
        }
        sbMi.append("              ) total_valor_ano ");
        sbMi.append("        ,(SELECT count(distinct cli_cdgo) FROM ( ");
        sbMi.append("          SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc, rep r");
        sbMi.append("           WHERE cc.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append("          AND ctl.codigo_marca = codigo_marca ");
        }
        sbMi.append("           UNION ");
        sbMi.append("          SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca, rep r");
        sbMi.append("           WHERE cca.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append("          AND ctl.codigo_marca = codigo_marca ");
        }
        sbMi.append("              )) clientes_atendidos_ano ");
        sbMi.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMi.append("      , rep rep");
        sbMi.append("      , regionais_vendas reg ");
        sbMi.append("  WHERE empresa = '01' ");
        sbMi.append(mes);
        sbMi.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sbMi.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMi.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMi.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMi.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMi.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMi.append(sbParametros.toString());
        sbMi.append("  GROUP BY rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append("        , ctl.codigo_marca ");
        }
        sbMi.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMi.append("         , 'MÊS' ");
        sbMi.append("   UNION ");
        sbMi.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMi.append("      , 'SEMANA ATUAL' datam ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMi.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMi.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMi.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMi.append("      , 'REGIONAL' tipo ");
        sbMi.append("      , 0 codigo_gerente ");
        sbMi.append("      , rep.codigo_regional ");
        sbMi.append("      , '' rep_cdgo ");
        sbMi.append("      , NULL rep_rzao ");
        sbMi.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMi.append("      , NULL marca ");
        sbMi.append("      , NULL descricao_marca ");
        sbMi.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMi.append("      , 0 total_pares_ano ");
        sbMi.append("      , 0.0 total_valor_ano ");
        sbMi.append("      , 0 clientes_atendidos_ano ");
        sbMi.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMi.append("      , rep rep ");
        sbMi.append("      , regionais_vendas reg ");
        sbMi.append("  WHERE empresa = '01' ");
        sbMi.append(semana_atual);
        sbMi.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sbMi.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMi.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sbMi.append("                                        FROM semanas sem ");
        sbMi.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sbMi.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMi.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMi.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMi.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMi.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMi.append(sbParametros.toString());
        sbMi.append("  GROUP BY rep.codigo_regional ");
        sbMi.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMi.append("         , 'SEMANA ATUAL' ");
        sbMi.append(" ORDER BY tot_vlr DESC ");


        //Adicionei porque estava trazendo duas regionais pois tem 2 gerentes
        sbMe.append(" SELECT /*+ all_rows */ ");
        sbMe.append("        sigla_regional ");
        sbMe.append("      , NULL codigo_gerente ");
        sbMe.append("      , SUM(pr_pp) pr_pp ");
        sbMe.append("      , SUM(vlr_pp) vlr_pp ");
        sbMe.append("      , SUM(pr_pg) pr_pg ");
        sbMe.append("      , SUM(vlr_pg) vlr_pg ");
        sbMe.append("      , SUM(tot_pares) tot_pares ");
        sbMe.append("      , SUM(tot_vlr) tot_vlr ");
        sbMe.append("      , codigo_regional ");
        sbMe.append("      , SUM(clientes) clientes ");
        sbMe.append("      , SUM(total_pares_ano) total_pares_ano ");
        sbMe.append("      , SUM(total_valor_ano) total_valor_ano ");
        sbMe.append("      , SUM(clientes_atendidos_ano) clientes_atendidos_ano ");
        sbMe.append("   FROM ( ");
        sbMe.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMe.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMe.append("      , 'REGIONAL' tipo ");
        sbMe.append("      , 0 codigo_gerente ");
        sbMe.append("      , rep.codigo_regional ");
        sbMe.append("      , '' rep_cdgo ");
        sbMe.append("      , NULL rep_rzao ");
        sbMe.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMe.append("      , NULL marca ");
        sbMe.append("      , NULL descricao_marca ");
        sbMe.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMe.append("      , 0 total_pares_ano ");
        sbMe.append("      , 0.0 total_valor_ano ");
        sbMe.append("      , 0 clientes_atendidos_ano ");
        sbMe.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMe.append("      , rep rep ");
        sbMe.append("      , regionais_vendas reg ");
        sbMe.append("  WHERE empresa = '01' ");
        sbMe.append(anterior);
        sbMe.append("    AND rep.rep_tipo_mercado = 'ME' ");
        sbMe.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMe.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbMe.append("                      FROM semanas sem ");
        sbMe.append("                     WHERE data = (SELECT sem.data_mapa ");
        sbMe.append("                                     FROM semanas sem ");
        sbMe.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sbMe.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMe.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMe.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMe.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMe.append(sbParametros.toString());
        sbMe.append("  GROUP BY rep.codigo_regional ");
        sbMe.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMe.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbMe.append(" UNION ");
        sbMe.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMe.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMe.append("      , 'REGIONAL' tipo ");
        sbMe.append("      , 0 codigo_gerente ");
        sbMe.append("      , rep.codigo_regional ");
        sbMe.append("      , '' rep_cdgo ");
        sbMe.append("      , NULL rep_rzao ");
        sbMe.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMe.append("      , NULL marca ");
        sbMe.append("      , NULL descricao_marca ");
        sbMe.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMe.append("      , 0 total_pares_ano ");
        sbMe.append("      , 0.0 total_valor_ano ");
        sbMe.append("      , 0 clientes_atendidos_ano ");
        sbMe.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMe.append("      , rep rep ");
        sbMe.append("      , regionais_vendas reg ");
        sbMe.append("  WHERE empresa = '01' ");
        sbMe.append(atual);
        sbMe.append("    AND rep.rep_tipo_mercado = 'ME' ");
        sbMe.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMe.append("    AND data = NVL((SELECT sem.data_mapa ");
        sbMe.append("                     FROM semanas sem ");
        sbMe.append("                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sbMe.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMe.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMe.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMe.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMe.append(sbParametros.toString());
        sbMe.append("  GROUP BY rep.codigo_regional ");
        sbMe.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMe.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sbMe.append(" UNION ");
        sbMe.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMe.append("      , 'MÊS' datam ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMe.append("      , 'REGIONAL' tipo ");
        sbMe.append("      , 0 codigo_gerente ");
        sbMe.append("      , rep.codigo_regional ");
        sbMe.append("      , '' rep_cdgo ");
        sbMe.append("      , NULL rep_rzao ");
        sbMe.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMe.append("      , NULL marca ");
        sbMe.append("      , NULL descricao_marca ");
        sbMe.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMe.append("        ,(SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) + ");
        sbMe.append("                   NVL(entped_nomes_geral_pares, 0))) FROM tmp_mapa_automatico_resumo cc, rep r ");
        sbMe.append("          WHERE cc.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append("         AND ctl.codigo_marca = codigo_marca ");
        }
        sbMe.append("              ) total_pares_ano ");
        sbMe.append("        ,(SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + ");
        sbMe.append("               NVL(entped_nomes_geral_vlr, 0))) FROM tmp_mapa_automatico_resumo cc, rep r ");
        sbMe.append("           WHERE cc.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append("         AND ctl.codigo_marca = codigo_marca ");
        }
        sbMe.append("              ) total_valor_ano ");
        sbMe.append("        ,(SELECT count(distinct cli_cdgo) FROM ( ");
        sbMe.append("          SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc, rep r");
        sbMe.append("           WHERE cc.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append("          AND ctl.codigo_marca = codigo_marca ");
        }
        sbMe.append("           UNION ");
        sbMe.append("          SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca, rep r");
        sbMe.append("           WHERE cca.codigo_representante = r.rep_cdgo "+filtroRep + " and r.codigo_regional = rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append("          AND ctl.codigo_marca = codigo_marca ");
        }
        sbMe.append("              )) clientes_atendidos_ano ");
        sbMe.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMe.append("      , rep rep ");
        sbMe.append("      , regionais_vendas reg ");
        sbMe.append("  WHERE empresa = '01' ");
        sbMe.append(mes);
        sbMe.append("    AND rep.rep_tipo_mercado = 'ME'");
        sbMe.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMe.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMe.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMe.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMe.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMe.append(sbParametros.toString());
        sbMe.append("  GROUP BY rep.codigo_regional ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append("   , ctl.codigo_marca ");
        }
        sbMe.append("      , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMe.append("      , 'MÊS' ");
        sbMe.append("  UNION ");
        sbMe.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sbMe.append("      , 'SEMANA ATUAL' datam ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sbMe.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sbMe.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sbMe.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sbMe.append("      , 'REGIONAL' tipo ");
        sbMe.append("      , 0 codigo_gerente ");
        sbMe.append("      , rep.codigo_regional ");
        sbMe.append("      , '' rep_cdgo ");
        sbMe.append("      , NULL rep_rzao ");
        sbMe.append("      , pck_regionais_vendas.get_sigla(rep.codigo_regional) sigla_regional ");
        sbMe.append("      , NULL marca ");
        sbMe.append("      , NULL descricao_marca ");
        sbMe.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sbMe.append("      , 0 total_pares_ano ");
        sbMe.append("      , 0.0 total_valor_ano ");
        sbMe.append("      , 0 clientes_atendidos_ano ");
        sbMe.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sbMe.append("      , rep rep ");
        sbMe.append("      , regionais_vendas reg ");
        sbMe.append("  WHERE empresa = '01' ");
        sbMe.append(semana_atual);
        sbMe.append("    AND rep.rep_tipo_mercado = 'ME' ");
        sbMe.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sbMe.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sbMe.append("                                        FROM semanas sem ");
        sbMe.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sbMe.append("    AND NVL(to_char(ctl.codigo_representante), NULL) = nvl(rep.rep_cdgo,null) ");
        sbMe.append("    AND NVL(rep.codigo_regional, NULL) = reg.codigo_regional ");
        sbMe.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbMe.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sbMe.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sbMe.append(sbParametros.toString());
        sbMe.append("  GROUP BY rep.codigo_regional ");
        sbMe.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sbMe.append("         , 'SEMANA ATUAL' ");
        sbMe.append(" ORDER BY tot_vlr DESC ");

        sbMe.append(" ) ");
        sbMe.append("  GROUP BY sigla_regional ");
        sbMe.append("         , codigo_regional ");
        sbMe.append("  ORDER BY tot_vlr DESC ");


        StringBuilder sbDatas = new StringBuilder();


        sbDatas.append(" SELECT /*+ all_rows */ ");
        sbDatas.append("        nvl(SUM(clientes_mercado_interno),0)||'#'|| nvl(SUM(clientes_mercado_externo),0) clientes ");
        sbDatas.append("   FROM (SELECT CASE WHEN mercado = 'I' THEN clientes END clientes_mercado_interno ");
        sbDatas.append("               ,CASE WHEN mercado = 'E' THEN clientes END clientes_mercado_externo ");
        sbDatas.append("           FROM (SELECT ger.mercado, COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sbDatas.append("                   FROM tmp_mapa_automatico_resumo ctl ");
        sbDatas.append("                       ,gerentes_regionais_vendas  ger ");
        sbDatas.append("                       ,regionais_vendas           reg ");
        sbDatas.append("                  WHERE empresa = '01' ");
        sbDatas.append("                    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");

        if (tipoSelecionado.equalsIgnoreCase("anterior")) {
          sbDatas.append("    AND data = NVL((SELECT sem.data_mapa ");
          sbDatas.append("                     FROM semanas sem ");
          sbDatas.append("                    WHERE data = (SELECT sem.data_mapa ");
          sbDatas.append("                                    FROM semanas sem ");
          sbDatas.append("                                   WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        }
        if (tipoSelecionado.equalsIgnoreCase("atual")) {
          sbDatas.append("    AND data = NVL((SELECT sem.data_mapa ");
          sbDatas.append("                     FROM semanas sem ");
          sbDatas.append("                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        }
        if (tipoSelecionado.equalsIgnoreCase("mes")) {
          sbDatas.append("");
        }
        if (tipoSelecionado.equalsIgnoreCase("semana_atual")) {
          sbDatas.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
          sbDatas.append("                                        FROM semanas sem ");
          sbDatas.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        }
        sbDatas.append("                    AND NVL(ctl.codigo_gerente, NULL) = ");
        sbDatas.append("                        NVL(ger.codigo_gerente, NULL) ");
        sbDatas.append("                    AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
        sbDatas.append("                    AND (NVL(ctl.entped_pp_pares, 0) + ");
        sbDatas.append("                        NVL(ctl.entped_pg_pares, 0) + ");
        sbDatas.append("                        NVL(ctl.entped_rr_pares, 0) + ");
        sbDatas.append("                        NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sbDatas.append("                    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + ");
        sbDatas.append("                        NVL(ctl.entped_rr_vlr, 0) + ");
        sbDatas.append("                        NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sbDatas.append("                  GROUP BY ger.mercado )) ");
        String[] clientesMeMi = query.retorna(sbDatas.toString()).split("#");
        session.setAttribute("clientes_mercado_interno", Integer.parseInt(clientesMeMi[0]));
        session.setAttribute("clientes_mercado_externo", Integer.parseInt(clientesMeMi[1]));
      }


      if (tipoQuebra.equalsIgnoreCase("representante")) {
        String seg = "";
        String vendas = "S";
        String segmento = "";
        String segmentoAno = "";
        if (session.getAttribute("entrada_pedidos_representantes_vendas") != null) {
          vendas = (String) session.getAttribute("entrada_pedidos_representantes_vendas");
        }
        seg = (String) session.getAttribute("entrada_pedidos_representantes_vendas_segmentos") + "";
        if (vendas.equalsIgnoreCase("S")) {

          if (seg.equalsIgnoreCase("C")) {
            segmento = "AND ctl.faltas not in (7,17,26)";
          } else if (seg.equalsIgnoreCase("B")) {
            segmento = "AND ctl.faltas in (7,17)";
          } else if (seg.equalsIgnoreCase("M")) {
            segmento = "AND ctl.faltas = 26";
          }
        }
        session.setAttribute("res_Jw_entrada_atual_pedidos_filtro_segmento",segmento);
        segmentoAno = segmento.replaceAll("ctl.","");
        session.setAttribute("entrada_pedidos_representantes_vendas_mostrar_segmentos",vendas);

        if (vendas.equalsIgnoreCase("N")) {
          sb.append(" SELECT * FROM ( ");
        }

        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'REPRESENTANTE' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , rep.rep_cdgo ");
        sb.append("      , rep.rep_nome rep_rzao ");
        sb.append("      , reg.sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");

        if (vendas.equalsIgnoreCase("N")) {
          sb.append("      , nvl((SUM( decode(ctl.faltas, 26, NVL(ctl.entped_pp_pares, 0),0) ) + (SUM( decode(ctl.faltas, 26,NVL(ctl.entped_pg_pares, 0),0)) + SUM(NVL(ctl.entped_rr_pares, 0)))),0) tot_pares_meias ");
          sb.append("      , nvl((SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas in (7,17) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_bolsas ");
          sb.append("      , nvl((SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_calcados ");
        }

        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(anterior);
        sb.append(segmento);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                     FROM semanas sem ");
        sb.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        if (vendas.equalsIgnoreCase("S")) {
          sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
          sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        }
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rep_cdgo ");
        sb.append("         , rep_nome ");
        sb.append("         , reg.sigla_regional ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        //          if(!vendas.equalsIgnoreCase("S")) {
        //             sb.append(" HAVING (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) = 0 ");
        //          }
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'REPRESENTANTE' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , rep.rep_cdgo ");
        sb.append("      , rep.rep_nome rep_rzao ");
        sb.append("      , reg.sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");

        if (vendas.equalsIgnoreCase("N")) {
          sb.append("      , nvl((SUM( decode(ctl.faltas, 26, NVL(ctl.entped_pp_pares, 0),0) ) + (SUM( decode(ctl.faltas, 26,NVL(ctl.entped_pg_pares, 0),0)) + SUM(NVL(ctl.entped_rr_pares, 0)))),0) tot_pares_meias ");
          sb.append("      , nvl((SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas in (7,17) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_bolsas ");
          sb.append("      , nvl((SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_calcados ");
        }

        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(atual);
        sb.append(segmento);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        if (vendas.equalsIgnoreCase("S")) {
          sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
          sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        }
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rep_cdgo ");
        sb.append("         , rep_nome ");
        sb.append("         , reg.sigla_regional ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        //          if(!vendas.equalsIgnoreCase("S")) {
        //             sb.append(" HAVING (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) = 0 ");
        //          }
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'REPRESENTANTE' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , rep.rep_cdgo rep_cdgo ");
        sb.append("      , rep.rep_nome rep_rzao ");
        sb.append("      , reg.sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , (SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
        sb.append("                    NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo where codigo_representante = rep.rep_cdgo "+segmentoAno + ") total_pares_ano ");
        sb.append("      , (SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) +  ");
        sb.append("                    NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo where codigo_representante = rep.rep_cdgo "+segmentoAno + ") total_valor_ano ");
        sb.append("      , (SELECT COUNT(DISTINCT(cli_cdgo)) FROM (SELECT cli_cdgo FROM tmp_mapa_automatico_resumo WHERE codigo_representante = rep.rep_cdgo "+segmentoAno + " UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.codigo_representante = rep.rep_cdgo)) clientes_atendidos_ano ");

        if (vendas.equalsIgnoreCase("N")) {
          sb.append("      , nvl((SUM( decode(ctl.faltas, 26, NVL(ctl.entped_pp_pares, 0),0) ) + (SUM( decode(ctl.faltas, 26,NVL(ctl.entped_pg_pares, 0),0)) + SUM(NVL(ctl.entped_rr_pares, 0)))),0) tot_pares_meias ");
          sb.append("      , nvl((SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas in (7,17) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_bolsas ");
          sb.append("      , nvl((SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_calcados ");
        }

        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(mes);
        sb.append(segmento);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        if (vendas.equalsIgnoreCase("S")) {
          sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
          sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        }
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rep_cdgo ");
        sb.append("         , rep_nome ");
        sb.append("         , reg.sigla_regional ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        //          if(!vendas.equalsIgnoreCase("S")) {
        //             sb.append(" HAVING (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) = 0 ");
        //          }
        sb.append("  UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , 'REPRESENTANTE' tipo ");
        sb.append("      , NULL codigo_gerente ");
        sb.append("      , NULL codigo_regional ");
        sb.append("      , rep.rep_cdgo ");
        sb.append("      , rep.rep_nome rep_rzao ");
        sb.append("      , reg.sigla_regional ");
        sb.append("      , NULL marca ");
        sb.append("      , NULL descricao_marca ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");

        if (vendas.equalsIgnoreCase("N")) {
          sb.append("      , nvl((SUM( decode(ctl.faltas, 26, NVL(ctl.entped_pp_pares, 0),0) ) + (SUM( decode(ctl.faltas, 26,NVL(ctl.entped_pg_pares, 0),0)) + SUM(NVL(ctl.entped_rr_pares, 0)))),0) tot_pares_meias ");
          sb.append("      , nvl((SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas in (7,17) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas in (7,17) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_bolsas ");
          sb.append("      , nvl((SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pp_pares, 0) end ) + (SUM( case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_pg_pares, 0) end) + SUM(case when ctl.faltas not in (7,17,26) then NVL(ctl.entped_rr_pares, 0) end))),0) tot_pares_calcados ");
        }

        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(semana_atual);
        sb.append(segmento);
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sb.append("                                        FROM semanas sem ");
        sb.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        if (vendas.equalsIgnoreCase("S")) {
          sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
          sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        }
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rep_cdgo ");
        sb.append("         , rep_nome ");
        sb.append("         , reg.sigla_regional ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
        //          if(!vendas.equalsIgnoreCase("S")) {
        //             sb.append(" HAVING (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) = 0 ");
        //          }
        if (vendas.equalsIgnoreCase("S")) {
          sb.append("  ORDER BY tot_vlr DESC ");
        } else {
          sb.append("  ORDER BY sigla_regional ");
          sb.append("         , rep_cdgo ");
        }



        if (vendas.equalsIgnoreCase("N")) {
          sb.append(" ) ");
          sb.append(" WHERE 1=1 ");
          if (seg.equalsIgnoreCase("C")) {
            sb.append(" AND tot_pares_calcados = 0 ");
            sb.append(" AND (tot_pares_meias + tot_pares_bolsas) > 0 ");
            sb.append("  ORDER BY tot_vlr DESC ");
          } else if (seg.equalsIgnoreCase("B")) {
            sb.append(" AND tot_pares_bolsas = 0 ");
            sb.append(" AND (tot_pares_meias + tot_pares_calcados) > 0 ");
            sb.append("  ORDER BY tot_vlr DESC ");
          } else if (seg.equalsIgnoreCase("M")) {
            sb.append(" AND tot_pares_meias = 0 ");
            sb.append(" AND (tot_pares_meias + tot_pares_bolsas) > 0 ");
            sb.append("  ORDER BY tot_vlr DESC ");
          } else {
            sb.append(" AND tot_pares = 0 ");
            sb.append(" ORDER BY sigla_regional ");
            sb.append("        , rep_cdgo ");
          }

        }
      }


      if (tipoQuebra.equalsIgnoreCase("cliente") || tipoQuebra.equalsIgnoreCase("clienteRegional")) {
        String marcaSelecionada = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
        String mercado = (String) session.getAttribute("mercado") != null ? (String) session.getAttribute("mercado") : "todos";
        String codigoRegional = session.getAttribute("entrada_pedidos_regional_cliente_selecionada") != null ? ((String) session.getAttribute("entrada_pedidos_regional_cliente_selecionada")) : null;
        Jw_entrada_atual_pedidos_clientes table_clientes = new Jw_entrada_atual_pedidos_clientes();
        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , cli.cli_cdgo ");
        sb.append("      , cli.cli_rzao ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(anterior);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        if (codigoRegional != null) {
          sb.append(" AND reg.codigo_regional = " + codigoRegional);
        }
        if (!mercado.equalsIgnoreCase("todos") && mercado != null) {
          if (mercado.toString().equalsIgnoreCase("ME")) {
            sb.append(" AND cli.cli_tipo_mercado = 'EX'");
          } else {
            sb.append(" AND cli.cli_tipo_mercado = '"+mercado + "'");
          }
        }
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                     FROM semanas sem ");
        sb.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY cli.cli_cdgo ");
        sb.append("         , cli.cli_rzao ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , cli.cli_cdgo ");
        sb.append("      , cli.cli_rzao ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(atual);
        if (codigoRegional != null) {
          sb.append(" AND reg.codigo_regional = " + codigoRegional);
        }
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        if (!mercado.equalsIgnoreCase("todos") && mercado != null) {
          if (mercado.toString().equalsIgnoreCase("ME")) {
            sb.append(" AND cli.cli_tipo_mercado = 'EX'");
          } else {
            sb.append(" AND cli.cli_tipo_mercado = '"+mercado + "'");
          }
        }
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY cli.cli_cdgo ");
        sb.append("         , cli.cli_rzao ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , cli.cli_cdgo ");
        sb.append("      , cli.cli_rzao ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) + (select sum(cca.pares) from ubiratan.tmp_mapa_res_acumulado1 cca where cca.cli_cdgo_ano = cli.cli_cdgo and nvl(cca.codigo_marca, null) = "+marcaSelecionada + filtroCodigoRepresentante + ") total_pares_ano ");
          sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) + (select sum(cca.valor) from ubiratan.tmp_mapa_res_acumulado1 cca where cca.cli_cdgo_ano = cli.cli_cdgo and nvl(cca.codigo_marca, null) = "+marcaSelecionada + filtroCodigoRepresentante + ") total_valor_ano ");
          sb.append("      , (SELECT count(distinct cli_cdgo) FROM (select cli_cdgo from tmp_mapa_automatico_resumo t where t.cli_cdgo  = cli.cli_cdgo and nvl(t.codigo_marca,null) = "+marcaSelecionada + " union select cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca where cca.cli_cdgo = cli.cli_cdgo and nvl(cca.codigo_marca,null) = "+marcaSelecionada + filtroCodigoRepresentante + " )) clientes_atendidos_ano ");
        } else {
          sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) + (select sum(cca.pares) from ubiratan.tmp_mapa_res_acumulado1 cca where cca.cli_cdgo_ano = cli.cli_cdgo "+filtroCodigoRepresentante + ") total_pares_ano ");
          sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2)  + (select sum(cca.valor) from ubiratan.tmp_mapa_res_acumulado1 cca where cca.cli_cdgo_ano = cli.cli_cdgo "+filtroCodigoRepresentante + ") total_valor_ano ");
          sb.append("      , (SELECT count(distinct cli_cdgo) FROM (select cli_cdgo from tmp_mapa_automatico_resumo t where t.cli_cdgo  = cli.cli_cdgo "+filtroCodigoRepresentante + " union select cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca where cca.cli_cdgo = cli.cli_cdgo "+filtroCodigoRepresentante + ")) clientes_atendidos_ano ");
        }
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(mes);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        if (codigoRegional != null) {
          sb.append(" AND reg.codigo_regional = " + codigoRegional);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        if (!mercado.equalsIgnoreCase("todos") && mercado != null) {
          if (mercado.toString().equalsIgnoreCase("ME")) {
            sb.append(" AND cli.cli_tipo_mercado = 'EX'");
          } else {
            sb.append(" AND cli.cli_tipo_mercado = '"+mercado + "'");
          }
        }
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY cli.cli_cdgo ");
        sb.append("         , cli.cli_rzao ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        sb.append("  UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , cli.cli_cdgo ");
        sb.append("      , cli.cli_rzao ");
        sb.append("      , count(distinct ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM tmp_mapa_automatico_resumo ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(semana_atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        if (codigoRegional != null) {
          sb.append(" AND reg.codigo_regional = " + codigoRegional);
        }
        if (!mercado.equalsIgnoreCase("todos") && mercado != null) {
          if (mercado.toString().equalsIgnoreCase("ME")) {
            sb.append(" AND cli.cli_tipo_mercado = 'EX'");
          } else {
            sb.append(" AND cli.cli_tipo_mercado = '"+mercado + "'");
          }
        }
        sb.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sb.append("                                                  FROM semanas sem ");
        sb.append("                                                 WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY cli.cli_cdgo ");
        sb.append("         , cli.cli_rzao ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
        sb.append(" ORDER BY tot_vlr DESC ");

        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sb.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_clientes = j.select(table_clientes, sb.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_clientes",res_Jw_entrada_atual_pedidos_clientes);
      }


      if (tipoQuebra.equalsIgnoreCase("estilo")) {
        String marcaSelecionada = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
        Jw_entrada_atual_pedidos_estilos table_estilos = new Jw_entrada_atual_pedidos_estilos();
        sb = new StringBuilder();
        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , id_tipo_estilos ");
        sb.append("      , descricao_estilos ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(anterior);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                     FROM semanas sem ");
        sb.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) +  NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY id_tipo_estilos ");
        sb.append("         , descricao_estilos ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , id_tipo_estilos ");
        sb.append("      , descricao_estilos ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + ");
        sb.append("        NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + ");
        sb.append("        NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY id_tipo_estilos ");
        sb.append("         , descricao_estilos ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , id_tipo_estilos ");
        sb.append("      , descricao_estilos ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
          sb.append("                          NVL(entped_rr_pares, 0) + ");
          sb.append("                          NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo ");
          sb.append("               WHERE id_tipo_estilos = ctl.id_tipo_estilos and nvl(codigo_marca,null)="+marcaSelecionada + ") total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
          sb.append("                     NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo ");
          sb.append("                WHERE id_tipo_estilos = ctl.id_tipo_estilos and nvl(codigo_marca,null)="+marcaSelecionada + ") total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) from (select cli_cdgo from tmp_mapa_automatico_resumo WHERE id_tipo_estilos = ctl.id_tipo_estilos and nvl(codigo_marca, null) = "+marcaSelecionada + " union select cca.cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.id_tipo_estilos = ctl.id_tipo_estilos and nvl(cca.codigo_marca, null) = "+marcaSelecionada + " )) clientes_atendidos_ano ");
        } else {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
          sb.append("                          NVL(entped_rr_pares, 0) + ");
          sb.append("                          NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo ");
          sb.append("               WHERE id_tipo_estilos = ctl.id_tipo_estilos ) total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
          sb.append("                     NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo ");
          sb.append("                WHERE id_tipo_estilos = ctl.id_tipo_estilos) total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) from (select cli_cdgo from tmp_mapa_automatico_resumo WHERE id_tipo_estilos = ctl.id_tipo_estilos union select cca.cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.id_tipo_estilos = ctl.id_tipo_estilos )) clientes_atendidos_ano ");
        }
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(mes);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.id_tipo_estilos ");
        sb.append("         , ctl.descricao_estilos ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , id_tipo_estilos ");
        sb.append("      , descricao_estilos ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(semana_atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND NVL(ctl.semana_mapa, NULL) IN ");
        sb.append("        (SELECT sem.semana ");
        sb.append("           FROM semanas sem ");
        sb.append("          WHERE data = TRUNC(CASE ");
        sb.append("                               WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND ");
        sb.append("                                    EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP)) < 8) THEN ");
        sb.append("                                TRUNC(SYSDATE) - 1 ");
        sb.append("                               ELSE ");
        sb.append("                                TRUNC(SYSDATE) ");
        sb.append("                             END)) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY id_tipo_estilos ");
        sb.append("         , descricao_estilos ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
        sb.append("  ORDER BY tot_vlr DESC ");

        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sb.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_estilos = j.select(table_estilos, sb.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_estilos", res_Jw_entrada_atual_pedidos_estilos);
      }



      if (tipoQuebra.equalsIgnoreCase("unidade")) {
        String marcaSelecionada = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
        Jw_entrada_atual_pedidos_unidades table_unidades = new Jw_entrada_atual_pedidos_unidades();
        sb = new StringBuilder();
        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , unn_descri");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        if (!usuarioRepresentante) {
          sb.append("      , cli ");
        }
        sb.append("  WHERE empresa = '01' ");
        sb.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sb.append(anterior);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        if (!usuarioRepresentante) {
          sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        }
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                     FROM semanas sem ");
        sb.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) +  NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY unn_descri ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , unn_descri");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        if (!usuarioRepresentante) {
          sb.append("      , cli ");
        }
        sb.append("  WHERE empresa = '01' ");
        sb.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sb.append(atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        if (!usuarioRepresentante) {
          sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        }
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY unn_descri ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , nvl(unn_descri,'-') unn_descri ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
          sb.append("                          NVL(entped_rr_pares, 0) + ");
          sb.append("                          NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo t, rep r ");
          sb.append("               WHERE t.codigo_representante = r.rep_cdgo and r.rep_tipo_mercado = 'MI' AND nvl(unn_descri,'X') = nvl(ctl.unn_descri,'X') and nvl(codigo_marca, null)="+marcaSelecionada + filtroCodigoRepresentante + ") total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo t, rep r ");
          sb.append("                WHERE t.codigo_representante  = r.rep_cdgo and r.rep_tipo_mercado = 'MI' AND nvl(unn_descri,'X') = nvl(ctl.unn_descri,'X') and nvl(codigo_marca,null)="+marcaSelecionada + filtroCodigoRepresentante + ") total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) from (select cli_cdgo from tmp_mapa_automatico_resumo WHERE unn_descri = ctl.unn_descri and nvl(codigo_marca, null) = "+marcaSelecionada + filtroCodigoRepresentante + " union select cca.cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.unn_descri = ctl.unn_descri and nvl(cca.codigo_marca, null) = "+marcaSelecionada + filtroCodigoRepresentante + " )) clientes_atendidos_ano ");
        } else {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) + NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo t, rep r ");
          sb.append("               WHERE t.codigo_representante = r.rep_cdgo and r.rep_tipo_mercado = 'MI' "+filtroCodigoRepresentante + " AND nvl(unn_descri,'X') = nvl(ctl.unn_descri,'X')) total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo t, rep r ");
          sb.append("                WHERE t.codigo_representante = r.rep_cdgo "+filtroCodigoRepresentante + " and r.rep_tipo_mercado = 'MI' AND nvl(unn_descri,'X') = nvl(ctl.unn_descri,'X')) total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) from (select cli_cdgo from tmp_mapa_automatico_resumo t, rep r WHERE t.codigo_representante = r.rep_cdgo and r.rep_tipo_mercado = 'MI' and unn_descri = ctl.unn_descri "+filtroCodigoRepresentante + " union select cca.cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca WHERE 1=1 "+filtroCodigoRepresentante + " and nvl(cca.unn_descri,'X') = nvl(ctl.unn_descri,'X'))) clientes_atendidos_ano ");
        }
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        if (!usuarioRepresentante) {
          sb.append("      , cli ");
        }
        sb.append("  WHERE empresa = '01' ");
        sb.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sb.append(mes);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        if (!usuarioRepresentante) {
          sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        }
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.unn_descri ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , unn_descri ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        if (!usuarioRepresentante) {
          sb.append("      , cli ");
        }
        sb.append("  WHERE empresa = '01' ");
        sb.append("    AND rep.rep_tipo_mercado = 'MI' ");
        sb.append(semana_atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        if (!usuarioRepresentante) {
          sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        }
        sb.append("    AND NVL(ctl.semana_mapa, NULL) IN ");
        sb.append("        (SELECT sem.semana ");
        sb.append("           FROM semanas sem ");
        sb.append("          WHERE data = TRUNC(CASE ");
        sb.append("                               WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND ");
        sb.append("                                    EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP)) < 8) THEN ");
        sb.append("                                TRUNC(SYSDATE) - 1 ");
        sb.append("                               ELSE ");
        sb.append("                                TRUNC(SYSDATE) ");
        sb.append("                             END)) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY unn_descri ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
        sb.append("  ORDER BY tot_vlr DESC ");

        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sb.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_unidades = j.select(table_unidades, sb.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_unidades", res_Jw_entrada_atual_pedidos_unidades);

        Vector res_Jw_entrada_atual_pedidos_unidades_me = j.select(table_unidades, sb.toString().replaceAll("= 'MI'","= 'ME'"), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_unidades_me", res_Jw_entrada_atual_pedidos_unidades_me);
      }



      if (tipoQuebra.equalsIgnoreCase("tipoProduto")) {
        String marcaSelecionada = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
        Jw_entrada_atual_pedidos_tipo_produto table_tipo_produto = new Jw_entrada_atual_pedidos_tipo_produto();
        sb = new StringBuilder();
        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , rv_meaning tipo_produto ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        //        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(anterior);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        //        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                     FROM semanas sem ");
        sb.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) +  NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rv_meaning ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , rv_meaning tipo_produto ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        //        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        //        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rv_meaning ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , rv_meaning tipo_produto ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
          sb.append("                          NVL(entped_rr_pares, 0) + ");
          sb.append("                          NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo ");
          sb.append("               WHERE rv_meaning = ctl.rv_meaning and nvl(codigo_marca, null)="+marcaSelecionada + filtroCodigoRepresentante + ") total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo ");
          sb.append("                WHERE rv_meaning = ctl.rv_meaning and nvl(codigo_marca,null)="+marcaSelecionada + filtroCodigoRepresentante + ") total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) from (select cli_cdgo from tmp_mapa_automatico_resumo WHERE rv_meaning = ctl.rv_meaning and nvl(codigo_marca, null) = "+marcaSelecionada + filtroCodigoRepresentante + " union select cca.cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.rv_meaning = ctl.rv_meaning and nvl(cca.codigo_marca, null) = "+marcaSelecionada + filtroCodigoRepresentante + " )) clientes_atendidos_ano ");
        } else {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) + NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo ");
          sb.append("               WHERE rv_meaning = ctl.rv_meaning "+filtroCodigoRepresentante + ") total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo ");
          sb.append("                WHERE rv_meaning = ctl.rv_meaning "+filtroCodigoRepresentante + ") total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) from (select cli_cdgo from tmp_mapa_automatico_resumo WHERE rv_meaning = ctl.rv_meaning "+filtroCodigoRepresentante + " union select cca.cli_cdgo_ano cli_cdgo from ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.rv_meaning = ctl.rv_meaning "+filtroCodigoRepresentante + ")) clientes_atendidos_ano ");
        }
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("           FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        //        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(mes);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        //        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.rv_meaning ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , rv_meaning tipo_produto ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        //        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(semana_atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        //        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND NVL(ctl.semana_mapa, NULL) IN ");
        sb.append("        (SELECT sem.semana ");
        sb.append("           FROM semanas sem ");
        sb.append("          WHERE data = TRUNC(CASE ");
        sb.append("                               WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND ");
        sb.append("                                    EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP)) < 8) THEN ");
        sb.append("                                TRUNC(SYSDATE) - 1 ");
        sb.append("                               ELSE ");
        sb.append("                                TRUNC(SYSDATE) ");
        sb.append("                             END)) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY rv_meaning ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
        sb.append("  ORDER BY tot_vlr DESC ");

        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sb.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_tipo_produto = j.select(table_tipo_produto, sb.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_tipo_produto", res_Jw_entrada_atual_pedidos_tipo_produto);
      }








      if (tipoQuebra.equalsIgnoreCase("grupo")) {
        String marcaSelecionada = (String) session.getAttribute("entrada_pedidos_marca_selecionada");
        Jw_entrada_atual_pedidos_grupos table_grupos = new Jw_entrada_atual_pedidos_grupos();
        sb.append(" SELECT /*+ all_rows */ ");
        sb.append("        TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , CASE WHEN gre_grupo IS NOT NULL THEN ctl.gre_grupo ELSE ctl.gre_descricao END gre_descricao ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("              , CASE WHEN pck_cliente.get_grupo_economico(ctl.cli_cdgo) IS NOT NULL THEN ");
        sb.append("                  ('GRUPO : ' || ");
        sb.append("                   pck_cliente.get_grupo_economico(ctl.cli_cdgo) || ' - ' || ");
        sb.append("                   pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(ctl.cli_cdgo))) ");
        sb.append("                ELSE ");
        sb.append("                   NULL ");
        sb.append("                END gre_grupo ");
        sb.append("          FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(anterior);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = (SELECT sem.data_mapa ");
        sb.append("                                     FROM semanas sem ");
        sb.append("                                    WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')) - 1), to_date('"+diaAtual + "','dd/mm/yyyy') - 1) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.gre_descricao ");
        sb.append("         , ctl.gre_grupo ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , CASE WHEN gre_grupo IS NOT NULL THEN ctl.gre_grupo ELSE ctl.gre_descricao END gre_descricao ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("              , CASE WHEN pck_cliente.get_grupo_economico(ctl.cli_cdgo) IS NOT NULL THEN ");
        sb.append("                  ('GRUPO : ' || ");
        sb.append("                   pck_cliente.get_grupo_economico(ctl.cli_cdgo) || ' - ' || ");
        sb.append("                   pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(ctl.cli_cdgo))) ");
        sb.append("                ELSE ");
        sb.append("                   NULL ");
        sb.append("                END gre_grupo ");
        sb.append("          FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND data = NVL((SELECT sem.data_mapa ");
        sb.append("                      FROM semanas sem ");
        sb.append("                     WHERE data = to_date('"+diaAtual + "','dd/mm/yyyy')), to_date('"+diaAtual + "','dd/mm/yyyy')) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.gre_descricao ");
        sb.append("         , ctl.gre_grupo ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , TO_CHAR(data, 'DD/MM/YYYY') ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'MÊS' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , CASE WHEN gre_grupo IS NOT NULL THEN ctl.gre_grupo ELSE ctl.gre_descricao END gre_descricao ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
          sb.append("                          NVL(entped_rr_pares, 0) + ");
          sb.append("                          NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo ");
          sb.append("               WHERE gre_descricao = ctl.gre_descricao and nvl(codigo_marca,null)="+marcaSelecionada + ") total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
          sb.append("                     NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo ");
          sb.append("                WHERE gre_descricao = ctl.gre_descricao and nvl(codigo_marca,null)="+marcaSelecionada + ") total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cli_cdgo FROM tmp_mapa_automatico_resumo WHERE gre_descricao = ctl.gre_descricao AND NVL(codigo_marca, NULL) = "+marcaSelecionada + " UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE  ctl.gre_descricao like ('GRUPO  : %') and (REPLACE(ctl.gre_descricao, 'GRUPO  : ', '') = cca.grupo) AND NVL(codigo_marca, NULL) = "+marcaSelecionada + " UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE  ctl.gre_descricao like ('CLIENTE: %') and (REPLACE(ctl.gre_descricao, 'CLIENTE: ', '') = cca.cliente) AND NVL(codigo_marca, NULL) = "+marcaSelecionada + ")) clientes_atendidos_ano ");
        } else {
          sb.append("      , (SELECT (SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
          sb.append("                          NVL(entped_rr_pares, 0) + ");
          sb.append("                          NVL(entped_nomes_geral_pares, 0))) ");
          sb.append("                FROM tmp_mapa_automatico_resumo ");
          sb.append("               WHERE gre_descricao = ctl.gre_descricao) total_pares_ano ");
          sb.append("      , (SELECT (SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
          sb.append("                     NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0))) ");
          sb.append("                 FROM tmp_mapa_automatico_resumo ");
          sb.append("                WHERE gre_descricao = ctl.gre_descricao) total_valor_ano ");
          sb.append("      , (SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cli_cdgo FROM tmp_mapa_automatico_resumo WHERE gre_descricao = ctl.gre_descricao UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE  ctl.gre_descricao like ('GRUPO  : %') and (REPLACE(ctl.gre_descricao, 'GRUPO  : ', '') = cca.grupo) UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE  ctl.gre_descricao like ('CLIENTE: %') and (REPLACE(ctl.gre_descricao, 'CLIENTE: ', '') = cca.cliente))) clientes_atendidos_ano ");
        }
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("              , CASE WHEN pck_cliente.get_grupo_economico(ctl.cli_cdgo) IS NOT NULL THEN ");
        sb.append("                  ('GRUPO : ' || ");
        sb.append("                   pck_cliente.get_grupo_economico(ctl.cli_cdgo) || ' - ' || ");
        sb.append("                   pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(ctl.cli_cdgo))) ");
        sb.append("                ELSE ");
        sb.append("                   NULL ");
        sb.append("                END gre_grupo ");
        sb.append("          FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(mes);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.gre_descricao ");
        sb.append("         , ctl.gre_grupo ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'MÊS' ");
        sb.append(" UNION ");
        sb.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
        sb.append("      , 'SEMANA ATUAL' datam ");
        sb.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
        sb.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
        sb.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
        sb.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
        sb.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
        sb.append("      , CASE WHEN gre_grupo IS NOT NULL THEN ctl.gre_grupo ELSE ctl.gre_descricao END gre_descricao ");
        sb.append("      , COUNT(DISTINCT ctl.cli_cdgo) clientes ");
        sb.append("      , 0 total_pares_ano ");
        sb.append("      , 0.0 total_valor_ano ");
        sb.append("      , 0 clientes_atendidos_ano ");
        sb.append("   FROM (SELECT ctl.* ");
        sb.append("              , CASE WHEN pck_cliente.get_grupo_economico(ctl.cli_cdgo) IS NOT NULL THEN ");
        sb.append("                  ('GRUPO : ' || ");
        sb.append("                   pck_cliente.get_grupo_economico(ctl.cli_cdgo) || ' - ' || ");
        sb.append("                   pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(ctl.cli_cdgo))) ");
        sb.append("                ELSE ");
        sb.append("                   NULL ");
        sb.append("                END gre_grupo ");
        sb.append("          FROM tmp_mapa_automatico_resumo ctl) ctl ");
        sb.append("      , regionais_vendas reg ");
        sb.append("      , rep rep ");
        sb.append("      , cli ");
        sb.append("  WHERE empresa = '01' ");
        sb.append(semana_atual);
        if (!marcaSelecionada.equalsIgnoreCase("T")) {
          sb.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
        }
        sb.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
        sb.append("    AND cli.cli_cdgo = ctl.cli_cdgo ");
        sb.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
        sb.append("                                        FROM semanas sem ");
        sb.append("                                       WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
        sb.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
        sb.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
        sb.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
        sb.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
        sb.append(sbParametros.toString());
        sb.append("  GROUP BY ctl.gre_descricao ");
        sb.append("         , ctl.gre_grupo ");
        sb.append("         , TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
        sb.append("         , 'SEMANA ATUAL' ");
        sb.append(" ORDER BY tot_vlr DESC ");

        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sb.toString());
        }
        Vector res_Jw_entrada_atual_pedidos_grupos = j.select(table_grupos, sb.toString(), null);
        session.setAttribute("res_Jw_entrada_atual_pedidos_grupos",res_Jw_entrada_atual_pedidos_grupos);
      }



      if (tipoQuebra.equalsIgnoreCase("representante")) {
        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sb.toString());
        }
        Vector res_Entrada_pedidos_atual_vw = j.select(t_entrada_pedidos_atual_vw, sb.toString(), null);
        session.setAttribute("res_Entrada_pedidos_atual_vw",res_Entrada_pedidos_atual_vw);
      }

      if (tipoQuebra.equalsIgnoreCase("regional")) {
        acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
        if (usuario.mostraQuery()) {
          throw new Exception(sbMi.toString());
        }
        Vector res_Entrada_pedidos_atual_vw_mi = j.select(t_entrada_pedidos_atual_vw, sbMi.toString(), null);
        session.setAttribute("res_Entrada_pedidos_atual_vw_mi",res_Entrada_pedidos_atual_vw_mi);
        session.setAttribute("res_Entrada_pedidos_atual_vw_mi_select",res_Entrada_pedidos_atual_vw_mi);
        Vector res_Entrada_pedidos_atual_vw_me = j.select(t_entrada_pedidos_atual_vw, sbMe.toString(), null);
        session.setAttribute("res_Entrada_pedidos_atual_vw_me",res_Entrada_pedidos_atual_vw_me);
        session.setAttribute("res_Entrada_pedidos_atual_vw_me_select",res_Entrada_pedidos_atual_vw_me);
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      select1_action(j, mapping, form, request, response);
      //  actionForward = mapping.findForward("same");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;


    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()}, {"semana_atual","like", f.getSemana_atual()} };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");
      session.setAttribute("dataSelecionada",r.getDia_anterior() + "");
      session.setAttribute("tipoSelecionado", "anterior");
      session.setAttribute("mercado", f.getMercado());
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      select2_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"semana_atual","like", f.getSemana_atual()} };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");
      session.setAttribute("dataSelecionada",r.getDia_atual() + "");
      session.setAttribute("tipoSelecionado", "atual");
      session.setAttribute("mercado", f.getMercado());
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      select3_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select3_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()}, {"semana_atual","like", f.getSemana_atual()} };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");
      session.setAttribute("dataSelecionada",r.getMes() + "");
      session.setAttribute("tipoSelecionado", "mes");
      session.setAttribute("mercado", f.getMercado());
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select_semana_atual_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      select_semana_atual_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_semana_atual_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()}, {"semana_atual","like", f.getSemana_atual()} };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");
      session.setAttribute("dataSelecionada", "SEMANA ATUAL");
      session.setAttribute("tipoSelecionado", "semana_atual");
      session.setAttribute("mercado", f.getMercado());
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select4_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      session.setAttribute("tipoQuebra", "marca");
      session.setAttribute("entrada_pedidos_marca_selecionada", "T");
      f.setRegional_cliente("T");


      session.removeAttribute("entrada_pedidos_tipo_mercado_marca");
      if ((f.getMarca_select() != null && f.getMarca_select().equalsIgnoreCase("null") || f.getMarca_select() == null)) {
        f.setMarca_select("T");
      }
      session.setAttribute("entrada_pedidos_tipo_mercado_marca", f.getMarca_select());


      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select5_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      if ((f.getMarca_regional() != null && f.getMarca_regional().equalsIgnoreCase("null") || f.getMarca_regional() == null)) {
        f.setMarca_regional("T");
      }
      session.setAttribute("entrada_pedidos_marca_selecionada", f.getMarca_regional());

      session.setAttribute("tipoQuebra", "regional");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select6_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      session.setAttribute("tipoQuebra", "representante");
      session.setAttribute("entrada_pedidos_marca_selecionada", "T");
      session.setAttribute("entrada_pedidos_representantes_vendas", f.getRepresentantes_vendas());
      session.setAttribute("entrada_pedidos_representantes_vendas_segmentos", f.getRepresentantes_vendas_segmentos());
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select7_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      if ((f.getMarca_cliente() != null && f.getMarca_cliente().equalsIgnoreCase("null") || f.getMarca_cliente() == null)) {
        f.setMarca_cliente("T");
      }
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      session.setAttribute("entrada_pedidos_marca_selecionada", f.getMarca_cliente());
      session.setAttribute("tipoQuebra", "cliente");
      session.setAttribute("mercado", "todos");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select8_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      session.setAttribute("tipoQuebra", "faturamento");
      session.setAttribute("entrada_pedidos_marca_selecionada", "T");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select9_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      if ((f.getMarca_grupo() != null && f.getMarca_grupo().equalsIgnoreCase("null") || f.getMarca_grupo() == null)) {
        f.setMarca_grupo("T");
      }
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      session.setAttribute("entrada_pedidos_marca_selecionada", f.getMarca_grupo());
      session.setAttribute("tipoQuebra", "grupo");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      resetfull_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void resetfull_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()}, };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    session.removeAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas");
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");

      session.setAttribute("dataSelecionada",r.getDia_atual() + "");
      session.setAttribute("tipoSelecionado", "atual");
      session.setAttribute("tipoQuebra","regional");
      session.setAttribute("entrada_pedidos_marca_selecionada", "T");
      session.setAttribute("mercado", "todos");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      acesso.Sessao sessao = new acesso.Sessao(session);
      acesso.Usuario u = new acesso.Usuario();

      u = (acesso.Usuario) session.getAttribute("User");


      if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) {
        //       if(f.getTipo().equalsIgnoreCase("inicio")){
        session.setAttribute("tipoQuebra","representante");
        //       }
      }


      if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
        //       if(f.getTipo().equalsIgnoreCase("inicio")){
        session.setAttribute("tipoQuebra","regional");
        //       }
      }


      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        //       if(f.getTipo().equalsIgnoreCase("inicio")){
        session.setAttribute("tipoQuebra","regional");
        //       }
      }
    }
    session.setAttribute("entrada_pedidos_marca_selecionada","T");
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select10_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      try {
        select10_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select10_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Entrada_pedidos_atual_datas_vw table = new Entrada_pedidos_atual_datas_vw();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()}, };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Entrada_pedidos_atual_datas_vw r = (Entrada_pedidos_atual_datas_vw) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_select12_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      if (f.getMercado().equalsIgnoreCase("null") || f.getMercado() == null) {
        f.setMercado("todos");
      }
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      select12_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=",false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select12_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
    Jw_entrada_pedidos_atual_datas table = new Jw_entrada_pedidos_atual_datas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"dia_anterior","like", f.getDia_anterior()}, {"dia_atual","like", f.getDia_atual()}, {"mes","like", f.getMes()}, {"semana_atual","like", f.getSemana_atual()} };
    Vector res_Entrada_pedidos_atual_datas_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Entrada_pedidos_atual_datas_vw",res_Entrada_pedidos_atual_datas_vw);
    if (res_Entrada_pedidos_atual_datas_vw != null && res_Entrada_pedidos_atual_datas_vw.size() > 0) {
      Jw_entrada_pedidos_atual_datas r = (Jw_entrada_pedidos_atual_datas) res_Entrada_pedidos_atual_datas_vw.elementAt(0);
      f.setDia_anterior((r.getDia_anterior() != null) ? r.getDia_anterior() + "":"");
      f.setDia_atual((r.getDia_atual() != null) ? r.getDia_atual() + "":"");
      f.setMes((r.getMes() != null) ? r.getMes() + "":"");
      f.setSemana_atual((r.getSemana_atual() != null) ? r.getSemana_atual() + "":"");
      f.setTipo(session.getAttribute("tipoSelecionado") != null ? (String) session.getAttribute("tipoSelecionado") : "regional");

      session.setAttribute("tipoSelecionado", f.getTipo());
      session.setAttribute("mercado", f.getMercado());
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select_estilos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      if ((f.getEstilos() != null && f.getEstilos().equalsIgnoreCase("null") || f.getEstilos() == null)) {
        f.setEstilos("T");
      }
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      session.setAttribute("entrada_pedidos_marca_selecionada", f.getEstilos());
      session.setAttribute("tipoQuebra", "estilo");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }








  public ActionForward perform_select_unidades_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      if ((f.getUnidade() != null && f.getUnidade().equalsIgnoreCase("null") || f.getUnidade() == null)) {
        f.setUnidade("T");
      }
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      session.setAttribute("entrada_pedidos_marca_selecionada", f.getUnidade());
      session.setAttribute("tipoQuebra", "unidade");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }


  public ActionForward perform_select_tipo_produto_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      if ((f.getTipo_produto() != null && f.getTipo_produto().equalsIgnoreCase("null") || f.getTipo_produto() == null)) {
        f.setTipo_produto("T");
      }
      f.setRegional_cliente("T");
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      session.setAttribute("entrada_pedidos_marca_selecionada", f.getTipo_produto());
      session.setAttribute("tipoQuebra", "tipoProduto");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }


  public ActionForward perform_select_regional_cliente_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      session.removeAttribute("entrada_pedidos_regional_cliente_selecionada");
      if ((f.getRegional_cliente() != null && f.getRegional_cliente().equalsIgnoreCase("null") || f.getRegional_cliente() == null)) {
        f.setRegional_cliente("T");
      }
      if (!f.getRegional_cliente().equalsIgnoreCase("T")) {
        session.setAttribute("entrada_pedidos_regional_cliente_selecionada", f.getRegional_cliente());
      }
      session.setAttribute("mercado", "todos");
      session.setAttribute("tipoQuebra", "cliente");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select_giro_producao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      String periodo = (String) session.getAttribute("periodoGiroProducao");
      util.consultas.com.EntradaAtualPedidos entradaAtualPedidos = new util.consultas.com.EntradaAtualPedidos();
      entradaAtualPedidos.gerarDados(j, periodo, request);
      List < util.consultas.com.EntradaAtualPedidos.GiroProducao > listaGiro = entradaAtualPedidos.getListaGiroProducao();
      session.setAttribute("giroProducao", listaGiro);
      session.setAttribute("tipoQuebra","giro_producao");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }


  public ActionForward perform_select_giro_producao_atual_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      session.setAttribute("periodoGiroProducao", "atual");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_giro_producao_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select_giro_producao_anterior_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntradaAtualPedidosActionForm f = (EntradaAtualPedidosActionForm) form;
      session.setAttribute("periodoGiroProducao", "anterior");
      actionForward = new ActionForward("/com/EntradaAtualPedidosForm.do?select_giro_producao_action=", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
