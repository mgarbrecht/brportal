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
 * Creation Date 23/01/2014 11:05:43
 * Last Modify Date 18/08/2015 12:20:31
 */

public class ArquivosFornecedoresOcAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ArquivosFornecedoresOcActionForm f = (ArquivosFornecedoresOcActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ArquivosFornecedoresOc_rGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivo_compra_oc", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosFornecedoresOcActionForm f = (ArquivosFornecedoresOcActionForm) form;
    Jw_interface_arq_compra table = new Jw_interface_arq_compra();

    StringBuilder parametros = new StringBuilder();
    if (f.getOco_numero() != "") {
      parametros.append(" AND ioc.oco_numero = " + f.getOco_numero());
    }
    if (f.getRem_nro() != "") {
      parametros.append(" AND ioc.rem_nro = " + f.getRem_nro());
    }
    if (f.getData_inicial() != "") {
      parametros.append(" AND ioc.data_compra >= to_date('"+f.getData_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getData_final() != "") {
      parametros.append(" AND ioc.data_compra <= to_date('"+f.getData_final() + "','dd/mm/yyyy') ");
    }

    StringBuilder sbQuery = new StringBuilder();
    sbQuery.append(" SELECT iac.interface_arq_compra_id ");
    sbQuery.append("      , iac.for_codigo forn_codigo ");
    sbQuery.append("      , iac.nome_arquivo ");
    sbQuery.append("      , iac.situacao ");
    sbQuery.append("      , decode(situacao,'P','Publicado','B','Baixado','C','Consultado', situacao) descricao_situacao ");
    sbQuery.append("   FROM interface_arq_compra iac ");
    sbQuery.append("  WHERE iac.ativo = 'S' ");
    sbQuery.append("    AND iac.tipo = 'O' ");
    if (f.getForn_codigo() != "") {
      sbQuery.append(" AND iac.for_codigo = " + f.getForn_codigo());
    }
    if (parametros.length() > 0) {
      sbQuery.append("    AND EXISTS (SELECT 1 ");
      sbQuery.append("                  FROM interface_arq_compra_oc ioc ");
      sbQuery.append("                 WHERE ioc.interface_arq_compra_id = iac.interface_arq_compra_id ");
      sbQuery.append(parametros.toString());
      sbQuery.append("               ) ");
    }

    session.setAttribute("query_interface_arq_compra", sbQuery.toString());
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ArquivosFornecedoresOcActionForm f = (ArquivosFornecedoresOcActionForm) form;
      session.removeAttribute("res_Jw_arquivo_compra_oc");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivo_compra_oc", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
