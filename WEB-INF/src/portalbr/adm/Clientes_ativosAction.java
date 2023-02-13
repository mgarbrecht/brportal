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
 * Creation Date 01/09/2006 17:50:07
 * Last Modify Date 03/10/2016 15:33:19
 */

public class Clientes_ativosAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_ativos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Clientes_ativosActionForm f = (Clientes_ativosActionForm) form;
    portalbr.dbobj.view.Jw_clientes_ativos table = new portalbr.dbobj.view.Jw_clientes_ativos();
    String representante = "";
    String marca = "";
    String regional = "";
    StringBuilder parametros = new StringBuilder();

    if (!(f.getRep_cdgo() == null)) {
      parametros.append("  and  rm.situacao  = 'A' ");
      parametros.append("  and  rep.rep_situ = 'A' ");
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
    query.append(" SELECT /*+ all_rows */ DISTINCT ");
    query.append("        cli.cli_cdgo ");
    query.append("      , cli.cli_nome ");
    query.append("      , cli.cli_rzao ");
    query.append("      , '' cidade ");
    query.append("      , cli_dult ");
    query.append("   FROM rep ");
    query.append("      , cliente_representante clr ");
    query.append("      , cli ");
    query.append("      , representante_marca rm ");
    query.append("  WHERE clr.codigo_representante = rep.rep_cdgo ");
    query.append("    AND cli.cli_cdgo             = clr.codigo_cliente ");
    query.append("    AND rm.codigo_representante  = rep.rep_cdgo ");
    query.append("    AND rep.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("    AND clr.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("    AND rm.situacao              = nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append("    AND rm.marca_produto         = nvl(").append(marca).append(", rm.marca_produto) ");
    query.append("    AND rep.rep_cdgo             = nvl(").append(representante).append(",rep.rep_cdgo) ");
    query.append("    AND rep.codigo_regional      = nvl(").append(regional).append(",rep.codigo_regional) ");
    query.append("    AND rm.marca_produto         = nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
    query.append("    AND rep.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional) ");
    query.append("    AND rep.codigo_regional      > 0 ");
    query.append("    AND cli.cli_situ             = 'A' ");
    query.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
    query.append(parametros.toString());
    query.append("  ORDER BY cli_cdgo ");

    Vector res_Jw_clientes_ativos = j.select(table, query.toString(), null);

    if (res_Jw_clientes_ativos != null && res_Jw_clientes_ativos.size() > 0) {
      util.consultas.Cidades cid = new util.consultas.Cidades();
      for (int x = 0; x < res_Jw_clientes_ativos.size(); x++) {
        portalbr.dbobj.view.Jw_clientes_ativos r = (portalbr.dbobj.view.Jw_clientes_ativos) res_Jw_clientes_ativos.elementAt(x);
        r.setCidade(cid.retornaCidades(r.getCli_cdgo() + ""));
        r.setEmail(cid.retornaEmails());
      }
    }

    session.setAttribute("res_Jw_clientes_ativos",res_Jw_clientes_ativos);
    if (!(res_Jw_clientes_ativos != null && res_Jw_clientes_ativos.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_ativos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
}
