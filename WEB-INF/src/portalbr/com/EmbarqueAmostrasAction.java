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
 * Creation Date 08/02/2012 14:00:00
 * Last Modify Date 04/07/2012 12:18:31
 */

public class EmbarqueAmostrasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EmbarqueAmostrasActionForm f = (EmbarqueAmostrasActionForm) form;
      util.consultas.com.EmbarqueAmostra embarque = new util.consultas.com.EmbarqueAmostra();
      String arquivo = null;
      //----------------------------------------------------------
      arquivo = embarque.geraExcel(f.getDt_inicial(), f.getDt_final(), f.getMarca().equals("") ? null : f.getMarca(), f.getFil_filial().equals("") ? null : f.getFil_filial(), f.getTipo_linha().equals("") ? null : f.getTipo_linha(), f.getMix(), f.getFator().equals("") ? "2.1":f.getFator().replace(",","."), f.getLiv_cdgo().equals("") ? "21":f.getLiv_cdgo());

      if (arquivo.equals("")) {
        throw new Exception("Nenhum registro encontrado!");
      }

      //----------------------------------------------------------
      request.setAttribute("abre_automaticamente","N");
      //----------------------------------------------------------
      request.setAttribute("arquivo", arquivo);
      //----------------------------------------------------------


      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_embarque_amostras", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      EmbarqueAmostrasActionForm f = (EmbarqueAmostrasActionForm) form;
      session.removeAttribute("res_Jw_embarque_amostras");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_embarque_amostras", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
