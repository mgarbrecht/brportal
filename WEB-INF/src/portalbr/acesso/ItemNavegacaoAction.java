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
 * Creation Date 08/02/2006 13:22:33
 * Last Modify Date 29/10/2010 07:47:33
 */

public class ItemNavegacaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 08/02/2006
    // Data de Alteração :
    // Objetivo          : Insere um novo item de navegação
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      insert_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ItemNavegacaoActionForm f = (ItemNavegacaoActionForm) form;
    //-------------------------------------------------------------
    acesso.ItemMenuAPI item = new acesso.ItemMenuAPI(j.getConn());
    if (f.getItme_doin_id() != "") {
      acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn());
      documento.select(Integer.parseInt(f.getItme_doin_id()));
      item.setDocumentoInterface((acesso.DocumentoInterface) documento);
    }

    if (f.getItme_menu_id() != "") {
      acesso.MenuAPI menu = new acesso.MenuAPI(j.getConn());
      menu.select(Integer.parseInt(f.getItme_menu_id()));
      item.setMenu((acesso.Menu) menu);

    }
    item.setNome(f.getItme_nome());
    item.setTexto(f.getItme_texto());
    item.setComando(f.getItme_comando());
    item.insert();
    //-------------------------------------------------------------
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }


  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 08/02/2006
    // Data de Alteração :
    // Objetivo          : Altera um item de navegação
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ItemNavegacaoActionForm f = (ItemNavegacaoActionForm) form;
    portalbr.dbobj.table.Itens_menus table = new portalbr.dbobj.table.Itens_menus();
    table.setItme_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getItme_id()));
    table.setItme_nome(f.getItme_nome());
    table.setItme_texto(f.getItme_texto());
    table.setItme_comando(f.getItme_comando());
    table.setItme_menu_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getItme_menu_id()));
    table.setItme_doin_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getItme_doin_id()));
    //-----------------------------------------------------------------------------------------------------

    acesso.ItemMenuAPI item = new acesso.ItemMenuAPI(j.getConn());
    item.select(Integer.parseInt(f.getItme_id()));
    if (f.getItme_doin_id() != "") {
      acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn());
      documento.select(Integer.parseInt(f.getItme_doin_id()));
      item.setDocumentoInterface((acesso.DocumentoInterface) documento);
    }
    if (f.getItme_menu_id() != "") {
      acesso.MenuAPI menu = new acesso.MenuAPI(j.getConn());
      menu.select(Integer.parseInt(f.getItme_menu_id()));
      item.setMenu((acesso.Menu) menu);

    }
    item.setNome(f.getItme_nome());
    item.setTexto(f.getItme_texto());
    item.setComando(f.getItme_comando());
    item.update();
    //-----------------------------------------------------------------------------------------------------
    Vector res_Itens_menus = (Vector) session.getAttribute("res_Itens_menus");
    if (res_Itens_menus != null) {
      res_Itens_menus.setElementAt(table, 0);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    //                     TechnoCorp - Tecnologia e Software
    // Data de Criação   : 08/02/2006
    // Data de Alteração :
    // Objetivo          : Deleta um item de navegação
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ItemNavegacaoActionForm f = (ItemNavegacaoActionForm) form;
    //----------------------------------------------------------------------------------------------
    acesso.ItemMenuAPI item = new acesso.ItemMenuAPI(j.getConn());
    item.select(Integer.parseInt(f.getItme_id()));
    item.delete();
    //----------------------------------------------------------------------------------------------
    Vector res_Itens_menus = (Vector) session.getAttribute("res_Itens_menus");
    if (res_Itens_menus != null && res_Itens_menus.size() > 0) {
      res_Itens_menus.removeElementAt(0);
    }
    f.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ItemNavegacaoActionForm f = (ItemNavegacaoActionForm) form;
    portalbr.dbobj.table.Itens_menus table = new portalbr.dbobj.table.Itens_menus();
    String[][] select = null;
    Object[][] where = { {"Itme_id","=", com.egen.util.text.FormatNumber.toInteger(f.getItme_id())}, {"Itme_nome","like", f.getItme_nome()}, {"Itme_texto","like", f.getItme_texto()}, {"Itme_comando","like", f.getItme_comando()}, {"Itme_menu_id","=", com.egen.util.text.FormatNumber.toInteger(f.getItme_menu_id())}, {"Itme_doin_id","=", com.egen.util.text.FormatNumber.toInteger(f.getItme_doin_id())} };

    Vector res_Itens_menus = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Itens_menus",res_Itens_menus);
    if (res_Itens_menus != null && res_Itens_menus.size() > 0) {
      portalbr.dbobj.table.Itens_menus r = (portalbr.dbobj.table.Itens_menus) res_Itens_menus.elementAt(0);
      f.setItme_id((r.getItme_id() != null) ? r.getItme_id() + "":"");
      f.setItme_nome((r.getItme_nome() != null) ? r.getItme_nome() + "":"");
      f.setItme_texto((r.getItme_texto() != null) ? r.getItme_texto() + "":"");
      f.setItme_comando((r.getItme_comando() != null) ? r.getItme_comando() + "":"");
      f.setItme_menu_id((r.getItme_menu_id() != null) ? r.getItme_menu_id() + "":"");
      f.setItme_doin_id((r.getItme_doin_id() != null) ? r.getItme_doin_id() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("ItemNavegacaoActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


}
