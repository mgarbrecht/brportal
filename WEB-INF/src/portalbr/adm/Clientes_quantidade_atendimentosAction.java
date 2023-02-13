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
 * Last Modify Date 10/12/2020 18:02:30
 */

public class Clientes_quantidade_atendimentosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_quantidade_atendimentos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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

    Clientes_quantidade_atendimentosActionForm f = (Clientes_quantidade_atendimentosActionForm) form;
    portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos table = new portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos();
    String lin_cdgo = null;
    String codigo_marca = null;
    String codigo_regional = null;

    String usuario = "";
    acesso.Sessao s = new acesso.Sessao(session);
    usuario = s.getUsuario();


    if (!f.getLin_cdgo().equals("")) {
      lin_cdgo = f.getLin_cdgo();
    }
    if (!f.getCodigo_marca().equals("")) {
      codigo_marca = f.getCodigo_marca();
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT atendimentos ");
    query.append("      , COUNT(DISTINCT cli_cdgo) clientes ");
    query.append("   FROM (SELECT cli_cdgo ");
    query.append("              , COUNT(DISTINCT ped_nmro) atendimentos ");
    query.append("           FROM (SELECT p.cli_cdgo ");
    query.append("                      , p.ped_nmro ");
    query.append("                   FROM ped p ");
    query.append("                      , rep r ");
    query.append("                      , ite i ");
    query.append("                      , cli c ");
    query.append("                      , cliente_representante clr ");
    query.append("                      , representante_marca   rm ");
    query.append("                  WHERE p.ped_dadg >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
    query.append("                    AND p.ped_dadg < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
    query.append("                    AND c.cli_situ = NVL('A', c.cli_situ) ");
    query.append("                    AND c.seg_cdgo NOT IN (9, 153) ");
    query.append("                    AND c.cli_cdgo = p.cli_cdgo ");
    query.append("                    AND r.rep_situ = NVL(").append(session.getAttribute("situacao_representante")).append(", r.rep_situ) ");
    query.append("                    AND clr.situacao = NVL(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
    query.append("                    AND rm.situacao = NVL(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
    query.append("                    AND i.lin_cdgo =  nvl(").append(session.getAttribute("lin_cdgo")).append(",i.lin_cdgo) ");
    query.append("                    AND r.codigo_regional =  nvl(").append(session.getAttribute("codigo_regional")).append(", r.codigo_regional) ");
    query.append("                    AND rm.marca_produto =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
    query.append("                    AND r.rep_cdgo = p.rep_cdgo ");
    query.append("                    AND clr.codigo_representante = r.rep_cdgo ");
    query.append("                    AND p.esc_seqn = clr.codigo_sequencial ");
    query.append("                    AND p.cli_cdgo = clr.codigo_cliente ");
    query.append("                    AND rm.marca_produto = fct_marca_produto(i.lin_cdgo,i.ref_cdgo) ");
    query.append("                    AND rm.codigo_representante = r.rep_cdgo ");
    query.append("                    AND NVL(p.ped_stat, 'X') <> 'C' ");
    query.append("                    AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP') ");
    query.append("                    AND NVL(p.ped_especie_pedido, 'x') IN ('F', 'N', 'M', 'P', 'X') ");
    query.append("                    AND NVL(p.ped_substituicao, 'N') <> 'S' ");
    query.append("                    AND i.ped_nmro = p.ped_nmro ");
    query.append("                    AND NVL(p.cli_cdgo, NULL) <> 40000 ");
    query.append("                  UNION ");
    query.append("                 SELECT p.cli_cdgo ");
    query.append("                      , p.ped_nmro ");
    query.append("                   FROM ped p ");
    query.append("                      , rep r ");
    query.append("                      , cli c ");
    query.append("                      , ite i ");
    query.append("                      , cliente_representante clr ");
    query.append("                      , representante_marca   rm ");
    query.append("                  WHERE p.ped_dadg >= to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') ");
    query.append("                    AND p.ped_dadg < to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1 ");
    query.append("                    AND c.cli_situ = NVL('A', c.cli_situ) ");
    query.append("                    AND c.seg_cdgo NOT IN (9, 153) ");
    query.append("                    AND c.cli_cdgo = p.cli_cdgo ");
    query.append("                    AND r.rep_situ = NVL(").append(session.getAttribute("situacao_representante")).append(", r.rep_situ) ");
    query.append("                    AND clr.situacao = NVL(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
    query.append("                    AND rm.situacao = NVL(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
    query.append("                    AND i.lin_cdgo =  nvl(").append(session.getAttribute("lin_cdgo")).append(",i.lin_cdgo) ");
    query.append("                    AND r.codigo_regional =  nvl(").append(session.getAttribute("codigo_regional")).append(", r.codigo_regional) ");
    query.append("                    AND rm.marca_produto =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
    query.append("                    AND r.rep_cdgo = p.rep_cdgo ");
    query.append("                    AND clr.codigo_representante = r.rep_cdgo ");
    query.append("                    AND p.esc_seqn = clr.codigo_sequencial ");
    query.append("                    AND p.cli_cdgo = clr.codigo_cliente ");
    query.append("                    AND rm.marca_produto = fct_marca_produto(i.lin_cdgo,i.ref_cdgo) ");
    query.append("                    AND rm.codigo_representante = r.rep_cdgo ");
    query.append("                    AND NVL(p.ped_stat, 'X') <> 'C' ");
    query.append("                    AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP') ");
    query.append("                    AND (NVL(p.ped_especie_pedido, 'x') IN ('C', 'R') OR NVL(p.ped_substituicao, 'N') = 'S') ");
    query.append("                    AND i.ped_nmro = p.ped_nmro ");
    query.append("                 ) ");
    query.append("          GROUP BY cli_cdgo) ");
    query.append("  GROUP BY atendimentos ");
    query.append("  ORDER BY atendimentos ");

    Vector res_Clientes_quantidade_atendimentos = j.select(table, query.toString(), null);

    session.setAttribute("res_Clientes_quantidade_atendimentos", res_Clientes_quantidade_atendimentos);
    if (!(res_Clientes_quantidade_atendimentos != null && res_Clientes_quantidade_atendimentos.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_quantidade_atendimentos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Clientes_quantidade_atendimentosActionForm f = (Clientes_quantidade_atendimentosActionForm) form;
      session.removeAttribute("res_Clientes_regional");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_quantidade_atendimentos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
