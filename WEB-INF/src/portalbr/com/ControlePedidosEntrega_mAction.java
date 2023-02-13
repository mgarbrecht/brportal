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
 * Creation Date 25/05/2011 14:08:30
 * Last Modify Date 20/08/2013 10:39:52
 */

public class ControlePedidosEntrega_mAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControlePedidosEntrega_mActionForm[]_ge_grid_array = (ControlePedidosEntrega_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControlePedidosEntrega_mActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ControlePedidosEntrega_mActionForm[]_ge_grid_array = (ControlePedidosEntrega_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControlePedidosEntrega_mActionForm f = _ge_grid_array[0];
    if (f != null) {
      Controle_clientes_especiais_vw table = new Controle_clientes_especiais_vw();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = (Object[][]) session.getAttribute("where");
      Vector res_Controle_clientes_especiais_vw = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Controle_clientes_especiais_vw",res_Controle_clientes_especiais_vw);
      if (res_Controle_clientes_especiais_vw != null && res_Controle_clientes_especiais_vw.size() > 0) {
        ControlePedidosEntrega_mActionForm[]_ge_grid_array_flex = new ControlePedidosEntrega_mActionForm[res_Controle_clientes_especiais_vw.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Controle_clientes_especiais_vw_lines", res_Controle_clientes_especiais_vw.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ControlePedidosEntrega_mActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Controle_clientes_especiais_vw.size() > _ge_pos) {
            Controle_clientes_especiais_vw r = (Controle_clientes_especiais_vw) res_Controle_clientes_especiais_vw.elementAt(_ge_pos);
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setOc((r.getOc() != null) ? r.getOc() + "":"");
            f.setModelos((r.getModelos() != null) ? r.getModelos() + "":"");
            f.setEtiquetas((r.getEtiquetas() != null) ? r.getEtiquetas() + "":"");
            f.setObse_adicionais((r.getObse_adicionais() != null) ? r.getObse_adicionais() + "":"");
            f.setPrs((r.getPrs() != null) ? r.getPrs() + "":"");
            f.setRemessa((r.getRemessa() != null) ? r.getRemessa() + "":"");
            f.setFilial_prd((r.getFilial_prd() != null) ? r.getFilial_prd() + "":"");
            f.setFil_filial_fat((r.getFil_filial_fat() != null) ? r.getFil_filial_fat() + "":"");
            f.setDt_digit(com.egen.util.text.FormatDate.format(r.getDt_digit(), "dd/MM/yyyy"));
            f.setDt_fatur(com.egen.util.text.FormatDate.format(r.getDt_fatur(), "dd/MM/yyyy"));
            f.setDt_fatur_filial(com.egen.util.text.FormatDate.format(r.getDt_fatur_filial(), "dd/MM/yyyy"));
            f.setMarca((r.getMarca() != null) ? r.getMarca() + "":"");
            f.setCarimbo((r.getCarimbo() != null) ? r.getCarimbo() + "":"");
            f.setRotulos((r.getRotulos() != null) ? r.getRotulos() + "":"");
            f.setPed_amostra((r.getPed_amostra() != null) ? r.getPed_amostra() + "":"");
            f.setDt_envio_amostras(com.egen.util.text.FormatDate.format(r.getDt_envio_amostras(), "dd/MM/yyyy"));
            f.setAgendamento_cdgo((r.getAgendamento_cdgo() != null) ? r.getAgendamento_cdgo() + "":"");
            f.setData_efetiva(com.egen.util.text.FormatDate.format(r.getData_efetiva(), "dd/MM/yyyy"));
            f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
            f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
            f.setPed_stat((r.getPed_stat() != null) ? r.getPed_stat() + "":"");
            f.setBanco(r.getExiste());
            f.setHora((r.getHora() != null) ? r.getHora() + "":"");
            f.setSenha((r.getSenha() != null) ? r.getSenha() + "":"");
            f.setDt_emissao(com.egen.util.text.FormatDate.format(r.getDt_emissao(), "dd/MM/yyyy"));
            f.setFilial((r.getFilial() != null) ? r.getFilial() + "":"");
            f.setNotafiscal((r.getNotafiscal() != null) ? r.getNotafiscal() + "":"");
            f.setVolumes((r.getFilial() != null) ? r.getVolumes() + "":"");

            f.setCliente(r.getCli_cdgo() + " - "+r.getCli_rzao());
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setRep_rzao((r.getRep_rzao() != null) ? r.getRep_rzao() + "":"");
            f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
            f.setValor_pedido(com.egen.util.text.FormatNumber.format(r.getValor_pedido(), "##,##0.00"));
            f.setPed_amostra_brinde((r.getPed_amostra_brinde() == null) ? r.getPed_amostra_brinde() + "":"");
            f.setData_entrega_cliente((r.getData_entrega_cliente() + "" == null) ? r.getData_entrega_cliente() + "" + "":"");


          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Controle_clientes_especiais_vw_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControlePedidosEntrega_mActionForm[]_ge_grid_array = (ControlePedidosEntrega_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControlePedidosEntrega_mActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      //    actionForward = mapping.findForward("same");
      actionForward = new ActionForward("/com/ControlePedidosEntrega_mGrid.do?select_action=", true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ControlePedidosEntrega_mActionForm[]_ge_grid_array = (ControlePedidosEntrega_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControlePedidosEntrega_mActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (true) {
        // ----- Insert ---------------------------------------------
        if (f.getBanco().equals("N") && f.getAlterado().equals("S")) {
          Ped_inf_adicionais table = new Ped_inf_adicionais();
          Object[][] name_value = { {"ped_nmro",com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"dt_fatur_filial",com.egen.util.text.FormatDate.parseDate(f.getDt_fatur_filial(), "dd/MM/yyyy")}, };
          j.insert(table, name_value);
        }
        // ----- Update ---------------------------------------------
        if (f.getBanco().equals("S") && f.getAlterado().equals("S")) {
          Ped_inf_adicionais table = new Ped_inf_adicionais();
          Vector sets = new Vector(10, 2);
          table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPed_nmro()));
          if (f.getPed_nmro() != null) {
            sets.addElement("ped_nmro");
          }

          table.setEmp_empresa("01");
          sets.addElement("emp_empresa");

          table.setDt_fatur_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_fatur_filial(), "dd/MM/yyyy"));
          if (f.getDt_fatur_filial() != null) {
            sets.addElement("dt_fatur_filial");
          }

          if (sets != null && sets.size() > 0) {
            String[] set = new String[sets.size()];
            for (int i = 0; i < sets.size(); i++) {
              set[i] = (String) sets.elementAt(i);
            }
            int updated = j.update(table, set);
          }
        }
        // ----------------------------------------------------------
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
      ControlePedidosEntrega_mActionForm[]_ge_grid_array = (ControlePedidosEntrega_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControlePedidosEntrega_mActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/ControlePedidosEntregaForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
