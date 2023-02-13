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
 * Creation Date 02/09/2015 11:16:00
 * Last Modify Date 19/07/2022 10:09:23
 */

public class ArquivosTalao_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query queryUtil = new util.consultas.Query();
    ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
    ArquivosTalao_rActionForm f = _ge_grid_array[0];
    boolean registraAlteracao = false;
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.isFornecedorAtelier()) {
      registraAlteracao = true;
    }
    if (f != null) {
      Jw_arquivos_talao table = new Jw_arquivos_talao();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      String query = (String) session.getAttribute("where");
      Vector res_Jw_arquivos_talao = j.select(table, query, null);
      session.setAttribute("res_Jw_arquivos_talao",res_Jw_arquivos_talao);
      if (res_Jw_arquivos_talao != null && res_Jw_arquivos_talao.size() > 0) {
        ArquivosTalao_rActionForm[]_ge_grid_array_flex = new ArquivosTalao_rActionForm[res_Jw_arquivos_talao.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_arquivos_talao_lines", res_Jw_arquivos_talao.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ArquivosTalao_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_arquivos_talao.size() > _ge_pos) {
            Jw_arquivos_talao r = (Jw_arquivos_talao) res_Jw_arquivos_talao.elementAt(_ge_pos);
            f.setForn_codigo((r.getForn_codigo() != null) ? r.getForn_codigo() + "":"");
            f.setInterface_arq_compra_id((r.getInterface_arq_compra_id() != null) ? r.getInterface_arq_compra_id() + "":"");
            f.setOco_numero((r.getOco_numero() != null) ? r.getOco_numero() + "":"");
            f.setRem_nro((r.getRem_nro() != null) ? r.getRem_nro() + "":"");
            f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setArquivo_edi((r.getArquivo_edi() != null) ? r.getArquivo_edi() + "":"");
            f.setForn_razsoc((r.getForn_razsoc() != null) ? r.getForn_razsoc() + "":"");
            f.setData_compra(com.egen.util.text.FormatDate.format(r.getData_compra(), "dd/MM/yyyy"));
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
            if (registraAlteracao) {
              String existe = queryUtil.retorna("SELECT 's' FROM edi.interface_arq_compra_tal_log WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND rem_nro = "+f.getRem_nro() + " and oco_numero = "+f.getOco_numero() + " AND situacao = 'C'");
              if (existe.equalsIgnoreCase("s")) {
                queryUtil.execute("UPDATE edi.interface_arq_compra_tal_log SET data_transacao = SYSDATE, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND rem_nro = "+f.getRem_nro() + " AND oco_numero = "+f.getOco_numero() + " AND situacao = 'C'");
              } else {
                queryUtil.execute("INSERT INTO edi.interface_arq_compra_tal_log VALUES ("+f.getInterface_arq_compra_id() + ", "+f.getRem_nro() + ", "+f.getOco_numero() + ", 'C', sysdate, '"+sessao.getUsuario() + "')");
              }
            }
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_arquivos_talao_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("warn.norowsselected",""));
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
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_arquivos_talao");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_arquivos_talao_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      if (_ge_grid_array != null) {
        ArquivosTalao_rActionForm f = null;
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
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      if (_ge_grid_array != null) {
        ArquivosTalao_rActionForm f = null;
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
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    boolean registraAlteracao = false;
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.isFornecedorAtelier()) {
      registraAlteracao = true;
    }
    util.consultas.Query queryUtil = new util.consultas.Query();
    ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
    ArquivosTalao_rActionForm f = _ge_grid_array[0];
    java.util.List < String > listagemParametros = new java.util.ArrayList < String > ();
    boolean marcou = false;
    StringBuilder sbRemessas = new StringBuilder();
    StringBuilder sbOrdens = new StringBuilder();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        marcou = true;
        listagemParametros.add(f.getInterface_arq_compra_id() + "#" + f.getOco_numero() + "#" + f.getRem_nro());
        if (registraAlteracao) {
          String existe = queryUtil.retorna("SELECT 's' FROM edi.interface_arq_compra_tal_log WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND rem_nro = "+f.getRem_nro() + " and oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          if (existe.equalsIgnoreCase("s")) {
            queryUtil.execute("UPDATE edi.interface_arq_compra_tal_log SET data_transacao = SYSDATE, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND rem_nro = "+f.getRem_nro() + " AND oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          } else {
            queryUtil.execute("INSERT INTO edi.interface_arq_compra_tal_log VALUES ("+f.getInterface_arq_compra_id() + ", "+f.getRem_nro() + ", "+f.getOco_numero() + ", 'G', sysdate, '"+sessao.getUsuario() + "')");
          }
        }
        if (sbRemessas.length() > 0) {
          sbRemessas.append(",");
        }
        if (sbOrdens.length() > 0) {
          sbOrdens.append(",");
        }
        sbRemessas.append(f.getRem_nro());
        sbOrdens.append(f.getOco_numero());
      }
    }
    session.setAttribute("listagemParametros", listagemParametros);
    if (!marcou) {
      throw new Exception("Selecione um registro!");
    }
    String materiais = "";
    if (session.getAttribute("codigo_materiais") != null) {
      materiais = " AND itm.cod_peca IN ("+(String) session.getAttribute("codigo_materiais") + ") ";
    }
    String query = " AND it.rem_nro in ("+sbRemessas.toString() + ") and it.oco_numero in ("+sbOrdens.toString() + ") " + materiais;
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    String espacamento = (String) session.getAttribute("arquivos_talao_filtro_espacamento") + "";
    if (espacamento.equalsIgnoreCase("3")) {
      g.setRelatorio("Talao3mm.jasper");
    } else {
      g.setRelatorio("Talao.jasper");
    }
    g.setParametro("P_QUERY", query);
    g.setParametro("P_ORDER", (String) session.getAttribute("arquivos_talao_ordenacao"));
    g.gerar();
  }


  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];
      util.consultas.com.InterfaceArqCompra interfaceArqCompra = new util.consultas.com.InterfaceArqCompra();
      interfaceArqCompra.gerarTalao(form, request);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosTalao_rActionForm[]_ge_grid_array = (ArquivosTalao_rActionForm[])_ge_grid.get("bl_form_Jw_arquivos_talao_lines");
      ArquivosTalao_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/ArquivosTalaoForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
