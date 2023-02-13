package portalbr.ind;

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
 * Creation Date 15/01/2015 11:54:29
 * Last Modify Date 10/02/2015 14:10:34
 */

public class AtelieresQuarterizados_frAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_frActionForm f = (AtelieresQuarterizados_frActionForm) form;


      actionForward = new ActionForward("/ind/AtelieresQuarterizados_fForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_frActionForm f = (AtelieresQuarterizados_frActionForm) form;
      java.util.Vector res_Jw_relatorio_atelier_pre_envio_quarterizado = (java.util.Vector) session.getAttribute("res_Jw_relatorio_atelier_pre_envio_quarterizado");
      res_Jw_relatorio_atelier_pre_envio_quarterizado.removeElementAt(0);
      String atelier = null;
      acesso.Sessao sessao = new acesso.Sessao(session);
      if (sessao.getTipoEntidadeNegocio().equals("ATELIER")) {
        atelier = sessao.getChave();
      }
      StringBuilder sb = new StringBuilder();
      sb.append(" DELETE atelier_pre_envio_quarterizado ");
      sb.append("  WHERE for_codigo = " + atelier);
      sb.append("    AND for_codigo_quarterizado = " + f.getFornecedor_codigo_quarterizado());
      sb.append("    AND fen_seq_quarterizado = " + f.getFen_seq_quarterizado());
      sb.append("    AND pro_numero = " + f.getPro_numero());
      sb.append("    AND rem_nro = " + f.getRem_nro());
      sb.append("    AND tal_nro = " + f.getTal_nro());
      util.consultas.Query query = new util.consultas.Query();
      query.execute(sb.toString());
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
