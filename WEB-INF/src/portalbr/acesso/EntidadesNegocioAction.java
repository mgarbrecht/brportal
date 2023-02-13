package portalbr.acesso;

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
 * Creation Date 17/01/2006 15:53:56
 * Last Modify Date 07/12/2009 15:20:53
 */

public class EntidadesNegocioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 17/01/2006
    // Data de Alteração :
    // Objetivo          : Faz uma consulta na visão portalbr.dbobj.view.Jw_ent_neg_usuarios
    //                     Após a consulta, redireciona para a tela com a lista dos registros
    //                     retornados:  /acesso/ListaEntidadesNegocioForm.jsp.
    //----------------------------------------------------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/ListaEntidadesNegocioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entidades_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EntidadesNegocioActionForm f = (EntidadesNegocioActionForm) form;
    portalbr.dbobj.view.Jw_ent_neg_usuarios table = new portalbr.dbobj.view.Jw_ent_neg_usuarios();
    String[][] select = null;
    String[] order = {"enne_tien_id","enne_descricao"};
    Object[][] where = { {"upper(Enne_descricao)","like", f.getEnne_descricao().toUpperCase()}, {"Enne_tien_id","=", com.egen.util.text.FormatNumber.toInteger(f.getEnne_tien_id())}, {"Enne_chave","like", f.getEnne_chave()} };
    Vector res_Entidades_negocio = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Entidades_negocio",res_Entidades_negocio);
    if (!(res_Entidades_negocio != null && res_Entidades_negocio.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntidadesNegocioActionForm f = (EntidadesNegocioActionForm) form;
      session.removeAttribute("res_Entidades_negocio");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Entidades_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
