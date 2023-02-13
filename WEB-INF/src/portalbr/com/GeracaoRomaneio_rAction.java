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
 * Creation Date 23/01/2014 11:37:25
 * Last Modify Date 22/02/2016 10:03:41
 */

public class GeracaoRomaneio_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      GeracaoRomaneio_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
    GeracaoRomaneio_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_geracao_romaneio_filtro table = new Jw_geracao_romaneio_filtro();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = (Object[][]) session.getAttribute("where");
      Vector res_Jw_geracao_romaneio_filtro = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_geracao_romaneio_filtro",res_Jw_geracao_romaneio_filtro);
      if (res_Jw_geracao_romaneio_filtro != null && res_Jw_geracao_romaneio_filtro.size() > 0) {
        GeracaoRomaneio_rActionForm[]_ge_grid_array_flex = new GeracaoRomaneio_rActionForm[res_Jw_geracao_romaneio_filtro.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_geracao_romaneio_filtro_lines", res_Jw_geracao_romaneio_filtro.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new GeracaoRomaneio_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_geracao_romaneio_filtro.size() > _ge_pos) {
            Jw_geracao_romaneio_filtro r = (Jw_geracao_romaneio_filtro) res_Jw_geracao_romaneio_filtro.elementAt(_ge_pos);
            f.setEmp_empresa((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
            f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setNfs_nmro((r.getNfs_nmro() != null) ? r.getNfs_nmro() + "":"");
            f.setNfs_serie((r.getNfs_serie() != null) ? r.getNfs_serie() + "":"");
            f.setNfs_dtemis(com.egen.util.text.FormatDate.format(r.getNfs_dtemis()));
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
            f.setRep_rzao((r.getRep_rzao() != null) ? r.getRep_rzao() + "":"");
            f.setPossui_sku((r.getPossui_sku() != null) ? r.getPossui_sku() + "":"");
            f.setPreco_final_liquido((String) session.getAttribute("preco_final_liquido"));
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_geracao_romaneio_filtro_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      GeracaoRomaneio_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_geracao_romaneio_filtro");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_geracao_romaneio_filtro_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("possui_sku","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      GeracaoRomaneio_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      if (_ge_grid_array != null) {
        GeracaoRomaneio_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          if (f.getPossui_sku().equalsIgnoreCase("S")) {
            f.setGridCheckField(true);
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

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      GeracaoRomaneio_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      if (_ge_grid_array != null) {
        GeracaoRomaneio_rActionForm f = null;
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

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      GeracaoRomaneio_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/GeracaoRomaneioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_gerar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
      GeracaoRomaneio_rActionForm f = _ge_grid_array[0];
      gerar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void gerar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    String tipoGeracao = "N";
    GeracaoRomaneio_rActionForm[]_ge_grid_array = (GeracaoRomaneio_rActionForm[])_ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
    GeracaoRomaneio_rActionForm f = _ge_grid_array[0];
    util.consultas.com.GeracaoRomaneio geracao = new util.consultas.com.GeracaoRomaneio();
    geracao.gerar(form, request, tipoGeracao);

  }

}
