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
 * Creation Date 21/09/2016 09:31:52
 * Last Modify Date 21/09/2016 13:13:24
 */

public class PrecoVendaPedido_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PrecoVendaPedido_rActionForm[]_ge_grid_array = (PrecoVendaPedido_rActionForm[])_ge_grid.get("bl_form_Jw_preco_venda_pedido_lines");
      PrecoVendaPedido_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
        if (session.getAttribute("atualizou") != null) {
          ActionErrors errors = new ActionErrors();
          errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("msg.successfuloperation",""));
          request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
          session.removeAttribute("atualizou");
        }
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PrecoVendaPedido_rActionForm[]_ge_grid_array = (PrecoVendaPedido_rActionForm[])_ge_grid.get("bl_form_Jw_preco_venda_pedido_lines");
    PrecoVendaPedido_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_preco_venda_pedido table = new Jw_preco_venda_pedido();
      String[][] select = null;
      Object[][] where = (Object[][]) session.getAttribute("where");
      Vector res_Jw_preco_venda_pedido = j.select(table, select, where, null, null, null);
      session.setAttribute("res_Jw_preco_venda_pedido",res_Jw_preco_venda_pedido);
      if (res_Jw_preco_venda_pedido != null && res_Jw_preco_venda_pedido.size() > 0) {
        PrecoVendaPedido_rActionForm[]_ge_grid_array_flex = new PrecoVendaPedido_rActionForm[res_Jw_preco_venda_pedido.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_preco_venda_pedido_lines", res_Jw_preco_venda_pedido.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new PrecoVendaPedido_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_preco_venda_pedido.size() > _ge_pos) {
            Jw_preco_venda_pedido r = (Jw_preco_venda_pedido) res_Jw_preco_venda_pedido.elementAt(_ge_pos);
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setEsc_seqn(r.getEsc_seqn() + "");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setPed_daem(com.egen.util.text.FormatDate.format(r.getPed_daem(), "dd/MM/yyyy"));
            f.setIte_seqn(r.getIte_seqn() + "");
            f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
            f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
            f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
            f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
            f.setIte_preco_venda((r.getIte_preco_venda() != null) ? r.getIte_preco_venda() + "":"");
            f.setPed_ped_cliente((r.getPed_ped_cliente() != null) ? r.getPed_ped_cliente() + "":"");
            f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
            f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_preco_venda_pedido_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("warn.norowsselected",""));
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
      PrecoVendaPedido_rActionForm[]_ge_grid_array = (PrecoVendaPedido_rActionForm[])_ge_grid.get("bl_form_Jw_preco_venda_pedido_lines");
      PrecoVendaPedido_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_preco_venda_pedido");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_preco_venda_pedido_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PrecoVendaPedido_rActionForm[]_ge_grid_array = (PrecoVendaPedido_rActionForm[])_ge_grid.get("bl_form_Jw_preco_venda_pedido_lines");
      PrecoVendaPedido_rActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/PrecoVendaPedido_rGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    DynaActionForm _ge_grid = (DynaActionForm) form;
    PrecoVendaPedido_rActionForm[]_ge_grid_array = (PrecoVendaPedido_rActionForm[])_ge_grid.get("bl_form_Jw_preco_venda_pedido_lines");
    PrecoVendaPedido_rActionForm f = _ge_grid_array[0];

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (true) {
        String valor_item = f.getIte_preco_venda_novo().replace(",",".");
        if (valor_item != "") {
          Double valor = null;
          try {
            valor = Double.parseDouble(valor_item);
          } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new Exception("Preço inválido para o pedido/item: " + f.getPed_nmro() + "-"+f.getIte_seqn() + "("+f.getIte_preco_venda_novo() + ")");
          }
          if (valor < 0) {
            throw new Exception("O preço não pode ser menor que zero para o pedido/item: " + f.getPed_nmro() + "-"+f.getIte_seqn() + "("+f.getIte_preco_venda_novo() + ")");
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (true) {
        Double valorNovo = null;
        Double valorAntigo = null;

        String valor_item_novo = f.getIte_preco_venda_novo().replace(",",".");
        String valor_item_antigo = f.getIte_preco_venda().replace(",",".");

        if (valor_item_novo.equals("")) {
        } else {
          valorNovo = Double.parseDouble(valor_item_novo);
        }
        if (valor_item_antigo.equals("")) {
        } else {
          valorAntigo = Double.parseDouble(valor_item_antigo);
        }


        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE ite ");
        sb.append("    SET ite_preco_venda = " + valor_item_novo);
        sb.append("  WHERE ped_nmro = " + f.getPed_nmro());
        sb.append("    AND ite_seqn = " + f.getIte_seqn());

        StringBuilder sbi = new StringBuilder();
        sbi.append(" INSERT INTO situacoes_pedidos ");
        sbi.append("    ( ped_nmro ");
        sbi.append("    , ts_codigo_situacao ");
        sbi.append("    , dt_cad_situacao ");
        sbi.append("    , usuario_situacao ");
        sbi.append("    , observ_situacao ");
        sbi.append("    , ite_seqn) ");
        sbi.append(" VALUES ");
        sbi.append("    ( " + f.getPed_nmro());
        sbi.append("    , 615 ");
        sbi.append("    , sysdate");
        sbi.append("    , '"+sessao.getUsuario() + "' ");
        sbi.append("    , 'PRECO DE VENDA ALTERADO DE: "+ (f.getIte_preco_venda().equals("") ? "NULO":f.getIte_preco_venda()) + " PARA: "+valorNovo + "' ");
        sbi.append("    , "+f.getIte_seqn() + ") ");

        boolean atualiza = false;
        if (valor_item_novo != "") {
          if (valorAntigo != null) {
            if (valorAntigo.doubleValue() != valorNovo.doubleValue()) {
              atualiza = true;
            }
          } else {
            atualiza = true;
          }

          if (atualiza) {
            session.setAttribute("atualizou", true);
            query.execute(sb.toString());
            query.execute(sbi.toString());
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PrecoVendaPedido_rActionForm[]_ge_grid_array = (PrecoVendaPedido_rActionForm[])_ge_grid.get("bl_form_Jw_preco_venda_pedido_lines");
      PrecoVendaPedido_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/PrecoVendaPedidoForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
