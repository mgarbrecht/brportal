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
 * Creation Date 26/07/2018 12:31:25
 * Last Modify Date 12/09/2019 14:07:52
 */

public class EmbarqueExportacaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EmbarqueExportacaoActionForm f = (EmbarqueExportacaoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      if ((f.getGerar_planilha() + "").equalsIgnoreCase("1")) {
        actionForward = new ActionForward("/com/EmbarqueExportacaoForm.jsp", true);
      } else {
        actionForward = new ActionForward("/com/EmbarqueExportacao_rForm.jsp", true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_embarque_exportacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EmbarqueExportacaoActionForm f = (EmbarqueExportacaoActionForm) form;
    if (f.getRem_nro().equals("") && f.getPed_nmro().equals("") && f.getPed_invoice().equals("") && (f.getNfs_nmro().equals("") || f.getNfs_serie().equals(""))) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }
    Jw_embarque_exportacao table = new Jw_embarque_exportacao();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"REM_NRO","=", com.egen.util.text.FormatNumber.toInteger(f.getRem_nro())}, {"PED_NMRO","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"PED_INVOICE","like", f.getPed_invoice()}, {"fil_filial","like", f.getFil_filial()}, {"NFS_NMRO","=", com.egen.util.text.FormatNumber.toInt(f.getNfs_nmro())}, {"NFS_SERIE","like", f.getNfs_serie()} };
    Vector res_Jw_embarque_exportacao = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_embarque_exportacao",res_Jw_embarque_exportacao);
    if (!(res_Jw_embarque_exportacao != null && res_Jw_embarque_exportacao.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    if ((f.getGerar_planilha() + "").equalsIgnoreCase("1")) {
      util.consultas.com.EmbarqueExportacao embarqueExportacao = new util.consultas.com.EmbarqueExportacao(res_Jw_embarque_exportacao);
      String arquivo = embarqueExportacao.geraExcel();
      if (!arquivo.equals("")) {
        session.setAttribute("arquivo", arquivo);
      }
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EmbarqueExportacaoActionForm f = (EmbarqueExportacaoActionForm) form;
      session.removeAttribute("res_Jw_embarque_exportacao");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_embarque_exportacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
