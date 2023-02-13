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
 * Creation Date 08/09/2006 11:10:23
 * Last Modify Date 14/07/2015 13:15:48
 */

public class ClassificacaoFiscalAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClassificacaoFiscalActionForm f = (ClassificacaoFiscalActionForm) form;
      try {

        if ((!(f.getCodigo_marca() != "")) && (!(f.getLin_cdgo() != ""))) {
          throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
        }

        select_action(j, mapping, form, request, response);
        tg_select_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/ind/ClassificacaoFiscal_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ncm", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ClassificacaoFiscalActionForm f = (ClassificacaoFiscalActionForm) form;
    portalbr.dbobj.view.Jw_ncm table = new portalbr.dbobj.view.Jw_ncm();
    String[][] select = null;
    String[] order = {"Codigo_marca","Lin_cdgo","Ref_cdgo","Cab_cdgo"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"Codigo_marca","like", f.getCodigo_marca()}, {"Lin_cdgo","like", f.getLin_cdgo()}, {"Ref_cdgo","like", f.getRef_cdgo()}, {"Cab_cdgo","like", f.getCab_cdgo()}, {"Ref_status","like", f.getSituacao()}, {"Rfb_status","like", f.getSituacao()} };
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível! javaview: res_Jw_ncm");
    }
    Vector res_Jw_ncm = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_ncm",res_Jw_ncm);
    if (!(res_Jw_ncm != null && res_Jw_ncm.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ncm", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ClassificacaoFiscalActionForm f = (ClassificacaoFiscalActionForm) form;
      java.util.Vector res_Jw_ncm = (java.util.Vector) session.getAttribute("res_Jw_ncm");
      if (res_Jw_ncm != null && res_Jw_ncm.size() == 0) {
        throw new Exception("Nenhum registro encontrado!");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClassificacaoFiscalActionForm f = (ClassificacaoFiscalActionForm) form;
      session.removeAttribute("res_Jw_ncm");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ncm", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
