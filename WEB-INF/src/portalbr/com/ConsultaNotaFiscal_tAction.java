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
 * Creation Date 25/10/2012 17:10:34
 * Last Modify Date 26/10/2012 08:49:39
 */

public class ConsultaNotaFiscal_tAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ConsultaNotaFiscal_tActionForm[]_ge_grid_array = (ConsultaNotaFiscal_tActionForm[])_ge_grid.get("bl_form_Tipo_ocorrencia_lines");
      ConsultaNotaFiscal_tActionForm f = _ge_grid_array[0];
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    java.util.List < String > listaTipoOcorrencias = new java.util.ArrayList < String > ();
    java.util.List < String > listaTipoOcorrenciasDescricao = new java.util.ArrayList < String > ();
    ConsultaNotaFiscal_tActionForm[]_ge_grid_array = (ConsultaNotaFiscal_tActionForm[])_ge_grid.get("bl_form_Tipo_ocorrencia_lines");
    ConsultaNotaFiscal_tActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getDescricao() != null && f.getDescricao() != "") {
        listaTipoOcorrencias.add(f.getCodigo());
        listaTipoOcorrenciasDescricao.add(f.getCodigo() + "-"+f.getDescricao());
      }
    }
    request.setAttribute("fechar","ok");
    session.setAttribute("listaTipoOcorrencias",listaTipoOcorrencias);
    session.setAttribute("listaTipoOcorrenciasDescricao",listaTipoOcorrenciasDescricao);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ConsultaNotaFiscal_tActionForm[]_ge_grid_array = (ConsultaNotaFiscal_tActionForm[])_ge_grid.get("bl_form_Tipo_ocorrencia_lines");
      ConsultaNotaFiscal_tActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Tipo_ocorrencia");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Tipo_ocorrencia_lines", mapping, form, request);
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
