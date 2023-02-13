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
 * Last Modify Date 25/03/2020 16:20:09
 */

public class Clientes_fluxo_representanteAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_fluxo_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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

    Clientes_fluxo_representanteActionForm f = (Clientes_fluxo_representanteActionForm) form;
    portalbr.dbobj.view.Jw_fluxo_representante table = new portalbr.dbobj.view.Jw_fluxo_representante();

    String lin_cdgo = null;
    String codigo_marca = null;
    String codigo_regional = null;
    String parametros = "";
    if (!f.getLin_cdgo().equals("")) {
      lin_cdgo = f.getLin_cdgo();
    }
    if (!f.getCodigo_marca().equals("")) {
      codigo_marca = f.getCodigo_marca();
    }
    if (!(f.getSituacao_representante() + "").equals("T") && f.getSituacao_representante() != null) {
      parametros = " and  rm.situacao = '" +f.getSituacao_representante() + "' and clr.situacao = '" + f.getSituacao_representante() + "'";
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */ ");
    query.append("        codigo_regional ");
    query.append("      , pck_regionais_vendas.get_nome(codigo_regional) nome_regional ");
    query.append("      , rep_cdgo ");
    query.append("      , rep_rzao ");
    query.append("      , quantidade_meses ");
    query.append("      , quantidade_meses || ' ' || CASE ");
    query.append("          WHEN quantidade_meses = 1 THEN ");
    query.append("           'M�s' ");
    query.append("          ELSE ");
    query.append("           'Meses' ");
    query.append("        END descricao_quantidade_meses ");
    query.append("      , COUNT(DISTINCT cli_Cdgo) clientes ");
    query.append("   FROM (SELECT cli_cdgo ");
    query.append("              , codigo_regional ");
    query.append("              , rep_cdgo ");
    query.append("              , rep_rzao ");
    query.append("              , COUNT(DISTINCT mes_ano) quantidade_meses ");
    query.append("           FROM (SELECT cli.cli_cdgo ");
    query.append("                      , res.codigo_regional ");
    query.append("                      , rep.rep_cdgo ");
    query.append("                      , rep.rep_rzao ");
    query.append("                      , to_char(data_dig, 'mm/yyyy') mes_ano ");
    query.append("                   FROM resumo_ped            res ");
    query.append("                      , cli ");
    query.append("                      , rep ");
    query.append("                      , cliente_representante clr ");
    query.append("                      , representante_marca   rm ");
    query.append("                  WHERE res.data_dig >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("                    AND res.data_dig <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("                    AND cli.cli_cdgo = res.cli_cdgo ");
    query.append("                    AND rep.rep_cdgo = res.rep_cdgo ");
    query.append("                    AND res.esc_seqn = clr.codigo_sequencial ");
    query.append("                    AND rm.marca_produto = res.codigo_marca ");
    query.append("                    AND clr.codigo_representante = rep.rep_cdgo ");
    query.append("                    AND cli.cli_cdgo = clr.codigo_cliente ");
    query.append("                    AND rm.codigo_representante = rep.rep_cdgo ");
    query.append("                    AND cli.cli_situ = NVL('A', cli.cli_situ) ");
    query.append("                    AND cli.seg_cdgo NOT IN (9, 153) ");
    query.append("                    AND res.lin_cdgo =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
    query.append("                    AND res.codigo_regional =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
    query.append("                    AND res.codigo_marca =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
    query.append("                    AND res.rep_cdgo =  nvl(").append(session.getAttribute("codigo_representante")).append(",res.rep_cdgo) ");
    query.append("                    AND rep.rep_situ = NVL(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ) ");
    query.append("                    AND clr.situacao = NVL(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
    query.append("                    AND rm.situacao = NVL(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao) ");
    query.append("                  UNION ALL ");
    query.append("                 SELECT cli.cli_cdgo ");
    query.append("                      , res.codigo_regional ");
    query.append("                      , rep.rep_cdgo ");
    query.append("                      , rep.rep_rzao ");
    query.append("                      , to_char(data_dig, 'mm/yyyy') mes_ano ");
    query.append("                   FROM resumo_pedidos        res ");
    query.append("                      , cli ");
    query.append("                      , rep ");
    query.append("                      , cliente_representante clr ");
    query.append("                      , representante_marca   rm ");
    query.append("                  WHERE res.data_dig >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("                    AND res.data_dig <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("                    AND cli.cli_cdgo = res.cli_cdgo ");
    query.append("                    AND rep.rep_cdgo = res.rep_cdgo ");
    query.append("                    AND res.esc_seqn = clr.codigo_sequencial ");
    query.append("                    AND rm.marca_produto = res.codigo_marca ");
    query.append("                    AND clr.codigo_representante = rep.rep_cdgo ");
    query.append("                    AND cli.cli_cdgo = clr.codigo_cliente ");
    query.append("                    AND rm.codigo_representante = rep.rep_cdgo ");
    query.append("                    AND cli.cli_situ = NVL('A', cli.cli_situ) ");
    query.append("                    AND cli.seg_cdgo NOT IN (9, 153) ");
    query.append("                    AND res.lin_cdgo =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
    query.append("                    AND res.codigo_regional =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
    query.append("                    AND res.codigo_marca =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
    query.append("                    AND res.rep_cdgo =  nvl(").append(session.getAttribute("codigo_representante")).append(",res.rep_cdgo) ");
    query.append("                    AND rep.rep_situ = NVL(").append(session.getAttribute("situacao_representante")).append(", rep.rep_situ) ");
    query.append("                    AND clr.situacao = NVL(").append(session.getAttribute("situacao_cliente_representante")).append(", clr.situacao) ");
    query.append("                    AND rm.situacao = NVL(").append(session.getAttribute("situacao_representante_marca")).append(", rm.situacao)) ");
    query.append("          GROUP BY cli_cdgo ");
    query.append("                 , codigo_regional ");
    query.append("                 , rep_cdgo ");
    query.append("                 , rep_rzao) ");
    query.append("  GROUP BY quantidade_meses ");
    query.append("         , codigo_regional ");
    query.append("         , rep_cdgo ");
    query.append("         , rep_rzao ");
    query.append("  ORDER BY codigo_regional ");
    query.append("         , rep_cdgo ");
    query.append("         , quantidade_meses ");

    Vector res_clientes_fluxo_representante = j.select(table, query.toString(), null);


    session.setAttribute("res_clientes_fluxo_representante",res_clientes_fluxo_representante);
    if (!(res_clientes_fluxo_representante != null && res_clientes_fluxo_representante.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_fluxo_representante", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Clientes_fluxo_representanteActionForm f = (Clientes_fluxo_representanteActionForm) form;
      session.removeAttribute("res_Clientes_regional");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_regional", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
