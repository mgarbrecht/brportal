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
 * Creation Date 12/04/2006 12:00:31
 * Last Modify Date 28/10/2013 09:34:31
 */

public class EntidadeNegocioChaveAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 12/04/2006
    // Data de Alteração :
    // Objetivo          : Insere uma nova Entidade de Negócio por Chave
    //---------------------------------------------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      insert_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntidadeNegocioChaveActionForm f = (EntidadeNegocioChaveActionForm) form;
    portalbr.dbobj.table.Entidades_negocio table = new portalbr.dbobj.table.Entidades_negocio();
    //--------------------------------------------------------------------------------------------------
    acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn());
    acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getEnne_tien_id()));
    entidade.setChave(f.getEnne_chave().trim());
    entidade.setDescricao(f.getEnne_descricao());
    entidade.setTipoEntidadeNegocio(tipoentidade);
    entidade.insert();
    //--------------------------------------------------------------------------------------------------
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntidadeNegocioChaveActionForm f = (EntidadeNegocioChaveActionForm) form;
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
