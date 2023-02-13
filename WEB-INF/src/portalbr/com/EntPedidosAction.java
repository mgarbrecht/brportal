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
 * Creation Date 17/09/2010 10:56:28
 * Last Modify Date 21/08/2013 11:58:10
 */

public class EntPedidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosActionForm f = (EntPedidosActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
        org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
        ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/com/EntPedidosGrid");
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
          EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[]) detailActionForm.get("bl_form_Emula_itens_faturas_proformas_lines");
          EntPedidosActionForm f0 = _ge_grid_array[0];
          f0.setNumero_pedido1(((EntPedidosActionForm) form).getNumero_pedido());
          perform_select1_action(detailMapping, detailActionForm, request, response);
          request.setAttribute(detailMapping.getName(), detailActionForm);
        }
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EntPedidosActionForm f = (EntPedidosActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    session.removeAttribute("pedido_tem_erros");
    //----- Se o usuário logado for EX, seta o codigo do usuário na WHERE ------
    acesso.Sessao se = new acesso.Sessao(session);
    String cliente = "";
    if (se.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")) {
      f.setCodigo_cliente(se.getChave());
    }
    Emula_faturas_proformas table = new Emula_faturas_proformas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"numero_pedido","=", com.egen.util.text.FormatNumber.toInteger(f.getNumero_pedido())}, {"codigo_cliente","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_cliente())}, {"estabelecimento_cliente","=", com.egen.util.text.FormatNumber.toInteger(f.getEstabelecimento_cliente())}, {"data_pedido","=", com.egen.util.text.FormatDate.parseDate(f.getData_pedido(), "dd/MM/yyyy")}, {"nome_planilha","like", f.getNome_planilha()}, {"status","=", f.getStatus()} };
    Vector res_Emula_faturas_proformas = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Emula_faturas_proformas",res_Emula_faturas_proformas);
    if (res_Emula_faturas_proformas != null && res_Emula_faturas_proformas.size() > 0) {
      Emula_faturas_proformas r = (Emula_faturas_proformas) res_Emula_faturas_proformas.elementAt(0);
      f.setNumero_pedido((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
      f.setCodigo_cliente((r.getCodigo_cliente() != null) ? r.getCodigo_cliente() + "":"");
      f.setEstabelecimento_cliente((r.getEstabelecimento_cliente() != null) ? r.getEstabelecimento_cliente() + "":"");
      f.setData_pedido(com.egen.util.text.FormatDate.format(r.getData_pedido(), "dd/MM/yyyy"));
      f.setNome_planilha((r.getNome_planilha() != null) ? r.getNome_planilha() + "":"");
      f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
      //---------------------------------------
      String tem_erros = "";
      tem_erros = query.retorna("SELECT 1 from emula_itens_faturas_proformas i WHERE numero_pedido = "+f.getNumero_pedido() + " AND descricao_erro is NOt NULL AND ROWNUM = 1");
      if (!tem_erros.equals("")) {
        session.setAttribute("pedido_tem_erros","s");
      }
      //---------------------------------------
      session.setAttribute("status_pedido", f.getStatus());
      //--------------------------------------------------------------------------
      session.removeAttribute("entrada_pedidos_codigo_cliente");
      session.removeAttribute("entrada_pedidos_estabelecimento_cliente");
      session.removeAttribute("entrada_pedidos_data_pedido");
      session.removeAttribute("entrada_pedidos_nome_planilha");
      //---------------------------------------
      f.setPos("0");
      session.setAttribute("pos", "0");
    } else {
      throw new Exception("Nenhum pedido encontrado!");
    }
    //--------------------------------------------------------------
    session.setAttribute("numero_pedido", f.getNumero_pedido());
    session.removeAttribute("itens_adicionados");
    acesso.Sessao sessao = new acesso.Sessao(session);
    query.execute("DELETE wbrio.tmp_generic_table_brportal WHERE varchar_column1 = '"+sessao.getUsuario() + "'");
    //---------------------------------------
    String tem_item = query.retorna("SELECT 's' FROM emula_itens_faturas_proformas where numero_pedido = "+(String) session.getAttribute("numero_pedido") + " and rownum=1");
    if (!tem_item.equals("s")) {
      query.execute("insert INTO emula_itens_faturas_proformas VALUES ("+(String) session.getAttribute("numero_pedido") + ",1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)");
    }
    //--------------------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosActionForm f = (EntPedidosActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
        org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
        ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/com/EntPedidosGrid");
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
          EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[]) detailActionForm.get("bl_form_Emula_itens_faturas_proformas_lines");
          EntPedidosActionForm f0 = _ge_grid_array[0];
          f0.setNumero_pedido1(((EntPedidosActionForm) form).getNumero_pedido());
          perform_select1_action(detailMapping, detailActionForm, request, response);
          request.setAttribute(detailMapping.getName(), detailActionForm);
        }
      }
      //    actionForward = mapping.findForward("same");
      actionForward = new ActionForward("/com/EntPedidosForm.do?select_action=&numero_pedido="+f.getNumero_pedido(), true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query query = new util.consultas.Query();
    String numero_pedido = query.retorna(j, "SELECT nvl(max(numero_pedido)+1,1) FROM emula_faturas_proformas");
    EntPedidosActionForm f = (EntPedidosActionForm) form;
    Emula_faturas_proformas table = new Emula_faturas_proformas();
    table.setNumero_pedido(com.egen.util.text.FormatNumber.parseIntegerWrapper(numero_pedido));
    table.setCodigo_cliente(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cliente()));
    table.setEstabelecimento_cliente(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getEstabelecimento_cliente()));
    table.setData_pedido(com.egen.util.text.FormatDate.parseDate(f.getData_pedido(), "dd/MM/yyyy"));
    table.setNome_planilha(f.getNome_planilha());
    table.setStatus("O");
    session.setAttribute("status_pedido","O");
    //---------------------------------------
    f.setNumero_pedido(numero_pedido);
    //---------------------------------------
    j.insert(table);
    session.setAttribute("naovalidar","s");
    //---------------------------------------
    query.execute("insert INTO emula_itens_faturas_proformas VALUES ("+numero_pedido + ",1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)");
    //---------------------------------------
    Vector res_Emula_faturas_proformas = (Vector) session.getAttribute("res_Emula_faturas_proformas");
    if (res_Emula_faturas_proformas != null && table != null) {
      res_Emula_faturas_proformas.addElement(table);
      session.setAttribute("res_Emula_faturas_proformas", res_Emula_faturas_proformas);
    }
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosActionForm f = (EntPedidosActionForm) form;
      if (f.getStatus().equals("C")) {
        throw new Exception(util.file.Bundle.getKey("ComercialResources","operacao_nao_permitida"));
      }
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
        org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
        ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/com/EntPedidosGrid");
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
          EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[]) detailActionForm.get("bl_form_Emula_itens_faturas_proformas_lines");
          EntPedidosActionForm f0 = _ge_grid_array[0];
          f0.setNumero_pedido1(((EntPedidosActionForm) form).getNumero_pedido());
          perform_select1_action(detailMapping, detailActionForm, request, response);
          request.setAttribute(detailMapping.getName(), detailActionForm);
        }
      }
      actionForward = new ActionForward("/com/EntPedidosForm.do?select_action=&numero_pedido="+(String) session.getAttribute("numero_pedido"), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EntPedidosActionForm f = (EntPedidosActionForm) form;
    Emula_faturas_proformas table = new Emula_faturas_proformas();
    Vector sets = new Vector(10, 2);
    table.setNumero_pedido(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_pedido()));
    if (f.getNumero_pedido() != null) {
      sets.addElement("numero_pedido");
    }
    table.setCodigo_cliente(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cliente()));
    if (f.getCodigo_cliente() != null) {
      sets.addElement("codigo_cliente");
    }
    table.setEstabelecimento_cliente(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getEstabelecimento_cliente()));
    if (f.getEstabelecimento_cliente() != null) {
      sets.addElement("estabelecimento_cliente");
    }
    table.setData_pedido(com.egen.util.text.FormatDate.parseDate(f.getData_pedido(), "dd/MM/yyyy"));
    if (f.getData_pedido() != null) {
      sets.addElement("data_pedido");
    }
    table.setNome_planilha(f.getNome_planilha());
    if (f.getNome_planilha() != null) {
      sets.addElement("nome_planilha");
    }
    /*  table.setStatus(f.getStatus());
          if (f.getStatus() != null) {
            sets.addElement("status");
          }
        */
    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      int updated = j.update(table, set);
      String _pos_field_name = "pos";
      String _lines_name = "bl_form_Emula_faturas_proformas_lines";
      String action = null;
      int _ge_pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, f, request);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_Emula_faturas_proformas = (Vector) session.getAttribute("res_Emula_faturas_proformas");
        if (res_Emula_faturas_proformas != null) {
          res_Emula_faturas_proformas.setElementAt(table, _ge_pos);
          Emula_faturas_proformas r = (Emula_faturas_proformas) res_Emula_faturas_proformas.elementAt(_ge_pos);
          f.setNumero_pedido((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
          f.setCodigo_cliente((r.getCodigo_cliente() != null) ? r.getCodigo_cliente() + "":"");
          f.setEstabelecimento_cliente((r.getEstabelecimento_cliente() != null) ? r.getEstabelecimento_cliente() + "":"");
          f.setData_pedido(com.egen.util.text.FormatDate.format(r.getData_pedido(), "dd/MM/yyyy"));
          f.setNome_planilha((r.getNome_planilha() != null) ? r.getNome_planilha() + "":"");
          f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosActionForm f = (EntPedidosActionForm) form;
      if (!(f.getStatus() + "").equals("O")) {
        throw new Exception(util.file.Bundle.getKey("ComercialResources","operacao_nao_permitida"));
      }
      //---------------------------
      util.consultas.Query query = new util.consultas.Query();
      query.execute(j, "DELETE emula_grades_itens_proformas WHERE numero_pedido = "+f.getNumero_pedido());
      query.execute(j, "DELETE emula_itens_faturas_proformas WHERE numero_pedido = "+f.getNumero_pedido());
      query.execute(j, "DELETE  emula_faturas_proformas WHERE numero_pedido = "+f.getNumero_pedido());
      //-----------------------------------------------------
      //  util.mensagem.Aviso.mostra(session, "Aviso", util.file.Bundle.getKey("ComercialResources","pedido_excluido"), "numero_pedido");
      //-----------------------------------------------------
      actionForward = new ActionForward("/com/EntPedidosForm.do?resetfull_action=",true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      EntPedidosActionForm f = (EntPedidosActionForm) form;
      session.removeAttribute("res_Emula_faturas_proformas");
      session.removeAttribute("numero_pedido");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
      ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/com/EntPedidosGrid");
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
      //    actionForward = mapping.findForward("same");

      session.removeAttribute("entrada_pedidos_codigo_cliente");
      session.removeAttribute("entrada_pedidos_cli_rzao");
      session.removeAttribute("entrada_pedidos_data_pedido");
      session.removeAttribute("entrada_pedidos_nome_planilha");
      session.setAttribute("total_pares", "0");

      actionForward = new ActionForward("/com/EntPedidosGrid.do?resetfull1_action=",true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
        String _lines_name = "bl_form_Emula_faturas_proformas_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          org.apache.struts.config.ModuleConfig moduleConfig = mapping.getModuleConfig();
          ActionMapping detailMapping = (ActionMapping) moduleConfig.findActionConfig("/com/EntPedidosGrid");
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
            EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[]) detailActionForm.get("bl_form_Emula_itens_faturas_proformas_lines");
            EntPedidosActionForm f0 = _ge_grid_array[0];
            f0.setNumero_pedido1(((EntPedidosActionForm) form).getNumero_pedido());
            perform_select1_action(detailMapping, detailActionForm, request, response);
            request.setAttribute(detailMapping.getName(), detailActionForm);
          }
        }
        finally {
          if (j != null) {
            j.close();
          }
        }
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EntPedidosActionForm f = (EntPedidosActionForm) form;
    Vector res_Emula_faturas_proformas = (Vector) session.getAttribute("res_Emula_faturas_proformas");
    if (res_Emula_faturas_proformas != null && _ge_pos < res_Emula_faturas_proformas.size()) {
      Emula_faturas_proformas r = (Emula_faturas_proformas) res_Emula_faturas_proformas.elementAt(_ge_pos);
      f.setNumero_pedido((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
      f.setCodigo_cliente((r.getCodigo_cliente() != null) ? r.getCodigo_cliente() + "":"");
      f.setEstabelecimento_cliente((r.getEstabelecimento_cliente() != null) ? r.getEstabelecimento_cliente() + "":"");
      f.setData_pedido(com.egen.util.text.FormatDate.format(r.getData_pedido(), "dd/MM/yyyy"));
      f.setNome_planilha((r.getNome_planilha() != null) ? r.getNome_planilha() + "":"");
      f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
      f.setPos("" + _ge_pos);
      //---------------------------------------
      session.setAttribute("status_pedido", f.getStatus());
      //--------------------------------------------------------------
      session.setAttribute("numero_pedido", f.getNumero_pedido());
      session.removeAttribute("itens_adicionados");
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Query query = new util.consultas.Query();
      query.execute("DELETE wbrio.tmp_generic_table_brportal WHERE varchar_column1 = '"+sessao.getUsuario() + "' and varchar_column2 = '"+f.getNumero_pedido() + "'");
      //---------------------------
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute("pos", "" + _ge_pos);
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_finalizar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    String numero_pedido = "";
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      numero_pedido = (String) session.getAttribute("numero_pedido");
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT 's' ");
      sb.append("   FROM (SELECT SUM(NVL(g.quantidade_pares, 0)) pares ");
      sb.append("           FROM emula_itens_faturas_proformas i ");
      sb.append("               ,emula_grades_itens_proformas g ");
      sb.append("               ,emula_faturas_proformas f ");
      sb.append("          WHERE i.numero_pedido = g.numero_pedido(+) ");
      sb.append("            AND i.numero_item = g.numero_item(+) ");
      sb.append("            AND f.numero_pedido = i.numero_pedido ");
      sb.append("            AND i.numero_pedido = "+ numero_pedido);
      sb.append("          GROUP BY i.numero_pedido ");
      sb.append("                  ,i.numero_item) ");
      sb.append("  WHERE pares = 0 ");
      sb.append("    AND ROWNUM = 1 ");

      String sem_grade = "";
      util.consultas.Query query = new util.consultas.Query();
      sem_grade = query.retorna(sb.toString());
      session.removeAttribute("semgrade");
      if (sem_grade.equals("s")) {
        session.setAttribute("semgrade","s");
        throw new Exception("sem grade");
      }

      EntPedidosActionForm f = (EntPedidosActionForm) form;
      if (!(f.getStatus() + "").equals("O")) {
        throw new Exception(util.file.Bundle.getKey("ComercialResources","EntPedidosForm.operacao_nao_permitida"));
      }
      String tem_itens = "";
      tem_itens = query.retorna("SELECT 's' FROM emula_itens_faturas_proformas WHERE numero_pedido = "+numero_pedido + " and codigo_linha is not null AND ROWNUM = 1 ");
      if (!tem_itens.equals("s")) {
        throw new Exception(util.file.Bundle.getKey("ComercialResources","EntPedidosForm.pedido_sem_item"));
      }
      if (session.getAttribute("item_invalido") != null) {
        util.mensagem.Aviso.mostra(session, "Aviso", util.file.Bundle.getKey("ComercialResources","EntPedidosForm.informacoes_obrigatorias").replace("x",(String) session.getAttribute("item_invalido")));
        session.setAttribute("registro_erro", (String) session.getAttribute("posicao_item_invalido"));
        actionForward = mapping.findForward("same");
      } else {
        query.execute(j, "UPDATE emula_faturas_proformas SET status = 'C' WHERE numero_pedido = "+numero_pedido);
        query.execute(j, "DELETE emula_itens_faturas_proformas WHERE numero_pedido = "+numero_pedido + " AND codigo_linha is NULL AND codigo_referencia IS NULL AND codigo_cabedal is NULL AND codigo_cor IS NULL AND codigo_grade is NULL AND quantidade_pares is NULL AND preco_unitario IS NULL AND descricao_item is NULL AND descricao_erro IS NULL AND loja_cliente is NULL");
        util.mensagem.Aviso.mostra(session, "Aviso", util.file.Bundle.getKey("ComercialResources","EntPedidosForm.pedido_finalizado"), "numero_pedido");
        Prc_envia_email_emula_faturas r = new Prc_envia_email_emula_faturas();
        r.setP_numero_pedido((String) session.getAttribute("numero_pedido"));
        r = (Prc_envia_email_emula_faturas) j.execute(r);
        actionForward = new ActionForward("/com/EntPedidosForm.do?select_action=&numero_pedido="+numero_pedido, true);
      }
      //------------------------------------
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));

      if (session.getAttribute("semgrade") != null) {
        actionForward = new ActionForward("/com/EntPedidosForm.do?select_action=&numero_pedido="+numero_pedido, true);
      } else {
        actionForward = mapping.findForward("same");
      }
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  public ActionForward perform_sessao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntPedidosActionForm f = (EntPedidosActionForm) form;

      session.setAttribute("entrada_pedidos_codigo_cliente",f.getCodigo_cliente());
      session.setAttribute("entrada_pedidos_cli_rzao",f.getCli_rzao());
      session.setAttribute("entrada_pedidos_data_pedido",f.getData_pedido());
      session.setAttribute("entrada_pedidos_nome_planilha",f.getNome_planilha());

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query query = new util.consultas.Query();
    DynaActionForm _ge_grid = (DynaActionForm) form;
    EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
    EntPedidosActionForm f = _ge_grid_array[0];
    session.removeAttribute("item_invalido");
    session.removeAttribute("posicao_item_invalido");
    boolean achou_item = false;

    int quantidade_pares_corrugado = 0;
    int quantidade_pares = 0;
    int quantidade_pares_grade = 0;
    boolean erro = false;


    int total_pares = 0;
    if (f != null) {
      Emula_itens_faturas_proformas table = new Emula_itens_faturas_proformas();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"numero_pedido","=", (String) session.getAttribute("numero_pedido")} };
      Vector res_Emula_itens_faturas_proformas = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Emula_itens_faturas_proformas",res_Emula_itens_faturas_proformas);
      if (res_Emula_itens_faturas_proformas != null && res_Emula_itens_faturas_proformas.size() > 0) {
        //------
        session.setAttribute("quantidade_itens", res_Emula_itens_faturas_proformas.size() + "");
        //------
        //---------------------------------------------------------------------------
        if (res_Emula_itens_faturas_proformas.size() > 1) {
          session.setAttribute("qtd_itens", res_Emula_itens_faturas_proformas.size() + "");
        } else {
          session.setAttribute("qtd_itens", "1");
        }
        //---------------------------------------------------------------------------

        EntPedidosActionForm[]_ge_grid_array_flex = new EntPedidosActionForm[res_Emula_itens_faturas_proformas.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Emula_itens_faturas_proformas_lines", res_Emula_itens_faturas_proformas.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new EntPedidosActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Emula_itens_faturas_proformas.size() > _ge_pos) {
            Emula_itens_faturas_proformas r = (Emula_itens_faturas_proformas) res_Emula_itens_faturas_proformas.elementAt(_ge_pos);
            f.setNumero_pedido1((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
            f.setNumero_item((r.getNumero_item() != null) ? r.getNumero_item() + "":"");
            f.setCodigo_linha((r.getCodigo_linha() != null) ? r.getCodigo_linha() + "":"");
            f.setCodigo_referencia((r.getCodigo_referencia() != null) ? r.getCodigo_referencia() + "":"");
            f.setCodigo_corrugado((r.getCodigo_corrugado() != null) ? r.getCodigo_corrugado() + "":"");
            f.setCodigo_cabedal((r.getCodigo_cabedal() != null) ? r.getCodigo_cabedal() + "":"");
            f.setDescricao_item((r.getDescricao_item() != null) ? r.getDescricao_item() + "":"");
            //          f.setDescricao_erro((r.getDescricao_erro() != null) ? r.getDescricao_erro() + "":"");
            f.setCodigo_cor((r.getCodigo_cor() != null) ? r.getCodigo_cor() + "":"");
            f.setCodigo_grade((r.getCodigo_grade() != null) ? r.getCodigo_grade() + "":"");
            f.setQuantidade_pares((r.getQuantidade_pares() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_pares(), "0") + "":"");
            f.setPreco_unitario((r.getPreco_unitario() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_unitario(), "##,##0.00") : "");
            f.setLoja_cliente((r.getLoja_cliente() != null) ? r.getLoja_cliente() + "":"");
            total_pares += ((r.getQuantidade_pares() != null) ? r.getQuantidade_pares() : 0);
            f.setRegistro_banco("s");



            if (session.getAttribute("naovalidar") == null) {

              query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = null WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
              //----------------------- VALIDACOES -----------------------------------
              if (f.getNumero_pedido1().equals("") || f.getNumero_item().equals("") || f.getCodigo_linha().equals("") || f.getCodigo_corrugado().equals("") || f.getCodigo_referencia().equals("") || f.getCodigo_cabedal().equals("") || f.getCodigo_cor().equals("") || f.getCodigo_grade().equals("") || f.getQuantidade_pares().equals("")) {
                query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.informacoes_obrigatorias").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                erro = true;
              }
              if (!erro) {
                quantidade_pares = Integer.parseInt(f.getQuantidade_pares());
                if (quantidade_pares < 1) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.quantidade_pares").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
              }
              //---- Valida Linha --------------------------------------------
              if (!erro) {
                StringBuilder sbl = new StringBuilder();
                sbl.append(" SELECT lin_cdgo ");
                sbl.append("   FROM lin ");
                sbl.append("  WHERE (1=1 or situacao = 'A') ");
                sbl.append("    AND lin_cdgo ="+f.getCodigo_linha());
                String linha = query.retorna(j, sbl.toString());
                if (linha.equals("")) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.linha_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
              }
              //---- Valida Referência ---------------------------------------
              if (!erro) {
                StringBuilder sbr = new StringBuilder();
                sbr.append(" SELECT ref_cdgo ");
                sbr.append("   FROM ref ");
                sbr.append("  WHERE lin_cdgo = "+f.getCodigo_linha());
                sbr.append("    AND (1=1 or ref_status = 'A') ");
                sbr.append("    AND ref_cdgo = "+f.getCodigo_referencia());
                sbr.append("    AND ROWNUM = 1 ");
                String referencia = query.retorna(j, sbr.toString());
                if (referencia.equals("")) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.referencia_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
              }
              //---- Valida Corrugado ---------------------------------------
              if (!erro) {
                StringBuilder sbco = new StringBuilder();
                sbco.append(" SELECT qt_par_corrug ");
                sbco.append("   FROM peso_corrugados ");
                sbco.append("  WHERE lin_cdgo = "+f.getCodigo_linha());
                sbco.append("    AND ref_cdgo = "+f.getCodigo_referencia());
                sbco.append("    AND codigo_corrug= "+f.getCodigo_corrugado());
                sbco.append("    AND ROWNUM =1 ");
                String corrugado = query.retorna(j, sbco.toString());
                if (corrugado.equals("")) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.corrugado_invalido_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
                quantidade_pares_corrugado = Integer.parseInt(corrugado);
              }
              //---- Valida Cabedal ------------------------------------------
              if (!erro) {
                StringBuilder sbc = new StringBuilder();
                sbc.append(" SELECT rcab.cab_cdgo ");
                sbc.append("   FROM ref_cab rcab ");
                sbc.append("      , dom_item_estoque dies ");
                sbc.append("      , cabedal cabe ");
                sbc.append("  WHERE dies.lin_cdgo = rcab.lin_cdgo ");
                sbc.append("    AND dies.ref_cdgo = rcab.ref_cdgo ");
                sbc.append("    AND dies.cab_cdgo = rcab.cab_cdgo ");
                sbc.append("    AND cabe.cab_cdgo = rcab.cab_cdgo ");
                sbc.append("    AND (1=2 or rcab.rfb_status = 'A') ");
                sbc.append("    AND rcab.lin_cdgo = "+f.getCodigo_linha());
                sbc.append("    AND rcab.ref_cdgo = "+f.getCodigo_referencia());
                sbc.append("    AND rcab.cab_cdgo = "+f.getCodigo_cabedal());
                sbc.append("    AND ROWNUM = 1 ");
                String cabedal = query.retorna(j, sbc.toString());
                if (cabedal.equals("")) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.cabedal_invalido_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
              }
              //---- Valida Cor-----------------------------------------------
              if (!erro) {
                StringBuilder sbo = new StringBuilder();
                sbo.append(" SELECT rcor.cor_cdgo ");
                sbo.append("   FROM ref_cor rcor ");
                sbo.append("       ,cor cors ");
                sbo.append("  WHERE cors.cor_cdgo = rcor.cor_cdgo ");
                sbo.append("    AND (1=2 or rcor.rfc_status = 'A') ");
                sbo.append("    AND rcor.lin_cdgo = "+f.getCodigo_linha());
                sbo.append("    AND rcor.ref_cdgo = "+f.getCodigo_referencia());
                sbo.append("    AND rcor.cab_cdgo = "+f.getCodigo_cabedal());
                sbo.append("    AND rcor.cor_cdgo = "+f.getCodigo_cor());
                sbo.append("    AND ROWNUM = 1 ");
                String cor = query.retorna(j, sbo.toString());
                if (cor.equals("")) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.cor_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
              }
              //---- Valida Grade ---------------------------------------------
              if (!erro) {
                StringBuilder sbg = new StringBuilder();
                sbg.append(" SELECT rgde.gde_cdgo ");
                sbg.append("   FROM ref_gde rgde ");
                sbg.append("      , gre grde ");
                sbg.append("  WHERE grde.gde_cdgo = rgde.gde_cdgo ");
                sbg.append("    AND (1=1 or rgde.rfg_status = 'A') ");
                sbg.append("    AND rgde.lin_cdgo = "+f.getCodigo_linha());
                sbg.append("    AND rgde.ref_cdgo = "+f.getCodigo_referencia());
                sbg.append("    AND rgde.gde_cdgo = "+f.getCodigo_grade());
                sbg.append("    AND rownum = 1 ");
                String grade = query.retorna(j, sbg.toString());
                if (grade.equals("")) {
                  if (!f.getCodigo_grade().equals("99")) {
                    query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.grade_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                    erro = true;
                  }
                } else {
                  quantidade_pares_grade = Integer.parseInt(query.retorna(j, "SELECT gde_tota FROM gre where gde_cdgo = "+f.getCodigo_grade()));
                }
              }
              //----------------------------------------------------------------------
              if (!erro) {
                if (!(f.getCodigo_grade().equals("99"))) {
                  StringBuilder v1 = new StringBuilder();
                  v1.append(" SELECT 1 ");
                  v1.append("   FROM peso_corrugados p ");
                  v1.append("      , gre g");
                  v1.append("  where p.codigo_corrug = "+f.getCodigo_corrugado());
                  v1.append("    AND p.lin_cdgo = "+f.getCodigo_linha());
                  v1.append("    and p.ref_cdgo = "+f.getCodigo_referencia());
                  v1.append("    AND g.gde_cdgo = "+f.getCodigo_grade());
                  v1.append("    AND mod(qt_par_corrug, g.gde_tota) = 0 ");
                  String v_erro = query.retorna(j, v1.toString());
                  if (v_erro.equals("")) {
                    query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Quantidade da grade não é múltipla do corrugado!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                    erro = true;
                  }
                }
              }

              if (!erro) {
                if (!f.getCodigo_grade().equals("99")) {
                  if ((quantidade_pares % quantidade_pares_grade) != 0) {
                    query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Quantidade não é múltipla da grade!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                    erro = true;
                  }
                }
              }

              if (!erro) {
                if (f.getCodigo_grade().equals("99")) {
                  if ((quantidade_pares % quantidade_pares_corrugado) != 0) {
                    query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Quantidade não é múltipla do corrugado!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                    erro = true;
                  }
                }
              }



              if (!erro) {

                int qtd = 0;
                qtd = Integer.parseInt(query.retorna(j, "SELECT nvl(SUM(quantidade_pares),0) FROM emula_grades_itens_proformas WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item()));
                if (qtd == 0) {
                  query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Grade não preenchida!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
                  erro = true;
                }
              }

            }
            //----------------------------------------------------------------------


            //----------------
            if (!achou_item) {
              if (f.getQuantidade_pares().equals("")) {
                session.setAttribute("item_invalido", f.getNumero_item());
                achou_item = true;
              }
              if (f.getCodigo_grade().equals("")) {
                session.setAttribute("posicao_item_invalido", _ge_pos + "");
                achou_item = true;
              }
            }

            //-----------------

          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Emula_itens_faturas_proformas_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }


      if (erro) {
        session.setAttribute("pedido_tem_erros", "s");
        res_Emula_itens_faturas_proformas = j.select(table, select, where, groupby, having, order);
        session.setAttribute("res_Emula_itens_faturas_proformas",res_Emula_itens_faturas_proformas);
      }

      session.removeAttribute("naovalidar");

      session.setAttribute(mapping.getName(), form);
      session.setAttribute("total_pares", total_pares + "");
    }
  }
  public ActionForward perform_insert1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      try {
        insert1_action(j, mapping, form, request, response);
        tg_insert1_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/EntPedidosForm.do?select_action=&numero_pedido="+(String) session.getAttribute("numero_pedido"), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    boolean erro = false;
    EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
    EntPedidosActionForm f = _ge_grid_array[0];
    int quantidade_pares_corrugado = 0;
    int quantidade_pares = 0;
    int quantidade_pares_grade = 0;
    session.setAttribute("inseriu_item","s");
    session.removeAttribute("pedido_tem_erros");
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getRegistro_banco().equals("s")) {
        erro = false;
        query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = null WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
        //----------------------- VALIDACOES -----------------------------------
        if (f.getNumero_pedido1().equals("") || f.getNumero_item().equals("") || f.getCodigo_linha().equals("") || f.getCodigo_corrugado().equals("") || f.getCodigo_referencia().equals("") || f.getCodigo_cabedal().equals("") || f.getCodigo_cor().equals("") || f.getCodigo_grade().equals("") || f.getQuantidade_pares().equals("")) {
          query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.informacoes_obrigatorias").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
          erro = true;
        }
        if (!erro) {
          quantidade_pares = Integer.parseInt(f.getQuantidade_pares());
          if (quantidade_pares < 1) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.quantidade_pares").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
        }
        //---- Valida Linha --------------------------------------------
        if (!erro) {
          StringBuilder sbl = new StringBuilder();
          sbl.append(" SELECT lin_cdgo ");
          sbl.append("   FROM lin ");
          sbl.append("  WHERE (1=1 or situacao = 'A') ");
          sbl.append("    AND lin_cdgo ="+f.getCodigo_linha());
          String linha = query.retorna(j, sbl.toString());
          if (linha.equals("")) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.linha_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
        }
        //---- Valida Referência ---------------------------------------
        if (!erro) {
          StringBuilder sbr = new StringBuilder();
          sbr.append(" SELECT ref_cdgo ");
          sbr.append("   FROM ref ");
          sbr.append("  WHERE lin_cdgo = "+f.getCodigo_linha());
          sbr.append("    AND (1=1 or ref_status = 'A') ");
          sbr.append("    AND ref_cdgo = "+f.getCodigo_referencia());
          sbr.append("    AND ROWNUM = 1 ");
          String referencia = query.retorna(j, sbr.toString());
          if (referencia.equals("")) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.referencia_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
        }
        //---- Valida Corrugado ---------------------------------------
        if (!erro) {
          StringBuilder sbco = new StringBuilder();
          sbco.append(" SELECT qt_par_corrug ");
          sbco.append("   FROM peso_corrugados ");
          sbco.append("  WHERE lin_cdgo = "+f.getCodigo_linha());
          sbco.append("    AND ref_cdgo = "+f.getCodigo_referencia());
          sbco.append("    AND codigo_corrug= "+f.getCodigo_corrugado());
          sbco.append("    AND ROWNUM =1 ");
          String corrugado = query.retorna(j, sbco.toString());
          if (corrugado.equals("")) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.corrugado_invalido_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
          quantidade_pares_corrugado = Integer.parseInt(corrugado);
        }
        //---- Valida Cabedal ------------------------------------------
        if (!erro) {
          StringBuilder sbc = new StringBuilder();
          sbc.append(" SELECT rcab.cab_cdgo ");
          sbc.append("   FROM ref_cab rcab ");
          sbc.append("      , dom_item_estoque dies ");
          sbc.append("      , cabedal cabe ");
          sbc.append("  WHERE dies.lin_cdgo = rcab.lin_cdgo ");
          sbc.append("    AND dies.ref_cdgo = rcab.ref_cdgo ");
          sbc.append("    AND dies.cab_cdgo = rcab.cab_cdgo ");
          sbc.append("    AND cabe.cab_cdgo = rcab.cab_cdgo ");
          sbc.append("    AND (1=2 or rcab.rfb_status = 'A') ");
          sbc.append("    AND rcab.lin_cdgo = "+f.getCodigo_linha());
          sbc.append("    AND rcab.ref_cdgo = "+f.getCodigo_referencia());
          sbc.append("    AND rcab.cab_cdgo = "+f.getCodigo_cabedal());
          sbc.append("    AND ROWNUM = 1 ");
          String cabedal = query.retorna(j, sbc.toString());
          if (cabedal.equals("")) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.cabedal_invalido_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
        }
        //---- Valida Cor-----------------------------------------------
        if (!erro) {
          StringBuilder sbo = new StringBuilder();
          sbo.append(" SELECT rcor.cor_cdgo ");
          sbo.append("   FROM ref_cor rcor ");
          sbo.append("       ,cor cors ");
          sbo.append("  WHERE cors.cor_cdgo = rcor.cor_cdgo ");
          sbo.append("    AND (1=2 or rcor.rfc_status = 'A') ");
          sbo.append("    AND rcor.lin_cdgo = "+f.getCodigo_linha());
          sbo.append("    AND rcor.ref_cdgo = "+f.getCodigo_referencia());
          sbo.append("    AND rcor.cab_cdgo = "+f.getCodigo_cabedal());
          sbo.append("    AND rcor.cor_cdgo = "+f.getCodigo_cor());
          sbo.append("    AND ROWNUM = 1 ");
          String cor = query.retorna(j, sbo.toString());
          if (cor.equals("")) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.cor_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
        }
        //---- Valida Grade ---------------------------------------------
        if (!erro) {
          StringBuilder sbg = new StringBuilder();
          sbg.append(" SELECT rgde.gde_cdgo ");
          sbg.append("   FROM ref_gde rgde ");
          sbg.append("      , gre grde ");
          sbg.append("  WHERE grde.gde_cdgo = rgde.gde_cdgo ");
          sbg.append("    AND (1=1 or rgde.rfg_status = 'A') ");
          sbg.append("    AND rgde.lin_cdgo = "+f.getCodigo_linha());
          sbg.append("    AND rgde.ref_cdgo = "+f.getCodigo_referencia());
          sbg.append("    AND rgde.gde_cdgo = "+f.getCodigo_grade());
          sbg.append("    AND rownum = 1 ");
          String grade = query.retorna(j, sbg.toString());
          if (grade.equals("")) {
            if (!f.getCodigo_grade().equals("99")) {
              query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = '"+util.file.Bundle.getKey("ComercialResources","EntPedidosForm.grade_invalida_item").replace("x",f.getNumero_item()) + "' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
              erro = true;
            }
          } else {
            quantidade_pares_grade = Integer.parseInt(query.retorna(j, "SELECT gde_tota FROM gre where gde_cdgo = "+f.getCodigo_grade()));
          }
        }
        //----------------------------------------------------------------------
        if (!erro) {
          if (!(f.getCodigo_grade().equals("99"))) {
            StringBuilder v1 = new StringBuilder();
            v1.append(" SELECT 1 ");
            v1.append("   FROM peso_corrugados p ");
            v1.append("      , gre g");
            v1.append("  where p.codigo_corrug = "+f.getCodigo_corrugado());
            v1.append("    AND p.lin_cdgo = "+f.getCodigo_linha());
            v1.append("    and p.ref_cdgo = "+f.getCodigo_referencia());
            v1.append("    AND g.gde_cdgo = "+f.getCodigo_grade());
            v1.append("    AND mod(qt_par_corrug, g.gde_tota) = 0 ");
            String v_erro = query.retorna(j, v1.toString());
            if (v_erro.equals("")) {
              query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Quantidade da grade não é múltipla do corrugado!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
              erro = true;
            }
          }
        }

        if (!erro) {
          if (!f.getCodigo_grade().equals("99")) {
            if ((quantidade_pares % quantidade_pares_grade) != 0) {
              query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Quantidade não é múltipla da grade!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
              erro = true;
            }
          }
        }

        if (!erro) {
          if (f.getCodigo_grade().equals("99")) {
            if ((quantidade_pares % quantidade_pares_corrugado) != 0) {
              query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Quantidade não é múltipla do corrugado!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
              erro = true;
            }
          }
        }



        if (!erro) {
          int qtd = 0;
          qtd = Integer.parseInt(query.retorna(j, "SELECT nvl(SUM(quantidade_pares),0) FROM emula_grades_itens_proformas WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item()));
          if (qtd == 0) {
            query.execute(j, "UPDATE emula_itens_faturas_proformas SET descricao_erro = 'Grade não preenchida!' WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item="+f.getNumero_item());
            erro = true;
          }
        }

        //----------------------------------------------------------------------
        try {

          Emula_itens_faturas_proformas table = new Emula_itens_faturas_proformas();
          Vector sets = new Vector(10, 2);
          table.setNumero_pedido(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_pedido1()));
          if (f.getNumero_pedido1() != null) {
            sets.addElement("numero_pedido");
          }
          table.setNumero_item(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_item()));
          if (f.getNumero_item() != null) {
            sets.addElement("numero_item");
          }
          table.setCodigo_linha(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_linha()));
          if (f.getCodigo_linha() != null) {
            sets.addElement("codigo_linha");
          }
          table.setCodigo_referencia(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_referencia()));
          if (f.getCodigo_referencia() != null) {
            sets.addElement("codigo_referencia");
          }
          table.setCodigo_cabedal(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cabedal()));
          if (f.getCodigo_cabedal() != null) {
            sets.addElement("codigo_cabedal");
          }
          table.setDescricao_item(f.getDescricao_item());
          if (f.getDescricao_item() != null) {
            sets.addElement("descricao_item");
          }
          table.setCodigo_cor(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cor()));
          if (f.getCodigo_cor() != null) {
            sets.addElement("codigo_cor");
          }
          table.setCodigo_grade(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_grade()));
          if (f.getCodigo_grade() != null) {
            sets.addElement("codigo_grade");
          }
          table.setQuantidade_pares(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getQuantidade_pares()));
          if (f.getQuantidade_pares() != null) {
            sets.addElement("quantidade_pares");
          }
          table.setLoja_cliente(f.getLoja_cliente());
          if (f.getLoja_cliente() != null) {
            sets.addElement("loja_cliente");
          }
          table.setPreco_unitario(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_unitario()));
          if (f.getPreco_unitario() != null) {
            sets.addElement("preco_unitario");
          }
          table.setCodigo_corrugado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_corrugado()));
          if (f.getCodigo_corrugado() != null) {
            sets.addElement("codigo_corrugado");
          }
          if (sets != null && sets.size() > 0) {
            String[] set = new String[sets.size()];
            for (int i = 0; i < sets.size(); i++) {
              set[i] = (String) sets.elementAt(i);
            }
            int updated = j.update(table, set);
            //---------- Atualiza Grade -------------------------------
            if (!(f.getCodigo_grade().equals("99"))) {
              query.execute(j, "delete wbrio.tmp_generic_table_brportal WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+f.getNumero_pedido1() + "' AND varchar_column3 = '"+f.getNumero_item() + "'");
            }
            String existe = "";
            existe = query.retorna(j, "select 's' from wbrio.tmp_generic_table_brportal WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+f.getNumero_pedido1() + "' AND varchar_column3 = '"+f.getNumero_item() + "' AND ROWNUM = 1");

            if (existe.equals("s")) {
              query.execute(j, "DELETE emula_grades_itens_proformas WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item = "+f.getNumero_item());
              StringBuilder sb = new StringBuilder();
              sb.append(" INSERT INTO emula_grades_itens_proformas (  ");
              sb.append("      SELECT varchar_column2 ");
              sb.append("           , varchar_column3 ");
              sb.append("           , varchar_column4 ");
              sb.append("           , varchar_column5 ");
              sb.append("        FROM wbrio.tmp_generic_table_brportal ");
              sb.append("       WHERE varchar_column1 = '"+sessao.getUsuario() + "'");
              sb.append("         AND varchar_column2 = '"+f.getNumero_pedido1() + "'");
              sb.append("         AND varchar_column3 = '"+f.getNumero_item() + "')");
              query.execute(j, sb.toString());
            } else if (!(f.getCodigo_grade().equals("99"))) {
              query.execute(j, "DELETE emula_grades_itens_proformas WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item = "+f.getNumero_item());
              StringBuilder sb = new StringBuilder();
              sb.append(" INSERT INTO emula_grades_itens_proformas ( ");
              sb.append("          SELECT "+f.getNumero_pedido1());
              sb.append("      , "+f.getNumero_item());
              sb.append("      , q.qtd_nume ");
              sb.append("      , q.qtd_pars ");
              sb.append("          FROM qtd q ");
              sb.append("           WHERE q.gde_cdgo = "+f.getCodigo_grade() + ")");
              query.execute(j, sb.toString());
            }
            //---------------------------------------------------------
            if (updated == 0) {
              ActionErrors errors = new ActionErrors();
              errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("warn.norowsupdated",": " + updated));
              request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
            }
          }
        }
        catch (Exception e) { }
      }

      if (erro) {
        session.setAttribute("pedido_tem_erros", "s");
      }

    } // LOOP REGISTROS

  }


  private void tg_insert1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      session.removeAttribute("itens_adicionados");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      try {
        update1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
    EntPedidosActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        Emula_itens_faturas_proformas table = new Emula_itens_faturas_proformas();
        Vector sets = new Vector(10, 2);
        table.setNumero_pedido(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_pedido1()));
        if (f.getNumero_pedido1() != null) {
          sets.addElement("numero_pedido");
        }
        table.setNumero_item(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_item()));
        if (f.getNumero_item() != null) {
          sets.addElement("numero_item");
        }
        table.setCodigo_linha(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_linha()));
        if (f.getCodigo_linha() != null) {
          sets.addElement("codigo_linha");
        }
        table.setCodigo_referencia(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_referencia()));
        if (f.getCodigo_referencia() != null) {
          sets.addElement("codigo_referencia");
        }
        table.setCodigo_corrugado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_corrugado()));
        if (f.getCodigo_corrugado() != null) {
          sets.addElement("codigo_corrugado");
        }
        table.setCodigo_cabedal(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cabedal()));
        if (f.getCodigo_cabedal() != null) {
          sets.addElement("codigo_cabedal");
        }
        table.setDescricao_item(f.getDescricao_item());
        if (f.getDescricao_item() != null) {
          sets.addElement("descricao_item");
        }
        table.setCodigo_cor(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cor()));
        if (f.getCodigo_cor() != null) {
          sets.addElement("codigo_cor");
        }
        table.setCodigo_grade(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_grade()));
        if (f.getCodigo_grade() != null) {
          sets.addElement("codigo_grade");
        }
        table.setQuantidade_pares(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getQuantidade_pares()));
        if (f.getQuantidade_pares() != null) {
          sets.addElement("quantidade_pares");
        }
        table.setPreco_unitario(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_unitario()));
        if (f.getPreco_unitario() != null) {
          sets.addElement("preco_unitario");
        }
        table.setLoja_cliente(f.getLoja_cliente());
        if (f.getLoja_cliente() != null) {
          sets.addElement("loja_cliente");
        }
        table.setDescricao_erro(f.getDescricao_erro());
        if (f.getDescricao_erro() != null) {
          sets.addElement("descricao_erro");
        }
        if (sets != null && sets.size() > 0) {
          String[] set = new String[sets.size()];
          for (int i = 0; i < sets.size(); i++) {
            set[i] = (String) sets.elementAt(i);
          }
          int updated = j.update(table, set);
          if (updated == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("warn.norowsupdated",": " + updated));
            request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
          } else {
            Vector res_Emula_itens_faturas_proformas = (Vector) session.getAttribute("res_Emula_itens_faturas_proformas");
            if (res_Emula_itens_faturas_proformas != null) {
              res_Emula_itens_faturas_proformas.setElementAt(table, 0);
              Emula_itens_faturas_proformas r = (Emula_itens_faturas_proformas) res_Emula_itens_faturas_proformas.elementAt(0);
              f.setNumero_pedido1((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
              f.setNumero_item((r.getNumero_item() != null) ? r.getNumero_item() + "":"");
              f.setCodigo_linha((r.getCodigo_linha() != null) ? r.getCodigo_linha() + "":"");
              f.setCodigo_referencia((r.getCodigo_referencia() != null) ? r.getCodigo_referencia() + "":"");
              f.setCodigo_corrugado((r.getCodigo_corrugado() != null) ? r.getCodigo_corrugado() + "":"");
              f.setCodigo_cabedal((r.getCodigo_cabedal() != null) ? r.getCodigo_cabedal() + "":"");
              f.setDescricao_item((r.getDescricao_item() != null) ? r.getDescricao_item() + "":"");
              f.setCodigo_cor((r.getCodigo_cor() != null) ? r.getCodigo_cor() + "":"");
              f.setCodigo_grade((r.getCodigo_grade() != null) ? r.getCodigo_grade() + "":"");
              f.setQuantidade_pares((r.getQuantidade_pares() != null) ? r.getQuantidade_pares() + "":"");
              f.setPreco_unitario((r.getPreco_unitario() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_unitario(), "##,##0.00") : "");
              f.setLoja_cliente((r.getLoja_cliente() != null) ? r.getLoja_cliente() + "":"");
              f.setDescricao_erro((r.getDescricao_erro() != null) ? r.getDescricao_erro() + "":"");
            }
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }

  public ActionForward perform_delete1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      try {
        delete1_action(j, mapping, form, request, response);
      }
      finally {
      }
      //    actionForward = mapping.findForward("same");
      actionForward = new ActionForward("/com/EntPedidosForm.do?select_action=&numero_pedido="+(String) session.getAttribute("numero_pedido"), true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
    EntPedidosActionForm f = _ge_grid_array[0];
    int _ge_pos = 0;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        query.execute("DELETE emula_grades_itens_proformas WHERE numero_pedido = "+f.getNumero_pedido1() + " AND numero_item = "+f.getNumero_item());
        Emula_itens_faturas_proformas table = new Emula_itens_faturas_proformas();
        table.setNumero_pedido(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_pedido1()));
        table.setNumero_item(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNumero_item()));
        table.setCodigo_linha(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_linha()));
        table.setCodigo_referencia(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_referencia()));
        table.setCodigo_corrugado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_corrugado()));
        table.setCodigo_cabedal(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cabedal()));
        table.setDescricao_item(f.getDescricao_item());
        table.setCodigo_cor(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_cor()));
        table.setCodigo_grade(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_grade()));
        table.setQuantidade_pares(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getQuantidade_pares()));
        table.setPreco_unitario(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_unitario()));
        table.setLoja_cliente(f.getLoja_cliente());
        j.delete(table);
        Vector res_Emula_itens_faturas_proformas = (Vector) session.getAttribute("res_Emula_itens_faturas_proformas");
        if (res_Emula_itens_faturas_proformas != null && res_Emula_itens_faturas_proformas.size() > 0) {
          res_Emula_itens_faturas_proformas.removeElementAt(0);
          if (res_Emula_itens_faturas_proformas.size() > 0) {
            Emula_itens_faturas_proformas r = (Emula_itens_faturas_proformas) res_Emula_itens_faturas_proformas.elementAt(0);
            f.setNumero_pedido1((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
            f.setNumero_item((r.getNumero_item() != null) ? r.getNumero_item() + "":"");
            f.setCodigo_linha((r.getCodigo_linha() != null) ? r.getCodigo_linha() + "":"");
            f.setCodigo_referencia((r.getCodigo_referencia() != null) ? r.getCodigo_referencia() + "":"");
            f.setCodigo_corrugado((r.getCodigo_corrugado() != null) ? r.getCodigo_corrugado() + "":"");
            f.setCodigo_cabedal((r.getCodigo_cabedal() != null) ? r.getCodigo_cabedal() + "":"");
            f.setDescricao_item((r.getDescricao_item() != null) ? r.getDescricao_item() + "":"");
            f.setCodigo_cor((r.getCodigo_cor() != null) ? r.getCodigo_cor() + "":"");
            f.setCodigo_grade((r.getCodigo_grade() != null) ? r.getCodigo_grade() + "":"");
            f.setQuantidade_pares((r.getQuantidade_pares() != null) ? r.getQuantidade_pares() + "":"");
            f.setPreco_unitario((r.getPreco_unitario() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_unitario(), "##,##0.00") : "");
            f.setLoja_cliente((r.getLoja_cliente() != null) ? r.getLoja_cliente() + "":"");
          } else {
            f.reset(mapping, request);
          }
        } else {
          f.reset(mapping, request);
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }
  public ActionForward perform_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Emula_itens_faturas_proformas");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Emula_itens_faturas_proformas_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_adicionar_item_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      EntPedidosActionForm[]_ge_grid_array = (EntPedidosActionForm[])_ge_grid.get("bl_form_Emula_itens_faturas_proformas_lines");
      EntPedidosActionForm f = _ge_grid_array[0];
      for (int x = 0; x < 10; x++) {
        int max_numero_item = Integer.parseInt(query.retorna(j, "SELECT nvl(max(numero_item),0)+1 FROM emula_itens_faturas_proformas WHERE numero_pedido = "+(String) session.getAttribute("numero_pedido")));
        query.execute(j, "insert INTO emula_itens_faturas_proformas VALUES ("+(String) session.getAttribute("numero_pedido") + ","+max_numero_item + ",NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,null,null,null)");
      }
      session.setAttribute("adicionou_item","s");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
