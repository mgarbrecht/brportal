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
 * Creation Date 03/05/2006 09:02:08
 * Last Modify Date 18/12/2014 14:15:20
 */

public class CodigoBarraUnicoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //----------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 03/05/2006
    // Objetivo          : Executa uma consulta na tabela:
    //                     portalbr.dbobj.table.Ref_cor,
    //                     redirecionando para o relatório que mostra o código de barra único EAN13:
    //                     /com/CodigoBarraUnico_rForm.jsp
    //-----------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-----------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      CodigoBarraUnicoActionForm f = (CodigoBarraUnicoActionForm) form;
      actionForward = new ActionForward("/com/CodigoBarraUnico_rForm.do?&consulta="+f.getConsulta(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    CodigoBarraUnicoActionForm f = (CodigoBarraUnicoActionForm) form;
    portalbr.dbobj.table.Ref_cor table = new portalbr.dbobj.table.Ref_cor();
    String[][] select = null;
    String[] order = {"lin_cdgo","ref_cdgo","cab_cdgo","cor_cdgo"};
    Object[][] where = { {"Lin_cdgo","=", com.egen.util.text.FormatNumber.toInt(f.getLin_cdgo())}, {"Ref_cdgo","=", com.egen.util.text.FormatNumber.toInt(f.getRef_cdgo())}, {"Cab_cdgo","=", com.egen.util.text.FormatNumber.toInt(f.getCab_cdgo())}, {"Cor_cdgo","=", com.egen.util.text.FormatNumber.toInt(f.getCor_cdgo())}, };
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível! tabela: Ref_cor");
    }
    Vector res_Ref_cor = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Ref_cor",res_Ref_cor);
    if (!(res_Ref_cor != null && res_Ref_cor.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
    request.setAttribute("consulta",f.getConsulta());
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CodigoBarraUnicoActionForm f = (CodigoBarraUnicoActionForm) form;
      session.removeAttribute("res_Ref_cor");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
