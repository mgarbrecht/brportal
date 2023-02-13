package portalbr.lov;

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
 * Creation Date 20/01/2016 07:46:47
 * Last Modify Date 20/01/2016 12:31:32
 */

public class LvMateriaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      LvMateriaisActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
    LvMateriaisActionForm f = _ge_grid_array[0];
    java.util.Vector vetor = new java.util.Vector();
    String cod = "";
    session.removeAttribute("materiais");
    session.removeAttribute("codigo_materiais");
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField() == true) {
        if (cod.equals("")) {
          vetor.addElement(f.getIes_codigo() + "-"+f.getIes_descricao());
          cod = f.getIes_codigo();
        } else {
          vetor.addElement(f.getIes_codigo() + "-"+f.getIes_descricao());
          cod += ","+f.getIes_codigo();
        }
      }
    }
    session.setAttribute("materiais", vetor);
    session.setAttribute("codigo_materiais", cod);
    session.setAttribute("selecionou", true);
  }











  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      LvMateriaisActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      if (_ge_grid_array != null) {
        LvMateriaisActionForm f = null;
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
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      LvMateriaisActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      if (_ge_grid_array != null) {
        LvMateriaisActionForm f = null;
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

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      LvMateriaisActionForm f = _ge_grid_array[0];
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
    LvMateriaisActionForm f = _ge_grid_array[0];
    if (f != null) {

      Jw_lv_materiais_talao table = new Jw_lv_materiais_talao();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT DISTINCT itm.cod_peca ies_codigo ");
      sb.append("               , itm.desc_peca ies_descricao ");
      sb.append("   FROM interface_arq_compra_tal     iat ");
      sb.append("      , interface_arq_compra_tal_mat itm ");
      sb.append("      , interface_arq_compra         iac ");
      sb.append("      , interface_arq_compra_oc      iaco ");
      sb.append("  WHERE iac.interface_arq_compra_id = iat.interface_arq_compra_id ");
      sb.append("    AND iaco.oco_numero = iat.oco_numero ");
      sb.append("    AND iat.interface_arq_compra_id = itm.interface_arq_compra_id ");
      sb.append("    AND iat.rem_nro = itm.rem_nro ");
      sb.append("    AND iat.tal_nro = itm.tal_nro ");
      sb.append("    AND NVL(iac.ativo, NULL) = 'S' ");
      sb.append("    AND NVL(iac.tipo, NULL) = 'T' ");
      sb.append((String) session.getAttribute("where_materiais"));

      Vector res_Jw_lv_materiais_talao = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_lv_materiais_talao",res_Jw_lv_materiais_talao);
      if (res_Jw_lv_materiais_talao != null && res_Jw_lv_materiais_talao.size() > 0) {
        LvMateriaisActionForm[]_ge_grid_array_flex = new LvMateriaisActionForm[res_Jw_lv_materiais_talao.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_lv_materiais_talao_lines", res_Jw_lv_materiais_talao.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvMateriaisActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_lv_materiais_talao.size() > _ge_pos) {
            Jw_lv_materiais_talao r = (Jw_lv_materiais_talao) res_Jw_lv_materiais_talao.elementAt(_ge_pos);
            f.setIes_codigo((r.getIes_codigo() != null) ? r.getIes_codigo() + "":"");
            f.setIes_descricao((r.getIes_descricao() != null) ? r.getIes_descricao() + "":"");
            f.setGridCheckField(true);
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_lv_materiais_talao_lines", _ge_grid_array_flex);
      } else {
        throw new Exception("Nenhum material selecionado para os critérios da pesquisa!");
        /*
            ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
            if (errors == null) {
              errors = new ActionErrors();
            }

            errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao", new ActionMessage("warn.norowsselected",""));
            request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
            */
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMateriaisActionForm[]_ge_grid_array = (LvMateriaisActionForm[])_ge_grid.get("bl_form_Jw_lv_materiais_talao_lines");
      LvMateriaisActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_lv_materiais_talao");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_lv_materiais_talao_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvMateriaisActionForm f = (LvMateriaisActionForm) form;
      StringBuilder sbParametros = new StringBuilder();
      if (f.getForn_codigo() != "") {
        sbParametros.append(" AND iac.for_codigo = " + f.getForn_codigo());
      }
      if (f.getFil_filial() != "") {
        sbParametros.append(" AND nvl(iat.fil_filial, null) = '"+f.getFil_filial() + "' ");
      }
      if (!f.getSituacao().equalsIgnoreCase("T")) {
        if (f.getSituacao().equalsIgnoreCase("NV")) {
          sbParametros.append(" AND nvl(iat.situacao,'XXX') <> 'V' ");
        } else {
          sbParametros.append(" AND nvl(iat.situacao,null) = '"+f.getSituacao() + "' ");
        }
      }
      if (f.getOco_numero() != "") {
        sbParametros.append(" AND iat.oco_numero = " + f.getOco_numero());
      }
      if (f.getRem_nro() != "") {
        sbParametros.append(" AND iat.rem_nro = " + f.getRem_nro());
      }
      if (f.getData_compra_inicial() != "" && f.getData_compra_inicial() != "") {
        sbParametros.append(" AND iaco.data_compra between to_date('"+f.getData_compra_inicial() + "','dd/mm/yyyy') and to_date('"+f.getData_compra_final() + "','dd/mm/yyyy') ");
      }
      session.setAttribute("where_materiais", sbParametros.toString());
      actionForward = new ActionForward("/lov/LvMateriaisGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
