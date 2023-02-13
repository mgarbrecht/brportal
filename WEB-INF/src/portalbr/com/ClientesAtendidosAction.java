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
 * Creation Date 28/04/2020 11:23:26
 * Last Modify Date 28/04/2020 12:44:23
 */

public class ClientesAtendidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClientesAtendidosActionForm f = (ClientesAtendidosActionForm) form;
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("ClientesAtendidos.jasper");
      g.setParametro("P_TIPO", f.getTipo());
      g.setParametro("P_MES", f.getMes());
      g.setParametro("P_ANO", f.getAno());
      g.setParametro("P_CODIGO_REGIONAL", f.getCodigo_regional());
      g.setParametro("P_GRE_GRUPO", f.getGre_grupo());
      g.setParametro("P_CODIGO_REPRESENTANTE", f.getRep_cdgo());
      g.setParametro("P_CODIGO_CLIENTE", f.getCli_cdgo());
      g.setParametro("P_CODIGO_MARCA", f.getCodigo_marca());
      g.gerar();
      request.setAttribute("abre_automaticamente","N");


      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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


  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesAtendidosActionForm f = (ClientesAtendidosActionForm) form;
      session.removeAttribute("res_Dual");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
