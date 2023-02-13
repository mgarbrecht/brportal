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
 * Creation Date 22/08/2013 13:49:04
 * Last Modify Date 23/08/2013 11:06:24
 */

public class AbastecimentoMateriais_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
    Req_sdo_abastecimento_fornec table = new Req_sdo_abastecimento_fornec();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id","=", com.egen.util.text.FormatNumber.toInteger(f.getId())} };
    Vector res_Req_sdo_abastecimento_fornec = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Req_sdo_abastecimento_fornec",res_Req_sdo_abastecimento_fornec);
    if (res_Req_sdo_abastecimento_fornec != null && res_Req_sdo_abastecimento_fornec.size() > 0) {
      Req_sdo_abastecimento_fornec r = (Req_sdo_abastecimento_fornec) res_Req_sdo_abastecimento_fornec.elementAt(0);
      f.setId((r.getId() != null) ? r.getId() + "":"");
      f.setIes_codigo((r.getIes_codigo() != null) ? r.getIes_codigo() + "":"");
      f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
      f.setTai_codigo((r.getTai_codigo() != null) ? r.getTai_codigo() + "":"");
      f.setCod_min_fabr((r.getCod_min_fabr() != null) ? r.getCod_min_fabr() + "":"");
      f.setFen_seq((r.getFen_seq() != null) ? r.getFen_seq() + "":"");
      f.setQuantidade_transito((r.getQuantidade_transito() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_transito(), "##,##0.00") : "");
      f.setQuantidade_produzida((r.getQuantidade_produzida() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_produzida(), "##,##0.00") : "");
      f.setQuantidade_atraso((r.getQuantidade_atraso() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_atraso(), "##,##0.00") : "");
      f.setData_entrega(com.egen.util.text.FormatDate.format(r.getData_entrega(), "dd/MM/yyyy"));
      f.setData_atualizacao(com.egen.util.text.FormatDate.format(r.getData_atualizacao(), "dd/MM/yyyy HH:mm:ss"));
      f.setFornecedor_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
      insert_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT data_entrega ");
    sb.append("   FROM req_sdo_abastecimento_fornec ");
    sb.append("  WHERE ies_codigo = " + f.getIes_codigo());
    sb.append("    AND cor_cdgo = " + f.getCor_cdgo());
    sb.append("    AND for_codigo = " + f.getFornecedor_codigo());
    sb.append("    AND fen_seq = " + f.getFen_seq());
    sb.append("    AND data_entrega = to_date('"+f.getData_entrega() + "','dd/mm/yyyy') ");
    sb.append("    AND ROWNUM = 1 ");

    util.consultas.Query query = new util.consultas.Query();
    String existe = null;
    existe = query.retorna(j, sb.toString());
    if (existe.equalsIgnoreCase("")) {
      String data_atual = query.retorna(j, "SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') FROM dual");
      int seq = Integer.parseInt(query.retorna(j, "SELECT est.req_sdo_abastec_fornec.nextval FROM dual"));
      Req_sdo_abastecimento_fornec table = new Req_sdo_abastecimento_fornec();
      Object[][] name_value = { {"id", seq}, {"ies_codigo",com.egen.util.text.FormatNumber.toLong(f.getIes_codigo())}, {"cor_cdgo",com.egen.util.text.FormatNumber.toInteger(f.getCor_cdgo())}, {"tai_codigo", "0"}, {"cod_min_fabr",com.egen.util.text.FormatNumber.toInteger("0")}, {"fen_seq",com.egen.util.text.FormatNumber.toInteger(f.getFen_seq())}, {"quantidade_transito",com.egen.util.text.FormatNumber.toDouble(f.getQuantidade_transito())}, {"quantidade_produzida",com.egen.util.text.FormatNumber.toDouble(f.getQuantidade_produzida())}, {"quantidade_atraso",com.egen.util.text.FormatNumber.toDouble(f.getQuantidade_atraso())}, {"data_entrega",com.egen.util.text.FormatDate.parseDate(f.getData_entrega(), "dd/MM/yyyy")}, {"sdo_req",com.egen.util.text.FormatNumber.toDouble(f.getSdo_req())}, {"data_atualizacao",com.egen.util.text.FormatDate.parseTimestamp(data_atual, "dd/MM/yyyy HH:mm:ss")}, {"for_codigo",com.egen.util.text.FormatNumber.toLong(f.getFornecedor_codigo())} };
      j.insert(table, name_value);
      f.setId("");
      request.setAttribute("inseriu_ok","s");
      Vector res_Req_sdo_abastecimento_fornec = (Vector) session.getAttribute("res_Req_sdo_abastecimento_fornec");
      if (res_Req_sdo_abastecimento_fornec != null && table != null) {
        res_Req_sdo_abastecimento_fornec.addElement(table);
        session.setAttribute("res_Req_sdo_abastecimento_fornec", res_Req_sdo_abastecimento_fornec);
      }
    } else {
      throw new Exception("Data já existente!");
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }



  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT 1 ");
    sb.append("   FROM req_sdo_abastecimento_fornec ");
    sb.append("  WHERE ies_codigo = " + f.getIes_codigo());
    sb.append("    AND cor_cdgo = " + f.getCor_cdgo());
    sb.append("    AND for_codigo = " + f.getFornecedor_codigo());
    sb.append("    AND fen_seq = " + f.getFen_seq());
    sb.append("    AND data_entrega = to_date('"+f.getData_entrega() + "','dd/mm/yyyy') ");
    sb.append("    AND id <> " + f.getId());
    sb.append("    AND ROWNUM = 1 ");

    util.consultas.Query query = new util.consultas.Query();
    String existe = null;
    existe = query.retorna(j, sb.toString());
    if (existe.equalsIgnoreCase("")) {
      String data_atual = query.retorna(j, "SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') FROM dual");
      Req_sdo_abastecimento_fornec table = new Req_sdo_abastecimento_fornec();
      Vector sets = new Vector(10, 2);
      table.setId(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId()));
      if (f.getId() != null) {
        sets.addElement("id");
      }
      table.setIes_codigo(com.egen.util.text.FormatNumber.parseLongWrapper(f.getIes_codigo()));
      if (f.getIes_codigo() != null) {
        sets.addElement("ies_codigo");
      }
      table.setCor_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCor_cdgo()));
      if (f.getCor_cdgo() != null) {
        sets.addElement("cor_cdgo");
      }
      table.setTai_codigo(f.getTai_codigo());
      if (f.getTai_codigo() != null) {
        sets.addElement("tai_codigo");
      }
      table.setCod_min_fabr(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCod_min_fabr()));
      if (f.getCod_min_fabr() != null) {
        sets.addElement("cod_min_fabr");
      }
      table.setFen_seq(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFen_seq()));
      if (f.getFen_seq() != null) {
        sets.addElement("fen_seq");
      }
      table.setQuantidade_transito(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getQuantidade_transito()));
      if (f.getQuantidade_transito() != null) {
        sets.addElement("quantidade_transito");
      }
      table.setQuantidade_produzida(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getQuantidade_produzida()));
      if (f.getQuantidade_produzida() != null) {
        sets.addElement("quantidade_produzida");
      }
      table.setQuantidade_atraso(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getQuantidade_atraso()));
      if (f.getQuantidade_atraso() != null) {
        sets.addElement("quantidade_atraso");
      }
      table.setData_entrega(com.egen.util.text.FormatDate.parseDate(f.getData_entrega(), "dd/MM/yyyy"));
      if (f.getData_entrega() != null) {
        sets.addElement("data_entrega");
      }
      table.setSdo_req(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getSdo_req()));
      if (f.getSdo_req() != null) {
        sets.addElement("sdo_req");
      }
      table.setData_atualizacao(com.egen.util.text.FormatDate.parseTimestamp(data_atual, "dd/MM/yyyy HH:mm:ss"));
      if (f.getData_atualizacao() != null) {
        sets.addElement("data_atualizacao");
      }
      table.setFor_codigo(com.egen.util.text.FormatNumber.parseLongWrapper(f.getFornecedor_codigo()));
      if (f.getFornecedor_codigo() != null) {
        sets.addElement("for_codigo");
      }
      if (sets != null && sets.size() > 0) {
        String[] set = new String[sets.size()];
        for (int i = 0; i < sets.size(); i++) {
          set[i] = (String) sets.elementAt(i);
        }
        int updated = j.update(table, set);
        request.setAttribute("atualizou_ok","s");
        if (updated == 0) {
          ActionErrors errors = new ActionErrors();
          errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("warn.norowsupdated",": " + updated));
          request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
        } else {
          Vector res_Req_sdo_abastecimento_fornec = (Vector) session.getAttribute("res_Req_sdo_abastecimento_fornec");
          if (res_Req_sdo_abastecimento_fornec != null) {
            res_Req_sdo_abastecimento_fornec.setElementAt(table, 0);
            Req_sdo_abastecimento_fornec r = (Req_sdo_abastecimento_fornec) res_Req_sdo_abastecimento_fornec.elementAt(0);
            f.setId((r.getId() != null) ? r.getId() + "":"");
            f.setIes_codigo((r.getIes_codigo() != null) ? r.getIes_codigo() + "":"");
            f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
            f.setTai_codigo((r.getTai_codigo() != null) ? r.getTai_codigo() + "":"");
            f.setCod_min_fabr((r.getCod_min_fabr() != null) ? r.getCod_min_fabr() + "":"");
            f.setFen_seq((r.getFen_seq() != null) ? r.getFen_seq() + "":"");
            f.setQuantidade_transito((r.getQuantidade_transito() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_transito(), "##,##0.00") : "");
            f.setQuantidade_produzida((r.getQuantidade_produzida() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_produzida(), "##,##0.00") : "");
            f.setQuantidade_atraso((r.getQuantidade_atraso() != null) ? com.egen.util.text.FormatNumber.format(r.getQuantidade_atraso(), "##,##0.00") : "");
            f.setData_entrega(com.egen.util.text.FormatDate.format(r.getData_entrega(), "dd/MM/yyyy"));
            f.setSdo_req((r.getSdo_req() != null) ? com.egen.util.text.FormatNumber.format(r.getSdo_req(), "##,##0.00") : "");
            f.setData_atualizacao(com.egen.util.text.FormatDate.format(r.getData_atualizacao(), "dd/MM/yyyy HH:mm:ss"));
            f.setFornecedor_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
          }
        }
      }
    } else {
      throw new Exception("Data já existente!");
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AbastecimentoMateriais_aActionForm f = (AbastecimentoMateriais_aActionForm) form;
      session.removeAttribute("res_Req_sdo_abastecimento_fornec");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("AbastecimentoMateriais_aActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


}
