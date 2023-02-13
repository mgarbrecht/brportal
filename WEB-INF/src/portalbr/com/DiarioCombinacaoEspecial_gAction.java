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
 * Creation Date 09/06/2015 16:00:20
 * Last Modify Date 10/06/2015 15:09:36
 */

public class DiarioCombinacaoEspecial_gAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[])_ge_grid.get("bl_form_Jw_grade_solicitacao_especial_lines");
      DiarioCombinacaoEspecial_gActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[])_ge_grid.get("bl_form_Jw_grade_solicitacao_especial_lines");
    DiarioCombinacaoEspecial_gActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_grade_solicitacao_especial table = new Jw_grade_solicitacao_especial();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"pares","=", com.egen.util.text.FormatNumber.toInteger(f.getPares())}, {"numeracao","=", com.egen.util.text.FormatNumber.toInteger(f.getNumeracao())}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo())} };

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ((n.numeracao_inicial - 1) + ROWNUM) numeracao ");
      sb.append("        ,0 pares ");
      sb.append("        ,n.lin_cdgo ");
      sb.append("    FROM wbrio.numeracoes_grades_validas n ");
      sb.append("        ,wbrio.usuarios ");
      sb.append("   WHERE ROWNUM <= (n.numeracao_final - n.numeracao_inicial) + 1 ");
      sb.append("   AND lin_cdgo = " + f.getLin_cdgo());


      Vector res_Jw_grade_solicitacao_especial = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_grade_solicitacao_especial",res_Jw_grade_solicitacao_especial);
      if (res_Jw_grade_solicitacao_especial != null && res_Jw_grade_solicitacao_especial.size() > 0) {
        DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array_flex = new DiarioCombinacaoEspecial_gActionForm[res_Jw_grade_solicitacao_especial.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_grade_solicitacao_especial_lines", res_Jw_grade_solicitacao_especial.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new DiarioCombinacaoEspecial_gActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_grade_solicitacao_especial.size() > _ge_pos) {
            Jw_grade_solicitacao_especial r = (Jw_grade_solicitacao_especial) res_Jw_grade_solicitacao_especial.elementAt(_ge_pos);
            f.setPares((r.getPares() != null) ? r.getPares() + "":"");
            f.setNumeracao((r.getNumeracao() != null) ? r.getNumeracao() + "":"");
            f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_grade_solicitacao_especial_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[])_ge_grid.get("bl_form_Jw_grade_solicitacao_especial_lines");
      DiarioCombinacaoEspecial_gActionForm f = _ge_grid_array[0];
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[])_ge_grid.get("bl_form_Jw_grade_solicitacao_especial_lines");
    DiarioCombinacaoEspecial_gActionForm f = _ge_grid_array[0];
    java.util.Vector v_numeracao = new java.util.Vector();

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      v_numeracao.add((f.getNumeracao() + "#"+f.getPares()));
    }
    Vector res_Jw_grade_solicitacao_especial = (Vector) session.getAttribute("res_Jw_grade_solicitacao_especial");
    session.setAttribute("v_numeracao", v_numeracao);
    session.setAttribute("fechar", "ok");
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[])_ge_grid.get("bl_form_Jw_grade_solicitacao_especial_lines");
      DiarioCombinacaoEspecial_gActionForm f = _ge_grid_array[0];
      try {
        resetfull_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void resetfull_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[])_ge_grid.get("bl_form_Jw_grade_solicitacao_especial_lines");
    DiarioCombinacaoEspecial_gActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_grade_solicitacao_especial table = new Jw_grade_solicitacao_especial();

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ((n.numeracao_inicial - 1) + ROWNUM) numeracao ");
      sb.append("        ,0 pares ");
      sb.append("        ,n.lin_cdgo ");
      sb.append("    FROM wbrio.numeracoes_grades_validas n ");
      sb.append("        ,wbrio.usuarios ");
      sb.append("   WHERE ROWNUM <= (n.numeracao_final - n.numeracao_inicial) + 1 ");
      sb.append("   AND lin_cdgo = 44 ");


      Vector res_Jw_grade_solicitacao_especial = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_grade_solicitacao_especial",res_Jw_grade_solicitacao_especial);
      if (res_Jw_grade_solicitacao_especial != null && res_Jw_grade_solicitacao_especial.size() > 0) {
        DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array_flex = new DiarioCombinacaoEspecial_gActionForm[res_Jw_grade_solicitacao_especial.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_grade_solicitacao_especial_lines", res_Jw_grade_solicitacao_especial.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new DiarioCombinacaoEspecial_gActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_grade_solicitacao_especial.size() > _ge_pos) {
            Jw_grade_solicitacao_especial r = (Jw_grade_solicitacao_especial) res_Jw_grade_solicitacao_especial.elementAt(_ge_pos);
            f.setPares((r.getPares() != null) ? r.getPares() + "":"");
            f.setNumeracao((r.getNumeracao() != null) ? r.getNumeracao() + "":"");
            f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_grade_solicitacao_especial_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_gActionForm f = (DiarioCombinacaoEspecial_gActionForm) form;


      org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
      ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/com/DiarioCombinacaoEspecial_gGrid");
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
        DiarioCombinacaoEspecial_gActionForm[]_ge_grid_array = (DiarioCombinacaoEspecial_gActionForm[]) detailActionForm.get("bl_form_Jw_grade_solicitacao_especial_lines");
        DiarioCombinacaoEspecial_gActionForm f0 = _ge_grid_array[0];
        f0.setLin_cdgo(((DiarioCombinacaoEspecial_gActionForm) form).getLin_cdgo1());
        perform_select_action(detailMapping, detailActionForm, request, response);
        request.setAttribute(detailMapping.getName(), detailActionForm);
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
