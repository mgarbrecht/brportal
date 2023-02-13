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
 * Creation Date 04/01/2011 12:59:15
 * Last Modify Date 22/06/2015 14:14:47
 */

public class PosicaoAmostrasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostrasActionForm f = (PosicaoAmostrasActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/PosicaoAmostras_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_rep_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PosicaoAmostrasActionForm f = (PosicaoAmostrasActionForm) form;
    Ped_amostra_rep_vw table = new Ped_amostra_rep_vw();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"ped_nmro",">=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"ped_nmro","<=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro_final())}, {"ped_dadg",">=", com.egen.util.text.FormatDate.parseDate(f.getPed_dadg(), "dd/MM/yyyy")}, {"ped_dadg","<=", com.egen.util.text.FormatDate.parseDate(f.getPed_dadg_final(), "dd/MM/yyyy")}, {"nfs_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getNfs_nmro())}, {"regional_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getRegional_cdgo())}, {"rep_cdgo","like", f.getRep_cdgo()}, {"codigo_marca","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_marca())}};


    Vector res_Ped_amostra_rep_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ped_amostra_rep_vw",res_Ped_amostra_rep_vw);
    if (!(res_Ped_amostra_rep_vw != null && res_Ped_amostra_rep_vw.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      PosicaoAmostrasActionForm f = (PosicaoAmostrasActionForm) form;
      if ((f.getNfs_nmro() == "") && (f.getPed_nmro() == "") && (f.getPed_nmro_final() == "") && (f.getPed_dadg() == "") && (f.getPed_dadg_final() == "") && (f.getRegional_cdgo() == "") && (f.getRep_cdgo() == "")) {
        throw new Exception("Um dos parâmetros deve ser informado!");
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
      PosicaoAmostrasActionForm f = (PosicaoAmostrasActionForm) form;
      session.removeAttribute("res_Ped_amostra_rep_vw");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_rep_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
