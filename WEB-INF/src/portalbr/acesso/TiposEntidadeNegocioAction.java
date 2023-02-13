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
 * Creation Date 18/01/2006 09:15:08
 * Last Modify Date 25/02/2016 11:30:46
 */

public class TiposEntidadeNegocioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 18/01/2006
    // Objetivo          : Executa uma consulta na java view:
    //                     portalbr.dbobj.table.Tipos_entidade_negocio,
    //                     Após a consulta, redireciona para a tela com a lista dos tipos de entidades
    //                     de negócio retornados pela consulta:
    //                     /acesso/ListaTiposEntidadeNegocioForm.jsp
    //-------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/ListaTiposEntidadeNegocioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    TiposEntidadeNegocioActionForm f = (TiposEntidadeNegocioActionForm) form;
    portalbr.dbobj.table.Tipos_entidade_negocio table = new portalbr.dbobj.table.Tipos_entidade_negocio();
    String[][] select = null;
    String[] order = {"tien_tipo"};
    Object[][] where = { {"Tien_id","=", com.egen.util.text.FormatNumber.toInteger(f.getTien_id())}, {"upper(Tien_tipo)","like", f.getTien_tipo().toUpperCase()}, {"upper(Tien_tabela)","like", f.getTien_tabela().toUpperCase()}, {"upper(Tien_campos_descr)","like", f.getTien_campos_descr().toUpperCase()}, {"Tien_campos_chave","like", f.getTien_campos_chave()}, {"Tien_condicional","like", f.getTien_condicional()} };
    Vector res_Tipos_entidade_negocio = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Tipos_entidade_negocio",res_Tipos_entidade_negocio);
    if (!(res_Tipos_entidade_negocio != null && res_Tipos_entidade_negocio.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TiposEntidadeNegocioActionForm f = (TiposEntidadeNegocioActionForm) form;
      session.removeAttribute("res_Tipos_entidade_negocio");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 18/01/2006
    // Objetivo          : Redireciona para a tela de inclusão de novo tipo de entidade de negócio:
    //                     /acesso/TiposEntidadeNegocio_iForm.jsp
    //-------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/acesso/TiposEntidadeNegocio_iForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
