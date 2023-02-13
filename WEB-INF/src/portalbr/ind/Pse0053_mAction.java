package portalbr.ind;

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
 * Creation Date 02/09/2009 15:15:13
 * Last Modify Date 04/11/2022 16:09:55
 */

public class Pse0053_mAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
      Pse0053_mActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
    Pse0053_mActionForm f = _ge_grid_array[0];
    if (request.getParameter("pro_numero") != null) {
      session.setAttribute("pse0053_processo", request.getParameter("pro_numero"));
    }
    util.consultas.Query queryUtil = new util.consultas.Query();
    if (f != null) {
      StringBuilder parametros = new StringBuilder();
      if (f.getRem_nro() != null && !f.getRem_nro().equals("")) {
        parametros.append(" AND rem_nro = " + f.getRem_nro());
      }
      if (f.getTal_nro() != null && !f.getTal_nro().equals("")) {
        parametros.append(" AND tal_nro = " + f.getTal_nro());
      }
      if (f.getLin_cdgo() != null && !f.getLin_cdgo().equals("")) {
        parametros.append(" AND lin_cdgo = " + f.getLin_cdgo());
      }
      if (f.getRef_cdgo() != null && !f.getRef_cdgo().equals("")) {
        parametros.append(" AND ref_cdgo = " + f.getRef_cdgo());
      }
      if (f.getTal_pares() != null && !f.getTal_pares().equals("")) {
        parametros.append(" AND tal_pares = " + f.getTal_pares());
      }
      if (f.getFil_filial() != null && !f.getFil_filial().equals("")) {
        parametros.append(" AND fil_filial = '" + f.getFil_filial() + "'");
      }
      StringBuilder query = new StringBuilder();
      query.append(" SELECT /*+ all_rows */ * ");
      query.append("   FROM atelier_pre_envio ");

      if (session.getAttribute("pse0053_hora_inicial") != null) {
        query.append("  WHERE data_pre_envio >= to_date('"+session.getAttribute("pse0053_dt_inicial") + " "+session.getAttribute("pse0053_hora_inicial") + "', 'dd/mm/yyyy hh24:mi') ");
      } else {
        query.append("  WHERE data_pre_envio >= to_date('"+session.getAttribute("pse0053_dt_inicial") + "', 'dd/mm/yyyy') ");
      }

      if (session.getAttribute("pse0053_hora_final") != null) {
        query.append("    AND data_pre_envio <  to_date('"+session.getAttribute("pse0053_dt_final") + " "+session.getAttribute("pse0053_hora_final") + "','dd/mm/yyyy hh24:mi') +1 ");
      } else {
        query.append("    AND data_pre_envio <  to_date('"+session.getAttribute("pse0053_dt_final") + "','dd/mm/yyyy') +1 ");
      }
      query.append("    AND for_codigo = "+session.getAttribute("pse0053_fornecedor"));
      query.append("    AND fen_seq = "+session.getAttribute("pse0053_fen_seq"));
      query.append("    AND pro_numero = "+session.getAttribute("pse0053_processo"));
      query.append(parametros);

      query.append("    AND (('"+session.getAttribute("pse0053_tipo") + "' = 'E' AND status = 'E' AND (status_consiste_atelier is NULL OR status_retorno is null)) OR ");
      query.append("         ('"+session.getAttribute("pse0053_tipo") + "' = 'R' AND status_consiste_atelier = 'C' AND status_retorno IS NULL)) ");

      if (false) {
        throw new Exception(query.toString());
      }
      Atelier_pre_envio table = new Atelier_pre_envio();
      Vector res_Atelier_pre_envio = j.select(table, query.toString(), null);
      session.setAttribute("pse0053_m_query", query.toString());

      session.setAttribute("res_Atelier_pre_envio",res_Atelier_pre_envio);
      if (res_Atelier_pre_envio != null && res_Atelier_pre_envio.size() > 0) {
        Pse0053_mActionForm[]_ge_grid_array_flex = new Pse0053_mActionForm[res_Atelier_pre_envio.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Atelier_pre_envio_lines", res_Atelier_pre_envio.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new Pse0053_mActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Atelier_pre_envio.size() > _ge_pos) {
            Atelier_pre_envio r = (Atelier_pre_envio) res_Atelier_pre_envio.elementAt(_ge_pos);
            String[] linRef = (queryUtil.retorna(j, "select cab_cdgo||'#'||cor_Cdgo abertura from talao t where t.tal_nro = "+r.getTal_nro() + "and t.rem_nro = " + r.getRem_nro())).split("#");
            f.setRem_nro((r.getRem_nro() != null) ? r.getRem_nro() + "":"");
            f.setTal_nro((r.getTal_nro() != null) ? r.getTal_nro() + "":"");
            f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setCab_cdgo(linRef[0]);
            f.setCor_cdgo(linRef[1]);
            f.setLin_cdgo((r.getLin_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getLin_cdgo(), "0") : "");
            f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
            f.setFor_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
            f.setFen_seq((r.getFen_seq() != null) ? r.getFen_seq() + "":"");
            f.setPro_numero((r.getPro_numero() != null) ? r.getPro_numero() + "":"");
            f.setTal_pares((r.getTal_pares() != null) ? r.getTal_pares() + "":"");
            f.setData_pre_envio(com.egen.util.text.FormatDate.format(r.getData_pre_envio(), "dd/MM/yyyy HH:mm"));
            //        f.setPos("" + _ge_pos);
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Atelier_pre_envio_lines", _ge_grid_array_flex);
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
      Pse0053_mActionForm f = _ge_grid_array[0];
      delete_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/Pse0053_mGrid.do?select1_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
    Pse0053_mActionForm f = _ge_grid_array[0];
    int _ge_pos = 0;
    util.consultas.Query query = new util.consultas.Query();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE atelier_pre_envio ");
        sb.append("    SET status_consiste_atelier = NULL ");
        sb.append("  WHERE rem_nro = " + f.getRem_nro());
        sb.append("    AND tal_nro = " + f.getTal_nro());
        sb.append("    AND for_codigo = " + f.getFor_codigo());
        sb.append("    AND pro_numero = " + f.getPro_numero());
        sb.append("    AND fil_filial = '"+f.getFil_filial() + "' ");
        sb.append("    AND fen_seq = " + f.getFen_seq());
        query.execute(sb.toString());
      }
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      j.setMaxRows(1);
      DynaActionForm _ge_grid = (DynaActionForm) form;
      Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
      Pse0053_mActionForm f = _ge_grid_array[0];
      resetfull_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
    Pse0053_mActionForm f = _ge_grid_array[0];
    if (f != null) {
      Atelier_pre_envio table = new Atelier_pre_envio();
      j.setMaxRows(1);
      Vector res_Atelier_pre_envio = j.select(table, null, null, null, null, null);
      session.setAttribute("res_Atelier_pre_envio",res_Atelier_pre_envio);
      if (res_Atelier_pre_envio != null && res_Atelier_pre_envio.size() > 0) {
        Pse0053_mActionForm[]_ge_grid_array_flex = new Pse0053_mActionForm[res_Atelier_pre_envio.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Atelier_pre_envio_lines", res_Atelier_pre_envio.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new Pse0053_mActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Atelier_pre_envio.size() > _ge_pos) {

          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Atelier_pre_envio_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("warn.norowsselected",""));
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
      DynaActionForm _ge_grid = (DynaActionForm) form;
      Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
      Pse0053_mActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    Pse0053_mActionForm[]_ge_grid_array = (Pse0053_mActionForm[])_ge_grid.get("bl_form_Atelier_pre_envio_lines");
    Pse0053_mActionForm f = _ge_grid_array[0];
    if (f != null) {
      Atelier_pre_envio table = new Atelier_pre_envio();
      Vector res_Atelier_pre_envio = j.select(table, (String) session.getAttribute("pse0053_m_query"), null);
      session.setAttribute("res_Atelier_pre_envio",res_Atelier_pre_envio);
      if (res_Atelier_pre_envio != null && res_Atelier_pre_envio.size() > 0) {
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.reset(mapping, request);
          if (res_Atelier_pre_envio.size() > _ge_pos) {
            Atelier_pre_envio r = (Atelier_pre_envio) res_Atelier_pre_envio.elementAt(_ge_pos);
            f.setRem_nro((r.getRem_nro() != null) ? r.getRem_nro() + "":"");
            f.setTal_nro((r.getTal_nro() != null) ? r.getTal_nro() + "":"");
            f.setLin_cdgo((r.getLin_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getLin_cdgo(), "0") : "");
            f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
            f.setFor_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
            f.setPro_numero((r.getPro_numero() != null) ? r.getPro_numero() + "":"");
            f.setTal_pares((r.getTal_pares() != null) ? r.getTal_pares() + "":"");
            f.setData_pre_envio(com.egen.util.text.FormatDate.format(r.getData_pre_envio(), "dd/MM/yyyy HH:mm"));
          }
          _ge_grid_array[_ge_grid_array_index] = f;
        }
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_gerar_planilha_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      util.consultas.ind.Pse0053 pse0053 = new util.consultas.ind.Pse0053();
      String arquivo = pse0053.geraExcelRemessas(session);
      request.setAttribute("abre_automaticamente","N");
      request.setAttribute("arquivo", arquivo);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
