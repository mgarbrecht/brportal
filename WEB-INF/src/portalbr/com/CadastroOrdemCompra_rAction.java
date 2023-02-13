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
 * Creation Date 02/04/2012 16:42:28
 * Last Modify Date 15/05/2018 12:07:33
 */

public class CadastroOrdemCompra_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_processar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CadastroOrdemCompra_rActionForm f = (CadastroOrdemCompra_rActionForm) form;
      if (f.getOc1() != "") {
        session.setAttribute("nova_oc_processar", f.getOc1());
      }
      actionForward = new ActionForward("/com/CadastroOrdemCompra_rGrid.do?processar_todos_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CadastroOrdemCompra_rActionForm f = (CadastroOrdemCompra_rActionForm) form;


      try {
        tg_resetfull1_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      CadastroOrdemCompra_rActionForm f = (CadastroOrdemCompra_rActionForm) form;
      f.setOc1("");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_pos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos";
        String _lines_name = "bl_form_Jw_pedidos_ordem_compra_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
    CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
      f = _ge_grid_array[_ge_grid_array_index];
      Vector res_Jw_pedidos_ordem_compra = (Vector) session.getAttribute("res_Jw_pedidos_ordem_compra");
      if (res_Jw_pedidos_ordem_compra != null && _ge_pos < res_Jw_pedidos_ordem_compra.size()) {
        Jw_pedidos_ordem_compra r = (Jw_pedidos_ordem_compra) res_Jw_pedidos_ordem_compra.elementAt(_ge_pos);
        f.setNumero((r.getNumero() != null) ? r.getNumero() + "":"");
        f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
        f.setSequencial((r.getSequencial() != null) ? r.getSequencial() + "":"");
        f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
        f.setGrupo((r.getGrupo() != null) ? r.getGrupo() + "":"");
        f.setNome_grupo((r.getNome_grupo() != null) ? r.getNome_grupo() + "":"");
        f.setOc((r.getOc() != null) ? r.getOc() + "":"");
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
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
    CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      String oc = "";
      if (session.getAttribute("oc") != null) {
        oc = (String) session.getAttribute("oc");
        session.removeAttribute("oc");
      }
      Jw_pedidos_ordem_compra table = new Jw_pedidos_ordem_compra();
      String where = (String) session.getAttribute("where");
      Vector res_Jw_pedidos_ordem_compra = j.select(table, where, null);
      session.setAttribute("res_Jw_pedidos_ordem_compra",res_Jw_pedidos_ordem_compra);
      if (res_Jw_pedidos_ordem_compra != null && res_Jw_pedidos_ordem_compra.size() > 0) {
        CadastroOrdemCompra_rActionForm[]_ge_grid_array_flex = new CadastroOrdemCompra_rActionForm[res_Jw_pedidos_ordem_compra.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_pedidos_ordem_compra_lines", res_Jw_pedidos_ordem_compra.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new CadastroOrdemCompra_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_pedidos_ordem_compra.size() > _ge_pos) {
            Jw_pedidos_ordem_compra r = (Jw_pedidos_ordem_compra) res_Jw_pedidos_ordem_compra.elementAt(_ge_pos);
            f.setNumero(r.getNumero() + "");
            f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
            f.setSequencial((r.getSequencial() != null) ? r.getSequencial() + "":"");
            f.setGrupo((r.getGrupo() != null) ? r.getGrupo() + "" : "");
            f.setOc((r.getOc() != null) ? r.getOc() + "":"");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setNome_grupo((r.getNome_grupo() != null) ? r.getNome_grupo() + "":"");
            f.setOc_nova(oc);
            f.setPos("" + _ge_pos);

          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_pedidos_ordem_compra_lines", _ge_grid_array_flex);
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      if (_ge_grid_array != null) {
        CadastroOrdemCompra_rActionForm f = null;
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
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      if (_ge_grid_array != null) {
        CadastroOrdemCompra_rActionForm f = null;
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

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query query = new util.consultas.Query();
    CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
    CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
    StringBuilder sbSituacao = new StringBuilder();
    sbSituacao.append(" BEGIN ");
    sbSituacao.append("    NULL; ");
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (f.getOc_nova() != "") {
          query.execute(j, "UPDATE ped SET ped_ped_cliente = '"+f.getOc_nova() + "' WHERE ped_nmro="+f.getNumero());
          sbSituacao.append(" IF brio.pck_situacoes_pedidos.grava_situacao(").append(f.getNumero()).append(", 630, 'OC alterada para ").append(f.getOc_nova()).append("') THEN ");
          sbSituacao.append("    NULL; ");
          sbSituacao.append("  END IF; ");
        } else {
          query.execute(j, "UPDATE ped SET ped_ped_cliente = null WHERE ped_nmro="+f.getNumero());
          sbSituacao.append(" IF brio.pck_situacoes_pedidos.grava_situacao(").append(f.getNumero()).append(", 630, 'OC alterada para null') THEN ");
          sbSituacao.append("    NULL; ");
          sbSituacao.append(" END IF; ");
        }
      }
    }
    sbSituacao.append(" END; ");
    java.sql.CallableStatement call = j.getConn().prepareCall(sbSituacao.toString());
    call.execute();
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/CadastroOrdemCompraForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_processar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
      processar_todos_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void processar_todos_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
    CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_pedidos_ordem_compra table = new Jw_pedidos_ordem_compra();
      String where = (String) session.getAttribute("where");
      Vector res_Jw_pedidos_ordem_compra = j.select(table, where, null);
      session.setAttribute("res_Jw_pedidos_ordem_compra",res_Jw_pedidos_ordem_compra);
      String novaOcProcessar = (String) session.getAttribute("nova_oc_processar");
      session.removeAttribute("nova_oc_processar");
      if (res_Jw_pedidos_ordem_compra != null && res_Jw_pedidos_ordem_compra.size() > 0) {
        CadastroOrdemCompra_rActionForm[]_ge_grid_array_flex = new CadastroOrdemCompra_rActionForm[res_Jw_pedidos_ordem_compra.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_pedidos_ordem_compra_lines", res_Jw_pedidos_ordem_compra.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new CadastroOrdemCompra_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_pedidos_ordem_compra.size() > _ge_pos) {
            Jw_pedidos_ordem_compra r = (Jw_pedidos_ordem_compra) res_Jw_pedidos_ordem_compra.elementAt(_ge_pos);
            f.setNumero(r.getNumero() + "");
            f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
            f.setSequencial((r.getSequencial() != null) ? r.getSequencial() + "":"");
            f.setGrupo((r.getGrupo() != null) ? r.getGrupo() + "" : "");
            f.setOc((r.getOc() != null) ? r.getOc() + "":"");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setNome_grupo((r.getNome_grupo() != null) ? r.getNome_grupo() + "":"");
            f.setOc_nova(novaOcProcessar);
            f.setPos("" + _ge_pos);
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_pedidos_ordem_compra_lines", _ge_grid_array_flex);
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      CadastroOrdemCompra_rActionForm f = _ge_grid_array[0];


      try {
        tg_resetfull_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      CadastroOrdemCompra_rActionForm[]_ge_grid_array = (CadastroOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_pedidos_ordem_compra_lines");
      if (_ge_grid_array != null) {
        CadastroOrdemCompra_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          //      f.setGridCheckField(true);
          f.setOc_nova("");
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

}
