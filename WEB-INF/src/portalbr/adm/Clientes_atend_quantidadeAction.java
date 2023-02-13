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
 * Last Modify Date 10/12/2020 19:00:53
 */

public class Clientes_atend_quantidadeAction extends com.egen.util.struts.AbstractAction {

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
    Clientes_atend_quantidadeActionForm f = (Clientes_atend_quantidadeActionForm) form;
    portalbr.dbobj.view.Jw_clientes_atendidos table = new portalbr.dbobj.view.Jw_clientes_atendidos();
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;

    try {

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


      StringBuilder query = new StringBuilder();
      query.append(" SELECT cli_cdgo ");
      query.append("      , cli_nome ");
      query.append("      , cli_rzao ");
      query.append("      , NULL         cli_dult ");
      query.append("      , pares        pares ");
      query.append("      , valor        valor ");
      query.append("      , 0            pares_recolocado ");
      query.append("      , 0            valor_recolocado ");
      query.append("      , 0            saldo ");
      query.append("      , 0            limite_credito ");
      query.append("      , atendimentos ");
      query.append("   FROM (SELECT cli_cdgo ");
      query.append("              , cli_nome ");
      query.append("              , cli_rzao ");
      query.append("              , COUNT(DISTINCT ped_nmro) atendimentos ");
      query.append("              , sum(fct_valor_pedido(ped_nmro)) valor ");
      query.append("              , sum(pck_pedidos.get_pares(ped_nmro)) pares ");
      query.append("           FROM (SELECT p.cli_cdgo ");
      query.append("                      , c.cli_nome ");
      query.append("                      , c.cli_rzao ");
      query.append("                      , p.ped_nmro ");
      query.append("                   FROM ped                   p ");
      query.append("                      , rep                   r ");
      query.append("                      , ite                   i ");
      query.append("                      , cli                   c ");
      query.append("                      , cliente_representante clr ");
      query.append("                      , representante_marca   rm ");
      query.append("                  WHERE p.ped_dadg >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy')  ");
      query.append("                    AND p.ped_dadg < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1  ");
      query.append("                    AND c.cli_situ = NVL('A', c.cli_situ) ");
      query.append("                    AND c.seg_cdgo NOT IN (9, 153) ");
      query.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      query.append("                    AND r.rep_situ = NVL(").append(session.getAttribute("situacao_representante")).append(", r.rep_situ)  ");
      query.append("                    AND clr.situacao = NVL(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao)  ");
      query.append("                    AND rm.situacao = NVL(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)  ");
      query.append("                    AND i.lin_cdgo =  nvl(").append(session.getAttribute("lin_cdgo")).append(",i.lin_cdgo)    ");
      query.append("                    AND r.codigo_regional =  nvl(").append(session.getAttribute("codigo_regional")).append(", r.codigo_regional)  ");
      query.append("                    AND rm.marca_produto =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto)  ");
      query.append("                    AND rm.marca_produto = nvl("+marca + ", rm.marca_produto) ");
      query.append("                    AND r.codigo_regional= nvl("+regional + ", r.codigo_regional) ");
      if (!representante.equals("null")) {
        query.append("                 AND r.rep_cdgo = '").append(representante).append("'");
      }
      query.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      query.append("                    AND clr.codigo_representante = r.rep_cdgo ");
      query.append("                    AND p.esc_seqn = clr.codigo_sequencial ");
      query.append("                    AND p.cli_cdgo = clr.codigo_cliente ");
      query.append("                    AND rm.marca_produto = fct_marca_produto(i.lin_cdgo, i.ref_cdgo) ");
      query.append("                    AND rm.codigo_representante = r.rep_cdgo ");
      query.append("                    AND NVL(p.ped_stat, 'X') <> 'C' ");
      query.append("                    AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP') ");
      query.append("                    AND NVL(p.ped_especie_pedido, 'x') IN ('F', 'N', 'M', 'P', 'X') ");
      query.append("                    AND NVL(p.ped_substituicao, 'N') <> 'S' ");
      query.append("                    AND i.ped_nmro = p.ped_nmro ");
      query.append("                    AND NVL(p.cli_cdgo, NULL) <> 40000 ");
      query.append("                  UNION ");
      query.append("                 SELECT p.cli_cdgo ");
      query.append("                      , c.cli_nome ");
      query.append("                      , c.cli_rzao ");
      query.append("                      , p.ped_nmro ");
      query.append("                   FROM ped                   p ");
      query.append("                      , rep                   r ");
      query.append("                      , cli                   c ");
      query.append("                      , ite                   i ");
      query.append("                      , cliente_representante clr ");
      query.append("                      , representante_marca   rm ");
      query.append("                  WHERE p.ped_dadg >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy')  ");
      query.append("                    AND p.ped_dadg < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1  ");
      query.append("                    AND c.cli_situ = NVL('A', c.cli_situ) ");
      query.append("                    AND c.seg_cdgo NOT IN (9, 153) ");
      query.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      query.append("                    AND r.rep_situ = NVL(").append(session.getAttribute("situacao_representante")).append(", r.rep_situ)  ");
      query.append("                    AND clr.situacao = NVL(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao)  ");
      query.append("                    AND rm.situacao = NVL(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)  ");
      query.append("                    AND i.lin_cdgo =  nvl(").append(session.getAttribute("lin_cdgo")).append(",i.lin_cdgo)    ");
      query.append("                    AND r.codigo_regional =  nvl(").append(session.getAttribute("codigo_regional")).append(", r.codigo_regional)  ");
      query.append("                    AND rm.marca_produto =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto)  ");
      query.append("                    AND rm.marca_produto = nvl("+marca + ", rm.marca_produto) ");
      query.append("                    AND r.codigo_regional= nvl("+regional + ", r.codigo_regional) ");
      if (!representante.equals("null")) {
        query.append("                 AND r.rep_cdgo = '").append(representante).append("'");
      }
      query.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      query.append("                    AND clr.codigo_representante = r.rep_cdgo ");
      query.append("                    AND p.esc_seqn = clr.codigo_sequencial ");
      query.append("                    AND p.cli_cdgo = clr.codigo_cliente ");
      query.append("                    AND rm.marca_produto = fct_marca_produto(i.lin_cdgo, i.ref_cdgo) ");
      query.append("                    AND rm.codigo_representante = r.rep_cdgo ");
      query.append("                    AND NVL(p.ped_stat, 'X') <> 'C' ");
      query.append("                    AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP') ");
      query.append("                    AND (NVL(p.ped_especie_pedido, 'x') IN ('C', 'R') OR NVL(p.ped_substituicao, 'N') = 'S') ");
      query.append("                    AND i.ped_nmro = p.ped_nmro) ");
      query.append("          GROUP BY cli_cdgo ");
      query.append("                 , cli_nome ");
      query.append("                 , cli_rzao) ");
      query.append("  WHERE atendimentos = " + f.getAtendimentos());
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
