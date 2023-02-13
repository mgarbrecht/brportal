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
 * Creation Date 18/08/2015 08:15:41
 * Last Modify Date 23/09/2020 09:49:30
 */

public class DownloadImagens_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
    DownloadImagens_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_cat_produtos table = new Jw_cat_produtos();
      String query = (String) session.getAttribute("where");
      Vector res_Jw_cat_produtos = j.select(table, query, null);
      session.setAttribute("res_Jw_cat_produtos",res_Jw_cat_produtos);
      if (res_Jw_cat_produtos != null && res_Jw_cat_produtos.size() > 0) {
        DownloadImagens_rActionForm[]_ge_grid_array_flex = new DownloadImagens_rActionForm[res_Jw_cat_produtos.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_cat_produtos_lines", res_Jw_cat_produtos.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new DownloadImagens_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_cat_produtos.size() > _ge_pos) {
            Jw_cat_produtos r = (Jw_cat_produtos) res_Jw_cat_produtos.elementAt(_ge_pos);
            f.setMarca((r.getMarca() != null) ? r.getMarca() + "":"");
            f.setLinha((r.getLinha() != null) ? r.getLinha() + "":"");
            f.setReferencia((r.getReferencia() != null) ? r.getReferencia() + "":"");
            f.setCabedal((r.getCabedal() != null) ? r.getCabedal() + "":"");
            f.setCor((r.getCor() != null) ? r.getCor() + "":"");
            f.setImagem((r.getImagem() != null) ? r.getImagem() + "":"");
            f.setVenda_exportacao((r.getVenda_exportacao() != null) ? r.getVenda_exportacao() + "":"");
            f.setCategoria_produto((r.getCategoria_produto() != null) ? r.getCategoria_produto() + "":"");
            f.setDescricao_categoria_produto((r.getDescricao_categoria_produto() != null) ? r.getDescricao_categoria_produto() + "":"");
            f.setTipo((r.getTipo() != null) ? r.getTipo() + "":"");
            f.setDescricao_tipo((r.getDescricao_tipo() != null) ? r.getDescricao_tipo() + "":"");
            f.setDescricao_produto((r.getDescricao_produto() != null) ? r.getDescricao_produto() + "":"");
            f.setSequencial_angulo((r.getSequencial_angulo() != null) ? r.getSequencial_angulo() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_cat_produtos_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
    DownloadImagens_rActionForm f = _ge_grid_array[0];
    java.util.List < String > listaImagens;
    if (session.getAttribute("listaImagens") != null) {
      listaImagens = (java.util.List < String >) session.getAttribute("listaImagens");
    } else {
      listaImagens = new java.util.ArrayList < String > ();
    }
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (!listaImagens.contains(f.getImagem())) {
          if (f.getImagem().equals("default.jpg") || f.getImagem().equals("default.gif")) {
          } else {
            listaImagens.add(f.getImagem());
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
    session.setAttribute("listaImagens", listaImagens);
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      if (_ge_grid_array != null) {
        DownloadImagens_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          if (f.getImagem().equals("default.gif")) {
            f.setGridCheckField(false);
          } else {
            f.setGridCheckField(true);
          }
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      if (_ge_grid_array != null) {
        DownloadImagens_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          if (f.getImagem().equals("default.gif")) {
            f.setGridCheckField(false);
          } else {
            f.setGridCheckField(false);
          }
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_cat_produtos");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_cat_produtos_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/DownloadImagensForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      update1_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
    DownloadImagens_rActionForm f = _ge_grid_array[0];
    java.util.List < String > listaImagens;
    if (session.getAttribute("listaImagens") != null) {
      listaImagens = (java.util.List < String >) session.getAttribute("listaImagens");
    } else {
      listaImagens = new java.util.ArrayList < String > ();
    }
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (listaImagens.contains(f.getImagem())) {
          listaImagens.remove(f.getImagem());
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
    session.setAttribute("listaImagens", listaImagens);
  }

  public ActionForward perform_download_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      util.consultas.com.DownloadImagens downloadImagens = new util.consultas.com.DownloadImagens();
      String arquivo = downloadImagens.processar(request);
      if (arquivo != null) {
        request.setAttribute("arquivo", arquivo);
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_remover_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      session.setAttribute("listaImagens", null);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_download_alta_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DownloadImagens_rActionForm[]_ge_grid_array = (DownloadImagens_rActionForm[])_ge_grid.get("bl_form_Jw_cat_produtos_lines");
      DownloadImagens_rActionForm f = _ge_grid_array[0];
      session.setAttribute("desconsiderar_lista_imagens_inexistentes","S");
      actionForward = new ActionForward("/com/DownloadImagens_rGrid.do?download_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
