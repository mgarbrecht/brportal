package portalbr.exp;

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
 * Creation Date 02/04/2012 15:34:44
 * Last Modify Date 23/08/2012 14:42:54
 */

public class TabelaPrecos_rcAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      TabelaPrecos_rcActionForm f = (TabelaPrecos_rcActionForm) form;


      org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
      ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/exp/TabelaPrecos_rcGrid");
      DynaActionForm detailActionForm = null;
      if (detailMapping != null) {
        org.apache.struts.config.FormBeanConfig config = moduleConfig.findFormBeanConfig(detailMapping.getName());
        if (config.getDynamic()) {
          DynaActionFormClass dynaClass = DynaActionFormClass.createDynaActionFormClass(config);
          detailActionForm = (DynaActionForm) dynaClass.newInstance();
          detailActionForm.initialize(mapping);
        }
      }
      if (detailActionForm != null) {
        TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[]) detailActionForm.get("bl_form_Jw_ref_cor_1_lines");
        TabelaPrecos_rcActionForm f0 = _ge_grid_array[0];
        f0.setLin_cdgo1(((TabelaPrecos_rcActionForm) form).getLin_cdgo());
        f0.setRef_cdgo1(((TabelaPrecos_rcActionForm) form).getRef_cdgo());
        perform_select_action(detailMapping, detailActionForm, request, response);
        request.setAttribute(detailMapping.getName(), detailActionForm);
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TabelaPrecos_rcActionForm f = (TabelaPrecos_rcActionForm) form;
      session.removeAttribute("res_Jw_ref_cor");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
      ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/exp/TabelaPrecos_rcGrid");
      DynaActionForm detailActionForm = null;
      if (detailMapping != null) {
        org.apache.struts.config.FormBeanConfig config = moduleConfig.findFormBeanConfig(detailMapping.getName());
        if (config.getDynamic()) {
          DynaActionFormClass dynaClass = DynaActionFormClass.createDynaActionFormClass(config);
          detailActionForm = (DynaActionForm) dynaClass.newInstance();
          detailActionForm.initialize(mapping);
        }
      }
      if (detailActionForm != null) {
        detailActionForm.reset(detailMapping, request);
        request.setAttribute(detailMapping.getName(), detailActionForm);
        session.setAttribute(detailMapping.getName(), detailActionForm);
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_pos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos";
        String _lines_name = "bl_form_Jw_ref_cor_1_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
    TabelaPrecos_rcActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
      f = _ge_grid_array[_ge_grid_array_index];
      Vector res_Jw_ref_cor = (Vector) session.getAttribute("res_Jw_ref_cor");
      if (res_Jw_ref_cor != null && _ge_pos < res_Jw_ref_cor.size()) {
        Jw_ref_cor r = (Jw_ref_cor) res_Jw_ref_cor.elementAt(_ge_pos);
        f.setCodigo_marca1((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
        f.setDescricao_marca1((r.getDescricao_marca() != null) ? r.getDescricao_marca() + "":"");
        f.setLin_cdgo1((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
        f.setRef_cdgo1((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
        f.setModelo((r.getModelo() != null) ? r.getModelo() + "":"");
        f.setPos("" + _ge_pos);
      } else {
        f.reset(mapping, request);
      }
      f.setGridCheckField(false);
      _ge_grid_array[_ge_grid_array_index] = f;
      session.setAttribute("pos", "" + _ge_pos);
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
      TabelaPrecos_rcActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
    TabelaPrecos_rcActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_ref_cor table = new Jw_ref_cor();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"codigo_marca","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_marca1())}, {"descricao_marca","like", f.getDescricao_marca1()}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo1())}, {"ref_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getRef_cdgo1())}, {"modelo","like", f.getModelo()}, };
      Vector res_Jw_ref_cor = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_ref_cor",res_Jw_ref_cor);
      if (res_Jw_ref_cor != null && res_Jw_ref_cor.size() > 0) {
        TabelaPrecos_rcActionForm[]_ge_grid_array_flex = new TabelaPrecos_rcActionForm[res_Jw_ref_cor.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_ref_cor_1_lines", res_Jw_ref_cor.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new TabelaPrecos_rcActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_ref_cor.size() > _ge_pos) {
            Jw_ref_cor r = (Jw_ref_cor) res_Jw_ref_cor.elementAt(_ge_pos);
            f.setCodigo_marca1((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
            f.setDescricao_marca1((r.getDescricao_marca() != null) ? r.getDescricao_marca() + "":"");
            f.setLin_cdgo1((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
            f.setRef_cdgo1((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
            f.setModelo((r.getModelo() != null) ? r.getModelo() + "":"");
            f.setPos("" + _ge_pos);
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_ref_cor_1_lines", _ge_grid_array_flex);
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_selecionar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
      TabelaPrecos_rcActionForm f = _ge_grid_array[0];
      try {
        selecionar_action(j, mapping, form, request, response);
        tg_selecionar_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void selecionar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
    TabelaPrecos_rcActionForm f = _ge_grid_array[0];
    java.util.List < Object[][] > listaProdutos = null;
    if (session.getAttribute("listaProdutos") == null) {
      listaProdutos = new java.util.ArrayList < Object[][] > ();
    } else {
      listaProdutos = (java.util.List < Object[][] >) session.getAttribute("listaProdutos");
    }
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        Object[][] produto = {{f.getLin_cdgo1(), f.getRef_cdgo1(), f.getModelo()}};
        listaProdutos.add(produto);
      }
    }
    if (!listaProdutos.isEmpty()) {
      session.setAttribute("listaProdutos", listaProdutos);
    }
    request.setAttribute("refresh","ok");
  }


  private void tg_selecionar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
      TabelaPrecos_rcActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
      if (_ge_grid_array != null) {
        TabelaPrecos_rcActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(true);
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
      TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
      TabelaPrecos_rcActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      TabelaPrecos_rcActionForm[]_ge_grid_array = (TabelaPrecos_rcActionForm[])_ge_grid.get("bl_form_Jw_ref_cor_1_lines");
      if (_ge_grid_array != null) {
        TabelaPrecos_rcActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

}
