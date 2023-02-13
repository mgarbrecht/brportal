package portalbr.lov;

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
 * Creation Date 25/10/2012 17:00:07
 * Last Modify Date 11/04/2018 16:56:28
 */

public class LvTipoOcorrenciasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvTipoOcorrenciasActionForm f = (LvTipoOcorrenciasActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipo_ocorrencia", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvTipoOcorrenciasActionForm f = (LvTipoOcorrenciasActionForm) form;
    Tipo_ocorrencia table = new Tipo_ocorrencia();
    String[][] select = {{"codigo",null},{"descricao",null}};
    String[] order = {"codigo"};
    String[] groupby = {"codigo","descricao"};
    String[] having = null;
    Object[][] where = { {"CODIGO","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo())}, {"DESCRICAO","like", f.getDescricao().toUpperCase()} };
    //  Vector res_Tipo_ocorrencia = j.select(table, select, where, groupby, having, order);
    Vector res_Tipo_ocorrencia = j.select(table, "select distinct codigo, descricao, null desconsiderar, null tra_cdgo, null usuario_inclusao, null dthr_inclusao, null usuario_alteracao, null dthr_alteracao from wbrio.tipo_ocorrencia t order by codigo, descricao", null);

    session.setAttribute("res_Tipo_ocorrencia",res_Tipo_ocorrencia);
    if (res_Tipo_ocorrencia == null || res_Tipo_ocorrencia.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipo_ocorrencia", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvTipoOcorrenciasActionForm f = (LvTipoOcorrenciasActionForm) form;
      session.removeAttribute("res_Tipo_ocorrencia");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipo_ocorrencia", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
