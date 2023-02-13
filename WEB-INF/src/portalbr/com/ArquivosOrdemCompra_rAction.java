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
 * Creation Date 19/08/2015 15:48:36
 * Last Modify Date 18/07/2022 16:24:37
 */

public class ArquivosOrdemCompra_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
    ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
    boolean registraAlteracao = false;
    StringBuilder sbErro = new StringBuilder();
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.isFornecedorAtelier()) {
      registraAlteracao = true;
    }
    if (f != null) {
      util.consultas.Query queryUtil = new util.consultas.Query();
      Jw_arquivos_ordem_compra table = new Jw_arquivos_ordem_compra();
      String where = (String) session.getAttribute("where");
      Vector res_Jw_arquivos_ordem_compra = j.select(table, where, null);
      session.setAttribute("res_Jw_arquivos_ordem_compra",res_Jw_arquivos_ordem_compra);
      if (res_Jw_arquivos_ordem_compra != null && res_Jw_arquivos_ordem_compra.size() > 0) {
        ArquivosOrdemCompra_rActionForm[]_ge_grid_array_flex = new ArquivosOrdemCompra_rActionForm[res_Jw_arquivos_ordem_compra.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_arquivos_ordem_compra_lines", res_Jw_arquivos_ordem_compra.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ArquivosOrdemCompra_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_arquivos_ordem_compra.size() > _ge_pos) {
            Jw_arquivos_ordem_compra r = (Jw_arquivos_ordem_compra) res_Jw_arquivos_ordem_compra.elementAt(_ge_pos);
            f.setForn_codigo((r.getForn_codigo() != null) ? r.getForn_codigo() + "":"");
            f.setInterface_arq_compra_id((r.getInterface_arq_compra_id() != null) ? r.getInterface_arq_compra_id() + "":"");
            f.setOco_numero((r.getOco_numero() != null) ? r.getOco_numero() + "":"");
            f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setData_emissao(com.egen.util.text.FormatDate.format(r.getData_emissao(), "dd/MM/yyyy"));
            f.setData_entrega(com.egen.util.text.FormatDate.format(r.getData_entrega(), "dd/MM/yyyy"));
            f.setData_entrega_fornecedor(com.egen.util.text.FormatDate.format(r.getData_entrega_fornecedor(), "dd/MM/yyyy"));
            f.setCond_pagto((r.getCond_pagto() != null) ? r.getCond_pagto() + "":"");
            f.setArquivo_edi((r.getArquivo_edi() != null) ? r.getArquivo_edi() + "":"");
            f.setAmostra((r.getAmostra() != null) ? r.getAmostra() + "":"");
            f.setForn_razsoc((r.getForn_razsoc() != null) ? r.getForn_razsoc() + "":"");
            f.setSituacao_ordem_compra((r.getSituacao_ordem_compra() != null) ? r.getSituacao_ordem_compra() + "":"");
            if (r.getSituacao() == null || r.getSituacao().equalsIgnoreCase("P") || r.getSituacao().equals("null")) {
              r.setSituacao("C");
              r.setDescricao_situacao("Consultado");
            } else {
              if (r.getSituacao().equalsIgnoreCase("C")) {
                r.setDescricao_situacao("Consultado");
              }
              if (r.getSituacao().equalsIgnoreCase("G")) {
                r.setDescricao_situacao("Gerado");
              }
              if (r.getSituacao().equalsIgnoreCase("V")) {
                r.setDescricao_situacao("Visualizado");
              }
            }
            sbErro = new StringBuilder();
            if (registraAlteracao) {
              String existe = queryUtil.retorna("SELECT 's' FROM edi.interface_arq_compra_oc_log WHERE interface_arq_compra_id = "+r.getInterface_arq_compra_id() + " AND oco_numero  = "+r.getOco_numero() + " AND situacao = 'C'");
              if (existe.equalsIgnoreCase("s")) {
                try {
                  queryUtil.execute("UPDATE edi.interface_arq_compra_oc_log SET data_transacao = sysdate, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+r.getInterface_arq_compra_id() + " AND oco_numero = "+r.getOco_numero() + " AND situacao = 'C'");
                } catch (Exception e) {
                  queryUtil.execute("DELETE edi.interface_arq_compra_oc_log WHERE interface_arq_compra_id = "+r.getInterface_arq_compra_id() + " AND oco_numero = "+r.getOco_numero() + " AND situacao = 'C'");
                  queryUtil.execute("INSERT INTO edi.interface_arq_compra_oc_log VALUES ("+r.getInterface_arq_compra_id() + ", "+r.getOco_numero() + ",'C', sysdate, '"+sessao.getUsuario() + "')");
                }
              } else {
                queryUtil.execute("INSERT INTO edi.interface_arq_compra_oc_log VALUES ("+r.getInterface_arq_compra_id() + ", "+r.getOco_numero() + ",'C', sysdate, '"+sessao.getUsuario() + "')");
              }
            }
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_arquivos_ordem_compra_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("warn.norowsselected",""));
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
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_arquivos_ordem_compra");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_arquivos_ordem_compra_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      if (_ge_grid_array != null) {
        ArquivosOrdemCompra_rActionForm f = null;
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
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      if (_ge_grid_array != null) {
        ArquivosOrdemCompra_rActionForm f = null;
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
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query queryUtil = new util.consultas.Query();
    ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
    ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
    boolean marcou = false;
    boolean registraAlteracao = false;
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.isFornecedorAtelier()) {
      registraAlteracao = true;
    }
    java.util.List < String > listagemParametros = new java.util.ArrayList < String > ();
    StringBuilder query = new StringBuilder();
    query.append(" i.oco_numero IN (");
    StringBuilder sbQuery = new StringBuilder();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        listagemParametros.add(f.getInterface_arq_compra_id() + "#" + f.getOco_numero());
        if (registraAlteracao) {
          String existe = queryUtil.retorna("SELECT 's' FROM edi.interface_arq_compra_oc_log WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND oco_numero  = "+f.getOco_numero() + " AND situacao = 'G'");
          if (existe.equalsIgnoreCase("s")) {
            queryUtil.execute("UPDATE edi.interface_arq_compra_oc_log SET data_transacao = sysdate, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          } else {
            queryUtil.execute("INSERT INTO edi.interface_arq_compra_oc_log values ("+f.getInterface_arq_compra_id() + ", "+f.getOco_numero() + ",'G', sysdate, '"+sessao.getUsuario() + "')");
          }
        }
        marcou = true;
        if (sbQuery.length() > 0) {
          sbQuery.append(",");
        }
        sbQuery.append(f.getOco_numero());
      }
    }
    session.setAttribute("listagemParametros", listagemParametros);
    query.append(sbQuery.toString());
    query.append(") ");
    if (!marcou) {
      throw new Exception("Selecione um registro!");
    }
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("OrdemCompra.jasper");
    g.setParametro("P_QUERY", query.toString());
    g.gerar();
  }



  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
      update1_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query queryUtil = new util.consultas.Query();
    java.util.List < String > listagemParametros = new java.util.ArrayList < String > ();
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
    ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
    boolean marcou = false;
    boolean registraAlteracao = false;
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.isFornecedorAtelier()) {
      registraAlteracao = true;
    }
    StringBuilder query = new StringBuilder();
    query.append(" i.oco_numero IN (");
    StringBuilder sbQuery = new StringBuilder();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        listagemParametros.add(f.getInterface_arq_compra_id() + "#" + f.getOco_numero());
        if (registraAlteracao) {
          String existe = queryUtil.retorna("SELECT 's' FROM edi.interface_arq_compra_oc_log WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND oco_numero  = "+f.getOco_numero() + " AND situacao = 'G'");
          if (existe.equalsIgnoreCase("s")) {
            queryUtil.execute("UPDATE edi.interface_arq_compra_oc_log SET data_transacao = sysdate, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          } else {
            queryUtil.execute("INSERT into edi.interface_arq_compra_oc_log values ("+f.getInterface_arq_compra_id() + ", "+f.getOco_numero() + ",'G', sysdate, '"+sessao.getUsuario() + "')");
          }
        }
        session.setAttribute("listagemParametros", listagemParametros);
        marcou = true;
        if (sbQuery.length() > 0) {
          sbQuery.append(",");
        }
        sbQuery.append(f.getOco_numero());
      }
    }
    query.append(sbQuery.toString());
    query.append(") ");
    if (!marcou) {
      throw new Exception("Selecione um registro!");
    }
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("OrdemCompraRemessa.jasper");
    g.setParametro("P_QUERY", query.toString());
    g.gerar();
  }

  public ActionForward perform_update2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
      util.consultas.com.InterfaceArqCompra interfaceArqCompra = new util.consultas.com.InterfaceArqCompra();
      interfaceArqCompra.gerarOC(form, request);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_update3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
      update3_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update3_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    util.consultas.Query queryUtil = new util.consultas.Query();
    java.util.List < String > listagemParametros = new java.util.ArrayList < String > ();
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
    ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
    boolean marcou = false;
    boolean registraAlteracao = false;
    acesso.Sessao sessao = new acesso.Sessao(session);
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getAmostra().equalsIgnoreCase("S") && sessao.isFornecedorAtelier() && f.getSituacao_ordem_compra().equals("0") && f.getAlterado().equalsIgnoreCase("S")) {
        if (f.getData_entrega_fornecedor().equals("")) {
          queryUtil.execute("update edi.interface_arq_compra_oc set data_entrega_fornecedor = null where oco_numero = " + f.getOco_numero());
        } else {
          queryUtil.execute("update edi.interface_arq_compra_oc set data_entrega_fornecedor = to_date('"+f.getData_entrega_fornecedor() + "','dd/mm/yyyy') where oco_numero = " + f.getOco_numero());
        }
      }
    }

  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosOrdemCompra_rActionForm[]_ge_grid_array = (ArquivosOrdemCompra_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
      ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/ArquivosOrdemCompraForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
