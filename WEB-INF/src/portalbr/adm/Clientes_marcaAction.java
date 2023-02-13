package portalbr.adm;

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
 * Creation Date 21/12/2005 11:33:20
 * Last Modify Date 24/04/2020 18:55:05
 */

public class Clientes_marcaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_marca", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    Clientes_marcaActionForm f = (Clientes_marcaActionForm) form;
    portalbr.dbobj.view.Clientes_marca table = new portalbr.dbobj.view.Clientes_marca();
    portalbr.dbobj.view.Jw_grupos_ativos_qtd table_grupos_ativos = new portalbr.dbobj.view.Jw_grupos_ativos_qtd();
    portalbr.dbobj.view.Jw_clientes_ativos_qtd table_clientes_ativos = new portalbr.dbobj.view.Jw_clientes_ativos_qtd();
    portalbr.dbobj.view.Jw_clientes_atendidos_qtd table_clientes_atendidos = new portalbr.dbobj.view.Jw_clientes_atendidos_qtd();
    portalbr.dbobj.view.Jw_cidades_ativas_qtd table_cidades_ativas = new portalbr.dbobj.view.Jw_cidades_ativas_qtd();
    portalbr.dbobj.view.Jw_cidades_atendidas_qtd table_cidades_atendidas = new portalbr.dbobj.view.Jw_cidades_atendidas_qtd();
    portalbr.dbobj.view.Jw_clientes_atendidos_segmentos table_segmentos = new portalbr.dbobj.view.Jw_clientes_atendidos_segmentos();
    portalbr.dbobj.view.Jw_clientes_nao_atendidos_segmentos table_segmentos_nao_atendidos = new portalbr.dbobj.view.Jw_clientes_nao_atendidos_segmentos();
    portalbr.dbobj.view.Jw_clientes_segmentos_regional table_clientes_regional = new portalbr.dbobj.view.Jw_clientes_segmentos_regional();

    String lin_cdgo = null;
    String codigo_marca = null;
    String codigo_regional = null;
    if (!f.getLin_cdgo().equals("")) {
      lin_cdgo = f.getLin_cdgo();
    }
    if (!f.getCodigo_marca().equals("")) {
      codigo_marca = f.getCodigo_marca();
    }
    if (!f.getCodigo_regional().equals("")) {
      codigo_regional = f.getCodigo_regional();
    }

    StringBuilder query = new StringBuilder();
    query.append("  SELECT /*+ all_rows */ marca ");
    query.append("       , codigo_marca ");
    if (session.getAttribute("ca_abrir_meses") == "S") {
      query.append("  ,TRUNC(data_dig, 'MONTH') mes ");
    }
    query.append("       , 0 grupos_ativos ");
    query.append("       , 0 grupos_atendidos ");
    query.append("       , 0 grupos_nao_atendidos ");
    query.append("       , 0 clientes_ativos ");
    query.append("       , 0 clientes_atendidos ");
    query.append("       , 0 clientes_nao_atendidos ");
    query.append("       , 0 cidades_ativas ");
    query.append("       , 0 cidades_atendidas ");
    query.append("       , 0 cidades_nao_atendidas ");
    query.append("       , nvl(sum(pares), 0) pares ");
    query.append("       , nvl(sum(valor), 0) valor ");
    query.append("    FROM (   ");
    query.append("  SELECT lpad(res.codigo_marca, 3, 0) || '-' || mp.descricao_marca marca ");
    query.append("       , res.codigo_marca ");
    query.append("       , res.pares pares ");
    query.append("       , res.valor valor ");
    if (session.getAttribute("ca_abrir_meses") == "S") {
      query.append("  ,res.data_dig");
    }
    query.append("    FROM resumo_ped res ");
    query.append("       , cli ");
    query.append("       , regionais_vendas rv ");
    query.append("       , rep ");
    query.append("       , cliente_representante clr ");
    query.append("       , representante_marca rm ");
    query.append("       , marcas_produtos mp ");
    query.append("   WHERE cli.cli_cdgo             =  res.cli_cdgo  ");
    query.append("     AND mp.codigo_marca          =  res.codigo_marca   ");
    query.append("     AND rv.codigo_regional       =  res.codigo_regional  ");
    query.append("     AND cli.cli_cdgo             =  res.cli_cdgo  ");
    query.append("     AND clr.codigo_sequencial    =  res.esc_seqn  ");
    query.append("     AND clr.codigo_representante =  rep.rep_cdgo  ");
    query.append("     AND cli.cli_cdgo             =  clr.codigo_cliente  ");
    query.append("     AND rm.codigo_representante  =  rep.rep_cdgo  ");
    query.append("     AND rep.rep_cdgo             =  res.rep_cdgo  ");
    query.append("     AND rm.marca_produto         =  res.codigo_marca  ");
    query.append("     AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
    query.append("     AND cli.seg_cdgo             NOT IN (9,153) ");
    query.append("     AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("     AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append("     AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("     AND res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("     AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("     AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
    query.append("     AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
    query.append("     AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
    query.append("   UNION ALL ");
    query.append("  SELECT lpad(res.codigo_marca, 3, 0) || '-' || mp.descricao_marca marca ");
    query.append("       , res.codigo_marca ");
    query.append("       , res.pares pares ");
    query.append("       , res.valor valor ");
    if (session.getAttribute("ca_abrir_meses") == "S") {
      query.append("  ,res.data_dig ");
    }
    query.append("    FROM resumo_pedidos res ");
    query.append("       , cli ");
    query.append("       , regionais_vendas rv ");
    query.append("       , rep ");
    query.append("       , cliente_representante clr ");
    query.append("       , representante_marca rm ");
    query.append("       , marcas_produtos mp ");
    query.append("   WHERE cli.cli_cdgo             =  res.cli_cdgo  ");
    query.append("     AND mp.codigo_marca          =  res.codigo_marca ");
    query.append("     AND rv.codigo_regional       =  res.codigo_regional  ");
    query.append("     AND cli.cli_cdgo             =  res.cli_cdgo  ");
    query.append("     AND clr.codigo_sequencial    =  res.esc_seqn  ");
    query.append("     AND clr.codigo_representante =  rep.rep_cdgo  ");
    query.append("     AND cli.cli_cdgo             =  clr.codigo_cliente  ");
    query.append("     AND rm.codigo_representante  =  rep.rep_cdgo  ");
    query.append("     AND rep.rep_cdgo             =  res.rep_cdgo  ");
    query.append("     AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
    query.append("     AND cli.seg_cdgo             NOT IN (9,153) ");
    query.append("     AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("     AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append("     AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("     AND res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("     AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("     AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
    query.append("     AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
    query.append("     AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
    query.append("     AND rm.marca_produto         =  res.codigo_marca ) ");
    query.append("   GROUP BY marca ");
    query.append("          , codigo_marca ");
    if (session.getAttribute("ca_abrir_meses") == "S") {
      query.append("  ,TRUNC(data_dig, 'MONTH') ");
    }

    if (session.getAttribute("ca_abrir_meses") == "S") {
      query.append("  ORDER BY  3 ");
    } else {
      query.append(" ORDER BY 1 ");
    }


    Vector res_Clientes_marca = j.select(table, query.toString(), null);


    if (res_Clientes_marca != null && res_Clientes_marca.size() > 0) {


      for (int x = 0; x < res_Clientes_marca.size(); x++) {
        portalbr.dbobj.view.Clientes_marca r = (portalbr.dbobj.view.Clientes_marca) res_Clientes_marca.elementAt(x);

        //-----grupos ativos-------
        StringBuilder qgrupos = new StringBuilder();
        qgrupos.append(" SELECT /*+ all_rows */ count(distinct grec.gre_grupo) qtd_grupos ");
        qgrupos.append("   FROM cliente_representante        clre ");
        qgrupos.append("      , grupo_economico              grec ");
        qgrupos.append("      , representante_marca          rema ");
        qgrupos.append("      , rep                          repr ");
        qgrupos.append("      , regionais_vendas             reve ");
        qgrupos.append("      , marcas_produtos              mapr ");
        qgrupos.append("  WHERE clre.codigo_representante =  repr.rep_cdgo ");
        qgrupos.append("    AND grec.cli_cdgo             =  clre.codigo_cliente ");
        qgrupos.append("    AND rema.codigo_representante =  repr.rep_cdgo ");
        qgrupos.append("    AND reve.codigo_regional      =  repr.codigo_regional ");
        qgrupos.append("    AND mapr.codigo_marca         =  rema.marca_produto ");
        qgrupos.append("    AND mapr.codigo_marca         =  ").append(r.getCodigo_marca());
        qgrupos.append("    AND mapr.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",mapr.codigo_marca) ");
        qgrupos.append("    AND reve.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(",reve.codigo_regional) ");
        qgrupos.append("    AND clre.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clre.situacao) ");
        qgrupos.append("    AND rema.situacao             =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rema.situacao) ");
        qgrupos.append("    AND repr.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",repr.rep_situ) ");

        if (session.getAttribute("ca_consulta_grupos") == "S") {
          Vector res_Grupos_ativos = j.select(table_grupos_ativos, qgrupos.toString(), null);

          portalbr.dbobj.view.Jw_grupos_ativos_qtd r1 = (portalbr.dbobj.view.Jw_grupos_ativos_qtd) res_Grupos_ativos.elementAt(0);
          r.setGrupos_ativos(r1.getQtd_grupos());
        }


        StringBuilder grupos_atendidos = new StringBuilder();
        grupos_atendidos.append(" SELECT /*+ all_rows */ count(distinct gre_grupo) atendidos_qtd ");
        grupos_atendidos.append("   FROM ( ");
        grupos_atendidos.append(" SELECT gre.gre_grupo ");
        grupos_atendidos.append("   FROM resumo_ped res ");
        grupos_atendidos.append("      , cli ");
        grupos_atendidos.append("      , rep ");
        grupos_atendidos.append("      , cliente_representante clr ");
        grupos_atendidos.append("      , representante_marca rm ");
        grupos_atendidos.append("      , grupo_economico gre ");
        if (session.getAttribute("ca_abrir_meses") == "S") {
          grupos_atendidos.append("  WHERE res.data_dig >= to_date('"+r.getMes() + "', 'yyyy-mm-dd') ");
          grupos_atendidos.append("  AND res.data_dig < last_day(to_date('"+r.getMes() + "', 'yyyy-mm-dd')) + 1 ");
        } else {
          grupos_atendidos.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          grupos_atendidos.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
        }
        grupos_atendidos.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
        grupos_atendidos.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
        grupos_atendidos.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
        grupos_atendidos.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        grupos_atendidos.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        grupos_atendidos.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
        grupos_atendidos.append("    AND res.codigo_marca         =  nvl(").append(r.getCodigo_marca()).append(",res.codigo_marca) ");
        grupos_atendidos.append("    AND gre.cli_cdgo             =  cli.cli_cdgo ");
        grupos_atendidos.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
        grupos_atendidos.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
        grupos_atendidos.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
        grupos_atendidos.append("    AND rm.marca_produto         =  res.codigo_marca ");
        grupos_atendidos.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
        grupos_atendidos.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
        grupos_atendidos.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        grupos_atendidos.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        grupos_atendidos.append("    AND cli.seg_cdgo              NOT IN (9,153) ");
        grupos_atendidos.append("  UNION ALL ");
        grupos_atendidos.append(" SELECT gre.gre_grupo ");
        grupos_atendidos.append("   FROM resumo_pedidos res ");
        grupos_atendidos.append("      , cli ");
        grupos_atendidos.append("      , rep ");
        grupos_atendidos.append("      , cliente_representante clr ");
        grupos_atendidos.append("      , representante_marca rm ");
        grupos_atendidos.append("      , grupo_economico gre ");
        if (session.getAttribute("ca_abrir_meses") == "S") {
          grupos_atendidos.append("  WHERE res.data_dig >= to_date('"+r.getMes() + "', 'yyyy-mm-dd') ");
          grupos_atendidos.append("  AND res.data_dig < last_day(to_date('"+r.getMes() + "', 'yyyy-mm-dd')) + 1 ");
        } else {
          grupos_atendidos.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          grupos_atendidos.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
        }
        grupos_atendidos.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
        grupos_atendidos.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
        grupos_atendidos.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
        grupos_atendidos.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        grupos_atendidos.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        grupos_atendidos.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
        grupos_atendidos.append("    AND res.codigo_marca         =  nvl(").append(r.getCodigo_marca()).append(",res.codigo_marca) ");
        grupos_atendidos.append("    AND gre.cli_cdgo             =  cli.cli_cdgo");
        grupos_atendidos.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
        grupos_atendidos.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
        grupos_atendidos.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
        grupos_atendidos.append("    AND rm.marca_produto         =  res.codigo_marca ");
        grupos_atendidos.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
        grupos_atendidos.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
        grupos_atendidos.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        grupos_atendidos.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        grupos_atendidos.append("    AND cli.seg_cdgo              NOT IN (9,153) ");
        grupos_atendidos.append(" ) ");

        java.sql.PreparedStatement pstm = null;
        java.sql.ResultSet rset = null;
        try {
          if (session.getAttribute("ca_consulta_grupos") == "S") {
            pstm = j.getConn().prepareStatement(grupos_atendidos.toString());
            rset = pstm.executeQuery();
            while (rset.next()) {
              r.setGrupos_atendidos(rset.getInt(1));
              r.setGrupos_nao_atendidos(r.getGrupos_ativos() - r.getGrupos_atendidos());
            }
          }
        }
        finally {
          if (rset != null) {
            rset.close();
          }
          if (pstm != null) {
            pstm.close();
          }

        }

        //-----clientes ativos-------
        StringBuilder qclientes = new StringBuilder();
        qclientes.append(" SELECT /*+ all_rows */ count(distinct cli.cli_cdgo) ativos_qtd ");
        qclientes.append("   FROM rep ");
        qclientes.append("      , cliente_representante clr ");
        qclientes.append("      , cli ");
        qclientes.append("      , representante_marca rm ");
        qclientes.append("  WHERE clr.codigo_representante =  rep.rep_cdgo ");
        qclientes.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
        qclientes.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        qclientes.append("    AND rm.marca_produto         =  nvl(").append(r.getCodigo_marca()).append(", rm.marca_produto) ");
        qclientes.append("    AND rm.marca_produto         =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
        qclientes.append("    AND rep.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional) ");
        qclientes.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        qclientes.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
        qclientes.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        qclientes.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        qclientes.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");


        if (session.getAttribute("ca_consulta_clientes") == "S") {
          Vector res_Clientes_ativos = j.select(table_clientes_ativos, qclientes.toString(), null);

          portalbr.dbobj.view.Jw_clientes_ativos_qtd r2 = (portalbr.dbobj.view.Jw_clientes_ativos_qtd) res_Clientes_ativos.elementAt(0);
          r.setClientes_ativos(r2.getAtivos_qtd());
        }



        //----- Clientes atendidos recolocação -------
        /*
          StringBuilder qatendidosr = new StringBuilder();
          qatendidosr .append(" SELECT count(distinct cli_cdgo) atendidos_qtd ");
          qatendidosr .append("   FROM ( SELECT cli.cli_cdgo ");
          qatendidosr.append("   FROM resumo_pedidos res ");
          qatendidosr.append("      , cli ");
          qatendidosr.append("      , rep ");
          qatendidosr.append("      , cliente_representante clr ");
          qatendidosr.append("      , representante_marca rm ");
          qatendidosr.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          qatendidosr.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
          qatendidosr.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
          qatendidosr.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
          qatendidosr.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
          qatendidosr.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
          qatendidosr.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
          qatendidosr.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
          qatendidosr.append("    AND rm.marca_produto         =  res.codigo_marca ");
          qatendidosr.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
          qatendidosr.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
          qatendidosr.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
          qatendidosr.append("    AND res.codigo_marca         =  nvl(").append(r.getCodigo_marca()).append(",res.codigo_marca) ");
          qatendidosr.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
          qatendidosr.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
          qatendidosr.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
          qatendidosr.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
          qatendidosr.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
          qatendidosr.append("    AND NOT EXISTS (SELECT 1 ");
          qatendidosr.append("                      FROM ped ped ");
          qatendidosr.append("                     WHERE ped.cli_cdgo = cli.cli_cdgo ");
          qatendidosr.append("                       AND ped.rep_cdgo = rep.rep_cdgo ");
          qatendidosr.append("                       AND ped.ped_especie_pedido <> 'C' ");
          qatendidosr.append("                       AND ped.ped_dadg >= TO_DATE('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
          qatendidosr.append("                       AND ped.ped_dadg <= TO_DATE('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
          qatendidosr.append("                       AND NOT EXISTS (SELECT 1 ");
          qatendidosr.append("                                     FROM ped pdd ");
          qatendidosr.append("                                    WHERE pdd.ped_nmro = ped.ped_recolocado ");
          qatendidosr.append("                                      AND pdd.ped_dadg < TO_DATE('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy'))) ");
          qatendidosr.append("    ) ");

          if(session.getAttribute("ca_consulta_clientes")=="S"){
             Vector res_Clientes_atendidos_recolocacao = j.select(table_clientes_atendidos,
                                                                  qatendidosr.toString(),
                                                                  null);

             portalbr.dbobj.view.Jw_clientes_atendidos_qtd r3 = (portalbr.dbobj.view.Jw_clientes_atendidos_qtd) res_Clientes_atendidos_recolocacao.elementAt(0);
             r.setClientes_atendidos_recolocacao(r3.getAtendidos_qtd());
          }
        */



        //-----clientes atendidos-------
        StringBuilder qatendidos = new StringBuilder();
        qatendidos.append(" SELECT /*+ all_rows */ count(distinct cli_cdgo) atendidos_qtd ");
        qatendidos.append("   FROM (  ");
        qatendidos.append(" SELECT cli.cli_cdgo ");
        qatendidos.append("   FROM resumo_ped res ");
        qatendidos.append("      , cli ");
        qatendidos.append("      , rep ");
        qatendidos.append("      , cliente_representante clr ");
        qatendidos.append("      , representante_marca rm ");
        if (session.getAttribute("ca_abrir_meses") == "S") {
          qatendidos.append("  WHERE res.data_dig >= to_date('"+r.getMes() + "', 'yyyy-mm-dd') ");
          qatendidos.append("  AND res.data_dig < last_day(to_date('"+r.getMes() + "', 'yyyy-mm-dd')) + 1 ");
        } else {
          qatendidos.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          qatendidos.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
        }
        qatendidos.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
        qatendidos.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
        qatendidos.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
        qatendidos.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        qatendidos.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        qatendidos.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
        qatendidos.append("    AND res.codigo_marca         =  nvl(").append(r.getCodigo_marca()).append(",res.codigo_marca) ");
        qatendidos.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
        qatendidos.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
        qatendidos.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
        qatendidos.append("    AND rm.marca_produto         =  res.codigo_marca ");
        qatendidos.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
        qatendidos.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
        qatendidos.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        qatendidos.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        qatendidos.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
        qatendidos.append("  UNION ALL ");
        qatendidos.append(" SELECT cli.cli_cdgo ");
        qatendidos.append("   FROM resumo_pedidos res ");
        qatendidos.append("      , cli ");
        qatendidos.append("      , rep ");
        qatendidos.append("      , cliente_representante clr ");
        qatendidos.append("      , representante_marca rm ");
        if (session.getAttribute("ca_abrir_meses") == "S") {
          qatendidos.append("  WHERE res.data_dig >= to_date('"+r.getMes() + "', 'yyyy-mm-dd') ");
          qatendidos.append("  AND res.data_dig < last_day(to_date('"+r.getMes() + "', 'yyyy-mm-dd')) + 1 ");
        } else {
          qatendidos.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          qatendidos.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
        }
        qatendidos.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
        qatendidos.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
        qatendidos.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
        qatendidos.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
        qatendidos.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
        qatendidos.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
        qatendidos.append("    AND rm.marca_produto         =  res.codigo_marca ");
        qatendidos.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
        qatendidos.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
        qatendidos.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        qatendidos.append("    AND res.codigo_marca         =  nvl(").append(r.getCodigo_marca()).append(",res.codigo_marca) ");
        qatendidos.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        qatendidos.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
        qatendidos.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        qatendidos.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
        qatendidos.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        /*
            qatendidos.append("    AND NOT EXISTS (SELECT 1 ");
            qatendidos.append("                      FROM ped ped ");
            qatendidos.append("                     WHERE ped.cli_cdgo = cli.cli_cdgo ");
            qatendidos.append("                       AND ped.rep_cdgo = rep.rep_cdgo ");
            qatendidos.append("                       AND ped.ped_especie_pedido = 'C' ");
            qatendidos.append("                       AND ped.ped_dadg >= TO_DATE('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
            qatendidos.append("                       AND ped.ped_dadg <= TO_DATE('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
            qatendidos.append("                       AND EXISTS (SELECT 1 ");
            qatendidos.append("                                     FROM ped pdd ");
            qatendidos.append("                                    WHERE pdd.ped_nmro = ped.ped_recolocado ");
            qatendidos.append("                                      AND pdd.ped_dadg < TO_DATE('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy'))) ");
            */

        qatendidos.append("    ) ");

        if (session.getAttribute("ca_consulta_clientes") == "S") {
          Vector res_Clientes_atendidos = j.select(table_clientes_atendidos, qatendidos.toString(), null);

          portalbr.dbobj.view.Jw_clientes_atendidos_qtd r3 = (portalbr.dbobj.view.Jw_clientes_atendidos_qtd) res_Clientes_atendidos.elementAt(0);
          r.setClientes_atendidos(r3.getAtendidos_qtd());
          r.setClientes_nao_atendidos(r.getClientes_ativos() - (r.getClientes_atendidos()));
        }

        //-----cidades ativas-------
        StringBuilder qativas = new StringBuilder();
        qativas.append(" SELECT /*+ all_rows */ count(distinct ecl.ecl_cdad||' - '||ecl.est_unifed) cidades_ativas_qtd ");
        qativas.append("   FROM ecl ");
        qativas.append("      , cliente_representante cr ");
        qativas.append("      , rep r ");
        qativas.append("      , representante_marca rm ");
        qativas.append("      , cli c ");
        qativas.append("  WHERE ecl.ned_cdgo            in ('COB', 'UNI') ");
        qativas.append("    AND ecl.cli_cdgo            =  cr.codigo_cliente ");
        qativas.append("    AND cr.codigo_representante =  r.rep_cdgo ");
        qativas.append("    AND r.rep_cdgo              =  rm.codigo_representante ");
        qativas.append("    AND c.cli_cdgo              =  cr.codigo_cliente ");
        qativas.append("    AND cr.codigo_sequencial    =  ecl.esc_seqn ");
        qativas.append("    AND rm.marca_produto        =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
        qativas.append("    AND r.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",r.codigo_regional) ");
        qativas.append("    AND rm.marca_produto        =  nvl(").append(r.getCodigo_marca()).append(",rm.marca_produto) ");
        qativas.append("    AND c.cli_situ              =  nvl('A',c.cli_situ) ");
        qativas.append("    AND c.seg_cdgo              NOT IN (9,153) ");
        qativas.append("    AND rm.situacao             =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        qativas.append("    AND r.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",r.rep_situ) ");
        qativas.append("    AND cr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", cr.situacao) ");

        if (session.getAttribute("ca_consulta_cidades") == "S") {
          Vector res_Cidades_ativas = j.select(table_cidades_ativas, qativas.toString(), null);

          portalbr.dbobj.view.Jw_cidades_ativas_qtd r4 = (portalbr.dbobj.view.Jw_cidades_ativas_qtd) res_Cidades_ativas.elementAt(0);
          r.setCidades_ativas(r4.getCidades_ativas_qtd());
        }

        //-----cidades atendidas-------
        StringBuilder qatendidas = new StringBuilder();
        qatendidas.append(" SELECT /*+ all_rows */ count(distinct cidade) cidades_atendidas_qtd ");
        qatendidas.append("   FROM ( ");
        qatendidas.append(" SELECT DISTINCT ");
        qatendidas.append("        (ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade ");
        qatendidas.append("   FROM resumo_ped res ");
        qatendidas.append("      , ecl ");
        qatendidas.append("      , cli ");
        qatendidas.append("      , rep ");
        qatendidas.append("      , cliente_representante clr ");
        qatendidas.append("      , representante_marca   rm ");
        if (session.getAttribute("ca_abrir_meses") == "S") {
          qatendidas.append("  WHERE res.data_dig >= to_date('"+r.getMes() + "', 'yyyy-mm-dd') ");
          qatendidas.append("  AND res.data_dig < last_day(to_date('"+r.getMes() + "', 'yyyy-mm-dd')) + 1 ");
        } else {
          qatendidas.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          qatendidas.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
        }
        qatendidas.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
        qatendidas.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
        qatendidas.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
        qatendidas.append("    AND ecl.cli_cdgo             =  res.cli_cdgo ");
        qatendidas.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
        qatendidas.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
        qatendidas.append("    AND clr.codigo_cliente       =  cli.cli_cdgo ");
        qatendidas.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        qatendidas.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
        qatendidas.append("    AND clr.codigo_sequencial    =  res.esc_seqn ");
        qatendidas.append("    AND rm.marca_produto         =  res.codigo_marca ");
        qatendidas.append("    AND rm.marca_produto         =  nvl(").append(r.getCodigo_marca()).append(",rm.marca_produto) ");
        qatendidas.append("    AND ecl.ned_cdgo             in ('COB', 'UNI') ");
        qatendidas.append("    AND ecl.esc_seqn             =  res.esc_seqn ");
        qatendidas.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        qatendidas.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
        qatendidas.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        qatendidas.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
        qatendidas.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        qatendidas.append("  UNION ALL ");
        qatendidas.append(" SELECT DISTINCT ");
        qatendidas.append("        (ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade ");
        qatendidas.append("   FROM resumo_pedidos res ");
        qatendidas.append("      , ecl ");
        qatendidas.append("      , cli ");
        qatendidas.append("      , rep ");
        qatendidas.append("      , cliente_representante clr ");
        qatendidas.append("      , representante_marca rm ");
        if (session.getAttribute("ca_abrir_meses") == "S") {
          qatendidas.append("  WHERE res.data_dig >= to_date('"+r.getMes() + "', 'yyyy-mm-dd') ");
          qatendidas.append("  AND res.data_dig < last_day(to_date('"+r.getMes() + "', 'yyyy-mm-dd')) + 1 ");
        } else {
          qatendidas.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
          qatendidas.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
        }
        qatendidas.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
        qatendidas.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
        qatendidas.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
        qatendidas.append("    AND ecl.cli_cdgo             =  res.cli_cdgo ");
        qatendidas.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
        qatendidas.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
        qatendidas.append("    AND clr.codigo_cliente       =  cli.cli_cdgo ");
        qatendidas.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
        qatendidas.append("    AND clr.codigo_sequencial    =  res.esc_seqn ");
        qatendidas.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
        qatendidas.append("    AND ecl.ned_cdgo             in ('COB', 'UNI') ");
        qatendidas.append("    AND ecl.esc_seqn             =  res.esc_seqn ");
        qatendidas.append("    AND rm.marca_produto         =  res.codigo_marca ");
        qatendidas.append("    AND rm.marca_produto         =  nvl(").append(r.getCodigo_marca()).append(",rm.marca_produto) ");
        qatendidas.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
        qatendidas.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
        qatendidas.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
        qatendidas.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
        qatendidas.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
        qatendidas.append(" ) ");

        if (session.getAttribute("ca_consulta_cidades") == "S") {
          Vector res_Cidades_atendidas = j.select(table_cidades_atendidas, qatendidas.toString(), null);

          portalbr.dbobj.view.Jw_cidades_atendidas_qtd r5 = (portalbr.dbobj.view.Jw_cidades_atendidas_qtd) res_Cidades_atendidas.elementAt(0);
          r.setCidades_atendidas(r5.getCidades_atendidas_qtd());
          r.setCidades_nao_atendidas(r.getCidades_ativas() - r.getCidades_atendidas());
        }

      }



    }


    if (session.getAttribute("ca_consulta_segmentos") == "S") {
      StringBuilder qsegmentos = new StringBuilder();
      qsegmentos.append(" select /*+ all_rows */ seg_cdgo, ");
      qsegmentos.append("        seg_desc, ");
      qsegmentos.append("        sum(pequeno) pequenos, ");
      qsegmentos.append("        sum(medio) medios, ");
      qsegmentos.append("        sum(grande) grandes, ");
      qsegmentos.append("        sum(todos) todos ");
      qsegmentos.append("   from ( ");
      qsegmentos.append("          select seg_cdgo, ");
      qsegmentos.append("                 seg_desc, ");
      qsegmentos.append("                 DECODE(limite, 'Pequeno', count(distinct cli_cdgo), 0) pequeno, ");
      qsegmentos.append("                 DECODE(limite, 'Médio', count(distinct cli_cdgo), 0) medio, ");
      qsegmentos.append("                 DECODE(limite, 'Grande', count(distinct cli_cdgo), 0) grande, ");
      qsegmentos.append("                 nvl(count(distinct cli_cdgo), 0) todos ");
      qsegmentos.append("           from (SELECT cli_cdgo, ");
      qsegmentos.append("                         seg_cdgo, ");
      qsegmentos.append("                         seg_desc, ");
      qsegmentos.append("                         case ");
      qsegmentos.append("                           when limite_credito <= 50000 then ");
      qsegmentos.append("                            'Pequeno' ");
      qsegmentos.append("                           when limite_credito > 50000 and ");
      qsegmentos.append("                                limite_credito <= 200000 then ");
      qsegmentos.append("                            'Médio' ");
      qsegmentos.append("                           when limite_credito > 200000 then ");
      qsegmentos.append("                            'Grande' ");
      qsegmentos.append("                         end limite ");
      qsegmentos.append("                    from (SELECT distinct cli.cli_cdgo, ");
      qsegmentos.append("                                          cli.cli_nome, ");
      qsegmentos.append("                                          cli.cli_rzao, ");
      qsegmentos.append("                                          seg.seg_cdgo, ");
      qsegmentos.append("                                          seg.seg_desc, ");
      qsegmentos.append("                                          p.limite_credito ");
      qsegmentos.append("                            FROM resumo_ped res, ");
      qsegmentos.append("                                 cli, ");
      qsegmentos.append("                                 rep, ");
      qsegmentos.append("                                 cliente_representante clr, ");
      qsegmentos.append("                                 representante_marca rm, ");
      qsegmentos.append("                                 seg, ");
      qsegmentos.append("                                 parametros_cliente p ");
      qsegmentos.append("                           WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
      qsegmentos.append("                             AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
      qsegmentos.append("                             AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo) ");
      qsegmentos.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentos.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentos.append("                             AND cli.cli_cdgo             = res.cli_cdgo ");
      qsegmentos.append("                             AND seg.seg_cdgo             = cli.seg_cdgo ");
      qsegmentos.append("                             and p.cli_cdgo               = cli.cli_cdgo ");
      qsegmentos.append("                             AND rep.rep_cdgo             = res.rep_cdgo ");
      qsegmentos.append("                             AND clr.codigo_representante = rep.rep_cdgo ");
      qsegmentos.append("                             AND cli.cli_cdgo             = clr.codigo_cliente ");
      qsegmentos.append("                             AND res.esc_seqn             = clr.codigo_sequencial ");
      qsegmentos.append("                             AND rm.marca_produto         = res.codigo_marca ");
      qsegmentos.append("                             AND rm.codigo_representante  = rep.rep_cdgo ");
      qsegmentos.append("                             AND cli.cli_situ             = nvl('A', cli.cli_situ) ");
      qsegmentos.append("                             AND cli.seg_cdgo             NOT IN (9, 153) ");
      qsegmentos.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentos.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentos.append("                             AND res.rep_cdgo             = nvl(null, res.rep_cdgo) ");
      qsegmentos.append("                             AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ) ");
      qsegmentos.append("                             AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
      qsegmentos.append("                             AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
      qsegmentos.append("                          UNION ");
      qsegmentos.append("                          SELECT distinct cli.cli_cdgo, ");
      qsegmentos.append("                                          cli.cli_nome, ");
      qsegmentos.append("                                          cli.cli_rzao, ");
      qsegmentos.append("                                          seg.seg_cdgo, ");
      qsegmentos.append("                                          seg.seg_desc, ");
      qsegmentos.append("                                          p.limite_credito ");
      qsegmentos.append("                            FROM resumo_pedidos res, ");
      qsegmentos.append("                                 cli, ");
      qsegmentos.append("                                 rep, ");
      qsegmentos.append("                                 cliente_representante clr, ");
      qsegmentos.append("                                 representante_marca rm, ");
      qsegmentos.append("                                 seg, ");
      qsegmentos.append("                                 parametros_cliente p ");
      qsegmentos.append("                           WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
      qsegmentos.append("                             AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
      qsegmentos.append("                             AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo) ");
      qsegmentos.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentos.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentos.append("                             AND cli.cli_cdgo             = res.cli_cdgo ");
      qsegmentos.append("                             AND seg.seg_cdgo             = cli.seg_cdgo ");
      qsegmentos.append("                             and p.cli_cdgo               = cli.cli_cdgo ");
      qsegmentos.append("                             AND rep.rep_cdgo             = res.rep_cdgo ");
      qsegmentos.append("                             AND res.esc_seqn             = clr.codigo_sequencial ");
      qsegmentos.append("                             AND rm.marca_produto         = res.codigo_marca ");
      qsegmentos.append("                             AND clr.codigo_representante = rep.rep_cdgo ");
      qsegmentos.append("                             AND cli.cli_cdgo             = clr.codigo_cliente ");
      qsegmentos.append("                             AND rm.codigo_representante  = rep.rep_cdgo ");
      qsegmentos.append("                             AND cli.cli_situ             = nvl('A', cli.cli_situ) ");
      qsegmentos.append("                             AND cli.seg_cdgo             NOT IN (9, 153) ");
      qsegmentos.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentos.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentos.append("                             AND res.rep_cdgo             = nvl(null, res.rep_cdgo) ");
      qsegmentos.append("                             AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ) ");
      qsegmentos.append("                             AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
      qsegmentos.append("                             AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
      qsegmentos.append("                          ) ");
      qsegmentos.append("                  ) ");
      qsegmentos.append("          group by seg_cdgo, seg_desc, limite ");
      qsegmentos.append("         ) ");
      qsegmentos.append("  group by seg_cdgo, seg_desc ");



      //     if(true){throw new Exception(qsegmentos.toString());}
      Vector res_Jw_clientes_atendidos_segmentos = j.select(table_segmentos, qsegmentos.toString(), null);
      session.setAttribute("res_Jw_clientes_atendidos_segmentos",res_Jw_clientes_atendidos_segmentos);
    }




    if (session.getAttribute("ca_consulta_segmentos") == "S") {
      StringBuilder qsegmentosn = new StringBuilder();
      qsegmentosn.append(" select /*+ all_rows */ seg_cdgo, ");
      qsegmentosn.append("        seg_desc, ");
      qsegmentosn.append("        sum(pequeno) pequenos, ");
      qsegmentosn.append("        sum(medio) medios, ");
      qsegmentosn.append("        sum(grande) grandes, ");
      qsegmentosn.append("        sum(todos) todos ");
      qsegmentosn.append("   from ( ");
      qsegmentosn.append("          select seg_cdgo, ");
      qsegmentosn.append("                 seg_desc, ");
      qsegmentosn.append("                 DECODE(limite, 'Pequeno', count(distinct cli_cdgo), 0) pequeno, ");
      qsegmentosn.append("                 DECODE(limite, 'Médio', count(distinct cli_cdgo), 0) medio, ");
      qsegmentosn.append("                 DECODE(limite, 'Grande', count(distinct cli_cdgo), 0) grande, ");
      qsegmentosn.append("                 nvl(count(distinct cli_cdgo), 0) todos ");
      qsegmentosn.append("           from (SELECT cli_cdgo, ");
      qsegmentosn.append("                         seg_cdgo, ");
      qsegmentosn.append("                         seg_desc, ");
      qsegmentosn.append("                         case ");
      qsegmentosn.append("                           when limite_credito <= 50000 then ");
      qsegmentosn.append("                            'Pequeno' ");
      qsegmentosn.append("                           when limite_credito > 50000 and ");
      qsegmentosn.append("                                limite_credito <= 200000 then ");
      qsegmentosn.append("                            'Médio' ");
      qsegmentosn.append("                           when limite_credito > 200000 then ");
      qsegmentosn.append("                            'Grande' ");
      qsegmentosn.append("                         end limite ");
      qsegmentosn.append("                    from ( ");
      qsegmentosn.append(" SELECT DISTINCT ");
      qsegmentosn.append("         cli.cli_cdgo ");
      qsegmentosn.append("       , cli.cli_nome ");
      qsegmentosn.append("       , cli.cli_rzao ");
      qsegmentosn.append("        , seg.seg_cdgo,");
      qsegmentosn.append("          seg.seg_desc,");
      qsegmentosn.append("          p.limite_credito ");
      qsegmentosn.append("    FROM rep ");
      qsegmentosn.append("       , cliente_representante clr ");
      qsegmentosn.append("       , cli ");
      qsegmentosn.append("       , representante_marca rm ");
      qsegmentosn.append("        , seg ");
      qsegmentosn.append("        , parametros_cliente p ");
      qsegmentosn.append("   WHERE clr.codigo_representante =  rep.rep_cdgo  ");
      qsegmentosn.append("      AND seg.seg_cdgo              = cli.seg_cdgo ");
      qsegmentosn.append("      and p.cli_cdgo                = cli.cli_cdgo ");
      qsegmentosn.append("     AND cli.cli_cdgo              =  clr.codigo_cliente  ");
      qsegmentosn.append("     AND rm.codigo_representante   =  rep.rep_cdgo  ");
      qsegmentosn.append("     AND cli.cli_situ              =  'A'  ");
      qsegmentosn.append("     AND cli.seg_cdgo              NOT IN (9,153)  ");
      qsegmentosn.append("     AND rep.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ)  ");
      qsegmentosn.append("     AND clr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao)  ");
      qsegmentosn.append("     AND rm.situacao               =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao)  ");
      qsegmentosn.append("     AND rep.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional)  ");
      qsegmentosn.append("     AND rm.marca_produto          =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto)  ");
      qsegmentosn.append("   MINUS (     ");



      qsegmentosn.append("                          SELECT distinct cli.cli_cdgo, ");
      qsegmentosn.append("                                          cli.cli_nome, ");
      qsegmentosn.append("                                          cli.cli_rzao, ");
      qsegmentosn.append("                                          seg.seg_cdgo, ");
      qsegmentosn.append("                                          seg.seg_desc, ");
      qsegmentosn.append("                                          p.limite_credito ");
      qsegmentosn.append("                            FROM resumo_ped res, ");
      qsegmentosn.append("                                 cli, ");
      qsegmentosn.append("                                 rep, ");
      qsegmentosn.append("                                 cliente_representante clr, ");
      qsegmentosn.append("                                 representante_marca rm, ");
      qsegmentosn.append("                                 seg, ");
      qsegmentosn.append("                                 parametros_cliente p ");
      qsegmentosn.append("                           WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
      qsegmentosn.append("                             AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
      qsegmentosn.append("                             AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo) ");
      qsegmentosn.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentosn.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentosn.append("                             AND cli.cli_cdgo             = res.cli_cdgo ");
      qsegmentosn.append("                             AND seg.seg_cdgo             = cli.seg_cdgo ");
      qsegmentosn.append("                             and p.cli_cdgo               = cli.cli_cdgo ");
      qsegmentosn.append("                             AND rep.rep_cdgo             = res.rep_cdgo ");
      qsegmentosn.append("                             AND clr.codigo_representante = rep.rep_cdgo ");
      qsegmentosn.append("                             AND cli.cli_cdgo             = clr.codigo_cliente ");
      qsegmentosn.append("                             AND res.esc_seqn             = clr.codigo_sequencial ");
      qsegmentosn.append("                             AND rm.marca_produto         = res.codigo_marca ");
      qsegmentosn.append("                             AND rm.codigo_representante  = rep.rep_cdgo ");
      qsegmentosn.append("                             AND cli.cli_situ             = nvl('A', cli.cli_situ) ");
      qsegmentosn.append("                             AND cli.seg_cdgo             NOT IN (9, 153) ");
      qsegmentosn.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentosn.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentosn.append("                             AND res.rep_cdgo             = nvl(null, res.rep_cdgo) ");
      qsegmentosn.append("                             AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ) ");
      qsegmentosn.append("                             AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
      qsegmentosn.append("                             AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
      qsegmentosn.append("                          UNION ");
      qsegmentosn.append("                          SELECT distinct cli.cli_cdgo, ");
      qsegmentosn.append("                                          cli.cli_nome, ");
      qsegmentosn.append("                                          cli.cli_rzao, ");
      qsegmentosn.append("                                          seg.seg_cdgo, ");
      qsegmentosn.append("                                          seg.seg_desc, ");
      qsegmentosn.append("                                          p.limite_credito ");
      qsegmentosn.append("                            FROM resumo_pedidos res, ");
      qsegmentosn.append("                                 cli, ");
      qsegmentosn.append("                                 rep, ");
      qsegmentosn.append("                                 cliente_representante clr, ");
      qsegmentosn.append("                                 representante_marca rm, ");
      qsegmentosn.append("                                 seg, ");
      qsegmentosn.append("                                 parametros_cliente p ");
      qsegmentosn.append("                           WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
      qsegmentosn.append("                             AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
      qsegmentosn.append("                             AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo) ");
      qsegmentosn.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentosn.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentosn.append("                             AND cli.cli_cdgo             = res.cli_cdgo ");
      qsegmentosn.append("                             AND seg.seg_cdgo             = cli.seg_cdgo ");
      qsegmentosn.append("                             and p.cli_cdgo               = cli.cli_cdgo ");
      qsegmentosn.append("                             AND rep.rep_cdgo             = res.rep_cdgo ");
      qsegmentosn.append("                             AND res.esc_seqn             = clr.codigo_sequencial ");
      qsegmentosn.append("                             AND rm.marca_produto         = res.codigo_marca ");
      qsegmentosn.append("                             AND clr.codigo_representante = rep.rep_cdgo ");
      qsegmentosn.append("                             AND cli.cli_cdgo             = clr.codigo_cliente ");
      qsegmentosn.append("                             AND rm.codigo_representante  = rep.rep_cdgo ");
      qsegmentosn.append("                             AND cli.cli_situ             = nvl('A', cli.cli_situ) ");
      qsegmentosn.append("                             AND cli.seg_cdgo             NOT IN (9, 153) ");
      qsegmentosn.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
      qsegmentosn.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
      qsegmentosn.append("                             AND res.rep_cdgo             = nvl(null, res.rep_cdgo) ");
      qsegmentosn.append("                             AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ) ");
      qsegmentosn.append("                             AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
      qsegmentosn.append("                             AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)) ");
      qsegmentosn.append("                          ) ");
      qsegmentosn.append("                  ) ");
      qsegmentosn.append("          group by seg_cdgo, seg_desc, limite ");
      qsegmentosn.append("         ) ");
      qsegmentosn.append("  group by seg_cdgo, seg_desc ");



      //     if(true){throw new Exception(qsegmentos.toString());}
      Vector res_Jw_clientes_nao_atendidos_segmentos = j.select(table_segmentos_nao_atendidos, qsegmentosn.toString(), null);
      session.setAttribute("res_Jw_clientes_nao_atendidos_segmentos",res_Jw_clientes_nao_atendidos_segmentos);
    }



    if (session.getAttribute("ca_consulta_regionais") == "S") {
      StringBuilder qlimiteregional = new StringBuilder();
      qlimiteregional.append(" select /*+ all_rows */ codigo_regional, ");
      qlimiteregional.append("        pck_regionais_vendas.get_nome(codigo_regional) nome, ");
      qlimiteregional.append("        'Atendidos' situacao, ");
      qlimiteregional.append("        sum(pequeno) pequenos,  ");
      qlimiteregional.append("        sum(medio) medios,  ");
      qlimiteregional.append("        sum(grande) grandes,  ");
      qlimiteregional.append("        sum(todos) todos  ");
      qlimiteregional.append("   from (  ");
      qlimiteregional.append("          select codigo_regional, ");
      qlimiteregional.append("                 DECODE(limite, 'Pequeno', count(distinct cli_cdgo), 0) pequeno,  ");
      qlimiteregional.append("                 DECODE(limite, 'Médio', count(distinct cli_cdgo), 0) medio,  ");
      qlimiteregional.append("                 DECODE(limite, 'Grande', count(distinct cli_cdgo), 0) grande,  ");
      qlimiteregional.append("                 nvl(count(distinct cli_cdgo), 0) todos  ");
      qlimiteregional.append("           from (SELECT  codigo_regional, ");
      qlimiteregional.append("                         cli_cdgo, ");
      qlimiteregional.append("                         case  ");
      qlimiteregional.append("                           when limite_credito <= 50000 then  ");
      qlimiteregional.append("                            'Pequeno'  ");
      qlimiteregional.append("                           when limite_credito > 50000 and  ");
      qlimiteregional.append("                                limite_credito <= 200000 then  ");
      qlimiteregional.append("                            'Médio'  ");
      qlimiteregional.append("                           when limite_credito > 200000 then  ");
      qlimiteregional.append("                            'Grande'  ");
      qlimiteregional.append("                         end limite  ");
      qlimiteregional.append("                    from (SELECT distinct rep.codigo_regional, ");
      qlimiteregional.append("                                          cli.cli_cdgo,  ");
      qlimiteregional.append("                                          cli.cli_nome,  ");
      qlimiteregional.append("                                          cli.cli_rzao,  ");
      qlimiteregional.append("                                          p.limite_credito  ");
      qlimiteregional.append("                            FROM resumo_ped res,  ");
      qlimiteregional.append("                                 cli,  ");
      qlimiteregional.append("                                 rep,  ");
      qlimiteregional.append("                                 cliente_representante clr,  ");
      qlimiteregional.append("                                 representante_marca rm,  ");
      qlimiteregional.append("                                 seg,  ");
      qlimiteregional.append("                                 parametros_cliente p  ");
      qlimiteregional.append("                           WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy')  ");
      qlimiteregional.append("                             AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1  ");
      qlimiteregional.append("                             AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo)  ");
      qlimiteregional.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                             AND cli.cli_cdgo             = res.cli_cdgo  ");
      qlimiteregional.append("                             AND seg.seg_cdgo             = cli.seg_cdgo  ");
      qlimiteregional.append("                             and p.cli_cdgo               = cli.cli_cdgo  ");
      qlimiteregional.append("                             AND rep.rep_cdgo             = res.rep_cdgo  ");
      qlimiteregional.append("                             AND clr.codigo_representante = rep.rep_cdgo  ");
      qlimiteregional.append("                             AND cli.cli_cdgo             = clr.codigo_cliente  ");
      qlimiteregional.append("                             AND res.esc_seqn             = clr.codigo_sequencial  ");
      qlimiteregional.append("                             AND rm.marca_produto         = res.codigo_marca  ");
      qlimiteregional.append("                             AND rm.codigo_representante  = rep.rep_cdgo  ");
      qlimiteregional.append("                             AND cli.cli_situ             = nvl('A', cli.cli_situ)  ");
      qlimiteregional.append("                             AND cli.seg_cdgo             NOT IN (9, 153)  ");
      qlimiteregional.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                             AND res.rep_cdgo             = nvl(null, res.rep_cdgo)  ");
      qlimiteregional.append("                             AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ)  ");
      qlimiteregional.append("                             AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao)  ");
      qlimiteregional.append("                             AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)  ");
      qlimiteregional.append("                          UNION  ");
      qlimiteregional.append("                          SELECT distinct rep.codigo_regional, ");
      qlimiteregional.append("                                          cli.cli_cdgo,  ");
      qlimiteregional.append("                                          cli.cli_nome,  ");
      qlimiteregional.append("                                          cli.cli_rzao,  ");
      qlimiteregional.append("                                          p.limite_credito  ");
      qlimiteregional.append("                            FROM resumo_pedidos res,  ");
      qlimiteregional.append("                                 cli,  ");
      qlimiteregional.append("                                 rep,  ");
      qlimiteregional.append("                                 cliente_representante clr,  ");
      qlimiteregional.append("                                 representante_marca rm,  ");
      qlimiteregional.append("                                 seg,  ");
      qlimiteregional.append("                                 parametros_cliente p  ");
      qlimiteregional.append("                           WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy')  ");
      qlimiteregional.append("                             AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1  ");
      qlimiteregional.append("                             AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo)  ");
      qlimiteregional.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                             AND cli.cli_cdgo             = res.cli_cdgo  ");
      qlimiteregional.append("                             AND seg.seg_cdgo             = cli.seg_cdgo  ");
      qlimiteregional.append("                             and p.cli_cdgo               = cli.cli_cdgo  ");
      qlimiteregional.append("                             AND rep.rep_cdgo             = res.rep_cdgo  ");
      qlimiteregional.append("                             AND res.esc_seqn             = clr.codigo_sequencial ");
      qlimiteregional.append("                             AND rm.marca_produto         = res.codigo_marca  ");
      qlimiteregional.append("                             AND clr.codigo_representante = rep.rep_cdgo  ");
      qlimiteregional.append("                             AND cli.cli_cdgo             = clr.codigo_cliente  ");
      qlimiteregional.append("                             AND rm.codigo_representante  = rep.rep_cdgo  ");
      qlimiteregional.append("                             AND cli.cli_situ             = nvl('A', cli.cli_situ)  ");
      qlimiteregional.append("                             AND cli.seg_cdgo             NOT IN (9, 153)  ");
      qlimiteregional.append("                             AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                             AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                             AND res.rep_cdgo             = nvl(null, res.rep_cdgo)  ");
      qlimiteregional.append("                             AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ)  ");
      qlimiteregional.append("                             AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao)  ");
      qlimiteregional.append("                             AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)  ");
      qlimiteregional.append("                          )  ");
      qlimiteregional.append("                  )  ");
      qlimiteregional.append("          group by codigo_regional, limite  ");
      qlimiteregional.append("         )  ");
      qlimiteregional.append("  group by codigo_regional ");
      qlimiteregional.append("  union ");
      qlimiteregional.append(" select  codigo_regional, ");
      qlimiteregional.append("         pck_regionais_vendas.get_nome(codigo_regional) nome, ");
      qlimiteregional.append("         'Não Atendidos' situacao, ");
      qlimiteregional.append("         sum(pequeno) pequenos,  ");
      qlimiteregional.append("         sum(medio) medios,  ");
      qlimiteregional.append("         sum(grande) grandes,  ");
      qlimiteregional.append("         sum(todos) todos  ");
      qlimiteregional.append("    from (  ");
      qlimiteregional.append("           select codigo_regional, ");
      qlimiteregional.append("                  DECODE(limite, 'Pequeno', count(distinct cli_cdgo), 0) pequeno,  ");
      qlimiteregional.append("                  DECODE(limite, 'Médio', count(distinct cli_cdgo), 0) medio,  ");
      qlimiteregional.append("                  DECODE(limite, 'Grande', count(distinct cli_cdgo), 0) grande,  ");
      qlimiteregional.append("                  nvl(count(distinct cli_cdgo), 0) todos  ");
      qlimiteregional.append("            from (SELECT cli_cdgo,  ");
      qlimiteregional.append("                          codigo_regional, ");
      qlimiteregional.append("                          case  ");
      qlimiteregional.append("                            when limite_credito <= 50000 then  ");
      qlimiteregional.append("                             'Pequeno'  ");
      qlimiteregional.append("                            when limite_credito > 50000 and  ");
      qlimiteregional.append("                                 limite_credito <= 200000 then  ");
      qlimiteregional.append("                             'Médio'  ");
      qlimiteregional.append("                            when limite_credito > 200000 then  ");
      qlimiteregional.append("                             'Grande'  ");
      qlimiteregional.append("                          end limite  ");
      qlimiteregional.append("                     from (  ");
      qlimiteregional.append("  SELECT DISTINCT  ");
      qlimiteregional.append("           cl.cli_cdgo  ");
      qlimiteregional.append("         , cl.cli_nome  ");
      qlimiteregional.append("         , cl.cli_rzao  ");
      qlimiteregional.append("         , rep.codigo_regional ");
      qlimiteregional.append("         ,  p.limite_credito  ");
      qlimiteregional.append("      FROM rep  ");
      qlimiteregional.append("         , cliente_representante clr  ");
      qlimiteregional.append("         , cli cl ");
      qlimiteregional.append("         , representante_marca rm  ");
      qlimiteregional.append("         , seg  ");
      qlimiteregional.append("         , parametros_cliente p  ");
      qlimiteregional.append("     WHERE clr.codigo_representante  =  rep.rep_cdgo   ");
      qlimiteregional.append("       AND seg.seg_cdgo              = cl.seg_cdgo  ");
      qlimiteregional.append("       and p.cli_cdgo                = cl.cli_cdgo  ");
      qlimiteregional.append("       AND cl.cli_cdgo               =  clr.codigo_cliente  ");
      qlimiteregional.append("       AND rm.codigo_representante   =  rep.rep_cdgo   ");
      qlimiteregional.append("       AND cl.cli_situ               =  'A'   ");
      qlimiteregional.append("       AND cl.seg_cdgo              NOT IN (9,153)   ");
      qlimiteregional.append("       AND rep.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ)   ");
      qlimiteregional.append("       AND clr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao)   ");
      qlimiteregional.append("       AND rm.situacao               =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao)   ");
      qlimiteregional.append("       AND rep.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional) ");
      qlimiteregional.append("       AND rm.marca_produto          =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto)   ");
      qlimiteregional.append("     minus (      ");
      qlimiteregional.append("                           SELECT distinct cli.cli_cdgo,  ");
      qlimiteregional.append("                                           cli.cli_nome,  ");
      qlimiteregional.append("                                           cli.cli_rzao,  ");
      qlimiteregional.append("                                           rep.codigo_regional, ");
      qlimiteregional.append("                                           p.limite_credito  ");
      qlimiteregional.append("                             FROM resumo_ped res,  ");
      qlimiteregional.append("                                  cli,  ");
      qlimiteregional.append("                                  rep,  ");
      qlimiteregional.append("                                  cliente_representante clr,  ");
      qlimiteregional.append("                                  representante_marca rm,  ");
      qlimiteregional.append("                                  seg,  ");
      qlimiteregional.append("                                  parametros_cliente p  ");
      qlimiteregional.append("                            WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy')  ");
      qlimiteregional.append("                              AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1  ");
      qlimiteregional.append("                              AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo)  ");
      qlimiteregional.append("                              AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                              AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                              AND cli.cli_cdgo             = res.cli_cdgo  ");
      qlimiteregional.append("                              AND seg.seg_cdgo             = cli.seg_cdgo  ");
      qlimiteregional.append("                              and p.cli_cdgo               = cli.cli_cdgo  ");
      qlimiteregional.append("                              AND rep.rep_cdgo             = res.rep_cdgo  ");
      qlimiteregional.append("                              AND clr.codigo_representante = rep.rep_cdgo  ");
      qlimiteregional.append("                              AND cli.cli_cdgo             = clr.codigo_cliente  ");
      qlimiteregional.append("                              AND res.esc_seqn             = clr.codigo_sequencial  ");
      qlimiteregional.append("                              AND rm.marca_produto         = res.codigo_marca  ");
      qlimiteregional.append("                              AND rm.codigo_representante  = rep.rep_cdgo  ");
      qlimiteregional.append("                              AND cli.cli_situ             = nvl('A', cli.cli_situ)  ");
      qlimiteregional.append("                              AND cli.seg_cdgo             NOT IN (9, 153) ");
      qlimiteregional.append("                              AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                              AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                              AND res.rep_cdgo             = nvl(null, res.rep_cdgo)  ");
      qlimiteregional.append("                              AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ)  ");
      qlimiteregional.append("                              AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao)  ");
      qlimiteregional.append("                              AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)  ");
      qlimiteregional.append("                           UNION  ");
      qlimiteregional.append("                           SELECT distinct cli.cli_cdgo,  ");
      qlimiteregional.append("                                           cli.cli_nome,  ");
      qlimiteregional.append("                                           cli.cli_rzao,  ");
      qlimiteregional.append("                                           rep.codigo_regional, ");
      qlimiteregional.append("                                           p.limite_credito  ");
      qlimiteregional.append("                             FROM resumo_pedidos res,  ");
      qlimiteregional.append("                                  cli,  ");
      qlimiteregional.append("                                  rep,  ");
      qlimiteregional.append("                                  cliente_representante clr,  ");
      qlimiteregional.append("                                  representante_marca rm,  ");
      qlimiteregional.append("                                  seg,  ");
      qlimiteregional.append("                                  parametros_cliente p  ");
      qlimiteregional.append("                            WHERE res.data_dig            >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy')  ");
      qlimiteregional.append("                              AND res.data_dig             < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1  ");
      qlimiteregional.append("                              AND res.lin_cdgo             = nvl(").append(session.getAttribute("lin_cdgo")).append(", res.lin_cdgo)  ");
      qlimiteregional.append("                              AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                              AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                              AND cli.cli_cdgo             = res.cli_cdgo  ");
      qlimiteregional.append("                              AND seg.seg_cdgo             = cli.seg_cdgo  ");
      qlimiteregional.append("                              and p.cli_cdgo               = cli.cli_cdgo  ");
      qlimiteregional.append("                              AND rep.rep_cdgo             = res.rep_cdgo  ");
      qlimiteregional.append("                              AND res.esc_seqn             = clr.codigo_sequencial  ");
      qlimiteregional.append("                              AND rm.marca_produto         = res.codigo_marca  ");
      qlimiteregional.append("                              AND clr.codigo_representante = rep.rep_cdgo  ");
      qlimiteregional.append("                              AND cli.cli_cdgo             = clr.codigo_cliente  ");
      qlimiteregional.append("                              AND rm.codigo_representante  = rep.rep_cdgo  ");
      qlimiteregional.append("                              AND cli.cli_situ             = nvl('A', cli.cli_situ)  ");
      qlimiteregional.append("                              AND cli.seg_cdgo             NOT IN (9, 153)  ");
      qlimiteregional.append("                              AND res.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca)  ");
      qlimiteregional.append("                              AND res.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional)  ");
      qlimiteregional.append("                              AND res.rep_cdgo             = nvl(null, res.rep_cdgo)  ");
      qlimiteregional.append("                              AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ)  ");
      qlimiteregional.append("                              AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao)  ");
      qlimiteregional.append("                              AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
      qlimiteregional.append(" )  ");
      qlimiteregional.append("                           )  ");
      qlimiteregional.append("                   )  ");
      qlimiteregional.append("           group by codigo_regional, limite  ");
      qlimiteregional.append("          )  ");
      qlimiteregional.append("   group by codigo_regional ");


      Vector res_Jw_clientes_segmentos_regional = j.select(table_clientes_regional, qlimiteregional.toString(), null);

      session.setAttribute("res_Jw_clientes_segmentos_regional",res_Jw_clientes_segmentos_regional);
    }



    session.setAttribute("res_Clientes_marca",res_Clientes_marca);
    if (res_Clientes_marca != null && res_Clientes_marca.size() > 0) {
      portalbr.dbobj.view.Clientes_marca r = (portalbr.dbobj.view.Clientes_marca) res_Clientes_marca.elementAt(0);
      f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_marca", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Clientes_marcaActionForm f = (Clientes_marcaActionForm) form;
      session.removeAttribute("res_Clientes_marca");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_marca", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
