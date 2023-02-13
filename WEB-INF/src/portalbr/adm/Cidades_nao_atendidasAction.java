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
 * Creation Date 30/01/2006 11:28:43
 * Last Modify Date 16/11/2009 11:16:36
 */

public class Cidades_nao_atendidasAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cid_atend_reg", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    String representante = "";
    String marca = "";
    String regional = "";
    Cidades_nao_atendidasActionForm f = (Cidades_nao_atendidasActionForm) form;
    portalbr.dbobj.view.Jw_cid_atend_reg table = new portalbr.dbobj.view.Jw_cid_atend_reg();

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
    query.append(" SELECT DISTINCT ");
    query.append("        ecl.ecl_cdad||' - '||ecl.est_unifed cidade ");
    query.append("   FROM ecl ");
    query.append("      , cliente_representante cr ");
    query.append("      , rep r ");
    query.append("      , representante_marca rm ");
    query.append("      , cli c ");
    query.append("  WHERE ecl.ned_cdgo            in ('COB', 'UNI') ");
    query.append("    AND ecl.cli_cdgo             =  cr.codigo_cliente ");
    query.append("    AND cr.codigo_representante  =  r.rep_cdgo ");
    query.append("    AND r.rep_cdgo               =  rm.codigo_representante ");
    query.append("    AND cr.codigo_sequencial     =  ecl.esc_seqn ");
    query.append("    AND c.cli_cdgo               =  cr.codigo_cliente ");
    query.append("    AND ecl.cli_cdgo             >  0 ");
    query.append("    AND rm.marca_produto         >  0 ");
    query.append("    AND c.cli_situ               =  'A' ");
    query.append("    AND r.rep_situ               =  nvl(").append(session.getAttribute("situacao_representante")).append(",r.rep_situ) ");
    query.append("    AND cr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",cr.situacao) ");
    query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append("    AND r.codigo_regional        =  nvl(").append(regional).append(",r.codigo_regional) ");
    query.append("    AND cr.codigo_representante  =  nvl(").append(representante).append(",cr.codigo_representante)  ");
    query.append("    AND rm.marca_produto         =  nvl(").append(marca).append(",rm.marca_produto)  ");
    query.append("    AND rm.marca_produto         =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
    query.append("    AND r.codigo_regional        =  nvl(").append(session.getAttribute("codigo_regional")).append(",r.codigo_regional) ");
    query.append("  MINUS ");
    query.append(" (");
    query.append(" SELECT DISTINCT(ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade ");
    query.append("   FROM resumo_ped res ");
    query.append("      , ecl ");
    query.append("      , cli ");
    query.append("      , rep ");
    query.append("      , cliente_representante clr ");
    query.append("      , representante_marca rm  ");
    query.append("  WHERE res.rep_cdgo             =  nvl(").append(session.getAttribute("codigo_representante")).append(",res.rep_cdgo) ");
    query.append("    AND res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
    query.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
    query.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
    query.append("    AND ecl.cli_cdgo             =  res.cli_cdgo ");
    query.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
    query.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
    query.append("    AND clr.codigo_cliente       =  cli.cli_cdgo ");
    query.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
    query.append("    AND rm.marca_produto         =  res.codigo_marca ");
    query.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
    query.append("    AND clr.codigo_sequencial    =  res.esc_seqn ");
    query.append("    AND res.rep_cdgo             =  nvl(").append(representante).append(",res.rep_cdgo) ");
    query.append("    AND rm.marca_produto         =  nvl(").append(marca).append(",rm.marca_produto) ");
    query.append("    AND res.codigo_regional      =  nvl(").append(regional).append(",res.codigo_regional) ");
    query.append("    AND ecl.ned_cdgo             in ('COB', 'UNI') ");
    query.append("    AND ecl.esc_seqn             =  res.esc_seqn  ");
    query.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
    query.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append("  UNION ALL ");
    query.append(" SELECT DISTINCT(ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade  ");
    query.append("   FROM resumo_pedidos res ");
    query.append("      , ecl ");
    query.append("      , cli ");
    query.append("      , rep ");
    query.append("      , cliente_representante clr ");
    query.append("      , representante_marca rm ");
    query.append("  WHERE res.codigo_regional      >  0  ");
    query.append("    AND res.codigo_regional      =  nvl(").append(f.getCodigo_regional()).append(",res.codigo_regional) ");
    query.append("    AND res.rep_cdgo             =  nvl(").append(session.getAttribute("codigo_representante")).append(",res.rep_cdgo) ");
    query.append("    AND res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
    query.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(", res.codigo_marca) ");
    query.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
    query.append("    AND ecl.cli_cdgo             =  res.cli_cdgo ");
    query.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
    query.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
    query.append("    AND clr.codigo_cliente       =  cli.cli_cdgo ");
    query.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
    query.append("    AND rm.marca_produto         =  res.codigo_marca ");
    query.append("    AND clr.codigo_sequencial    =  res.esc_seqn ");
    query.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
    query.append("    AND ecl.ned_cdgo             in ('COB', 'UNI') ");
    query.append("    AND ecl.esc_seqn             =  res.esc_seqn  ");
    query.append("    AND res.rep_cdgo             =  nvl(").append(representante).append(",res.rep_cdgo) ");
    query.append("    AND rm.marca_produto         =  nvl(").append(marca).append(",rm.marca_produto) ");
    query.append("    AND res.codigo_regional      =  nvl(").append(regional).append(",res.codigo_regional) ");
    query.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
    query.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append(") ");

    Vector res_Jw_cid_atend_reg = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_cid_atend_reg",res_Jw_cid_atend_reg);
    if (!(res_Jw_cid_atend_reg != null && res_Jw_cid_atend_reg.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cid_atend_reg", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Cidades_atendidasActionForm f = (Cidades_atendidasActionForm) form;
      actionForward = new ActionForward (f.getChamador(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cid_atend_reg", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
