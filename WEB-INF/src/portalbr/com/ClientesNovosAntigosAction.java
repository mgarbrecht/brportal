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
 * Creation Date 08/05/2009 07:02:11
 * Last Modify Date 22/06/2015 13:22:44
 */

public class ClientesNovosAntigosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClientesNovosAntigosActionForm f = (ClientesNovosAntigosActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ClientesNovosAntigos_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_novos_antigos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ClientesNovosAntigosActionForm f = (ClientesNovosAntigosActionForm) form;
    Jw_clientes_novos_antigos table = new Jw_clientes_novos_antigos();
    Jw_clientes_novos_antigos_normal table_normal = new Jw_clientes_novos_antigos_normal();
    Jw_clientes_novos_antigos_total_geral table_geral = new Jw_clientes_novos_antigos_total_geral();
    Jw_clientes_novos_antigos_total_marca table_marca = new Jw_clientes_novos_antigos_total_marca();
    Jw_clientes_novos_antigos_total_regional table_regional = new Jw_clientes_novos_antigos_total_regional();
    Jw_clientes_novos_antigos_total_representante table_representante = new Jw_clientes_novos_antigos_total_representante();

    session.removeAttribute("res_Jw_clientes_novos_antigos");
    session.removeAttribute("res_Jw_clientes_novos_antigos_normal");
    session.removeAttribute("res_Jw_clientes_novos_antigos_total_geral");
    session.removeAttribute("res_Jw_clientes_novos_antigos_total_marca");
    session.removeAttribute("res_Jw_clientes_novos_antigos_total_regional");


    StringBuilder parametros = new StringBuilder();
    StringBuilder parametros_recolocados = new StringBuilder();
    //
    session.setAttribute("parametro1",null);
    session.setAttribute("parametro2",null);
    session.setAttribute("parametro3",null);
    //
    if (!f.getP_dt_inicial().equals("")) {
      parametros.append(" and ped.ped_dadg >= to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') ");
      parametros_recolocados.append(" and pe.ped_dadg >= to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') ");
    }
    if (!f.getP_dt_final().equals("")) {
      parametros.append(" and ped.ped_dadg < to_date('"+f.getP_dt_final() + "','dd/mm/yyyy') + 1 ");
      parametros_recolocados.append(" and pe.ped_dadg < to_date('"+f.getP_dt_final() + "','dd/mm/yyyy') + 1 ");
    }
    if (!f.getClientes().equals("")) {
      parametros.append("  and cli.status = '"+f.getClientes() + "' ");
    }
    if (!f.getReg().equals("")) {
      parametros.append("  and nvl(r.codigo_regional,null) = "+f.getReg());
      session.setAttribute("parametro2",f.getReg() + "-"+f.getNome_regional());
    }
    if (!f.getRep_cdgo().equals("")) {
      parametros.append("  and nvl(r.rep_cdgo,null) = '"+f.getRep_cdgo() + "'");
      session.setAttribute("parametro3",f.getRep_cdgo() + "-"+f.getRep_rzao());
    }
    if (!f.getCodigo_marca().equals("")) {
      parametros.append("  and fct_marca_produto(ite.lin_cdgo,ite.ref_cdgo) = "+f.getCodigo_marca());
      session.setAttribute("parametro1",f.getCodigo_marca() + "-"+f.getDescricao_marca());
    }
    StringBuilder sb = new StringBuilder();
    StringBuilder sb_normal = new StringBuilder();
    StringBuilder sb_geral = new StringBuilder();
    StringBuilder sb_marca = new StringBuilder();
    StringBuilder sb_regional = new StringBuilder();
    StringBuilder sb_representante = new StringBuilder();

    sb.append(" SELECT codigo_regional ");
    sb.append("      , nome_regional ");
    sb.append("      , cli_cdgo ");
    sb.append("      , cli_nome ");
    sb.append("      , status ");
    sb.append("      , sum(qtde) qtde ");
    sb.append("      , sum(valor_total) valor_total ");
    sb.append("   FROM ( SELECT r.codigo_regional ");
    sb.append("               , rv.nome_regional ");
    sb.append("               , cli.cli_cdgo ");
    sb.append("               , cli.cli_nome ");
    sb.append("               , cli.status ");
    sb.append("               , sum(ite.ite_qtde) qtde ");
    sb.append("               , fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor_total ");
    sb.append("            FROM ped, ");
    sb.append("                 ( SELECT cli.*, ");
    sb.append("                          CASE ");
    sb.append("                            WHEN (cli.cli_dtin between ");
    sb.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb.append("                               'Novos' ");
    sb.append("                            WHEN (cli.CLI_DATA_REATIVACAO between to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb.append("                               'Reativados' ");
    sb.append("                            ELSE ");
    sb.append("                               'Antigos' ");
    sb.append("                          END status ");
    sb.append("                     FROM cli ) cli, ");
    sb.append("                 ite, ");
    sb.append("                 rep r, ");
    sb.append("                 regionais_vendas rv ");
    sb.append("           WHERE ped.ped_stat <> 'C' ");
    sb.append("             AND r.rep_cdgo = ped.rep_cdgo ");
    //sb.append("             AND NVL(ped.ped_amostra_brinde, 'X') <> 'B' ");
    //sb.append("             AND NVL(ped.ped_substituicao, 'N') <> 'S' ");
    //sb.append("             AND NVL(ped.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P', 'C') ");
    //sb.append("             AND NVL(cli.cli_cdgo, NULL) <> 40000 ");
    sb.append("             AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    sb.append("             AND NVL(ped.rep_cdgo, NULL) = NVL(null, ped.rep_cdgo) ");
    sb.append("             AND cli.cli_cdgo = ped.cli_cdgo ");
    sb.append("             AND ite.ped_nmro = ped.ped_nmro ");
    sb.append("             AND rv.codigo_regional = r.codigo_regional ");
    sb.append("             AND exists (select 1 ");
    sb.append("                           from ped pe ");
    sb.append("                          where pe.ped_nmro = pck_pedidos.get_recolocado(ped.ped_nmro) ");
    sb.append(parametros_recolocados.toString());
    sb.append("                         ) ");
    sb.append(parametros);
    sb.append("           GROUP BY r.codigo_regional, ");
    sb.append("                    rv.nome_regional, ");
    sb.append("                    cli.cli_cdgo, ");
    sb.append("                    cli.cli_nome, ");
    sb.append("                    cli.status, ");
    sb.append("                    ite.ped_nmro, ");
    sb.append("                    ite.ite_seqn) ");
    sb.append(" GROUP BY codigo_regional, nome_regional, cli_cdgo, cli_nome, status ");
    sb.append(" ORDER BY codigo_regional, status, cli_cdgo ");

    //  if(true){throw new Exception(sb.toString());}
    if (!((f.getCb_somente_resumo() + "").equals("S")) && (((f.getCb_quebra_regional() + "").equals("S")))) {
      Vector res_Jw_clientes_novos_antigos = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_clientes_novos_antigos",res_Jw_clientes_novos_antigos);
    }


    // -------------- NORMAL SEM QUEBRA -------------------
    sb_normal.append(" select  cli_cdgo, ");
    sb_normal.append("         cli_nome, ");
    sb_normal.append("         status, ");
    sb_normal.append("         sum(pares) pares, ");
    sb_normal.append("         sum(valor) valor ");
    sb_normal.append("    from (SELECT cli.cli_cdgo, ");
    sb_normal.append("                 cli.cli_nome, ");
    sb_normal.append("                 cli.status, ");
    sb_normal.append("                 sum(ite.ite_qtde) pares, ");
    sb_normal.append("                 fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor ");
    sb_normal.append("            FROM ped, ");
    sb_normal.append("                 (SELECT cli.*, ");
    sb_normal.append("                         CASE ");
    sb_normal.append("                           WHEN (cli.cli_dtin between to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') ");
    sb_normal.append("                           and to_date('"+f.getP_dt_final() + "','dd/mm/yyyy') ");
    sb_normal.append("                           )  THEN ");
    sb_normal.append("                            'Novos' ");
    sb_normal.append("                           when (cli.CLI_DATA_REATIVACAO between to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') ");
    sb_normal.append("                           and to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_normal.append("                            'Reativados' ");
    sb_normal.append("                           ELSE ");
    sb_normal.append("                            'Antigos' ");
    sb_normal.append("                         END status ");
    sb_normal.append("                    FROM cli) cli, ");
    sb_normal.append("                 ite, ");
    sb_normal.append("                 rep r, ");
    sb_normal.append("                 regionais_vendas rv ");
    sb_normal.append("           WHERE ped.ped_stat <> 'C' ");
    sb_normal.append("             AND r.rep_cdgo = ped.rep_cdgo ");
    //sb_normal.append("             and NVL(ped.ped_amostra_brinde, 'X') <> 'B' ");
    //sb_normal.append("             AND NVL(ped.ped_substituicao, 'N') <> 'S' ");
    //sb_normal.append("             AND NVL(ped.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P', 'C') ");
    //sb_normal.append("             AND NVL(cli.cli_cdgo, NULL) <> 40000 ");
    sb_normal.append("             AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    sb_normal.append("             AND NVL(ped.rep_cdgo, NULL) = NVL(null, ped.rep_cdgo) ");
    sb_normal.append("             AND cli.cli_cdgo = ped.cli_cdgo ");
    sb_normal.append("             AND ite.ped_nmro = ped.ped_nmro ");
    sb_normal.append("             and rv.codigo_regional = r.codigo_regional ");
    sb_normal.append("             AND exists (select 1 ");
    sb_normal.append("                           from ped pe ");
    sb_normal.append("                          where pe.ped_nmro = pck_pedidos.get_recolocado(ped.ped_nmro) ");
    sb_normal.append(parametros_recolocados.toString());
    sb_normal.append("                         ) ");
    sb_normal.append(parametros);
    sb_normal.append("           GROUP BY cli.cli_cdgo, ");
    sb_normal.append("                    cli.cli_nome, ");
    sb_normal.append("                    cli.status, ");
    sb_normal.append("                    ite.ped_nmro, ");
    sb_normal.append("                    ite.ite_seqn) ");
    sb_normal.append("   group by cli_cdgo, ");
    sb_normal.append("            cli_nome, ");
    sb_normal.append("            status ");
    sb_normal.append("   ORDER by status, cli_cdgo ");

    //  if(true){throw new Exception(sb_normal.toString());}
    if (!((f.getCb_quebra_regional() + "").equals("S")) && (!((f.getCb_somente_resumo() + "").equals("S")))) {
      Vector res_Jw_clientes_novos_antigos_normal = j.select(table_normal, sb_normal.toString(), null);
      session.setAttribute("res_Jw_clientes_novos_antigos_normal",res_Jw_clientes_novos_antigos_normal);
    }

    //------------------ TOTAL GERAL ----------------------
    sb_geral.append(" SELECT status ");
    sb_geral.append("      , count(distinct cli_cdgo) qtde ");
    sb_geral.append("      , sum(pares) pares ");
    sb_geral.append("      , sum(valor) valor ");
    sb_geral.append("   FROM (SELECT cli.cli_cdgo ");
    sb_geral.append("              , cli.cli_nome ");
    sb_geral.append("              , cli.status ");
    sb_geral.append("              , sum(ite.ite_qtde) pares ");
    sb_geral.append("              , fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor ");
    sb_geral.append("           FROM ped ");
    sb_geral.append("              , (SELECT cli.*, ");
    sb_geral.append("                        CASE ");
    sb_geral.append("                          WHEN (cli.cli_dtin between ");
    sb_geral.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_geral.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_geral.append("                           'Novos' ");
    sb_geral.append("                          WHEN (cli.cli_data_reativacao BETWEEN ");
    sb_geral.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_geral.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_geral.append("                           'Reativados' ");
    sb_geral.append("                          ELSE ");
    sb_geral.append("                           'Antigos' ");
    sb_geral.append("                        END status ");
    sb_geral.append("                   FROM cli) cli ");
    sb_geral.append("              , ite ");
    sb_geral.append("              , rep r ");
    sb_geral.append("              , regionais_vendas rv ");
    sb_geral.append("          WHERE ped.ped_stat <> 'C' ");
    sb_geral.append("            AND r.rep_cdgo = ped.rep_cdgo ");
    //sb_geral.append("            AND nvl(ped.ped_amostra_brinde, 'X') <> 'B' ");
    //sb_geral.append("            AND NVL(ped.ped_substituicao, 'N') <> 'S' ");
    //sb_geral.append("            AND NVL(ped.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P', 'C') ");
    //sb_geral.append("            AND NVL(cli.cli_cdgo, NULL) <> 40000 ");
    sb_geral.append("            AND NVL(ped.rep_cdgo, NULL) = NVL(null, ped.rep_cdgo) ");
    sb_geral.append("             AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    sb_geral.append("            AND cli.cli_cdgo = ped.cli_cdgo ");
    sb_geral.append("            AND ite.ped_nmro = ped.ped_nmro ");
    sb_geral.append("            AND rv.codigo_regional = r.codigo_regional ");
    sb_geral.append("            AND exists (select 1 ");
    sb_geral.append("                          from ped pe ");
    sb_geral.append("                         where pe.ped_nmro = pck_pedidos.get_recolocado(ped.ped_nmro) ");
    sb_geral.append(parametros_recolocados.toString());
    sb_geral.append("                        ) ");
    sb_geral.append(parametros);
    sb_geral.append("          GROUP BY cli.cli_cdgo ");
    sb_geral.append("                 , cli.cli_nome ");
    sb_geral.append("                 , cli.status ");
    sb_geral.append("                 , ite.ped_nmro ");
    sb_geral.append("                 , ite.ite_seqn) ");
    sb_geral.append("  GROUP BY status ");
    sb_geral.append("  ORDER BY status ");

    if ((f.getCb_resumo_geral() + "").equals("S")) {
      Vector res_Jw_clientes_novos_antigos_total_geral = j.select(table_geral, sb_geral.toString(), null);
      session.setAttribute("res_Jw_clientes_novos_antigos_total_geral",res_Jw_clientes_novos_antigos_total_geral);
    }


    //------------- TOTAL MARCA -----------------------------------------
    sb_marca.append(" SELECT codigo_marca ");
    sb_marca.append("      , descricao_marca ");
    sb_marca.append("      , status ");
    sb_marca.append("      , count(distinct cli_cdgo) qtde ");
    sb_marca.append("      , sum(pares) pares ");
    sb_marca.append("      , sum(valor) valor ");
    sb_marca.append("   from (SELECT cli.cli_cdgo, ");
    sb_marca.append("                cli.cli_nome, ");
    sb_marca.append("                cli.status, ");
    sb_marca.append("                fct_marca_produto(ite.lin_cdgo,ite.ref_cdgo) codigo_marca, ");
    sb_marca.append("                mp.descricao_marca, ");
    sb_marca.append("                sum(ite.ite_qtde) pares, ");
    sb_marca.append("                fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor ");
    sb_marca.append("           FROM ped, ");
    sb_marca.append("                (SELECT cli.*, ");
    sb_marca.append("                        CASE ");
    sb_marca.append("                          WHEN (cli.cli_dtin between ");
    sb_marca.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_marca.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_marca.append("                           'Novos' ");
    sb_marca.append("                          WHEN (cli.cli_data_reativacao BETWEEN ");
    sb_marca.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_marca.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_marca.append("                           'Reativados' ");
    sb_marca.append("                          ELSE ");
    sb_marca.append("                           'Antigos' ");
    sb_marca.append("                        END status ");
    sb_marca.append("                   FROM cli) cli, ");
    sb_marca.append("                ite, ");
    sb_marca.append("                rep r, ");
    sb_marca.append("                regionais_vendas rv, ");
    sb_marca.append("                marcas_produtos mp ");
    sb_marca.append("          WHERE ped.ped_stat <> 'C' ");
    sb_marca.append("            AND r.rep_cdgo = ped.rep_cdgo ");
    //sb_marca.append("            AND nvl(ped.ped_amostra_brinde, 'X') <> 'B' ");
    //sb_marca.append("            AND NVL(ped.ped_substituicao, 'N') <> 'S' ");
    //sb_marca.append("            AND NVL(ped.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P', 'C') ");
    //sb_marca.append("            AND NVL(cli.cli_cdgo, NULL) <> 40000 ");
    //sb_marca.append("            AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    sb_marca.append("            AND NVL(ped.rep_cdgo, NULL) = NVL(null, ped.rep_cdgo) ");
    sb_marca.append("            AND cli.cli_cdgo = ped.cli_cdgo ");
    sb_marca.append("            AND ite.ped_nmro = ped.ped_nmro ");
    sb_marca.append("            AND rv.codigo_regional = r.codigo_regional ");
    sb_marca.append("            AND mp.codigo_marca = fct_marca_produto(ite.lin_cdgo,ite.ref_cdgo) ");
    sb_marca.append("            AND exists (select 1 ");
    sb_marca.append("                          from ped pe ");
    sb_marca.append("                         where pe.ped_nmro = pck_pedidos.get_recolocado(ped.ped_nmro) ");
    sb_marca.append(parametros_recolocados.toString());
    sb_marca.append("                        ) ");
    sb_marca.append(parametros);
    sb_marca.append("          GROUP BY cli.cli_cdgo ");
    sb_marca.append("                 , cli.cli_nome ");
    sb_marca.append("                 , cli.status ");
    sb_marca.append("                 , ite.ped_nmro ");
    sb_marca.append("                 , ite.ite_seqn ");
    sb_marca.append("                 , fct_marca_produto(ite.lin_cdgo,ite.ref_cdgo) ");
    sb_marca.append("                 , mp.descricao_marca) ");
    sb_marca.append("  GROUP BY codigo_marca, descricao_marca, status ");
    sb_marca.append("  ORDER by codigo_marca, descricao_marca, status ");

    if ((f.getCb_resumo_marca() + "").equals("S")) {
      Vector res_Jw_clientes_novos_antigos_total_marca = j.select(table_marca, sb_marca.toString(), null);
      session.setAttribute("res_Jw_clientes_novos_antigos_total_marca",res_Jw_clientes_novos_antigos_total_marca);
    }

    //------------- TOTAL REGIONAL -----------------------------------------
    sb_regional.append(" select codigo_regional, ");
    sb_regional.append("        nome_regional, ");
    sb_regional.append("        status, ");
    sb_regional.append("        count(distinct cli_cdgo) qtde, ");
    sb_regional.append("        sum(pares) pares, ");
    sb_regional.append("        sum(valor) valor ");
    sb_regional.append("   from (SELECT cli.cli_cdgo, ");
    sb_regional.append("                cli.cli_nome, ");
    sb_regional.append("                cli.status, ");
    sb_regional.append("                rv.codigo_regional, ");
    sb_regional.append("                rv.nome_regional, ");
    sb_regional.append("                sum(ite.ite_qtde) pares, ");
    sb_regional.append("                fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor ");
    sb_regional.append("           FROM ped, ");
    sb_regional.append("                (SELECT cli.*, ");
    sb_regional.append("                        CASE ");
    sb_regional.append("                          WHEN (cli.cli_dtin between ");
    sb_regional.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_regional.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_regional.append("                           'Novos' ");
    sb_regional.append("                          when (cli.CLI_DATA_REATIVACAO between ");
    sb_regional.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_regional.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_regional.append("                           'Reativados' ");
    sb_regional.append("                          ELSE ");
    sb_regional.append("                           'Antigos' ");
    sb_regional.append("                        END status ");
    sb_regional.append("                   FROM cli) cli, ");
    sb_regional.append("                ite, ");
    sb_regional.append("                rep r, ");
    sb_regional.append("                regionais_vendas rv ");
    sb_regional.append("          WHERE ped.ped_stat <> 'C' ");
    sb_regional.append("            AND r.rep_cdgo = ped.rep_cdgo ");
    //sb_regional.append("            and nvl(ped.ped_amostra_brinde, 'X') <> 'B' ");
    //sb_regional.append("            AND NVL(ped.ped_substituicao, 'N') <> 'S' ");
    //sb_regional.append("            AND NVL(ped.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P', 'C') ");
    //sb_regional.append("            AND NVL(cli.cli_cdgo, NULL) <> 40000 ");
    sb_regional.append("            AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    sb_regional.append("            AND NVL(ped.rep_cdgo, NULL) = NVL(null, ped.rep_cdgo) ");
    sb_regional.append("            AND cli.cli_cdgo = ped.cli_cdgo ");
    sb_regional.append("            AND ite.ped_nmro = ped.ped_nmro ");
    sb_regional.append("            AND rv.codigo_regional = r.codigo_regional ");
    sb_regional.append("            AND exists (select 1 ");
    sb_regional.append("                          from ped pe ");
    sb_regional.append("                         where pe.ped_nmro = pck_pedidos.get_recolocado(ped.ped_nmro) ");
    sb_regional.append(parametros_recolocados.toString());
    sb_regional.append("                        ) ");
    sb_regional.append(parametros);
    sb_regional.append("          GROUP BY cli.cli_cdgo, ");
    sb_regional.append("                   cli.cli_nome, ");
    sb_regional.append("                   cli.status, ");
    sb_regional.append("                   ite.ped_nmro, ");
    sb_regional.append("                   ite.ite_seqn, ");
    sb_regional.append("                   rv.codigo_regional, ");
    sb_regional.append("                   rv.nome_regional) ");
    sb_regional.append("  group by codigo_regional, nome_regional, status ");
    sb_regional.append("  ORDER by codigo_regional, nome_regional, status ");

    if ((f.getCb_resumo_regional() + "").equals("S")) {
      Vector res_Jw_clientes_novos_antigos_total_regional = j.select(table_regional, sb_regional.toString(), null);
      session.setAttribute("res_Jw_clientes_novos_antigos_total_regional",res_Jw_clientes_novos_antigos_total_regional);
    }

    //------------- TOTAL REPRESENTANTE -----------------------------------------
    sb_representante.append(" select rep_cdgo, ");
    sb_representante.append("        rep_rzao, ");
    sb_representante.append("        status, ");
    sb_representante.append("        count(distinct cli_cdgo) qtde, ");
    sb_representante.append("        sum(pares) pares, ");
    sb_representante.append("        sum(valor) valor ");
    sb_representante.append("   from (SELECT cli.cli_cdgo, ");
    sb_representante.append("                cli.cli_nome, ");
    sb_representante.append("                cli.status, ");
    sb_representante.append("                r.rep_cdgo, ");
    sb_representante.append("                r.rep_rzao, ");
    sb_representante.append("                sum(ite.ite_qtde) pares, ");
    sb_representante.append("                fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor ");
    sb_representante.append("           FROM ped, ");
    sb_representante.append("                (SELECT cli.*, ");
    sb_representante.append("                        CASE ");
    sb_representante.append("                          WHEN (cli.cli_dtin between ");
    sb_representante.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_representante.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_representante.append("                           'Novos' ");
    sb_representante.append("                          when (cli.CLI_DATA_REATIVACAO between ");
    sb_representante.append("                               to_date('"+f.getP_dt_inicial() + "','dd/mm/yyyy') and ");
    sb_representante.append("                               to_date('"+f.getP_dt_final() + "','dd/mm/yyyy')) THEN ");
    sb_representante.append("                           'Reativados' ");
    sb_representante.append("                          ELSE ");
    sb_representante.append("                           'Antigos' ");
    sb_representante.append("                        END status ");
    sb_representante.append("                   FROM cli) cli, ");
    sb_representante.append("                ite, ");
    sb_representante.append("                rep r, ");
    sb_representante.append("                regionais_vendas rv ");
    sb_representante.append("          WHERE ped.ped_stat <> 'C' ");
    sb_representante.append("            AND r.rep_cdgo = ped.rep_cdgo ");
    //sb_representante.append("            and nvl(ped.ped_amostra_brinde, 'X') <> 'B' ");
    //sb_representante.append("            AND NVL(ped.ped_substituicao, 'N') <> 'S' ");
    //sb_representante.append("            AND NVL(ped.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P', 'C') ");
    //sb_representante.append("            AND NVL(cli.cli_cdgo, NULL) <> 40000 ");
    sb_representante.append("            AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    sb_representante.append("            AND NVL(ped.rep_cdgo, NULL) = NVL(null, ped.rep_cdgo) ");
    sb_representante.append("            AND cli.cli_cdgo = ped.cli_cdgo ");
    sb_representante.append("            AND ite.ped_nmro = ped.ped_nmro ");
    sb_representante.append("            and rv.codigo_regional = r.codigo_regional ");
    sb_representante.append("            AND exists (select 1 ");
    sb_representante.append("                          from ped pe ");
    sb_representante.append("                         where pe.ped_nmro = pck_pedidos.get_recolocado(ped.ped_nmro) ");
    sb_representante.append(parametros_recolocados.toString());
    sb_representante.append("                        ) ");
    sb_representante.append(parametros);
    sb_representante.append("          GROUP BY cli.cli_cdgo, ");
    sb_representante.append("                   cli.cli_nome, ");
    sb_representante.append("                   cli.status, ");
    sb_representante.append("                   ite.ped_nmro, ");
    sb_representante.append("                   ite.ite_seqn, ");
    sb_representante.append("                   r.rep_cdgo, ");
    sb_representante.append("                   r.rep_rzao) ");
    sb_representante.append("  group by rep_cdgo, rep_rzao, status ");
    sb_representante.append("  ORDER by rep_cdgo, rep_rzao, status ");


    if ((f.getCb_resumo_representante() + "").equals("S")) {
      Vector res_Jw_clientes_novos_antigos_total_representante = j.select(table_representante, sb_representante.toString(), null);
      session.setAttribute("res_Jw_clientes_novos_antigos_total_representante",res_Jw_clientes_novos_antigos_total_representante);
    }


    //  if (!(res_Jw_clientes_novos_antigos != null && res_Jw_clientes_novos_antigos.size() > 0)) {
    //     throw new Exception("Nenhum registro encontrado!");
    //  }

    session.setAttribute("mapping.getName()", form);
  }




  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesNovosAntigosActionForm f = (ClientesNovosAntigosActionForm) form;
      session.removeAttribute("res_Jw_clientes_novos_antigos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_novos_antigos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
