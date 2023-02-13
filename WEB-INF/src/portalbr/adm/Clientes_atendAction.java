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
 * Creation Date 04/09/2006 09:03:24
 * Last Modify Date 10/12/2020 16:44:00
 */

public class Clientes_atendAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_atendidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Clientes_atendActionForm f = (Clientes_atendActionForm) form;
    portalbr.dbobj.view.Jw_clientes_atendidos table = new portalbr.dbobj.view.Jw_clientes_atendidos();
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;

    try {
      String limite_qry = "";
      String segmento = "";
      String limite = "";
      String representante = "";
      String marca = "";
      String regional = "";
      if (!(f.getRep_cdgo() == null)) {
        representante = f.getRep_cdgo();
      } else {
        representante = "null";
      }

      if (!(f.getCodigo_marca() == null)) {
        marca = f.getCodigo_marca();
      } else {
        marca = "null";
      }
      if (!(f.getCodigo_regional() == null)) {
        regional = f.getCodigo_regional();
      } else {
        regional = "null";
      }


      if (!(f.getSegmento() == null)) {
        segmento = f.getSegmento();
      } else {
        segmento = "null";
      }

      if (!(f.getLimite() == null)) {
        limite = f.getLimite();
        if (limite.equals("p")) {
          limite_qry = " AND limite_credito <= 50000 ";
        }
        if (limite.equals("m")) {
          limite_qry = " AND limite_credito > 50000 and limite_credito <= 200000 ";
        }
        if (limite.equals("g")) {
          limite_qry = " AND limite_credito > 200000 ";
        }
      }

      StringBuilder query = new StringBuilder();
      query.append(" SELECT /*+ all_rows */ cli_cdgo ");
      query.append("      , cli_nome ");
      query.append("      , cli_rzao ");
      query.append("      , cli_dult ");
      query.append("      , NVL(SUM(pares), 0) - NVL(SUM(pares_recolocado), 0) pares ");
      query.append("      , NVL(SUM(valor), 0) - NVL(SUM(valor_recolocado), 0) valor ");
      query.append("      , NVL(SUM(pares_recolocado), 0) pares_recolocado ");
      query.append("      , NVL(SUM(valor_recolocado), 0) valor_recolocado ");
      if (((String) session.getAttribute("ca_consulta_saldo_limite_credito")).equalsIgnoreCase("S")) {
        query.append("   , fnc_ctr_saldo_limite(cli_cdgo, '01') saldo ");
      } else {
        query.append("   , 0 saldo ");
      }
      query.append("      , limite_credito ");
      query.append("   FROM ( SELECT cli.cli_cdgo ");
      query.append("               , cli.cli_nome ");
      query.append("               , cli.cli_rzao ");
      query.append("               , cli.cli_dult ");
      query.append("               , res.pares pares ");
      query.append("               , res.valor valor ");
      query.append("               , 0 pares_recolocado ");
      query.append("               , 0 valor_recolocado ");
      query.append("               , nvl(cli_valor_credito_analista,0) limite_credito ");
      query.append("            FROM resumo_ped res ");
      query.append("               , cli ");
      query.append("               , rep ");
      query.append("               , cliente_representante clr ");
      query.append("               , representante_marca rm ");
      query.append("               , seg ");
      query.append("               , parametros_cliente par ");
      query.append("           WHERE res.data_dig              >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
      query.append("             AND res.data_dig              <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
      query.append("             AND res.lin_cdgo              =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
      query.append("             AND res.codigo_marca          =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
      query.append("             AND res.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",res.codigo_regional) ");
      query.append("             AND par.cli_cdgo              =  cli.cli_cdgo ");
      query.append("             AND seg.seg_cdgo              =  cli.seg_cdgo ");
      query.append("             AND cli.cli_cdgo              =  res.cli_cdgo ");
      query.append("             AND rep.rep_cdgo              =  res.rep_cdgo ");
      query.append("             AND clr.codigo_representante  =  rep.rep_cdgo ");
      query.append("             AND cli.cli_cdgo              =  clr.codigo_cliente ");
      query.append("             AND res.esc_seqn              =  clr.codigo_sequencial ");
      query.append("             AND rm.marca_produto          =  res.codigo_marca ");
      query.append("             AND rm.codigo_representante   =  rep.rep_cdgo   ");
      query.append("             AND cli.cli_situ              =  nvl('A',cli.cli_situ) ");
      query.append("             AND cli.seg_cdgo              NOT IN (9,153) ");
      query.append("             AND res.codigo_marca          =  nvl(").append(marca).append(",res.codigo_marca) ");
      query.append("             AND res.codigo_regional       =  nvl(").append(regional).append(",res.codigo_regional) ");
      query.append("             AND seg.seg_cdgo              =  nvl(").append(segmento).append(",seg.seg_cdgo) ");
      query.append("             AND res.rep_cdgo              =  nvl(").append(representante).append(",res.rep_cdgo ) ");
      query.append("             AND rep.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
      query.append("             AND clr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
      query.append("             AND rm.situacao               =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
      query.append(limite_qry);
      query.append("           UNION ALL ");
      query.append("          SELECT cli.cli_cdgo ");
      query.append("               , cli.cli_nome ");
      query.append("               , cli.cli_rzao ");
      query.append("               , cli.cli_dult ");
      query.append("               , res.pares pares ");
      query.append("               , res.valor valor ");
      query.append("               , 0 pares_recolocado ");
      query.append("               , 0 valor_recolocado ");
      query.append("               , nvl(cli_valor_credito_analista,0) limite_credito ");
      query.append("            FROM resumo_pedidos res ");
      query.append("               , cli ");
      query.append("               , rep ");
      query.append("               , cliente_representante clr ");
      query.append("               , representante_marca rm ");
      query.append("               , seg ");
      query.append("               , parametros_cliente par ");
      query.append("           WHERE res.data_dig              >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
      query.append("             AND res.data_dig              <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
      query.append("             AND res.lin_cdgo              =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
      query.append("             AND res.codigo_marca          =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
      query.append("             AND res.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",res.codigo_regional) ");
      query.append("             AND par.cli_cdgo              =  cli.cli_cdgo ");
      query.append("             AND seg.seg_cdgo              =  cli.seg_cdgo ");
      query.append("             AND cli.cli_cdgo              =  res.cli_cdgo ");
      query.append("             AND rep.rep_cdgo              =  res.rep_cdgo ");
      query.append("             AND res.esc_seqn              =  clr.codigo_sequencial ");
      query.append("             AND rm.marca_produto          =  res.codigo_marca ");
      query.append("             AND clr.codigo_representante  =  rep.rep_cdgo ");
      query.append("             AND cli.cli_cdgo              =  clr.codigo_cliente ");
      query.append("             AND rm.codigo_representante   =  rep.rep_cdgo ");
      query.append("             AND cli.cli_situ              =  nvl('A',cli.cli_situ) ");
      query.append("             AND cli.seg_cdgo              NOT IN (9,153) ");
      query.append("             AND res.codigo_marca          =  nvl(").append(marca).append(",res.codigo_marca) ");
      query.append("             AND res.codigo_regional       =  nvl(").append(regional).append(",res.codigo_regional) ");
      query.append("             AND seg.seg_cdgo              =  nvl(").append(segmento).append(",seg.seg_cdgo) ");
      query.append("             AND res.rep_cdgo              =  nvl(").append(representante).append(",res.rep_cdgo ) ");
      query.append("             AND rep.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
      query.append("             AND clr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
      query.append("             AND rm.situacao               =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
      query.append(limite_qry);
      query.append("           UNION ALL ");
      query.append("          SELECT cli.cli_cdgo ");
      query.append("               , cli.cli_nome ");
      query.append("               , cli.cli_rzao ");
      query.append("               , cli.cli_dult ");
      query.append("               , 0 pares ");
      query.append("               , 0 valor ");
      query.append("               , res.pares pares_recolocado ");
      query.append("               , res.valor valor_recolocado ");
      query.append("               , nvl(cli_valor_credito_analista,0) limite_credito ");
      query.append("            FROM resumo_pedidos res ");
      query.append("               , cli ");
      query.append("               , rep ");
      query.append("               , cliente_representante clr ");
      query.append("               , representante_marca rm ");
      query.append("               , seg ");
      query.append("               , parametros_cliente par ");
      query.append("           WHERE res.data_dig              >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
      query.append("             AND res.data_dig              <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
      query.append("             AND res.lin_cdgo              =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
      query.append("             AND res.codigo_marca          =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
      query.append("             AND res.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",res.codigo_regional) ");
      query.append("             AND par.cli_cdgo              =  cli.cli_cdgo ");
      query.append("             AND seg.seg_cdgo              =  cli.seg_cdgo ");
      query.append("             AND cli.cli_cdgo              =  res.cli_cdgo ");
      query.append("             AND rep.rep_cdgo              =  res.rep_cdgo ");
      query.append("             AND res.esc_seqn              =  clr.codigo_sequencial ");
      query.append("             AND rm.marca_produto          =  res.codigo_marca ");
      query.append("             AND clr.codigo_representante  =  rep.rep_cdgo ");
      query.append("             AND cli.cli_cdgo              =  clr.codigo_cliente ");
      query.append("             AND rm.codigo_representante   =  rep.rep_cdgo ");
      query.append("             AND cli.cli_situ              =  nvl('A',cli.cli_situ) ");
      query.append("             AND cli.seg_cdgo              NOT IN (9,153) ");
      query.append("             AND res.codigo_marca          =  nvl(").append(marca).append(",res.codigo_marca) ");
      query.append("             AND res.codigo_regional       =  nvl(").append(regional).append(",res.codigo_regional) ");
      query.append("             AND seg.seg_cdgo              =  nvl(").append(segmento).append(",seg.seg_cdgo) ");
      query.append("             AND res.rep_cdgo              =  nvl(").append(representante).append(",res.rep_cdgo ) ");
      query.append("             AND rep.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
      query.append("             AND clr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
      query.append("             AND rm.situacao               =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
      query.append("      AND NOT EXISTS (SELECT 1 ");
      query.append("                        FROM ped ped ");
      query.append("                     WHERE ped.cli_cdgo = cli.cli_cdgo ");
      query.append("                             AND ped.rep_cdgo = rep.rep_cdgo ");
      query.append("                              AND ped.ped_especie_pedido <> 'C' ");
      query.append("                              AND ped.ped_dadg >= TO_DATE('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
      query.append("                              AND ped.ped_dadg <= TO_DATE('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
      query.append("                              AND NOT EXISTS (SELECT 1 ");
      query.append("                                                  FROM ped pdd ");
      query.append("                                            WHERE pdd.ped_nmro = ped.ped_recolocado ");
      query.append("                                                AND pdd.ped_dadg < TO_DATE('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy'))) ");
      query.append(limite_qry);
      query.append("        ) ");
      query.append("  GROUP BY cli_cdgo ");
      query.append("         , cli_nome ");
      query.append("         , cli_rzao ");
      query.append("         , cli_dult ");
      query.append("         , limite_credito ");
      query.append("  ORDER BY cli_cdgo ");

      if (false) {
        throw new Exception(query.toString());
      }
      Vector res_Jw_clientes_atendidos = j.select(table, query.toString(), null);

      //------------------------------------------------------------
      StringBuilder query2 = new StringBuilder();
      query2.append(" SELECT /*+ all_rows */ MAX(data_ultima_compra)data_ultima_compra ");
      query2.append("   FROM ( ");
      query2.append(" SELECT MAX(rp.data_dig) data_ultima_compra ");
      query2.append("   FROM resumo_ped rp ");
      query2.append("  WHERE rp.cli_cdgo         = ? ");
      query2.append("    AND rp.codigo_marca     =  nvl(").append(session.getAttribute("codigo_marca")).append(",rp.codigo_marca) ");
      query2.append("    AND rp.codigo_regional  =  nvl(").append(session.getAttribute("codigo_regional")).append(",rp.codigo_regional) ");
      query2.append("    AND rp.lin_cdgo         =  nvl(").append(session.getAttribute("lin_cdgo")).append(",rp.lin_cdgo) ");
      query2.append("    AND rp.codigo_marca     =  nvl(").append(marca).append(",rp.codigo_marca) ");
      query2.append("    AND rp.codigo_regional  =  nvl(").append(regional).append(",rp.codigo_regional) ");
      query2.append("    AND rp.rep_cdgo         =  nvl(").append(representante).append(",rp.rep_cdgo ) ");
      query2.append("  UNION ALL ");
      query2.append(" SELECT MAX(rp.data_dig) data_ultima_compra ");
      query2.append("   FROM resumo_pedidos rp ");
      query2.append("  WHERE rp.cli_cdgo         = ? ");
      query2.append("    AND rp.codigo_marca     =  nvl(").append(session.getAttribute("codigo_marca")).append(",rp.codigo_marca) ");
      query2.append("    AND rp.codigo_regional  =  nvl(").append(session.getAttribute("codigo_regional")).append(",rp.codigo_regional) ");
      query2.append("    AND rp.lin_cdgo         =  nvl(").append(session.getAttribute("lin_cdgo")).append(",rp.lin_cdgo) ");
      query2.append("    AND rp.codigo_marca     =  nvl(").append(marca).append(",rp.codigo_marca) ");
      query2.append("    AND rp.codigo_regional  =  nvl(").append(regional).append(",rp.codigo_regional) ");
      query2.append("    AND rp.rep_cdgo         =  nvl(").append(representante).append(",rp.rep_cdgo ) )");


      pstm = j.getConn().prepareStatement(query2.toString());
      util.consultas.Cidades cid = new util.consultas.Cidades();
      for (int i = 0; i < res_Jw_clientes_atendidos.size(); i++) {
        portalbr.dbobj.view.Jw_clientes_atendidos r = (portalbr.dbobj.view.Jw_clientes_atendidos) res_Jw_clientes_atendidos.elementAt(i);
        pstm.setString(1, r.getCli_cdgo());
        pstm.setString(2, r.getCli_cdgo());
        rset = pstm.executeQuery();
        while (rset.next()) {
          r.setCli_dult(rset.getTimestamp(1));
          r.setCidade(cid.retornaCidades(r.getCli_cdgo() + ""));
          r.setEmail(cid.retornaEmails());
          r.setFones(cid.retornaFones());
        }
      }
      //------------------------------------------------------------
      session.setAttribute("res_Jw_clientes_atendidos",res_Jw_clientes_atendidos);
      if (!(res_Jw_clientes_atendidos != null && res_Jw_clientes_atendidos.size() > 0)) {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_atendidos", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
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
    session.setAttribute("mapping.getName()", form);
  }
}
