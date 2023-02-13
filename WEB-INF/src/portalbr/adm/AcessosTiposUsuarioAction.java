package portalbr.adm;

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
 * Creation Date 07/04/2010 11:31:17
 * Last Modify Date 07/04/2010 12:39:26
 */

public class AcessosTiposUsuarioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
    Acessos_tipos_usuario_loja table = new Acessos_tipos_usuario_loja();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"actu_tius_tipo","like", f.getActu_tius_tipo()}, };
    session.setAttribute("acessos_tipo_where", where);
    Vector res_Acessos_tipos_usuario_loja = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Acessos_tipos_usuario_loja",res_Acessos_tipos_usuario_loja);
    if (!(res_Acessos_tipos_usuario_loja != null && res_Acessos_tipos_usuario_loja.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/adm/AcessosTiposUsuarioForm.do?select1_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
    Acessos_tipos_usuario_loja table = new Acessos_tipos_usuario_loja();
    j.insert(table);
    Vector res_Acessos_tipos_usuario_loja = (Vector) session.getAttribute("res_Acessos_tipos_usuario_loja");
    if (res_Acessos_tipos_usuario_loja != null && table != null) {
      res_Acessos_tipos_usuario_loja.addElement(table);
      session.setAttribute("res_Acessos_tipos_usuario_loja", res_Acessos_tipos_usuario_loja);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
      session.removeAttribute("res_Acessos_tipos_usuario_loja");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
    Acessos_tipos_usuario_loja table = new Acessos_tipos_usuario_loja();
    table.setActu_id(com.egen.util.text.FormatNumber.parseInt(f.getActu_id()));
    //  table.setActu_tius_tipo(f.getActu_tius_tipo());
    //  table.setActu_inte_id(com.egen.util.text.FormatNumber.parseInt(f.getActu_inte_id()));
    j.delete(table);
    Vector res_Acessos_tipos_usuario_loja = (Vector) session.getAttribute("res_Acessos_tipos_usuario_loja");
    /*  if (res_Acessos_tipos_usuario_loja != null && res_Acessos_tipos_usuario_loja.size() > 0) {
        res_Acessos_tipos_usuario_loja.removeElementAt(0);
        if (res_Acessos_tipos_usuario_loja.size() > 0) {
          Acessos_tipos_usuario_loja r = (Acessos_tipos_usuario_loja) res_Acessos_tipos_usuario_loja.elementAt(0);
          f.setActu_id(r.getActu_id() + "");
          f.setActu_tius_tipo((r.getActu_tius_tipo() != null) ? r.getActu_tius_tipo() + "":"");
          f.setActu_inte_id(r.getActu_inte_id() + "");
        } else {
          f.reset(mapping, request);
        }
      } else {
        f.reset(mapping, request);
      }
    */
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AcessosTiposUsuarioActionForm f = (AcessosTiposUsuarioActionForm) form;
    Acessos_tipos_usuario_loja table = new Acessos_tipos_usuario_loja();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = (Object[][]) session.getAttribute("acessos_tipo_where");
    Vector res_Acessos_tipos_usuario_loja = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Acessos_tipos_usuario_loja",res_Acessos_tipos_usuario_loja);
    if (res_Acessos_tipos_usuario_loja != null && res_Acessos_tipos_usuario_loja.size() > 0) {
      Acessos_tipos_usuario_loja r = (Acessos_tipos_usuario_loja) res_Acessos_tipos_usuario_loja.elementAt(0);
      f.setActu_tius_tipo((r.getActu_tius_tipo() != null) ? r.getActu_tius_tipo() + "":"");
      f.setActu_inte_id("");
      f.setInte_nome("");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_tipos_usuario_loja", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
