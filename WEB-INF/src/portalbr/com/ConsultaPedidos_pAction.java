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
 * Creation Date 09/03/2006 10:50:00
 * Last Modify Date 07/10/2022 16:26:31
 */

public class ConsultaPedidos_pAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      ConsultaPedidos_pActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
    ConsultaPedidos_pActionForm f = _ge_grid_array[0];
    if (f != null) {
      Vector res_Jw_consulta_pedidos_ped = (java.util.Vector) session.getAttribute("res_Jw_consulta_pedidos_ped");
      if (res_Jw_consulta_pedidos_ped != null && res_Jw_consulta_pedidos_ped.size() > 0) {
        ConsultaPedidos_pActionForm[]_ge_grid_array_flex = new ConsultaPedidos_pActionForm[res_Jw_consulta_pedidos_ped.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_consulta_pedidos_ped_1_lines", res_Jw_consulta_pedidos_ped.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ConsultaPedidos_pActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_consulta_pedidos_ped.size() > _ge_pos) {
            Jw_consulta_pedidos_ped r = (Jw_consulta_pedidos_ped) res_Jw_consulta_pedidos_ped.elementAt(_ge_pos);
            f.setPedido_beira_rio((r.getPedido_beira_rio() != null) ? r.getPedido_beira_rio() + "":"");
            f.setQtde_pares(r.getQtde_pares() + "");
            f.setPedido_cliente((r.getPedido_cliente() != null) ? r.getPedido_cliente() + "":"");
            f.setRemessa((r.getRemessa() != null) ? r.getRemessa() + "":"");
            f.setRep((r.getRep() != null) ? r.getRep() + "":"");
            f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
            f.setPt((r.getPt() != null) ? r.getPt() + "":"");
            f.setDt_digitacao(com.egen.util.text.FormatDate.format(r.getDt_digitacao()));
            f.setDt_entrega1(com.egen.util.text.FormatDate.format(r.getDt_entrega()));
            f.setDt_embarque((r.getDt_embarque() != null) ? r.getDt_embarque() + "":"");
            f.setNome_linha((r.getNome_linha() != null) ? r.getNome_linha() + "":"");
            f.setMarca1((r.getMarca() != null) ? r.getMarca() + "":"");
            f.setFilial_pedido((r.getFilial_pedido() != null) ? r.getFilial_pedido() + "":"");
            f.setCliente2((r.getCliente() != null) ? r.getCliente() + "":"");
            f.setEmp_empresa((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
            f.setPed_tipo((r.getPed_tipo() != null) ? r.getPed_tipo() + "":"");
            f.setPeriodo_entrega((r.getPeriodo_entrega() != null) ? r.getPeriodo_entrega() + "":"");
            f.setPrevisao_faturamento((r.getPrevisao_faturamento() != null) ? r.getPrevisao_faturamento() + "":"");
            f.setValor_pedido((r.getValor_pedido() != null) ? r.getValor_pedido() + "":"");
            f.setDescricao_livro((r.getDescricao_livro() != null) ? r.getDescricao_livro() + "":"");
            f.setValor_bruto((r.getValor_bruto() != null) ? r.getValor_bruto() + "":"");
            f.setValor_nota((r.getValor_nota() != null) ? r.getValor_nota() + "":"");
            f.setRecolocado((r.getRecolocado() != null) ? r.getRecolocado() + "":"");
            f.setValor_indenizado((r.getValor_indenizado() != null) ? r.getValor_indenizado() + "":"");
            f.setCondicao_pagamento((r.getCondicao_pagamento() != null) ? r.getCondicao_pagamento() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_consulta_pedidos_ped_1_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("warn.norowsselected",""));
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
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      ConsultaPedidos_pActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      if (_ge_grid_array != null) {
        ConsultaPedidos_pActionForm f = null;
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
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      ConsultaPedidos_pActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      if (_ge_grid_array != null) {
        ConsultaPedidos_pActionForm f = null;
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

  public ActionForward perform_imprimir_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    //com.egen.util.jdbc.JdbcUtil j = null;
    try {
      //  j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      ConsultaPedidos_pActionForm f = _ge_grid_array[0];
      imprimir_action(null, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      //    if (j != null) {
      //      j.close();
      //    }
    }
    return actionForward;
  }
  private void imprimir_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
    ConsultaPedidos_pActionForm f = _ge_grid_array[0];
    StringBuilder sb = new StringBuilder();
    boolean marcou = false;

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (!marcou) {
          sb.append(f.getPedido_beira_rio());
        } else {
          sb.append(",").append(f.getPedido_beira_rio());
        }
        marcou = true;
        session.setAttribute(mapping.getName(), form);
      }
    }
    if (!marcou) {
      throw new Exception("Nenhum pedido foi selecionado!");
    }
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("sbr0522.rdf");
    System.out.println(sb.toString());
    g.setParametro("P_PEDIDOS", sb.toString());
    g.gerar();
  }

  public ActionForward perform_imprimir_interno_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      ConsultaPedidos_pActionForm f = _ge_grid_array[0];
      imprimir_interno_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void imprimir_interno_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
    ConsultaPedidos_pActionForm f = _ge_grid_array[0];
    StringBuilder sb = new StringBuilder();
    boolean marcou = false;

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (!marcou) {
          sb.append(f.getPedido_beira_rio());
        } else {
          sb.append(",").append(f.getPedido_beira_rio());
        }
        marcou = true;
        session.setAttribute(mapping.getName(), form);
      }
    }
    if (!marcou) {
      throw new Exception("Nenhum pedido foi selecionado!");
    }
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("PedidoInterno.jasper");
    g.setParametro("P_PED_NMRO", sb.toString());

    boolean mostrarOriginal = true;
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) {
      mostrarOriginal = false;
    }
    g.setParametro("P_MOSTRAR_ORIGINAL", mostrarOriginal);

    g.gerar();
  }








  public ActionForward perform_back2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ConsultaPedidos_pActionForm[]_ge_grid_array = (ConsultaPedidos_pActionForm[])_ge_grid.get("bl_form_Jw_consulta_pedidos_ped_1_lines");
      ConsultaPedidos_pActionForm f = _ge_grid_array[0];
      String retorno = "/com/ConsultaPedidos_rForm.jsp";
      if (session.getAttribute("consulta_pedidos_back_action") != null) {
        retorno = (String) session.getAttribute("consulta_pedidos_back_action");
      }
      actionForward = new ActionForward(retorno, true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ConsultaPedidos_pGrid.do?select1_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPedidos_pActionForm f = (ConsultaPedidos_pActionForm) form;
    portalbr.dbobj.view.Jw_consulta_pedidos_ped table = new portalbr.dbobj.view.Jw_consulta_pedidos_ped();
    String codigo_regional = "";
    String codigo_representante = "";
    String codigo_analista = "";
    String tipo = "";
    String parametro_dias_retroativos = "";
    String dataEmissao = "";
    String dataEntrada = "";
    String dataFaturamento = "";
    String mix = "T";
    String grupoSessao = null;
    if (session.getAttribute("consulta_pedidos_grupo_economico") != null) {
      grupoSessao = (String) session.getAttribute("consulta_pedidos_grupo_economico");
      session.removeAttribute("consulta_pedidos_grupo_economico");
    }
    boolean usuarioConsultaGrupoEconomico = false;
    String grupoEconomicoLiberadoUsuario = null;
    util.consultas.Query qr = new util.consultas.Query();
    acesso.Sessao sessao = new acesso.Sessao(session);
    StringBuilder sbg = new StringBuilder();
    sbg.append(" SELECT /*+ all_rows */ substr(valor, instr(valor, '#')+1, length(valor)) ");
    sbg.append("   FROM wbrio.parametros ");
    sbg.append("  WHERE nome = 'usuario_consulta_grupo_economico' ");
    sbg.append("    AND substr(valor,0,instr(valor,'#')-1) = '"+sessao.getUsuario() + "' ");
    grupoEconomicoLiberadoUsuario = qr.retorna(j, sbg.toString());
    if (!grupoEconomicoLiberadoUsuario.equals("")) {
      usuarioConsultaGrupoEconomico = true;
    }

    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");

    //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
    String diasRetroativos = "";
    com.egen.util.jdbc.JdbcUtil connection = null;
    try {
      connection = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.table.Acessos_documentos_interfaces table_acessos = new portalbr.dbobj.table.Acessos_documentos_interfaces();
      String[][] select = null;
      Object[][] where = {{"Acdi_doin_id", "=", "75"}, {"Acdi_usua_id", "=", u.getId()}, {"Acdi_dias_consulta_retroativa", ">", 0 }};
      Vector res_Acessos_documentos_interfaces = connection.select(table_acessos, select, where, null, null, null);
      if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
        portalbr.dbobj.table.Acessos_documentos_interfaces r = (portalbr.dbobj.table.Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
        diasRetroativos = r.getAcdi_dias_consulta_retroativa() + "";
      } else {
        if (u.getDiasConsultaRetroativa() != null && u.getDiasConsultaRetroativa() > 0) {
          diasRetroativos = u.getDiasConsultaRetroativa() + "";
        }
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
        connection = null;
      }
    }


    if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
      parametro_dias_retroativos = " and trunc(p.ped_dadg) > trunc(sysdate-" + diasRetroativos + ") ";
    }

    //----------------------------------------------------------
    String data_entrega = "null";
    String data_emissao = "null";
    String situacao = "";
    String seqn = "null";
    String rep = "null";
    String reg = "null";
    String marca = "null";
    String param_ped_cliente = "";
    String param_cli = "";
    String from_oco = "";
    String where_oco = "";
    boolean grupo_economico = false;

    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = ent.getChave() + "";
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = ent.getChave() + "";
      }
      if (tipo.equals("ANALISTA REGIONAL")) {
        codigo_analista = ent.getChave() + "";
      }
    }

    if (tipo.equals("ANALISTA REGIONAL")) {
      com.egen.util.jdbc.JdbcUtil j2 = null;
      try {
        j2 = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.view.Jw_regional_analista table_analista = new portalbr.dbobj.view.Jw_regional_analista();
        String[][] select = null;
        Object[][] where = {{"codigo_gerente", "=", codigo_analista}};
        Vector res_Jw_regional_analista = j2.select(table_analista, select, where, null, null, null);
        if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
          portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
          codigo_regional = r.getCodigo_regional();
        }
      }
      finally {
        if (j2 != null) {
          j2.close();
          j2 = null;
        }
      }
    }

    if ((!(codigo_representante.equals("")))) {
      rep = "'" + codigo_representante + "'";
    }

    if ((!(codigo_regional.equals("")))) {
      reg = "'" + codigo_regional + "'";
    }

    if ((f.getPed_ped_cliente() != "") && f.getPed_ped_cliente() != null) {

      String oc = f.getPed_ped_cliente();
      oc = oc.replace(" ", "");
      String ocs = oc;
      ocs = ocs.replaceAll("\\s+", " ");
      ocs = ocs.replaceAll(" ", "\n");
      ocs = ocs.replaceAll("\\r\\n|\\r|\\n", "','");
      if ((ocs.charAt(ocs.length() - 1) + "").equalsIgnoreCase(",")) {
        ocs = ocs.substring(0, ocs.lastIndexOf(","));
      }


      param_ped_cliente = "  AND p.ped_ped_cliente in ('" + ocs + "')";
    }


    if ((f.getCod() != "" && f.getCod() != null) || grupoSessao != null) {
      if (grupoSessao != null) {
        f.setCod(grupoSessao + "g");
      }
      if ((f.getCod() + "").indexOf("g") == -1) {
        grupo_economico = false;
        param_cli = " AND p.cli_cdgo          =  " + f.getCod();
      } else {
        grupo_economico = true;
        param_cli = " AND g.cli_cdgo = p.cli_cdgo AND g.status = 'A' AND g.gre_grupo = " + f.getCod().replace("g", "");
      }
    }

    if (f.getSeqn() != "") {
      seqn = f.getSeqn();
    }

    if (f.getMarca() != "") {
      marca = f.getMarca();
    }

    //  if((f.getSituacao()+"").equals("A")){
    //     situacao = " (p.ped_stat = 'A' or (p.ped_stat = 'L' and i.ite_situ = '5')) and ";
    //  }

    if ((f.getSituacao() + "").equals("A")) {
      situacao = " (p.ped_stat in ('A')) and ";
    }

    if ((f.getSituacao() + "").equals("L")) {
      situacao = " (p.ped_stat in ('L')) and ";
    }

    if ((f.getSituacao() + "").equals("F")) {
      situacao = " p.ped_stat in ('F') and ";
    }

    //  if((f.getSituacao()+"").equals("B")){
    //     situacao = " p.ped_stat in ('P','B','T') and ";
    //  }

    if ((f.getSituacao() + "").equals("B")) {
      situacao = " p.ped_stat in ('B') and ";
    }

    if ((f.getSituacao() + "").equals("T")) {
      situacao = " p.ped_stat in ('T') and ";
    }

    if ((f.getSituacao() + "").equals("P")) {
      situacao = " p.ped_stat in ('P') and ";
    }

    if ((f.getSituacao() + "").equals("C")) {
      situacao = " p.ped_stat in ('C') and ";
    }

    if ((f.getDt_entrega() != "") && f.getDt_entrega() != null) {
      data_entrega = "'" + f.getDt_entrega() + "'";
    }

    if (session.getAttribute("consulta_pedidos_data_entrada") != null) {
      dataEntrada = (String) session.getAttribute("consulta_pedidos_data_entrada");
    }

    if (session.getAttribute("consulta_pedidos_data_emissao") != null) {
      dataEmissao = (String) session.getAttribute("consulta_pedidos_data_emissao");
    }

    if (session.getAttribute("consulta_pedidos_data_faturamento") != null) {
      dataFaturamento = (String) session.getAttribute("consulta_pedidos_data_faturamento");
    }

    if (session.getAttribute("consulta_pedidos_mix") != null) {
      mix = (String) session.getAttribute("consulta_pedidos_mix");
    }
    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */  ");
    query.append("        qry.pedido_beira_rio ");
    query.append("      , qry.qtde_pares ");
    query.append("      , qry.remessa ");
    if (session.getAttribute("consulta_pedidos_somente_indenizados") == "s") {
      query.append("   , qry.valor_indenizado ");
    }
    query.append("      , qry.pedido_cliente ");
    query.append("      , qry.rep ");
    query.append("      , qry.status ");
    query.append("      , qry.pt ");
    query.append("      , qry.dt_digitacao ");
    query.append("      , qry.dt_entrega ");
    query.append("      , DECODE(qry.ped_emba, NULL, (DECODE(qry.cli_cdgo, NULL, brio.fct_periodo_data_tonel(qry.pedido_beira_rio), TO_CHAR(qry.dt_entrega, 'dd/mm/yyyy'))), TO_CHAR(qry.ped_emba, 'dd/mm/yyyy')) dt_embarque ");
    query.append("      , qry.nome_linha ");
    query.append("      , qry.marca ");
    query.append("      , qry.filial_pedido ");
    query.append("      , qry.cliente ");
    query.append("      , qry.emp_empresa ");
    query.append("      , qry.ped_tipo ");
    query.append("      , qry.periodo_entrega ");
    query.append("      , DECODE(qry.ped_emba, NULL, brio.fct_periodo_data_tonel(qry.pedido_beira_rio), qry.ped_emba) previsao_faturamento ");
    query.append("      , qry.valor_pedido ");
    query.append("      , qry.recolocado ");
    query.append("      , qry.fora_normas ");
    query.append("      , qry.valor_bruto ");
    query.append("      , qry.valor_nota ");
    query.append("      , qry.condicao_pagamento ");
    query.append("      , qry.descricao_livro ");
    query.append(" FROM( ");

    query.append(" SELECT DISTINCT ");
    query.append("        p.ped_nmro pedido_beira_rio ");

    if (session.getAttribute("consulta_pedidos_somente_entrada") != null) {
      query.append("      ,(SELECT SUM(NVL(i.ite_qtde, 0)) ");
      query.append("          FROM ite i ");
      query.append("         WHERE i.ped_nmro = p.ped_nmro ");
      query.append("           AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn)) qtde_pares ");
    } else {
      query.append("      , pck_pedidos.get_pares(p.ped_nmro) qtde_pares ");
    }

    if (session.getAttribute("consulta_pedidos_somente_indenizados") == "s") {
      query.append("        ,pia.ped_boni_avaria valor_indenizado");
    }

    query.append("      , REPLACE(rowtocol('SELECT DISTINCT rem_nro  FROM rem_ped rp WHERE rp.ped_nmro = pck_pedidos.get_pedido_origem(' || p.ped_nmro || ') '), ',', '<br>') remessa ");
    query.append("      , p.ped_ped_cliente pedido_cliente ");
    query.append("      , p.rep_cdgo rep ");
    query.append("      , decode(p.ped_stat,'A', 'Liber.Prod', ");
    query.append("                          'B', 'Em Análise', ");
    query.append("                          'C', 'Cancelado', ");
    query.append("                          'F', 'Faturado', ");
    query.append("                          'L', 'Liberado', ");
    query.append("                          'P', 'Em Análise', ");
    query.append("                          'PF','Parc.Fat', ");
    query.append("                          'T', 'Bloq.Com') ||' - '||p.ped_stat||(SELECT ite_situ FROM ite ii WHERE ii.ped_nmro =  p.ped_nmro and rownum = 1 ) status ");
    query.append("      , decode(p.ped_stat,'F', 'Faturado', ");
    query.append("                          'C', 'Cancelado', 'ABERTO') pt ");
    query.append("      , p.ped_dadg dt_digitacao ");
    query.append("      , p.ped_det dt_entrega ");
    query.append("      , p.ped_emba ");
    query.append("      , tf.cli_cdgo ");
    query.append("      , REPLACE((SELECT rowtocol('SELECT lin_cdgo||'' - ''||lin_nome FROM lin where lin_cdgo IN (select i.lin_cdgo from ite i where i.ped_nmro = '||p.ped_nmro||')') FROM dual),',','<br>') nome_linha ");
    query.append("      , replace(rowtocol('SELECT DISTINCT r.codigo_marca || '' - '' || mp.descricao_marca marcas FROM ite i,REF r,marcas_produtos mp WHERE i.ped_nmro = '||p.ped_nmro||' AND mp.codigo_marca = r.codigo_marca  AND r.lin_cdgo = i.lin_cdgo   AND r.ref_cdgo = i.ref_cdgo'), ',', '<br>')  marca ");
    query.append("      , decode(p.ped_emba, NULL, (rowtocol('SELECT distinct fct_retorna_fil_producao(p.ped_nmro, DECODE(p.ped_especie_pedido, ''C'', 1, i.ite_seqn)) filial_pedido FROM ped p ,ite i WHERE p.ped_nmro = i.ped_nmro AND i.ped_nmro = ' || p.ped_nmro)), (rowtocol('SELECT distinct fil_filial FROM notas_fiscais_saida_ped_venda where ped_nmro = '||p.ped_nmro||''))) filial_pedido ");
    query.append("      , c.cli_cdgo || ' - '|| b.esc_seqn || ' - ' || c.cli_rzao cliente ");
    query.append("      , p.emp_empresa ");
    query.append("      , p.ped_tipo ");
    query.append("      , '' periodo_entrega ");
    query.append("      , (SELECT SUM(NVL(fct_valor_pedido(i.ped_nmro, i.ite_seqn), 0)) ");
    query.append("           FROM ite i ");
    query.append("          WHERE i.ped_nmro = p.ped_nmro ");

    if (session.getAttribute("consulta_pedidos_somente_entrada") != null) {
      query.append("         AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
    }

    query.append("            ) valor_pedido ");
    query.append("     , decode( nvl((select count(1) ");
    query.append("                       from ped_recolocacoes r  ");
    query.append("                      where r.ped_recolocado = p.ped_nmro  ");
    query.append("                        and p.ped_stat = 'C'),0), 0, 'Não', 'Sim' ) recolocado ");
    query.append("     , decode( nvl((select count(1) ");
    query.append("                      from situacoes_pedidos sp ");
    query.append("                      where sp.ped_nmro = p.ped_nmro ");
    query.append("                        AND NVL(sp.ts_codigo_situacao, NULL) = 36),0), 0, 'Não', 'Sim' ) fora_normas ");
    query.append("     , pck_pedidos.get_total_mercadorias(p.ped_nmro) valor_bruto ");
    query.append("     , (select n.nfs_vltot from nf_saida n where n.ped_nmro = p.ped_nmro and n.stat_codigo in (4,8) and rownum = 1) valor_nota ");
    query.append("     , p.cnd_cdgo||' - '||pck_cnd.get_nome(p.cnd_cdgo) condicao_pagamento ");
    query.append("     , p.liv_codigo ||' - '|| pck_livro.get_nome(liv_codigo) descricao_livro ");
    if (!mix.equalsIgnoreCase("T")) {
      query.append("   FROM (SELECT * FROM ped p WHERE wbrio.fct_mix_produto_pedido(p.ped_nmro) = '"+mix + "') p ");
    } else {
      query.append("   FROM ped p ");
    }


    query.append("      , lin l ");
    query.append("      , ite i ");
    query.append("      , esc b ");

    if (session.getAttribute("consulta_pedidos_fora_normas") != null) {
      query.append("   , situacoes_pedidos sp ");
    }

    query.append("      , brio.cli_respeita_tranca_fat_vw tf ");

    if (grupo_economico) {
      query.append("   , grupo_economico g ");
    }

    query.append("      , regionais_vendas reg ");
    query.append("      , rep r ");
    query.append("      , cli c ");
    if (session.getAttribute("consulta_pedidos_somente_indenizados") == "s") {
      query.append("      , ped_inf_adicionais pia ");
    }
    query.append(from_oco);
    query.append("  WHERE 1=1 ");

    if (session.getAttribute("consulta_pedidos_filtro_clientes") != null) {
      query.append((String) session.getAttribute("consulta_pedidos_filtro_clientes") + "");
    }


    if (session.getAttribute("consulta_pedidos_fora_normas") != null) {
      query.append("            AND p.ped_nmro = sp.ped_nmro ");
      query.append("            AND NVL(sp.ts_codigo_situacao, NULL) = 36 ");
    }

    if (session.getAttribute("multiplos_pedidos") != null) {
      query.append((String) session.getAttribute("multiplos_pedidos"));
    }

    if (session.getAttribute("consulta_pedidos_situacao_filtro") != null) {
      query.append((String) session.getAttribute("consulta_pedidos_situacao_filtro"));
    }

    if (session.getAttribute("consulta_pedidos_status_filtro") != null) {
      query.append((String) session.getAttribute("consulta_pedidos_status_filtro"));
    }

    query.append("    AND p.esc_seqn          =  nvl(").append(seqn).append(",p.esc_seqn) ");
    query.append(where_oco);
    query.append(param_cli);
    if (session.getAttribute("consulta_pedidos_somente_entrada_periodo") != null) {
      query.append((String) session.getAttribute("consulta_pedidos_somente_entrada_periodo"));
    }

    query.append("    AND b.cli_cdgo          =  p.cli_cdgo ");
    query.append("    AND c.cli_cdgo          =  p.cli_cdgo ");
    query.append("    AND r.rep_cdgo          =  p.rep_cdgo ");
    query.append("    AND reg.codigo_regional =  r.codigo_regional ");
    query.append("    AND b.esc_seqn          =  p.esc_seqn ");
    query.append("    AND p.ped_nmro          =  i.ped_nmro ");
    query.append("    AND i.lin_cdgo          =  l.lin_cdgo ");
    query.append("    AND i.codigo_marca      =  nvl(").append(marca).append(",i.codigo_marca) ");

    if (session.getAttribute("consulta_pedidos_somente_indenizados") == "s") {
      query.append("    AND p.ped_nmro = pia.ped_nmro ");
      query.append("    AND pia.ped_boni_avaria > 0 ");
    }
    if (session.getAttribute("consulta_pedidos_tipo_produto") != null) {
      query.append("    AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) = ").append((String) session.getAttribute("consulta_pedidos_tipo_produto"));
    }
    if (session.getAttribute("consulta_pedidos_lin_cdgo") != null) {
      query.append("    AND i.lin_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_lin_cdgo") + ",i.lin_cdgo) ");
    }
    if (session.getAttribute("consulta_pedidos_ref_cdgo") != null) {
      query.append("    AND i.ref_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_ref_cdgo") + ", i.ref_cdgo) ");
    }
    if (session.getAttribute("consulta_pedidos_cab_cdgo") != null) {
      query.append("    AND i.cab_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_cab_cdgo") + ", i.cab_cdgo) ");
    }
    if (session.getAttribute("consulta_pedidos_cor_cdgo") != null) {
      query.append("    AND i.cor_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_cor_cdgo") + ", i.cor_cdgo)");
    }

    query.append("    AND ");
    query.append(situacao);
    query.append(" p.cli_cdgo > 0 ");
    query.append(dataEmissao);
    query.append(dataEntrada);
    query.append(dataFaturamento);
    query.append("    AND p.ped_det >= decode(to_date(").append(data_entrega).append(",'dd/mm/yyyy'), null, p.ped_det, to_date(").append(data_entrega).append(",'dd/mm/yyyy')) ");
    query.append("    AND p.rep_cdgo = nvl(").append(rep).append(",p.rep_cdgo) ");
    if (session.getAttribute("consulta_pedidos_agrupa_cliente") != null) {
      query.append("    AND p.rep_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_representante") + ", r.rep_cdgo) ");
    } else {
      query.append("    AND r.rep_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_representante") + ", r.rep_cdgo) ");
    }
    if (session.getAttribute("consulta_pedidos_condicao_pagamento") != null) {
      query.append((String) session.getAttribute("consulta_pedidos_condicao_pagamento"));
    }
    if (session.getAttribute("consulta_pedidos_somente_entrada") != null) {
      query.append("    AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
    }
    if (session.getAttribute("consulta_pedidos_invoice") != null) {
      query.append("    AND nvl(p.ped_invoice,null) = '" + ((String) session.getAttribute("consulta_pedidos_invoice")) + "' ");
    }

    if ((!(reg.equals("null")))) {
      if (usuarioConsultaGrupoEconomico) {
        StringBuilder sbge = new StringBuilder();
        sbge.append(" AND ((reg.codigo_regional = NVL(").append(codigo_regional).append(", reg.codigo_regional)) ");
        sbge.append("     OR (EXISTS (SELECT 1 ");
        sbge.append("                   FROM grupo_economico ge ");
        sbge.append("                  WHERE ge.cli_cdgo = c.cli_cdgo ");
        sbge.append("                    AND nvl(ge.status,null) = 'A' ");
        sbge.append("                    AND ge.gre_grupo = ").append(grupoEconomicoLiberadoUsuario).append("))) ");
        query.append(sbge.toString());
      } else {
        query.append(" AND reg.codigo_regional = nvl(").append(codigo_regional).append(", reg.codigo_regional) ");
      }
    }

    query.append("    AND p.ped_tipo = NVL(" + f.getTipo_pedido() + ", p.ped_tipo) ");
    query.append("    AND p.cli_cdgo = tf.cli_cdgo (+) ");
    query.append(param_ped_cliente);
    query.append(parametro_dias_retroativos);
    query.append(" ) qry ");

    if (session.getAttribute("consulta_pedidos_ordenacao").equals("D")) {
      query.append("  ORDER BY qry.dt_digitacao DESC ");
    } else {
      query.append("  ORDER BY qry.dt_digitacao ASC ");
    }
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }


    Vector res_Jw_consulta_pedidos_ped = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_consulta_pedidos_ped", res_Jw_consulta_pedidos_ped);


    if (!(res_Jw_consulta_pedidos_ped != null && res_Jw_consulta_pedidos_ped.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped", new ActionMessage("warn.norowsselected", ""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidos_pActionForm f = (ConsultaPedidos_pActionForm) form;
      actionForward = new ActionForward("ConsultaPedidos_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
