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
 * Creation Date 25/05/2011 11:44:52
 * Last Modify Date 21/08/2013 12:00:12
 */

public class ControlePedidosEntregaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ControlePedidosEntregaActionForm f = (ControlePedidosEntregaActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/ControlePedidosEntrega_mGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ControlePedidosEntregaActionForm f = (ControlePedidosEntregaActionForm) form;

    if (f.getRep_cdgo().equals("") && f.getCli_cdgo().equals("") && f.getGre_grupo().equals("")) {
      throw new Exception("Cliente ou Representante deve ser informado!");
    }


    Controle_clientes_especiais_vw table = new Controle_clientes_especiais_vw();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"dt_digit",">=", com.egen.util.text.FormatDate.parseDate(f.getDt_inicial(), "dd/MM/yyyy")}, {"dt_digit","<=", com.egen.util.text.FormatDate.parseDate(f.getDt_final(), "dd/MM/yyyy")}, {"rep_cdgo","like", f.getRep_cdgo()}, {"cli_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCli_cdgo())}, {"codigo_marca","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_marca())}, {"ped_stat","like", f.getPed_stat()}, {"codigo_regional","=", f.getReg()}, {"grupo_economico","=", f.getGre_grupo()} };
    session.setAttribute("where", where);
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ControlePedidosEntregaActionForm f = (ControlePedidosEntregaActionForm) form;
      session.removeAttribute("res_Controle_clientes_especiais_vw");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
